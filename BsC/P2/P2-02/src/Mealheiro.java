import java.util.Vector;

public class Mealheiro {
	Vector<Nota> mealheiro;
	
	Mealheiro(){
		mealheiro = new Vector<Nota>();
	}
	
	void adicionaNota(Nota n){
		mealheiro.add(n);
		System.out.println("Nota inserida.");
	}
	
	int tamanhoM(){
		return mealheiro.size();
	}
	
	int calcularValor(char moeda){
		int resultado = 0;
		
		for(int i=0; i<mealheiro.size(); i++){
			if(mealheiro.elementAt(i).getMoeda() == moeda){
				resultado += mealheiro.elementAt(i).getValor();
			}
		}
		
		return resultado;
	}
}
