/*
 * Login.java
 * jDroidOS version 2.0.1   All Rights Reserved  :P :)
 * Please do not copy or misuse this project
 */

/**
 * @author KDR
 */
import javax.swing.JOptionPane;
import java.math.BigInteger;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

public class Login extends javax.swing.JFrame {

    String curusername;
    String curpassword;
    private double firstnum = 0.0;
    private double secondnum = 0.0;
    private double result = 0.0;
    String operations;
    private int wordcount = 1;
    private int trycount = 1;
    private int delsrno = 0;
    public Login() {

        initComponents();

        //JDBC part getting username and password------------------------------//
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jos", "root", "mysql");
            Statement stmt = con.createStatement();
            String query = "Select * from userpass";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.first()) {
                curusername = rs.getString(1);
                curpassword = rs.getString(2);
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
        //---------------------------------------------------------------------//
        //JDBC part setting wallpaper------------------------------------------//
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jos", "root", "mysql");
            Statement stmt = con.createStatement();
            String query = "Select * from backgrounds";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.first()) {
                String homebackg = rs.getString(1);
                String loginbackg = rs.getString(2);
                homelabel.setIcon(new ImageIcon(getClass().getResource(homebackg)));
                menulabel.setIcon(new ImageIcon(getClass().getResource(homebackg)));
                loginlabel.setIcon(new ImageIcon(getClass().getResource(loginbackg)));

            }
        } catch (Exception e) {
            System.out.println("Error");
        }
        //---------------------------------------------------------------------//
        //JDBC part useravatar-------------------------------------------------//
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jos", "root", "mysql");
            Statement stmt = con.createStatement();
            String query = "Select * from useravatar";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.first()) {
                String avatar = rs.getString(1);
                userlabel.setIcon(new ImageIcon(getClass().getResource(avatar)));
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
        //---------------------------------------------------------------------//
        //---Contacts display in table--//
            addcontact.setVisible(false);
            updatepanel.setVisible(false);
            contactpanel.setVisible(true);
            try {
                DefaultTableModel tb = (DefaultTableModel) cnttb.getModel();
                Class.forName("java.sql.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jos", "root", "mysql");
                Statement stmt = con.createStatement();
                String query = "Select * from contacts";
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    int srno = rs.getInt(1);
                    String fname = rs.getString(2);
                    String lname = rs.getString(3);
                    BigInteger num = new BigInteger(rs.getString(4));
                    tb.addRow(new Object[]{srno, fname, lname, num});
                }
                con.close();
                stmt.close();
                rs.close();

            } catch (Exception e) {
            }
        //-----name display in recent called-//
        try {
                Class.forName("java.sql.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jos", "root", "mysql");
                Statement stmt = con.createStatement();
                String query = "Select * from calling";
                ResultSet rs = stmt.executeQuery(query);
                String name = "", num = "";
                while (rs.next()) {
                    name = rs.getString(1);
                    num = rs.getString(2);
                }
                pbname1.setText(name);
                pbnum1.setText("" + num);
                con.close();
                stmt.close();
                rs.close();
            } catch (Exception e) {
                System.out.println("Error in connectivity");
            }
         //-----button properties---//
        cbbutn.setOpaque(false);
        cbbutn.setContentAreaFilled(false);
        cbbutn.setBorderPainted(false);
        cnttb.setOpaque(false);
        contactpanel.getViewport().setOpaque(false);
        cnttb.setBackground(null);
        contactpanel.setBackground(null);
        //---------------------------------------------------------------------//
        //setting buttons transparent
        subbutton1.setOpaque(false);
        subbutton1.setContentAreaFilled(false);
        subbutton1.setBorderPainted(false);
        homebutton.setOpaque(false);
        homebutton.setContentAreaFilled(false);
        homebutton.setBorderPainted(false);
        powbutton.setOpaque(false);
        powbutton.setContentAreaFilled(false);
        powbutton.setBorderPainted(false);
        backbutton.setOpaque(false);
        backbutton.setContentAreaFilled(false);
        backbutton.setBorderPainted(false);
        cancelbutton1.setOpaque(false);
        cancelbutton1.setContentAreaFilled(false);
        cancelbutton1.setBorderPainted(false);
        appbutton.setOpaque(false);
        appbutton.setContentAreaFilled(false);
        appbutton.setBorderPainted(false);
        calcbutton.setOpaque(false);
        calcbutton.setContentAreaFilled(false);
        calcbutton.setBorderPainted(false);
        billbutton.setOpaque(false);
        billbutton.setContentAreaFilled(false);
        billbutton.setBorderPainted(false);
        aboutbutton.setOpaque(false);
        aboutbutton.setContentAreaFilled(false);
        aboutbutton.setBorderPainted(false);
        npbutton.setOpaque(false);
        npbutton.setContentAreaFilled(false);
        npbutton.setBorderPainted(false);
        gamebutton.setOpaque(false);
        gamebutton.setContentAreaFilled(false);
        gamebutton.setBorderPainted(false);
        settingbutton.setOpaque(false);
        settingbutton.setContentAreaFilled(false);
        settingbutton.setBorderPainted(false);
        calcbutton1.setOpaque(false);
        calcbutton1.setContentAreaFilled(false);
        calcbutton1.setBorderPainted(false);
        billbutton1.setOpaque(false);
        billbutton1.setContentAreaFilled(false);
        billbutton1.setBorderPainted(false);
        gamebutton1.setOpaque(false);
        gamebutton1.setContentAreaFilled(false);
        gamebutton1.setBorderPainted(false);
        contactbutton1.setOpaque(false);
        contactbutton1.setContentAreaFilled(false);
        contactbutton1.setBorderPainted(false);
        homebutton1.setOpaque(false);
        homebutton1.setContentAreaFilled(false);
        homebutton1.setBorderPainted(false);
        powbutton1.setOpaque(false);
        powbutton1.setContentAreaFilled(false);
        powbutton1.setBorderPainted(false);
        backbutton1.setOpaque(false);
        backbutton1.setContentAreaFilled(false);
        backbutton1.setBorderPainted(false);
        homebutton3.setOpaque(false);
        homebutton3.setContentAreaFilled(false);
        homebutton3.setBorderPainted(false);
        powbutton3.setOpaque(false);
        powbutton3.setContentAreaFilled(false);
        powbutton3.setBorderPainted(false);
        backbutton3.setOpaque(false);
        backbutton3.setContentAreaFilled(false);
        backbutton3.setBorderPainted(false);
        homebutton4.setOpaque(false);
        homebutton4.setContentAreaFilled(false);
        homebutton4.setBorderPainted(false);
        powbutton4.setOpaque(false);
        powbutton4.setContentAreaFilled(false);
        powbutton4.setBorderPainted(false);
        backbutton4.setOpaque(false);
        backbutton4.setContentAreaFilled(false);
        backbutton4.setBorderPainted(false);
        homebutton5.setOpaque(false);
        homebutton5.setContentAreaFilled(false);
        homebutton5.setBorderPainted(false);
        backbutton5.setOpaque(false);
        backbutton5.setContentAreaFilled(false);
        backbutton5.setBorderPainted(false);
        powbutton5.setOpaque(false);
        powbutton5.setContentAreaFilled(false);
        powbutton5.setBorderPainted(false);
        backbutton6.setOpaque(false);
        backbutton6.setContentAreaFilled(false);
        backbutton6.setBorderPainted(false);
        homebutton6.setOpaque(false);
        homebutton6.setContentAreaFilled(false);
        homebutton6.setBorderPainted(false);
        powbutton6.setOpaque(false);
        powbutton6.setContentAreaFilled(false);
        powbutton6.setBorderPainted(false);
        backbutton7.setOpaque(false);
        backbutton7.setContentAreaFilled(false);
        backbutton7.setBorderPainted(false);
        homebutton7.setOpaque(false);
        homebutton7.setContentAreaFilled(false);
        homebutton7.setBorderPainted(false);
        displaybut.setOpaque(false);
        displaybut.setContentAreaFilled(false);
        displaybut.setBorderPainted(false);
        powbutton7.setOpaque(false);
        powbutton7.setContentAreaFilled(false);
        powbutton7.setBorderPainted(false);
        backbutton8.setOpaque(false);
        backbutton8.setContentAreaFilled(false);
        backbutton8.setBorderPainted(false);
        homebutton8.setOpaque(false);
        homebutton8.setContentAreaFilled(false);
        homebutton8.setBorderPainted(false);
        userbut.setOpaque(false);
        userbut.setContentAreaFilled(false);
        userbut.setBorderPainted(false);
        passchangebut.setOpaque(false);
        passchangebut.setContentAreaFilled(false);
        passchangebut.setBorderPainted(false);
        powbutton8.setOpaque(false);
        powbutton8.setContentAreaFilled(false);
        powbutton8.setBorderPainted(false);
        backbutton9.setOpaque(false);
        backbutton9.setContentAreaFilled(false);
        backbutton9.setBorderPainted(false);
        homebutton9.setOpaque(false);
        homebutton9.setContentAreaFilled(false);
        homebutton9.setBorderPainted(false);
        wallbut1.setOpaque(false);
        wallbut1.setContentAreaFilled(false);
        wallbut1.setBorderPainted(false);
        wallbut2.setOpaque(false);
        wallbut2.setContentAreaFilled(false);
        wallbut2.setBorderPainted(false);
        wallbut3.setOpaque(false);
        wallbut3.setContentAreaFilled(false);
        wallbut3.setBorderPainted(false);
        wallbut4.setOpaque(false);
        wallbut4.setContentAreaFilled(false);
        wallbut4.setBorderPainted(false);
        wallbut5.setOpaque(false);
        wallbut5.setContentAreaFilled(false);
        wallbut5.setBorderPainted(false);
        wallbut6.setOpaque(false);
        wallbut6.setContentAreaFilled(false);
        wallbut6.setBorderPainted(false);
        wallbut7.setOpaque(false);
        wallbut7.setContentAreaFilled(false);
        wallbut7.setBorderPainted(false);
        wallbut8.setOpaque(false);
        wallbut8.setContentAreaFilled(false);
        wallbut8.setBorderPainted(false);
        wallbut9.setOpaque(false);
        wallbut9.setContentAreaFilled(false);
        wallbut9.setBorderPainted(false);
        wallbut10.setOpaque(false);
        wallbut10.setContentAreaFilled(false);
        wallbut10.setBorderPainted(false);
        wallbut11.setOpaque(false);
        wallbut11.setContentAreaFilled(false);
        wallbut11.setBorderPainted(false);
        wallbut12.setOpaque(false);
        wallbut12.setContentAreaFilled(false);
        wallbut12.setBorderPainted(false);
        wallbut13.setOpaque(false);
        wallbut13.setContentAreaFilled(false);
        wallbut13.setBorderPainted(false);
        wallbut14.setOpaque(false);
        wallbut14.setContentAreaFilled(false);
        wallbut14.setBorderPainted(false);
        userbut1.setOpaque(false);
        userbut1.setContentAreaFilled(false);
        userbut1.setBorderPainted(false);
        userbut2.setOpaque(false);
        userbut2.setContentAreaFilled(false);
        userbut2.setBorderPainted(false);
        userbut3.setOpaque(false);
        userbut3.setContentAreaFilled(false);
        userbut3.setBorderPainted(false);
        userbut4.setOpaque(false);
        userbut4.setContentAreaFilled(false);
        userbut4.setBorderPainted(false);
        userbut5.setOpaque(false);
        userbut5.setContentAreaFilled(false);
        userbut5.setBorderPainted(false);
        userbut6.setOpaque(false);
        userbut6.setContentAreaFilled(false);
        userbut6.setBorderPainted(false);
        userbut7.setOpaque(false);
        userbut7.setContentAreaFilled(false);
        userbut7.setBorderPainted(false);
        userbut8.setOpaque(false);
        userbut8.setContentAreaFilled(false);
        userbut8.setBorderPainted(false);
        userbut9.setOpaque(false);
        userbut9.setContentAreaFilled(false);
        userbut9.setBorderPainted(false);
        userbut10.setOpaque(false);
        userbut10.setContentAreaFilled(false);
        userbut10.setBorderPainted(false);
        userbut11.setOpaque(false);
        userbut11.setContentAreaFilled(false);
        userbut11.setBorderPainted(false);
        userbut12.setOpaque(false);
        userbut12.setContentAreaFilled(false);
        userbut12.setBorderPainted(false);
        userbut13.setOpaque(false);
        userbut13.setContentAreaFilled(false);
        userbut13.setBorderPainted(false);
        userbut14.setOpaque(false);
        userbut14.setContentAreaFilled(false);
        userbut14.setBorderPainted(false);
        userbut15.setOpaque(false);
        userbut15.setContentAreaFilled(false);
        userbut15.setBorderPainted(false);
        powbutton9.setOpaque(false);
        powbutton9.setContentAreaFilled(false);
        powbutton9.setBorderPainted(false);
        backbutton10.setOpaque(false);
        backbutton10.setContentAreaFilled(false);
        backbutton10.setBorderPainted(false);
        homebutton10.setOpaque(false);
        homebutton10.setContentAreaFilled(false);
        homebutton10.setBorderPainted(false);
        powbutton10.setOpaque(false);
        powbutton10.setContentAreaFilled(false);
        powbutton10.setBorderPainted(false);
        backbutton11.setOpaque(false);
        backbutton11.setContentAreaFilled(false);
        backbutton11.setBorderPainted(false);
        homebutton11.setOpaque(false);
        homebutton11.setContentAreaFilled(false);
        homebutton11.setBorderPainted(false);
        contactbutton.setOpaque(false);
        contactbutton.setContentAreaFilled(false);
        contactbutton.setBorderPainted(false);
        gamepanel.setOpaque(false);
        gamepanel.setBackground(null);
