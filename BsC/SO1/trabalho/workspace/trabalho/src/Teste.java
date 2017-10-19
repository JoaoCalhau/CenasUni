import java.io.FileWriter;
import java.util.Scanner;
import java.util.concurrent.*;

public class Teste extends Thread {
	final Semaphore semaphore = new Semaphore(0);
	final Semaphore mutex = new Semaphore(1);

	final Escalonador cenas = new Escalonador();
	
	
	Thread scheduler = new Thread() {
		public void run() {
			try {
				while(true) {
					semaphore.acquire();

					mutex.acquire();

					FileWriter fw = new FileWriter("scheduler.out", true);

					cenas.Escalonar();

					fw.write(cenas.toString()+"\n");
					fw.close();

					mutex.release();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	};
	

	Thread addProcess = new Thread() {
		public void run() {
			try {
				while(true) {

					mutex.acquire();
					String testi;
					Scanner scan = new Scanner(System.in);

					System.out.println("Insira processo: ");


					testi = scan.nextLine(); 
					Process P = new Process(testi, cenas.process);
					if (P.abriu) {
						
						cenas.tabela.addPCB(new PCB(P.pid, cenas.tempo));
						cenas.incrementProcess();

						cenas.addNew(P);
					}
					mutex.release();

					semaphore.release();
					Thread.sleep(500);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	};
	
	public static void main(String[] args) {
		final Teste cenas = new Teste();
		
		cenas.scheduler.start();
		cenas.addProcess.start();

	}
}