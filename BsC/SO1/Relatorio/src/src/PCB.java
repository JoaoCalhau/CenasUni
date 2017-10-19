public class PCB{
		int pid; // nº do process
		int n_pos; //posiçao do array de instruçoes do processo, da instruçao a ser realizada

		int stage; // estagio onde processo se encontra : new, ready, run, block, exit 
				  // utilizado nos prints


		//criaçao de um PCB dado um pid de um processo 
		public PCB(int pid){
			this.pid = pid;
			this.n_pos = 0;
			this.stage = 1;
		}
		
		//operaçao go to begin, faz com que o processo volte
		//a primeira instruçao da lista de instruçoes
		public void gotoBegin() {
			this.n_pos = 0;
		}
		
		//vai para a proxima instruçao do processo
		//da lista de instruçoes do processo
		public void nextInst() {
			this.n_pos++;
		}
		
		//altera a stage dum processo
		//utilizado quando se move um processo de um estado para outro
		public void setStage(int s) {
			this.stage = s;
		}
		

		//toString para registar no ficheiro scheduler.out
		//o estado atual dos processos
		public String toString() {
			if (this.stage == 1)
				return " new ";
			else if (this.stage == 2)
				return "ready";
			else if (this.stage == 3)
				return "block";
			else if (this.stage == 4)
				return " run ";
			else
				return "exit ";
		}
	}