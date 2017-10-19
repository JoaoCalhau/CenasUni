public class BubbleSort {
	
	private int n;
	
	public BubbleSort(int n) {
		this.n=n;
	}
	
	public void Sort(int[] array) {
		int swap;
		for (int c=0; c<(n-1);c++) {
			for (int d=0;d<n-c-1;d++) {
				if (array[d] > array[d+1]) {
					swap = array[d];
					array[d] = array[d+1];
					array[d+1] = swap;
				}
			}
		}
		printNumbers(array);
	}
	
	public void printNumbers(int[] array) {
		String s="{";
		System.out.println("Sorted List of Numbers");
		for (int c=0;c<n;c++) {
			s=s+array[c]+", ";
		}
		System.out.println(s.substring(0, s.length()-2)+"}");
	}
	
	public static void main(String[] args) {
		BubbleSort cenas = new BubbleSort(11);
		int[] array = {3, 24, 43, 13, 12, 20, 8, 16, 4, 30, 18};
		cenas.Sort(array);
	}
}
