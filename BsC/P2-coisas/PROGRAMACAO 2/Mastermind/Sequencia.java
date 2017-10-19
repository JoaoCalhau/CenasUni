public class Sequencia{
  String cor1;
  String cor2;
  String cor3;
  String cor4;
  String[] ordem = new String[4];
  
  public Sequencia(String c1,String c2,String c3,String c4){
    cor1=c1;
    cor2=c2;
    cor3=c3;
    cor4=c4;
    
  }
  
  public String getcor1(){
    return cor1;
    
  }
  
  public String getcor2(){
    return cor2;
    
  }
  
  public String getcor3(){
    return cor3;
    
  }
  
  public String getcor4(){
    return cor4;
    
  }
  
  public void ordenado(){
    ordem[0]=cor1;
    ordem[1]=cor2;
    ordem[2]=cor3;
    ordem[3]=cor4;
      
    
  }
  
  public String toString(){
    return ordem[0] +"\n" + ordem[1] +"\n" + ordem[2]+"\n"+ ordem[3];
  }
}
    
    
    
    
    
    
    
    
    
    
    
    