public class HeapSort {
	
	int[] arr_un; 
	
	public void fnSortHeap(int array[], int arr_ubound) {
		int arr_un = array;
		int lChild, rChild, parent, root, temp;
		root=(arr_ubound-1)/2;
		
		for (int o=root;o>=0;o--) {
			for (int i=root;i>=0;i--) {
				lChild = (2*i)+1;
				rChild = (2*i+2);
				
				if ((lChild <= arr_ubound) && (rChild <=arr_ubound)) {
					if (array[rChild] >= array[lChild]) {
						parent=rChild;
					}else {
						parent=lChild;
					}
				}else {
					if (rChild > arr_ubound) {
						parent=lChild;
					}else {
						parent=rChild;
					}
				}
				if (array[i] <array[parent]) {
					temp = array[i];
					array[i]=array[parent];
					array[parent]=temp;
				}
			}
		}
		temp=array[0];
		array[0]=array[arr_ubound];
		array[arr_ubound]=temp;
		printNumbers(array);
	}
	
	public void printNumbers(int array[]) {
		String s=
		System.out.println("\nHeap Sort\n-------------------------");
		System.out.println("\nUnsorted Array\n--------------------");
		for (int i=0;i<array.length;i++) {
			System.out.println(" "+array[i]);
		}
	}
}
