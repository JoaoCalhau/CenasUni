package so2;

/**
 * CLASSE DO OBJECTO REMOTO Tem a parte funcional... a implementação das
 * operações do serviço.
 */
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ReservasParaJantarImpl extends UnicastRemoteObject implements ReservasParaJantar, java.io.Serializable {
    
    ArrayList<String> lista = new ArrayList<String>();

    // deve existir um construtor
    public ReservasParaJantarImpl() throws java.rmi.RemoteException {
        super();
    }

    // ... e a implementacao de
    // cada metodo declarado na interface remota
    
    
    
    
    public void reservarNome(String s) throws java.rmi.RemoteException{
        lista.add(s);
        
    }
    
    public ArrayList<String> listaDeNomes() throws java.rmi.RemoteException{
        return this.lista;
    }
    
    public int numeroReservas() throws java.rmi.RemoteException{
        return this.lista.size();
    }

    

}
