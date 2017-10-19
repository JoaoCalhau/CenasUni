import java.util.Scanner;

public class Somar {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Quantos números quer inserir?");
		int num = input.nextInt();
		int array[] = new int [num];
		
		System.out.println("Insira os " + num + " números do array.");
		
		for (int i = 0; i<array.length; i++){
			array[i] = input.nextInt();
		}
		
		int a = 0;
		for (int b = 0; b<array.length; b++){
			a = a + array[b];
		}
		
		System.out.println(a + "é a soma dos números do array.");

	}

}
