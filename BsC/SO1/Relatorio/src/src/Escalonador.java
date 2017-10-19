import java.util.*;

public class Escalonador {
	Process_Table tabela; //tabela de PCBS
	int process; //quantidade de processos que ja passaram pelo escalonador
	int tempo; // tempo atual
	int paginas; // numero de paginas disponiveis
	boolean lock; //boleano para ver o disco está em lock ou não
	int locked_pid; //nº do processo que bloqueou o disco

	//listas de estados com processos
	LinkedList<Process> New, Ready, Blocked, Exit;
	//processo unico em RUN
	Process Running;


	//criação do escalonador
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


	//adicionar processo ao estado NEW
	//altera-se stage do processo no pcb
	public void addNew(Process processo) {
		tabela.lista.get(processo.pid-1).setStage(1);
		New.add(processo);
	}

	//adicionar processo ao estado READY
	//altera-se stage do processo no PCB
	//metodo utilizado quando o processo ja tenha entrado no escalonador anteriormente
	public void addReady(Process processo) {
		tabela.lista.get(processo.pid-1).setStage(2);
		Ready.add(processo);
	}

	//adicionar processo ao estado READY
	//altera-se stage do processo no PCB
	//metodo utilizado quando o processo entra pela primeira vez no escalonador
	//so e inserido caso o número de paginas disponiveis seja suficiente
	public boolean addReadyFirst(Process processo) {
		
		if (processo.numPaginas() > paginas)
			return false;
		else {
			addReady(processo);
			paginas -= processo.numPaginas();
			return true;
		}
	}

	//adicionar processo ao estado BLOCKED
	//altera-se stage do processo no PCB
	public void addBlocked(Process processo) {
		tabela.lista.get(processo.pid-1).setStage(3);
		Blocked.add(processo);
	}

	//adicionar processo ao estado EXIT
	//altera-se stage do processo no PCB
	public void addExit(Process processo) {
		tabela.lista.get(processo.pid-1).setStage(5);
		Exit.add(processo);
		paginas += processo.numPaginas();
	}

	//adicionar processo ao estado RUN
	//altera-se stage do processo no PCB
	public void addRunning(Process processo) {
		tabela.lista.get(processo.pid-1).setStage(4);
		Running = processo;
	}

	//remover processo do estado NEW
	public Process removeNew() {
		return New.poll();
	}

	//remover processo do estado READY
	public Process removeReady() {
		return Ready.poll();
	}

	//remover processo do estado BLOCKED
	public Process removeBlocked() {
		return Blocked.poll();
	}

	//remover processo do estado EXIT
	public Process removeExit() {
		return Exit.poll();
	}

	//remover processo do estado RUN
	public Process removeRunning() {
		Process temp = Running;
		Running = null;
		return temp;
	}

	//aumentar tempo do escalonador+1
	public void incrementTempo() {
		this.tempo++;
	}

	//aumentar a quantidade de processos 
	public void incrementProcess() {
		this.process++;
	}


	//toString para identação no ficheiro scheduler.out
	public String toString() {
		if (tempo < 10)
			return "  " + tempo + "  " + tabela.toString();
		else if (tempo >= 10 && tempo < 100)
			return " " + tempo + "  " + tabela.toString();
		else
			return " " + tempo + " " + tabela.toString();
	}


	//metodo que verifica os processos do estado ready
	public void verReady() {
		int s = Ready.size();
		if (s > 0) {

			//percorre todos os processos em ready
			for (int i = 0; i < s; i++) {
				Process temp = removeReady();
				int x = temp.pid-1;

				//caso a instruçao seja diferente de acesso ao disco
				//processo adiciona-se ao estado RUN
				if (temp.inst[tabela.lista.get(x).n_pos] == 1 
						|| temp.inst[tabela.lista.get(x).n_pos] == 3 
						|| temp.inst[tabela.lista.get(x).n_pos] == 4
						|| temp.inst[tabela.lista.get(x).n_pos] == 5
						|| temp.inst[tabela.lista.get(x).n_pos] == 0) {
					addRunning(temp);
					break;

				//CASO CONTRARIO = acesso ao disco
				} else if (temp.inst[tabela.lista.get(x).n_pos] == 2) {

					//se tiver bloqueado o disco
					if (lock) {

						//se for por este processo
						//o processo e adicionado ao estado RUN
						if (locked_pid == temp.pid) {
							addRunning(temp);
							break;
						}

						//caso contrario o disco esta bloqueado por outro processo
						//o processo a adicionado ao estado BLOCKED
						else {
							addBlocked(temp);
						}
					}

					//se o disco nao tiver bloqueado
					//o processo e adicionado ao estado RUN
					else {
						addRunning(temp);
						break;
					}
				}
			}
		}
	}

