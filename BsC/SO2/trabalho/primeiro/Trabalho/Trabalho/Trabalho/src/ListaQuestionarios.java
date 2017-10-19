import java.util.ArrayList;
import java.util.Scanner;


public class ListaQuestionarios {
    
    ArrayList<Questionario> lista;
    int contador;
    
    
    public ListaQuestionarios(){
        lista = new ArrayList<Questionario>();
        contador=0;
    }
    
    public void addQuestionario(){
        Scanner sc = new Scanner(System.in);
        int quantidade;
        System.out.println("Insira valor válido: Entre 3 e 5 inclusive");
        while(sc.hasNext()) {
            if(sc.hasNextInt()) {
                quantidade = sc.nextInt();
                if(quantidade > 2 && quantidade < 6) {
                    Questionario novo = new Questionario(quantidade, ++contador);
                    lista.add(novo);
                    System.out.println("Questionario adicionado!\n");
                    break;
                }
            } else {
                 System.out.println("Insira valor válido: Entre 3 e 5 inclusive");
                 sc.next();
            }
        }
    }
    
    public void respondeQuestionario(int numQuestionario) {
        int pos = numQuestionario-1;
        if(pos> lista.size()){
            System.out.println("Não existe um Questionario com esse nome\n");
        }
        else{
            lista.get(pos).responderPerguntas();
        }   
    }
    
    public String listarQuestionarios() {
        StringBuilder sb = new StringBuilder();
        String s;
        for(int i = 0; i < lista.size(); i++) {
            s = "Questionario nº" + i + "\n";
            sb.append(s + "\n");
            sb.append(lista.get(i).toString());
        }
        sb.append(sb.append("\n"));
        return sb.toString();
    }
}
