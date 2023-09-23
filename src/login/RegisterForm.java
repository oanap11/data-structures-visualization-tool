package login;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import dsa.utils.FormLayoutUtils;


public class RegisterForm extends JFrame {

	LoginForm login;

    private JButton backButton;
    private JLabel emailLabel;
    private JTextField emailTextField;
    private JLabel logo;
    private JPanel mainPanel;
    private JPasswordField passField;
    private JLabel passLabel;
    private JButton registerButton;
    private JButton resetButton;
    private JLabel userLabel;
    private JTextField userTextField;

    public RegisterForm() {
        initComponents();
    }

    private void initComponents() {
    	setTitle("Inregistrare");
    	setResizable(false);
    	//setLocationRelativeTo(null);
    	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    	this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        mainPanel = new JPanel();
        logo = new JLabel();
        //email
        emailLabel = new JLabel();
        emailTextField = new JTextField();

        //utilizator
        userLabel = new JLabel();
        userTextField = new JTextField();

        //parola
        passLabel = new JLabel();
        passField = new JPasswordField();

        //butoane
        registerButton = new JButton();
        resetButton = new JButton();
        backButton = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainPanel.setBackground(new Color(211, 227, 235));
        logo.setIcon(new ImageIcon(getClass().getResource("/images/logoInregistrare.png")));

        emailLabel.setFont(new Font("Bitstream Vera Sans Mono", 1, 18));
        emailLabel.setText("E-mail");

        userLabel.setFont(new Font("Bitstream Vera Sans Mono", 1, 18));
        userLabel.setText("Utilizator");

        passLabel.setFont(new Font("Bitstream Vera Sans Mono", 1, 18));
        passLabel.setText("Parola");

        //buton de inregistrare
        registerButton.setBackground(new Color(11, 167, 88));
        registerButton.setFont(new Font("Bitstream Vera Sans Mono", 1, 18));
        registerButton.setText("Inregistreaza-te");
        registerButton.setBorder(null);
        registerButton.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        //buton de reset
        resetButton.setBackground(new Color(11, 167, 88));
        resetButton.setFont(new Font("Bitstream Vera Sans Mono", 1, 18)); // NOI18N
        resetButton.setText("Reseteaza");
        resetButton.setBorder(null);
        resetButton.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        //buton back login
        backButton.setBackground(new Color(211, 227, 235));
        backButton.setIcon(new ImageIcon(getClass().getResource("/images/backButton.png"))); // NOI18N
        backButton.setBorder(null);
        backButton.setFocusPainted(false);
        backButton.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        FormLayoutUtils.setupRegisterPanelLayout(mainPanel, registerButton, resetButton, userLabel, passLabel, emailLabel, emailTextField, passField, userTextField, backButton, logo);

        FormLayoutUtils.setCommonLayout(mainPanel,getContentPane());
        pack();
    }

    private void registerButtonActionPerformed(ActionEvent evt) {
    	String email = emailTextField.getText();
        String username = userTextField.getText();
        String password = passField.getText();

        if(!Validation.checkValidUser(username)) {
        	JOptionPane.showMessageDialog(null, "Introduceti un nume de utilizator care are minim 6 caractere si nu contine spatii");
        }
        else if(Validation.checkUsernameExists(username)) {
        	JOptionPane.showMessageDialog(null, "Numele de utilizator este deja utilizat.");
        }
        else if(!Validation.checkValidPassword(password)) {
        	JOptionPane.showMessageDialog(null, "Introduceti o parola de minim 6 caractere care contine o cifra");
        }
        else if(!Validation.checkValidEmail(email)) {
        	JOptionPane.showMessageDialog(null, "Introduceti o adresa de e-mail valida.");
        }


        else {
        	boolean check = Validation.checkValidEmail(email) && Validation.checkValidUser(username)
        			&& Validation.checkValidPassword(password);
            if (check) {
            	try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/aplicatieLicenta", "root", "password");

                    String query = "INSERT INTO cont (username, password, email) VALUES ('" + username + "','" + password + "','" + email + "')";

                    Statement sta = connection.createStatement();
                    int x = sta.executeUpdate(query);
                    if (x == 0) {
                        JOptionPane.showMessageDialog(registerButton, "Numele introdus apartine altui utilizator.");
                    } else {
                        JOptionPane.showMessageDialog(registerButton,
                            "Contul dumneavoastra a fost creat.");
                    }
                    connection.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
            else {
            	JOptionPane.showMessageDialog(null, "Adresa de e-mail nu este valida.");
            }

        }
    }

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {
        clearFields();
    }

    private void backButtonActionPerformed(ActionEvent evt) {
    	setVisible(false);
    	login = new LoginForm();
    	login.setVisible(true);
    }

    private void clearFields() {
    	emailTextField.setText(null);
    	userTextField.setText(null);
    	passField.setText(null);
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        EventQueue.invokeLater(new Runnable() {
            @Override
			public void run() {
                RegisterForm register = new RegisterForm();
                register.setVisible(true);
            }
        });
    }


}
