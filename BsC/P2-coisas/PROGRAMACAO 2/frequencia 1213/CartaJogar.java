public class CartaJogar{
  private int naipe;
  private int valor;
  private static CartaJogar[] baralho=new CartaJogar[52];
  private static int indice=0;
    
    
  public CartaJogar(int v,int n){
    this.valor=v;
    this.naipe=n;
  }
  
  public int getNaipe(){
    return this.naipe;
  }
  
  public int getValor(){
    return this.valor;
  }
  
  public String toString(){
    String v ="";
    String n="";
    if( this.valor==11){
      v="D";
    }
    if (this.valor==12){
      v="J";
    }
    if (this.valor==13){
      v="K";
    }
    if (this.valor==14){
      v="A";
    }
    else{
      v = Integer.toString(this.valor);
    }
    
    if (this.naipe==1){
      n="Copas";
    }
    if (this.naipe==2){
      n="Paus";
    }
    if (this.naipe==3){
      n="Espadas";
    }
    if (this.naipe==4){
      n="Ouros";
    }
    
    if(this.valor<2 |this.valor>14){
      return "";
    }
    if(this.naipe<1 |this.naipe>4){
      return "";
    }
    return v+'_'+n;
    }
    
  
  
  public boolean equals(Object x){
    if(this==x){
      return true;
    }
    if(x==null || x.getClass()==this.getClass()){
      return false;
    } 
    CartaJogar cj=(CartaJogar)x;
    return this.valor==cj.valor && this.naipe==cj.naipe;
  }
  
  
  
  public int compareTo(CartaJogar y){
    int x=-100;
    if (this.naipe==y.naipe){
      
      if(this.valor<y.valor){
        x=-1;
        
      }
      
      if( this.valor==y.valor){
        x=0;
        
      }
      
      else{
        x=1;
        
      }
      
    }
   
    if(this.naipe!=y.naipe){
      x=100;
      
    }
    return x;
  }   
            
  
  
  public boolean vermelha(){
    if (this.naipe==3 | this.naipe==4){
      return true;
    }
    else{
      return false;
    }
  }
  
  public boolean preta(){
    if(this.naipe==1 | this.naipe==2){
      return true;
    }
    else{
      return false;
    }
  }
  
  
  public static CartaJogar[] baralho(){
    for(int va=2;va<15;va++){
      for(int na=1;na<5;na++){
        baralho[indice]=new CartaJogar(va,na);
        indice++;
      }
    }  
    
     return baralho;
  }
  
  
  
  
}