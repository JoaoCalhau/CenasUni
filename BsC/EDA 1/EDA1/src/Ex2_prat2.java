import java.io.*;

public class Ex2_prat2 {
	public static void main(String[] args) throws ExceptionFull, ExceptionEmpty, IOException {
		ArrayStack<Character> stack = new ArrayStack<Character>();
		System.out.println("Digite a expressão: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine().trim();
		String auxiliar = "Yep!";
		for (int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			if (c == 'a' || c == 'A') {
				stack.push(c);
				if (c == 'b' || c == 'B')
					if (stack.empty()) {
						auxiliar = "Nope!";
						break;
					}else{
						stack.pop();
					}
			}
		}
		if (stack.size() != 0) {
			auxiliar = "Nope!";
		}
		System.out.println(auxiliar);
	}
}
