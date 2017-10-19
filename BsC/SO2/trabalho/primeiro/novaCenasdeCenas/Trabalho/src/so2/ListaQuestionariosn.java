package so2;

public interface ListaQuestionariosn extends java.rmi.Remote {
    public void addQuestionario(Questionario x) throws java.rmi.RemoteException ;
    public String returnQuestionarioNome(int pos) throws java.rmi.RemoteException;
    public Questionario returnQuestionario(int pos) throws java.rmi.RemoteException;
    public void respondeQuestionario(int numQuestionario, int[] respostas) throws java.rmi.RemoteException ;
    public void removeQuestionario(int numQuestionario) throws java.rmi.RemoteException;
    public String listarQuestionarios() throws java.rmi.RemoteException;
    public void inserirBD(Questionario q) throws java.rmi.RemoteException;
    public void updateBD(int numQ, int[] resp) throws java.rmi.RemoteException;
    public void removerBD(int numQ) throws java.rmi.RemoteException;
    public int returnContador() throws java.rmi.RemoteException;
    public int returnCurr() throws java.rmi.RemoteException;
}