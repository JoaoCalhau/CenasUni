public class Teste {

	public static void main(String[] args) {
		
		Mealheiro mealheiro = new Mealheiro();
		mealheiro.tamanhoM();
		
		Nota euro10 = new Nota(10, '€');
		Nota euro20 = new Nota(20, '€');
		Nota dolar10 = new Nota(10, '$');
		
		System.out.println(euro10.toString());
		euro10.getValor();
		euro10.getMoeda();
		
		euro10.setValor(50);
		System.out.println(euro10.toString());
		
		euro10.setMoeda('£');
		System.out.println(euro10.toString());
		
		mealheiro.adicionaNota(euro10);
		mealheiro.adicionaNota(euro20);
		mealheiro.adicionaNota(dolar10);
		mealheiro.tamanhoM();
		
		System.out.println(mealheiro.calcularValor('€'));
		
		System.out.println(euro10);
	}

}
