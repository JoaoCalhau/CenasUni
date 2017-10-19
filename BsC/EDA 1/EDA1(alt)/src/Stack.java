public interface Stack <T>{
	public void push(T o) throws Exceptions;
	public T top();
	public T pop() throws Exceptions;
	public int size();
	public boolean empty();
		
}