import com.sun.javafx.embed.EmbeddedSceneInterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by giuseppe on 17/12/15.
 */
public class Login extends JFrame{

    private JPanel JPanel1;
    private JLabel Lusuario;
    private JLabel Lclave;
    private JLabel Limagen;
    private JTextField Tusuario;
    private JPasswordField Tclave;
    private JButton Baceptar;
    private JButton BCancelar;

    public Login (){
        //Propiedades del login
        setTitle("Ingreso al sistema");
        setResizable(false);
        setSize(390,180);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Icon icon = new ImageIcon(getClass().getResource("/images/login.png"));

        //Creamos objetos del formulario
        Lusuario = new JLabel("Usuario: ");
        Tusuario = new JTextField(10);
        Lclave = new JLabel("Contraseña: ");
        Tclave = new JPasswordField(12);
        Baceptar = new JButton("Aceptar");
        BCancelar = new JButton("Cancelar");
        Limagen = new JLabel(icon);
        //Crear iconos
        //TODO https://youtu.be/MihOM3uK2fw?list=PLuEZQoW9bRnR4CbS0Q6SJbGIVfspUTT5Y&t=1417 Agregar los iconos siguiendo este link
        //Adiccionar objetos al formulario
        add(Lusuario);
        add(Tusuario);
        add(Lclave);
        add(Tclave);
        add(Baceptar);
        add(BCancelar);
        add(Limagen);

        Baceptar.setHorizontalTextPosition(SwingConstants.HORIZONTAL);
        Baceptar.setVerticalTextPosition(SwingConstants.BOTTOM);
        Baceptar.setToolTipText("Ingresa al sistema");

        BCancelar.setHorizontalTextPosition(SwingConstants.HORIZONTAL);
        BCancelar.setVerticalTextPosition(SwingConstants.BOTTOM);
        Baceptar.setToolTipText("Cancelar");

        //Ubica los objetos en el formulario

        Lusuario.setBounds(20,20,100,20);
        Tusuario.setBounds(120,20,100,20);
        Limagen.setBounds(300,20,64,64);

        Lclave.setBounds(20,45,100,20);
        Tclave.setBounds(120,45,100,20);

        Baceptar.setBounds(20,75,110,60);
        BCancelar.setBounds(150,75,120,60);

        Baceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = Tusuario.getText();
                String clave = String.valueOf(Tclave.getPassword());

                if (usuario.equals("giuseppe") && clave.equals("12345") ){
                    JOptionPane.showMessageDialog(null,"Bienvenido a ChocOS!");
                    setVisible(false);
                    Escritorio escritorio = new Escritorio();
                    escritorio.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    escritorio.setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Usuario o contraseña incorrecta");
                    Tusuario.setText("");
                    Tclave.setText("");
                    Tusuario.requestFocusInWindow();
                }
            }
        });

        BCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }

}
