/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author rober
 */
public interface InterfaceGame extends Remote{
    
    public String getNomeGame() throws RemoteException;
    public void setNomeGame(String NomeGame) throws RemoteException;
    public String getDeveloper() throws RemoteException;
    public void setDeveloper(String Developer) throws RemoteException;
    public String getGenero()  throws RemoteException;
    public void setGenero(String Genero) throws RemoteException;
    
}
