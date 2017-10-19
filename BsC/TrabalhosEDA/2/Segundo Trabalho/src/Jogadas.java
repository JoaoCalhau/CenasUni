public class Jogadas {
	JogoDoGalo jg1, jg2, jg3, jg4;
	int vezesVisto, wins, games, defeats;
	
	public Jogadas() {
		this.vezesVisto=0;
		this.wins=0;
		this.games=1;
	}
	
	public JogoDoGalo getJogadas(int n) {
		if (n==1) {
			return jg1;
		}else if (n==2) {
			return jg2;
		}else if (n==3) {
			return jg3;
		}else {
			return jg4;
		}
	}
	
	public void setJogadas(JogoDoGalo j, int n) {
		if (n==1) {
			this.jg1=j;
		}else if (n==2) {
			this.jg2=j;
		}else if (n==3) {
			this.jg3=j;
		}else {
			this.jg4=j;
		}
	}
	
	public void incrementWins() {
		this.wins++;
	}
	
	public int getWins() {
		return this.wins;
	}
	
	public void incrementGames() {
		this.games++;
	}
	
	public int getGames() {
		return this.games;
	}
	
	public double winRate() {
		return (double) wins/games;
	}
	
	public void incrementDefeats() {
		this.defeats++;
	}
	
	public int getDefeats() {
		return this.defeats;
	}
}
