package so2;

import java.util.*;

public interface MainMenu extends java.rmi.Remote {

    public void toAdmin(String pass) throws java.rmi.RemoteException;

    public void listarComandos() throws java.rmi.RemoteException;
    
    public void listarQuestionarios() throws java.rmi.RemoteException;
    
    public void responderQuestionarios() throws java.rmi.RemoteException;
    
    public void criarQuestionario() throws java.rmi.RemoteException;
    
    public void apagarQuestionario() throws java.rmi.RemoteException;
    
    public void logoutAdmin() throws java.rmi.RemoteException;
    
    public void exitProgram() throws java.rmi.RemoteException;
    
    public void menu() throws java.rmi.RemoteException;

}