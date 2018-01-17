import java.util.Iterator;


public class ABP {
	NoABP raiz;
	
	public ABP() {
		raiz=null;
	}
	
	private static class NoABP {
		contacto elemento;
		NoABP esq;
		NoABP dir;
		
		NoABP(contacto x, NoABP direita, NoABP esquerda) {
			elemento=x;
			dir=direita;
			esq=esquerda;	
		}

		public contacto elem() {
			return elemento;
		}
		
		public NoABP dir() {
			return dir;
		}
		
		public NoABP esq() {
			return esq;
		}
	}
	
	/*
	private static class IteradorEmOrdem implements java.util.Iterator {
		NoABP atual;
		ArrayStack<NoABP> choice_points;
		
		public IteradorEmOrdem(NoABP n) {
			atual = n;
			choice_points = new ArrayStack<NoABP>();
		}

		@Override
		public boolean hasNext() {
			return atual!=null;
		}

		@Override
		public contacto next() {
			if (!hasNext()) {
				throw new java.util.NoSuchElementException();
			}
			contacto to_return = atual.elem();
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
	*/
	
	public boolean isEmpty() {
		if(raiz==null) return true;
		else return false;
	}
	
	
	
	public boolean contains(contacto x) {
		return contains(x,raiz);
	}
	
	private boolean contains(contacto x, NoABP n) {
		if (n==null) return false;
		else {
			if (n.elemento.compareTo(x)<0) return contains(x,n.dir);
			else {
				if (n.elemento.compareTo(x)>0) return contains(x,n.esq);
				else return true;
			}
		}
	}
	
	
	
	public contacto findMin() {
		if (isEmpty()) return null;
		return findMin(raiz);
	}
	
	private contacto findMin(NoABP n) {
		if (n.esq==null) return n.elemento;
		else return findMin(n.esq);
	}
	
	
	
	public contacto findMax() {
		if (isEmpty()) return null;
		return findMax(raiz);
	}
	
	private contacto findMax(NoABP n) {
		if (n.dir==null) return n.elemento;
		else return findMax(n.dir);
	}
	
	
	public void insere(contacto x) {
		raiz=insere(x,raiz);
	}
	
	private NoABP insere(contacto x, NoABP n) {
		if (n==null)
			n=new NoABP(x,null,null);
		else if ((n.elemento).compareTo(x)>0)
			n.esq=insere(x,n.esq);
		else if ((n.elemento).compareTo(x)<0)
			n.dir=insere(x,n.dir);
		return n;
	}
	
	
	public String findPath(contacto x) {
		if (isEmpty()) {return null;}
		else if(!contains(x)) {return null;}
		else {
			String s = findPath(x, raiz);
			return s;
		}
	}
	
	public String findPath(contacto x, NoABP n) {
		String s = "";
		if (x.compareTo(n.elemento)==0) {
			s = s + "; " + n.elemento.toString();
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
	
	private NoABP remove(E x, NoABP n) {
		
	}
	*/
	
	
	public void printEmOrdem() { //(esq,no,dir)
		
	}
	
	public void printPosOrdem() {//(esq,dir,no)
		
	}
	
	public void printPreOrdem() {//(no,esq,dir)
	}



/*
	@Override
	public Iterator iterator() {
		return new IteradorEmOrdem(raiz);
	}
*/
	public static class contacto {
		private String nome;
		private int numero;

		public contacto(String x, int num) {
			this.nome = x;
			this.numero = num;
		}

		public String getNome() {
			return this.nome;
		}

		public int compareTo(contacto c) {
			return this.getNome().compareTo(c.getNome());
		}

		public String toString() {
			return "" + nome + ": " + numero;
		}
	}

/*
	public int compareTo(NoABP n) {
		return compareTo(n.elemento);
	}
	*/

	public static void main(String[] args) {
		ABP cenas = new ABP();
		cenas.insere(new contacto("eu",123));
		cenas.insere(new contacto("tu",321));
		cenas.insere(new contacto("nois",321123));

		System.out.println(cenas.findMax().toString());
		System.out.println(cenas.findMin().toString());
	}
}

