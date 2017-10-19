import java.util.*;
import java.io.*;


public class LZWv2 {
	 static String A = "00";
	 static String C = "01";
	 static String G = "10";
	 static String T = "11";
	 
	// Testes de compressao (divisao em blocos)
	 
	// List<Map<String, Integer>> ms;
	// List<List<Integer>> ls;
	// List<List<String>> codeds;
	// List<String> words;
	// int times;
	 
	public static List<Integer> compress(String word) {
		int size = 5;
		Map<String, Integer> d = new HashMap<String, Integer>();
		
		d.put("A", 1);
		d.put("C", 2);
		d.put("G", 3);
		d.put("T", 4);
		
		//d.put("0", 1);
		//d.put("1", 2);

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

	public static String decompress(List<Integer> l) {
		/*
		Map<Integer, String> inversed = new HashMap<Integer, String>();

		for(Map.Entry<String, Integer> entry : lm.getM().entrySet())
			inversed.put(entry.getValue(), entry.getKey());
		
		StringBuffer sb = new StringBuffer();


		for(int i = 0; i < lm.getL().size(); i++)
			sb.append(inversed.get(lm.getL().get(i)));

		return sb.toString();
		*/
		
		int size = 5;
		Map<Integer, String> d = new HashMap<Integer, String>();
		
		d.put(1, "A");
		d.put(2, "C");
		d.put(3, "G");
		d.put(4, "T");
		
		int atual = l.get(0);
		int prox;
		String output = d.get(atual);
		
		for(int i = 0; i < l.size()-1; i++) {
			prox = l.get(i+1);

			if(size == prox) {
				d.put(size++, d.get(atual) + d.get(atual).substring(0, 1));
				output += d.get(prox);
				atual = prox;
			} else {
				d.put(size++, d.get(atual) + d.get(prox).substring(0, 1));
				output += d.get(prox);
				atual = prox;
			}
		}
		
		return output;
		
	}

	public static List<String> toCode(List<Integer> l) {

		List<String> lista = new ArrayList<String>();

		for(int i = 0; i < l.size(); i++) {
			StringBuffer sb = new StringBuffer();
			int code = l.get(i);
			String cenas = Integer.toBinaryString(code);

			if(cenas.length() == 1)
				sb.append("00000000000" + cenas);
			else if(cenas.length() == 2)
				sb.append("0000000000" + cenas);
			else if(cenas.length() == 3)
				sb.append("000000000" + cenas);
			else if(cenas.length() == 4)
				sb.append("00000000" + cenas);
			else if(cenas.length() == 5)
				sb.append("0000000" + cenas);
			else if(cenas.length() == 6)
				sb.append("000000" + cenas);
			else if(cenas.length() == 7)
				sb.append("00000" + cenas);
			else if(cenas.length() == 8)
				sb.append("0000" + cenas);
			else if(cenas.length() == 9)
				sb.append("000" + cenas);
			else if(cenas.length() == 10)
				sb.append("00" + cenas);
			else if(cenas.length() == 11)
				sb.append("0" + cenas);
			else
				sb.append(cenas);

			lista.add(sb.toString());
		}

		return lista;
	}
	
	public static List<Integer> decode(List<String> coded) {
		List<Integer> lista = new ArrayList<Integer>();
		
		for(int i = 0; i < coded.size(); i++)
			lista.add(Integer.parseInt(coded.get(i), 2));
		
		return lista;
	}
	
	public static String append(List<String> toCode) {
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < toCode.size(); i++)
			sb.append(toCode.get(i));
		
		return sb.toString();
	}
	
	public static List<String> unAppend(String coded) {
		List<String> lista = new ArrayList<String>();
		
		for(int i = 0; i < coded.length(); i+=12)
			lista.add(coded.substring(i, i+12));
		
		return lista;
	}

	public static String read() {

		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		in.close();

		try(BufferedReader br = new BufferedReader(new FileReader(input + ".txt"))) {

			String s = br.readLine();

			return s;

		} catch(IOException e) {
			System.out.println("Wrong file...");
		}
		return null;
	}
	
	/* Testes de compressao (divisao em blocos)
	 * 
	public  void divide() {
		words = new ArrayList<String>();
		int begin = 0;
		int blockSize = word.length()/times;
		int end = blockSize;
		
		for(int i = 0; i < times; i++) {
			words.add(word.substring(begin, end));
			begin = end;
			end += blockSize;
		}
	}
	
	public  void coding() {
		char[] c = word.toCharArray();
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < c.length; i++) {
			if(c[i] == 'A')
				sb.append(A);
			else if(c[i] == 'C')
				sb.append(C);
			else if(c[i] == 'G')
				sb.append(G);
			else
				sb.append(T);
		}
		
		code = sb.toString();
	}
	*/
	
	public static void main(String[] args) {


		/* Testinho dos compresses simples

		String coded = code(word);
		System.out.println(coded + "\n");

		List<Integer> l = compress(coded);
		System.out.println(l.toString() + "\n");

		String s = decompress(l);
		System.out.println(s + "\n");

		String decoded = decode(s);

		 */
		
		/*Testinho de compressao em blocos

		times = 256;
		
		read();
		divide();
		
		ls = new ArrayList<List<Integer>>();
		ms = new ArrayList<Map<String, Integer>>();
		for(int i = 0; i < words.size(); i++) {
			compress(words.get(i));
			ls.add(l);
			ms.add(m);
		}
		
		System.out.println("size ls: " + ls.size() + "\n");
		int total = 0;
		for(int i = 0; i < times; i++) {
			int size = ls.get(i).size();
			System.out.println("size l's: " + size);
			System.out.println("size max: " + Collections.max(ls.get(i)) + "\n");
			total += size;
		}
		System.out.println("total : " + total + "\n");
		*/
		
		
		/*Testinho de comparašao de palavras

		code();
		System.out.println(coded.toString() + "\n");
		
		System.out.println(l.size() + "\n");
		System.out.println(coded.size() + "\n");

		if (s.equals(word))
			System.out.println(true);
		else
			System.out.println(false);
		*/
		
		/*Testinho final
		
		LZWv2 cenas = new LZWv2();
		
		String original = cenas.read();
		
		List<Integer> l = cenas.compress(original);
		System.out.println(l.toString() + "\n");
		
		String decompressed = cenas.decompress(l);
		System.out.println(original.equals(decompressed) + "\n");
		
		List<String> compressedCoded  = cenas.toCode(l);
		
		String appended = cenas.append(compressedCoded);
		
		List<String> unAppended = cenas.unAppend(appended);
		System.out.println("Binary compression size :" + appended.length() + "\n");
		List<Integer> backAgain = cenas.decode(unAppended);
		String backToBack = cenas.decompress(backAgain);
		System.out.println(backToBack.equals(original) + "\n");
		*/
	}
}
