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
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		mainPanel = new JPanel();
		loginLabel = new JLabel();
		userLabel = createLabel("Utilizator");
		passLabel = createLabel("Parola");
		userTextField = new JTextField();
		passField = new JPasswordField();

		mainPanel.setBackground(new Color(211, 227, 235));
		loginLabel.setIcon(new ImageIcon(getClass().getResource("/images/logoLogin.png")));

		loginButton = createButton("Log In", this::loginButtonActionPerformed);
		registerButton = createButton("Inregistrare", this::registerButtonActionPerformed);

		FormLayoutUtils.setupLoginPanelLayout(mainPanel, userLabel, userTextField, passLabel, passField, loginButton,
				registerButton, loginLabel);
		FormLayoutUtils.setCommonLayout(mainPanel, getContentPane());
		pack();
		setLocationRelativeTo(null);
	}
	
	private JLabel createLabel(String text) {
	    JLabel label = new JLabel(text);
	    label.setFont(new Font("Bitstream Vera Sans Mono", Font.BOLD, 24));
	    label.setForeground(new Color(31, 40, 56));
	    return label;
	}

	private JButton createButton(String text, ActionListener listener) {
		JButton button = new JButton();
		button.setBackground(new Color(11, 167, 88));
		button.setFont(new Font("Bitstream Vera Sans Mono", 1, 18));
		button.setText(text);
		button.setBorder(null);
		button.addActionListener(listener);
		return button;
	}
	
	private void registerButtonActionPerformed(ActionEvent evt) {
		EventQueue.invokeLater(() -> {
		    setVisible(false);
		    try {
		        RegisterForm frame = new RegisterForm();
		        frame.setVisible(true);
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		});
	}

	private void loginButtonActionPerformed(ActionEvent evt) {

		String userName = userTextField.getText();
		String password = passField.getText();
		try {
			Connection connection = DatabaseConnectionManager.getConnection();

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
				} catch (Exception e) {
				}

				Main.configureUIManager();

				SwingUtilities.invokeLater(new Runnable() {
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

}
