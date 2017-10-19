/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservas;

import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
/**
 *
 * @author joaoc
 */
public class reservasParaJantarImpl extends UnicastRemoteObject implements reservasParaJantar, java.io.Serializable{
   
    ArrayList<String> l = new ArrayList<String>();
    
    public reservasParaJantarImpl() throws java.rmi.RemoteException {
        super();
    }
    
    public void addReserve(String s) throws java.rmi.RemoteException {
        l.add(s);
    }
    
    public ArrayList<String> getListReserves() throws java.rmi.RemoteException {
        return l;
    }
    
    public int getNumReserves() throws java.rmi.RemoteException {
        return l.size();
    }
}
