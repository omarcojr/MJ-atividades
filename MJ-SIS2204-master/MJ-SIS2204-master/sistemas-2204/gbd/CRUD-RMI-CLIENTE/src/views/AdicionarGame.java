package views;

import Interfaces.InterfaceGame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.rmi.RemoteException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AdicionarGame extends JPanel implements ActionListener {
 
    JTextField campo_nome;
    JTextField campo_developer;
    JTextField campo_genero;

    JButton botao_salvar;
    
    public AdicionarGame() {
        JLabel label_nome = new JLabel("Nome: ");
        campo_nome = new JTextField(20);
        JLabel label_developer = new JLabel("Developer: ");
        campo_developer = new JTextField(20);
        JLabel label_genero = new JLabel("Genero: ");
        campo_genero = new JTextField(20);

        botao_salvar = new JButton("Salvar");
        botao_salvar.addActionListener(this);

        add(label_nome);
        add(campo_nome);
        add(label_developer);
        add(campo_developer);
        add(label_genero);
        add(campo_genero);

        add(botao_salvar);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {

        String NomeGame = campo_nome.getText();
        String Developer = campo_developer.getText();
        String Genero = campo_genero.getText();

        try {
            InterfaceGame gameRemoto = (InterfaceGame) Naming.lookup("rmi://192.168.1.106:1099/Produto");

            gameRemoto.setNomeGame(NomeGame);
            gameRemoto.setDeveloper(Developer);
            gameRemoto.setGenero(Genero);
            
            gameRemoto.adicionarGame();

            String texto_retorno = "\nNome do jogo: " + gameRemoto.getNomeGame() + "\nDeveloper: "
                    + gameRemoto.getDeveloper() + "\nGenero: " + gameRemoto.getGenero();

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
