public class PCB{
		int pid;
		int time;
		int n_pos;
		int stage;

		public PCB(int pid, int time){
			this.pid = pid;
			this.time = time;
			this.n_pos = 0;
			this.stage = 1;
		}
		
		public void gotoBegin() {
			this.n_pos = 0;
		}
		
		public void nextInst() {
			this.n_pos++;
		}
		
		public void setStage(int s) {
			this.stage = s;
		}
		
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