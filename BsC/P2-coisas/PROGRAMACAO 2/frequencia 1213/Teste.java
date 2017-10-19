public class Teste{
  public static void main(String args[]){
    CartaJogar nova1 = new CartaJogar(3,2);
    System.out.println(nova1);
    CartaJogar nova2 = new CartaJogar(6,2);
    System.out.println(nova2);
    System.out.println(nova1.getNaipe());
    System.out.println(nova1.getValor());
    System.out.println(nova2.toString());
    System.out.println(nova2.compareTo(nova1));
    System.out.println(nova2.equals(nova1));
    System.out.println(nova1.vermelha());
  }
}