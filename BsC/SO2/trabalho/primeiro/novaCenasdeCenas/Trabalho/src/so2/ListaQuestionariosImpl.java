package so2;

import java.io.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ListaQuestionariosImpl extends UnicastRemoteObject implements ListaQuestionarios, java.io.Serializable {

    boolean exists;
    ArrayList<Questionario> lista;
    
    
    public ListaQuestionariosImpl() throws java.rmi.RemoteException, Exception {
        loadQuest();
        if(!exists)
            lista = new ArrayList<>();
    }
    
    public int returnContador()throws java.rmi.RemoteException{
        return this.lista.size();
    }
    
    public void addQuestionario(Questionario x) throws java.rmi.RemoteException {
        lista.add(x);
    }
    
    public void respondeQuestionario(int numQuestionario, int[] respostas) throws java.rmi.RemoteException {
        lista.get(numQuestionario).responderPerguntas(respostas);
    }
    
    public void removeQuestionario(int numQuestionario) throws java.rmi.RemoteException {
        lista.remove(numQuestionario);
    }
    
    public String returnQuestionarioNome(int pos) throws java.rmi.RemoteException{
        Questionario temp =lista.get(pos);
        String nome = temp.getNome();
        return nome;
    }
    
    public Questionario returnQuestionario(int pos) throws java.rmi.RemoteException{
        return lista.get(pos);
    }
    
    public String listarQuestionarios() throws java.rmi.RemoteException {
        String resposta="";
        for(int i=0; i< this.lista.size(); i++){
            resposta+=(i+1) +" - " + lista.get(i).getNome();
            resposta+="\n";
        }
        return resposta;
    }
    
    public void writeQuest() {
        try {
            FileOutputStream fos = new FileOutputStream("Data.file");
            try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(lista);
            }
        } catch (Exception e) {
            System.err.println("Oops! Something went wrong while saving file!");
        }
    }
    
    public void loadQuest() {
        try {
            FileInputStream fis = new FileInputStream("Data.file");
            try (ObjectInputStream ois = new ObjectInputStream(fis)) {
                lista = new ArrayList<>((ArrayList<Questionario>) ois.readObject());
                exists = true;
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Oops! Something went wrong while loading the file!");
        }
    }
}