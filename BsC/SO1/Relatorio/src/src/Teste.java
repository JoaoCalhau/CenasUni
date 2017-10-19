import java.io.FileWriter;
import java.util.Scanner;
import java.util.concurrent.*;

public class Teste extends Thread {
	final Semaphore semaphore = new Semaphore(0);
	final Semaphore mutex = new Semaphore(1);

	final Escalonador esc = new Escalonador();
	
	//Thread scheduler
	Thread scheduler = new Thread() {
		//Metodo run da thread scheduler
		public void run() {
			try {
				//ciclo infinito
				while(true) {
					//fica á espera de sinal da segunda thread (addProcess)
					semaphore.acquire();

					mutex.acquire();

					//Criar novo ficheiro (ou abrir se já existe)
					FileWriter fw = new FileWriter("scheduler.out", true);

					//Processo principal para escalonar
					esc.Escalonar();

					//Fazer append para ficheiro
					fw.write(esc.toString()+"\n");
					//Fechar ficheiro
					fw.close();

					mutex.release();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	};
	
	//Thread addProcess
	Thread addProcess = new Thread() {
		//Metodo run da Thread
		public void run() {
			try {
				//Ciclo infinito
				while(true) {

					mutex.acquire();
					//String para o nome do ficheiro
					String testi; 
					//Scanner para receber o input
					Scanner scan = new Scanner(System.in);

					System.out.println("Insira processo: ");

					//Atribuir o nome do ficheiro a string criada anteriormente
					testi = scan.nextLine(); 
					//Criar um novo processo com o nome do ficheiro recebido e com o nº process do escalonador
					Process P = new Process(testi, esc.process);
					//Se ficheiro existe
					if (P.abriu) {
						//Adiciona um novo processo a lista de PCBs da processTable
						esc.tabela.addPCB(new PCB(P.pid));
						//incrementa o nº de processos
						esc.incrementProcess();

						//adicionar processo criado anteriormente a lista NEW do escalonador
						esc.addNew(P);
					}
					mutex.release();

					//Manda sinal para a primeira thread prosseguir
					semaphore.release();
					Thread.sleep(500);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	};
	
	public static void main(String[] args) {
		final Teste teste = new Teste();
		
		//Iniciar as duas Threads
		teste.scheduler.start();
		teste.addProcess.start();

	}
}