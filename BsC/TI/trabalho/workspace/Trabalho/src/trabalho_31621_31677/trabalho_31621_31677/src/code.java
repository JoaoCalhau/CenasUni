import java.io.*;
import java.util.*;

public class code {
	
	/*
	 * A funcao read recebe como entrada uma string, in, e utiliza-a como ficheiro de entrada
	 * para correr o resto do programa
	 */
	public static String read(String in) {
		try(BufferedReader br = new BufferedReader(new FileReader(in))) {

			String s = br.readLine();

			return s;

		} catch(IOException e) {
			System.out.println("Inexistant file...");
		}
		return null;
	}
	
	/*
	 * Funcao main que faz a parte "code" que o trabalho pede
	 * Primeiro comprime a palavra do ficheiro dado como argumento
	 * Segundo codifica-a
	 * Terceiro concatena-a
	 * Quarto aplica o algoritmo de Hamming
	 * Por fim, envia-a para o stdout para ser escrito no ficheiro de saida
	 */
	public static void main(String[] args) {
		
		String original = read(args[0]);
		
		List<Integer> li = LZW.compress(original);
		
		List<String> compressedCoded = LZW.toCode(li);
		
		String appended = LZW.append(compressedCoded);
		
		String hammingCoded = Hamming.hammingCode(appended);
		
		System.out.print(hammingCoded);
	}
}
