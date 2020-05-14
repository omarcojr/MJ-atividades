
package dao;
import classes.Cardapio;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class CardapioDAO {
    public static void insert(Cardapio cardapio){
        String sql = "INSERT INTO produto (nome_prato, descprato, preco_prato, qtd_prato) values(?,?,?,?)";
        
        try{
            Connection conexao = ConexaoDB.retornaConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, cardapio.getNomePrato());
            stmt.setString(2, cardapio.getDescPrato());
            stmt.setDouble(3, cardapio.getPrecoPrato());
            stmt.setInt(4, cardapio.getQtdPrato());
            
            stmt.execute();
            
         
        }catch(Exception e){
            System.out.println("Erro na Função insert" +e.toString());
        }
    }
    public void update(){}
    public void delete(){}
    public void select(){}
    
}
