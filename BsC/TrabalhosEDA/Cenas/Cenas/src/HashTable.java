public abstract class HashTable<T> {
	
	Elemento [] array;
	int size;
	float ocupados=0;
	
	
	
	HashTable(){
		array = new Elemento [11];
		this.size=11;
	}
	
	
	HashTable(int size){
		this.size= this.getPrime(size);
		array = new Elemento [this.size];
	}
	
	public float ocupados(){
		return ocupados;
	}
	
	public float fatorCarga(){
		return (ocupados/size);
	}
	
	public int getPrime(int f) {
		for (int i=f-1;i>=1;i--) {
			int fact=0;
			for (int j=2;j<=(int) Math.sqrt(i);j++) {
				if (i%j==0) {
					fact++;
				}
			}
			if (fact==0) {
				return i;
			}
		}
		return 3;
	}
	
	protected abstract int procPos(T s);
	
	public void alocarTabela(int dim){
		size= this.getPrime(dim);
		array= new Elemento [size];
	}
	
	public void tornarVazia(){
		alocarTabela(size);
	}
	
	public T procurar(T x){
		return (T) array[this.procPos(x)];
	}
	
	public  void remove (T x){
		array[this.procPos(x)]=null;
		ocupados--;
	}
	
	public void insere (T x){
		array[this.procPos(x)]= (Elemento) x;
		ocupados++;
		//System.out.println(this.procPos(x));
		if (this.fatorCarga()>=0.6){
			this.rehash();
			System.out.println("aqui1");
		}
		
	}
	
	public void rehash() {
		Elemento[] tempTable = new Elemento[size*2];
		
		for(int i = 0; i < size; i++)
				tempTable[i] = array[i];
		
		
		alocarTabela(size*2);
		
		for( int i = 0; i < size; i++) {
			if(tempTable[i] != null)
				insere((T)tempTable[i]);
		}
		

		/*
		System.out.println("aqui");
		Elemento [] tempArray = new Elemento [size];
		for(int i=0; i<size; i++){
			if (array[i]!= null){
				tempArray[i]=array[i];
				
			}
		}
		
		size= this.getPrime(size*2);
		array = new Elemento [size];
		for (int i=0; i<tempArray.length; i++){
			if (array[i]!= null){
				insere( (T) tempArray[i]);
			}
		}
		*/
	}
	public void print(){
		for (int i=0; i<array.length; i++){
			if (array[i]!= null){
				System.out.println(array[i].toString());
			}
		}
	}
	
	public static void main(String[] args) {
		
	}
}
