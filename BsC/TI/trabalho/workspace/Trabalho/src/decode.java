import java.io.*;
import java.util.*;

public class decode {
	
	public static String read(String in) {
		try(BufferedReader br = new BufferedReader(new FileReader(in))) {

			String s = br.readLine();

			return s;

		} catch(IOException e) {
			System.out.println("Inexsistant file...");
		}
		return null;
	}
	
	public static void main(String[] args) {
		
		String original = read(args[0]);
		
		String hammingDecoded = Hamming.hammingDecode(original);
		
		List<String> unappended = LZW.unappend(hammingDecoded);
		
		List<Integer> decoded = LZW.decode(unappended);
		
		String decompressed = LZW.decompress(decoded);
		
		System.out.println(decompressed);
	}
}
