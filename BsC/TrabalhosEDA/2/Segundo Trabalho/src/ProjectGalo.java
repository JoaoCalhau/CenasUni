public class ProjectGalo {
	JogAcaso jogAcaso;
	JogInteli jogInteli;
	static HashTable table;
	int countWins, countDraws, countWinsI;
	Jogadas jg;
	
	public ProjectGalo() {
		jogAcaso = new JogAcaso();
		jogInteli = new JogInteli();
		table = new HashTable(11);
	}
	
	public void play(int numJogos) {
		while (numJogos>=1) {
			numJogos--;
			JogoDoGalo jogo = new JogoDoGalo();
			jogInteli.novoJogo(2);
			jg = new Jogadas();
			int n=1;
			for (int i=4;i>=1;i--) {
				jogAcaso.joga(jogo);
				jogInteli.joga(jogo, n);
				jg.setJogadas(jogo, n);
				n++;
				if (jogo.acabou()) {
					break;
				}
			}
			System.out.println(jogo.toString());
			System.out.println("");
			String key = Builder(jogo.hashcode());
			if (jogo.vencedor()==1) {
				countWins++;
				jg.incrementGames();
				jg.incrementDefeats();
			}else if(jogo.vencedor()==0) {
				countDraws++;
				jg.incrementGames();
			}else if(jogo.vencedor()==2) {
				countWinsI++;
				jg.incrementWins();
				jg.incrementGames();
			}
			int erro=0;
			try {
				Jogadas item = (Jogadas) table.get(key);
				erro=1;
			}catch (Exception e){
			}finally {
				if (erro==1) {
					Jogadas item = (Jogadas) table.get(key);
					table.remove(key);

					table.put(key, item);
				}else {
					table.put(key, jg);
				}
			}
			jogInteli.acabou(jogo);
		}
		relatorioFinal();
	}
	
	public String Builder(int n) {
		StringBuilder sb = new StringBuilder();
		sb.append("");
		sb.append(n);
		String s = sb.toString();
		return s;
	}
	
	public void relatorioFinal() {
		System.out.println("Relatorio final:");
		System.out.println("");
		System.out.println("Número de slots: "+table.capacity());
		System.out.println("Número de entradas: "+table.size());
		System.out.println("Factor de Carga: "+table.loadFactor());
		System.out.println("Número de colisões: "+table.colisoes());
		System.out.println("JogAcaso ganhou "+countWins+" vezes");
		System.out.println("JogInteli ganhou "+countWinsI+" vezes");
		System.out.println("Houveram "+countDraws+" empates!");
	}
	
	public static void main(String[] args) {
		ProjectGalo jogo = new ProjectGalo();
		jogo.play(100);
	}
}
