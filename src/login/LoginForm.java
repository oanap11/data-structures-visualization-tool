package login;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import dsa.Main;
import dsa.utils.FormLayoutUtils;

public class LoginForm extends JFrame {

    private JPanel mainPanel;
    private JButton loginButton;
    private JLabel loginLabel;
    private JPasswordField passField;
    private JLabel passLabel;
    private JButton registerButton;
    private JLabel userLabel;
    private JTextField userTextField;

    public LoginForm() {
        initComponents();
    }

    private void initComponents() {
    	setTitle("Login");
    	setResizable(false);
    	setLocationRelativeTo(null);

    	mainPanel = new JPanel();
        loginLabel = new JLabel();
        userLabel = new JLabel();
        passLabel = new JLabel();
        userTextField = new JTextField();
        loginButton = new JButton();
        registerButton = new JButton();
        passField = new JPasswordField();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setBackground(new Color(211, 227, 235));
        loginLabel.setIcon(new ImageIcon(getClass().getResource("/images/logoLogin.png")));

        userLabel.setFont(new Font("Bitstream Vera Sans Mono", 1, 24)); // NOI18N
        userLabel.setForeground(new Color(31, 40, 56));
        userLabel.setText("Utilizator");

        passLabel.setFont(new Font("Bitstream Vera Sans Mono", 1, 24)); // NOI18N
        passLabel.setForeground(new Color(31, 40, 56));
        passLabel.setText("Parola");

        loginButton.setBackground(new Color(11, 167, 88));
        loginButton.setFont(new Font("Bitstream Vera Sans Mono", 1, 18)); // NOI18N
        loginButton.setText("Login");
        loginButton.setBorder(null);
        loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				 String userName = userTextField.getText();
	              String password = passField.getText();
	                try {
	                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/aplicatieLicenta",
	                        "root", "password");

	                    PreparedStatement st = connection
	                        .prepareStatement("Select username, password from cont where username=? and password=?");

	                    st.setString(1, userName);
	                    st.setString(2, password);
	                    ResultSet rs = st.executeQuery();
	                    if (rs.next()) {
	                        dispose();

	                        try {
	                			String className = UIManager.getCrossPlatformLookAndFeelClassName();
	                			UIManager.setLookAndFeel(className);
	                		} catch (Exception e) {}

	                    	Font f = new Font("sans-serif", Font.PLAIN, 50);
	                    	UIManager.put("Menu.font", f);
	                    	UIManager.put("MenuItem.font", f);

	                    	UIManager.put("MenuBar.background", new Color(255, 87, 51));
	                        UIManager.put("MenuItem.background", new Color(255, 87, 51));

	                		SwingUtilities.invokeLater(new Runnable(){
	                			@Override
								public void run() {
	                				Main main = new Main();
	                				main.setPreferredSize(new Dimension(400, 300));
	                				main.setVisible(true);

	                			}
	                		});

	                    } else {
	                        JOptionPane.showMessageDialog(loginButton, "Informatiile introduse nu se afla in baza de date.");
	                    }
	                } catch (SQLException sqlException) {
	                    sqlException.printStackTrace();
	                }
			}
		});

        registerButton.setBackground(new Color(11, 167, 88));
        registerButton.setFont(new Font("Bitstream Vera Sans Mono", 1, 18)); // NOI18N
        registerButton.setText("Inregistrare");
        registerButton.setBorder(null);
        registerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				EventQueue.invokeLater(new Runnable() {
		            @Override
					public void run() {
		                try {
		                	setVisible(false);
		                    RegisterForm frame = new RegisterForm();
		                    frame.setVisible(true);
		                } catch (Exception e) {
		                    e.printStackTrace();
		                }
		            }
		        });
			}
		});

        FormLayoutUtils.setupLoginPanelLayout(mainPanel, userLabel, userTextField, passLabel, passField, loginButton, registerButton, loginLabel);
        FormLayoutUtils.setCommonLayout(mainPanel,getContentPane());
        pack();
    }


    public static void main(String args[]) {

    	try {
			String className = UIManager.getCrossPlatformLookAndFeelClassName();
			UIManager.setLookAndFeel(className);
		} catch (Exception e) {}

		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run() {
				new LoginForm().setVisible(true);
			}
		});

    }
}
