import java.io.*;
import java.util.*;

public class Process{
	int pid; // nº do processo
	int inst[]; // array de instruçoes do processo
	int tamanho; //quantidade de instruçoes
	boolean abriu; // boleano que diz se ficheiro existe ou nao
	int paginas; // numero de paginas necessarias para execuçao do processo



	//criaçao do Processo com uma string que e o nome do ficheiro
	//e um pid que o numero do processo, sendo cada processo : pid = pid do processo anterior + 1
	public Process(String s, int pid){
		this.pid = pid;
		tamanho = 0;
		abriu = false;

		//tenta-se abrir ficheiro com instruçoes
		try (BufferedReader br = new BufferedReader(new FileReader(s +".txt")))
		{
			//se conseguiu abrir, ficheiro e valido 
			abriu = true;

			//le-se tudo do ficheiro para saber quantidade de instruçoes
			String sCurrentLine;
			if((sCurrentLine = br.readLine()) != null) {
				tamanho += (sCurrentLine.length()+1)/2;
				
			}

		//caso nome de ficheiro nao seja valido
		} catch (IOException e) {
			System.out.println("\nFICHEIRO NÃO ENCONTRADO/INVÁLIDO\n");
		}

		//se ficheiro valido, volta a abrir
		if(abriu){
			try(Scanner scanner = new Scanner(new File(s +".txt"))){

				//e criado array conforme a quantidade das instruçoes
				//e e lido do ficheiro as instruçoes para o dito array
				inst = new int [tamanho];
				int i = 0;
				while(scanner.hasNextInt()){
					inst[i++] = scanner.nextInt();
				}
			}
			catch(IOException e) {}
		}

	}


	//calculo do numero de páginas necessarias para o processo	
	public int numPaginas() {
		int k = tamanho/10;
		int result = k;
		if (tamanho%10 > 0)
			result++;

		return result;
	}
}