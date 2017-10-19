package so2;

public interface ListaQuestionarios extends java.rmi.Remote {
    public void addQuestionario() throws java.rmi.RemoteException;
    public void respondeQuestionario(int numQuestionario) throws java.rmi.RemoteException;
    public void removeQuestionario(int numQuestionario) throws java.rmi.RemoteException;
    public void listarQuestionarios() throws java.rmi.RemoteException;
    
}
