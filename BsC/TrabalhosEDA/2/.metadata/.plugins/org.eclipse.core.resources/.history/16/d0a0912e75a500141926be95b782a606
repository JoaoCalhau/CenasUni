import java.util.Random;

public class JogAcaso{
	Jogadores X;
	
	public JogAcaso() {
		X = new Jogadores(1, "X");
	}
	
  //faz uma jogada aleatorio sobre o tabuleiro t
	public void joga(JogoDoGalo t){
		Random generator = new Random();
		int n1 = generator.nextInt(3);
		int n2 = generator.nextInt(3);
		while (!t.joga(n1, n2) && !t.acabou()) {
			n1 = generator.nextInt(3);
			n2 = generator.nextInt(3);
		}
		t.jogoDoGalo[n1][n2]=X;
	}
}