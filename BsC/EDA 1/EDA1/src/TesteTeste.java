public class TesteTeste {
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws ExceptionEmpty, ExceptionFull {
		
		Hannoi cenas = new Hannoi(7);
		cenas.mover(7, cenas.t1, cenas.t2, cenas.t3);
		System.out.println(cenas.t1.toString());
		System.out.println(cenas.t2.toString());
		System.out.println(cenas.t3.toString());
	}
}
