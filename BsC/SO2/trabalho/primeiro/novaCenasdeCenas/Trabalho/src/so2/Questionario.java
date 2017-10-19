package so2;

import java.io.Serializable;
import java.util.Scanner;

public final class Questionario implements Serializable{
    
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
        
        for(int i=1; i<= quantidade; i++) {
            switch(i) {
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
    
    public Questionario(String n, Pergunta[] p) {
        NomeQuestionario = n;
        quantidade = p.length;
        
        for(int i=0; i< quantidade; i++) {
            switch(i) {
                case 0:
                    Pergunta1 = p[i];
                    break;
                case 1:
                    Pergunta2 = p[i];
                    break;
                case 2:
                    Pergunta3 = p[i];
                    break;
                case 3:
                    Pergunta4 = p[i];
                    break;
                case 4:
                    Pergunta5 = p[i];
                    break;
            }
        }
    }
    
    public int criarQuantidade() {
        Scanner sc = new Scanner(System.in);
        int quant = scan(sc,3,5);
        return quant; 
    }
    
    public String verPerguntas() {
       String resultado="";
       for(int i=0; i< quantidade; i++) {
            switch(i) {
                case 0:
                    resultado+= this.Pergunta1.Nome() +"\n";
                    break;
                case 1:
                    resultado+= this.Pergunta2.Nome()+"\n";
                    break;
                case 2:
                    resultado+= this.Pergunta3.Nome()+"\n";
                    break;
                case 3:
                    resultado+= this.Pergunta4.Nome()+"\n";
                    break;
                case 4:
                    resultado+= this.Pergunta5.Nome()+"\n";
                    break;
            }
        }
        return resultado;  
    }
    
    public int quantRespostas() {
        return this.Pergunta1.quantRespostas();
    }
    
    public String verMedia() {
       //String resultado="";
       //float media[] = new float[quantidade];
       StringBuilder sb = new StringBuilder();
       for(int i=0; i< quantidade; i++){
            switch(i) {
                case 0:
                    //media[i] = Pergunta1.Media();
                    sb.append(Pergunta1.Media() + "\n");
                    //resultado+= this.Pergunta1.Nome() + " " + this.Pergunta1.Media() +"\n";
                    break;
                case 1:
                    //media[i] = Pergunta2.Media();
                    sb.append(Pergunta2.Media() + "\n");
                    //resultado+= this.Pergunta2.Nome() + " " + this.Pergunta2.Media() +"\n";
                    break;
                case 2:
                    //media[i] = Pergunta3.Media();
                    sb.append(Pergunta3.Media() + "\n");
                    //resultado+= this.Pergunta3.Nome() + " " + this.Pergunta3.Media() +"\n";
                    break;
                case 3:
                    //media[i] = Pergunta4.Media();
                    sb.append(Pergunta4.Media() + "\n");
                    //resultado+= this.Pergunta4.Nome() + " " + this.Pergunta4.Media() +"\n";
                    break;
                case 4:
                    //media[i] = Pergunta5.Media();
                    sb.append(Pergunta5.Media());
                    //resultado+= this.Pergunta5.Nome() + " " + this.Pergunta5.Media() +"\n";
                    break;
            }
        }
        return sb.toString();  
    }
    
    public String setNome() {
        System.out.println("Insira o nome do Questionario:");
        Scanner sc = new Scanner(System.in);
        String questao="";
        boolean repetir=true;
        boolean ciclo;
        while(repetir) {
            ciclo=true;
            questao = sc.nextLine();
            System.out.println("Está satisfeito como nome? y/n");
            String satisfeito= sc.nextLine();
            while(ciclo) {
                switch (satisfeito.toUpperCase()) {
                    case "Y":
                        System.out.println("Nome aceite!");
                        repetir=false;
                        ciclo=false;
                        break;
                    case "N":
                        System.out.println("Nome nao foi aceite!");
                        System.out.println("Insira o nome do Questionario:");
                        ciclo=false;
                        break;
                    default:
                        System.out.println("Insira y/n!");
                        satisfeito= sc.nextLine();
                        break;
                }
            }
        }
        return questao;
    }
    
    public int[] getRespostas() {
       int respostas[] = new int[quantidade];
       for(int i=0; i< quantidade; i++) {
            switch(i) {
                case 0:
                    respostas[i]= this.Pergunta1.LastValue();
                    break;
                case 1:
                    respostas[i]= this.Pergunta2.LastValue();
                    break;
                case 2:
                    respostas[i]= this.Pergunta3.LastValue();
                    break;
                case 3:
                    respostas[i]= this.Pergunta4.LastValue();
                    break;
                case 4:
                    respostas[i]= this.Pergunta5.LastValue();
                    break;
            }
        }
        return respostas; 
    }
    
    public Pergunta setPergunta() {
        System.out.println("Insira a questão:");
        Scanner sc = new Scanner(System.in);
        String questao = sc.nextLine();
        Pergunta temp = new Pergunta(questao);
        return temp;
    }
    
    public void responderPerguntas() {
        int valor;
        Scanner sc = new Scanner(System.in);
        for(int i=1; i<= this.quantidade; i++) {
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
    
    public void responderPerguntas(int[] respostas) {
        for(int i=0; i< respostas.length; i++) {
            switch(i) {
                
                case 0:
                    this.Pergunta1.Responder(respostas[i]);
                    break;
                    
                case 1:
                    this.Pergunta2.Responder(respostas[i]);
                    break;
                    
                case 2:
                    this.Pergunta3.Responder(respostas[i]);
                    break;
                    
                case 3:
                    this.Pergunta4.Responder(respostas[i]);
                    break;
                    
                case 4:
                    this.Pergunta5.Responder(respostas[i]);
                    break;
            }
        }
    }
    
    public int scan(Scanner sc, int start, int end) {
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
    
    public int getQuantidade() {
        return quantidade;
    }
    
    public Pergunta getPergunta(int i) {
        switch(i) {
            case 1:
                return Pergunta1;
            case 2:
                return Pergunta2;
            case 3:
                return Pergunta3;
            case 4:
                return Pergunta4;
            case 5:
                return Pergunta5;
            default:
                return null;
        }
    }
}
