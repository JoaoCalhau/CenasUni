public class Hamming {
	static int errors = 0;

	public static String hammingCode(String in) {
		//Hamming 7,4
		StringBuffer sb = new StringBuffer();

		for(int i = 0; i < in.length(); i+=4) {
			int data1 = Character.getNumericValue(in.charAt(i));
			int data2 = Character.getNumericValue(in.charAt(i+1));
			int data3 = Character.getNumericValue(in.charAt(i+2));
			int data4 = Character.getNumericValue(in.charAt(i+3));

			int check1 = data1 ^ data2 ^ data4;
			int check2 = data1 ^ data3 ^ data4;
			int check3 = data2 ^ data3 ^ data4;

			sb.append(check1);
			sb.append(check2);
			sb.append(data1);
			sb.append(check3);
			sb.append(data2);
			sb.append(data3);
			sb.append(data4);
		}

		return sb.toString();
	}

	public static String hammingDecode(String in) {
		StringBuffer out = new StringBuffer();

		for(int i = 0; i < in.length(); i+=7) {
			int data1 = Character.getNumericValue(in.charAt(i));
			int data2 = Character.getNumericValue(in.charAt(i+1));
			int data3 = Character.getNumericValue(in.charAt(i+2));
			int data4 = Character.getNumericValue(in.charAt(i+3));
			int data5 = Character.getNumericValue(in.charAt(i+4));
			int data6 = Character.getNumericValue(in.charAt(i+5));
			int data7 = Character.getNumericValue(in.charAt(i+6));

			int p1 = data1 ^ data3 ^ data5 ^ data7;
			int p2 = data2 ^ data3 ^ data6 ^ data7;
			int p4 = data4 ^ data5 ^ data6 ^ data7;

			String check = "" + p4 + "" + p2 + "" + p1;

			int bitError = Integer.parseInt(check, 2);

			StringBuffer correct = new StringBuffer();
			correct.append(data1);
			correct.append(data2);
			correct.append(data3);
			correct.append(data4);
			correct.append(data5);
			correct.append(data6);
			correct.append(data7);

			if(bitError != 0) {
				if(correct.charAt(bitError-1) == '0')
					correct.setCharAt(bitError-1, '1');
				else
					correct.setCharAt(bitError-1, '0');

				errors++;
			}

			String original = "" + correct.charAt(2) + "" + correct.charAt(4) + "" + correct.charAt(5) + "" + correct.charAt(6);
			out.append(original);
		}

		return out.toString();
	}
}