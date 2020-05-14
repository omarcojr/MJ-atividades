
package dao;
import classes.Game;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class GameDAO {
    public static void insert(Game game){
        String sql = "INSERT INTO produto (nome_game, Developer, Genero) values(?,?,?)";
        
        try{
            Connection conexao = ConexaoDB.retornaConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, game.getNomeGame());
            stmt.setString(2, game.getDeveloper());
            stmt.setString(3, game.getGenero());
            
            stmt.execute();
            
         
        }catch(Exception e){
            System.out.println("Erro na Função insert" +e.toString());
        }
    }
    public void update(){}
    public void delete(){}
    public void select(){}
    
}
