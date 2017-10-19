/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservas;

import java.util.ArrayList;
/**
 *
 * @author joaoc
 */
public interface reservasParaJantar extends java.rmi.Remote {
       public void addReserve(String s) throws java.rmi.RemoteException;
       public ArrayList<String> getListReserves() throws java.rmi.RemoteException;
       public int getNumReserves() throws java.rmi.RemoteException;
}
