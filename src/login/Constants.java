package login;

public class Constants {
	// Image paths
	static final String LOGIN_LOGO = "/images/loginLogo.png";
	static final String REGISTER_LOGO = "/images/logoInregistrare.png";
	static final String BACK_BUTTON = "/images/backButton.png";
	
	// Error messages
	static final String USERNAME_TAKEN = "Numele de utilizator este deja utilizat.";
	static final String ACCOUNT_CREATED = "Contul dumneavoastra a fost creat.";
	static final String INVALID_USERNAME = "Introduceti un nume de utilizator cu minim 6 caractere fara spatii.";
	static final String INVALID_PASSWORD = "Introduceti o parola de minim 6 caractere care contine o cifra.";
	static final String INVALID_EMAIL = "Introduceti o adresa de e-mail valida.";
	static final String USER_NOT_FOUND = "Utilizatorul nu a fost gasit.";
	
	// SQL queries
    static final String CHECK_USERNAME_EXISTS_QUERY = "SELECT COUNT(*) FROM users WHERE username = ?";
    static final String LOGIN_QUERY = "SELECT username, password FROM users WHERE username=? AND password=?";
    static final String CREATE_USER_QUERY = "INSERT INTO users (username, password, email) VALUES (?, ?, ?)";

    // Format patterns
    static final String USERNAME_FORMAT = "^[a-zA-Z0-9.\\-_$@*!]{6,20}$";
    static final String EMAIL_FORMAT = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
    static final String PASSWORD_FORMAT = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,20}$";
}
