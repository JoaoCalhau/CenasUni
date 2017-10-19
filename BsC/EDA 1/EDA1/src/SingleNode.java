public class SingleNode<T> {
	T elemento;
	SingleNode<T> next;
	
	public SingleNode(T e) {
		elemento = e;
		next = null;
	}
	
	public SingleNode() {
		this(null);
	}
	
	public SingleNode(T e, SingleNode<T> n) {
		elemento = e;
		next = n;
	}
	
	public T element() {
		if(elemento == null) {
			throw new java.util.NoSuchElementException();
		}
		return elemento;
	}
	
	public void setElement(T e) {
		this.elemento = e;
	}
	
	public SingleNode<T> getNext() {
		return next;
	}
	
	public void setNext(SingleNode<T> n) {
		next = n;
	}
}
