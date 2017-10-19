package so2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Questionario {
    
    int NumQuestionario;
    
    int quantidade;
    Pergunta Pergunta1;
    Pergunta Pergunta2;
    Pergunta Pergunta3;
    Pergunta Pergunta4;
    Pergunta Pergunta5;
    
    public Questionario(int quant, int NumQuest){
        
        this.quantidade=quant;
        this.NumQuestionario=NumQuest;
        
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
            switch(i){
                
                case 1:
                    System.out.print(this.Pergunta1.toString() + "\n");
                    this.Pergunta1.Responder(scan(sc));
                    break;
                    
                case 2:
                    System.out.print(this.Pergunta2.toString()+ "\n");
                    this.Pergunta2.Responder(scan(sc));
                    break;
                    
                case 3:
                    System.out.print(this.Pergunta3.toString()+ "\n");
                    this.Pergunta3.Responder(scan(sc));
                    break;
                    
                case 4:
                    System.out.print(this.Pergunta4.toString()+ "\n");
                    this.Pergunta4.Responder(scan(sc));
                    break;
                    
                case 5:
                    System.out.print(this.Pergunta5.toString()+ "\n");
                    this.Pergunta5.Responder(scan(sc));
                    break;
            }
            
        }
        sc.close();
    
    }
    
    
    
    public int scan(Scanner sc){
        int valor;
        System.out.println("Insira valor int entre 1 e 10");
        while(sc.hasNext()){
            if(sc.hasNextInt()) {
                valor = sc.nextInt();
                if(valor > 0 && valor < 11 ) {
                    System.out.println("Resposta Aceite");
                    return valor;
                }
            } else {
                System.out.println("Insira valor int entre 1 e 10");
                sc.next();
            }
        }
        return -1;
    }
    
}
