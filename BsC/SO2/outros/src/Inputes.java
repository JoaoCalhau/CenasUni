import java.util.Scanner;
import java.io.IOException;

public class Inputes {
	public static void main(String[] args) {
		//This
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		System.out.println(i+1);

		System.out.println("");
		//Or this
		byte[] b = new byte[128];
		try{
			int r = System.in.read(b);
			String s = new String(b, 0, r-2);
			int value = Integer.parseInt(s.substring(0, r-2));
			System.out.println(value++);
		} catch(NumberFormatException n) {
			System.out.println("Hello from the other side...");
		} catch(IOException e) {
			System.out.println("Hello from the other side...");
		}

	}
}