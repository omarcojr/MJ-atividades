
package views;
import Interfaces.InterfaceCardapio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.rmi.RemoteException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class AdicionarCardapio extends JPanel implements ActionListener {

    JTextField campo_nome;
    JTextField campo_desc;
    JTextField campo_preco;
    JTextField campo_Qtd;

    JButton botao_salvar;
    
    
    public AdicionarCardapio() {
        JLabel label_nome = new JLabel("Nome: ");
        campo_nome = new JTextField(20);
        JLabel label_desc = new JLabel("descrição: ");
        campo_desc = new JTextField(20);
        JLabel label_preco = new JLabel("Preço: ");
        campo_preco = new JTextField(20);
        JLabel label_Qtd = new JLabel("Quantidade: ");
        campo_Qtd = new JTextField(20);

        botao_salvar = new JButton("Salvar");
        botao_salvar.addActionListener(this);

        add(label_nome);
        add(campo_nome);
        add(label_desc);
        add(campo_desc);
        add(label_preco);
        add(campo_preco);
        add(label_Qtd);
        add(campo_Qtd);

        add(botao_salvar);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {

        String NomePrato = campo_nome.getText();
        String DescPrato = campo_desc.getText();
        double PrecoPrato = Double.parseDouble(campo_preco.getText());
        int QtdPrato = Integer.parseInt(campo_Qtd.getText());

        try {
            InterfaceCardapio cardapioRemoto = (InterfaceCardapio) Naming.lookup("rmi://192.168.1.106:1099/Produto");

            cardapioRemoto.setNomePrato(NomePrato);
            cardapioRemoto.setDescPrato(DescPrato);
            cardapioRemoto.setPrecoPrato(PrecoPrato);
            cardapioRemoto.setQtdPrato(QtdPrato);
            
            cardapioRemoto.adicionarCardapio();

            String texto_retorno = "\nNome Prato: " + cardapioRemoto.getNomePrato() + "\ndescrição Prato: "
                    + cardapioRemoto.getDescPrato() + "\nPreço do Prato: " + cardapioRemoto.getPrecoPrato() + "\nQuantidade: "
                    + cardapioRemoto.getQtdPrato();

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
