package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

	public static boolean checkUsernameExists(String username) {
		boolean usernameExists = false;

		try {
			Connection connection = DatabaseConnectionManager.getConnection();
			
			Statement statement = connection.createStatement();

			String getNumberOfUsers = "SELECT COUNT(*) FROM cont WHERE username='" + username + "'";

			ResultSet resultSet = statement.executeQuery(getNumberOfUsers);
			
			if (resultSet.next()) {
				int numberOfUsers = resultSet.getInt(1); // retrieve the value from the result set
				usernameExists = numberOfUsers > 0;
			}		

		} catch (SQLException e) {
			System.out.println("SQL Exception: " + e.toString());
		}

		return usernameExists;
	}

	public static boolean checkValidUser(String user) {
		String usernameFormat = "^[a-zA-Z0-9.\\-_$@*!]{6,20}$";
		return isValid(user, usernameFormat);
	}

	public static boolean checkValidEmail(String email) {
		String emailFormat = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\."
				+ "[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
		return isValid(email, emailFormat);
	}

	public static boolean checkValidPassword(String password) {
		String passwordFormat = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$"; // minim 1 cifra, minim 6 caractere, maxim
																			// 20 caractere
		return isValid(password, passwordFormat);
	}

	public static boolean isValid(String input, String regexPattern) {
		Pattern pattern = Pattern.compile(regexPattern);
		Matcher matcher = pattern.matcher(input);
		return matcher.matches();
	}

}
