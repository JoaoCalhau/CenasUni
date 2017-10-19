import java.util.Random;

public class JogInteli{
	
	Jogadores O;
	int jogada;
	HashTable table;
	

	public JogInteli(){
	}
	//prepara-se para um novo jogo, i.e. prepara-se para registar os tabuleiros do jogo que se vai iniciar
	//deve ser chamado quando um novo jogo vai comecar
	//deve registar qual o jogador que JogInteli (X ou O)
	public void novoJogo(int jogador){
		O = new Jogadores(jogador, "O");
		table = ProjectGalo.table;
	}

	//faz uma jogada baseada na experiencia passada, devendo ser escolhido o movimento com maior % de ganhos
	//#ganhou/(#ganhou+#perdeu+#empatou), em caso de empate decida-se aleatoriamnte
	public void joga(JogoDoGalo t, int n){
		Random generator = new Random();
		int n1 = generator.nextInt(3);
		int n2 = generator.nextInt(3);
		while (!t.joga(n1, n2) && !t.acabou()) {
			n1 = generator.nextInt(3);
			n2 = generator.nextInt(3);
		}
		t.jogoDoGalo[n1][n2]=O;
	}
		/*if (table.isEmpty()) {
			Random generator = new Random();
			int n1 = generator.nextInt(3);
			int n2 = generator.nextInt(3);
			while (!t.joga(n1, n2) && !t.acabou()) {
				n1 = generator.nextInt(3);
				n2 = generator.nextInt(3);
			}
			t.jogoDoGalo[n1][n2]=O;
		}else {
			double maior=0.0;
			Jogadas melhor = new Jogadas();
			for (int i=0;i<table.capacity();i++) {
				Jogadas j = (Jogadas) table.table[i].getValue();
				if (j.winRate()>maior) {
					maior=j.winRate();
					melhor=j;
				}
			}
			JogoDoGalo j = melhor.getJogadas(n);
			Jogadores jg = new Jogadores(0, " ");
			if (n==1) {
				for (int i=0;i<3;i++) {
					for (int k=0;k<3;k++) {
						if (j.jogoDoGalo[i][k].getJogador()==2 && t.joga(i, k)) {
							jg = j.jogoDoGalo[i][k];
							t.jogoDoGalo[i][k]=jg;
						}else {
							Random generator = new Random();
							int n1 = generator.nextInt(3);
							int n2 = generator.nextInt(3);
							while (!t.joga(n1, n2) && !t.acabou()) {
								n1 = generator.nextInt(3);
								n2 = generator.nextInt(3);
							}
							t.jogoDoGalo[n1][n2]=O;
						}
					}
				}
			}else if (n==2) {
				JogoDoGalo jgr = melhor.getJogadas(1);
				int a=0;
				int b=0;
				for (int i=0;i<3;i++) {
					for (int k=0;k<3;k++) {
						if (jgr.jogoDoGalo[i][k].getJogador()==2) {
							a=i;
							b=k;
						}
					}
				}
				for (int i=0;i<3;i++) {
					for (int k=0;k<3;k++) {
						if (j.jogoDoGalo[i][k].getJogador()==2 && t.joga(i, k) && i!=a && k!=b) {
							jg = j.jogoDoGalo[i][k];
							t.jogoDoGalo[i][k]=jg;
						}else {
							Random generator = new Random();
							int n1 = generator.nextInt(3);
							int n2 = generator.nextInt(3);
							while (!t.joga(n1, n2) && !t.acabou()) {
								n1 = generator.nextInt(3);
								n2 = generator.nextInt(3);
							}
							t.jogoDoGalo[n1][n2]=O;
						}
					}
				}
			}else if (n==3) {
				JogoDoGalo jgr = melhor.getJogadas(1);
				JogoDoGalo jgrr = melhor.getJogadas(2);
				int a=0;
				int b=0;
				int c=0;
				int d=0;
				for (int i=0;i<3;i++) {
					for (int k=0;k<3;k++) {
						if (jgr.jogoDoGalo[i][k].getJogador()==2) {
							a=i;
							b=k;
						}
					}
				}
				for (int i=0;i<3;i++) {
					for (int k=0;k<3;k++) {
						if (jgrr.jogoDoGalo[i][k].getJogador()==2 && t.joga(i, k) && i!=a && k!=b) {
							c=i;
							d=k;
						}
					}
				}
				for (int i=0;i<3;i++) {
					for (int k=0;k<3;k++) {
						if (j.jogoDoGalo[i][k].getJogador()==2 && t.joga(i, k) && i!=a && k!=b && i!=c && k!=d) {
							jg = j.jogoDoGalo[i][k];
							t.jogoDoGalo[i][k]=jg;
						}else {
							Random generator = new Random();
							int n1 = generator.nextInt(3);
							int n2 = generator.nextInt(3);
							while (!t.joga(n1, n2) && !t.acabou()) {
								n1 = generator.nextInt(3);
								n2 = generator.nextInt(3);
							}
							t.jogoDoGalo[n1][n2]=O;
						}
					}
				}
			}else {
				JogoDoGalo jgr = melhor.getJogadas(1);
				JogoDoGalo jgrr = melhor.getJogadas(2);
				JogoDoGalo jgrrr = melhor.getJogadas(3);
				int a=0;
				int b=0;
				int c=0;
				int d=0;
				int e=0;
				int f=0;
				for (int i=0;i<3;i++) {
					for (int k=0;k<3;k++) {
						if (jgr.jogoDoGalo[i][k].getJogador()==2) {
							a=i;
							b=k;
						}
					}
				}
				for (int i=0;i<3;i++) {
					for (int k=0;k<3;k++) {
						if (jgrr.jogoDoGalo[i][k].getJogador()==2 && t.joga(i, k) && i!=a && k!=b) {
							c=i;
							d=k;
						}
					}
				}
				for (int i=0;i<3;i++) {
					for (int k=0;k<3;k++) {
						if (jgrrr.jogoDoGalo[i][k].getJogador()==2 && t.joga(i, k) && i!=a && k!=b && i!=c && k!=d) {
							e=i;
							f=k;
						}
					}
				}
				for (int i=0;i<3;i++) {
					for (int k=0;k<3;k++) {
						if (j.jogoDoGalo[i][k].getJogador()==2 && t.joga(i, k) && i!=a && k!=b && i!=c && k!=d && i!=e && k!=f) {
							jg = j.jogoDoGalo[i][k];
							t.jogoDoGalo[i][k]=jg;
						}else {
							Random generator = new Random();
							int n1 = generator.nextInt(3);
							int n2 = generator.nextInt(3);
							while (!t.joga(n1, n2) && !t.acabou()) {
								n1 = generator.nextInt(3);
								n2 = generator.nextInt(3);
							}
							t.jogoDoGalo[n1][n2]=O;
						}
					}
				}
			}
		}
	}*/
	//dado que terminal uma configuracao em que o jogo acabou as configuracoes que constituem todas as
	//Jogadores do jogo devem ser registadas como respondentes a voitoria, empate ou derrota
	public void acabou(JogoDoGalo terminal){
	}

	// numero de vezes que a configuracao t foi vista
	public int numeroDeVezesVisto(JogoDoGalo t){
		return 0;
	}
	// retorna todas as configuracoes que foram Jogadores apos a configuracao t
	public JogoDoGalo[] sucessores(JogoDoGalo t){
		return new JogoDoGalo[4];
	}

}