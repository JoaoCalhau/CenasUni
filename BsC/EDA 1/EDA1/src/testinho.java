//import java.util.Arrays;

public class testinho {
	public static void main(String[] args) {
		
		String s = "{2}";
		/*
		char[] c = s.toCharArray();
		c = Arrays.copyOfRange(c, 1, s.length()-1);
		s = String.valueOf(c);
		*/ 
		
		s = s.replaceAll("\\{", "");
		s = s.replaceAll("\\}", "");
		System.out.println(s);
	}
}
