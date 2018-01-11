import java.util.*;

public class LZW {
	static int errors = 0;


	/*
	 * A funcao compress, como diz o nome, comprime uma string, neste caso a string word
	 * Comprime essa string usando o algoritmo LZW dado nas aulas
	 */
	public static List<Integer> compress(String word) {
		
		int size = 5;
		Map<String, Integer> d = new HashMap<String, Integer>();

		d.put("A", 1);
		d.put("C", 2);
		d.put("G", 3);
		d.put("T", 4);

		String s1 = "";
		List<Integer> lista = new ArrayList<Integer>();

		for (char c : word.toCharArray()) {
			String toAdd = s1 + c;

			if (d.containsKey(toAdd))
				s1 = toAdd;
			else {
				lista.add(d.get(s1));
				d.put(toAdd, size++);
				s1 = "" + c;
			}
		}

		if (!s1.equals(""))
			lista.add(d.get(s1));

		return lista;
	}

	/*
	 * A funcao decompress, como diz o nome, descomprime uma lista, neste caso a lista li
	 * Descomprime essa lista usando o algoritmo LZW dado nas aulas
	 */
	public static String decompress(List<Integer> li) {
		
		int size = 5;
		Map<Integer, String> d = new HashMap<Integer, String>();

		d.put(1, "A");
		d.put(2, "C");
		d.put(3, "G");
		d.put(4, "T");

		
		int atual = li.get(0);
		int prox;
		String output = d.get(atual);

		for(int i = 0; i < li.size()-1; i++) {
			prox = li.get(i+1);

				if(size == prox) {
					d.put(size++, d.get(atual) + d.get(atual).substring(0, 1));
					output += d.get(prox);
					atual = prox;
				} else if(d.containsKey(prox)){
					d.put(size++, d.get(atual) + d.get(prox).substring(0, 1));
					output += d.get(prox);
					atual = prox;
				} else {
					errors++;
					continue;
				}
		}

		return output;
	}

	/*
	 * A funcao toCode, transforma a lista dada como argumento (li) numa outra lista,
	 * mas desta vez uma lista de Strings (strings estas que sao a codificacao do inteiro)
	 */
	public static List<String> toCode(List<Integer> li) {

		List<String> lista = new ArrayList<String>();

		for(int i = 0; i < li.size(); i++) {
			StringBuffer sb = new StringBuffer();
			int code = li.get(i);

			if(i > 2047)
				sb.append(String.format("%12s", Integer.toBinaryString(code)).replace(' ', '0'));
			else if(i > 1023)
				sb.append(String.format("%11s", Integer.toBinaryString(code)).replace(' ', '0'));
			else if(i > 511)
				sb.append(String.format("%10s", Integer.toBinaryString(code)).replace(' ', '0'));
			else if(i > 255)
				sb.append(String.format("%9s", Integer.toBinaryString(code)).replace(' ', '0'));
			else if(i > 127)
				sb.append(String.format("%8s", Integer.toBinaryString(code)).replace(' ', '0'));
			else if(i > 63)
				sb.append(String.format("%7s", Integer.toBinaryString(code)).replace(' ', '0'));
			else if(i > 31)
				sb.append(String.format("%6s", Integer.toBinaryString(code)).replace(' ', '0'));
			else
				sb.append(String.format("%5s", Integer.toBinaryString(code)).replace(' ', '0'));


			lista.add(sb.toString());
		}

		return lista;
	}

	/*
	 * A funcao decode, faz o contrario da funcao toCode, dada a lista como argumento (ls)
	 * transformando a lista ls de volta a lista de outputs de LZW
	 */
	public static List<Integer> decode(List<String> ls) {
		List<Integer> lista = new ArrayList<Integer>();

		for(int i = 0; i < ls.size(); i++)
			lista.add(Integer.parseInt(ls.get(i), 2));

		return lista;
	}

	/*
	 * A funcao append, faz uma concatenacao de todas a posicoes da lista de entrada
	 * e devolve essa concatenacao como uma string. String esta que sera passada
	 * mais tarde como argumento para o Hamming
	 */
	public static String append(List<String> ls) {
		StringBuffer sb = new StringBuffer();

		for(int i = 0; i < ls.size(); i++)
			sb.append(ls.get(i));

		return sb.toString();
	}

	/*
	 * A funcao unappend, faz o contrario da append, ou seja, pega numa string e separa-a
	 */
	public static List<String> unappend(String s) {
		List<String> lista = new ArrayList<String>();
		int i = 0;
		int change = 0;

		while(i < s.length()) {

			if(lista.size() == 32)
				change = 32;
			else if(lista.size() == 64)
				change = 64;
			else if(lista.size() == 128)
				change = 128;
			else if(lista.size() == 256)
				change = 256;
			else if(lista.size() == 512)
				change = 512;
			else if(lista.size() == 1024)
				change = 1024;
			else if(lista.size() == 2048)
				change = 2048;

			if(change == 2048) {
				lista.add(s.substring(i, i+12));
				i+=12;
			} else if(change == 1024) {
				lista.add(s.substring(i, i+11));
				i+=11;
			} else if(change == 512) {
				lista.add(s.substring(i, i+10));
				i+=10;
			} else if(change == 256) {
				lista.add(s.substring(i, i+9));
				i+=9;
			} else if(change == 128) {
				lista.add(s.substring(i, i+8));
				i+=8;
			} else if(change == 64) {
				lista.add(s.substring(i, i+7));
				i+=7;
			} else if(change == 32) {
				lista.add(s.substring(i, i+6));
				i+=6;
			} else {
				lista.add(s.substring(i, i+5));
				i+=5;
			}
		}

		return lista;
	}
}