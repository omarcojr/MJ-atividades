
package dao;

import classes.Aluno;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class AlunoDAO {
    public static void insert(Aluno aluno){
        String sql = "INSERT INTO produto (nome, turma, curso, matricula) values(?,?,?,?)";
        
        try{
            Connection conexao = ConexaoDB.retornaConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, aluno.getNomeAluno());
            stmt.setString(2, aluno.getTurma());
            stmt.setString(3, aluno.getCurso());
            stmt.setInt(4, aluno.getMatricula());
            
            stmt.execute();
            
         
        }catch(Exception e){
            System.out.println("Erro na Função insert" +e.toString());
        }
    }

    public void update(){}
    public void delete(){}
    public void select(){}
    
}
