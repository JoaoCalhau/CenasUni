public class Teste{
  public static void main(String[] args){
    My_Data d=new My_Data(31,12,2020);
    System.out.println(d.toString());
    My_Data d1=d.diaSeguinte();
  System.out.println(d1.toString());
  d1.add(600);
  System.out.println(d1.toString());
  System.out.println(d.maior(d1));
  Desconto des=new Desconto(3.54f);
  System.out.println(des);
  
  CartaoSuper c1=new CartaoSuper("Madalena Miguel");
  c1.acumulaDesconto(2.32f);
  c1.acumulaDesconto(1.23f);
  
  
  c1.acumulaDesconto(5.00f,new My_Data(1,2,2014));
  
  System.out.println(c1);
  c1.actualizaSaldo();
  System.out.println(c1);
  
  
  //Fazia pagamento
  c1.pagar(2.0f);
  //não faz pagamento
  c1.pagar(30.0f);
  }
  
}