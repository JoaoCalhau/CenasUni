public class ClassicSingleton {
	private static ClassicSingleton instance = null;
	protected ClassicSingleton(){
	}
	
	public static ClassicSingleton getInstance(){
		if (instance == null){
			instance = new ClassicSingleton();
		}
		return instance;
	}

}
