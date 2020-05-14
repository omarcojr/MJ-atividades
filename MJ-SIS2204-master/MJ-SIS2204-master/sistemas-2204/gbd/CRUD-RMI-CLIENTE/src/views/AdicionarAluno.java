package views;

import Interfaces.InterfaceAluno;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.rmi.RemoteException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AdicionarAluno extends JPanel implements ActionListener {

    JTextField campo_nome;
    JTextField campo_turma;
    JTextField campo_curso;
    JTextField campo_matricula;

    JButton botao_salvar;
    
    public AdicionarAluno() {
        JLabel label_nome = new JLabel("Nome: ");
        campo_nome = new JTextField(20);
        JLabel label_turma = new JLabel("Turma: ");
        campo_turma = new JTextField(20);
        JLabel label_curso = new JLabel("Quantidade: ");
        campo_curso = new JTextField(20);
        JLabel label_matricula = new JLabel("Matricula: ");
        campo_matricula = new JTextField(20);

        botao_salvar = new JButton("Salvar");
        botao_salvar.addActionListener(this);

        add(label_nome);
        add(campo_nome);
        add(label_turma);
        add(campo_turma);
        add(label_curso);
        add(campo_curso);
        add(label_matricula);
        add(campo_matricula);

        add(botao_salvar);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {

        String NomeAluno = campo_nome.getText();
        String Turma = campo_turma.getText();
        String Curso = campo_curso.getText();
        int Matricula = Integer.parseInt(campo_matricula.getText());

        try {
            InterfaceAluno alunoRemoto = (InterfaceAluno) Naming.lookup("rmi://192.168.1.106:1099/Produto");

            alunoRemoto.setNomeAluno(NomeAluno);
            alunoRemoto.setTurma(Turma);
            alunoRemoto.setCurso(Curso);
            alunoRemoto.setMatricula(Matricula);
            
            alunoRemoto.adicionarAluno();

            String texto_retorno = "\nNome: " + alunoRemoto.getNomeAluno() + "\nTurma: "
                    + alunoRemoto.getTurma() + "\nCurso: " + alunoRemoto.getCurso() + "\nMatricula: "
                    + alunoRemoto.getMatricula();

            JOptionPane.showMessageDialog(null, texto_retorno, "Dados do Produto", JOptionPane.INFORMATION_MESSAGE);
        } catch (RemoteException re) {
            JOptionPane.showMessageDialog(null, "Erro remoto: " + re.toString(), "Erro remoto",
                    JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro local: " + e.toString(), "Erro local",
                    JOptionPane.WARNING_MESSAGE);
        }

    }
    
}
