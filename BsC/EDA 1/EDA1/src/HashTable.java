public abstract class HashTable<T> {
	
	private int SIZE;
	private Elemento[] tabela;
	
	private class Elemento<T> {
		
		private T key;
		private T value;
		
		public Elemento(T key, T value) {
			this.key = key;
			this.value = value;
		}
		
		public T getKey() {
			return this.key;
		}
		
		public T getValue() {
			return this.value;
		}
		
		public boolean compareTo(Elemento x) {
			return this.key==x.key;
		}
	}
	
	public HashTable() {}
	
	public HashTable(int n) {
		this.SIZE = n;
		tabela = new Elemento[n];
		for (int i=0;i<this.SIZE;i++) {
			tabela[i] = null;
		}
	}
	
	public int ocupados() {
		int count=0;
		for (int i=0;i<this.SIZE;i++) {
			if (tabela[i] != null) {
				count++;
			}
		}
		return count;
	}
	
	public float factorCarga() {
		return (float) ocupados()/SIZE;
	}
	
	protected abstract int procPos(T s) {
	}
	
	public void alocarTabela(int dim) {
	}
	
	public void tornarVazia() {
	}
	
	public T procurar(T x) {
	}
	
	public void remove(T x) {
	}
	
	public void insere(T x) {
	}
	
	public void rehash() {
	}
	
	public void print() {
	}
}
