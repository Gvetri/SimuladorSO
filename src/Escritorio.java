import modelos.Celda;
import modelos.DiscoFrame;
import modelos.Proceso;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

/**
 * Created by giuseppe on 21/03/16.
 */
public class Escritorio extends JFrame {
    private JPanel panel_disco;
    private JButton JButtonAndroid;
    private JLabel LAndroidstudio;

    private JButton JButtonGenymotion;
    private JLabel JGenymotion;

    private JButton JButtonFirefox;
    private JLabel JFirefox;

    private JPanel panel_procesos;
    private DiscoFrame frame_disco = new DiscoFrame();

    private JTable table;
    private JScrollPane Jscroll;
    private JLabel Ltitulo_adm;

    private JButton BIniciar,BMatar,BBloquear,BAlgoritmos;

    private JProgressBar PBram,PBcpu,PBdisco;

    private ImageIcon Img_cpu,Img_ram,Img_hdd,Img_monitor,img_keyboard,img_music,img_mic,img_mouse,img_usb,img_impresora;
    private JButton JImgcpu,JImgram,Jimg_hdd,Jimg_monitor,Jimg_keyboard,Jimg_music,Jimg_mic,Jimg_mouse,Jimg_usb,Jimg_impresora;
    private JLabel Jlabelcpu,Jlabelram,Jlabelhdd;
    private JButton Bdisco;
    private ArrayList<Proceso> lista_procesos;
    private DefaultTableModel tableModel,tableModel_disco;
    private Thread hilo_proceso = new Thread();
    private Thread hilo_bloqueo = new Thread();
    private Thread hilo_listo = new Thread();

    //Elementos del panel de disco

    private JPanel PMatriz;
    private JTable PTable;
    private JScrollPane PScrollpane;
    private JLabel J1,J2,J3,J4,J5,J6,J7,J8,J9,J10,J11,J12,J13,J14,J15,J16,J17,J18,J19,J20,J21,J22,J23,J24,J25;
    private ArrayList<Celda> lista_disco;
    private Thread hilo_cscan;
    private Integer bandera_salida = 0;
    private Thread hilo_scan;
    private int bTerminado;

