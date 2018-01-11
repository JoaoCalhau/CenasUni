import java.io.*;
import java.util.*;

public class decode {
	
	/*
	 * Funcao igual a funcao no programa canal e decode
	 */
	public static String read(String in) {
		try(BufferedReader br = new BufferedReader(new FileReader(in))) {

			String s = br.readLine();

			return s;

		} catch(IOException e) {
			System.out.println("Inexsistant file...");
		}
		return null;
	}

	/*
	 * Funcao main que faz a parte "decode" que o trabalho pede
	 * Primeiro corrige os erros da palavra proveniente do ficheiro dado como argumento
	 * Segundo separa a string 
	 * Terceiro descodifica-a
	 * Quarto descomprime-a
	 * Por fim, envia a string descodificada para o stdout para ser escrita no ficheiro de saida
	 */
	public static void main(String[] args) {
		
		String original = read(args[0]);
		
		String hammingDecoded = Hamming.hammingDecode(original);
		
		List<String> unappended = LZW.unappend(hammingDecoded);
		
		List<Integer> decoded = LZW.decode(unappended);
		
		String decompressed = LZW.decompress(decoded);
		
		System.out.print(decompressed);
	}
}
