package so2;

import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


public class ListaQuestionariosImpl extends UnicastRemoteObject implements ListaQuestionarios, java.io.Serializable {
    
    ArrayList<Questionario> lista;
    
    public ListaQuestionariosImpl() throws java.rmi.RemoteException {
        lista = new ArrayList<Questionario>();
    }
    
    public int returnContador()throws java.rmi.RemoteException {
        return this.lista.size();
    }
    
    public void addQuestionario(Questionario x) throws java.rmi.RemoteException {
        System.out.println("ta ca dentro??");
        lista.add(x);
    }
    
    public void respondeQuestionario(int numQuestionario) throws java.rmi.RemoteException {
        int pos = numQuestionario-1;
        if(pos > lista.size() || lista.size() == 0){
            System.out.println("Questionario com esse numero não existe");
        } else {
            lista.get(pos).responderPerguntas();
        }
    }
    
    public void removeQuestionario(int numQuestionario) throws java.rmi.RemoteException {
        lista.remove(numQuestionario);
    }
    
    public String returnQuestionarioNome(int pos) throws java.rmi.RemoteException {
        Questionario temp =lista.get(pos);
        String nome = temp.getNome();
        return nome;
    }
    
    public String listarQuestionarios() throws java.rmi.RemoteException {
        String resposta="";
        for(int i=0; i< this.lista.size(); i++) {
            resposta+=(i+1) +" - " + lista.get(i).getNome();
            resposta+="\n";
        }
        return resposta;
    }
}