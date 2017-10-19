public class JogoDoGalo{
	public Jogadores[][] jogoDoGalo;
	public int vencedor;
	Jogadores vazio = new Jogadores(0, " ");

	//[][x]-Coluna [x][]-linha
	public JogoDoGalo(){
		vencedor = 0;
		jogoDoGalo = new Jogadores[3][3];
		for (int linha=0;linha<3;linha++) {
			for (int coluna=0;coluna<3;coluna++) {
				jogoDoGalo[linha][coluna]=vazio;
			}
		}
	}
	//diz quem ganhou o jogo
	public int vencedor(){
		return vencedor;
	}
	
	@Override
	public JogoDoGalo clone() {
		JogoDoGalo clone;
		try {
			clone = (JogoDoGalo) super.clone();
		}catch (CloneNotSupportedException e) {
			throw new Error();
		}
		return clone;
	}
	
	//retorna o codigo hash do objecto
	public int hashcode(){
		String s="";
		for (int i=0;i<3;i++) {
			for (int j=0;j<3;j++) {
				s+=jogoDoGalo[i][j].getJogador();
			}
		}
		return Integer.parseInt(s);
	}

	public boolean acabou(){
		if (diagonais() || linhas() || colunas()) {return true;}
		else {return false;}
	}
	//faz uma jogada na celula indicada se esta vazia, se nao esta vazia retorna false
	boolean joga(int row, int col){
			if (jogoDoGalo[row][col].getJogador()==0) {return true;}
			else {return false;}
	}
	
	void jogar(int row, int col, Jogadores j) {
		jogoDoGalo[row][col]=j;
	}
	//retorna o movimento actual na localiza�cao dada, i.e qual o jogador naquela posi�cao
	int jogador(int row, int col){
		return jogoDoGalo[row][col].getJogador();
	}
	
	public boolean diagonais() {
		if ((jogoDoGalo[0][0].getJogador()!=0 && (jogoDoGalo[0][0].getJogador()==jogoDoGalo[1][1].getJogador() && jogoDoGalo[0][0].getJogador()==jogoDoGalo[2][2].getJogador())) || (jogoDoGalo[0][2].getJogador()!=0 && (jogoDoGalo[0][2].getJogador()==jogoDoGalo[1][1].getJogador() && jogoDoGalo[0][2].getJogador()==jogoDoGalo[2][0].getJogador()))) {
			vencedor = jogoDoGalo[1][1].getJogador();
			return true;
		}else {return false;}
	}
	
	public boolean linhas() {
		if (jogoDoGalo[0][0].getJogador()!=0 && jogoDoGalo[0][0].getJogador()==jogoDoGalo[0][1].getJogador() && jogoDoGalo[0][0].getJogador()==jogoDoGalo[0][2].getJogador()) {
			vencedor = jogoDoGalo[0][0].getJogador();
			return true;
		}else if (jogoDoGalo[1][0].getJogador()!=0 && jogoDoGalo[1][0].getJogador()==jogoDoGalo[1][1].getJogador() && jogoDoGalo[1][0].getJogador()==jogoDoGalo[1][2].getJogador()) {
			vencedor = jogoDoGalo[1][0].getJogador();
			return true;
		}else if (jogoDoGalo[2][0].getJogador()!=0 && jogoDoGalo[2][0].getJogador()==jogoDoGalo[2][1].getJogador() && jogoDoGalo[2][0].getJogador()==jogoDoGalo[2][2].getJogador()) {
			vencedor = jogoDoGalo[2][0].getJogador();
			return true;
		}else {return false;}
	}
	
	public boolean colunas() {
		if (jogoDoGalo[0][0].getJogador()!=0 && jogoDoGalo[0][0].getJogador()==jogoDoGalo[1][0].getJogador() && jogoDoGalo[0][0].getJogador()==jogoDoGalo[2][0].getJogador()) {
			vencedor = jogoDoGalo[0][0].getJogador();
			return true;
		}else if (jogoDoGalo[0][1].getJogador()!=0 && jogoDoGalo[0][1].getJogador()==jogoDoGalo[1][1].getJogador() && jogoDoGalo[0][1].getJogador()==jogoDoGalo[2][1].getJogador()) {
			vencedor = jogoDoGalo[0][1].getJogador();
			return true;
		}else if (jogoDoGalo[0][2].getJogador()!=0 && jogoDoGalo[0][2].getJogador()==jogoDoGalo[1][2].getJogador() && jogoDoGalo[0][2].getJogador()==jogoDoGalo[2][2].getJogador()) {
			vencedor = jogoDoGalo[0][2].getJogador();
			return true;
		}else {return false;}
	}
	
	//retorna reperesenta�cao em String do tabuleiro
	public String toString(){
		return "["+jogoDoGalo[0][0].getJogada()+" , "+jogoDoGalo[0][1].getJogada()+" , "+jogoDoGalo[0][2].getJogada()+"]\n["+jogoDoGalo[1][0].getJogada()+" , "+jogoDoGalo[1][1].getJogada()+" , "+jogoDoGalo[1][2].getJogada()+"]\n["+jogoDoGalo[2][0].getJogada()+" , "+jogoDoGalo[2][1].getJogada()+" , "+jogoDoGalo[2][2].getJogada()+"]";
	}
}