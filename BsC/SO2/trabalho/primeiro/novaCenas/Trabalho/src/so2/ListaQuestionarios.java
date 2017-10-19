package so2;

import java.util.ArrayList;

public interface ListaQuestionarios extends java.rmi.Remote {
    public void addQuestionario(Questionario x) throws java.rmi.RemoteException ;
    public String returnQuestionarioNome(int pos) throws java.rmi.RemoteException;
    public int returnContador()throws java.rmi.RemoteException;
    public void respondeQuestionario(int numQuestionario) throws java.rmi.RemoteException;
    public void removeQuestionario(int numQuestionario) throws java.rmi.RemoteException;
    public String listarQuestionarios() throws java.rmi.RemoteException;
    
}
