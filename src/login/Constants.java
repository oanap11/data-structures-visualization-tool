package login;

public class Constants {
	
	// SQL Queries
    public static final String CHECK_USERNAME_EXISTS_QUERY = "SELECT COUNT(*) FROM users WHERE username = ?";

    // Format Patterns
    public static final String USERNAME_FORMAT = "^[a-zA-Z0-9.\\-_$@*!]{6,20}$";
    public static final String EMAIL_FORMAT = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
    public static final String PASSWORD_FORMAT = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,20}$";
}
