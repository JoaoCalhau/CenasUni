public class InsertionSort {
	
	static int step=1;
	
	public static void Sort(int array[]) {
		int n=array.length;
		for (int i=1;i<n;i++) {
			int key = array[i];
			int j=i-1;
			while ((j>-1) && (array[j]>key)) {
				array[j+1] = array[j];
				j--;
			}
			array[j+1]=key;
			printNumbers(array);
		}
	}
	
	public static void printNumbers(int[] input) {
		System.out.println("Step "+step);
		System.out.println("-------------------------");
		step++;
		String s="{";
		for (int i=0;i<input.length;i++) {
			s=s+input[i]+", ";
		}
		System.out.println(s.substring(0, s.length()-2)+"}");
		System.out.println("\n");
	}
	
	public static void main(String[] args) {
		int[] input = {3, 24, 43, 13, 12, 20, 8, 16, 4, 30, 18};
		Sort(input);
	}
}
