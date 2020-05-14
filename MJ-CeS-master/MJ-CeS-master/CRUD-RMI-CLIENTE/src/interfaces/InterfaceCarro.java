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
public interface InterfaceCarro extends Remote{
    
    public String getModelo() throws RemoteException;
    public void setModelo(String Modelo) throws RemoteException;
    public String getMarca() throws RemoteException;
    public void setMarca(String Marca)throws RemoteException;
    public int getAno()throws RemoteException;
    public void setAno(int Ano)throws RemoteException;
    public String getPlaca() throws RemoteException;
    public void setPlaca(String Placa) throws RemoteException;
    
}
