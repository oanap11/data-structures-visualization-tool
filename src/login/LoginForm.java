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
	                        .prepareStatement("Select user, parola from cont where user=? and parola=?");

	                    st.setString(1, userName);
	                    st.setString(2, password);
	                    ResultSet rs = st.executeQuery();
	                    if (rs.next()) {
	                        dispose();
	                        /*Main test = new Main();
	                        //ah.setTitle("Welcome");
	                        test.setVisible(true);*/
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passLabel)
                    .addComponent(userLabel)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                            .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(158, 158, 158)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(userTextField)
                                .addComponent(passField, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)))))
                .addContainerGap(95, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(loginLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(161, 161, 161))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(loginLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userLabel)
                    .addComponent(userTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passLabel)
                    .addComponent(passField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

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
