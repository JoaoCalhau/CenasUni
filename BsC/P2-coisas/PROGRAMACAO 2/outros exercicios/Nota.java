public class Nota{
  //variaveis
  int valor;
  char moeda;
  
  //construtor da classe
  Nota(int valor,char moeda){
    this.valor=valor;
    this.moeda=moeda;
  }
  
  //alterar o valor duma moeda
  void setValor(int novoValor){
    valor=novoValor;
  }  
  //alterar a moeda
  void setMoeda(char novoMoeda){
    moeda=novoMoeda;
  }
  //retornar um valor
  int getValor(){
    return valor;
  }
  //retornar uma moeda
  char getMoeda(){
    return moeda;
  }
  //imprimir uma moeda
  public String toString(){
    return "A nota tem " + valor + " em " + moeda;
  }
  //equals
  public boolean equals(Nota compara){
    return this.valor==compara.valor && this.moeda==compara.moeda;
  }
  //clone
  public Nota clone(){
    return new Nota(this.valor,this.moeda);
  }
  
}





