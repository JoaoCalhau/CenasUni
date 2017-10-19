public interface Queue<E> {
	public void enqueue(E o) throws ExceptionFull;
	public E front() throws Exception;
	public E dequeue() throws ExceptionEmpty;
	public int size();
	public boolean empty();
	public int increment(int i);
}
