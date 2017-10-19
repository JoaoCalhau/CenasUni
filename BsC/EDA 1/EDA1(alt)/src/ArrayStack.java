public class ArrayStack<T> implements Stack<T> {

	private int maximo = 1000;
	private int topo = -1;
	private T[] stack;
	
	public ArrayStack() {
		stack = (T[]) new Object[maximo];
	}
	
	@Override
	public void push(T o) throws Exceptions {
		if (size()==maximo){
			throw new Exceptions("Tá cheio!");
		}else{
			topo += 1;
			stack[topo] = o;
		}
	}

	@Override
	public T top() {
		return stack[topo];
		
	}

	@Override
	public T pop() throws Exceptions {
		if(size()==0) {
			throw new Exceptions("Tá vazio!");
		}else{
			T valueTopo = stack[topo];
			stack[topo]= null;
			topo --;
			return valueTopo;
		}
	}

	@Override
	public int size() {
		return topo + 1;

	}

	@Override
	public boolean empty() {
		return topo==-1;
	}
	
	public String toString() {
		if(size()==0) return "[ ]";
		StringBuffer out = new StringBuffer("[");
		for(int i = 0; i < topo; i++)
			out.append(stack[i] + ", ");
		out.append(stack[topo] + "]");
		return out.toString();

	}
		
}