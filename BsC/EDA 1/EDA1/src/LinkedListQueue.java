public class LinkedListQueue<E> implements Queue<E> {
	private LinkedList<E> Q;
	private int fim, inicio = 0;
	
	public LinkedListQueue() {
		Q = new LinkedList<E>();
	}
	
	@Override
	public void enqueue(E o) {
		Q.add(o);
		fim = increment(fim);
	}

	@Override
	public E front() throws ExceptionEmpty {
		if (empty()) throw new ExceptionEmpty("Queue is probably empty...");
		else return Q.get(inicio);
	}

	@Override
	public E dequeue() throws ExceptionEmpty {
		E x = Q.get(inicio);
		Q.remove(inicio);
		inicio = increment(inicio);
		return x;
	}

	@Override
	public int size() {
		return Q.size();
	}

	@Override
	public boolean empty() {
		return Q.size()==0;
	}

	@Override
	public int increment(int i) {
		return (i+1);
	}
	
	public String toString() {
		   if(empty()) return "[ ]";

		   StringBuffer out = new StringBuffer("[");
		   for(int i = inicio; i < fim; i++)
			   out.append(Q.get(i) + ", ");

		   out.append(Q.get(fim) + "]");
		   return out.toString();
	}
}
