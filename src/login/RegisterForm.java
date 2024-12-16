package login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import dsa.common.FormLayoutUtils;

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
    	setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        mainPanel = new JPanel();
        mainPanel.setBackground(new Color(211, 227, 235));
        
        logo = new JLabel();
        logo.setIcon(new ImageIcon(getClass().getResource(Constants.REGISTER_LOGO)));

        emailLabel = createLabel("E-mail");
        emailTextField = createTextField();

        userLabel = createLabel("Utilizator");
        userTextField = createTextField();

        passLabel = createLabel("Parola");
        passField = createPasswordField();
        
        registerButton = createButton("Inregistreaza-te", this::registerButtonActionPerformed);
        resetButton = createButton("Reseteaza", this::resetButtonActionPerformed);
        backButton = createButton("", this::backButtonActionPerformed);
        backButton.setIcon(new ImageIcon(getClass().getResource(Constants.BACK_BUTTON)));
        backButton.setBackground(new Color(211, 227, 235));
        backButton.setBorder(null);
        backButton.setFocusPainted(false);

        FormLayoutUtils.setupRegisterPanelLayout(mainPanel, registerButton, resetButton, userLabel, passLabel, 
        		emailLabel, emailTextField, passField, userTextField, backButton, logo);
        FormLayoutUtils.setCommonLayout(mainPanel,getContentPane());
        
        pack();
        setLocationRelativeTo(null);
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
    
    private JLabel createLabel(String text) {
        JLabel label = new JLabel();
        label.setFont(new Font("Bitstream Vera Sans Mono", 1, 18));
        label.setText(text);
        return label;
    }
    
    private JTextField createTextField() {
        JTextField textField = new JTextField();
        return textField;
    }

    private JPasswordField createPasswordField() {
        JPasswordField passwordField = new JPasswordField();
        return passwordField;
    }
    
    private void registerButtonActionPerformed(ActionEvent evt) {
        String email = emailTextField.getText();
        String username = userTextField.getText();
        String password = passField.getText();

        // Validation checks
        if (!Validation.checkValidUser(username)) {
            showMessage(Constants.INVALID_USERNAME);
        } else if (Validation.checkUsernameExists(username)) {
            showMessage(Constants.USERNAME_TAKEN);
        } else if (!Validation.checkValidPassword(password)) {
            showMessage(Constants.INVALID_PASSWORD);
        } else if (!Validation.checkValidEmail(email)) {
            showMessage(Constants.INVALID_EMAIL);
        } else {
            registerUser(username, password, email);
        }
    }
    
    private void registerUser(String username, String password, String email) {
        try (Connection connection = DatabaseConnectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(Constants.CREATE_USER_QUERY)) {

            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, email);
            
            int result = statement.executeUpdate();
            showMessage(result == 0 ? Constants.USERNAME_TAKEN : Constants.ACCOUNT_CREATED);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void showMessage(String message) {
        JOptionPane.showMessageDialog(registerButton, message);
    }

    private void resetButtonActionPerformed(ActionEvent evt) {
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
}
