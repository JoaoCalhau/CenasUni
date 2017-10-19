
public interface ABPi<E extends Comparable<? super E>> {
	public boolean isEmpty();
	public boolean contains(E x);
	public E findMax();
	public E findMin();
	public void insere(E x);
	//public void remove(E x);
	public void printEmOrdem();
	public void printPosOrdem();
	public void printPreOrdem();
}
