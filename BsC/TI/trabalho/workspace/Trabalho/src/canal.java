import java.io.*;
import java.util.*;

public class canal {
	
	public static String read(String in) {
		try(BufferedReader br = new BufferedReader(new FileReader(in))) {

			String s = br.readLine();

			return s;

		} catch(IOException e) {
			System.out.println("Inexistant file...");
		}
		return null;
	}
	
	public static String inputError(String in) {
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < in.length(); i++) {
			if(in.charAt(i) == '1') {
				Random rnd = new Random();
				int decidingFactor = rnd.nextInt(11);
				if(decidingFactor == 1)
					sb.append('0');
				else
					sb.append('1');
			} else {
				sb.append('0');
			}
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		
		String coded = read(args[0]);
		
		String codedErrored = inputError(coded);
		
		System.out.println(codedErrored);
	}
}