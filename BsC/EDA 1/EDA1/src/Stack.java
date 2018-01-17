public interface Stack<E>{
	public void push(E o) throws ExceptionFull;
	public E top();
	public E pop() throws ExceptionEmpty;
	public int size();
	public boolean empty();
	public void clear();
}