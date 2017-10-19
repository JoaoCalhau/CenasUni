import java.util.*;

public class Escalonador {
	Process_Table tabela;
	int process;
	int tempo;
	int paginas;
	boolean lock;
	int locked_pid;

	LinkedList<Process> New, Ready, Blocked, Exit;
	Process Running;

	public Escalonador() {
		this.New = new LinkedList<Process>();
		this.Ready = new LinkedList<Process>();
		this.Blocked = new LinkedList<Process>();
		this.Exit = new LinkedList<Process>();
		this.Running = null;
		this.tabela = new Process_Table();
		this.process = 1;
		this.tempo = -1;
		this.paginas = 10;
		this.lock = false;
		this.locked_pid = 0;
	}

	//Adiciona um processo para 
	public void addNew(Process processo) {
		tabela.lista.get(processo.pid-1).setStage(1);
		New.add(processo);
	}

	public void addReady(Process processo) {
		tabela.lista.get(processo.pid-1).setStage(2);
		Ready.add(processo);
	}

	public boolean addReadyFirst(Process processo) {
		tabela.lista.get(processo.pid-1).setStage(2);
		
		if (processo.numPaginas() > paginas)
			return false;
		else {
			Ready.add(processo);
			paginas -= processo.numPaginas();
			return true;
		}
	}

	public void addBlocked(Process processo) {
		tabela.lista.get(processo.pid-1).setStage(3);
		Blocked.add(processo);
	}

	public void addExit(Process processo) {
		tabela.lista.get(processo.pid-1).setStage(5);
		Exit.add(processo);
		paginas += processo.numPaginas();
	}

	public void addRunning(Process processo) {
		tabela.lista.get(processo.pid-1).setStage(4);
		Running = processo;
	}

	public Process removeNew() {
		return New.poll();
	}

	public Process removeReady() {
		return Ready.poll();
	}

	public Process removeBlocked() {
		return Blocked.poll();
	}

	public Process removeExit() {
		return Exit.poll();
	}

	public Process removeRunning() {
		Process temp = Running;
		Running = null;
		return temp;
	}

	public void incrementTempo() {
		this.tempo++;
	}

	public void incrementProcess() {
		this.process++;
	}

	public String toString() {
		if (tempo < 10)
			return "  " + tempo + "  " + tabela.toString();
		else if (tempo >= 10 && tempo < 100)
			return " " + tempo + "  " + tabela.toString();
		else
			return " " + tempo + " " + tabela.toString();
	}

	public void verReady() {
		int s = Ready.size();
		if (s > 0) {
			for (int i = 0; i < s; i++) {
				Process temp = removeReady();
				int x = temp.pid-1;
				if (temp.inst[tabela.lista.get(x).n_pos] == 1 
						|| temp.inst[tabela.lista.get(x).n_pos] == 3 
						|| temp.inst[tabela.lista.get(x).n_pos] == 4
						|| temp.inst[tabela.lista.get(x).n_pos] == 5
						|| temp.inst[tabela.lista.get(x).n_pos] == 0) {
					addRunning(temp);
					break;
				} else if (temp.inst[tabela.lista.get(x).n_pos] == 2) {
					if (lock) {
						if (locked_pid == temp.pid) {
							addRunning(temp);
							break;
						}
						else {
							addBlocked(temp);
						}
					}
					else {
						addRunning(temp);
						break;
					}
				}
			}
		}
	}

	public void Escalonar() {
		incrementTempo();
		
		if (Running != null) {
			if (tabela.lista.get(Running.pid-1).n_pos >= Running.tamanho || Running.inst[tabela.lista.get(Running.pid-1).n_pos] == 0) {
				addExit(removeRunning());
			} 
			else if (Running.inst[tabela.lista.get(Running.pid-1).n_pos] == 1 || Running.inst[tabela.lista.get(Running.pid-1).n_pos] == 3){
				tabela.lista.get(Running.pid-1).nextInst();
				addReady(removeRunning());
			}
			else if (Running.inst[tabela.lista.get(Running.pid-1).n_pos] == 2) {
				if (Running.inst[tabela.lista.get(Running.pid-1).n_pos+1] != 2) {
					lock = false;
					locked_pid = 0;
					tabela.lista.get(Running.pid-1).nextInst();
					addReady(removeRunning());
				}
				else {
					lock = true;
					locked_pid = Running.pid;
					tabela.lista.get(Running.pid-1).nextInst();
					addReady(removeRunning());
				}
			}
			else if (Running.inst[tabela.lista.get(Running.pid-1).n_pos] == 4) {
				tabela.lista.get(Running.pid-1).gotoBegin();
				addReady(removeRunning());
			}
			else if (Running.inst[tabela.lista.get(Running.pid-1).n_pos] == 5) {
				tabela.lista.get(Running.pid-1).nextInst();
				PCB temp = tabela.lista.get(Running.pid-1);
				Process temp2 = Running;
				temp2.pid = process;
				temp.pid = process;
				incrementProcess();
				addReady(temp2);
				tabela.addPCB(temp);
				addReady(removeRunning());
			}
		}

		if (Running == null) {
			if (!Blocked.isEmpty()) {
				if (!lock) {
					Process temp = removeBlocked();
					addRunning(temp);
				} 
				else if (lock) {
					verReady();
				}
			} 
			else {
				verReady();
			}
		}
		
		if (New.size() != 0 ) {
			while (paginas > 0) {
				if (New.size() == 0)
					break;
				Process temp = removeNew();
				if (temp == null)
					continue;
				boolean sera = addReadyFirst(temp);
				if (!sera)
					addNew(temp);
			}
		} 
	}
}