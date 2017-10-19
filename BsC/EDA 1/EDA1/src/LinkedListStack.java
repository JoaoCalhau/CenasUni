public class LinkedListStack<E> implements Stack<E>{
	private LinkedList<E> S;
	private int top=-1;
	
	public LinkedListStack() {
		S = new LinkedList<E>();
	}
	
	@Override
	public void push(E o) {
		top++;
		S.add(o);
	}

	@Override
	public E top() {
		return S.get(top);
	}

	@Override
	public E pop() throws ExceptionEmpty {
		if (top == -1) throw new ExceptionEmpty("It's probably empty...");
		else {
			E x = S.get(top);
			S.remove(top);
			top--;
			return x;
		}
	}

	@Override
	public int size() {
		return S.size();
	}

	@Override
	public boolean empty() {
		return size()==0;
	}

	@Override
	public void clear() {
		for (int i = 0;i==top;i++) {
			S.remove(i);
		}
	}
	
	public String toString() {
		   if(empty()) return "[ ]";

		   StringBuffer out = new StringBuffer("[");
		   for(int i = 0; i < top; i++)
			   out.append(S.get(i) + ", ");

		   out.append(S.get(top) + "]");
		   return out.toString();
	}
	
}
