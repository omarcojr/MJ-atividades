package client;

import java.rmi.Naming;
import java.rmi.RemoteException;
import javax.swing.JOptionPane;
import servidor.InterfaceProduto;


public class IniciarClient {
    public static void main(String[] args){
        try{
          InterfaceProduto produtoRemoto = (InterfaceProduto) Naming.lookup("rmi:://127.0.0.1:1099/Produto");
            
          String string_descricao = JOptionPane.showInputDialog(null, "Qual produto quer cadastrar?", "Entrada de Dados", JOptionPane.QUESTION_MESSAGE);
          String string_preco = JOptionPane.showInputDialog(null, "Qual preço desse produto?", "Entrada de Dados", JOptionPane.QUESTION_MESSAGE);;
          String string_quantidade = JOptionPane.showInputDialog(null, "Qual a quantidade no estoque?", "Entrada de Dados", JOptionPane.QUESTION_MESSAGE);;
            
          String descricao = string_descricao;
          double preco = Double.parseDouble(string_preco);
          int quantidade = Integer.parseInt(string_quantidade);  
          
          produtoRemoto.setDescricao(descricao);
          produtoRemoto.setPreco(preco);
          produtoRemoto.setQuantidade(quantidade);
          
          String texto_retorno = "\nDescricao:"+produtoRemoto.getDescricao()
                  + "\nPreco:"+produtoRemoto.getPreco()
                  + "\nQuantidade:"+produtoRemoto.getQuantidade();

          
          JOptionPane.showMessageDialog(null, texto_retorno, "Dados do Produto", JOptionPane.INFORMATION_MESSAGE);
          
          
        }catch(RemoteException re){
            JOptionPane.showMessageDialog(null, "Erro Removo: "+re.toString(), "Erro Remoto", JOptionPane.WARNING_MESSAGE);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro Local: "+e.toString(), "Erro Local", JOptionPane.WARNING_MESSAGE);
        }
    }
}
