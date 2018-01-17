public class ArrayStack<E> implements Stack<E>{
	private int MAX=100;
	private E[] S;
	private int topo=-1;
	
	
	@SuppressWarnings("unchecked")
	public ArrayStack() {
		S = (E[]) new Object[MAX];
	}
	
	@Override
	public void push(E o) throws ExceptionFull {
		if(size()==MAX) throw new ExceptionFull("Stack is Full!");
		else S[++topo]=o;
	}

	@Override
	public E top() {
		return S[topo];
	}

	@Override
	public E pop() throws ExceptionEmpty {
		if (size()==0) throw new ExceptionEmpty("Stack is Empty!");
		else{
			E x = S[topo];
			S[topo]=null;
			topo--;
			return x;
		}
	}

	@Override
	public int size() {
		return topo+1;
	}

	@Override
	public boolean empty() {
		return topo == -1;
	}
	
	@Override
	public void clear(){
		for(int i=0;i<S.length;i++) 
			S[i]=null;
	}
	
	
	public String toString() {
		   if(empty()) return "[ ]";

		   StringBuffer out = new StringBuffer("[");
		   for(int i = 0; i < topo; i++)
			   out.append(S[i] + ", ");

		   out.append(S[topo] + "]");
		   return out.toString();
	   }
}