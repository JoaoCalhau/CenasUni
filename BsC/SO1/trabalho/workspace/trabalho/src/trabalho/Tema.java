package trabalho;

public class Tema extends Comparable<? super Tema>{
  String nome;
  int pagina;
  ABP<Tema> teste = new ABP<Tema>();

  public Tema(String n, int p){
    nome = n;
    pagina = p;
  }

}
