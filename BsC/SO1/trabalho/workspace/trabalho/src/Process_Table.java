import java.util.LinkedList;

class Process_Table{
	LinkedList<PCB> lista;
	int size;

	public Process_Table(){
		lista = new LinkedList<PCB>();
		size = 0;
	}

	public void getElements(){
		for (int i = 0; i < this.size; i++) {
			System.out.println(lista.get(i).pid);
		}
	}

	public void addPCB(PCB novo){
		lista.add(novo);
		this.size++;
	}

	public boolean removePCB(PCB remove){
		boolean teste = lista.contains(remove);
		if (teste){
			lista.remove(remove);
			this.size--;
		}
		return teste;
	}

	public boolean emptyProcess(){
		return (this.size==0);
	}

	public String toString() {
		String s = "";
		
		for (int i = 0; i < lista.size(); i++) {
			s += "| "+lista.get(i).toString() + " ";
		}
		return s;
	}
}