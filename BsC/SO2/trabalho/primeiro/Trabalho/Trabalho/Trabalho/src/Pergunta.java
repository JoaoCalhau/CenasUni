import java.util.ArrayList;

public class Pergunta {
    
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
        StringBuilder sb = new StringBuilder();
        String s;
        s = "Q: " + questao;
        sb.append(s);
        for(int i = 0; i < resposta.size(); i++) {
            s = "A: " + resposta.get(i) + "\n";
            sb.append(s);
        }
        sb.append("\n");
        return sb.toString();
    }
}