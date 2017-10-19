public class Nota {
		
		//variaveis
		int valor;
		char moeda;
		
		//construtor
		Nota(int valor, char moeda){
			this.valor = valor;
			this.moeda = moeda;
			
		}
		
		//alterar o valor de uma nota
		void setValor(int novoValor){
			valor = novoValor;
		}
		
		//Alterar moeda
		void setMoeda(char novaMoeda){
			moeda = novaMoeda;
		}
		
		//Retornar o valor da nota
		int getValor(){
			return valor;
		}
		
		char getMoeda(){
			return moeda;
		}
		
		//Exercicio 1 da aula 3 começa aqui:
		
		public String toString(){
			return "Nota "+ valor + " na moeda " + moeda;
		}
		
		public Nota clone(){
			return new Nota(this.valor, this.moeda);
		}
		
		public boolean equals(Nota compara){
			return this.valor == compara.valor && this.moeda == compara.moeda;
		}
}
