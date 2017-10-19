public class LinkedList<T> implements Iterable<T> {
	private SingleNode<T> header;
	private int theSize;

	public LinkedList() {
		header = new SingleNode<T>();
		theSize = 0;
	}

	public java.util.Iterator<T> iterator() {
		return new LinkedListIterator<T>(header.next);
	}

	public int size() {
		return theSize;
	}

	public boolean isEmpty() {
		return theSize == 0;
	}

	public SingleNode<T> header() { 
		return header;
	}

	void add(SingleNode<T> prev, T x) {
		SingleNode<T> newNode = new SingleNode<T>(x, prev.getNext());
		prev.setNext(newNode);
		theSize++;
	}

	void remove(SingleNode<T> prev) {
		prev.setNext(prev.getNext().getNext());
		theSize--;
	}

	public void remove(int ind) {
		remove(getNode(ind-1));
	}
	
	public void add(int i, T x) {
		add(getNode(i-1), x);
	}
	
	public void add(T x) { //para adicionar uma no fim
		add(getNode(size()-1), x);
	}

	SingleNode<T> findPrevious(T x) {
		SingleNode<T> p = header();
		for(T v : this) {
			if (v.equals(x)) {
				return p; 
			} else {
				p = p.getNext();
			}
		}
		throw new java.util.NoSuchElementException();
	}

	public void remove(T x) {
		try {
			remove(findPrevious(x));
		}
		catch(java.util.NoSuchElementException e) {};
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("[");

		for (T x : this)
			sb.append(x + "");
		sb.append("]");

		return new String(sb);
	}

	public void set(int indx, T x) {
		getNode(indx).setElement(x);
	}

	public T get(int ind) {
		if(ind >= 0 && ind <= size()-1)
			return getNode(ind).element();
		else
			throw new IndexOutOfBoundsException("getNode index " + ind + " size: " + size());
	}

	SingleNode<T> getNode(int i) {
		int ind =- 1;
		SingleNode<T> s = header();
		while(ind++ < i)
			s = s.getNext();
		return s;
	}
}