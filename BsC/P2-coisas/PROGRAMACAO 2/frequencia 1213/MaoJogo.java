public class MaoJogo{
  private CartaJogar[] baralho;
  private int indice;
  
  
  public MaoJogo(int x){
    baralho=new CartaJogar[x];
    indice=0;
  }
    
  
  public void add(CartaJogar c){
    if(indice<baralho.length){
      baralho[indice]=c;
      indice++;
    }
  }
  
  public void jogar(CartaJogar c){
    int indremover=-1;
    for(int i=0;i<indice;i++){
      if(baralho[i].equals(c)){
        indremover=i;
      }
    }
    if(indremover==-1){
       System.out.println("Carta não existe");
    }
    else{
      for(int i=indremover;i<indice;i++){
        baralho[i]=baralho[i+1];
        
      }
    indice--;
    }
        
        
        
      
  
  }
}