    public Escritorio (){

        //Declaracion de el JFrame
        setTitle("Choc-OS");
        setResizable(true);
        setSize(800,800);
        //setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Declaracion de los elementos dentro del JFrame
        LAndroidstudio = new JLabel("Android studio");

        ImageIcon android_studio = new ImageIcon(getClass().getResource("/images/studio.png"));
        ImageIcon genymotion = new ImageIcon(getClass().getResource("/images/icon.png"));
        ImageIcon firefox = new ImageIcon(getClass().getResource("/images/firefox.png"));



        //Declaracion de Atributos de los elementos
        JButtonAndroid = new JButton(android_studio);
        JButtonAndroid.setBorder(BorderFactory.createEmptyBorder());
        JButtonAndroid.setBorderPainted(false);
        JButtonAndroid.setFocusPainted(false);
        JButtonAndroid.setContentAreaFilled(false);

        JButtonGenymotion = new JButton(genymotion);
        JButtonGenymotion.setBorder(BorderFactory.createEmptyBorder());
        JButtonGenymotion.setBorderPainted(false);
        JButtonGenymotion.setFocusPainted(false);
        JButtonGenymotion.setContentAreaFilled(false);

        JButtonFirefox = new JButton(firefox);
        JButtonFirefox.setBorder(BorderFactory.createEmptyBorder());
        JButtonFirefox.setBorderPainted(false);
        JButtonFirefox.setFocusPainted(false);
        JButtonFirefox.setContentAreaFilled(false);

        panel_procesos = new JPanel();
        panel_procesos.setLayout(new GridLayout(6,1,5,5));
        panel_procesos.setEnabled(true);
        panel_procesos.setBorder(BorderFactory.createEmptyBorder());

        panel_disco = new JPanel();
        panel_disco.setLayout(new GridLayout(3,1,3,3));
        panel_disco.setEnabled(true);
        panel_disco.setBorder(BorderFactory.createEmptyBorder());


        Rellenar_panel();
        JLabel titulo = new JLabel("Disco Duro");
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        panel_disco.add(titulo);

        Rellenar_panel_disco();




        //Declaracion para agregar elementos al JFrame
        add(JButtonAndroid);
        JButtonAndroid.setToolTipText("Android studio");
        add(LAndroidstudio);
        add(JButtonGenymotion);
        add(JButtonFirefox);
        add(panel_procesos);
        add(panel_disco);

        //Declaracion para establecer los elementos dentro del JFrame
        JButtonAndroid.setBounds(50,50,128,128);
        LAndroidstudio.setBounds(20,20,60,60);
        JButtonGenymotion.setBounds(50,300,128,128);
        JButtonFirefox.setBounds(50,500,128,128);
        panel_procesos.setBounds(800,50,500,600);

        panel_disco.setBounds(250,50,500,400);



        //Establecer fondo
        try {
            BufferedImage im = ImageIO.read(new File(getClass().getResource("/images/fondo.jpg").toURI()));
            BackgroundPane background = new BackgroundPane(im);
            add(background);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        AsignarLabels();

    }

    private void CScan() {
         hilo_cscan = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i <= 25; i++){

                    switch (i) {
                        case 1:
                            J25.setBackground(Color.green);
                            J1.setBackground(Color.black);
                            break;
                        case 2:
                            J1.setBackground(Color.green);
                            J2.setBackground(Color.black);
                            break;
                        case 3:
                            J2.setBackground(Color.green);
                            J3.setBackground(Color.black);
                            break;
                        case 4:
                            J3.setBackground(Color.green);
                            J4.setBackground(Color.black);
                            break;
                        case 5:
                            J4.setBackground(Color.green);
                            J5.setBackground(Color.black);
                            break;
                        case 6:
                            J5.setBackground(Color.green);
                            J6.setBackground(Color.black);
                            break;
                        case 7:
                            J6.setBackground(Color.green);
                            J7.setBackground(Color.black);
                            break;
                        case 8:
                            J7.setBackground(Color.green);
                            J8.setBackground(Color.black);
                            break;
                        case 9:
                            J8.setBackground(Color.green);
                            J9.setBackground(Color.black);
                            break;
                        case 10:
                            J9.setBackground(Color.green);
                            J10.setBackground(Color.black);
                            break;
                        case 11:
                            J10.setBackground(Color.green);
                            J11.setBackground(Color.black);
                            break;
                        case 12:
                            J11.setBackground(Color.green);
                            J12.setBackground(Color.black);
                            break;
                        case 13:
                            J12.setBackground(Color.green);
                            J13.setBackground(Color.black);
                            break;
                        case 14:
                            J13.setBackground(Color.green);
                            J14.setBackground(Color.black);
                            break;
                        case 15:
                            J14.setBackground(Color.green);
                            J15.setBackground(Color.black);
                            break;
                        case 16:
                            J15.setBackground(Color.green);
                            J16.setBackground(Color.black);
                            break;
                        case 17:
                            J16.setBackground(Color.green);
                            J17.setBackground(Color.black);
                            break;
                        case 18:
                            J17.setBackground(Color.green);
                            J18.setBackground(Color.black);
                            break;
                        case 19:
                            J18.setBackground(Color.green);
                            J19.setBackground(Color.black);
                            break;
                        case 20:
                            J19.setBackground(Color.green);
                            J20.setBackground(Color.black);
                            break;
                        case 21:
                            J20.setBackground(Color.green);
                            J21.setBackground(Color.black);
                            break;
                        case 22:
                            J21.setBackground(Color.green);
                            J22.setBackground(Color.black);
                            break;
                        case 23:
                            J22.setBackground(Color.green);
                            J23.setBackground(Color.black);
                            break;
                        case 24:
                            J23.setBackground(Color.green);
                            J24.setBackground(Color.black);
                            break;
                        case 25:
                            J24.setBackground(Color.green);
                            J25.setBackground(Color.black);
                            break;
                        default:
                            J1.setBackground(Color.black);
                            break;
                    }

                    try {
                        hilo_cscan.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                if (bandera_salida == 0){
                    bandera_salida++;
                    CScan();
                }

            }
        });

