import java.io.*;
import java.util.*;

public class code {
	
	public static String read(String in) {
		try(BufferedReader br = new BufferedReader(new FileReader(in))) {

			String s = br.readLine();

			return s;

		} catch(IOException e) {
			System.out.println("Inexistant file...");
		}
		return null;
	}
	
	public static void main(String[] args) {
		
		String original = read(args[0]);
		
		List<Integer> li = LZW.compress(original);
		
		List<String> compressedCoded = LZW.toCode(li);
		
		String appended = LZW.append(compressedCoded);
		
		String hammingCoded = Hamming.hammingCode(appended);
		
		System.out.println(hammingCoded);
	}
}