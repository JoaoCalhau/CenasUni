public class LocalVariables {
	public void pupAge(){
		int age = 0; //age é uma variavel local porque é definida dentro de pupAge
		age = age + 7;
		System.out.println("Puppy age is: "+ age);
	}
	
	public static void main(String args[]){
		LocalVariables test = new LocalVariables();
		test.pupAge();
	}

}