//-----------------------------------------------------------------------------//
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        home = new javax.swing.JFrame();
        backbutton = new javax.swing.JButton();
        homebutton = new javax.swing.JButton();
        powbutton = new javax.swing.JButton();
        appbutton = new javax.swing.JButton();
        calcbutton1 = new javax.swing.JButton();
        billbutton1 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        contactbutton1 = new javax.swing.JButton();
        gamebutton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        homelabel = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu23 = new javax.swing.JMenu();
        jMenuItem46 = new javax.swing.JMenuItem();
        jMenuItem47 = new javax.swing.JMenuItem();
        jMenuItem48 = new javax.swing.JMenuItem();
        jMenu24 = new javax.swing.JMenu();
        jMenuItem49 = new javax.swing.JMenuItem();
        appdrawer = new javax.swing.JFrame();
        backbutton1 = new javax.swing.JButton();
        homebutton1 = new javax.swing.JButton();
        powbutton1 = new javax.swing.JButton();
        npbutton = new javax.swing.JButton();
        calcbutton = new javax.swing.JButton();
        billbutton = new javax.swing.JButton();
        settingbutton = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        aboutbutton = new javax.swing.JButton();
        contactbutton = new javax.swing.JButton();
        gamebutton = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        menulabel = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        pyramid = new javax.swing.JButton();
        settingbutton1 = new javax.swing.JButton();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        contacts = new javax.swing.JFrame();
        pbname1 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        pbnum1 = new javax.swing.JLabel();
        cbbutn = new javax.swing.JButton();
        Contactbutton = new javax.swing.JButton();
        addcntbutton = new javax.swing.JButton();
        updatebutton = new javax.swing.JButton();
        contactpanel = new javax.swing.JScrollPane();
        cnttb = new javax.swing.JTable();
        updatepanel = new javax.swing.JPanel();
        jLabel86 = new javax.swing.JLabel();
        srnotf = new javax.swing.JTextField();
        shbutton = new javax.swing.JButton();
        jLabel87 = new javax.swing.JLabel();
        ufnametf = new javax.swing.JTextField();
        jLabel88 = new javax.swing.JLabel();
        ulnametf = new javax.swing.JTextField();
        jLabel90 = new javax.swing.JLabel();
        unumtf = new javax.swing.JTextField();
        upbutton = new javax.swing.JButton();
        delbutton = new javax.swing.JButton();
        resetbutton = new javax.swing.JButton();
        jLabel94 = new javax.swing.JLabel();
        searchbutton = new javax.swing.JButton();
        searchtf = new javax.swing.JTextField();
        addcontact = new javax.swing.JPanel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        fnametf = new javax.swing.JTextField();
        jLabel84 = new javax.swing.JLabel();
        lnametf = new javax.swing.JTextField();
        jLabel85 = new javax.swing.JLabel();
        numtf1 = new javax.swing.JTextField();
        addcntct = new javax.swing.JButton();
        jLabel81 = new javax.swing.JLabel();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        ssettings = new javax.swing.JFrame();
        jLabel24 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        curuser2TF = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        newpassTF = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        curpass2TF = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        curuserTF = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        newuserTF = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        curpassTF = new javax.swing.JPasswordField();
        jLabel63 = new javax.swing.JLabel();
        backbutton3 = new javax.swing.JButton();
        homebutton3 = new javax.swing.JButton();
        powbutton3 = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jMenuBar4 = new javax.swing.JMenuBar();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem16 = new javax.swing.JMenuItem();
        nextprime = new javax.swing.JFrame();
        powbutton4 = new javax.swing.JButton();
        homebutton4 = new javax.swing.JButton();
        backbutton4 = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        t1 = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        t2 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jMenuBar5 = new javax.swing.JMenuBar();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenu10 = new javax.swing.JMenu();
        jMenuItem20 = new javax.swing.JMenuItem();
        calculator = new javax.swing.JFrame();
        jPanel4 = new javax.swing.JPanel();
        b1 = new javax.swing.JButton();
        b7 = new javax.swing.JButton();
        b4 = new javax.swing.JButton();
        b0 = new javax.swing.JButton();
        b5 = new javax.swing.JButton();
        b8 = new javax.swing.JButton();
        b2 = new javax.swing.JButton();
        b6 = new javax.swing.JButton();
        b9 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        b3 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        t = new javax.swing.JTextField();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        homebutton5 = new javax.swing.JButton();
        backbutton5 = new javax.swing.JButton();
        jLabel39 = new javax.swing.JLabel();
        jMenuBar6 = new javax.swing.JMenuBar();
        jMenu11 = new javax.swing.JMenu();
        jMenuItem21 = new javax.swing.JMenuItem();
        jMenuItem22 = new javax.swing.JMenuItem();
        jMenuItem23 = new javax.swing.JMenuItem();
        jMenu12 = new javax.swing.JMenu();
        jMenuItem24 = new javax.swing.JMenuItem();
        aboutus = new javax.swing.JDialog();
        jLabel40 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel41 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel57 = new javax.swing.JLabel();
        billing = new javax.swing.JFrame();
        jLabel42 = new javax.swing.JLabel();
        fnameTF = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        ftypeTF = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        FpriceTF = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        FquantityTF = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        famountTF = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        ftpriceTF = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        drinksCmB = new javax.swing.JComboBox();
        dalCmB = new javax.swing.JComboBox();
        soupCmB = new javax.swing.JComboBox();
        vegCmB = new javax.swing.JComboBox();
        SouthCmB = new javax.swing.JComboBox();
        sandwichCmB = new javax.swing.JComboBox();
        chappatiCmB = new javax.swing.JComboBox();
        riceCmB = new javax.swing.JComboBox();
        jButton6 = new javax.swing.JButton();
        backbutton6 = new javax.swing.JButton();
        homebutton6 = new javax.swing.JButton();
        powbutton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jMenuBar7 = new javax.swing.JMenuBar();
        jMenu13 = new javax.swing.JMenu();
        jMenuItem25 = new javax.swing.JMenuItem();
        jMenuItem26 = new javax.swing.JMenuItem();
        jMenuItem27 = new javax.swing.JMenuItem();
        jMenu14 = new javax.swing.JMenu();
        jMenuItem28 = new javax.swing.JMenuItem();
        billtable = new javax.swing.JFrame();
        jScrollPane2 = new javax.swing.JScrollPane();
        billTB = new javax.swing.JTable();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        totalamtTF = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        powbutton6 = new javax.swing.JButton();
        homebutton7 = new javax.swing.JButton();
        backbutton7 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        gblogin = new javax.swing.JFrame();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jLabel53 = new javax.swing.JLabel();
        gbuserTF = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        gbpassPF = new javax.swing.JPasswordField();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        settings = new javax.swing.JFrame();
        powbutton7 = new javax.swing.JButton();
        homebutton8 = new javax.swing.JButton();
        backbutton8 = new javax.swing.JButton();
        jLabel59 = new javax.swing.JLabel();
        displaybut = new javax.swing.JButton();
        userbut = new javax.swing.JButton();
        passchangebut = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel58 = new javax.swing.JLabel();
        jMenuBar8 = new javax.swing.JMenuBar();
        jMenu15 = new javax.swing.JMenu();
        jMenuItem29 = new javax.swing.JMenuItem();
        jMenuItem30 = new javax.swing.JMenuItem();
        jMenuItem31 = new javax.swing.JMenuItem();
        jMenu16 = new javax.swing.JMenu();
        jMenuItem32 = new javax.swing.JMenuItem();
        changeback = new javax.swing.JFrame();
        jLabel60 = new javax.swing.JLabel();
        powbutton8 = new javax.swing.JButton();
        homebutton9 = new javax.swing.JButton();
        backbutton9 = new javax.swing.JButton();
        jLabel61 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel5 = new javax.swing.JPanel();
        wallbut1 = new javax.swing.JButton();
        wallbut2 = new javax.swing.JButton();
        wallbut3 = new javax.swing.JButton();
        wallbut4 = new javax.swing.JButton();
        wallbut5 = new javax.swing.JButton();
        wallbut6 = new javax.swing.JButton();
        wallbut7 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel6 = new javax.swing.JPanel();
        wallbut8 = new javax.swing.JButton();
        wallbut9 = new javax.swing.JButton();
        wallbut10 = new javax.swing.JButton();
        wallbut11 = new javax.swing.JButton();
        wallbut12 = new javax.swing.JButton();
        wallbut13 = new javax.swing.JButton();
        wallbut14 = new javax.swing.JButton();
        jLabel62 = new javax.swing.JLabel();
        jMenuBar9 = new javax.swing.JMenuBar();
        jMenu17 = new javax.swing.JMenu();
        jMenuItem33 = new javax.swing.JMenuItem();
        jMenuItem34 = new javax.swing.JMenuItem();
        jMenuItem35 = new javax.swing.JMenuItem();
        jMenu18 = new javax.swing.JMenu();
        jMenuItem36 = new javax.swing.JMenuItem();
        changeavatar = new javax.swing.JFrame();
        jLabel1 = new javax.swing.JLabel();
        userbut1 = new javax.swing.JButton();
        userbut2 = new javax.swing.JButton();
        userbut3 = new javax.swing.JButton();
        userbut4 = new javax.swing.JButton();
        userbut5 = new javax.swing.JButton();
        userbut6 = new javax.swing.JButton();
        userbut7 = new javax.swing.JButton();
        userbut8 = new javax.swing.JButton();
        userbut9 = new javax.swing.JButton();
        userbut10 = new javax.swing.JButton();
        userbut11 = new javax.swing.JButton();
        userbut12 = new javax.swing.JButton();
        userbut13 = new javax.swing.JButton();
        userbut14 = new javax.swing.JButton();
        userbut15 = new javax.swing.JButton();
        powbutton9 = new javax.swing.JButton();
        homebutton10 = new javax.swing.JButton();
        backbutton10 = new javax.swing.JButton();
        jLabel64 = new javax.swing.JLabel();
        jMenuBar10 = new javax.swing.JMenuBar();
        jMenu19 = new javax.swing.JMenu();
        jMenuItem37 = new javax.swing.JMenuItem();
        jMenuItem38 = new javax.swing.JMenuItem();
        jMenuItem39 = new javax.swing.JMenuItem();
        jMenu20 = new javax.swing.JMenu();
        jMenuItem40 = new javax.swing.JMenuItem();
        bullsandcows = new javax.swing.JFrame();
        powbutton10 = new javax.swing.JButton();
        homebutton11 = new javax.swing.JButton();
        backbutton11 = new javax.swing.JButton();
        jLabel65 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        inputTF = new javax.swing.JTextField();
        okbutton = new javax.swing.JButton();
        jLabel66 = new javax.swing.JLabel();
        gamepanel = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        inputlabel1 = new javax.swing.JLabel();
        inputlabel2 = new javax.swing.JLabel();
        inputlabel3 = new javax.swing.JLabel();
        inputlabel4 = new javax.swing.JLabel();
        inputlabel5 = new javax.swing.JLabel();
        inputlabel6 = new javax.swing.JLabel();
        inputlabel7 = new javax.swing.JLabel();
        inputlabel8 = new javax.swing.JLabel();
        inputlabel9 = new javax.swing.JLabel();
        inputlabel10 = new javax.swing.JLabel();
        bullslabel1 = new javax.swing.JLabel();
        bullslabel10 = new javax.swing.JLabel();
        bullslabel9 = new javax.swing.JLabel();
        bullslabel8 = new javax.swing.JLabel();
        bullslabel7 = new javax.swing.JLabel();
        bullslabel6 = new javax.swing.JLabel();
        bullslabel5 = new javax.swing.JLabel();
        bullslabel4 = new javax.swing.JLabel();
        bullslabel3 = new javax.swing.JLabel();
        bullslabel2 = new javax.swing.JLabel();
        cowslabel1 = new javax.swing.JLabel();
        cowslabel10 = new javax.swing.JLabel();
        cowslabel9 = new javax.swing.JLabel();
        cowslabel8 = new javax.swing.JLabel();
        cowslabel7 = new javax.swing.JLabel();
        cowslabel6 = new javax.swing.JLabel();
        cowslabel5 = new javax.swing.JLabel();
        cowslabel4 = new javax.swing.JLabel();
        cowslabel3 = new javax.swing.JLabel();
        cowslabel2 = new javax.swing.JLabel();
        restartbtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar11 = new javax.swing.JMenuBar();
        jMenu21 = new javax.swing.JMenu();
        jMenuItem41 = new javax.swing.JMenuItem();
        jMenuItem42 = new javax.swing.JMenuItem();
        jMenuItem43 = new javax.swing.JMenuItem();
        jMenu22 = new javax.swing.JMenu();
        jMenuItem45 = new javax.swing.JMenuItem();
        jMenuItem44 = new javax.swing.JMenuItem();
        howtoplay = new javax.swing.JDialog();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton15 = new javax.swing.JButton();
        jLabel75 = new javax.swing.JLabel();
        jd1 = new javax.swing.JDialog();
        jLabel22 = new javax.swing.JLabel();
        numtf = new javax.swing.JTextField();
        jButton18 = new javax.swing.JButton();
        details = new javax.swing.JFrame();
        namelbl = new javax.swing.JLabel();
        numlbl = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        Dclosebutton = new javax.swing.JButton();
        Ddelbutton = new javax.swing.JButton();
        Dcalbutton = new javax.swing.JButton();
        jLabel92 = new javax.swing.JLabel();
        tbdetails = new javax.swing.JFrame();
        jLabel93 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        dtb = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        userlabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        userTF = new javax.swing.JTextField();
        passTF = new javax.swing.JPasswordField();
        subbutton1 = new javax.swing.JButton();
        cancelbutton1 = new javax.swing.JButton();
        loginlabel = new javax.swing.JLabel();

        home.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        home.setTitle("jPieroid OS | Home");
        home.setMinimumSize(new java.awt.Dimension(1024, 640));
        home.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/android-system-back (2).png"))); // NOI18N
        backbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbuttonActionPerformed(evt);
            }
        });
        home.getContentPane().add(backbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 520, 300, 60));

        homebutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home-home-icon-90085 (2).png"))); // NOI18N
        homebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homebuttonActionPerformed(evt);
            }
        });
        home.getContentPane().add(homebutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 520, 330, -1));

        powbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/power-xxl (1).png"))); // NOI18N
        powbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                powbuttonActionPerformed(evt);
            }
        });
        home.getContentPane().add(powbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, 320, -1));

        appbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu--1-.png"))); // NOI18N
        appbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appbuttonActionPerformed(evt);
            }
        });
        home.getContentPane().add(appbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 360, -1, -1));

        calcbutton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/calculator-icon--2-.png"))); // NOI18N
        calcbutton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcbutton1ActionPerformed(evt);
            }
        });
        home.getContentPane().add(calcbutton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 360, -1, -1));

        billbutton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_billing--1-.png"))); // NOI18N
        billbutton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                billbutton1ActionPerformed(evt);
            }
        });
        home.getContentPane().add(billbutton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 360, -1, -1));

        jLabel18.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Game");
        home.getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 480, 150, -1));

        jLabel25.setFont(new java.awt.Font("Andalus", 1, 36)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("jPieroid Simulator");
        home.getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 440, 70));

        jLabel21.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Restaurant");
        home.getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 480, 140, -1));

        jLabel20.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Contacts");
        home.getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, 140, -1));

        jLabel19.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Calculator");
        home.getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 480, 140, -1));

        contactbutton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/contacts icon.png"))); // NOI18N
        contactbutton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactbutton1ActionPerformed(evt);
            }
        });
        home.getContentPane().add(contactbutton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 140, 120));

        gamebutton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/game icon.png"))); // NOI18N
        gamebutton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gamebutton1ActionPerformed(evt);
            }
        });
        home.getContentPane().add(gamebutton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 360, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/2560x1440-white-solid-color-ba.jpg"))); // NOI18N
        home.getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, -1, 60));

        homelabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/back3.jpg"))); // NOI18N
        home.getContentPane().add(homelabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jMenu23.setText("File");
        jMenu23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu23ActionPerformed(evt);
            }
        });

        jMenuItem46.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem46.setText("Jump to Home screen");
        jMenuItem46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem46ActionPerformed(evt);
            }
        });
        jMenu23.add(jMenuItem46);

        jMenuItem47.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem47.setText("Jump to Apps");
        jMenu23.add(jMenuItem47);

        jMenuItem48.setText("Exit jPieroid OS");
        jMenuItem48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem48ActionPerformed(evt);
            }
        });
        jMenu23.add(jMenuItem48);

        jMenuBar1.add(jMenu23);

        jMenu24.setText("Help");

        jMenuItem49.setText("About Me..");
        jMenuItem49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem49ActionPerformed(evt);
            }
        });
        jMenu24.add(jMenuItem49);

        jMenuBar1.add(jMenu24);

        home.setJMenuBar(jMenuBar1);

        appdrawer.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        appdrawer.setTitle("jPieroid OS | Apps");
        appdrawer.setMinimumSize(new java.awt.Dimension(1024, 640));
        appdrawer.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backbutton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/android-system-back (2).png"))); // NOI18N
        backbutton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbutton1ActionPerformed(evt);
            }
        });
        appdrawer.getContentPane().add(backbutton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 520, 300, 60));

        homebutton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home-home-icon-90085 (2).png"))); // NOI18N
        homebutton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homebutton1ActionPerformed(evt);
            }
        });
        appdrawer.getContentPane().add(homebutton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 520, 330, -1));

        powbutton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/power-xxl (1).png"))); // NOI18N
        powbutton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                powbutton1ActionPerformed(evt);
            }
        });
        appdrawer.getContentPane().add(powbutton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, 320, -1));

        npbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nextprime.png"))); // NOI18N
        npbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                npbuttonActionPerformed(evt);
            }
        });
        appdrawer.getContentPane().add(npbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        calcbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/calculator-icon--2-.png"))); // NOI18N
        calcbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcbuttonActionPerformed(evt);
            }
        });
        appdrawer.getContentPane().add(calcbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 30, -1, -1));

        billbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_billing--1-.png"))); // NOI18N
        billbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                billbuttonActionPerformed(evt);
            }
        });
        appdrawer.getContentPane().add(billbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, -1, -1));

        settingbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/settings-l-icon--1-.png"))); // NOI18N
        settingbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingbuttonActionPerformed(evt);
            }
        });
        appdrawer.getContentPane().add(settingbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 220, -1, -1));

        jLabel13.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Game");
        appdrawer.getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 150, 150, -1));

        jLabel15.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("More apps will come soon...");
        appdrawer.getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 340, -1, -1));

        jLabel16.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Restaurant");
        appdrawer.getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 340, 140, -1));

        jLabel79.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(255, 255, 255));
        jLabel79.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel79.setText("Contacts");
        appdrawer.getContentPane().add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, 140, -1));

        jLabel11.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Settings");
        appdrawer.getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 340, 140, -1));

        jLabel17.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Calculator");
        appdrawer.getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 150, 140, -1));

        jLabel14.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText(" Logic Maths");
        appdrawer.getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 170, -1));

        jLabel12.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("About Me");
        appdrawer.getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 140, -1));

        aboutbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/about-us-icon-15 (1).png"))); // NOI18N
        aboutbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutbuttonActionPerformed(evt);
            }
        });
        appdrawer.getContentPane().add(aboutbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        contactbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/contacts icon.png"))); // NOI18N
        contactbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactbuttonActionPerformed(evt);
            }
        });
        appdrawer.getContentPane().add(contactbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 140, 120));

        gamebutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/game icon.png"))); // NOI18N
        gamebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gamebuttonActionPerformed(evt);
            }
        });
        appdrawer.getContentPane().add(gamebutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 30, -1, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/2560x1440-white-solid-color-ba.jpg"))); // NOI18N
        appdrawer.getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, -1, 60));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/28h3fwh.png"))); // NOI18N
        appdrawer.getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 990, 480));

        menulabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/back3.jpg"))); // NOI18N
        appdrawer.getContentPane().add(menulabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel56.setText("jLabel56");
        appdrawer.getContentPane().add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pyramid.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pyramid.jpg"))); // NOI18N
        appdrawer.getContentPane().add(pyramid, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, 120, 120));

        settingbutton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/settings-l-icon--1-.png"))); // NOI18N
        settingbutton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingbutton1ActionPerformed(evt);
            }
        });
        appdrawer.getContentPane().add(settingbutton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 190, -1, -1));

        jMenu3.setText("File");
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setText("Jump to Home screen");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem6.setText("Jump to Apps");
        jMenu3.add(jMenuItem6);

        jMenuItem7.setText("Exit jPieroid OS");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem7);

        jMenuBar2.add(jMenu3);

        jMenu4.setText("Help");

        jMenuItem8.setText("About Me..");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem8);

        jMenuBar2.add(jMenu4);

        appdrawer.setJMenuBar(jMenuBar2);

        contacts.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        contacts.setTitle("jPieroid OS | Phonebook");
        contacts.setMinimumSize(new java.awt.Dimension(620, 770));
        contacts.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pbname1.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        pbname1.setForeground(new java.awt.Color(102, 255, 255));
        pbname1.setText("K. Dushyant Reddy");
        contacts.getContentPane().add(pbname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 330, -1));

        jLabel23.setFont(new java.awt.Font("Lucida Calligraphy", 1, 14)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/contact user icon.png"))); // NOI18N
        contacts.getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 80, 80));

        pbnum1.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        pbnum1.setForeground(new java.awt.Color(102, 255, 255));
        pbnum1.setText("9685522540");
        contacts.getContentPane().add(pbnum1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 300, 30));

        cbbutn.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        cbbutn.setForeground(new java.awt.Color(255, 255, 255));
        cbbutn.setText("Call Back");
        cbbutn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        cbbutn.setContentAreaFilled(false);
        cbbutn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbutnActionPerformed(evt);
            }
        });
        contacts.getContentPane().add(cbbutn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 120, 40));

        Contactbutton.setFont(new java.awt.Font("Andalus", 1, 20)); // NOI18N
        Contactbutton.setForeground(new java.awt.Color(102, 255, 255));
        Contactbutton.setText("Contacts");
        Contactbutton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        Contactbutton.setContentAreaFilled(false);
        Contactbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContactbuttonActionPerformed(evt);
            }
        });
        contacts.getContentPane().add(Contactbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 140, 40));

        addcntbutton.setFont(new java.awt.Font("Andalus", 1, 20)); // NOI18N
        addcntbutton.setForeground(new java.awt.Color(102, 255, 255));
        addcntbutton.setText("Add a Contact");
        addcntbutton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        addcntbutton.setContentAreaFilled(false);
        addcntbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addcntbuttonActionPerformed(evt);
            }
        });
        contacts.getContentPane().add(addcntbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 230, 40));

        updatebutton.setFont(new java.awt.Font("Andalus", 1, 20)); // NOI18N
        updatebutton.setForeground(new java.awt.Color(102, 255, 255));
        updatebutton.setText("Update Phonebook");
        updatebutton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        updatebutton.setContentAreaFilled(false);
        updatebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebuttonActionPerformed(evt);
            }
        });
        contacts.getContentPane().add(updatebutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 220, 200, 40));

        contactpanel.setFont(new java.awt.Font("Andalus", 0, 18)); // NOI18N
        contactpanel.setOpaque(false);
        contactpanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                contactpanelMouseClicked(evt);
            }
        });

        cnttb.setFont(new java.awt.Font("Andalus", 0, 18)); // NOI18N
        cnttb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sr.No", "First Name", "Last Name", "Phone Number"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        cnttb.setOpaque(false);
        cnttb.setRowHeight(25);
        cnttb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cnttbMouseClicked(evt);
            }
        });
        contactpanel.setViewportView(cnttb);

        contacts.getContentPane().add(contactpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 590, 420));

        updatepanel.setForeground(new java.awt.Color(255, 255, 255));
        updatepanel.setOpaque(false);

        jLabel86.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(255, 255, 255));
        jLabel86.setText("Enter Sr_No  ( You can check from Contacts)");

        srnotf.setFont(new java.awt.Font("Andalus", 0, 18)); // NOI18N

        shbutton.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        shbutton.setForeground(new java.awt.Color(255, 255, 255));
        shbutton.setText("Show Details");
        shbutton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        shbutton.setContentAreaFilled(false);
        shbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shbuttonActionPerformed(evt);
            }
        });

        jLabel87.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(255, 255, 255));
        jLabel87.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel87.setText("First Name");

        ufnametf.setFont(new java.awt.Font("Andalus", 0, 18)); // NOI18N
        ufnametf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ufnametf.setEnabled(false);

        jLabel88.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(255, 255, 255));
        jLabel88.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel88.setText(" Last Name");

        ulnametf.setFont(new java.awt.Font("Andalus", 0, 18)); // NOI18N
        ulnametf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ulnametf.setEnabled(false);

        jLabel90.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel90.setForeground(new java.awt.Color(255, 255, 255));
        jLabel90.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel90.setText("Phone Number");

        unumtf.setFont(new java.awt.Font("Andalus", 0, 18)); // NOI18N
        unumtf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        unumtf.setEnabled(false);

        upbutton.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        upbutton.setText("Update");
        upbutton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        upbutton.setEnabled(false);
        upbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upbuttonActionPerformed(evt);
            }
        });

        delbutton.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        delbutton.setText("Delete");
        delbutton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        delbutton.setEnabled(false);
        delbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delbuttonActionPerformed(evt);
            }
        });

        resetbutton.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        resetbutton.setText("Reset");
        resetbutton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        resetbutton.setEnabled(false);
        resetbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetbuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout updatepanelLayout = new javax.swing.GroupLayout(updatepanel);
        updatepanel.setLayout(updatepanelLayout);
        updatepanelLayout.setHorizontalGroup(
            updatepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updatepanelLayout.createSequentialGroup()
                .addGroup(updatepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(updatepanelLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(updatepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(updatepanelLayout.createSequentialGroup()
                                .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ufnametf, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(updatepanelLayout.createSequentialGroup()
                                .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ulnametf, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(updatepanelLayout.createSequentialGroup()
                                .addGroup(updatepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel90, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(updatepanelLayout.createSequentialGroup()
                                        .addGap(44, 44, 44)
                                        .addComponent(delbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(updatepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(upbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(unumtf, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(updatepanelLayout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addComponent(resetbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(updatepanelLayout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(shbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(updatepanelLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(srnotf, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        updatepanelLayout.setVerticalGroup(
            updatepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updatepanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(updatepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel86, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(srnotf, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(shbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(updatepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel87, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ufnametf, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(updatepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ulnametf, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(updatepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel90, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(unumtf, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(updatepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(delbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(upbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(resetbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        contacts.getContentPane().add(updatepanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 590, 420));

        jLabel94.setFont(new java.awt.Font("Andalus", 0, 20)); // NOI18N
        jLabel94.setForeground(new java.awt.Color(153, 255, 255));
        jLabel94.setText("Recent -");
        contacts.getContentPane().add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 130, 30));

        searchbutton.setFont(new java.awt.Font("Andalus", 1, 20)); // NOI18N
        searchbutton.setForeground(new java.awt.Color(102, 255, 255));
        searchbutton.setText("Search");
        searchbutton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        searchbutton.setContentAreaFilled(false);
        searchbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbuttonActionPerformed(evt);
            }
        });
        contacts.getContentPane().add(searchbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 100, 40));

        searchtf.setFont(new java.awt.Font("Andalus", 0, 18)); // NOI18N
        searchtf.setForeground(new java.awt.Color(102, 255, 255));
        searchtf.setText("  Search by First Name.....");
        searchtf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        searchtf.setOpaque(false);
        searchtf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchtfMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                searchtfMouseExited(evt);
            }
        });
        contacts.getContentPane().add(searchtf, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 430, 40));

        addcontact.setForeground(new java.awt.Color(255, 255, 255));
        addcontact.setOpaque(false);
        addcontact.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel82.setFont(new java.awt.Font("Andalus", 1, 22)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(255, 255, 255));
        jLabel82.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel82.setText("Add a Contact");
        jLabel82.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        addcontact.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 540, 40));

        jLabel83.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(255, 255, 255));
        jLabel83.setText("Enter Last Name");
        addcontact.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 200, 40));

        fnametf.setFont(new java.awt.Font("Andalus", 0, 18)); // NOI18N
        addcontact.add(fnametf, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 210, 40));

        jLabel84.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(255, 255, 255));
        jLabel84.setText("Enter First Name");
        addcontact.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 200, 40));

        lnametf.setFont(new java.awt.Font("Andalus", 0, 18)); // NOI18N
        addcontact.add(lnametf, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 210, 40));

        jLabel85.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(255, 255, 255));
        jLabel85.setText("Enter the Number");
        addcontact.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 190, 40));

        numtf1.setFont(new java.awt.Font("Andalus", 0, 18)); // NOI18N
        addcontact.add(numtf1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 210, 40));

        addcntct.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        addcntct.setForeground(new java.awt.Color(255, 255, 255));
        addcntct.setText("Add Contact");
        addcntct.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        addcntct.setContentAreaFilled(false);
        addcntct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addcntctActionPerformed(evt);
            }
        });
        addcontact.add(addcntct, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, 160, 50));

        contacts.getContentPane().add(addcontact, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 268, 590, 420));

        jLabel81.setIcon(new javax.swing.ImageIcon(getClass().getResource("/contact back2.jpg"))); // NOI18N
        contacts.getContentPane().add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 730));

        jMenu5.setText("File");

        jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem9.setText("Jump to Home screen");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem9);

        jMenuItem10.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem10.setText("Jump to App Drawer");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem10);

        jMenuItem11.setText("Exit jPieroid OS");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem11);

        jMenuBar3.add(jMenu5);

        jMenu6.setText("Help");

        jMenuItem12.setText("About Me..");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem12);

        jMenuBar3.add(jMenu6);

        contacts.setJMenuBar(jMenuBar3);

        ssettings.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        ssettings.setTitle("jPieroid OS | Security Settings");
        ssettings.setMinimumSize(new java.awt.Dimension(1024, 610));
        ssettings.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Andalus", 1, 48)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Security Settings");
        jLabel24.setPreferredSize(new java.awt.Dimension(1024, 47));
        ssettings.getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, -1, -1));

        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        jLabel26.setFont(new java.awt.Font("Andalus", 1, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Change Password");
        jPanel1.add(jLabel26);
        jLabel26.setBounds(0, 20, 480, 38);

        jLabel27.setFont(new java.awt.Font("Andalus", 1, 24)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Current Username");
        jPanel1.add(jLabel27);
        jLabel27.setBounds(10, 70, 220, 30);

        curuser2TF.setFont(new java.awt.Font("Andalus", 0, 18)); // NOI18N
        jPanel1.add(curuser2TF);
        curuser2TF.setBounds(240, 70, 230, 30);

        jLabel28.setFont(new java.awt.Font("Andalus", 1, 24)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Current password");
        jPanel1.add(jLabel28);
        jLabel28.setBounds(10, 110, 210, 30);

        newpassTF.setFont(new java.awt.Font("Andalus", 0, 18)); // NOI18N
        jPanel1.add(newpassTF);
        newpassTF.setBounds(240, 150, 230, 30);

        jLabel29.setFont(new java.awt.Font("Andalus", 1, 24)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("New Password");
        jPanel1.add(jLabel29);
        jLabel29.setBounds(10, 150, 220, 30);

        jButton2.setFont(new java.awt.Font("Andalus", 1, 24)); // NOI18N
        jButton2.setText("Submit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(170, 220, 120, 47);

        curpass2TF.setFont(new java.awt.Font("Andalus", 0, 18)); // NOI18N
        jPanel1.add(curpass2TF);
        curpass2TF.setBounds(240, 110, 230, 30);

        ssettings.getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 130, 490, 300));

        jPanel2.setOpaque(false);

        jLabel30.setFont(new java.awt.Font("Andalus", 1, 24)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Change Username");

        curuserTF.setFont(new java.awt.Font("Andalus", 0, 18)); // NOI18N

        jLabel32.setFont(new java.awt.Font("Andalus", 1, 24)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Current password");

        jLabel33.setFont(new java.awt.Font("Andalus", 1, 24)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("New Username");

        newuserTF.setFont(new java.awt.Font("Andalus", 0, 18)); // NOI18N

        jButton1.setFont(new java.awt.Font("Andalus", 1, 24)); // NOI18N
        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        curpassTF.setFont(new java.awt.Font("Andalus", 0, 18)); // NOI18N

        jLabel63.setFont(new java.awt.Font("Andalus", 1, 24)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(255, 255, 255));
        jLabel63.setText("Current Username");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(jButton1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(newuserTF, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                                .addGap(10, 10, 10))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel63)
                                .addGap(12, 12, 12)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(curuserTF, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                            .addComponent(curpassTF, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(curuserTF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(curpassTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel33, 0, 0, Short.MAX_VALUE)
                    .addComponent(newuserTF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jButton1)
                .addContainerGap())
        );

        ssettings.getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        backbutton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/android-system-back (2).png"))); // NOI18N
        backbutton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbutton3ActionPerformed(evt);
            }
        });
        ssettings.getContentPane().add(backbutton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 490, 290, 60));

        homebutton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home-home-icon-90085 (2).png"))); // NOI18N
        homebutton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homebutton3ActionPerformed(evt);
            }
        });
        ssettings.getContentPane().add(homebutton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 490, 330, -1));

        powbutton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/power-xxl (1).png"))); // NOI18N
        powbutton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                powbutton3ActionPerformed(evt);
            }
        });
        ssettings.getContentPane().add(powbutton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 340, -1));

        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/2560x1440-white-solid-color-ba.jpg"))); // NOI18N
        ssettings.getContentPane().add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 1020, 60));

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/settingsback3.png"))); // NOI18N
        ssettings.getContentPane().add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 550));

        jMenu7.setText("File");

        jMenuItem13.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem13.setText("Jump to Home screen");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem13);

        jMenuItem14.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem14.setText("Jump to App Drawer");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem14);

        jMenuItem15.setText("Exit jPieroid OS");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem15);

        jMenuBar4.add(jMenu7);

        jMenu8.setText("Help");

        jMenuItem16.setText("About Me..");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem16);

        jMenuBar4.add(jMenu8);

        ssettings.setJMenuBar(jMenuBar4);

        nextprime.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        nextprime.setTitle("jPieroid OS | Next Prime Number");
        nextprime.setMinimumSize(new java.awt.Dimension(1024, 640));

        powbutton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/power-xxl (1).png"))); // NOI18N
        powbutton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                powbutton4ActionPerformed(evt);
            }
        });

        homebutton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home-home-icon-90085 (2).png"))); // NOI18N
        homebutton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homebutton4ActionPerformed(evt);
            }
        });

        backbutton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/android-system-back (2).png"))); // NOI18N
        backbutton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbutton4ActionPerformed(evt);
            }
        });

        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/2560x1440-white-solid-color-ba.jpg"))); // NOI18N

        jScrollPane5.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane5.setPreferredSize(new java.awt.Dimension(1000, 330));

        jPanel3.setMaximumSize(new java.awt.Dimension(5000, 300));
        jPanel3.setMinimumSize(new java.awt.Dimension(1024, 300));
        jPanel3.setPreferredSize(new java.awt.Dimension(5000, 300));

        t1.setFont(new java.awt.Font("Andalus", 0, 18)); // NOI18N

        jLabel36.setFont(new java.awt.Font("Andalus", 1, 24)); // NOI18N
        jLabel36.setText("Enter a number");

        t2.setEditable(false);
        t2.setFont(new java.awt.Font("Andalus", 0, 18)); // NOI18N

        jLabel37.setFont(new java.awt.Font("Andalus", 1, 24)); // NOI18N
        jLabel37.setText("Next Prime number is ");

        jButton3.setFont(new java.awt.Font("Andalus", 1, 24)); // NOI18N
        jButton3.setText("Submit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Andalus", 1, 24)); // NOI18N
        jButton4.setText("Clear");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(163, 163, 163)
                        .addComponent(jButton4))
                    .addComponent(t1, javax.swing.GroupLayout.DEFAULT_SIZE, 4722, Short.MAX_VALUE)
                    .addComponent(t2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 4722, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37))
                .addGap(71, 71, 71)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton3))
                .addContainerGap(98, Short.MAX_VALUE))
        );

        jScrollPane5.setViewportView(jPanel3);

        jMenu9.setText("File");

        jMenuItem17.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem17.setText("Jump to Home screen");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem17);

        jMenuItem18.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem18.setText("Jump to App Drawer");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem18);

        jMenuItem19.setText("Exit jPieroid OS");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem19);

        jMenuBar5.add(jMenu9);

        jMenu10.setText("Help");

        jMenuItem20.setText("About Me..");
        jMenuItem20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem20ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem20);

        jMenuBar5.add(jMenu10);

        nextprime.setJMenuBar(jMenuBar5);

        javax.swing.GroupLayout nextprimeLayout = new javax.swing.GroupLayout(nextprime.getContentPane());
        nextprime.getContentPane().setLayout(nextprimeLayout);
        nextprimeLayout.setHorizontalGroup(
            nextprimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nextprimeLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 990, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(nextprimeLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(powbutton4, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(nextprimeLayout.createSequentialGroup()
                .addGap(700, 700, 700)
                .addComponent(backbutton4, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel38)
            .addGroup(nextprimeLayout.createSequentialGroup()
                .addGap(360, 360, 360)
                .addComponent(homebutton4, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        nextprimeLayout.setVerticalGroup(
            nextprimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nextprimeLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(155, 155, 155)
                .addGroup(nextprimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(nextprimeLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(powbutton4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(nextprimeLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(backbutton4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(nextprimeLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(homebutton4))))
        );

        calculator.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        calculator.setTitle("jPieroid OS | Calculator");
        calculator.setForeground(java.awt.Color.white);
        calculator.setMinimumSize(new java.awt.Dimension(500, 520));

        b1.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        b1.setText("1");
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });

        b7.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        b7.setText("7");
        b7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b7ActionPerformed(evt);
            }
        });

        b4.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        b4.setText("4");
        b4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b4ActionPerformed(evt);
            }
        });

        b0.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        b0.setText("0");
        b0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b0ActionPerformed(evt);
            }
        });

        b5.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        b5.setText("5");
        b5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b5ActionPerformed(evt);
            }
        });

        b8.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        b8.setText("8");
        b8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b8ActionPerformed(evt);
            }
        });

        b2.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        b2.setText("2");
        b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2ActionPerformed(evt);
            }
        });

        b6.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        b6.setText("6");
        b6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b6ActionPerformed(evt);
            }
        });

        b9.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        b9.setText("9");
        b9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b9ActionPerformed(evt);
            }
        });

        jButton14.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jButton14.setText("+");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        b3.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        b3.setText("3");
        b3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b3ActionPerformed(evt);
            }
        });

        jButton17.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jButton17.setText(".");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton16.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        jButton16.setText("=");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        t.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        t.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        t.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tActionPerformed(evt);
            }
        });

        jButton12.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jButton12.setText("-");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jButton13.setText("x");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton19.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jButton19.setText("/");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jButton20.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jButton20.setText("+/-");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jButton21.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jButton21.setText("CE");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        jButton22.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        jButton22.setText("√");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(b1, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                            .addComponent(b7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(b4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(b8, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                            .addComponent(b5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(b2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(b0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(b9, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                                .addComponent(jButton21, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(b6, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(b3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                                        .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton16, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE))))
                        .addContainerGap())))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(t)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(t, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(b7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .addComponent(b9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(b8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(b6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                            .addComponent(b5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(b3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(b2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(b0, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(19, 19, 19))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        homebutton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home-home-icon-90085 (2).png"))); // NOI18N
        homebutton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homebutton5ActionPerformed(evt);
            }
        });

        backbutton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/android-system-back (2).png"))); // NOI18N
        backbutton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbutton5ActionPerformed(evt);
            }
        });

        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/2560x1440-white-solid-color-ba.jpg"))); // NOI18N

        jMenu11.setText("File");

        jMenuItem21.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem21.setText("Jump to Home screen");
        jMenuItem21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem21ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem21);

        jMenuItem22.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem22.setText("Jump to App Drawer");
        jMenuItem22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem22ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem22);

        jMenuItem23.setText("Exit jPieroid OS");
        jMenuItem23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem23ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem23);

        jMenuBar6.add(jMenu11);

        jMenu12.setText("Help");

        jMenuItem24.setText("About Me..");
        jMenuItem24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem24ActionPerformed(evt);
            }
        });
        jMenu12.add(jMenuItem24);

        jMenuBar6.add(jMenu12);

        calculator.setJMenuBar(jMenuBar6);

        javax.swing.GroupLayout calculatorLayout = new javax.swing.GroupLayout(calculator.getContentPane());
        calculator.getContentPane().setLayout(calculatorLayout);
        calculatorLayout.setHorizontalGroup(
            calculatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(calculatorLayout.createSequentialGroup()
                .addGroup(calculatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(calculatorLayout.createSequentialGroup()
                        .addComponent(homebutton5, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(backbutton5, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(calculatorLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
            .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        calculatorLayout.setVerticalGroup(
            calculatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(calculatorLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(calculatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(homebutton5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backbutton5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        aboutus.setTitle("jPieroid OS | About Us");
        aboutus.setMinimumSize(new java.awt.Dimension(445, 460));

        jLabel40.setFont(new java.awt.Font("Andalus", 1, 36)); // NOI18N
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("About Me");

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Andalus", 0, 18)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("Hey There!! \nI am  the student of class 12 currently persuing IP as an optional subject. As an annual project, I made jPieroid Simulator which would function similar to an Android interface. \nIt's a user friendly interface which can be operated by anyone.\nAs an enthusiast, I introduced some extra features in my project which helped me to learn more ...");
        jTextArea1.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel41.setFont(new java.awt.Font("Andalus", 0, 14)); // NOI18N
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("jPieroid OS version 2.0.1.            ©All Rights Reserved..");

        jButton5.setText("OK");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel57.setFont(new java.awt.Font("Andalus", 1, 24)); // NOI18N
        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel57.setText("Created by- K. Dushyant Reddy");

        javax.swing.GroupLayout aboutusLayout = new javax.swing.GroupLayout(aboutus.getContentPane());
        aboutus.getContentPane().setLayout(aboutusLayout);
        aboutusLayout.setHorizontalGroup(
            aboutusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
            .addGroup(aboutusLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                .addGap(10, 10, 10))
            .addGroup(aboutusLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(aboutusLayout.createSequentialGroup()
                .addGap(178, 178, 178)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(191, Short.MAX_VALUE))
            .addGroup(aboutusLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel57, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                .addGap(50, 50, 50))
        );
        aboutusLayout.setVerticalGroup(
            aboutusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aboutusLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addGap(18, 18, 18)
                .addComponent(jLabel57)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        billing.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        billing.setTitle("jPieroid OS | Grizzy Bear - Menu");
        billing.setMinimumSize(new java.awt.Dimension(1024, 576));

        jLabel42.setText("Food Name");

        fnameTF.setEditable(false);

        jLabel43.setText("Food Type");

        ftypeTF.setEditable(false);

        jLabel44.setText("Price");

        FpriceTF.setEditable(false);

        jLabel45.setText("Quantity");

        FquantityTF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                FquantityTFMouseExited(evt);
            }
        });
        FquantityTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FquantityTFActionPerformed(evt);
            }
        });
        FquantityTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FquantityTFKeyReleased(evt);
            }
        });

        jLabel46.setText("Amount");

        famountTF.setEditable(false);

        jLabel47.setText("Total Price");

        ftpriceTF.setEditable(false);
        ftpriceTF.setText("0");

        jLabel48.setFont(new java.awt.Font("Andalus", 1, 28)); // NOI18N
        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel48.setText("Menu Items");

        drinksCmB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "DRINKS", "Tea\t", "Coffee", "Soda", "Soft Drink", "Lime Soda", "Vanilla Shake", "Chocolate Shake", "Strawberry Shake" }));
        drinksCmB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                drinksCmBItemStateChanged(evt);
            }
        });

        dalCmB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "DAL", "Dal Fry", "Dal Tadka", "Dal Makhani", "Dal Palak", "Dal Moghlai", " " }));
        dalCmB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                dalCmBItemStateChanged(evt);
            }
        });

        soupCmB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SOUP", "Tomato Soup", "Veg Manchow", "Veg Noddles", "Palak Soup", "Sweet Corn Noddles" }));
        soupCmB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                soupCmBItemStateChanged(evt);
            }
        });

        vegCmB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SHAKAHARI KHAZANA", "Veg Handi", "Mix Vegetables", "Dum Aloo", "Aloo Mutter", "Karela Masala", "Chana Masala", "Panneer Tikka", "Chhole Bhature", "Kaju Masala", "Mushroom Fry" }));
        vegCmB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                vegCmBItemStateChanged(evt);
            }
        });

        SouthCmB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SOUTH INDIAN", "Sada Dosa\t", "Masala Dosa", "Uttapam", "Rava Dosa", "Rava Masala", "Spring Masala" }));
        SouthCmB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                SouthCmBItemStateChanged(evt);
            }
        });

        sandwichCmB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SANDWICH", "Veg Sandwich", "Chatni Sandwich", "Omlet Sandwich", "Cheese Sandwich", "Club Sandwich", "Veg Grill Sandwich", "Diamond Club Sandwich" }));
        sandwichCmB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                sandwichCmBItemStateChanged(evt);
            }
        });

        chappatiCmB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CHAPATI", "Roti", "Paratha", "Naan", "Chapati", "Garlic Naan", "Kashmiri Naan" }));
        chappatiCmB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chappatiCmBItemStateChanged(evt);
            }
        });

        riceCmB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "RICE", "Plain Rice", "Jeera Rice", "Veg Fried Rice", "Jera Fried Rice", "Panner Fried Rice" }));
        riceCmB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                riceCmBItemStateChanged(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Andalus", 1, 24)); // NOI18N
        jButton6.setText("Add To Bill");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        backbutton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/android-system-back (2).png"))); // NOI18N
        backbutton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbutton6ActionPerformed(evt);
            }
        });

        homebutton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home-home-icon-90085 (2).png"))); // NOI18N
        homebutton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homebutton6ActionPerformed(evt);
            }
        });

        powbutton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/power-xxl (1).png"))); // NOI18N
        powbutton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                powbutton5ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Andalus", 1, 24)); // NOI18N
        jButton7.setText("Show Bill");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton11.setFont(new java.awt.Font("Andalus", 1, 24)); // NOI18N
        jButton11.setText("Clear");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jMenu13.setText("File");

        jMenuItem25.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem25.setText("Jump to Home screen");
        jMenuItem25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem25ActionPerformed(evt);
            }
        });
        jMenu13.add(jMenuItem25);

        jMenuItem26.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem26.setText("Jump to App Drawer");
        jMenuItem26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem26ActionPerformed(evt);
            }
        });
        jMenu13.add(jMenuItem26);

        jMenuItem27.setText("Exit jPieroid OS");
        jMenuItem27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem27ActionPerformed(evt);
            }
        });
        jMenu13.add(jMenuItem27);

        jMenuBar7.add(jMenu13);

        jMenu14.setText("Help");
        jMenu14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu14ActionPerformed(evt);
            }
        });

        jMenuItem28.setText("About Me..");
        jMenuItem28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem28ActionPerformed(evt);
            }
        });
        jMenu14.add(jMenuItem28);

        jMenuBar7.add(jMenu14);

        billing.setJMenuBar(jMenuBar7);

        javax.swing.GroupLayout billingLayout = new javax.swing.GroupLayout(billing.getContentPane());
        billing.getContentPane().setLayout(billingLayout);
        billingLayout.setHorizontalGroup(
            billingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, billingLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(billingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(billingLayout.createSequentialGroup()
                        .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87)
                        .addComponent(fnameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(billingLayout.createSequentialGroup()
                        .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87)
                        .addComponent(ftypeTF, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(billingLayout.createSequentialGroup()
                        .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87)
                        .addComponent(FpriceTF, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(billingLayout.createSequentialGroup()
                        .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87)
                        .addComponent(FquantityTF, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(billingLayout.createSequentialGroup()
                        .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87)
                        .addComponent(famountTF, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(billingLayout.createSequentialGroup()
                        .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87)
                        .addComponent(ftpriceTF, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(billingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(billingLayout.createSequentialGroup()
                        .addGroup(billingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(chappatiCmB, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sandwichCmB, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(drinksCmB, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(billingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(vegCmB, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(soupCmB, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SouthCmB, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(billingLayout.createSequentialGroup()
                        .addComponent(riceCmB, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dalCmB, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, billingLayout.createSequentialGroup()
                .addGroup(billingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(billingLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(powbutton5, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(homebutton6, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(billingLayout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(billingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backbutton6, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        billingLayout.setVerticalGroup(
            billingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(billingLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(billingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(billingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fnameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(SouthCmB, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(drinksCmB, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addGroup(billingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(billingLayout.createSequentialGroup()
                        .addGroup(billingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ftypeTF, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(billingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FpriceTF, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(billingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FquantityTF, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(billingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(famountTF, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(billingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ftpriceTF, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(billingLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(billingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sandwichCmB, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(vegCmB, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(billingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chappatiCmB, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(soupCmB, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(billingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(riceCmB, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dalCmB, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(49, 49, 49)
                .addGroup(billingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addGroup(billingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(powbutton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(backbutton6, javax.swing.GroupLayout.Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
                    .addComponent(homebutton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE))
                .addContainerGap())
        );

        billtable.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        billtable.setTitle("jPieroid OS | Grizzy Bear | Bill");
        billtable.setMinimumSize(new java.awt.Dimension(1024, 600));

        billTB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Food Name", "Price", "Quantity", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(billTB);

        jLabel49.setFont(new java.awt.Font("Andalus", 3, 24)); // NOI18N
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel49.setText("Your Bill, Restaurant");

        jLabel50.setFont(new java.awt.Font("Andalus", 3, 18)); // NOI18N
        jLabel50.setText("Total Amount");

        totalamtTF.setEditable(false);

        jButton8.setFont(new java.awt.Font("Andalus", 1, 24)); // NOI18N
        jButton8.setText("Place This Restaurant Order");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        powbutton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/power-xxl (1).png"))); // NOI18N
        powbutton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                powbutton6ActionPerformed(evt);
            }
        });

        homebutton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home-home-icon-90085 (2).png"))); // NOI18N
        homebutton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homebutton7ActionPerformed(evt);
            }
        });

        backbutton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/android-system-back (2).png"))); // NOI18N
        backbutton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbutton7ActionPerformed(evt);
            }
        });

        jButton23.setFont(new java.awt.Font("Andalus", 1, 24)); // NOI18N
        jButton23.setText("Clear");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout billtableLayout = new javax.swing.GroupLayout(billtable.getContentPane());
        billtable.getContentPane().setLayout(billtableLayout);
        billtableLayout.setHorizontalGroup(
            billtableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
            .addComponent(jLabel49, javax.swing.GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
            .addGroup(billtableLayout.createSequentialGroup()
                .addGroup(billtableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(billtableLayout.createSequentialGroup()
                        .addGap(271, 271, 271)
                        .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(totalamtTF, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 283, Short.MAX_VALUE))
                    .addGroup(billtableLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(billtableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(billtableLayout.createSequentialGroup()
                                .addComponent(powbutton6, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(homebutton7, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(backbutton7, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(billtableLayout.createSequentialGroup()
                                .addComponent(jButton8)
                                .addGap(123, 123, 123)
                                .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(270, 270, 270)))))
                .addContainerGap())
        );
        billtableLayout.setVerticalGroup(
            billtableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(billtableLayout.createSequentialGroup()
                .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(billtableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalamtTF, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(billtableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(billtableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(powbutton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(backbutton7, javax.swing.GroupLayout.Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
                    .addComponent(homebutton7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gblogin.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        gblogin.setTitle("jPieroid OS | Grizzy Bear Login");
        gblogin.setMinimumSize(new java.awt.Dimension(1024, 576));
        gblogin.getContentPane().setLayout(null);

        jLabel51.setFont(new java.awt.Font("Andalus", 1, 48)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel51.setText("Restaurant User Login");
        gblogin.getContentPane().add(jLabel51);
        jLabel51.setBounds(110, 70, 900, 50);

        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/grizzy bear.png"))); // NOI18N
        gblogin.getContentPane().add(jLabel52);
        jLabel52.setBounds(15, 10, 210, 210);

        jButton10.setFont(new java.awt.Font("Andalus", 1, 24)); // NOI18N
        jButton10.setText("BACK");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        gblogin.getContentPane().add(jButton10);
        jButton10.setBounds(550, 400, 250, 50);

        jLabel53.setFont(new java.awt.Font("Andalus", 1, 24)); // NOI18N
        jLabel53.setText("Enter your Username");
        gblogin.getContentPane().add(jLabel53);
        jLabel53.setBounds(250, 220, 250, 40);

        gbuserTF.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        gblogin.getContentPane().add(gbuserTF);
        gbuserTF.setBounds(550, 220, 250, 40);

        jButton9.setFont(new java.awt.Font("Andalus", 1, 24)); // NOI18N
        jButton9.setText("LOGIN");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        gblogin.getContentPane().add(jButton9);
        jButton9.setBounds(250, 400, 220, 50);

        gbpassPF.setFont(new java.awt.Font("Andalus", 1, 24)); // NOI18N
        gblogin.getContentPane().add(gbpassPF);
        gbpassPF.setBounds(550, 280, 250, 40);

        jLabel54.setFont(new java.awt.Font("Andalus", 1, 24)); // NOI18N
        jLabel54.setText("Enter your Password");
        gblogin.getContentPane().add(jLabel54);
        jLabel54.setBounds(250, 280, 250, 40);

        jLabel55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app back1.jpg"))); // NOI18N
        gblogin.getContentPane().add(jLabel55);
        jLabel55.setBounds(0, 0, 1024, 576);

        settings.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        settings.setTitle("jPieroid OS | Settings");
        settings.setMinimumSize(new java.awt.Dimension(1024, 640));
        settings.getContentPane().setLayout(null);

        powbutton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/power-xxl (1).png"))); // NOI18N
        powbutton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                powbutton7ActionPerformed(evt);
            }
        });
        settings.getContentPane().add(powbutton7);
        powbutton7.setBounds(0, 520, 350, 60);

        homebutton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home-home-icon-90085 (2).png"))); // NOI18N
        homebutton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homebutton8ActionPerformed(evt);
            }
        });
        settings.getContentPane().add(homebutton8);
        homebutton8.setBounds(360, 520, 310, 60);

        backbutton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/android-system-back (2).png"))); // NOI18N
        backbutton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbutton8ActionPerformed(evt);
            }
        });
        settings.getContentPane().add(backbutton8);
        backbutton8.setBounds(690, 520, 330, 60);

        jLabel59.setIcon(new javax.swing.ImageIcon(getClass().getResource("/2560x1440-white-solid-color-ba.jpg"))); // NOI18N
        jLabel59.setText("jLabel23");
        settings.getContentPane().add(jLabel59);
        jLabel59.setBounds(0, 520, 1020, 60);

        displaybut.setFont(new java.awt.Font("Andalus", 1, 24)); // NOI18N
        displaybut.setForeground(new java.awt.Color(255, 255, 255));
        displaybut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/displaysetting.png"))); // NOI18N
        displaybut.setText("    Change Background");
        displaybut.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        displaybut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displaybutActionPerformed(evt);
            }
        });
        settings.getContentPane().add(displaybut);
        displaybut.setBounds(210, 180, 560, 100);

        userbut.setFont(new java.awt.Font("Andalus", 1, 24)); // NOI18N
        userbut.setForeground(new java.awt.Color(255, 255, 255));
        userbut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/changeuser.png"))); // NOI18N
        userbut.setText("    Change Your Avatar");
        userbut.setBorder(null);
        userbut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userbutActionPerformed(evt);
            }
        });
        settings.getContentPane().add(userbut);
        userbut.setBounds(210, 30, 560, 100);

        passchangebut.setFont(new java.awt.Font("Andalus", 1, 24)); // NOI18N
        passchangebut.setForeground(new java.awt.Color(255, 255, 255));
        passchangebut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/passicon.png"))); // NOI18N
        passchangebut.setText("        Security Settings");
        passchangebut.setBorder(null);
        passchangebut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passchangebutActionPerformed(evt);
            }
        });
        settings.getContentPane().add(passchangebut);
        passchangebut.setBounds(210, 340, 560, 100);
        settings.getContentPane().add(jSeparator1);
        jSeparator1.setBounds(0, 310, 1020, 30);
        settings.getContentPane().add(jSeparator2);
        jSeparator2.setBounds(0, 460, 1020, 30);
        settings.getContentPane().add(jSeparator3);
        jSeparator3.setBounds(0, 160, 1020, 30);

        jLabel58.setIcon(new javax.swing.ImageIcon(getClass().getResource("/settingback4.jpg"))); // NOI18N
        settings.getContentPane().add(jLabel58);
        jLabel58.setBounds(0, 0, 1020, 520);

        jMenu15.setText("File");

        jMenuItem29.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem29.setText("Jump to Home screen");
        jMenuItem29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem29ActionPerformed(evt);
            }
        });
        jMenu15.add(jMenuItem29);

        jMenuItem30.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem30.setText("Jump to App Drawer");
        jMenuItem30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem30ActionPerformed(evt);
            }
        });
        jMenu15.add(jMenuItem30);

        jMenuItem31.setText("Exit jPieroid OS");
        jMenuItem31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem31ActionPerformed(evt);
            }
        });
        jMenu15.add(jMenuItem31);

        jMenuBar8.add(jMenu15);

        jMenu16.setText("Help");

        jMenuItem32.setText("About Me..");
        jMenuItem32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem32ActionPerformed(evt);
            }
        });
        jMenu16.add(jMenuItem32);

        jMenuBar8.add(jMenu16);

        settings.setJMenuBar(jMenuBar8);

        changeback.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        changeback.setTitle("jPieroid OS | Change Background");
        changeback.setMinimumSize(new java.awt.Dimension(1024, 640));
        changeback.getContentPane().setLayout(null);

        jLabel60.setFont(new java.awt.Font("Andalus", 1, 24)); // NOI18N
        jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel60.setText("Change Login Screen Background");
        changeback.getContentPane().add(jLabel60);
        jLabel60.setBounds(2, 252, 1040, 40);

        powbutton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/power-xxl (1).png"))); // NOI18N
        powbutton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                powbutton8ActionPerformed(evt);
            }
        });
        changeback.getContentPane().add(powbutton8);
        powbutton8.setBounds(2, 522, 290, 59);

        homebutton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home-home-icon-90085 (2).png"))); // NOI18N
        homebutton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homebutton9ActionPerformed(evt);
            }
        });
        changeback.getContentPane().add(homebutton9);
        homebutton9.setBounds(352, 522, 330, 59);

        backbutton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/android-system-back (2).png"))); // NOI18N
        backbutton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbutton9ActionPerformed(evt);
            }
        });
        changeback.getContentPane().add(backbutton9);
        backbutton9.setBounds(732, 522, 280, 60);

        jLabel61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/2560x1440-white-solid-color-ba.jpg"))); // NOI18N
        jLabel61.setText("jLabel23");
        changeback.getContentPane().add(jLabel61);
        jLabel61.setBounds(2, 522, 1020, 60);

        jScrollPane3.setBorder(null);
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane3.setPreferredSize(new java.awt.Dimension(1024, 200));

        wallbut1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/back1 icon.jpg"))); // NOI18N
        wallbut1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wallbut1ActionPerformed(evt);
            }
        });

        wallbut2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/back2 icon.jpg"))); // NOI18N
        wallbut2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wallbut2ActionPerformed(evt);
            }
        });

        wallbut3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/back3 icon.jpg"))); // NOI18N
        wallbut3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wallbut3ActionPerformed(evt);
            }
        });

        wallbut4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/back4 icon.jpg"))); // NOI18N
        wallbut4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wallbut4ActionPerformed(evt);
            }
        });

        wallbut5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/back5 icon.jpg"))); // NOI18N
        wallbut5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wallbut5ActionPerformed(evt);
            }
        });

        wallbut6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/back6 icon.jpg"))); // NOI18N
        wallbut6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wallbut6ActionPerformed(evt);
            }
        });

        wallbut7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/back7icon.jpg"))); // NOI18N
        wallbut7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wallbut7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(wallbut1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(wallbut2, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(wallbut3, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(wallbut4, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(wallbut5, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(wallbut6, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(wallbut7, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(wallbut2, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                    .addComponent(wallbut1, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                    .addComponent(wallbut7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                    .addComponent(wallbut4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                    .addComponent(wallbut3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                    .addComponent(wallbut5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                    .addComponent(wallbut6, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
                .addContainerGap())
        );

        jScrollPane3.setViewportView(jPanel5);

        changeback.getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(2, 302, 1024, 200);

        jScrollPane4.setBorder(null);
        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane4.setPreferredSize(new java.awt.Dimension(1024, 200));

        wallbut8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/back1 icon.jpg"))); // NOI18N
        wallbut8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wallbut8ActionPerformed(evt);
            }
        });

        wallbut9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/back2 icon.jpg"))); // NOI18N
        wallbut9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wallbut9ActionPerformed(evt);
            }
        });

        wallbut10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/back3 icon.jpg"))); // NOI18N
        wallbut10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wallbut10ActionPerformed(evt);
            }
        });

        wallbut11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/back4 icon.jpg"))); // NOI18N
        wallbut11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wallbut11ActionPerformed(evt);
            }
        });

        wallbut12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/back5 icon.jpg"))); // NOI18N
        wallbut12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wallbut12ActionPerformed(evt);
            }
        });

        wallbut13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/back6 icon.jpg"))); // NOI18N
        wallbut13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wallbut13ActionPerformed(evt);
            }
        });

        wallbut14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/back7icon.jpg"))); // NOI18N
        wallbut14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wallbut14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(wallbut8, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(wallbut9, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(wallbut10, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(wallbut11, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(wallbut12, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(wallbut13, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(wallbut14, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(wallbut9, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                    .addComponent(wallbut8, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                    .addComponent(wallbut14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                    .addComponent(wallbut11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                    .addComponent(wallbut10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                    .addComponent(wallbut12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                    .addComponent(wallbut13, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
                .addContainerGap())
        );

        jScrollPane4.setViewportView(jPanel6);

        changeback.getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(18, 41, 1024, 200);

        jLabel62.setFont(new java.awt.Font("Andalus", 1, 24)); // NOI18N
        jLabel62.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel62.setText("Change Home Screen Background");
        changeback.getContentPane().add(jLabel62);
        jLabel62.setBounds(0, 0, 1040, 40);

        jMenu17.setText("File");

        jMenuItem33.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem33.setText("Jump to Home screen");
        jMenuItem33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem33ActionPerformed(evt);
            }
        });
        jMenu17.add(jMenuItem33);

        jMenuItem34.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem34.setText("Jump to App Drawer");
        jMenuItem34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem34ActionPerformed(evt);
            }
        });
        jMenu17.add(jMenuItem34);

        jMenuItem35.setText("Exit jPieroid OS");
        jMenuItem35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem35ActionPerformed(evt);
            }
        });
        jMenu17.add(jMenuItem35);

        jMenuBar9.add(jMenu17);

        jMenu18.setText("Help");

        jMenuItem36.setText("About Me..");
        jMenuItem36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem36ActionPerformed(evt);
            }
        });
        jMenu18.add(jMenuItem36);

        jMenuBar9.add(jMenu18);

        changeback.setJMenuBar(jMenuBar9);

        changeavatar.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        changeavatar.setTitle("jPieroid OS | Change Avatar");
        changeavatar.setMinimumSize(new java.awt.Dimension(1024, 640));
        changeavatar.getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Andalus", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Choose Your Avatar ");
        changeavatar.getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1020, 20);

        userbut1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/user1.png"))); // NOI18N
        userbut1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userbut1ActionPerformed(evt);
            }
        });
        changeavatar.getContentPane().add(userbut1);
        userbut1.setBounds(0, 20, 170, 160);

        userbut2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/user2.png"))); // NOI18N
        userbut2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userbut2ActionPerformed(evt);
            }
        });
        changeavatar.getContentPane().add(userbut2);
        userbut2.setBounds(840, 362, 170, 160);

        userbut3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/user3.png"))); // NOI18N
        userbut3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userbut3ActionPerformed(evt);
            }
        });
        changeavatar.getContentPane().add(userbut3);
        userbut3.setBounds(210, 192, 170, 160);

        userbut4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/user4.png"))); // NOI18N
        userbut4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userbut4ActionPerformed(evt);
            }
        });
        changeavatar.getContentPane().add(userbut4);
        userbut4.setBounds(840, 26, 170, 160);

        userbut5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/user5.png"))); // NOI18N
        userbut5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userbut5ActionPerformed(evt);
            }
        });
        changeavatar.getContentPane().add(userbut5);
        userbut5.setBounds(0, 196, 170, 160);

        userbut6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/user6.png"))); // NOI18N
        userbut6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userbut6ActionPerformed(evt);
            }
        });
        changeavatar.getContentPane().add(userbut6);
        userbut6.setBounds(630, 26, 170, 160);

        userbut7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/user7.png"))); // NOI18N
        userbut7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userbut7ActionPerformed(evt);
            }
        });
        changeavatar.getContentPane().add(userbut7);
        userbut7.setBounds(420, 20, 170, 160);

        userbut8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/user8.png"))); // NOI18N
        userbut8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userbut8ActionPerformed(evt);
            }
        });
        changeavatar.getContentPane().add(userbut8);
        userbut8.setBounds(420, 196, 170, 160);

        userbut9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/user9.png"))); // NOI18N
        userbut9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userbut9ActionPerformed(evt);
            }
        });
        changeavatar.getContentPane().add(userbut9);
        userbut9.setBounds(630, 196, 170, 160);

        userbut10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/user10.png"))); // NOI18N
        userbut10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userbut10ActionPerformed(evt);
            }
        });
        changeavatar.getContentPane().add(userbut10);
        userbut10.setBounds(840, 196, 170, 160);

        userbut11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/user11.png"))); // NOI18N
        userbut11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userbut11ActionPerformed(evt);
            }
        });
        changeavatar.getContentPane().add(userbut11);
        userbut11.setBounds(0, 366, 170, 160);

        userbut12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/user12.png"))); // NOI18N
        userbut12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userbut12ActionPerformed(evt);
            }
        });
        changeavatar.getContentPane().add(userbut12);
        userbut12.setBounds(210, 366, 170, 160);

        userbut13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/user13.png"))); // NOI18N
        userbut13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userbut13ActionPerformed(evt);
            }
        });
        changeavatar.getContentPane().add(userbut13);
        userbut13.setBounds(420, 366, 170, 160);

        userbut14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/user14.png"))); // NOI18N
        userbut14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userbut14ActionPerformed(evt);
            }
        });
        changeavatar.getContentPane().add(userbut14);
        userbut14.setBounds(630, 366, 170, 160);

        userbut15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/user15.png"))); // NOI18N
        userbut15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userbut15ActionPerformed(evt);
            }
        });
        changeavatar.getContentPane().add(userbut15);
        userbut15.setBounds(210, 20, 170, 160);

        powbutton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/power-xxl (1).png"))); // NOI18N
        powbutton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                powbutton9ActionPerformed(evt);
            }
        });
        changeavatar.getContentPane().add(powbutton9);
        powbutton9.setBounds(0, 532, 290, 59);

        homebutton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home-home-icon-90085 (2).png"))); // NOI18N
        homebutton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homebutton10ActionPerformed(evt);
            }
        });
        changeavatar.getContentPane().add(homebutton10);
        homebutton10.setBounds(350, 532, 330, 59);

        backbutton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/android-system-back (2).png"))); // NOI18N
        backbutton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbutton10ActionPerformed(evt);
            }
        });
        changeavatar.getContentPane().add(backbutton10);
        backbutton10.setBounds(730, 532, 280, 60);

        jLabel64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/2560x1440-white-solid-color-ba.jpg"))); // NOI18N
        jLabel64.setText("jLabel23");
        changeavatar.getContentPane().add(jLabel64);
        jLabel64.setBounds(0, 532, 1020, 60);

        jMenu19.setText("File");

        jMenuItem37.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem37.setText("Jump to Home screen");
        jMenuItem37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem37ActionPerformed(evt);
            }
        });
        jMenu19.add(jMenuItem37);

        jMenuItem38.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem38.setText("Jump to App Drawer");
        jMenuItem38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem38ActionPerformed(evt);
            }
        });
        jMenu19.add(jMenuItem38);

        jMenuItem39.setText("Exit jPieroid OS");
        jMenuItem39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem39ActionPerformed(evt);
            }
        });
        jMenu19.add(jMenuItem39);

        jMenuBar10.add(jMenu19);

        jMenu20.setText("Help");

        jMenuItem40.setText("About Me..");
        jMenuItem40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem40ActionPerformed(evt);
            }
        });
        jMenu20.add(jMenuItem40);

        jMenuBar10.add(jMenu20);

        changeavatar.setJMenuBar(jMenuBar10);

        bullsandcows.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        bullsandcows.setTitle("jPieroid OS | Bulls and Cows");
        bullsandcows.setMinimumSize(new java.awt.Dimension(1024, 640));
        bullsandcows.getContentPane().setLayout(null);

        powbutton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/power-xxl (1).png"))); // NOI18N
        powbutton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                powbutton10ActionPerformed(evt);
            }
        });
        bullsandcows.getContentPane().add(powbutton10);
        powbutton10.setBounds(10, 520, 320, 59);

        homebutton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home-home-icon-90085 (2).png"))); // NOI18N
        homebutton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homebutton11ActionPerformed(evt);
            }
        });
        bullsandcows.getContentPane().add(homebutton11);
        homebutton11.setBounds(360, 520, 320, 59);

        backbutton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/android-system-back (2).png"))); // NOI18N
        backbutton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbutton11ActionPerformed(evt);
            }
        });
        bullsandcows.getContentPane().add(backbutton11);
        backbutton11.setBounds(720, 520, 300, 60);

        jLabel65.setIcon(new javax.swing.ImageIcon(getClass().getResource("/2560x1440-white-solid-color-ba.jpg"))); // NOI18N
        bullsandcows.getContentPane().add(jLabel65);
        jLabel65.setBounds(0, 520, 1024, 60);

        jLabel6.setFont(new java.awt.Font("Andalus", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Bulls and Cows");
        bullsandcows.getContentPane().add(jLabel6);
        jLabel6.setBounds(5, 0, 1020, 56);

        inputTF.setFont(new java.awt.Font("Andalus", 0, 24)); // NOI18N
        inputTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputTFActionPerformed(evt);
            }
        });
        bullsandcows.getContentPane().add(inputTF);
        inputTF.setBounds(640, 60, 240, 44);

        okbutton.setFont(new java.awt.Font("Andalus", 1, 24)); // NOI18N
        okbutton.setText("OK");
        okbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okbuttonActionPerformed(evt);
            }
        });
        bullsandcows.getContentPane().add(okbutton);
        okbutton.setBounds(900, 60, 100, 50);

        jLabel66.setFont(new java.awt.Font("Andalus", 0, 24)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(255, 255, 255));
        jLabel66.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel66.setText("Your Guess");
        bullsandcows.getContentPane().add(jLabel66);
        jLabel66.setBounds(500, 60, 120, 50);

        gamepanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel67.setFont(new java.awt.Font("Andalus", 1, 24)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(255, 255, 255));
        jLabel67.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel67.setText("Sr. No.");
        gamepanel.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 100, 40));

        jLabel89.setFont(new java.awt.Font("Andalus", 1, 24)); // NOI18N
        jLabel89.setForeground(new java.awt.Color(255, 255, 255));
        jLabel89.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel89.setText("Bulls");
        gamepanel.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 110, -1));

        jLabel100.setFont(new java.awt.Font("Andalus", 1, 24)); // NOI18N
        jLabel100.setForeground(new java.awt.Color(255, 255, 255));
        jLabel100.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel100.setText("Cows");
        gamepanel.add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 0, 100, -1));

        jLabel78.setFont(new java.awt.Font("Andalus", 1, 24)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(255, 255, 255));
        jLabel78.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel78.setText("Your Input");
        gamepanel.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, -1, -1));

        jLabel77.setFont(new java.awt.Font("Andalus", 0, 24)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(255, 255, 255));
        jLabel77.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel77.setText("10.");
        gamepanel.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, -1, 30));

        jLabel8.setFont(new java.awt.Font("Andalus", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("5.");
        gamepanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, 30));

        jLabel68.setFont(new java.awt.Font("Andalus", 0, 24)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(255, 255, 255));
        jLabel68.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel68.setText("1.");
        gamepanel.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, 30));

        jLabel69.setFont(new java.awt.Font("Andalus", 0, 24)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(255, 255, 255));
        jLabel69.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel69.setText("2.");
        gamepanel.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, 30));

        jLabel70.setFont(new java.awt.Font("Andalus", 0, 24)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(255, 255, 255));
        jLabel70.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel70.setText("4.");
        gamepanel.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 20, 30));

        jLabel71.setFont(new java.awt.Font("Andalus", 0, 24)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(255, 255, 255));
        jLabel71.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel71.setText("6.");
        gamepanel.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, 30));

        jLabel72.setFont(new java.awt.Font("Andalus", 0, 24)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(255, 255, 255));
        jLabel72.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel72.setText("3.");
        gamepanel.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, 30));

        jLabel73.setFont(new java.awt.Font("Andalus", 0, 24)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(255, 255, 255));
        jLabel73.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel73.setText("9.");
        gamepanel.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, -1, 30));

        jLabel74.setFont(new java.awt.Font("Andalus", 0, 24)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(255, 255, 255));
        jLabel74.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel74.setText("8.");
        gamepanel.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, 30));

        jLabel76.setFont(new java.awt.Font("Andalus", 0, 24)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(255, 255, 255));
        jLabel76.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel76.setText("7.");
        gamepanel.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, 30));

        inputlabel1.setFont(new java.awt.Font("Andalus", 0, 24)); // NOI18N
        inputlabel1.setForeground(new java.awt.Color(255, 255, 255));
        inputlabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gamepanel.add(inputlabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 120, 30));

        inputlabel2.setFont(new java.awt.Font("Andalus", 0, 24)); // NOI18N
        inputlabel2.setForeground(new java.awt.Color(255, 255, 255));
        inputlabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gamepanel.add(inputlabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 120, 30));

        inputlabel3.setFont(new java.awt.Font("Andalus", 0, 24)); // NOI18N
        inputlabel3.setForeground(new java.awt.Color(255, 255, 255));
        inputlabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gamepanel.add(inputlabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, 120, 30));

        inputlabel4.setFont(new java.awt.Font("Andalus", 0, 24)); // NOI18N
        inputlabel4.setForeground(new java.awt.Color(255, 255, 255));
        inputlabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gamepanel.add(inputlabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 120, 30));

        inputlabel5.setFont(new java.awt.Font("Andalus", 0, 24)); // NOI18N
        inputlabel5.setForeground(new java.awt.Color(255, 255, 255));
        inputlabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gamepanel.add(inputlabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, 120, 30));

        inputlabel6.setFont(new java.awt.Font("Andalus", 0, 24)); // NOI18N
        inputlabel6.setForeground(new java.awt.Color(255, 255, 255));
        inputlabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gamepanel.add(inputlabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, 120, 30));

        inputlabel7.setFont(new java.awt.Font("Andalus", 0, 24)); // NOI18N
        inputlabel7.setForeground(new java.awt.Color(255, 255, 255));
        inputlabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gamepanel.add(inputlabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, 120, 30));

        inputlabel8.setFont(new java.awt.Font("Andalus", 0, 24)); // NOI18N
        inputlabel8.setForeground(new java.awt.Color(255, 255, 255));
        inputlabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gamepanel.add(inputlabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 120, 30));

        inputlabel9.setFont(new java.awt.Font("Andalus", 0, 24)); // NOI18N
        inputlabel9.setForeground(new java.awt.Color(255, 255, 255));
        inputlabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gamepanel.add(inputlabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, 120, 30));

        inputlabel10.setFont(new java.awt.Font("Andalus", 0, 24)); // NOI18N
        inputlabel10.setForeground(new java.awt.Color(255, 255, 255));
        inputlabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gamepanel.add(inputlabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 320, 120, 30));

        bullslabel1.setFont(new java.awt.Font("Andalus", 0, 24)); // NOI18N
        bullslabel1.setForeground(new java.awt.Color(255, 255, 255));
        bullslabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gamepanel.add(bullslabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, 120, 30));

        bullslabel10.setFont(new java.awt.Font("Andalus", 0, 24)); // NOI18N
        bullslabel10.setForeground(new java.awt.Color(255, 255, 255));
        bullslabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gamepanel.add(bullslabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 320, 120, 30));

        bullslabel9.setFont(new java.awt.Font("Andalus", 0, 24)); // NOI18N
        bullslabel9.setForeground(new java.awt.Color(255, 255, 255));
        bullslabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gamepanel.add(bullslabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 290, 120, 30));

        bullslabel8.setFont(new java.awt.Font("Andalus", 0, 24)); // NOI18N
        bullslabel8.setForeground(new java.awt.Color(255, 255, 255));
        bullslabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gamepanel.add(bullslabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 260, 120, 30));

        bullslabel7.setFont(new java.awt.Font("Andalus", 0, 24)); // NOI18N
        bullslabel7.setForeground(new java.awt.Color(255, 255, 255));
        bullslabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gamepanel.add(bullslabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 230, 120, 30));

        bullslabel6.setFont(new java.awt.Font("Andalus", 0, 24)); // NOI18N
        bullslabel6.setForeground(new java.awt.Color(255, 255, 255));
        bullslabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gamepanel.add(bullslabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, 120, 30));

        bullslabel5.setFont(new java.awt.Font("Andalus", 0, 24)); // NOI18N
        bullslabel5.setForeground(new java.awt.Color(255, 255, 255));
        bullslabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gamepanel.add(bullslabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 170, 120, 30));

        bullslabel4.setFont(new java.awt.Font("Andalus", 0, 24)); // NOI18N
        bullslabel4.setForeground(new java.awt.Color(255, 255, 255));
        bullslabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gamepanel.add(bullslabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, 120, 30));

        bullslabel3.setFont(new java.awt.Font("Andalus", 0, 24)); // NOI18N
        bullslabel3.setForeground(new java.awt.Color(255, 255, 255));
        bullslabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gamepanel.add(bullslabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, 120, 30));

        bullslabel2.setFont(new java.awt.Font("Andalus", 0, 24)); // NOI18N
        bullslabel2.setForeground(new java.awt.Color(255, 255, 255));
        bullslabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gamepanel.add(bullslabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, 120, 30));

        cowslabel1.setFont(new java.awt.Font("Andalus", 0, 24)); // NOI18N
        cowslabel1.setForeground(new java.awt.Color(255, 255, 255));
        cowslabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gamepanel.add(cowslabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 50, 120, 30));

        cowslabel10.setFont(new java.awt.Font("Andalus", 0, 24)); // NOI18N
        cowslabel10.setForeground(new java.awt.Color(255, 255, 255));
        cowslabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gamepanel.add(cowslabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 320, 120, 30));

        cowslabel9.setFont(new java.awt.Font("Andalus", 0, 24)); // NOI18N
        cowslabel9.setForeground(new java.awt.Color(255, 255, 255));
        cowslabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gamepanel.add(cowslabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 290, 120, 30));

        cowslabel8.setFont(new java.awt.Font("Andalus", 0, 24)); // NOI18N
        cowslabel8.setForeground(new java.awt.Color(255, 255, 255));
        cowslabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gamepanel.add(cowslabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 260, 120, 30));

        cowslabel7.setFont(new java.awt.Font("Andalus", 0, 24)); // NOI18N
        cowslabel7.setForeground(new java.awt.Color(255, 255, 255));
        cowslabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gamepanel.add(cowslabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 230, 120, 30));

        cowslabel6.setFont(new java.awt.Font("Andalus", 0, 24)); // NOI18N
        cowslabel6.setForeground(new java.awt.Color(255, 255, 255));
        cowslabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gamepanel.add(cowslabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 200, 120, 30));

        cowslabel5.setFont(new java.awt.Font("Andalus", 0, 24)); // NOI18N
        cowslabel5.setForeground(new java.awt.Color(255, 255, 255));
        cowslabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gamepanel.add(cowslabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 170, 120, 30));

        cowslabel4.setFont(new java.awt.Font("Andalus", 0, 24)); // NOI18N
        cowslabel4.setForeground(new java.awt.Color(255, 255, 255));
        cowslabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gamepanel.add(cowslabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 140, 120, 30));

        cowslabel3.setFont(new java.awt.Font("Andalus", 0, 24)); // NOI18N
        cowslabel3.setForeground(new java.awt.Color(255, 255, 255));
        cowslabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gamepanel.add(cowslabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 110, 120, 30));

        cowslabel2.setFont(new java.awt.Font("Andalus", 0, 24)); // NOI18N
        cowslabel2.setForeground(new java.awt.Color(255, 255, 255));
        cowslabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gamepanel.add(cowslabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 80, 120, 30));

        bullsandcows.getContentPane().add(gamepanel);
        gamepanel.setBounds(10, 130, 790, 370);

        restartbtn.setFont(new java.awt.Font("Andalus", 1, 24)); // NOI18N
        restartbtn.setText("Restart");
        restartbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restartbtnActionPerformed(evt);
            }
        });
        bullsandcows.getContentPane().add(restartbtn);
        restartbtn.setBounds(840, 270, 150, 50);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/game back1.jpg"))); // NOI18N
        bullsandcows.getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 1024, 576);

        jMenu21.setText("File");

        jMenuItem41.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem41.setText("Jump to Home screen");
        jMenuItem41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem41ActionPerformed(evt);
            }
        });
        jMenu21.add(jMenuItem41);

        jMenuItem42.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem42.setText("Jump to App Drawer");
        jMenuItem42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem42ActionPerformed(evt);
            }
        });
        jMenu21.add(jMenuItem42);

        jMenuItem43.setText("Exit jPieroid OS");
        jMenuItem43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem43ActionPerformed(evt);
            }
        });
        jMenu21.add(jMenuItem43);

        jMenuBar11.add(jMenu21);

        jMenu22.setText("Help");

        jMenuItem45.setText("How to play");
        jMenuItem45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem45ActionPerformed(evt);
            }
        });
        jMenu22.add(jMenuItem45);

        jMenuItem44.setText("About Me..");
        jMenuItem44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem44ActionPerformed(evt);
            }
        });
        jMenu22.add(jMenuItem44);

        jMenuBar11.add(jMenu22);

        bullsandcows.setJMenuBar(jMenuBar11);

        howtoplay.setTitle("jPieroid OS | Bulls and Cows | How to Play");
        howtoplay.setMinimumSize(new java.awt.Dimension(497, 435));

        jTextArea2.setColumns(20);
        jTextArea2.setEditable(false);
        jTextArea2.setFont(new java.awt.Font("Andalus", 0, 18)); // NOI18N
        jTextArea2.setLineWrap(true);
        jTextArea2.setRows(5);
        jTextArea2.setText("Bulls and cows is a word guessing game. You are required to guess a word randomly generated by the computer. If your guessed word has some correct letters at the right position, those letters will be counted in Bulls. And if your guessed word has some correct letters but not at the right place, those will be counted as Cows. For example, the word generated is 'make',and you guessed 'game', then the number of Bulls is 2 and Cows is 1.");
        jTextArea2.setWrapStyleWord(true);
        jScrollPane6.setViewportView(jTextArea2);

        jButton15.setFont(new java.awt.Font("Andalus", 0, 18)); // NOI18N
        jButton15.setText("Got it");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jLabel75.setFont(new java.awt.Font("Andalus", 1, 24)); // NOI18N
        jLabel75.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel75.setText("How to Play Bulls and Cows");

        javax.swing.GroupLayout howtoplayLayout = new javax.swing.GroupLayout(howtoplay.getContentPane());
        howtoplay.getContentPane().setLayout(howtoplayLayout);
        howtoplayLayout.setHorizontalGroup(
            howtoplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(howtoplayLayout.createSequentialGroup()
                .addComponent(jLabel75, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
                .addGap(20, 20, 20))
            .addGroup(howtoplayLayout.createSequentialGroup()
                .addGroup(howtoplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(howtoplayLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(howtoplayLayout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addComponent(jButton15)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        howtoplayLayout.setVerticalGroup(
            howtoplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, howtoplayLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 36, Short.MAX_VALUE)
                .addGap(11, 11, 11)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton15)
                .addGap(66, 66, 66))
        );

        jd1.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        jd1.setTitle("Please enter a number");
        jd1.setAlwaysOnTop(true);
        jd1.setMinimumSize(new java.awt.Dimension(640, 320));
        jd1.setModal(true);
        jd1.setResizable(false);
        jd1.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Andalus", 1, 24)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Please enter any Number less than 40");
        jd1.getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 640, 50));

        numtf.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        numtf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jd1.getContentPane().add(numtf, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 210, 40));

        jButton18.setFont(new java.awt.Font("Andalus", 0, 24)); // NOI18N
        jButton18.setText("OK");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        jd1.getContentPane().add(jButton18, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 80, 40));

        details.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        details.setTitle("Contact | Details");
        details.setMinimumSize(new java.awt.Dimension(624, 342));
        details.setResizable(false);
        details.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        namelbl.setFont(new java.awt.Font("Andalus", 0, 20)); // NOI18N
        details.getContentPane().add(namelbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 400, 50));

        numlbl.setFont(new java.awt.Font("Andalus", 0, 20)); // NOI18N
        details.getContentPane().add(numlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 240, 40));

        jLabel91.setIcon(new javax.swing.ImageIcon(getClass().getResource("/contact user icon.png"))); // NOI18N
        details.getContentPane().add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 80, 80));

        Dclosebutton.setFont(new java.awt.Font("Lucida Fax", 1, 14)); // NOI18N
        Dclosebutton.setText("Close");
        Dclosebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DclosebuttonActionPerformed(evt);
            }
        });
        details.getContentPane().add(Dclosebutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 240, 150, 50));

        Ddelbutton.setFont(new java.awt.Font("Lucida Fax", 1, 14)); // NOI18N
        Ddelbutton.setText("Delete the Contact");
        Ddelbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DdelbuttonActionPerformed(evt);
            }
        });
        details.getContentPane().add(Ddelbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, 180, 50));

        Dcalbutton.setFont(new java.awt.Font("Lucida Fax", 1, 14)); // NOI18N
        Dcalbutton.setText("Call");
        Dcalbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DcalbuttonActionPerformed(evt);
            }
        });
        details.getContentPane().add(Dcalbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 150, 50));

        jLabel92.setIcon(new javax.swing.ImageIcon(getClass().getResource("/2560x1440-white-solid-color-ba.jpg"))); // NOI18N
        jLabel92.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        details.getContentPane().add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 500, 160));

        tbdetails.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        tbdetails.setMinimumSize(new java.awt.Dimension(634, 264));
        tbdetails.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel93.setFont(new java.awt.Font("Andalus", 1, 22)); // NOI18N
        jLabel93.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel93.setText("Please Select The Required Contact");
        tbdetails.getContentPane().add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 11, 630, 60));

        dtb.setFont(new java.awt.Font("Andalus", 0, 18)); // NOI18N
        dtb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sr.No", "First Name", "Last Name", "Number"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        dtb.setRowHeight(28);
        dtb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dtbMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(dtb);

        tbdetails.getContentPane().add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 610, 160));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("jPieroid OS | Login");
        setMinimumSize(new java.awt.Dimension(1024, 576));
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Andalus", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Hello, jPieroid Coder!");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 30, 1020, 80);

        userlabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/user1.png"))); // NOI18N
        getContentPane().add(userlabel);
        userlabel.setBounds(0, 140, 1020, 170);

        jLabel3.setFont(new java.awt.Font("Andalus", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password -");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(360, 400, 130, 40);

        jLabel5.setFont(new java.awt.Font("Andalus", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText(" Username -");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(350, 340, 140, 40);

        userTF.setFont(new java.awt.Font("Andalus", 1, 24)); // NOI18N
        getContentPane().add(userTF);
        userTF.setBounds(510, 340, 230, 40);

        passTF.setFont(new java.awt.Font("Andalus", 1, 24)); // NOI18N
        passTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passTFActionPerformed(evt);
            }
        });
        getContentPane().add(passTF);
        passTF.setBounds(510, 400, 230, 40);

        subbutton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tick_red (1).png"))); // NOI18N
        subbutton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subbutton1ActionPerformed(evt);
            }
        });
        getContentPane().add(subbutton1);
        subbutton1.setBounds(380, 460, 60, 60);

        cancelbutton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/x-mark-3-xxl (1).png"))); // NOI18N
        cancelbutton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelbutton1ActionPerformed(evt);
            }
        });
        getContentPane().add(cancelbutton1);
        cancelbutton1.setBounds(590, 460, 60, 60);

        loginlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/back1.jpg"))); // NOI18N
        getContentPane().add(loginlabel);
        loginlabel.setBounds(0, 0, 1020, 570);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void subbutton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subbutton1ActionPerformed
        String username = userTF.getText();
        String pass = new String(passTF.getPassword());
        if (username.equalsIgnoreCase(curusername) && pass.equalsIgnoreCase(curpassword)) {
            JOptionPane.showMessageDialog(this,"You have been successfully logged in." );
            home.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Password and User ID do not match. Please try again.", "Incorrect username or password", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_subbutton1ActionPerformed

    private void cancelbutton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelbutton1ActionPerformed
       if (JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_cancelbutton1ActionPerformed

    private void backbutton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbutton1ActionPerformed
        home.setVisible(true);
        appdrawer.dispose();
}//GEN-LAST:event_backbutton1ActionPerformed

    private void homebutton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homebutton1ActionPerformed
        home.setVisible(true);
        appdrawer.dispose();
    }//GEN-LAST:event_homebutton1ActionPerformed

    private void powbutton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_powbutton1ActionPerformed

        if (JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
}//GEN-LAST:event_powbutton1ActionPerformed

    private void calcbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcbuttonActionPerformed
        calculator.setVisible(true);
        appdrawer.setVisible(false);
}//GEN-LAST:event_calcbuttonActionPerformed

    private void gamebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gamebuttonActionPerformed
        bullsandcows.setVisible(true);
        jd1.setVisible(true);
        appdrawer.dispose();
}//GEN-LAST:event_gamebuttonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String username = curuser2TF.getText();
        String pass = new String(curpass2TF.getPassword());
        String newpass = newpassTF.getText();
        if (username.equals(curusername) && pass.equals(curpassword)) {
            try {
                Class.forName("java.sql.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jos", "root", "mysql");
                Statement stmt = con.createStatement();
                String query = "Update userpass set password='" + newpass + "'";
                int n = stmt.executeUpdate(query);
                JOptionPane.showMessageDialog(this, "Your Password name has been changed!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                System.out.println("Error");
            }
            curpassword = newpass;
        } else {
            JOptionPane.showMessageDialog(null, "Your username or password is wrong");
        }
        curuserTF.setText("");
        curpassTF.setText("");
        curuser2TF.setText("");
        curpass2TF.setText("");
        newuserTF.setText("");
        newpassTF.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String username = curuserTF.getText();
        String pass = new String(curpassTF.getPassword());
        String newuser = newuserTF.getText();

        if (username.equals(curusername) && pass.equals(curpassword)) {
            try {
                Class.forName("java.sql.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jos", "root", "mysql");
                Statement stmt = con.createStatement();
                String query = "Update userpass set username='" + newuser + "'";
                int n = stmt.executeUpdate(query);
                JOptionPane.showMessageDialog(this, "Your username name has been changed!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                System.out.println("Error");
            }
            curusername = newuser;
        } else {
            JOptionPane.showMessageDialog(null, "Your username or password is wrong");
        }
        curuserTF.setText("");
        curpassTF.setText("");
        curuser2TF.setText("");
        curpass2TF.setText("");
        newuserTF.setText("");
        newpassTF.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void backbutton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbutton3ActionPerformed
        ssettings.dispose();
        settings.setVisible(true);
    }//GEN-LAST:event_backbutton3ActionPerformed

    private void homebutton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homebutton3ActionPerformed
        ssettings.dispose();
        home.setVisible(true);
    }//GEN-LAST:event_homebutton3ActionPerformed

    private void powbutton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_powbutton3ActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }

    }//GEN-LAST:event_powbutton3ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        BigInteger n = new BigInteger(t1.getText());
        BigInteger p = new BigInteger("" + n.nextProbablePrime());
        t2.setText(p + "");
}//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        t2.setText("");
        t1.setText("");
}//GEN-LAST:event_jButton4ActionPerformed

    private void powbutton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_powbutton4ActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_powbutton4ActionPerformed

    private void homebutton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homebutton4ActionPerformed
        nextprime.dispose();
        home.setVisible(true);
    }//GEN-LAST:event_homebutton4ActionPerformed

    private void backbutton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbutton4ActionPerformed
        appdrawer.setVisible(true);
        nextprime.dispose();
    }//GEN-LAST:event_backbutton4ActionPerformed

    private void npbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_npbuttonActionPerformed
        nextprime.setVisible(true);
        appdrawer.setVisible(false);

    }//GEN-LAST:event_npbuttonActionPerformed

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
        String a = t.getText();
        if(a == ""){
        t.setText(b1.getText()); }
        else{
            a=t.getText() + b1.getText();
            t.setText(a);
        }
}//GEN-LAST:event_b1ActionPerformed

    private void b7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b7ActionPerformed
        String a = t.getText();
        if(a == ""){
        t.setText(b7.getText()); }
        else{
            a=t.getText() + b7.getText();
            t.setText(a);
        }
}//GEN-LAST:event_b7ActionPerformed

    private void b4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b4ActionPerformed
        String a = t.getText();
        if(a == ""){
        t.setText(b4.getText()); }
        else{
            a=t.getText() + b4.getText();
            t.setText(a);
        }
}//GEN-LAST:event_b4ActionPerformed

    private void b0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b0ActionPerformed
        String a = t.getText();
        if(a == ""){
        t.setText(b0.getText()); }
        else{
            a=t.getText() + b0.getText();
            t.setText(a);
        }
}//GEN-LAST:event_b0ActionPerformed

    private void b5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b5ActionPerformed
        String a = t.getText();
        if(a == ""){
        t.setText(b5.getText()); }
        else{
            a=t.getText() + b5.getText();
            t.setText(a);
        }
}//GEN-LAST:event_b5ActionPerformed

    private void b8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b8ActionPerformed
        String a = t.getText();
        if(a == ""){
        t.setText(b8.getText()); }
        else{
            a=t.getText() + b8.getText();
            t.setText(a);
        }
}//GEN-LAST:event_b8ActionPerformed

    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2ActionPerformed
        String a = t.getText();
        if(a == ""){
        t.setText(b2.getText()); }
        else{
            a=t.getText() + b2.getText();
            t.setText(a);
        }
}//GEN-LAST:event_b2ActionPerformed

    private void b6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b6ActionPerformed
        String a = t.getText();
        if(a == ""){
        t.setText(b6.getText()); }
        else{
            a=t.getText() + b6.getText();
            t.setText(a);
        }
}//GEN-LAST:event_b6ActionPerformed

    private void b9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b9ActionPerformed
        String a = t.getText();
        if(a == ""){
        t.setText(b9.getText()); }
        else{
            a=t.getText() + b9.getText();
            t.setText(a);
        }
}//GEN-LAST:event_b9ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        firstnum = Double.parseDouble(t.getText());
    t.setText("");
    operations="+";
}//GEN-LAST:event_jButton14ActionPerformed

    private void b3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b3ActionPerformed
        String a = t.getText();
        if(a == ""){
        t.setText(b3.getText()); }
        else{
            a=t.getText() + b3.getText();
            t.setText(a);
        }
}//GEN-LAST:event_b3ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        if(! t.getText().contains("."))
        {t.setText(t.getText() + jButton17.getText());
        }
}//GEN-LAST:event_jButton17ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
 String ans;
 secondnum = Double.parseDouble(t.getText());
        if(operations =="+")
        {
            result = firstnum + secondnum;
            ans = String.format("%.2f" , result);
            t.setText( ans);
        }
        else if (operations == "-")
                
        {
            result = firstnum - secondnum;
            ans = String.format("%.2f" , result);
            t.setText( ans);
        }
        else if (operations == "*")
                
        {
            result = firstnum * secondnum;
            ans = String.format("%.2f" , result);
            t.setText( ans);
        }
        else if (operations == "/")
                
        {
            result = firstnum / secondnum;
            ans = String.format("%.2f" , result);
            t.setText( ans);
        }        
        
}//GEN-LAST:event_jButton16ActionPerformed

    private void tActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_tActionPerformed

    private void homebutton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homebutton5ActionPerformed
        home.setVisible(true);
        calculator.dispose();
    }//GEN-LAST:event_homebutton5ActionPerformed

    private void settingbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingbuttonActionPerformed
        settings.setVisible(true);
        appdrawer.setVisible(false);
    }//GEN-LAST:event_settingbuttonActionPerformed

    private void backbutton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbutton5ActionPerformed
        appdrawer.setVisible(true);
        calculator.dispose();
    }//GEN-LAST:event_backbutton5ActionPerformed

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        home.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        home.setVisible(true);
        contacts.dispose();
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        appdrawer.setVisible(true);
        contacts.dispose();
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        appdrawer.setVisible(true);
        ssettings.dispose();
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        home.setVisible(true);
        ssettings.dispose();
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        home.setVisible(true);
        nextprime.dispose();
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        appdrawer.setVisible(true);
        nextprime.dispose();
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void jMenuItem23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem23ActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jMenuItem23ActionPerformed

    private void jMenuItem22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem22ActionPerformed
        appdrawer.setVisible(true);
        calculator.dispose();
    }//GEN-LAST:event_jMenuItem22ActionPerformed

    private void jMenuItem21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem21ActionPerformed
        home.setVisible(true);
        nextprime.dispose();
    }//GEN-LAST:event_jMenuItem21ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        aboutus.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        aboutus.setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void aboutbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutbuttonActionPerformed
        aboutus.setVisible(true);
    }//GEN-LAST:event_aboutbuttonActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        aboutus.setVisible(true);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        aboutus.setVisible(true);
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem20ActionPerformed
        aboutus.setVisible(true);
    }//GEN-LAST:event_jMenuItem20ActionPerformed

    private void jMenuItem24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem24ActionPerformed
        aboutus.setVisible(true);
    }//GEN-LAST:event_jMenuItem24ActionPerformed

    private void billbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_billbuttonActionPerformed
        gblogin.setVisible(true);
        appdrawer.setVisible(false);
    }//GEN-LAST:event_billbuttonActionPerformed

    private void FquantityTFMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FquantityTFMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_FquantityTFMouseExited

    private void FquantityTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FquantityTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FquantityTFActionPerformed

    private void FquantityTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FquantityTFKeyReleased
        int price = Integer.parseInt(FpriceTF.getText());
        int quantity = Integer.parseInt(FquantityTF.getText());
        famountTF.setText("" + (price * quantity));
}//GEN-LAST:event_FquantityTFKeyReleased

    private void drinksCmBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_drinksCmBItemStateChanged

        int food = drinksCmB.getSelectedIndex();
        if (food == 1) {
            fnameTF.setText("");
            ftypeTF.setText("");
            FpriceTF.setText("");
            fnameTF.setText("Tea");
            ftypeTF.setText("Drinks");
            FpriceTF.setText("" + 20);
        } else if (food == 2) {
            fnameTF.setText("");
            ftypeTF.setText("");
            FpriceTF.setText("");
            fnameTF.setText("Coffee");
            ftypeTF.setText("Drinks");
            FpriceTF.setText("" + 25);
        } else if (food == 3) {
            fnameTF.setText("");
            ftypeTF.setText("");
            FpriceTF.setText("");
            fnameTF.setText("Soda");
            ftypeTF.setText("Drinks");
            FpriceTF.setText("" + 15);
        } else if (food == 4) {
            fnameTF.setText("");
            ftypeTF.setText("");
            FpriceTF.setText("");
            fnameTF.setText("Soft Drink");
            ftypeTF.setText("Drinks");
            FpriceTF.setText("" + 35);
        } else if (food == 5) {
            fnameTF.setText("");
            ftypeTF.setText("");
            FpriceTF.setText("");
            fnameTF.setText("Lime Soda");
            ftypeTF.setText("Drinks");
            FpriceTF.setText("" + 25);
        } else if (food == 6) {
            fnameTF.setText("");
            ftypeTF.setText("");
            FpriceTF.setText("");
            fnameTF.setText("Vanilla Shake");
            ftypeTF.setText("Drinks");
            FpriceTF.setText("" + 60);
        } else if (food == 7) {
            fnameTF.setText("");
            ftypeTF.setText("");
            FpriceTF.setText("");
            fnameTF.setText("Chocolate Shake");
            ftypeTF.setText("Drinks");
            FpriceTF.setText("" + 60);
        } else if (food == 8) {
            fnameTF.setText("");
            ftypeTF.setText("");
            FpriceTF.setText("");
            fnameTF.setText("Strawberry Shake");
            ftypeTF.setText("Drinks");
            FpriceTF.setText("" + 60);
        }
        FquantityTF.setText("");
        famountTF.setText("");
    }//GEN-LAST:event_drinksCmBItemStateChanged

    private void SouthCmBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_SouthCmBItemStateChanged
        int food = SouthCmB.getSelectedIndex();
        if (food == 1) {
            fnameTF.setText("");
            ftypeTF.setText("");
            FpriceTF.setText("");
            fnameTF.setText("Sada Dosa");
            ftypeTF.setText("South Indian");
            FpriceTF.setText("" + 50);
        } else if (food == 2) {
            fnameTF.setText("");
            ftypeTF.setText("");
            FpriceTF.setText("");
            fnameTF.setText("Masala Dosa");
            ftypeTF.setText("South Indian");
            FpriceTF.setText("" + 60);
        } else if (food == 3) {
            fnameTF.setText("");
            ftypeTF.setText("");
            FpriceTF.setText("");
            fnameTF.setText("Uttapam");
            ftypeTF.setText("South Indian");
            FpriceTF.setText("" + 55);
        } else if (food == 4) {
            fnameTF.setText("");
            ftypeTF.setText("");
            FpriceTF.setText("");
            fnameTF.setText("Rava Dosa");
            ftypeTF.setText("South Indian");
            FpriceTF.setText("" + 55);
        } else if (food == 5) {
            fnameTF.setText("");
            ftypeTF.setText("");
            FpriceTF.setText("");
            fnameTF.setText("Rava Masala");
            ftypeTF.setText("South Indian");
            FpriceTF.setText("" + 65);
        } else if (food == 6) {
            fnameTF.setText("");
            ftypeTF.setText("");
            FpriceTF.setText("");
            fnameTF.setText("Spring Masala");
            ftypeTF.setText("South Indian");
            FpriceTF.setText("" + 75);
        }
        FquantityTF.setText("");
        famountTF.setText("");
    }//GEN-LAST:event_SouthCmBItemStateChanged

    private void sandwichCmBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_sandwichCmBItemStateChanged
        int food = sandwichCmB.getSelectedIndex();
        if (food == 1) {
            fnameTF.setText("");
            ftypeTF.setText("");
            FpriceTF.setText("");
            fnameTF.setText("Veg Sandwich");
            ftypeTF.setText("Sandwich");
            FpriceTF.setText("" + 40);
        } else if (food == 2) {
            fnameTF.setText("");
            ftypeTF.setText("");
            FpriceTF.setText("");
            fnameTF.setText("Chatni Sandwich");
            ftypeTF.setText("Sandwich");
            FpriceTF.setText("" + 30);
        } else if (food == 3) {
            fnameTF.setText("");
            ftypeTF.setText("");
            FpriceTF.setText("");
            fnameTF.setText("Omlet Sandwich");
            ftypeTF.setText("Sandwich");
            FpriceTF.setText("" + 55);
        } else if (food == 4) {
            fnameTF.setText("");
            ftypeTF.setText("");
            FpriceTF.setText("");
            fnameTF.setText("Cheese Sandwich");
            ftypeTF.setText("Sandwich");
            FpriceTF.setText("" + 70);
        } else if (food == 5) {
            fnameTF.setText("");
            ftypeTF.setText("");
            FpriceTF.setText("");
            fnameTF.setText("Club Sandwich");
            ftypeTF.setText("Sandwich");
            FpriceTF.setText("" + 80);
        } else if (food == 6) {
            fnameTF.setText("");
            ftypeTF.setText("");
            FpriceTF.setText("");
            fnameTF.setText("Veg Grill Sandwich");
            ftypeTF.setText("Sandwich");
            FpriceTF.setText("" + 65);
        } else if (food == 7) {
            fnameTF.setText("");
            ftypeTF.setText("");
            FpriceTF.setText("");
            fnameTF.setText("Diamond Club Sandwich");
            ftypeTF.setText("Sandwich");
            FpriceTF.setText("" + 100);
        }
        FquantityTF.setText("");
        famountTF.setText("");
    }//GEN-LAST:event_sandwichCmBItemStateChanged

    private void vegCmBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_vegCmBItemStateChanged
        int food = vegCmB.getSelectedIndex();
        if (food == 1) {
            fnameTF.setText("");
            ftypeTF.setText("");
            FpriceTF.setText("");
            fnameTF.setText("Veg Handi");
            ftypeTF.setText("Shakahari Khazana");
            FpriceTF.setText("" + 145);
        }
        if (food == 2) {
            fnameTF.setText("");
            ftypeTF.setText("");
            FpriceTF.setText("");
            fnameTF.setText("Mix Vegetables");
            ftypeTF.setText("Shakahari Khazana");
            FpriceTF.setText("" + 120);
        }
        if (food == 3) {
            fnameTF.setText("");
            ftypeTF.setText("");
            FpriceTF.setText("");
            fnameTF.setText("Dum Alu");
            ftypeTF.setText("Shakahari Khazana");
            FpriceTF.setText("" + 135);
        }
        if (food == 4) {
            fnameTF.setText("");
            ftypeTF.setText("");
            FpriceTF.setText("");
            fnameTF.setText("Alu Mutter");
            ftypeTF.setText("Shakahari Khazana");
            FpriceTF.setText("" + 105);
        }
        if (food == 5) {
            fnameTF.setText("");
            ftypeTF.setText("");
            FpriceTF.setText("");
            fnameTF.setText("Karela Masala");
            ftypeTF.setText("Shakahari Khazana");
            FpriceTF.setText("" + 135);
        }
        if (food == 6) {
            fnameTF.setText("");
            ftypeTF.setText("");
            FpriceTF.setText("");
            fnameTF.setText("Chana Masala");
            ftypeTF.setText("Shakahari Khazana");
            FpriceTF.setText("" + 145);
        }
        if (food == 7) {
            fnameTF.setText("");
            ftypeTF.setText("");
            FpriceTF.setText("");
            fnameTF.setText("Paneer Tikka");
            ftypeTF.setText("Shakahari Khazana");
            FpriceTF.setText("" + 160);
        }
        if (food == 8) {
            fnameTF.setText("");
            ftypeTF.setText("");
            FpriceTF.setText("");
            fnameTF.setText("Chhole Bhatura");
            ftypeTF.setText("Shakahari Khazana");
            FpriceTF.setText("" + 140);
        }
        if (food == 9) {
            fnameTF.setText("");
            ftypeTF.setText("");
            FpriceTF.setText("");
            fnameTF.setText("Kaju Masala");
            ftypeTF.setText("Shakahari Khazana");
            FpriceTF.setText("" + 185);
        }
        if (food == 10) {
            fnameTF.setText("");
            ftypeTF.setText("");
            FpriceTF.setText("");
            fnameTF.setText("Mushroom Fry");
            ftypeTF.setText("Shakahari Khazana");
            FpriceTF.setText("" + 145);
        }
        FquantityTF.setText("");
        famountTF.setText("");
    }//GEN-LAST:event_vegCmBItemStateChanged

    private void chappatiCmBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chappatiCmBItemStateChanged
        int food = chappatiCmB.getSelectedIndex();
        if (food == 1) {
            fnameTF.setText("");
            ftypeTF.setText("");
            FpriceTF.setText("");
            fnameTF.setText("Chapati");
            ftypeTF.setText("Chapati");
            FpriceTF.setText("" + 8);
        }
        if (food == 2) {
            fnameTF.setText("");
            ftypeTF.setText("");
            FpriceTF.setText("");
            fnameTF.setText("Roti");
            ftypeTF.setText("Chapati");
            FpriceTF.setText("" + 15);
        }
        if (food == 3) {
            fnameTF.setText("");
            ftypeTF.setText("");
            FpriceTF.setText("");
            fnameTF.setText("Paratha");
            ftypeTF.setText("Chapati");
            FpriceTF.setText("" + 24);
        }
        if (food == 4) {
            fnameTF.setText("");
            ftypeTF.setText("");
            FpriceTF.setText("");
            fnameTF.setText("Naan");
            ftypeTF.setText("Chapati");
            FpriceTF.setText("" + 25);
        }
        if (food == 5) {
            fnameTF.setText("");
            ftypeTF.setText("");
            FpriceTF.setText("");
            fnameTF.setText("Garlic Naan");
            ftypeTF.setText("Chapati");
            FpriceTF.setText("" + 50);
        }
        if (food == 6) {
            fnameTF.setText("");
            ftypeTF.setText("");
            FpriceTF.setText("");
            fnameTF.setText("Kashmiri Naan");
            ftypeTF.setText("Chapati");
            FpriceTF.setText("" + 50);
        }
        FquantityTF.setText("");
        famountTF.setText("");
    }//GEN-LAST:event_chappatiCmBItemStateChanged

    private void soupCmBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_soupCmBItemStateChanged
        int food = soupCmB.getSelectedIndex();
        if (food == 1) {
            fnameTF.setText("");
            ftypeTF.setText("");
            FpriceTF.setText("");
            fnameTF.setText("Tomato Soup");
            ftypeTF.setText("Soup");
            FpriceTF.setText("" + 85);
        }
        if (food == 2) {
            fnameTF.setText("");
            ftypeTF.setText("");
            FpriceTF.setText("");
            fnameTF.setText("Veg Manchow");
            ftypeTF.setText("Soup");
            FpriceTF.setText("" + 95);
        }
        if (food == 3) {
            fnameTF.setText("");
            ftypeTF.setText("");
            FpriceTF.setText("");
            fnameTF.setText("Veg Noddles");
            ftypeTF.setText("Soup");
            FpriceTF.setText("" + 90);
        }
        if (food == 4) {
            fnameTF.setText("");
            ftypeTF.setText("");
            FpriceTF.setText("");
            fnameTF.setText("Palak Soup");
            ftypeTF.setText("Soup");
            FpriceTF.setText("" + 90);
        }
        if (food == 5) {
            fnameTF.setText("");
            ftypeTF.setText("");
            FpriceTF.setText("");
            fnameTF.setText("Sweet Corn Noddles");
            ftypeTF.setText("Soup");
            FpriceTF.setText("" + 90);
        }
        FquantityTF.setText("");
        famountTF.setText("");
    }//GEN-LAST:event_soupCmBItemStateChanged

    private void riceCmBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_riceCmBItemStateChanged
        int food = riceCmB.getSelectedIndex();
        if (food == 1) {
            fnameTF.setText("");
            ftypeTF.setText("");
            FpriceTF.setText("");
            fnameTF.setText("Plain Rice");
            ftypeTF.setText("Rice");
            FpriceTF.setText("" + 90);
        }
        if (food == 2) {
            fnameTF.setText("");
            ftypeTF.setText("");
            FpriceTF.setText("");
            fnameTF.setText("Jeera Rice");
            ftypeTF.setText("Rice");
            FpriceTF.setText("" + 100);
        }
        if (food == 3) {
            fnameTF.setText("");
            ftypeTF.setText("");
            FpriceTF.setText("");
            fnameTF.setText("Veg Fried Rice");
            ftypeTF.setText("Rice");
            FpriceTF.setText("" + 120);
        }
        if (food == 4) {
            fnameTF.setText("");
            ftypeTF.setText("");
            FpriceTF.setText("");
            fnameTF.setText("Jeera Fried Rice");
            ftypeTF.setText("Rice");
            FpriceTF.setText("" + 120);
        }
        if (food == 5) {
            fnameTF.setText("");
            ftypeTF.setText("");
            FpriceTF.setText("");
            fnameTF.setText("Panneer Fried Rice");
            ftypeTF.setText("Rice");
            FpriceTF.setText("" + 130);
        }
        FquantityTF.setText("");
        famountTF.setText("");
    }//GEN-LAST:event_riceCmBItemStateChanged

    private void dalCmBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_dalCmBItemStateChanged
        int food = dalCmB.getSelectedIndex();
        if (food == 1) {
            fnameTF.setText("");
            ftypeTF.setText("");
            FpriceTF.setText("");
            fnameTF.setText("Dal Fry");
            ftypeTF.setText("Dal");
            FpriceTF.setText("" + 95);
        }
        if (food == 2) {
            fnameTF.setText("");
            ftypeTF.setText("");
            FpriceTF.setText("");
            fnameTF.setText("Dal Tadka");
            ftypeTF.setText("Dal");
            FpriceTF.setText("" + 110);
        }
        if (food == 3) {
            fnameTF.setText("");
            ftypeTF.setText("");
            FpriceTF.setText("");
            fnameTF.setText("Dal Makhani");
            ftypeTF.setText("Dal");
            FpriceTF.setText("" + 110);
        }
        if (food == 4) {
            fnameTF.setText("");
            ftypeTF.setText("");
            FpriceTF.setText("");
            fnameTF.setText("Dal Palak");
            ftypeTF.setText("Dal");
            FpriceTF.setText("" + 120);
        }
        if (food == 5) {
            fnameTF.setText("");
            ftypeTF.setText("");
            FpriceTF.setText("");
            fnameTF.setText("Dal Moghlai");
            ftypeTF.setText("Dal");
            FpriceTF.setText("" + 120);
        }
        FquantityTF.setText("");
        famountTF.setText("");
    }//GEN-LAST:event_dalCmBItemStateChanged

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        int amount = Integer.parseInt(famountTF.getText());
        int Tprice = Integer.parseInt(ftpriceTF.getText());
        DefaultTableModel billtm = (DefaultTableModel) billTB.getModel();
        billtm.addRow(new Object[]{fnameTF.getText(), FpriceTF.getText(), FquantityTF.getText(), famountTF.getText()});
        ftpriceTF.setText("" + (Tprice + amount));
        totalamtTF.setText("" + (Tprice + amount));
}//GEN-LAST:event_jButton6ActionPerformed

    private void backbutton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbutton6ActionPerformed
        appdrawer.setVisible(true);
        billing.dispose();
    }//GEN-LAST:event_backbutton6ActionPerformed

    private void homebutton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homebutton6ActionPerformed
        home.setVisible(true);
        billing.dispose();
    }//GEN-LAST:event_homebutton6ActionPerformed

    private void powbutton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_powbutton5ActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_powbutton5ActionPerformed

    private void jMenuItem25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem25ActionPerformed
        home.setVisible(true);
        billing.dispose();
    }//GEN-LAST:event_jMenuItem25ActionPerformed

    private void jMenuItem26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem26ActionPerformed
        appdrawer.setVisible(true);
        billing.dispose();
    }//GEN-LAST:event_jMenuItem26ActionPerformed

    private void jMenuItem27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem27ActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jMenuItem27ActionPerformed

    private void jMenuItem28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem28ActionPerformed
        aboutus.setVisible(true);
    }//GEN-LAST:event_jMenuItem28ActionPerformed

    private void jMenu14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu14ActionPerformed
    }//GEN-LAST:event_jMenu14ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        int Tamt = Integer.parseInt(totalamtTF.getText());
        JOptionPane.showMessageDialog(this, "Thank You for Choosing us. Your Order Has been Placed.The Total amount is " + Tamt + " ", "Order Placed. Thank You", JOptionPane.INFORMATION_MESSAGE);
}//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        billtable.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void powbutton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_powbutton6ActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_powbutton6ActionPerformed

    private void homebutton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homebutton7ActionPerformed
        home.setVisible(true);
        billtable.dispose();
        billing.dispose();
    }//GEN-LAST:event_homebutton7ActionPerformed

    private void backbutton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbutton7ActionPerformed
        billing.setVisible(true);
        billtable.dispose();
    }//GEN-LAST:event_backbutton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        String gbuser = gbuserTF.getText();
        String gbpass = new String(gbpassPF.getPassword());
        if (gbuser.equalsIgnoreCase(curusername) && gbpass.equalsIgnoreCase(curpassword)) {
            JOptionPane.showMessageDialog(this, "You have been successfully logged in");
            billing.setVisible(true);
            gblogin.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Your USERNAME or PASSWORD is incorrect. Please try again ", "Wrong Username or Password", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        appdrawer.setVisible(true);
        gblogin.dispose();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jMenuItem29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem29ActionPerformed
        home.setVisible(true);
        settings.dispose();
    }//GEN-LAST:event_jMenuItem29ActionPerformed

    private void jMenuItem30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem30ActionPerformed
        appdrawer.setVisible(true);
        settings.dispose();
    }//GEN-LAST:event_jMenuItem30ActionPerformed

    private void jMenuItem31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem31ActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jMenuItem31ActionPerformed

    private void jMenuItem32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem32ActionPerformed
        aboutus.setVisible(true);
    }//GEN-LAST:event_jMenuItem32ActionPerformed

    private void powbutton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_powbutton7ActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_powbutton7ActionPerformed

    private void homebutton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homebutton8ActionPerformed
        home.setVisible(true);
        settings.dispose();
    }//GEN-LAST:event_homebutton8ActionPerformed

    private void backbutton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbutton8ActionPerformed
        appdrawer.setVisible(true);
        settings.dispose();
    }//GEN-LAST:event_backbutton8ActionPerformed

    private void jMenuItem33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem33ActionPerformed
        home.setVisible(true);
        changeback.dispose();
    }//GEN-LAST:event_jMenuItem33ActionPerformed

    private void jMenuItem34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem34ActionPerformed
        appdrawer.setVisible(true);
        changeback.dispose();
    }//GEN-LAST:event_jMenuItem34ActionPerformed

    private void jMenuItem35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem35ActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jMenuItem35ActionPerformed

    private void jMenuItem36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem36ActionPerformed
        aboutus.setVisible(true);
    }//GEN-LAST:event_jMenuItem36ActionPerformed

    private void powbutton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_powbutton8ActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_powbutton8ActionPerformed

    private void homebutton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homebutton9ActionPerformed
        home.setVisible(true);
        changeback.dispose();
    }//GEN-LAST:event_homebutton9ActionPerformed

    private void backbutton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbutton9ActionPerformed
        settings.setVisible(true);
        changeback.dispose();
    }//GEN-LAST:event_backbutton9ActionPerformed

    private void displaybutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displaybutActionPerformed
        settings.dispose();
        changeback.setVisible(true);
    }//GEN-LAST:event_displaybutActionPerformed

    private void wallbut8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wallbut8ActionPerformed
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jos", "root", "mysql");
            Statement stmt = con.createStatement();
            String query = "Update backgrounds set homescreen='back1.jpg'";
            int n = stmt.executeUpdate(query);
            homelabel.setIcon(new ImageIcon(getClass().getResource("back1.jpg")));
            menulabel.setIcon(new ImageIcon(getClass().getResource("back1.jpg")));
            JOptionPane.showMessageDialog(this, "Background set successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.out.println("Error");
        }
    }//GEN-LAST:event_wallbut8ActionPerformed

    private void wallbut9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wallbut9ActionPerformed
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jos", "root", "mysql");
            Statement stmt = con.createStatement();
            String query = "Update backgrounds set homescreen='back2.jpg'";
            int n = stmt.executeUpdate(query);
            homelabel.setIcon(new ImageIcon(getClass().getResource("back2.jpg")));
            menulabel.setIcon(new ImageIcon(getClass().getResource("back2.jpg")));
            JOptionPane.showMessageDialog(this, "Background set successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.out.println("Error");
        }
    }//GEN-LAST:event_wallbut9ActionPerformed

    private void wallbut10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wallbut10ActionPerformed
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jos", "root", "mysql");
            Statement stmt = con.createStatement();
            String query = "Update backgrounds set homescreen='back3.jpg'";
            int n = stmt.executeUpdate(query);
            homelabel.setIcon(new ImageIcon(getClass().getResource("back3.jpg")));
            menulabel.setIcon(new ImageIcon(getClass().getResource("back3.jpg")));
            JOptionPane.showMessageDialog(this, "Background set successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.out.println("Error");
        }
    }//GEN-LAST:event_wallbut10ActionPerformed

    private void wallbut11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wallbut11ActionPerformed
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jos", "root", "mysql");
            Statement stmt = con.createStatement();
            String query = "Update backgrounds set homescreen='back4.jpg'";
            int n = stmt.executeUpdate(query);
            homelabel.setIcon(new ImageIcon(getClass().getResource("back4.jpg")));
            menulabel.setIcon(new ImageIcon(getClass().getResource("back4.jpg")));
            JOptionPane.showMessageDialog(this, "Background set successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.out.println("Error");
        }
    }//GEN-LAST:event_wallbut11ActionPerformed

    private void wallbut12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wallbut12ActionPerformed
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jos", "root", "mysql");
            Statement stmt = con.createStatement();
            String query = "Update backgrounds set homescreen='back5.jpg'";
            int n = stmt.executeUpdate(query);
            homelabel.setIcon(new ImageIcon(getClass().getResource("back5.jpg")));
            menulabel.setIcon(new ImageIcon(getClass().getResource("back5.jpg")));
            JOptionPane.showMessageDialog(this, "Background set successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.out.println("Error");
        }
    }//GEN-LAST:event_wallbut12ActionPerformed

    private void wallbut13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wallbut13ActionPerformed
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jos", "root", "mysql");
            Statement stmt = con.createStatement();
            String query = "Update backgrounds set homescreen='back6.jpg'";
            int n = stmt.executeUpdate(query);
            homelabel.setIcon(new ImageIcon(getClass().getResource("back6.jpg")));
            menulabel.setIcon(new ImageIcon(getClass().getResource("back6.jpg")));
            JOptionPane.showMessageDialog(this, "Background set successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.out.println("Error");
        }
    }//GEN-LAST:event_wallbut13ActionPerformed

    private void wallbut14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wallbut14ActionPerformed
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jos", "root", "mysql");
            Statement stmt = con.createStatement();
            String query = "Update backgrounds set homescreen='back7.jpg'";
            int n = stmt.executeUpdate(query);
            homelabel.setIcon(new ImageIcon(getClass().getResource("back7.jpg")));
            menulabel.setIcon(new ImageIcon(getClass().getResource("back7.jpg")));
            JOptionPane.showMessageDialog(this, "Background set successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.out.println("Error");
        }
    }//GEN-LAST:event_wallbut14ActionPerformed

    private void wallbut1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wallbut1ActionPerformed
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jos", "root", "mysql");
            Statement stmt = con.createStatement();
            String query = "Update backgrounds set loginscreen='back1.jpg'";
            int n = stmt.executeUpdate(query);
            loginlabel.setIcon(new ImageIcon(getClass().getResource("back1.jpg")));
            JOptionPane.showMessageDialog(this, "Background set successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.out.println("Error");
        }
    }//GEN-LAST:event_wallbut1ActionPerformed

    private void wallbut2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wallbut2ActionPerformed
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jos", "root", "mysql");
            Statement stmt = con.createStatement();
            String query = "Update backgrounds set loginscreen='back2.jpg'";
            int n = stmt.executeUpdate(query);
            loginlabel.setIcon(new ImageIcon(getClass().getResource("back2.jpg")));
            JOptionPane.showMessageDialog(this, "Background set successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.out.println("Error");
        }
    }//GEN-LAST:event_wallbut2ActionPerformed

    private void wallbut3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wallbut3ActionPerformed
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jos", "root", "mysql");
            Statement stmt = con.createStatement();
            String query = "Update backgrounds set loginscreen='back3.jpg'";
            int n = stmt.executeUpdate(query);
            loginlabel.setIcon(new ImageIcon(getClass().getResource("back3.jpg")));
            JOptionPane.showMessageDialog(this, "Background set successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.out.println("Error");
        }
    }//GEN-LAST:event_wallbut3ActionPerformed

    private void wallbut4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wallbut4ActionPerformed
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jos", "root", "mysql");
            Statement stmt = con.createStatement();
            String query = "Update backgrounds set loginscreen='back4.jpg'";
            int n = stmt.executeUpdate(query);
            loginlabel.setIcon(new ImageIcon(getClass().getResource("back4.jpg")));
            JOptionPane.showMessageDialog(this, "Background set successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.out.println("Error");
        }
    }//GEN-LAST:event_wallbut4ActionPerformed

    private void wallbut5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wallbut5ActionPerformed
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jos", "root", "mysql");
            Statement stmt = con.createStatement();
            String query = "Update backgrounds set loginscreen='back5.jpg'";
            int n = stmt.executeUpdate(query);
            loginlabel.setIcon(new ImageIcon(getClass().getResource("back5.jpg")));
            JOptionPane.showMessageDialog(this, "Background set successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.out.println("Error");
        }
    }//GEN-LAST:event_wallbut5ActionPerformed

    private void wallbut6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wallbut6ActionPerformed
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jos", "root", "mysql");
            Statement stmt = con.createStatement();
            String query = "Update backgrounds set loginscreen='back6.jpg'";
            int n = stmt.executeUpdate(query);
            loginlabel.setIcon(new ImageIcon(getClass().getResource("back6.jpg")));
            JOptionPane.showMessageDialog(this, "Background set successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.out.println("Error");
        }
    }//GEN-LAST:event_wallbut6ActionPerformed

    private void wallbut7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wallbut7ActionPerformed
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jos", "root", "mysql");
            Statement stmt = con.createStatement();
            String query = "Update backgrounds set loginscreen='back7.jpg'";
            int n = stmt.executeUpdate(query);
            loginlabel.setIcon(new ImageIcon(getClass().getResource("back7.jpg")));
            JOptionPane.showMessageDialog(this, "Background set successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.out.println("Error");
        }
    }//GEN-LAST:event_wallbut7ActionPerformed

    private void passchangebutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passchangebutActionPerformed
        ssettings.setVisible(true);
        settings.dispose();
    }//GEN-LAST:event_passchangebutActionPerformed

    private void userbutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userbutActionPerformed
        changeavatar.setVisible(true);
        settings.dispose();
    }//GEN-LAST:event_userbutActionPerformed

    private void jMenuItem37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem37ActionPerformed
        home.setVisible(true);
        changeavatar.dispose();
    }//GEN-LAST:event_jMenuItem37ActionPerformed

    private void jMenuItem38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem38ActionPerformed
        appdrawer.setVisible(true);
        changeavatar.dispose();
    }//GEN-LAST:event_jMenuItem38ActionPerformed

    private void jMenuItem39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem39ActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jMenuItem39ActionPerformed

    private void jMenuItem40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem40ActionPerformed
        aboutus.setVisible(true);
    }//GEN-LAST:event_jMenuItem40ActionPerformed

    private void userbut3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userbut3ActionPerformed
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jos", "root", "mysql");
            Statement stmt = con.createStatement();
            String query = "Update useravatar set avatar='user3.png'";
            int n = stmt.executeUpdate(query);
            userlabel.setIcon(new ImageIcon(getClass().getResource("user3.png")));
            JOptionPane.showMessageDialog(this, "Avatar set successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.out.println("Error");
        }
    }//GEN-LAST:event_userbut3ActionPerformed

    private void powbutton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_powbutton9ActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_powbutton9ActionPerformed

    private void homebutton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homebutton10ActionPerformed
        home.setVisible(true);
        changeavatar.dispose();
    }//GEN-LAST:event_homebutton10ActionPerformed

    private void backbutton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbutton10ActionPerformed
        settings.setVisible(true);
        changeavatar.dispose();
    }//GEN-LAST:event_backbutton10ActionPerformed

    private void userbut1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userbut1ActionPerformed
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jos", "root", "mysql");
            Statement stmt = con.createStatement();
            String query = "Update useravatar set avatar='user1.png'";
            int n = stmt.executeUpdate(query);
            userlabel.setIcon(new ImageIcon(getClass().getResource("user1.png")));
            JOptionPane.showMessageDialog(this, "Avatar set successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.out.println("Error");
        }
    }//GEN-LAST:event_userbut1ActionPerformed

    private void userbut2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userbut2ActionPerformed
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jos", "root", "mysql");
            Statement stmt = con.createStatement();
            String query = "Update useravatar set avatar='user2.png'";
            int n = stmt.executeUpdate(query);
            userlabel.setIcon(new ImageIcon(getClass().getResource("user2.png")));
            JOptionPane.showMessageDialog(this, "Avatar set successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.out.println("Error");
        }
    }//GEN-LAST:event_userbut2ActionPerformed

    private void userbut4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userbut4ActionPerformed
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jos", "root", "mysql");
            Statement stmt = con.createStatement();
            String query = "Update useravatar set avatar='user4.png'";
            int n = stmt.executeUpdate(query);
            userlabel.setIcon(new ImageIcon(getClass().getResource("user4.png")));
            JOptionPane.showMessageDialog(this, "Avatar set successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.out.println("Error");
        }
    }//GEN-LAST:event_userbut4ActionPerformed

    private void userbut5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userbut5ActionPerformed
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jos", "root", "mysql");
            Statement stmt = con.createStatement();
            String query = "Update useravatar set avatar='user5.png'";
            int n = stmt.executeUpdate(query);
            userlabel.setIcon(new ImageIcon(getClass().getResource("user5.png")));
            JOptionPane.showMessageDialog(this, "Avatar set successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.out.println("Error");
        }
    }//GEN-LAST:event_userbut5ActionPerformed

    private void userbut6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userbut6ActionPerformed
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jos", "root", "mysql");
            Statement stmt = con.createStatement();
            String query = "Update useravatar set avatar='user6.png'";
            int n = stmt.executeUpdate(query);
            userlabel.setIcon(new ImageIcon(getClass().getResource("user6.png")));
            JOptionPane.showMessageDialog(this, "Avatar set successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.out.println("Error");
        }
    }//GEN-LAST:event_userbut6ActionPerformed

    private void userbut7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userbut7ActionPerformed
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jos", "root", "mysql");
            Statement stmt = con.createStatement();
            String query = "Update useravatar set avatar='user7.png'";
            int n = stmt.executeUpdate(query);
            userlabel.setIcon(new ImageIcon(getClass().getResource("user7.png")));
            JOptionPane.showMessageDialog(this, "Avatar set successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.out.println("Error");
        }
    }//GEN-LAST:event_userbut7ActionPerformed

    private void userbut8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userbut8ActionPerformed
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jos", "root", "mysql");
            Statement stmt = con.createStatement();
            String query = "Update useravatar set avatar='user8.png'";
            int n = stmt.executeUpdate(query);
            userlabel.setIcon(new ImageIcon(getClass().getResource("user8.png")));
            JOptionPane.showMessageDialog(this, "Avatar set successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.out.println("Error");
        }
    }//GEN-LAST:event_userbut8ActionPerformed

    private void userbut9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userbut9ActionPerformed
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jos", "root", "mysql");
            Statement stmt = con.createStatement();
            String query = "Update useravatar set avatar='user9.png'";
            int n = stmt.executeUpdate(query);
            userlabel.setIcon(new ImageIcon(getClass().getResource("user9.png")));
            JOptionPane.showMessageDialog(this, "Avatar set successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.out.println("Error");
        }
    }//GEN-LAST:event_userbut9ActionPerformed

    private void userbut10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userbut10ActionPerformed
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jos", "root", "mysql");
            Statement stmt = con.createStatement();
            String query = "Update useravatar set avatar='user10.png'";
            int n = stmt.executeUpdate(query);
            userlabel.setIcon(new ImageIcon(getClass().getResource("user10.png")));
            JOptionPane.showMessageDialog(this, "Avatar set successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.out.println("Error");
        }
    }//GEN-LAST:event_userbut10ActionPerformed

    private void userbut11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userbut11ActionPerformed
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jos", "root", "mysql");
            Statement stmt = con.createStatement();
            String query = "Update useravatar set avatar='user11.png'";
            int n = stmt.executeUpdate(query);
            userlabel.setIcon(new ImageIcon(getClass().getResource("user11.png")));
            JOptionPane.showMessageDialog(this, "Avatar set successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.out.println("Error");
        }
    }//GEN-LAST:event_userbut11ActionPerformed

    private void userbut12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userbut12ActionPerformed
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jos", "root", "mysql");
            Statement stmt = con.createStatement();
            String query = "Update useravatar set avatar='user12.png'";
            int n = stmt.executeUpdate(query);
            userlabel.setIcon(new ImageIcon(getClass().getResource("user12.png")));
            JOptionPane.showMessageDialog(this, "Avatar set successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.out.println("Error");
        }
    }//GEN-LAST:event_userbut12ActionPerformed

    private void userbut13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userbut13ActionPerformed
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jos", "root", "mysql");
            Statement stmt = con.createStatement();
            String query = "Update useravatar set avatar='user13.png'";
            int n = stmt.executeUpdate(query);
            userlabel.setIcon(new ImageIcon(getClass().getResource("user13.png")));
            JOptionPane.showMessageDialog(this, "Avatar set successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.out.println("Error");
        }
    }//GEN-LAST:event_userbut13ActionPerformed

    private void userbut14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userbut14ActionPerformed
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jos", "root", "mysql");
            Statement stmt = con.createStatement();
            String query = "Update useravatar set avatar='user14.png'";
            int n = stmt.executeUpdate(query);
            userlabel.setIcon(new ImageIcon(getClass().getResource("user14.png")));
            JOptionPane.showMessageDialog(this, "Avatar set successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.out.println("Error");
        }
    }//GEN-LAST:event_userbut14ActionPerformed

    private void userbut15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userbut15ActionPerformed
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jos", "root", "mysql");
            Statement stmt = con.createStatement();
            String query = "Update useravatar set avatar='user15.png'";
            int n = stmt.executeUpdate(query);
            userlabel.setIcon(new ImageIcon(getClass().getResource("user15.png")));
            JOptionPane.showMessageDialog(this, "Avatar set successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.out.println("Error");
        }
    }//GEN-LAST:event_userbut15ActionPerformed

    private void jMenuItem41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem41ActionPerformed
        home.setVisible(true);
        bullsandcows.dispose();
    }//GEN-LAST:event_jMenuItem41ActionPerformed

    private void jMenuItem42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem42ActionPerformed
        appdrawer.setVisible(true);
        bullsandcows.dispose();
    }//GEN-LAST:event_jMenuItem42ActionPerformed

    private void jMenuItem43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem43ActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jMenuItem43ActionPerformed

    private void jMenuItem44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem44ActionPerformed
        aboutus.setVisible(true);
    }//GEN-LAST:event_jMenuItem44ActionPerformed

    private void powbutton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_powbutton10ActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_powbutton10ActionPerformed

    private void homebutton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homebutton11ActionPerformed
        home.setVisible(true);
        bullsandcows.dispose();
    }//GEN-LAST:event_homebutton11ActionPerformed

    private void backbutton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbutton11ActionPerformed
        appdrawer.setVisible(true);
        bullsandcows.dispose();
    }//GEN-LAST:event_backbutton11ActionPerformed

    private void okbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okbuttonActionPerformed
        String input = inputTF.getText();
        if (input.length() != 4) {
            JOptionPane.showMessageDialog(this, "Please enter a 4 digit word");
            inputTF.setText("");
        } else {
            if (trycount <= 10) {
                int bulls = 0;
                int cows = 0;
                String word = new String();
                char inputch;
                char wordch;
                try {
                    Class.forName("java.sql.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jos", "root", "mysql");
                    Statement stmt = con.createStatement();
                    String query = "Select word from words where srno=" + wordcount;
                    ResultSet rs = stmt.executeQuery(query);
                    if (rs.first()) {
                        word = rs.getString(1);
                    }
                } catch (Exception e) {
                    System.out.println("Error");
                }

                for (int i = 0; i < word.length(); i++) {

                    for (int j = 0; j < input.length();) {
                        wordch = word.charAt(i);
                        if (i == j) {
                            j++;
                        } else {
                            inputch = input.charAt(j);
                            if (inputch == wordch) {
                                cows++;
                            }
                            j++;
                        }
                    }
                }
                for (int i = 0; i < word.length(); i++) {
                    wordch = word.charAt(i);
                    inputch = input.charAt(i);
                    if (inputch == wordch) {
                        bulls++;

                    }
                }
                if (trycount == 1) {
                    inputlabel1.setText(input);
                    bullslabel1.setText(bulls + "");
                    cowslabel1.setText(cows + "");
                } else if (trycount == 2) {
                    inputlabel2.setText(input);
                    bullslabel2.setText(bulls + "");
                    cowslabel2.setText(cows + "");
                } else if (trycount == 3) {
                    inputlabel3.setText(input);
                    bullslabel3.setText(bulls + "");
                    cowslabel3.setText(cows + "");
                } else if (trycount == 4) {
                    inputlabel4.setText(input);
                    bullslabel4.setText(bulls + "");
                    cowslabel4.setText(cows + "");
                } else if (trycount == 5) {
                    inputlabel5.setText(input);
                    bullslabel5.setText(bulls + "");
                    cowslabel5.setText(cows + "");
                } else if (trycount == 6) {
                    inputlabel6.setText(input);
                    bullslabel6.setText(bulls + "");
                    cowslabel6.setText(cows + "");
                } else if (trycount == 7) {
                    inputlabel7.setText(input);
                    bullslabel7.setText(bulls + "");
                    cowslabel7.setText(cows + "");
                } else if (trycount == 8) {
                    inputlabel8.setText(input);
                    bullslabel8.setText(bulls + "");
                    cowslabel8.setText(cows + "");
                } else if (trycount == 9) {
                    inputlabel9.setText(input);
                    bullslabel9.setText(bulls + "");
                    cowslabel9.setText(cows + "");
                } else if (trycount == 10) {
                    inputlabel10.setText(input);
                    bullslabel10.setText(bulls + "");
                    cowslabel10.setText(cows + "");
                }
                if (trycount == 10 && bulls != 4) {
                    JOptionPane.showMessageDialog(this, "Sorry! You lost. The word is- " + word + ".", "You Lost", JOptionPane.PLAIN_MESSAGE);
                    inputTF.setText("");
                    inputlabel1.setText("");
                    bullslabel1.setText("");
                    cowslabel1.setText("");
                    inputlabel2.setText("");
                    bullslabel2.setText("");
                    cowslabel2.setText("");
                    inputlabel3.setText("");
                    bullslabel3.setText("");
                    cowslabel3.setText("");
                    inputlabel4.setText("");
                    bullslabel4.setText("");
                    cowslabel4.setText("");
                    inputlabel5.setText("");
                    bullslabel5.setText("");
                    cowslabel5.setText("");
                    inputlabel6.setText("");
                    bullslabel6.setText("");
                    cowslabel6.setText("");
                    inputlabel7.setText("");
                    bullslabel7.setText("");
                    cowslabel7.setText("");
                    inputlabel8.setText("");
                    bullslabel8.setText("");
                    cowslabel8.setText("");
                    inputlabel9.setText("");
                    bullslabel9.setText("");
                    cowslabel9.setText("");
                    inputlabel10.setText("");
                    bullslabel10.setText("");
                    cowslabel10.setText("");
                    trycount = 0;
                    if (wordcount <= 40) {
                        wordcount++;
                    } else {
                        wordcount = 1;
                    }
                }
                trycount++;
                if (bulls == 4) {
                    JOptionPane.showMessageDialog(this, "You got that!", "You won", JOptionPane.PLAIN_MESSAGE);
                    inputTF.setText("");
                    inputlabel1.setText("");
                    bullslabel1.setText("");
                    cowslabel1.setText("");
                    inputlabel2.setText("");
                    bullslabel2.setText("");
                    cowslabel2.setText("");
                    inputlabel3.setText("");
                    bullslabel3.setText("");
                    cowslabel3.setText("");
                    inputlabel4.setText("");
                    bullslabel4.setText("");
                    cowslabel4.setText("");
                    inputlabel5.setText("");
                    bullslabel5.setText("");
                    cowslabel5.setText("");
                    inputlabel6.setText("");
                    bullslabel6.setText("");
                    cowslabel6.setText("");
                    inputlabel7.setText("");
                    bullslabel7.setText("");
                    cowslabel7.setText("");
                    inputlabel8.setText("");
                    bullslabel8.setText("");
                    cowslabel8.setText("");
                    inputlabel9.setText("");
                    bullslabel9.setText("");
                    cowslabel9.setText("");
                    inputlabel10.setText("");
                    bullslabel10.setText("");
                    cowslabel10.setText("");
                    trycount = 1;
                    if (wordcount <= 40) {
                        wordcount++;
                    } else {
                        wordcount = 1;
                    }
                }

            } else {
                JOptionPane.showMessageDialog(this, "Sorry! You have no more tries left..", "No tries left", JOptionPane.WARNING_MESSAGE);
            }
        }
}//GEN-LAST:event_okbuttonActionPerformed

    private void restartbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restartbtnActionPerformed
        inputTF.setText("");
        inputlabel1.setText("");
        bullslabel1.setText("");
        cowslabel1.setText("");
        inputlabel2.setText("");
        bullslabel2.setText("");
        cowslabel2.setText("");
        inputlabel3.setText("");
        bullslabel3.setText("");
        cowslabel3.setText("");
        inputlabel4.setText("");
        bullslabel4.setText("");
        cowslabel4.setText("");
        inputlabel5.setText("");
        bullslabel5.setText("");
        cowslabel5.setText("");
        inputlabel6.setText("");
        bullslabel6.setText("");
        cowslabel6.setText("");
        inputlabel7.setText("");
        bullslabel7.setText("");
        cowslabel7.setText("");
        inputlabel8.setText("");
        bullslabel8.setText("");
        cowslabel8.setText("");
        inputlabel9.setText("");
        bullslabel9.setText("");
        cowslabel9.setText("");
        inputlabel10.setText("");
        bullslabel10.setText("");
        cowslabel10.setText("");
        trycount = 1;
        if (wordcount <= 40) {
            wordcount++;
        } else {
            wordcount = 1;
        }

}//GEN-LAST:event_restartbtnActionPerformed

    private void jMenuItem45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem45ActionPerformed
        howtoplay.setVisible(true);
    }//GEN-LAST:event_jMenuItem45ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        howtoplay.dispose();
    }//GEN-LAST:event_jButton15ActionPerformed

    private void contactbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactbuttonActionPerformed
        contacts.setVisible(true);
        appdrawer.dispose();
    }//GEN-LAST:event_contactbuttonActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        try {
            int num = Integer.parseInt(numtf.getText());
            if (num > 40) {
                JOptionPane.showMessageDialog(this, "Please enter a number less than 40", "Wrong Input", JOptionPane.WARNING_MESSAGE);
                numtf.setText("");
            } else {
                wordcount = num;
                jd1.dispose();
                numtf.setText("");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Your input is invalid.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButton18ActionPerformed

    private void cbbutnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbutnActionPerformed
        JOptionPane.showMessageDialog(null, "Sorry you have no SIM Card in phone. Please insert a SIM to call", "No SIM Card Detected", JOptionPane.ERROR_MESSAGE);
}//GEN-LAST:event_cbbutnActionPerformed

    private void ContactbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContactbuttonActionPerformed
        addcontact.setVisible(false);
        updatepanel.setVisible(false);
        contactpanel.setVisible(true);

        DefaultTableModel tb = (DefaultTableModel) cnttb.getModel();

        try {
            tb.setRowCount(0);
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jos", "root", "mysql");
            Statement stmt = con.createStatement();
            String query = "Select * from contacts";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int srno = rs.getInt(1);
                String fname = rs.getString(2);
                String lname = rs.getString(3);
                BigInteger num = new BigInteger(rs.getString(4));
                tb.addRow(new Object[]{srno, fname, lname, num});

            }
        } catch (Exception e) {
            System.out.println("Error in connectivity");
        }
}//GEN-LAST:event_ContactbuttonActionPerformed

    private void addcntbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addcntbuttonActionPerformed
        addcontact.setVisible(true);
        contactpanel.setVisible(false);
        updatepanel.setVisible(false);
}//GEN-LAST:event_addcntbuttonActionPerformed

    private void updatebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebuttonActionPerformed
        addcontact.setVisible(false);
        contactpanel.setVisible(false);
        updatepanel.setVisible(true);
}//GEN-LAST:event_updatebuttonActionPerformed

    private void cnttbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cnttbMouseClicked
        int n = cnttb.getSelectedRow();
        int s = (Integer) cnttb.getModel().getValueAt(n, 0);
        delsrno = s;
        details.setVisible(true);
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jos", "root", "mysql");
            Statement stmt = con.createStatement();
            String query = "Select * from contacts where sr_no=" + s;
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            namelbl.setText(rs.getString(2) + " " + rs.getString(3));
            BigInteger num = new BigInteger(rs.getString(4));
            numlbl.setText("" + num);
            con.close();
            stmt.close();
            rs.close();
        } catch (Exception e) {
            System.out.println("Error in connectivity");
        }
    }//GEN-LAST:event_cnttbMouseClicked

    private void contactpanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contactpanelMouseClicked
        // TODO add your handling code here:
}//GEN-LAST:event_contactpanelMouseClicked

    private void searchbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbuttonActionPerformed
        String name = searchtf.getText();

        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jos", "root", "mysql");
            Statement stmt = con.createStatement();
            String query = "Select * from contacts where first_name='" + name + "'";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                int count = 1;
                while (rs.next()) {
                    count++;
                }

                String query1 = "Select * from contacts where first_name='" + name + "'";
                ResultSet rs1 = stmt.executeQuery(query1);
                if (count == 1) {
                    rs1.next();
                    delsrno = rs1.getInt(1);
                    details.setVisible(true);
                    String fname = rs1.getString(2);
                    String lname = rs1.getString(3);
                    namelbl.setText(fname + " " + lname);
                    BigInteger num = new BigInteger(rs1.getString(4));
                    numlbl.setText("" + num);
                } else {
                    tbdetails.setVisible(true);
                    DefaultTableModel tb = (DefaultTableModel) dtb.getModel();
                    while (rs1.next()) {
                        int srno = rs1.getInt(1);
                        String fname = rs1.getString(2);
                        String lname = rs1.getString(3);
                        BigInteger num = new BigInteger(rs1.getString(4));
                        tb.addRow(new Object[]{srno, fname, lname, num});

                    }
                    rs1.close();
                }
            } else {
                JOptionPane.showMessageDialog(this, "No Contact with such name exists", "No Contact found", JOptionPane.ERROR_MESSAGE);
            }

            con.close();
            stmt.close();
            rs.close();
            searchtf.setText("  Search by First Name.....");
        } catch (Exception e) {
            System.out.println("Error in connectivity");
        }
}//GEN-LAST:event_searchbuttonActionPerformed

    private void searchtfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchtfMouseClicked
        searchtf.setText("");
}//GEN-LAST:event_searchtfMouseClicked

    private void searchtfMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchtfMouseExited
}//GEN-LAST:event_searchtfMouseExited

    private void addcntctActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addcntctActionPerformed
        BigInteger num = new BigInteger(numtf1.getText());
        String fname = fnametf.getText();
        String lname = lnametf.getText();
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jos", "root", "mysql");
            Statement stmt = con.createStatement();
            String query = "Select max(Sr_No) from contacts";
            ResultSet rs1 = stmt.executeQuery(query);
            rs1.next();
            int srno = rs1.getInt(1) + 1;
            String query2 = "Insert into contacts values(" + srno + ",'" + fname + "','" + lname + "'," + num + ")";
            stmt.executeUpdate(query2);
            JOptionPane.showMessageDialog(this, "Your Contact has been added successfully", "Contact Added", JOptionPane.INFORMATION_MESSAGE);
            numtf1.setText("");
            lnametf.setText("");
            fnametf.setText("");
        } catch (Exception e) {
            System.out.println("Error in connectivity");
        }
}//GEN-LAST:event_addcntctActionPerformed

    private void shbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shbuttonActionPerformed
        if (srnotf.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please Enter a Sr.No to get details!!", "Wrong Sr_No", JOptionPane.ERROR_MESSAGE);
        } else {

            int srno = Integer.parseInt(srnotf.getText());
            try {
                Class.forName("java.sql.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jos", "root", "mysql");
                Statement stmt = con.createStatement();
                String query = "Select Sr_No from contacts where Sr_No=" + srno;
                ResultSet rs = stmt.executeQuery(query);

                if (rs.next()) {
                    String query2 = "Select * from contacts where Sr_no=" + srno;
                    ResultSet rs1 = stmt.executeQuery(query2);
                    rs1.next();
                    String uname = rs1.getString(2);
                    String lname = rs1.getString(3);
                    ufnametf.setText(uname);
                    ulnametf.setText(lname);
                    BigInteger num = new BigInteger(rs1.getString(4));
                    unumtf.setText("" + num);
                    delbutton.setEnabled(true);
                    jLabel9.setEnabled(true);
                    jLabel10.setEnabled(true);
                    jLabel8.setEnabled(true);
                    upbutton.setEnabled(true);
                    ufnametf.setEnabled(true);
                    ulnametf.setEnabled(true);
                    unumtf.setEnabled(true);
                    srnotf.setEnabled(false);
                    resetbutton.setEnabled(true);
                } else {
                    JOptionPane.showMessageDialog(this, "You have entered wrong Serial Number!!. Please enter the correct number", "Wrong Sr_No", JOptionPane.ERROR_MESSAGE);

                }

            } catch (Exception e) {
                System.out.println("Error in connectivity");
            }
        }
}//GEN-LAST:event_shbuttonActionPerformed

    private void upbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upbuttonActionPerformed
        int srno = Integer.parseInt(srnotf.getText());
        String fname = ufnametf.getText();
        String lname = ulnametf.getText();
        BigInteger num = new BigInteger(unumtf.getText());
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jos", "root", "mysql");
            Statement stmt = con.createStatement();
            String query = "Update contacts set first_name='" + fname + "',last_name='" + lname + "',number=" + num + " where sr_no=" + srno;
            int n = stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(this, "Row successfully Updated", "Row Updated", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.out.println("Error in connectivity");
        }
}//GEN-LAST:event_upbuttonActionPerformed

    private void delbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delbuttonActionPerformed
        int srno = Integer.parseInt(srnotf.getText());
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jos", "root", "mysql");
            Statement stmt = con.createStatement();
            String query = "Delete from contacts where sr_no=" + srno;
            if ((JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this record?", "Delete Record", JOptionPane.YES_NO_OPTION)) == JOptionPane.YES_OPTION) {
                int n = stmt.executeUpdate(query);
                if (n == 0) {
                    JOptionPane.showMessageDialog(this, "Row does not exist", "No Row Remaining", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Row successfully deleted", "Row Deleted", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch (Exception e) {
            System.out.println("Error in connectivity");
        }
}//GEN-LAST:event_delbuttonActionPerformed

    private void resetbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetbuttonActionPerformed
        delbutton.setEnabled(false);
        jLabel9.setEnabled(false);
        jLabel10.setEnabled(false);
        jLabel8.setEnabled(false);
        upbutton.setEnabled(false);
        ufnametf.setEnabled(false);
        ulnametf.setEnabled(false);
        unumtf.setEnabled(false);
        srnotf.setEnabled(true);
        resetbutton.setEnabled(false);
        ufnametf.setText("");
        ulnametf.setText("");
        unumtf.setText("");
        srnotf.setText("");
    }//GEN-LAST:event_resetbuttonActionPerformed

    private void DclosebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DclosebuttonActionPerformed
        details.setVisible(false);
        addcontact.setVisible(false);
        contactpanel.setVisible(true);
        updatepanel.setVisible(false);
        DefaultTableModel tb = (DefaultTableModel) cnttb.getModel();

        try {
            tb.setRowCount(0);
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jos", "root", "mysql");
            Statement stmt = con.createStatement();
            String query = "Select * from contacts";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int srno = rs.getInt(1);
                String fname = rs.getString(2);
                String lname = rs.getString(3);
                BigInteger num = new BigInteger(rs.getString(4));
                tb.addRow(new Object[]{srno, fname, lname, num});

            }
        } catch (Exception e) {
            System.out.println("Error in connectivity");
        }
}//GEN-LAST:event_DclosebuttonActionPerformed

    private void DdelbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DdelbuttonActionPerformed
        if ((JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this record?", "Delete Record", JOptionPane.YES_NO_OPTION)) == JOptionPane.YES_OPTION) {
            try {
                Class.forName("java.sql.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jos", "root", "mysql");
                Statement stmt = con.createStatement();
                String query = "Delete from contacts where sr_no=" + delsrno;
                int n = stmt.executeUpdate(query);
                if (n == 0) {
                    JOptionPane.showMessageDialog(this, "Contact does not exist", "No Contact Remaining", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Contact successfully deleted", "Contact Deleted", JOptionPane.INFORMATION_MESSAGE);
                }
                con.close();
                stmt.close();

            } catch (Exception e) {
                System.out.println("Error in connectivity");
            }

        }
}//GEN-LAST:event_DdelbuttonActionPerformed

    private void DcalbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DcalbuttonActionPerformed
        String name = namelbl.getText();
        BigInteger num = new BigInteger(numlbl.getText());

        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jos", "root", "mysql");
            Statement stmt = con.createStatement();
            String query1 = "delete from calling";
            int rs1 = stmt.executeUpdate(query1);
            String query = "Insert into calling values('" + name + "'," + num + ")";
            int rs = stmt.executeUpdate(query);
            pbname1.setText(name);
            pbnum1.setText("" + num);
            con.close();
            stmt.close();

        } catch (Exception e) {
            System.out.println("Error in connectivity");
        }
        JOptionPane.showMessageDialog(null, "Sorry you have no SIM Card in phone. Please insert a SIM to call", "No SIM Card Detected", JOptionPane.ERROR_MESSAGE);
}//GEN-LAST:event_DcalbuttonActionPerformed

    private void dtbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dtbMouseClicked
        int n = dtb.getSelectedRow();
        int s = (Integer) dtb.getModel().getValueAt(n, 0);
        delsrno = s;
        details.setVisible(true);
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jos", "root", "mysql");
            Statement stmt = con.createStatement();
            String query = "Select * from contacts where sr_no=" + s;
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            namelbl.setText(rs.getString(2) + " " + rs.getString(3));
            BigInteger num = new BigInteger(rs.getString(4));
            numlbl.setText("" + num);
            con.close();
            stmt.close();
            rs.close();
        } catch (Exception e) {
            System.out.println("Error in connectivity");
        }
        tbdetails.setVisible(false);
}//GEN-LAST:event_dtbMouseClicked

    private void inputTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputTFActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        firstnum = Double.parseDouble(t.getText());
    t.setText("");
    operations="-";
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
    firstnum = Double.parseDouble(t.getText());
    t.setText("");
    operations="*";   // TODO add your handling code here:
    
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
    firstnum = Double.parseDouble(t.getText());
    t.setText("");
    operations="/";
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
    double as = Double.parseDouble(String.valueOf(t.getText()));
    as = as * (-1);
    t.setText(String.valueOf(as));
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
    double as = Double.parseDouble(String.valueOf(t.getText()));
    as = Math.sqrt(as);
    t.setText(String.valueOf(as));        // TODO add your handling code here:
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        t.setText("");        // TODO add your handling code here:
    }//GEN-LAST:event_jButton21ActionPerformed

    private void passTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passTFActionPerformed

    private void jMenuItem46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem46ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem46ActionPerformed

    private void jMenuItem48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem48ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem48ActionPerformed

    private void jMenu23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu23ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu23ActionPerformed

    private void jMenuItem49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem49ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem49ActionPerformed

    private void gamebutton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gamebutton1ActionPerformed
        bullsandcows.setVisible(true);
        jd1.setVisible(true);
        home.dispose();
    }//GEN-LAST:event_gamebutton1ActionPerformed

    private void contactbutton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactbutton1ActionPerformed
        contacts.setVisible(true);
        home.setVisible(false);
    }//GEN-LAST:event_contactbutton1ActionPerformed

    private void billbutton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_billbutton1ActionPerformed
        gblogin.setVisible(true);
        home.setVisible(false);
    }//GEN-LAST:event_billbutton1ActionPerformed

    private void appbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appbuttonActionPerformed
        appdrawer.dispose();
        appdrawer.setVisible(true);
        home.setVisible(false);
    }//GEN-LAST:event_appbuttonActionPerformed

    private void powbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_powbuttonActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }// TODO add your handling code here:
    }//GEN-LAST:event_powbuttonActionPerformed

    private void homebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homebuttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_homebuttonActionPerformed

    private void backbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbuttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backbuttonActionPerformed

    private void calcbutton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcbutton1ActionPerformed
       calculator.setVisible(true);
        home.setVisible(false);
    }//GEN-LAST:event_calcbutton1ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
