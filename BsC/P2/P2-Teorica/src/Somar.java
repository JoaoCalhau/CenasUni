import java.util.Scanner;

public class Somar {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Quantos n�meros quer inserir?");
		int num = input.nextInt();
		int array[] = new int [num];
		
		System.out.println("Insira os " + num + " n�meros do array.");
		
		for (int i = 0; i<array.length; i++){
			array[i] = input.nextInt();
		}
		
		int a = 0;
		for (int b = 0; b<array.length; b++){
			a = a + array[b];
		}
		
		System.out.println(a + "� a soma dos n�meros do array.");

	}

}
