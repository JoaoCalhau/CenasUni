public class Hannoi {
	public ArrayStack<Integer> t1, t2, t3;
	
	public Hannoi(int n) throws ExceptionFull {
		t1 = new ArrayStack<Integer>();
		t2 = new ArrayStack<Integer>();
		t3 = new ArrayStack<Integer>();
		while(n>0) {
			t1.push(n);
			n--;
		}
	}

	public static void mover_1(ArrayStack<Integer> A, ArrayStack<Integer> B) throws ExceptionFull, ExceptionEmpty {
		if (A.empty()) System.out.println("A is empty, you can't do this!");
		if (B.empty() || (B.top()!=null && B.top()>A.top())) B.push(A.pop());
	}
			
	
	public static void mover(int Ndiscos, ArrayStack<Integer> s1, ArrayStack<Integer> s2, ArrayStack<Integer> s3) throws ExceptionFull, ExceptionEmpty {
		if(Ndiscos==1) mover_1(s1,s2);
		else{
			mover(Ndiscos-1,s1,s3,s2);
			mover_1(s1,s2);
			mover(Ndiscos-1,s3,s2,s1);
		}
	}
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws ExceptionFull, ExceptionEmpty{
		Hannoi hanoi = new Hannoi(7);
		System.out.println("Before playing");
		System.out.println(hanoi.t1.toString());
		System.out.println(hanoi.t2.toString());
		System.out.println(hanoi.t3.toString());
		System.out.println("");
		hanoi.mover(7, hanoi.t1, hanoi.t2, hanoi.t3);
		System.out.println("After playing:");
		System.out.println(hanoi.t1.toString());
		System.out.println(hanoi.t2.toString());
		System.out.println(hanoi.t3.toString());
		System.out.println("");
	}
}

//l31621 - João Calhau
//l31643 - Ricardo Benedito