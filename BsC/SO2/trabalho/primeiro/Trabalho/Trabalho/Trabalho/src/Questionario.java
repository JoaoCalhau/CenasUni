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
        Scanner sc = new Scanner(System.in);
        for(int i=1; i<= this.quantidade; i++){
            switch(i){
                case 1:
                    System.out.print(this.Pergunta1.toString());
                    this.Pergunta1.Responder(scan(sc));
                    break;
                    
                case 2:
                    System.out.print(this.Pergunta2.toString());
                    this.Pergunta2.Responder(scan(sc));
                    break;
                    
                case 3:
                    System.out.print(this.Pergunta3.toString());
                    this.Pergunta3.Responder(scan(sc));
                    break;
                    
                case 4:
                    System.out.print(this.Pergunta4.toString());
                    this.Pergunta4.Responder(scan(sc));
                    break;
                    
                case 5:
                    System.out.print(this.Pergunta5.toString());
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
                if(valor > 0 && valor < 11) {
                    System.out.println("Resposta aceite!\n");
                    return valor;
                }
            } else {
                System.out.println("Insira valor int entre 1 e 10");
                sc.next();
            }
        }
        return -1;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < quantidade; i++) {
            switch(i){
                case 1:
                    sb.append("Pergunta nº 1" + Pergunta1.toString() + "\n");
                    break;
                case 2:
                    sb.append("Pergunta nº 2" + Pergunta2.toString() + "\n");
                    break;
                case 3:
                    sb.append("Pergunta nº 3" + Pergunta3.toString() + "\n");
                    break;
                case 4:
                    sb.append("Pergunta nº 4" + Pergunta4.toString() + "\n");
                    break;
                case 5:
                    sb.append("Pergunta nº 5" + Pergunta5.toString() + "\n");
                    break;
            }
        }
        return sb.toString();
    }
}