        hilo_cscan.start();
    }

    private void AsignarLabels() {
        J1.setText(String.valueOf(lista_disco.get(0).getId_proceso()));
        J2.setText(String.valueOf((lista_disco.get(1).getId_proceso())));
        J3.setText(String.valueOf((lista_disco.get(2).getId_proceso())));
        J4.setText(String.valueOf((lista_disco.get(3).getId_proceso())));
        J5.setText(String.valueOf((lista_disco.get(4).getId_proceso())));
        J6.setText(String.valueOf((lista_disco.get(5).getId_proceso())));
        J7.setText(String.valueOf((lista_disco.get(6).getId_proceso())));
        J8.setText(String.valueOf((lista_disco.get(7).getId_proceso())));
        J9.setText(String.valueOf((lista_disco.get(8).getId_proceso())));
        J10.setText(String.valueOf((lista_disco.get(9).getId_proceso())));
        J11.setText(String.valueOf((lista_disco.get(10).getId_proceso())));
        J12.setText(String.valueOf((lista_disco.get(11).getId_proceso())));
        J13.setText(String.valueOf((lista_disco.get(12).getId_proceso())));
        J14.setText(String.valueOf((lista_disco.get(13).getId_proceso())));
        J15.setText(String.valueOf((lista_disco.get(14).getId_proceso())));
        J16.setText(String.valueOf((lista_disco.get(15).getId_proceso())));
        J17.setText(String.valueOf((lista_disco.get(16).getId_proceso())));
        J18.setText(String.valueOf((lista_disco.get(17).getId_proceso())));
        J19.setText(String.valueOf((lista_disco.get(18).getId_proceso())));
        J20.setText(String.valueOf((lista_disco.get(19).getId_proceso())));
        J21.setText(String.valueOf((lista_disco.get(20).getId_proceso())));
        J22.setText(String.valueOf((lista_disco.get(21).getId_proceso())));
        J23.setText(String.valueOf((lista_disco.get(22).getId_proceso())));
        J24.setText(String.valueOf((lista_disco.get(23).getId_proceso())));
        J25.setText(String.valueOf((lista_disco.get(24).getId_proceso())));




    }

    private void Rellenar_panel_disco() {
        PMatriz = new JPanel(new GridLayout(5,5));
        DeclararLabels_Disco();
        DeclararTabla_Disco();
        panel_disco.add(PMatriz);

    }

    private void  DeclararTabla_Disco() {
        Object columnNamess[] = { "ID Celda", "Id Proceso "};
        tableModel_disco = new DefaultTableModel(columnNamess,0);
        lista_disco = LlenarTablaDisco();

        for (int i = 0; i < lista_disco.size(); i++){
            int id_celda = lista_disco.get(i).getId_celda();
            int id_proceso = lista_disco.get(i).getId_proceso();

            Object[] data_disco = {id_celda,id_proceso};
            tableModel_disco.addRow(data_disco);
        }
        PTable = new JTable(tableModel_disco);
        PScrollpane = new JScrollPane(PTable);
        Dimension d = new Dimension(400,800);
        PScrollpane.setMinimumSize(d);
        PScrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        panel_disco.add(PScrollpane);

    }

    private ArrayList<Celda> LlenarTablaDisco() {
        ArrayList<Celda> lista_celda = new ArrayList<>();
        //TODO hacer que los id de procesos de las celdas sean iguales a los de la lista procesos usando lista_procesos.get(i).getID
        for(int i = 0;i<25;i++){
            Celda celda = new Celda(idrandom_celda(),idrandom_celda());
            lista_celda.add(celda);
            System.out.println("Creada celda ID celda: "+lista_celda.get(i).getId_celda()+"ID proceso: "+lista_celda.get(i).getId_proceso());
        }
        return lista_celda;
    }

    private int idrandom_celda() {
        Random random = new Random();
        Integer id_random = random.nextInt(25)+1;
        return id_random;
    }

    private void DeclararLabels_Disco() {
            J1 = new JLabel("holi");
            J2 = new JLabel("2");
            J3 = new JLabel("3");
            J4 = new JLabel("4");
            J5 = new JLabel("5");
            J6 = new JLabel("6");
            J7 = new JLabel("7");
            J8 = new JLabel("8");
            J9 = new JLabel("9");
            J10 = new JLabel("sda");
             J11 = new JLabel("asd");
             J12 = new JLabel("s");
             J13 = new JLabel("d");
             J14 = new JLabel("4");
             J15 = new JLabel("6");
             J16 = new JLabel("4");
             J17 = new JLabel("7");
             J18 = new JLabel("2");
             J19 = new JLabel("f");
             J20 = new JLabel("t");
             J21 = new JLabel("h");
             J22 = new JLabel("j");
             J23 = new JLabel("k");
            J24 = new JLabel("w");
            J25 = new JLabel("q");

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

            J1.setOpaque(true);
            J2.setOpaque(true);
            J3.setOpaque(true);
            J4.setOpaque(true);
            J5.setOpaque(true);
            J6.setOpaque(true);
            J7.setOpaque(true);
            J8.setOpaque(true);
            J9.setOpaque(true);
            J10.setOpaque(true);
            J11.setOpaque(true);
            J12.setOpaque(true);
            J13.setOpaque(true);
            J14.setOpaque(true);
            J15.setOpaque(true);
            J16.setOpaque(true);
            J17.setOpaque(true);
            J18.setOpaque(true);
            J19.setOpaque(true);
            J20.setOpaque(true);
            J21.setOpaque(true);
            J22.setOpaque(true);
            J23.setOpaque(true);
            J24.setOpaque(true);
            J25.setOpaque(true);



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

    private void Rellenar_panel() {

        //Agregamos el titulo
        Ltitulo_adm = new JLabel("Administrador de procesos");
        Ltitulo_adm.setHorizontalAlignment(SwingConstants.CENTER);

        panel_procesos.add(Ltitulo_adm);



        lista_procesos =  LlenarTabla();
        Object columnNames[] = { "ID Proceso", "Nombre", "Memoria","Quantum","Prioridad","Tipo","Estado","tiempo","CPU"};

        JButtonAndroid.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(JButtonAndroid, "Se ha iniciado el proceso <Android Studio>.");
                Integer id_random = idrandom();
                Float id_quantum = idquantum();
                Proceso android_studio_p = new Proceso(id_random,3,"CPU",700,id_quantum,"Android Studio","nuevo",700);
                lista_procesos.add(android_studio_p);
                Ingresar(android_studio_p);
            }
        });

        JButtonGenymotion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(JButtonGenymotion, "Se ha iniciado el proceso <GenyMotion>.");
                Integer id_random = idrandom();
                Float id_quantum = idquantum();
                Proceso genymotion_p = new Proceso(id_random,3,"CPU",500,id_quantum,"Genymotion","nuevo",800);
                lista_procesos.add(genymotion_p);
                Ingresar(genymotion_p);
            }
        });

        JButtonFirefox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(JButtonFirefox, "Se ha iniciado el proceso <Firefox>.");
                Integer id_random = idrandom();
                Float id_quantum = idquantum();
                Proceso firefox_p = new Proceso(id_random,3,"CPU",350,id_quantum,"Firefox","nuevo",400);
                lista_procesos.add(firefox_p);
                Ingresar(firefox_p);
            }
        });

        tableModel = new DefaultTableModel(columnNames,0);

        for (int i = 0; i < lista_procesos.size(); i++){
            int id = lista_procesos.get(i).getId();
            int prioridad = lista_procesos.get(i).getPrioridad();
            String tipo_proceso = lista_procesos.get(i).gettipo_proceso();
            float memoria = lista_procesos.get(i).getMemoria();
            float quantum = lista_procesos.get(i).getQuantum();
            String nombre = lista_procesos.get(i).getNombre();
            String estado = lista_procesos.get(i).getEstado();
            int cpu = lista_procesos.get(i).getCpu();

            Object[] data = {id,nombre,memoria,quantum,prioridad,tipo_proceso,estado,0,cpu};
            tableModel.addRow(data);
        }


        table = new JTable(tableModel);

        Jscroll = new JScrollPane(table);
        Dimension d = new Dimension(400,800);
        Jscroll.setMinimumSize(d);
        Jscroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        panel_procesos.add(Jscroll);

        //Agregamos los botones
        BIniciar = new JButton("Iniciar");
        BMatar = new JButton("Matar");
        BBloquear = new JButton("Bloquear");
        BAlgoritmos = new JButton("Algoritmos");
        Bdisco = new JButton("Disco");

        //Crea un panel de gridbag para los botones y luego agregarlo al panel anterior

         JPanel panel_botones = new JPanel();
        panel_botones.setLayout(new GridLayout(1,5,1,1));

        BIniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String proceso_nombre = JOptionPane.showInputDialog(BIniciar,"Inserte nombre del proceso");
                String proceso_memoria = JOptionPane.showInputDialog(BIniciar,"Inserte cantidad de memoria");
                String proceso_quantum = JOptionPane.showInputDialog(BIniciar,"Inserte Quantum");
                String proceso_cpu_s = JOptionPane.showInputDialog(BIniciar,"Inserte cantidad de CPU ");
                float proceso_memoria_float = Float.parseFloat(proceso_memoria);
                float proceso_quantum_float= Float.parseFloat(proceso_quantum);
                Integer cpu = Integer.valueOf(proceso_cpu_s);
                Integer id_random = idrandom();

                Proceso proceso_iniciado = new Proceso(id_random,3,"CPU",proceso_memoria_float,proceso_quantum_float,proceso_nombre,"nuevo",cpu);
                lista_procesos.add(proceso_iniciado);
                Ingresar(proceso_iniciado);

                Thread hilo = new Thread();
                try {
                    Thread.sleep(10000);
                    proceso_iniciado.setEstado("listo");
                    lista_procesos.add(proceso_iniciado);
                    Ingresar(proceso_iniciado);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }


            }
        });

        BMatar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer id_proceso = Integer.valueOf(JOptionPane.showInputDialog("Ingrese el ID del proceso"));
                MatarProcesos(id_proceso);
            }
        });

        BBloquear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer id_proceso = Integer.valueOf(JOptionPane.showInputDialog("Ingrese el ID del proceso"));
                BloquearProceso(id_proceso);
            }
        });

        BAlgoritmos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] options = new String[] {"FIFO", "RoundRobin", "Scan", "CSCAN"};
                int response = JOptionPane.showOptionDialog(null, "Message", "Title",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                        null, options, options[0]);
                if(response == 0){
                    System.out.println("Opcion FIFO");
                    Fifo();
                }
                else if(response == 1){
                    System.out.println("Opcion RoundRobin");
                    //TODO Implementar RoundRobin
                }
                else if(response == 2){
                    System.out.println("Opcion SCAN");
                    Scan();
                }
                else if(response == 3){
                    System.out.println("Opcion CSCAN");
                    CScan();
                }
                else{
                    System.out.println("Se cerro el dialog o algo inesperado ha ocurrido :( ");
                }
            }
        });
        panel_botones.add(BIniciar);
        panel_botones.add(BMatar);
        panel_botones.add(BBloquear);
        panel_botones.add(BAlgoritmos);