	//Metodo Principal que faz escalonamento
	public void Escalonar() {
		//aumenta-se o tempo por cada ciclo de escalonamento
		incrementTempo();
		
		//se o estado running tiver algum processo la
		if (Running != null) {

			//se a posiçao atual exceder quantidade de instruções OU
			//se a instruçao atual for 0 = exit, o processo e adicionado ao estado EXIT
			if (tabela.lista.get(Running.pid-1).n_pos >= Running.tamanho || Running.inst[tabela.lista.get(Running.pid-1).n_pos] == 0) {
				addExit(removeRunning());
			}

			// se a instrução atual for 1 = calculo no CPU ou  3 = NOP,
			//processo e adicionado ao estado READY
			else if (Running.inst[tabela.lista.get(Running.pid-1).n_pos] == 1 || Running.inst[tabela.lista.get(Running.pid-1).n_pos] == 3){
				tabela.lista.get(Running.pid-1).nextInst();
				addReady(removeRunning());
			}

			//se a  instruçao atual for 2 = acesso a disco
			else if (Running.inst[tabela.lista.get(Running.pid-1).n_pos] == 2) {

				//se a proxima instruçao nao for um acesso a disco
				if (Running.inst[tabela.lista.get(Running.pid-1).n_pos+1] != 2) {

					//o disco e desbloqueado
					//adiciona-se processo ao estado ready
					//aumenta-se o nº da instrução a ver para a proxima
					lock = false;
					locked_pid = 0;
					tabela.lista.get(Running.pid-1).nextInst();
					addReady(removeRunning());
				}

				//se a proxima instrução for um acesso a disco
				else {

					//o disco e bloqueado
					//e o pid de bloquear e o do processo atual
					//adiciona-se processo ao estado ready
					//aumenta-se o nº da instruçao a ver para a proxima
					lock = true;
					locked_pid = Running.pid;
					tabela.lista.get(Running.pid-1).nextInst();
					addReady(removeRunning());
				}
			}

			//se a instruçao atual for um GotoBegin = 4
			//a proxima instrução ira ser a 1ª do processo
			//adiciona-se processo ao estado ready
			else if (Running.inst[tabela.lista.get(Running.pid-1).n_pos] == 4) {
				tabela.lista.get(Running.pid-1).gotoBegin();
				addReady(removeRunning());
			}

			//se a instrução atual for um fork = 5
			//processo e duplicado, ou seja
			//cria-se um processo novo igual ao atual, e também um PCB
			//esse processo continua da instruçao atual do processo original
			//adicionam-se os 2 processos ao estado ready
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

		//se nao existir nada do estado running
		//acontece pois anteriormente removemos o processo do run
		if (Running == null) {

			//se o Blocked nao estiver vazio
			if (!Blocked.isEmpty()) {

				//se o disco nao estiver bloqueado
				if (!lock) {

					//adiciona-se processo do blocked para o RUN
					//NOTA: so se ve o primeiro processo do estado blocked
					//pois se não der para meter o 1º, é porque existe um processo
					//que bloqueou o disco, e este encontra-se no estado READY
					Process temp = removeBlocked();
					addRunning(temp);
				} 
				//se o disco estiver bloqueado
				else if (lock) {

					//chama-se o metodo verReady descrito em cima
					verReady();
				}
			}
			//caso o blocked esteja vazio
			else {

				//vai-se ver os processos no estado READY
				verReady();
			}
		}
		

		//Aqui adicionam-se processos do estado NEW para
		//o estado Ready quando houver recursos
		//e caso haja processos no estado new, se sim...
		if (New.size() != 0 ) {

			//enquanto houver páginas disponiveis
			while (paginas > 0) {

				//caso tenham sido já removidos alguns processos do NEW
				//e o NEW fique vazio, sai do ciclo while, apesar de ainda 
				//existirem recursos
				if (New.size() == 0)
					break;
				Process temp = removeNew();

				//se o processo temporario for nulo, continua
				if (temp == null)
					continue;

				//boleano true se adicionou
				//boelano falso se não adicionou
				boolean sera = addReadyFirst(temp);

				//se nao adicionou ao ready, adiciona ao fim do NEW
				//e assim o proximo processo a ser visto no NEW sera outro
				if (!sera)
					addNew(temp);
			}
		} 
	}
}