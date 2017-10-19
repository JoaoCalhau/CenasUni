package so2;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Scanner;


public class ListaQuestionariosImpl extends UnicastRemoteObject implements ListaQuestionarios, java.io.Serializable {
    
    ArrayList<Questionario> lista;
    int contador;
    
    
    public ListaQuestionariosImpl() throws java.rmi.RemoteException {
        lista = new ArrayList<Questionario>();
        contador=0;
    }
    
    public void addQuestionario() throws java.rmi.RemoteException {
        Scanner sc = new Scanner(System.in);
        int quantidade = 0;
        while(quantidade>5 || quantidade <3){
            System.out.println("Insira valor válido: Entre 3 e 5 inclusive");
            try{
                quantidade = sc.nextInt();
            }
            catch(Exception e){
                System.out.println("Insira um Int válido entre 3 e 5");
                continue;
            }
        }
        Questionario novo = new Questionario(quantidade, ++contador);
        lista.add(novo);
        
    }
    
    public void respondeQuestionario(int numQuestionario) throws java.rmi.RemoteException {
        int pos = numQuestionario-1;
        if(pos > lista.size() || lista.size() == 0){
            System.out.println("Questionario com esse numero não existe");
        }
        else{
            lista.get(pos).responderPerguntas();
        }
        
    }
    
    public void removeQuestionario(int numQuestionario) throws java.rmi.RemoteException {
        //to do
    }
    
    public void listarQuestionarios() throws java.rmi.RemoteException {
        //to do
    }
}
