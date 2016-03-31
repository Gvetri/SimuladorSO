import modelos.Proceso;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

/**
 * Created by giuseppe on 21/03/16.
 */
public class Escritorio extends JFrame {
    private JButton JButtonAndroid;
    private JLabel LAndroidstudio;

    private JButton JButtonGenymotion;
    private JLabel JGenymotion;

    private JButton JButtonFirefox;
    private JLabel JFirefox;

    private JPanel panel_procesos;

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

        Rellenar_panel();


        //Declaracion para agregar elementos al JFrame
        add(JButtonAndroid);
        JButtonAndroid.setToolTipText("Android studio");
        add(LAndroidstudio);
        add(JButtonGenymotion);
        add(JButtonFirefox);
        add(panel_procesos);

        //Declaracion para establecer los elementos dentro del JFrame
        JButtonAndroid.setBounds(50,50,128,128);
        LAndroidstudio.setBounds(20,20,60,60);
        JButtonGenymotion.setBounds(50,300,128,128);
        JButtonFirefox.setBounds(50,500,128,128);
        panel_procesos.setBounds(800,50,500,600);

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

    }

    private void Rellenar_panel() {

        //Agregamos el titulo
        Ltitulo_adm = new JLabel("Administrador de procesos");
        Ltitulo_adm.setHorizontalAlignment(SwingConstants.CENTER);

        panel_procesos.add(Ltitulo_adm);



        Object rowData[][] = { { "Row1-Column1", "Row1-Column2", "Row1-Column3","Row1-Column4","Row1-column5","Row1-column6","Row1-column7" },
                { "Row2-Column1", "Row2-Column2", "Row2-Column3","Row2-Column4", "Row2-Column5", "Row2-Column6", "Row2-Column7" } };
        lista_procesos =  LlenarTabla();
        Object columnNames[] = { "ID Proceso", "Nombre", "Memoria","Quantum","Prioridad","ID_padre","tiempo"};


        DefaultTableModel tableModel = new DefaultTableModel(columnNames,0);
        for (int i = 0; i < lista_procesos.size(); i++){
            int id = lista_procesos.get(i).getId();
            int prioridad = lista_procesos.get(i).getPrioridad();
            float memoria = lista_procesos.get(i).getMemoria();
            float quantum = lista_procesos.get(i).getQuantum();
            String nombre = lista_procesos.get(i).getNombre();
            String estado = lista_procesos.get(i).getEstado();

            Object[] data = {id,nombre,memoria,quantum,prioridad,"",estado,0};
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
        PBcpu.setMaximumSize(new Dimension(3,10));

        PBdisco = new JProgressBar();
        PBdisco.setBackground(fondo);
        PBdisco.setForeground(foreground);
        PBdisco.setToolTipText("Disco");
        PBdisco.setBorderPainted(false);
        PBdisco.setStringPainted(true);
        PBdisco.setMaximumSize(new Dimension(3,10));

        PBram = new JProgressBar();
        PBram.setBackground(fondo);
        PBram.setForeground(foreground);
        PBram.setToolTipText("Disco");
        PBram.setBorderPainted(false);
        PBram.setStringPainted(true);
        PBdisco.setMaximumSize(new Dimension(3,10));


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


        Jimg_impresora = new JButton(img_impresora);
        Jimg_impresora.setBorder(BorderFactory.createEmptyBorder());
        Jimg_impresora.setBorderPainted(false);
        Jimg_impresora.setFocusPainted(false);
        Jimg_impresora.setContentAreaFilled(false);

        Jimg_keyboard = new JButton(img_keyboard);
        Jimg_keyboard.setBorder(BorderFactory.createEmptyBorder());
        Jimg_keyboard.setFocusPainted(false);
        Jimg_keyboard.setContentAreaFilled(false);


        Jimg_music = new JButton(img_music);
        Jimg_music.setBorder(BorderFactory.createEmptyBorder());
        Jimg_music.setFocusPainted(false);
        Jimg_music.setContentAreaFilled(false);

        Jimg_mic = new JButton(img_mic);
        Jimg_mic.setBorder(BorderFactory.createEmptyBorder());
        Jimg_mic.setFocusPainted(false);
        Jimg_mic.setContentAreaFilled(false);


        Jimg_mouse = new JButton(img_mouse);
        Jimg_mouse.setBorder(BorderFactory.createEmptyBorder());
        Jimg_mouse.setFocusPainted(false);
        Jimg_mouse.setContentAreaFilled(false);

        Jimg_usb = new JButton(img_usb);
        Jimg_usb.setBorder(BorderFactory.createEmptyBorder());
        Jimg_usb.setFocusPainted(false);
        Jimg_usb.setContentAreaFilled(false);

        panel_imges.add(Jimg_monitor);
        panel_imges.add(Jimg_impresora);
        panel_imges.add(Jimg_keyboard);
        panel_imges.add(Jimg_music);
        panel_imges.add(Jimg_mic);
        panel_imges.add(Jimg_mouse);
        panel_imges.add(Jimg_usb);

        panel_procesos.add(panel_imges);




    }

    private ArrayList<Proceso> LlenarTabla() {
        ArrayList<Proceso> Procesos = new ArrayList<Proceso>();
        Procesos.add(new Proceso(1,1,15,20,"Proceso de inicio","activo"));
        Procesos.add(new Proceso(2,1,15,20,"Proceso del panel","activo"));
        Procesos.add(new Proceso(3,3,15,20,"Dropbox","activo"));
        Procesos.add(new Proceso(4,3,15,20,"Skype","activo"));
        Procesos.add(new Proceso(5,1,15,20,"Administrador de volumen","activo"));
        Procesos.add(new Proceso(6,1,15,20,"Administrador de archivos","activo"));
        Procesos.add(new Proceso(7,1,15,20,"Administrador de red","activo"));
        Procesos.add(new Proceso(8,3,15,20,"MegaSync","activo"));

        return Procesos;
    }

}
