import javax.swing.*;

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

        //Creamos objetos del formulario
        Lusuario = new JLabel("Usuario: ");
        Tusuario = new JTextField(10);
        Lclave = new JLabel("Contraseña: ");
        Tclave = new JPasswordField(12);
        Baceptar = new JButton("Aceptar");
        BCancelar = new JButton("Cancelar");

        //Crear iconos
        //TODO https://youtu.be/MihOM3uK2fw?list=PLuEZQoW9bRnR4CbS0Q6SJbGIVfspUTT5Y&t=1417 Agregar los iconos siguiendo este link
        //Adiccionar objetos al formulario
        add(Lusuario);
        add(Tusuario);
        add(Lclave);
        add(Tclave);
        add(Baceptar);
        add(BCancelar);

        //Ubica los objetos en el formulario
        Lusuario.setBounds(20,20,100,20);
        Tusuario.setBounds(120,20,100,20);
        Lclave.setBounds(20,45,100,20);
        Tclave.setBounds(120,45,100,20);
        Baceptar.setBounds(20,75,90,60);
        BCancelar.setBounds(130,75,90,60);




    }

}
