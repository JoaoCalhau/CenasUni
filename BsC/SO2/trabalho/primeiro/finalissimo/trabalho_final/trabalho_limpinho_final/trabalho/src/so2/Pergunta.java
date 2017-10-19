package so2;

import java.io.Serializable;

public class Pergunta implements Serializable {
    
    String questao;
    int resposta, ultimaResp, tamanho;
    
    /**
     * Construtor que inicializa um novo objecto
     * Pergunta com o nome passado por argumento
     * e todos os restantes a 0
     * 
     * @param pergunta 
     */
    public Pergunta(String pergunta) {
        this.questao = pergunta;
        resposta = 0;
        ultimaResp = 0;
        tamanho = 0;
    }
    
    /**
     * Construtor que inicializa um novo objecto
     * Pergunta com o nome passado por argumento
     * e o total de respostas e as vezes que foi 
     * respondido com os restantes 2 argumentos
     * 
     * @param q
     * @param r
     * @param t 
     */
    public Pergunta(String q, int r, int t) {
        questao = q;
        resposta = r;
        tamanho = t;
        ultimaResp = 0;
    }
    
    /**
     * Metodo que adiciona o valor respondido ao valor total
     * da pergunta
     * 
     * @param valor 
     */
    public void Responder(int valor) {
        resposta += valor;
        ultimaResp = valor;
        tamanho++;
    }
    
    /**
     * Metodo que retorna o ultimo valor a ser respondido
     * 
     * @return 
     */
    public int LastValue() {
        return ultimaResp;
    }
    
    /**
     * Metodo que retorna a media da Pergunta
     * 
     * @return 
     */
    public float Media() {
        return (float)resposta / (float)tamanho;
    }
    
    /**
     * Metodo que retorna o nome da Pergunta
     * 
     * @return 
     */
    public String Nome() {
        return questao;
    }
    
    /**
     * Metodo que retorna a quantidade de vezes que a resposta
     * foi respondida
     * 
     * @return 
     */
    public int quantRespostas() {
        return tamanho;
    }
    
    
    @Override
    public String toString() {
        return this.questao;
    }
    
}
