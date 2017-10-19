public class CartaoSuper{
  private static int cartoes=1;
  
  private int num;
  private float valor;
  private String cliente="Sr(a)";
  private Desconto[] desc=new Desconto[100]; 
  int i=0;
  
  
  public CartaoSuper(String n){
    cliente=cliente + " "+ n;
    valor=0f;
    num=cartoes;
    cartoes++;
  }
  
  public void acumulaDesconto(float v){
    Desconto d=new Desconto(v);
    desc[i]=d;
    i++;
    
  }
  
  public void acumulaDesconto(float v, My_Data x){
    Desconto d=new Desconto(v,x);
    desc[i]=d;
    i++;
  }
  
  public void actualizaSaldo(){
    My_Data hoje=new My_Data();
    int indice=i;
    int contador=0;
    int [] indices= new int[desc.length];
    
    for(int k=0;k<i;k++){
      if(hoje.maior(desc[k].data_valor)){
        valor += desc[k].valor;
        desc[k]= null;
        indices[contador]=k;
        contador++;
        
        //indice=k;
        //return ;
      }
    }
    while(contador>0){
      for(int j=indices[contador-1];j<i;j++){
        desc[j]=desc[j+1];
      }
      
      contador--;
      i--;
    
    }  
      
      
  }
  
  public void pagar(float x){
    if(x<=valor){
      System.out.println("Pago");
      valor-=x;
    }
    else{
      System.out.println("Não pago");
    }  
    
  }
  
  public String toString(){
    String s=cliente + "\n" + "saldo " + valor +"Û\n";
    for (int k=0;k<i;k++)
      s+=desc[k]+"\n";
    return s;
    
  }
  
}