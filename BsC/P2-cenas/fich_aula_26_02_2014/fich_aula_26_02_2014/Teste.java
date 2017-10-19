class Teste{
  public static void main(String args[]){
    Jogador joao=new Jogador();
    Jogador ana=new Jogador();
    /*System.out.println(joao.casa);
    joao.recua(10);
    System.out.println(joao.casa);
    int j=ana.avanca(5);
    System.out.println(ana.avanca(5));
    System.out.println(j);*/
    Dado d1=new Dado();
    System.out.println(d1.face());
    d1.roda(6);
    System.out.println(d1.face());
    //joao.joga(d1,45);
    //System.out.println(joao.casa);
    
    
    
  }
}