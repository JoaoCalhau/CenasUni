package so2;

import java.io.Serializable;

public class Pergunta implements Serializable {
    
    String questao;
    int resposta, ultimaResp, tamanho;
    
    
    public Pergunta(String pergunta) {
        this.questao = pergunta;
        resposta = 0;
        ultimaResp = 0;
        tamanho = 0;
        
    }
    
    public Pergunta(String q, int r, int t) {
        questao = q;
        resposta = r;
        tamanho = t;
        ultimaResp = 0;
    }
    
    public void Responder(int valor) {
        resposta += valor;
        ultimaResp = valor;
        tamanho++;
        
    }
    
    public int LastValue() {
        return ultimaResp;
    }
    
    public float Media() {
        return (float)resposta / (float)tamanho;
    }
    
    public String Nome() {
        return questao;
    }
    
    public int quantRespostas() {
        return tamanho;
    }
    
    
    @Override
    public String toString() {
        return this.questao;
    }
    
}