fnameTF.setText("");
ftypeTF.setText("");
FpriceTF.setText("");
FquantityTF.setText("");
famountTF.setText("");
ftpriceTF.setText("0");

    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
DefaultTableModel x=(DefaultTableModel) billTB.getModel();
int rows=x.getRowCount();
if(rows>0){
    for(int i=0;i<rows;i++) {
        x.removeRow(0);
    }
}
totalamtTF.setText("");
// TODO add your handling code here:
    }//GEN-LAST:event_jButton23ActionPerformed

    private void settingbutton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingbutton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_settingbutton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Contactbutton;
    private javax.swing.JButton Dcalbutton;
    private javax.swing.JButton Dclosebutton;
    private javax.swing.JButton Ddelbutton;
    private javax.swing.JTextField FpriceTF;
    private javax.swing.JTextField FquantityTF;
    private javax.swing.JComboBox SouthCmB;
    private javax.swing.JButton aboutbutton;
    private javax.swing.JDialog aboutus;
    private javax.swing.JButton addcntbutton;
    private javax.swing.JButton addcntct;
    private javax.swing.JPanel addcontact;
    private javax.swing.JButton appbutton;
    private javax.swing.JFrame appdrawer;
    private javax.swing.JButton b0;
    private javax.swing.JButton b1;
    private javax.swing.JButton b2;
    private javax.swing.JButton b3;
    private javax.swing.JButton b4;
    private javax.swing.JButton b5;
    private javax.swing.JButton b6;
    private javax.swing.JButton b7;
    private javax.swing.JButton b8;
    private javax.swing.JButton b9;
    private javax.swing.JButton backbutton;
    private javax.swing.JButton backbutton1;
    private javax.swing.JButton backbutton10;
    private javax.swing.JButton backbutton11;
    private javax.swing.JButton backbutton3;
    private javax.swing.JButton backbutton4;
    private javax.swing.JButton backbutton5;
    private javax.swing.JButton backbutton6;
    private javax.swing.JButton backbutton7;
    private javax.swing.JButton backbutton8;
    private javax.swing.JButton backbutton9;
    private javax.swing.JTable billTB;
    private javax.swing.JButton billbutton;
    private javax.swing.JButton billbutton1;
    private javax.swing.JFrame billing;
    private javax.swing.JFrame billtable;
    private javax.swing.JFrame bullsandcows;
    private javax.swing.JLabel bullslabel1;
    private javax.swing.JLabel bullslabel10;
    private javax.swing.JLabel bullslabel2;
    private javax.swing.JLabel bullslabel3;
    private javax.swing.JLabel bullslabel4;
    private javax.swing.JLabel bullslabel5;
    private javax.swing.JLabel bullslabel6;
    private javax.swing.JLabel bullslabel7;
    private javax.swing.JLabel bullslabel8;
    private javax.swing.JLabel bullslabel9;
    private javax.swing.JButton calcbutton;
    private javax.swing.JButton calcbutton1;
    private javax.swing.JFrame calculator;
    private javax.swing.JButton cancelbutton1;
    private javax.swing.JButton cbbutn;
    private javax.swing.JFrame changeavatar;
    private javax.swing.JFrame changeback;
    private javax.swing.JComboBox chappatiCmB;
    private javax.swing.JTable cnttb;
    private javax.swing.JButton contactbutton;
    private javax.swing.JButton contactbutton1;
    private javax.swing.JScrollPane contactpanel;
    private javax.swing.JFrame contacts;
    private javax.swing.JLabel cowslabel1;
    private javax.swing.JLabel cowslabel10;
    private javax.swing.JLabel cowslabel2;
    private javax.swing.JLabel cowslabel3;
    private javax.swing.JLabel cowslabel4;
    private javax.swing.JLabel cowslabel5;
    private javax.swing.JLabel cowslabel6;
    private javax.swing.JLabel cowslabel7;
    private javax.swing.JLabel cowslabel8;
    private javax.swing.JLabel cowslabel9;
    private javax.swing.JPasswordField curpass2TF;
    private javax.swing.JPasswordField curpassTF;
    private javax.swing.JTextField curuser2TF;
    private javax.swing.JTextField curuserTF;
    private javax.swing.JComboBox dalCmB;
    private javax.swing.JButton delbutton;
    private javax.swing.JFrame details;
    private javax.swing.JButton displaybut;
    private javax.swing.JComboBox drinksCmB;
    private javax.swing.JTable dtb;
    private javax.swing.JTextField famountTF;
    private javax.swing.JTextField fnameTF;
    private javax.swing.JTextField fnametf;
    private javax.swing.JTextField ftpriceTF;
    private javax.swing.JTextField ftypeTF;
    private javax.swing.JButton gamebutton;
    private javax.swing.JButton gamebutton1;
    private javax.swing.JPanel gamepanel;
    private javax.swing.JFrame gblogin;
    private javax.swing.JPasswordField gbpassPF;
    private javax.swing.JTextField gbuserTF;
    private javax.swing.JFrame home;
    private javax.swing.JButton homebutton;
    private javax.swing.JButton homebutton1;
    private javax.swing.JButton homebutton10;
    private javax.swing.JButton homebutton11;
    private javax.swing.JButton homebutton3;
    private javax.swing.JButton homebutton4;
    private javax.swing.JButton homebutton5;
    private javax.swing.JButton homebutton6;
    private javax.swing.JButton homebutton7;
    private javax.swing.JButton homebutton8;
    private javax.swing.JButton homebutton9;
    private javax.swing.JLabel homelabel;
    private javax.swing.JDialog howtoplay;
    private javax.swing.JTextField inputTF;
    private javax.swing.JLabel inputlabel1;
    private javax.swing.JLabel inputlabel10;
    private javax.swing.JLabel inputlabel2;
    private javax.swing.JLabel inputlabel3;
    private javax.swing.JLabel inputlabel4;
    private javax.swing.JLabel inputlabel5;
    private javax.swing.JLabel inputlabel6;
    private javax.swing.JLabel inputlabel7;
    private javax.swing.JLabel inputlabel8;
    private javax.swing.JLabel inputlabel9;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu13;
    private javax.swing.JMenu jMenu14;
    private javax.swing.JMenu jMenu15;
    private javax.swing.JMenu jMenu16;
    private javax.swing.JMenu jMenu17;
    private javax.swing.JMenu jMenu18;
    private javax.swing.JMenu jMenu19;
    private javax.swing.JMenu jMenu20;
    private javax.swing.JMenu jMenu21;
    private javax.swing.JMenu jMenu22;
    private javax.swing.JMenu jMenu23;
    private javax.swing.JMenu jMenu24;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar10;
    private javax.swing.JMenuBar jMenuBar11;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuBar jMenuBar4;
    private javax.swing.JMenuBar jMenuBar5;
    private javax.swing.JMenuBar jMenuBar6;
    private javax.swing.JMenuBar jMenuBar7;
    private javax.swing.JMenuBar jMenuBar8;
    private javax.swing.JMenuBar jMenuBar9;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem24;
    private javax.swing.JMenuItem jMenuItem25;
    private javax.swing.JMenuItem jMenuItem26;
    private javax.swing.JMenuItem jMenuItem27;
    private javax.swing.JMenuItem jMenuItem28;
    private javax.swing.JMenuItem jMenuItem29;
    private javax.swing.JMenuItem jMenuItem30;
    private javax.swing.JMenuItem jMenuItem31;
    private javax.swing.JMenuItem jMenuItem32;
    private javax.swing.JMenuItem jMenuItem33;
    private javax.swing.JMenuItem jMenuItem34;
    private javax.swing.JMenuItem jMenuItem35;
    private javax.swing.JMenuItem jMenuItem36;
    private javax.swing.JMenuItem jMenuItem37;
    private javax.swing.JMenuItem jMenuItem38;
    private javax.swing.JMenuItem jMenuItem39;
    private javax.swing.JMenuItem jMenuItem40;
    private javax.swing.JMenuItem jMenuItem41;
    private javax.swing.JMenuItem jMenuItem42;
    private javax.swing.JMenuItem jMenuItem43;
    private javax.swing.JMenuItem jMenuItem44;
    private javax.swing.JMenuItem jMenuItem45;
    private javax.swing.JMenuItem jMenuItem46;
    private javax.swing.JMenuItem jMenuItem47;
    private javax.swing.JMenuItem jMenuItem48;
    private javax.swing.JMenuItem jMenuItem49;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JDialog jd1;
    private javax.swing.JTextField lnametf;
    private javax.swing.JLabel loginlabel;
    private javax.swing.JLabel menulabel;
    private javax.swing.JLabel namelbl;
    private javax.swing.JTextField newpassTF;
    private javax.swing.JTextField newuserTF;
    private javax.swing.JFrame nextprime;
    private javax.swing.JButton npbutton;
    private javax.swing.JLabel numlbl;
    private javax.swing.JTextField numtf;
    private javax.swing.JTextField numtf1;
    private javax.swing.JButton okbutton;
    private javax.swing.JPasswordField passTF;
    private javax.swing.JButton passchangebut;
    private javax.swing.JLabel pbname1;
    private javax.swing.JLabel pbnum1;
    private javax.swing.JButton powbutton;
    private javax.swing.JButton powbutton1;
    private javax.swing.JButton powbutton10;
    private javax.swing.JButton powbutton3;
    private javax.swing.JButton powbutton4;
    private javax.swing.JButton powbutton5;
    private javax.swing.JButton powbutton6;
    private javax.swing.JButton powbutton7;
    private javax.swing.JButton powbutton8;
    private javax.swing.JButton powbutton9;
    private javax.swing.JButton pyramid;
    private javax.swing.JButton resetbutton;
    private javax.swing.JButton restartbtn;
    private javax.swing.JComboBox riceCmB;
    private javax.swing.JComboBox sandwichCmB;
    private javax.swing.JButton searchbutton;
    private javax.swing.JTextField searchtf;
    private javax.swing.JButton settingbutton;
    private javax.swing.JButton settingbutton1;
    private javax.swing.JFrame settings;
    private javax.swing.JButton shbutton;
    private javax.swing.JComboBox soupCmB;
    private javax.swing.JTextField srnotf;
    private javax.swing.JFrame ssettings;
    private javax.swing.JButton subbutton1;
    private javax.swing.JTextField t;
    private javax.swing.JTextField t1;
    private javax.swing.JTextField t2;
    private javax.swing.JFrame tbdetails;
    private javax.swing.JTextField totalamtTF;
    private javax.swing.JTextField ufnametf;
    private javax.swing.JTextField ulnametf;
    private javax.swing.JTextField unumtf;
    private javax.swing.JButton upbutton;
    private javax.swing.JButton updatebutton;
    private javax.swing.JPanel updatepanel;
    private javax.swing.JTextField userTF;
    private javax.swing.JButton userbut;
    private javax.swing.JButton userbut1;
    private javax.swing.JButton userbut10;
    private javax.swing.JButton userbut11;
    private javax.swing.JButton userbut12;
    private javax.swing.JButton userbut13;
    private javax.swing.JButton userbut14;
    private javax.swing.JButton userbut15;
    private javax.swing.JButton userbut2;
    private javax.swing.JButton userbut3;
    private javax.swing.JButton userbut4;
    private javax.swing.JButton userbut5;
    private javax.swing.JButton userbut6;
    private javax.swing.JButton userbut7;
    private javax.swing.JButton userbut8;
    private javax.swing.JButton userbut9;
    private javax.swing.JLabel userlabel;
    private javax.swing.JComboBox vegCmB;
    private javax.swing.JButton wallbut1;
    private javax.swing.JButton wallbut10;
    private javax.swing.JButton wallbut11;
    private javax.swing.JButton wallbut12;
    private javax.swing.JButton wallbut13;
    private javax.swing.JButton wallbut14;
    private javax.swing.JButton wallbut2;
    private javax.swing.JButton wallbut3;
    private javax.swing.JButton wallbut4;
    private javax.swing.JButton wallbut5;
    private javax.swing.JButton wallbut6;
    private javax.swing.JButton wallbut7;
    private javax.swing.JButton wallbut8;
    private javax.swing.JButton wallbut9;
    // End of variables declaration//GEN-END:variables
}
