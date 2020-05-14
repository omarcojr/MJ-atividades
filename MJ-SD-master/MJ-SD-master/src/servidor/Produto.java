package servidor;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Produto extends UnicastRemoteObject implements InterfaceProduto{
    public String descricao;
    public double preco;
    public int quantidade;
    
    public Produto()throws RemoteException {
        System.out.print("a Classe produto está disponivel remotamente");
    }
    
    @Override
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    
    @Override
    public void setPreco(double preco){
        this.preco = preco;
    }
    
    @Override
    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }
    @Override
    public String getDescricao(){
        return this.descricao;
    }
    
    @Override
    public double getPreco(){
        return this.preco;
    }
    
    @Override
    public int getQuantidade(){
        return this.quantidade;
    }
    
}