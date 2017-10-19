package so2;

public interface OperacoesDB extends java.rmi.Remote {
    public void addQuestionario(Questionario q) throws java.rmi.RemoteException ;
    public String returnQuestionarioNome(int pos) throws java.rmi.RemoteException;
    public Questionario returnQuestionario(int pos) throws java.rmi.RemoteException;
    public void respondeQuestionario(int numQ, int[] resp) throws java.rmi.RemoteException ;
    public void removeQuestionario(int numQ) throws java.rmi.RemoteException;
    public String listarQuestionarios() throws java.rmi.RemoteException;
    public int returnContador() throws java.rmi.RemoteException;
    public int returnCurr() throws java.rmi.RemoteException;
}
