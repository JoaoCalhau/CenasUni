public class Desconto{
  float valor;
  My_Data data;
  My_Data data_valor;
  
  public Desconto(float v){
    valor=v;
    data=new My_Data();
    data_valor=data.diaSeguinte();
  }
  
  public Desconto(float v,My_Data x){
    valor= v;
    data= x;
    data_valor=data.diaSeguinte();
  }
  
  public String toString(){
    return valor+"Û em "+ data + " tem efeito em "+ data_valor;}
}