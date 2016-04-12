package modelos;

import com.sun.javafx.fxml.builder.JavaFXSceneBuilder;

import javax.swing.*;
import java.awt.*;

/**
 * Created by giuseppe on 10/04/16.
 */
public class DiscoFrame extends JFrame {
    private JPanel PMatriz;
    private JTable PTable;
    private JScrollPane PScrollpane;
    private JLabel J1,J2,J3,J4,J5,J6,J7,J8,J9,J10,J11,J12,J13,J14,J15,J16,J17,J18,J20,J21,J22,J23,J24,J25;

    public DiscoFrame() {

        setTitle("Choc-os");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(400,400);
        setLayout(new GridLayout(2,1));
        PMatriz = new JPanel(new GridLayout(5,5));
        DeclararLabels();
        DeclararTabla();
    }

    private void DeclararTabla() {
        PTable = new JTable();
        add(PTable);
    }

    private void DeclararLabels() {
        JLabel J1 = new JLabel("");
        JLabel J2 = new JLabel("");
        JLabel J3 = new JLabel("");
        JLabel J4 = new JLabel("");
        JLabel J5 = new JLabel("");
        JLabel J6 = new JLabel("");
        JLabel J7 = new JLabel("");
        JLabel J8 = new JLabel("");
        JLabel J9 = new JLabel("");
        JLabel J10 = new JLabel("");
        JLabel J11 = new JLabel("");
        JLabel J12 = new JLabel("");
        JLabel J13 = new JLabel("");
        JLabel J14 = new JLabel("");
        JLabel J15 = new JLabel("");
        JLabel J16 = new JLabel("");
        JLabel J17 = new JLabel("");
        JLabel J18 = new JLabel("");
        JLabel J19 = new JLabel("");
        JLabel J20 = new JLabel("");
        JLabel J21 = new JLabel("");
        JLabel J22 = new JLabel("");
        JLabel J23 = new JLabel("");
        JLabel J24 = new JLabel("");
        JLabel J25 = new JLabel("");

        J1.setBackground(Color.GREEN);
        J2.setBackground(Color.GREEN);
        J3.setBackground(Color.GREEN);
        J4.setBackground(Color.GREEN);
        J5.setBackground(Color.GREEN);
        J6.setBackground(Color.GREEN);
        J7.setBackground(Color.GREEN);
        J8.setBackground(Color.GREEN);
        J9.setBackground(Color.GREEN);
        J10.setBackground(Color.GREEN);
        J11.setBackground(Color.GREEN);
        J12.setBackground(Color.GREEN);
        J13.setBackground(Color.GREEN);
        J14.setBackground(Color.GREEN);
        J15.setBackground(Color.GREEN);
        J16.setBackground(Color.GREEN);
        J17.setBackground(Color.GREEN);
        J18.setBackground(Color.GREEN);
        J19.setBackground(Color.GREEN);
        J20.setBackground(Color.GREEN);
        J21.setBackground(Color.GREEN);
        J22.setBackground(Color.GREEN);
        J23.setBackground(Color.GREEN);
        J24.setBackground(Color.GREEN);
        J25.setBackground(Color.GREEN);

        PMatriz.add(J1);
        PMatriz.add(J2);
        PMatriz.add(J3);
        PMatriz.add(J4);
        PMatriz.add(J5);
        PMatriz.add(J6);
        PMatriz.add(J7);
        PMatriz.add(J8);
        PMatriz.add(J9);
        PMatriz.add(J10);
        PMatriz.add(J11);
        PMatriz.add(J12);
        PMatriz.add(J13);
        PMatriz.add(J14);
        PMatriz.add(J15);
        PMatriz.add(J16);
        PMatriz.add(J17);
        PMatriz.add(J18);
        PMatriz.add(J19);
        PMatriz.add(J20);
        PMatriz.add(J21);
        PMatriz.add(J22);
        PMatriz.add(J23);
        PMatriz.add(J24);
        PMatriz.add(J25);

    }
}
