import java.util.Iterator;


public class ABP<E extends Comparable<? super E>> implements ABPi<E>, Iterable<E> {
	NoABP<E> raiz;
	
	public ABP() {
		raiz=null;
	}
	
	private static class NoABP<E> {
		E elemento;
		NoABP<E> esq;
		NoABP<E> dir;
		
		NoABP(E x, NoABP<E> direita, NoABP<E> esquerda) {
			elemento=x;
			dir=direita;
			esq=esquerda;	
		}

		public E elem() {
			return elemento;
		}
		
		public NoABP<E> dir() {
			return dir;
		}
		
		public NoABP<E> esq() {
			return esq;
		}
	}
	
	private static class IteradorEmOrdem<E> implements java.util.Iterator<E> {
		NoABP<E> atual;
		ArrayStack<NoABP<E>> choice_points;
		
		public IteradorEmOrdem(NoABP<E> n) {
			atual = n;
			choice_points = new ArrayStack<NoABP<E>>();
		}

		@Override
		public boolean hasNext() {
			return atual!=null;
		}

		@Override
		public E next() {
			if (!hasNext()) {
				throw new java.util.NoSuchElementException();
			}
			E to_return = atual.elem();
			if (atual.esq()!=null) {
				try {
					choice_points.push(atual.esq());
				} catch (ExceptionFull e) {
					e.printStackTrace();
				}
			}
			if (atual.dir()!=null) {
				atual = atual.esq();
			}else {
				atual = null;
			}
			return to_return;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

	}
	
	
	public boolean isEmpty() {
		if(raiz==null) return true;
		else return false;
	}
	
	
	
	public boolean contains(E x) {
		return contains(x,raiz);
	}
	
	private boolean contains(E x, NoABP<E> n) {
		if (n==null) return false;
		else {
			if (n.elemento.compareTo(x)<0) return contains(x,n.dir);
			else {
				if (n.elemento.compareTo(x)>0) return contains(x,n.esq);
				else return true;
			}
		}
	}
	
	
	
	public E findMin() {
		if (isEmpty()) return null;
		return findMin(raiz);
	}
	
	private E findMin(NoABP<E> n) {
		if (n.esq==null) return n.elemento;
		else return findMin(n.esq);
	}
	
	
	
	public E findMax() {
		if (isEmpty()) return null;
		return findMax(raiz);
	}
	
	private E findMax(NoABP<E> n) {
		if (n.dir==null) return n.elemento;
		else return findMax(n.dir);
	}
	
	
	public void insere(E x) {
		raiz=insere(x,raiz);
	}
	
	private NoABP<E> insere(E x, NoABP<E> n) {
		if (n==null)
			n=new NoABP<E>(x,null,null);
		else if ((n.elemento).compareTo(x)>0)
			n.esq=insere(x,n.esq);
		else if ((n.elemento).compareTo(x)<0)
			n.dir=insere(x,n.dir);
		return n;
	}
	
	
	public String findPath(E x) {
		if (isEmpty()) {return null;}
		else if(!contains(x)) {return null;}
		else {
			String s = findPath(x, raiz);
			return s;
		}
	}
	
	public String findPath(E x, NoABP<E> n) {
		String s = "";
		if (x.compareTo(n.elemento)==0) {
			s = s + "; " + (String) n.elemento;
			return s;
		}else if(x.compareTo(n.elemento)>0) {
			s = s + "; " + findPath(x,n.dir);
		}else if(x.compareTo(n.elemento)<0) {
			s = s + "; " + findPath(x, n.esq);
		}
		return s;
	}
	/*
	public void remove(E x) {
		
	}
	
	private NoABP<E> remove(E x, NoABP<E> n) {
		
	}
	*/
	
	
	public void printEmOrdem() { //(esq,no,dir)
		
	}
	
	public void printPosOrdem() {//(esq,dir,no)
		
	}
	
	public void printPreOrdem() {//(no,esq,dir)
		
	}



	@Override
	public Iterator<E> iterator() {
		return new IteradorEmOrdem<E>(raiz);
	}
	
	
	public static void main(String[] args) {
		ABP<Integer> abp = new ABP<Integer>();
		abp.insere(10);
		abp.insere(20);
		abp.insere(5);
		abp.iterator();
	}
}
