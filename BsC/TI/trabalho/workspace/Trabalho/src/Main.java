import java.io.*;
import java.util.*;

public class Main {
	
	public static String read(String in) {
		try(BufferedReader br = new BufferedReader(new FileReader(in))) {

			String s = br.readLine();

			return s;

		} catch(IOException e) {
			System.out.println("Wrong file...");
		}
		return null;
	}
	
	/*
	public static void write(String toWrite) {
		try(Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("bits-output.txt"), "UTF-8"))) {
			
			writer.write(toWrite);
			
		}catch(IOException e) {}
	}
	*/
	
	public static void main(String[] args) {
		
		String original = read(args[0]);
		
		List<Integer> compressed = LZWv2.compress(original);
		
		List<String> compressedCoded  = LZWv2.toCode(compressed);
		
		String appended = LZWv2.append(compressedCoded);
		
		System.out.println(appended);
	}
}