import java.io.*;
import java.util.*;

public class Testinho {
	
	public static String read(String in) {
		try(BufferedReader br = new BufferedReader(new FileReader(in))) {

			String s = br.readLine();

			return s;

		} catch(IOException e) {
			System.out.println("Inexistant file...");
		}
		return null;
	}
	
	public static void write(String in, String file) {
		try(PrintWriter pw = new PrintWriter(file)) {
			pw.println(in);
		} catch(IOException e) {
			System.out.println("Inexistant file...");
		}
	}
	
	public static void main(String[] args) {
		/*
		String testinho = "011010010000111110100101";
		
		String s = Hamming.hammingCode(testinho);
		
		String s1 = Hamming.hammingDecode(s);
		
		System.out.println(s1.equals("0110"));
		
		//System.out.println(s);
		//System.out.println(s1);
		*/
		
		
		
		String original = read("input.txt");
		
		List<Integer> li = LZW.compress(original);
		
		List<String> ls = LZW.toCode(li);
		
		String cd = LZW.append(ls);
		
		String h = Hamming.hammingCode(cd);
		
		//String error = canal.inputError(h);
		
		//String hd = Hamming.hammingDecode(error);
		
		String hd = Hamming.hammingDecode(h);
		
		List<String> lss = LZW.unappend(hd);
		
		List<Integer> lii = LZW.decode(lss);
		
		String cdd = LZW.decompress(lii);
		
		System.out.println(cdd.equals(original));
		System.out.println(LZW.errors);
		
		write(cdd, "appended.txt");
		
		
		//String hamming = code.hammingCode(cd);
		
		//write(hamming, "hamming.txt");
		
	}
}
