package views;

import Interfaces.InterfaceCarro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.rmi.RemoteException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AdicionarCarro extends JPanel implements ActionListener {

    JTextField campo_modelo;
    JTextField campo_marca;
    JTextField campo_ano;
    JTextField campo_placa;

    JButton botao_salvar;
    
    public AdicionarCarro() {
        JLabel label_modelo = new JLabel("Modelo: ");
        campo_modelo = new JTextField(20);
        JLabel label_marca = new JLabel("Marca: ");
        campo_marca = new JTextField(20);
        JLabel label_ano = new JLabel("Ano: ");
        campo_ano = new JTextField(20);
        JLabel label_placa = new JLabel("Placa: ");
        campo_placa = new JTextField(20);

        botao_salvar = new JButton("Salvar");
        botao_salvar.addActionListener(this);

        add(label_modelo);
        add(campo_modelo);
        add(label_marca);
        add(campo_marca);
        add(label_ano);
        add(campo_ano);
        add(label_placa);
        add(campo_placa);

        add(botao_salvar);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {

        String Modelo = campo_modelo.getText();
        String Marca = campo_marca.getText();
        int Ano = Integer.parseInt(campo_ano.getText());
        String Placa = campo_placa.getText();

        try {
            InterfaceCarro carroRemoto = (InterfaceCarro) Naming.lookup("rmi://192.168.1.106:1099/Produto");

            carroRemoto.setModelo(Modelo);
            carroRemoto.setMarca(Marca);
            carroRemoto.setAno(Ano);
            carroRemoto.setPlaca(Placa);
            
            carroRemoto.adicionarCarro();

            String texto_retorno = "\nModelo: " + carroRemoto.getModelo() + "\nMarca: "
                    + carroRemoto.getMarca() + "\nAno: " + carroRemoto.getAno() + "\nPlaca: "
                    + carroRemoto.getPlaca();

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
