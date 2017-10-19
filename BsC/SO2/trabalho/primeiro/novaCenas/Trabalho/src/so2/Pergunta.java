package so2;

import java.io.Serializable;
import java.util.ArrayList;

public class Pergunta implements Serializable {
    
    String questao;
    ArrayList<Integer> resposta;
    
    public Pergunta(String pergunta){
        this.questao = pergunta;
        resposta = new ArrayList<Integer>();
    }
    
    public void Responder(int valor){
        this.resposta.add(valor);
    }
    
    public String toString(){
        return this.questao;
    }
}
