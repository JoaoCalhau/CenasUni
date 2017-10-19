public class Hannoi {
	
	private static ArrayStack<Integer> t1;
	private static ArrayStack<Integer> t2;
	private static ArrayStack<Integer> t3;
	
	public Hannoi(int n) throws Exceptions{
		t1 = new ArrayStack<Integer>();
		t2 = new ArrayStack<Integer>();
		t3 = new ArrayStack<Integer>();
		while(n>0) {
			t1.push(n);
			n = n -1;
		}
	}
	
	public static void mover_1(ArrayStack<Integer>A,ArrayStack<Integer>B) throws Exceptions{
		if (A.empty()) {
			System.out.println("Esta vazio!");
		}else{
			if (B.empty() || (B.top()!=null && A.top()<B.top())) {
			B.push(A.pop());
			}
		}
	}
		public static void mover(int Npecas, ArrayStack<Integer> stack1, ArrayStack<Integer> stack2, ArrayStack<Integer> stack3) throws Exceptions{
			if(Npecas==1) {
				mover_1(stack1,stack2);
			}
			else{
				mover(Npecas-1,stack1,stack3,stack2);
				mover_1(stack1,stack2);
				mover(Npecas-1,stack3,stack2,stack1);
			}
		}
		
		public static void main(String[] args) throws Exceptions{
			Hannoi jogo = new Hannoi(7);
			System.out.println("Inicio do jogo");
			System.out.println(jogo.t1.toString());
			System.out.println(jogo.t2.toString());
			System.out.println(jogo.t3.toString());
			System.out.println(" ");
			jogo.mover(7, jogo.t1, jogo.t2, jogo.t3);
			System.out.println("Depois de jogar");
			System.out.println(jogo.t1.toString());
			System.out.println(jogo.t2.toString());
			System.out.println(jogo.t3.toString());
		}
}