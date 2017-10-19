public class HashTable {
	
	private int SIZE;
	private int capacity;
	Element[] table;
	private int primeSize;
	private int colisoes;
	
	class Element {
		String key;
		Object value;
		
		Element(String key, Object value) {
			this.key=key;
			this.value=value;
		}
		
		public String getKey() {
			return this.key;
		}
		
		public void setKey(String key) {
			this.key=key;
		}
		
		public Object getValue() {
			return this.value;
		}
		
		public void setValue(Object value) {
			this.value=value;
		}
		
		public String toString() {
			return "<Element("+key+","+value+")>";
		}
	}
	
	public HashTable(int c) {
		capacity=c;
		SIZE=0;
		table = new Element[capacity];
		for (int i=0; i<capacity;i++) {
			table[i]=null;
		}
		primeSize=getPrime();
	}
	
	public int getPrime() {
		for (int i=capacity-1;i>=1;i--) {
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
	
	public int capacity() {
		return this.capacity;
	}
	
	public int size() {
		return this.SIZE;
	}
	
	public int colisoes() {
		return this.colisoes;
	}
	
	public boolean isEmpty() {
		return SIZE==0;
	}
	
	public void MakeEmpty() {
		SIZE=0;
		for (int i=0;i<capacity;i++) {
			table[i]=null;
		}
	}
	
	public Object get(String key) {
		int hash1 = hash1(key);
		int hash2 = hash2(key);
		while(table[hash1] != null && !table[hash1].getKey().equals(key)) {
			hash1 += hash2;
			hash1 %= capacity;
		}
		return table[hash1].getValue();
	}
	
	public void put(String key, Object value) {
		if (loadFactor() > 0.5) {
			rehash();
		}
		int hash1 = hash1(key);
		int hash2 = hash2(key);
		while (table[hash1] != null) {
			colisoes++;
			hash1 += hash2;
			hash1 %= capacity;
		}
		table[hash1] = new Element(key, value);
		SIZE++;
	}
	
	public void remove(String key) {
		int hash1 = hash1(key);
		int hash2 = hash2(key);
		while(table[hash1] != null && !table[hash1].getKey().equals(key)) {
			hash1 += hash2;
			hash1 %= capacity;
		}
	}
	
	public int hash1(String x) {
		int hash = x.hashCode();
		hash %= capacity;
		if (hash<0) {
			hash +=capacity;
		}
		return hash;
	}
	
	public int hash2(String x) {
		int hash = x.hashCode();
		hash %= capacity;
		if (hash<0) {
			hash += capacity;
		}
		return primeSize - hash % primeSize;
	}
	
	public void rehash() {
		HashTable newTable = new HashTable(capacity*2);
		for (int i=0;i<capacity;i++) {
			if (table[i]==null) {
				continue;
			}
			newTable.put(table[i].getKey(), table[i].getValue());
		}
		this.capacity = newTable.capacity;
		this.SIZE = newTable.SIZE;
		this.primeSize = newTable.primeSize;
		this.table = newTable.table;
	}
	
	public double loadFactor() {
		return (double) size()/capacity();
	}
	
	public String toString() {
		String s="<HashTable(";
		for (int i=0;i<capacity;i++) {
			if (table[i] != null) {
				s += table[i].toString();
			}
		}
		return s+")>";
	}
}