//        panel_botones.add(Bdisco);
        panel_procesos.add(panel_botones);


        //Agregamos las barras de progreso
        Color foreground = new Color(184,69,0);
        Color fondo = new Color(0,0,0);

        PBcpu = new JProgressBar();
        PBcpu.setBackground(fondo);
        PBcpu.setForeground(foreground);
        PBcpu.setToolTipText("CPU");
        PBcpu.setBorderPainted(false);
        PBcpu.setStringPainted(true);
        PBcpu.setMaximum(2000);
        PBcpu.setMinimum(0);
        PBcpu.setMaximumSize(new Dimension(3,10));

        PBdisco = new JProgressBar();
        PBdisco.setBackground(fondo);
        PBdisco.setForeground(foreground);
        PBdisco.setToolTipText("Disco");
        PBdisco.setBorderPainted(false);
        PBdisco.setStringPainted(true);
        PBdisco.setMaximum(32000);
        PBdisco.setMinimum(0);
        PBdisco.setMaximumSize(new Dimension(3,10));

        PBram = new JProgressBar();
        PBram.setBackground(fondo);
        PBram.setForeground(foreground);
        PBram.setToolTipText("Disco");
        PBram.setBorderPainted(false);
        PBram.setStringPainted(true);
        PBram.setMaximum(4000);
        PBram.setMinimum(0);
        PBdisco.setMaximumSize(new Dimension(3,10));

        //TODO hacer funcionar las barras
        //Crea un panel de gridbag para los botones y luego agregarlo al panel anterior
        JPanel panel_barras = new JPanel();
        panel_barras.setLayout(new GridLayout(3,3,5,5));


        panel_barras.add(PBcpu);
        panel_barras.add(PBram);
        panel_barras.add(PBdisco);

        Img_cpu = new ImageIcon(getClass().getResource("/images/computer.png"));
        Img_ram = new ImageIcon(getClass().getResource("/images/computer-1.png"));
        Img_hdd = new ImageIcon(getClass().getResource("/images/computer-2.png"));

        JImgcpu = new JButton(Img_cpu);
        JImgcpu.setBorder(BorderFactory.createEmptyBorder());
        JImgcpu.setBorderPainted(false);
        JImgcpu.setFocusPainted(false);
        JImgcpu.setContentAreaFilled(false);

        JImgram = new JButton(Img_ram);
        JImgram.setBorder(BorderFactory.createEmptyBorder());
        JImgram.setBorderPainted(false);
        JImgram.setFocusPainted(false);
        JImgram.setContentAreaFilled(false);

        Jimg_hdd = new JButton(Img_hdd);
        Jimg_hdd.setBorder(BorderFactory.createEmptyBorder());
        Jimg_hdd.setBorderPainted(false);
        Jimg_hdd.setFocusPainted(false);
        Jimg_hdd.setContentAreaFilled(false);


        JPanel panel_img = new JPanel();
        panel_img.setLayout(new GridLayout(2,3));

        panel_barras.add(JImgcpu);
        panel_barras.add(JImgram);
        panel_barras.add(Jimg_hdd);

        Jlabelcpu = new JLabel("CPU");
        Jlabelcpu.setHorizontalAlignment(SwingConstants.CENTER);
        Jlabelram = new JLabel("RAM");
        Jlabelram.setHorizontalAlignment(SwingConstants.CENTER);
        Jlabelhdd = new JLabel("DISCO");
        Jlabelhdd.setHorizontalAlignment(SwingConstants.CENTER);

        panel_barras.add(Jlabelcpu);
        panel_barras.add(Jlabelram);
        panel_barras.add(Jlabelhdd);

        panel_procesos.add(panel_barras);

        //Titulo de Entrada-Salida

        JLabel Jlabel_es = new JLabel("Dispositivos de entrada y salida");
        Jlabel_es.setHorizontalAlignment(SwingConstants.CENTER);
        panel_procesos.add(Jlabel_es);



        //Panel para los iconos de entrada y salida
        JPanel panel_imges = new JPanel(new GridLayout(1,7));

        Img_monitor = new ImageIcon(getClass().getResource("/images/computer-3.png"));
        img_keyboard =new ImageIcon(getClass().getResource("/images/computer-4.png"));
        img_music = new ImageIcon(getClass().getResource("/images/music.png"));
        img_impresora = new ImageIcon(getClass().getResource("/images/tool.png"));
        img_mic = new ImageIcon(getClass().getResource("/images/technology.png"));
        img_mouse = new ImageIcon(getClass().getResource("/images/technology-1.png"));
        img_usb = new ImageIcon(getClass().getResource("/images/technology-2.png"));

        Jimg_monitor = new JButton(Img_monitor);
        Jimg_monitor.setBorder(BorderFactory.createEmptyBorder());
        Jimg_monitor.setBorderPainted(false);
        Jimg_monitor.setFocusPainted(false);
        Jimg_monitor.setContentAreaFilled(false);
        Jimg_monitor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Proceso proceso = new Proceso(idrandom(),1,"E/S", 15.00f, 23.00f,"Proceso Monitor","nuevo",3);
                Ingresar(proceso);
            }
        });



        Jimg_impresora = new JButton(img_impresora);
        Jimg_impresora.setBorder(BorderFactory.createEmptyBorder());
        Jimg_impresora.setBorderPainted(false);
        Jimg_impresora.setFocusPainted(false);
        Jimg_impresora.setContentAreaFilled(false);
        Jimg_impresora.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Proceso proceso = new Proceso(idrandom(),1,"E/S", 15.00f, 23.00f,"Impresora","nuevo",3);
                Ingresar(proceso);
            }
        });

        Jimg_keyboard = new JButton(img_keyboard);
        Jimg_keyboard.setBorder(BorderFactory.createEmptyBorder());
        Jimg_keyboard.setFocusPainted(false);
        Jimg_keyboard.setContentAreaFilled(false);
        Jimg_keyboard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Proceso proceso = new Proceso(idrandom(),1,"E/S", 15.00f, 23.00f,"Proceso Teclado","nuevo",3);
                Ingresar(proceso);
            }
        });

        Jimg_music = new JButton(img_music);
        Jimg_music.setBorder(BorderFactory.createEmptyBorder());
        Jimg_music.setFocusPainted(false);
        Jimg_music.setContentAreaFilled(false);
        Jimg_music.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Proceso proceso = new Proceso(idrandom(),1,"E/S", 15.00f, 23.00f,"Proceso multimedia","nuevo",3);
                Ingresar(proceso);
            }
        });

        Jimg_mic = new JButton(img_mic);
        Jimg_mic.setBorder(BorderFactory.createEmptyBorder());
        Jimg_mic.setFocusPainted(false);
        Jimg_mic.setContentAreaFilled(false);
        Jimg_mic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Proceso proceso = new Proceso(idrandom(),1,"E/S", 15.00f, 23.00f,"Proceso Microfono","nuevo",3);
                Ingresar(proceso);
            }
        });


        Jimg_mouse = new JButton(img_mouse);
        Jimg_mouse.setBorder(BorderFactory.createEmptyBorder());
        Jimg_mouse.setFocusPainted(false);
        Jimg_mouse.setContentAreaFilled(false);
        Jimg_mouse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Proceso proceso = new Proceso(idrandom(),1,"E/S", 15.00f, 23.00f,"Proceso Mouse","nuevo",3);
                Ingresar(proceso);
            }
        });

        Jimg_usb = new JButton(img_usb);
        Jimg_usb.setBorder(BorderFactory.createEmptyBorder());
        Jimg_usb.setFocusPainted(false);
        Jimg_usb.setContentAreaFilled(false);
        Jimg_usb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Proceso proceso = new Proceso(idrandom(),1,"E/S", 15.00f, 23.00f,"USB","nuevo",3);
                Ingresar(proceso);
            }
        });

        panel_imges.add(Jimg_monitor);
        panel_imges.add(Jimg_impresora);
        panel_imges.add(Jimg_keyboard);
        panel_imges.add(Jimg_music);
        panel_imges.add(Jimg_mic);
        panel_imges.add(Jimg_mouse);
        panel_imges.add(Jimg_usb);

        panel_procesos.add(panel_imges);




    }

    private void Scan() {
        hilo_scan = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i=0; i <= 25; i++){

                    switch (i) {
                        case 1:
                            J25.setBackground(Color.green);
                            J1.setBackground(Color.black);
                            break;
                        case 2:
                            J1.setBackground(Color.green);
                            J2.setBackground(Color.black);
                            break;
                        case 3:
                            J2.setBackground(Color.green);
                            J3.setBackground(Color.black);
                            break;
                        case 4:
                            J3.setBackground(Color.green);
                            J4.setBackground(Color.black);
                            break;
                        case 5:
                            J4.setBackground(Color.green);
                            J5.setBackground(Color.black);
                            break;
                        case 6:
                            J5.setBackground(Color.green);
                            J6.setBackground(Color.black);
                            break;
                        case 7:
                            J6.setBackground(Color.green);
                            J7.setBackground(Color.black);
                            break;
                        case 8:
                            J7.setBackground(Color.green);
                            J8.setBackground(Color.black);
                            break;
                        case 9:
                            J8.setBackground(Color.green);
                            J9.setBackground(Color.black);
                            break;
                        case 10:
                            J9.setBackground(Color.green);
                            J10.setBackground(Color.black);
                            break;
                        case 11:
                            J10.setBackground(Color.green);
                            J11.setBackground(Color.black);
                            break;
                        case 12:
                            J11.setBackground(Color.green);
                            J12.setBackground(Color.black);
                            break;
                        case 13:
                            J12.setBackground(Color.green);
                            J13.setBackground(Color.black);
                            break;
                        case 14:
                            J13.setBackground(Color.green);
                            J14.setBackground(Color.black);
                            break;
                        case 15:
                            J14.setBackground(Color.green);
                            J15.setBackground(Color.black);
                            break;
                        case 16:
                            J15.setBackground(Color.green);
                            J16.setBackground(Color.black);
                            break;
                        case 17:
                            J16.setBackground(Color.green);
                            J17.setBackground(Color.black);
                            break;
                        case 18:
                            J17.setBackground(Color.green);
                            J18.setBackground(Color.black);
                            break;
                        case 19:
                            J18.setBackground(Color.green);
                            J19.setBackground(Color.black);
                            break;
                        case 20:
                            J19.setBackground(Color.green);
                            J20.setBackground(Color.black);
                            break;
                        case 21:
                            J20.setBackground(Color.green);
                            J21.setBackground(Color.black);
                            break;
                        case 22:
                            J21.setBackground(Color.green);
                            J22.setBackground(Color.black);
                            break;
                        case 23:
                            J22.setBackground(Color.green);
                            J23.setBackground(Color.black);
                            break;
                        case 24:
                            J23.setBackground(Color.green);
                            J24.setBackground(Color.black);
                            break;
                        case 25:
                            J24.setBackground(Color.green);
                            J25.setBackground(Color.black);
                            break;
                        default:
                            J1.setBackground(Color.black);
                            break;
                    }

                    try {
                        hilo_scan.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }



                for (int i=25; i <= 25; i--){

                    switch (i) {
                        case 1:
                            J25.setBackground(Color.green);
                            J2.setBackground(Color.green);
                            J1.setBackground(Color.black);
                            break;
                        case 2:
                            J3.setBackground(Color.green);
                            J2.setBackground(Color.black);
                            break;
                        case 3:
                            J4.setBackground(Color.green);
                            J3.setBackground(Color.black);
                            break;
                        case 4:
                            J5.setBackground(Color.green);
                            J4.setBackground(Color.black);
                            break;
                        case 5:
                            J6.setBackground(Color.green);
                            J5.setBackground(Color.black);
                            break;
                        case 6:
                            J7.setBackground(Color.green);
                            J6.setBackground(Color.black);
                            break;
                        case 7:
                            J8.setBackground(Color.green);
                            J7.setBackground(Color.black);
                            break;
                        case 8:
                            J9.setBackground(Color.green);
                            J8.setBackground(Color.black);
                            break;
                        case 9:
                            J10.setBackground(Color.green);
                            J9.setBackground(Color.black);
                            break;
                        case 10:
                            J11.setBackground(Color.green);
                            J10.setBackground(Color.black);
                            break;
                        case 11:
                            J12.setBackground(Color.green);
                            J11.setBackground(Color.black);
                            break;
                        case 12:
                            J13.setBackground(Color.green);
                            J12.setBackground(Color.black);
                            break;
                        case 13:
                            J14.setBackground(Color.green);
                            J13.setBackground(Color.black);
                            break;
                        case 14:
                            J15.setBackground(Color.green);
                            J14.setBackground(Color.black);
                            break;
                        case 15:
                            J16.setBackground(Color.green);
                            J15.setBackground(Color.black);
                            break;
                        case 16:
                            J17.setBackground(Color.green);
                            J16.setBackground(Color.black);
                            break;
                        case 17:
                            J18.setBackground(Color.green);
                            J17.setBackground(Color.black);
                            break;
                        case 18:
                            J19.setBackground(Color.green);
                            J18.setBackground(Color.black);
                            break;
                        case 19:
                            J20.setBackground(Color.green);
                            J19.setBackground(Color.black);
                            break;
                        case 20:
                            J21.setBackground(Color.green);
                            J20.setBackground(Color.black);
                            break;
                        case 21:
                            J22.setBackground(Color.green);
                            J21.setBackground(Color.black);
                            break;
                        case 22:
                            J23.setBackground(Color.green);
                            J22.setBackground(Color.black);
                            break;
                        case 23:
                            J24.setBackground(Color.green);
                            J23.setBackground(Color.black);
                            break;
                        case 24:
                            J25.setBackground(Color.green);
                            J24.setBackground(Color.black);
                            break;
                        case 25:
                            J24.setBackground(Color.green);
                            J25.setBackground(Color.black);
                            break;
                        default:
                            J1.setBackground(Color.black);
                            break;
                    }

                    try {
                        hilo_scan.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });

        hilo_scan.start();

    }

    private void Fifo() {

        hilo_proceso = new Thread(new Runnable() {
                @Override
                public void run() {


                    for (int i = 0; i < lista_procesos.size(); i++){
                        lista_procesos.get(i).setEstado("listo");
                        table.setValueAt("listo",i,6);
                        PBcpu.setValue(i);
                        try {
                            Thread.sleep(1500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }


                    for (int j = 0; j < lista_procesos.size(); j++) {
                        PBcpu.setValue((int) lista_procesos.get(j).getCpu());
                        PBram.setValue((int) lista_procesos.get(j).getMemoria());
                        float quantum_inicial = lista_procesos.get(j).getQuantum();
                        System.out.println("Valor del quantum inicial : " +quantum_inicial);
                        float contador_quantum = quantum_inicial;
                        while (contador_quantum != 0){
                            System.out.println("Entro en el while");
                            contador_quantum= contador_quantum - 1;
                            lista_procesos.get(j).setQuantum(contador_quantum);
                            table.setValueAt(contador_quantum, j, 3);
                            try {
                                hilo_proceso.sleep(500);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println("Valor del contador: " +contador_quantum);
                        }

                        if (lista_procesos.get(j).getPrioridad()!=1) {
                            lista_procesos.get(j).setEstado("terminado");
                            table.setValueAt("terminado", j, 6);
                            tableModel.fireTableDataChanged();
                        } else{
                            lista_procesos.get(j).setQuantum(20);
                            table.setValueAt(20, j, 3);
                        }
                        try {
                            hilo_proceso.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }


                        if (j == lista_procesos.size()) {
                            PBcpu.setValue(0);
                        }
                    }

                }
            });

            hilo_proceso.start();


    }

    private void BloquearProceso(Integer id_proceso) {
        for (int i = 0; i < lista_procesos.size(); i++){
            int id = lista_procesos.get(i).getId();
            int prioridad = lista_procesos.get(i).getPrioridad();
            String tipo_proceso = lista_procesos.get(i).gettipo_proceso();
            float memoria = lista_procesos.get(i).getMemoria();
            float quantum = lista_procesos.get(i).getQuantum();
            String nombre = lista_procesos.get(i).getNombre();
            String estado = lista_procesos.get(i).getEstado();

            if (id_proceso == id){

            lista_procesos.get(i).setEstado("Bloqueado");
                JOptionPane.showMessageDialog(BMatar,
                        "Bloqueando proceso.",
                        "BLoqueando proceso",
                        JOptionPane.WARNING_MESSAGE);
                Thread hilo = new Thread();

                try {
                    Thread.sleep(5000);
                    System.out.println("Se ha Bloqueado el objeto: " +id);
                    table.setValueAt("Bloqueado",i,6);
                    //TODO hacer que vuelva a cargar la lista en el tablemodel con el objeto que se modifico
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
            else{
                System.out.println("Los ID no coinciden id_proceso: " +id_proceso +" id: "+id);
                if (i == lista_procesos.size()){
                    JOptionPane.showMessageDialog(BMatar,"No se ha encontrado un proceso con ese ID");
                }
            }
        }

    }

    private void MatarProcesos(Integer id_proceso) {

        for (int i = 0; i < lista_procesos.size(); i++){
            int id = lista_procesos.get(i).getId();

            if (id_proceso == id){
                JOptionPane.showMessageDialog(BMatar,
                        "Eliminando proceso por favor espere.",
                        "Eliminando procesos",
                        JOptionPane.WARNING_MESSAGE);
                Thread hilo = new Thread();

                try {
                    Thread.sleep(5000);
                    lista_procesos.remove(lista_procesos.get(i));
                    System.out.println("Se ha removido el objeto: " +id);
                    tableModel.removeRow(i);
                    table.setModel(tableModel);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            else{
                System.out.println("Los ID no coinciden id_proceso: " +id_proceso +" id: "+id);
                if (i == lista_procesos.size()){
                    JOptionPane.showMessageDialog(BMatar,"No se ha encontrado un proceso con ese ID");
                }
            }
        }

    }

    private void Ingresar(Proceso proceso_nuevo) {
        lista_procesos.add(proceso_nuevo);
        int id = proceso_nuevo.getId();
        int prioridad = proceso_nuevo.getPrioridad();
        String tipo_proceso = proceso_nuevo.gettipo_proceso();
        float memoria = proceso_nuevo.getMemoria();
        float quantum = proceso_nuevo.getQuantum();
        String nombre = proceso_nuevo.getNombre();
        String estado = proceso_nuevo.getEstado();
        int cpu = proceso_nuevo.getCpu();

        Object[] data = {id,nombre,memoria,quantum,prioridad,tipo_proceso,estado,0,cpu};
        tableModel.addRow(data);
        table.setModel(tableModel);
    }

    private ArrayList<Proceso> LlenarTabla() {
        ArrayList<Proceso> Procesos = new ArrayList<Proceso>();
        Integer id_random = idrandom();
        Float id_quantum = idquantum();
        Procesos.add(new Proceso(id_random,1,"CPU",10,id_quantum,"Proceso de inicio","nuevo",30));
        id_random = idrandom();
        id_quantum = idquantum();
        Procesos.add(new Proceso(id_random,1,"CPU",15,id_quantum,"Proceso del panel","nuevo",30));
        id_random = idrandom();
        id_quantum = idquantum();
        Procesos.add(new Proceso(id_random,3,"CPU",15,id_quantum,"Dropbox","nuevo",100));
        id_random = idrandom();
        id_quantum = idquantum();
        Procesos.add(new Proceso(id_random,3,"CPU",15,id_quantum,"Skype","nuevo",200));
        id_random = idrandom();
        id_quantum = idquantum();
        Procesos.add(new Proceso(id_random,1,"E/S",15,id_quantum,"Administrador de volumen","nuevo",30));
        id_random = idrandom();
        id_quantum = idquantum();
        Procesos.add(new Proceso(id_random,1,"CPU",15,id_quantum,"Administrador de archivos","nuevo",50));
        id_random = idrandom();
        id_quantum = idquantum();
        Procesos.add(new Proceso(id_random,1,"E/S",15,id_quantum,"Administrador de red","nuevo",30));
        id_random = idrandom();
        id_quantum = idquantum();
        Procesos.add(new Proceso(id_random,3,"CPU",15,id_quantum,"MegaSync","nuevo",60));
        id_random = idrandom();
        id_quantum = idquantum();
        Procesos.add(new Proceso(id_random,1,"E/S",15,id_quantum,"Administrador de teclado","nuevo",20));
        id_random = idrandom();
        id_quantum = idquantum();
        Procesos.add(new Proceso(id_random,3,"CPU",800,id_quantum,"Intellij IDEA 15.0.2","nuevo",400));
        return Procesos;
    }

    private Float idquantum() {
        Random random = new Random();
        Float id_quantum = Float.valueOf(random.nextInt(50)+1);
        return id_quantum;
    }

    private Integer idrandom() {
        Random random = new Random();
        Integer id_random = random.nextInt(2000)+1;
        return id_random;
    }

}
