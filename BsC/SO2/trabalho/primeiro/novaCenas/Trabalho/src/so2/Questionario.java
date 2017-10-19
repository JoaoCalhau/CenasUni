package so2;

import java.io.Serializable;
import java.util.Scanner;

public class Questionario implements Serializable{
    
    String NomeQuestionario;
    
    int quantidade;
    Pergunta Pergunta1;
    Pergunta Pergunta2;
    Pergunta Pergunta3;
    Pergunta Pergunta4;
    Pergunta Pergunta5;
    
    public Questionario(){
        this.NomeQuestionario=setNome();
        this.quantidade=criarQuantidade();
        for(int i=1; i<= quantidade; i++){
            switch(i){
                case 1:
                    this.Pergunta1 = this.setPergunta();
                    break;
                case 2:
                    this.Pergunta2 = this.setPergunta();
                    break;
                case 3:
                    this.Pergunta3 = this.setPergunta();
                    break;
                case 4:
                    this.Pergunta4 = this.setPergunta();
                    break;
                case 5:
                    this.Pergunta5 = this.setPergunta();
                    break;
            }
        }
    }
    
    public int criarQuantidade(){
        Scanner sc = new Scanner(System.in);
        int quantidade = scan(sc,3,5);
        return quantidade;
        
    
    }
    
    public String setNome(){
        System.out.println("Insira o nome do Questionario:");
        Scanner sc = new Scanner(System.in);
        String questao="";
        boolean repetir=true;
        boolean ciclo;
        while(repetir){
            ciclo=true;
            questao = sc.nextLine();
            System.out.println("Está satisfeito como nome? y/n");
            String satisfeito= sc.nextLine();
            while(ciclo){
                if(satisfeito.toUpperCase().equals("Y")){
                    System.out.println("Nome aceite!");
                    repetir=false;
                    ciclo=false;
                }
                else if(satisfeito.toUpperCase().equals("N")){
                    System.out.println("Nome nao foi aceite!");
                    System.out.println("Insira o nome do Questionario:");
                    ciclo=false;
                    
                }
                else{
                    System.out.println("Insira y/n!");
                    satisfeito= sc.nextLine();
                }
            }
            
        }
        return questao;
    
    }
    
    public Pergunta setPergunta(){
        System.out.println("Insira a questão:");
        Scanner sc = new Scanner(System.in);
        String questao = sc.nextLine();
        Pergunta temp = new Pergunta(questao);
        return temp;
    }
    
    public void responderPerguntas() {
        int valor;
        Scanner sc = new Scanner(System.in);
        for(int i=1; i<= this.quantidade; i++){
            switch(i) {
                case 1:
                    System.out.print(this.Pergunta1.toString() + "\n");
                    this.Pergunta1.Responder(scan(sc,1,10));
                    break;
                    
                case 2:
                    System.out.print(this.Pergunta2.toString()+ "\n");
                    this.Pergunta2.Responder(scan(sc,1,10));
                    break;
                    
                case 3:
                    System.out.print(this.Pergunta3.toString()+ "\n");
                    this.Pergunta3.Responder(scan(sc,1,10));
                    break;
                    
                case 4:
                    System.out.print(this.Pergunta4.toString()+ "\n");
                    this.Pergunta4.Responder(scan(sc,1,10));
                    break;
                    
                case 5:
                    System.out.print(this.Pergunta5.toString()+ "\n");
                    this.Pergunta5.Responder(scan(sc,1,10));
                    break;
            }
        }
    }
    
    public int scan(Scanner sc, int start, int end){
        int valor=-1;
        System.out.println("Insira valor int entre "+ start +" e "+ end);
        while(sc.hasNext()) {
            if(sc.hasNextInt()) {
                valor = sc.nextInt();
                if(valor >= start && valor <= end ) {
                    System.out.println("Resposta Aceite");
                    return valor;
                }
            } else {
                System.out.println("Insira valor int entre "+ start +" e "+ end);
                sc.next();
            }
        }
        return valor;
    }
   
    public String getNome(){
        return this.NomeQuestionario;
    }
}
