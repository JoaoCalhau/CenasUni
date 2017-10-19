import java.util.LinkedList;

class Process_Table{
	LinkedList<PCB> lista; //lista de PCB's

	//cria-se uma process table com uma linkedlist
	public Process_Table(){
		lista = new LinkedList<PCB>();
	}

	//adicionar novo pcb a lista
	public void addPCB(PCB novo){
		lista.add(novo);
	}

	//remover pcb da lista
	public boolean removePCB(PCB remove){
		boolean teste = lista.contains(remove);
		if (teste){
			lista.remove(remove);
		}
		return teste;
	}

	
	//toString para o ficheiro scheduler.out 
	public String toString() {
		String s = "";
		
		for (int i = 0; i < lista.size(); i++) {
			s += "| "+lista.get(i).toString() + " ";
		}
		return s;
	}
}