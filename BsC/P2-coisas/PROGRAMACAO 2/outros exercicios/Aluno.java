public class Aluno{
  //variaveis
  private int numero;
  private String nome;
  
  //construtor
  Aluno(int numero,String nome){
    this.numero=numero;
    this.nome=nome;
  }
  
  //to string
  public String nome_proprio(){
    String proprio=new String();
    for(int i=0;i<nome.length();i++){
      if (nome.charAt(i)==' '){
        break;
      }
      else{
        proprio+=nome.charAt(i);
      }
   
  
    }  
    return proprio;
  }
  
  //conta espaços
  private int conta_espacos(){
    int espacos=0;
    for(int i=0;i<nome.length();i++){
      if(nome.charAt(i)==' '){
        espacos+=1;
      
      }
    }
    return espacos;
  }

  
  //int espaco
  




}












