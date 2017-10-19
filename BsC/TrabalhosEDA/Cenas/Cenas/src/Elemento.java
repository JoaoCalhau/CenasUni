public class Elemento<T> {
	
	T element;
	String s;
	boolean isActive;
	public T getElement() {
		return element;
	}
	
	Elemento (T elemento){
		element= elemento;

	}
	


	public void setElement(T element) {
		this.element = element;
	}
	
	public boolean isActive() {
		return isActive;
	}
	
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Elemento element=" + element ;
	}
	
	
}
