import java.util.Scanner;

public class aula1_ex3 {

	public static void main(String[] args) {
		
		//User input
		Scanner input = new Scanner(System.in);
		
		System.out.println("Quantos números tem o teu array?");
		int num = input.nextInt();
		
		int array[] = new int[num];
		
		System.out.println("Insira os " + num + " números agora.");
		
		for (int b = 0; b<array.length; b++){
			array[b] = input.nextInt();
		}
		
		//Programa normal
		int a = 100;
		for (int i=0; i<array.length; i++){
			if (array[i]<a && array[i]%2 != 0){
				a = array[i];
				
			}
		}
		System.out.println(a + " é o menor numero");

	}

}
