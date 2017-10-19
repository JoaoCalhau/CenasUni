import java.io.*;
import java.util.*;

public class Process{
	int pid;
	int inst[];
	int tamanho;
	boolean abriu;
	int paginas;

	public Process(String s, int pid){
		this.pid = pid;
		tamanho = 0;
		abriu = false;


		try (BufferedReader br = new BufferedReader(new FileReader("src/" + s +".txt")))
		{
			abriu = true;

			String sCurrentLine;
			if((sCurrentLine = br.readLine()) != null) {
				tamanho += (sCurrentLine.length()+1)/2;
				//System.out.println(sCurrentLine);
			}

		} catch (IOException e) {
			System.out.println("\nFICHEIRO NÃO ENCOTRADO/INVÁLIDO\n");
		}

		if(abriu){
			try(Scanner scanner = new Scanner(new File("src/" + s +".txt"))){

				inst = new int [tamanho];
				int i = 0;
				while(scanner.hasNextInt()){
					inst[i++] = scanner.nextInt();
				}
			}
			catch(IOException e) {}
		}

	}

	public boolean FileValido(){
		return this.abriu;
	}
	
	public int numPaginas() {
		int k = tamanho/10;
		int result = k;
		if (tamanho%10 > 0)
			result++;

		return result;
	}

	/*
	public static void main(String[] args) {
		Process P1= new Process("Programa1", 1);
		for(int i=0 ; i<P1.tamanho; i++){
			System.out.println(P1.inst[i]);
		}
		System.out.println("FINAL");
	}*/
}