import java.util.Vector;

public class Mealheiro{
  Vector<Nota> mealheiro;
  
  Mealheiro(){
    mealheiro= new Vector<Nota>();
  }
  
  void addNota(Nota n){
    mealheiro.add(n);
    System.out.println("Nota inserida.");
  }
  
  int tamanhoV(){
    return mealheiro.size();
  }
  /*
  int somaValor(char m){
    int resultado= 0;
    for(int i=0; mealheiro.size();i++){
      if(mealheiro.elementAt(i).getMoeda()==m){
        resultado += mealheiro.elementAt(i).getValor();
      }  
    return resultado;
    }
  }
  */
  
  

}