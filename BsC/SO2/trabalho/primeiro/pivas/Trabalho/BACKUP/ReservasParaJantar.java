package so2;

import java.util.*;

public interface ReservasParaJantar extends java.rmi.Remote {

    public void reservarNome(String s) throws java.rmi.RemoteException;

    public ArrayList<String> listaDeNomes() throws java.rmi.RemoteException;
    
    public int numeroReservas() throws java.rmi.RemoteException;

}
