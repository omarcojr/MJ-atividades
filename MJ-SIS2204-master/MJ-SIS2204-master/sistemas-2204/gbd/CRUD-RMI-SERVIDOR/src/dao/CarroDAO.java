
package dao;
import classes.Carro;
import java.sql.Connection;
import java.sql.PreparedStatement;


public class CarroDAO {
    public static void insert(Carro carro){
        String sql = "INSERT INTO produto (modelo, marca, ano, placa) values(?,?,?,?)";
        
        try{
            Connection conexao = ConexaoDB.retornaConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, carro.getModelo());
            stmt.setString(2, carro.getMarca());
            stmt.setInt(3, carro.getAno());
            stmt.setString(4, carro.getPlaca());
            
            stmt.execute();
            
         
        }catch(Exception e){
            System.out.println("Erro na Função insert" +e.toString());
        }
    }
    public void update(){}
    public void delete(){}
    public void select(){}
    
}
