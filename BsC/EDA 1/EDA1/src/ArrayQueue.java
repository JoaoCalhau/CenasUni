public class ArrayQueue<E> implements Queue<E>{
	private E[] Q;
	private int MAX=100;
	public int fim,inicio = 0;
	
	@SuppressWarnings("unchecked")
	public ArrayQueue(){
		Q = (E[]) new Object[MAX];
	}
	
	@Override
	public void enqueue(E o) throws ExceptionFull{
		if (size()==MAX){
			throw new ExceptionFull("Queue is Full!");
		}else{
			Q[fim]=o;
			fim=increment(fim);
		}
	}
	
	@Override
	public E front() throws ExceptionEmpty {
		if (empty()){
			throw new ExceptionEmpty("Queue is empty, there is no front!");
		}else{
			return Q[inicio];
		}
	}
	
	@Override
	public E dequeue() throws ExceptionEmpty{
		if (empty()){
			throw new ExceptionEmpty("Queue is empty!");
		}else{
			E i=Q[inicio];
			Q[inicio]=null;
			inicio=increment(inicio);
			return i;
		}
	}
	
	@Override
	public int size(){
		return((MAX-inicio+fim)%MAX);
	}
	
	@Override
	public boolean empty(){
		return (inicio==fim);
	}
	
	@Override
	public int increment(int i){
		return (i+1)%MAX;
	}
}
