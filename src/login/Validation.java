package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;

public class Validation {

	static boolean checkUsernameExists(String username) {
		try (Connection connection = DatabaseConnectionManager.getConnection();
			PreparedStatement statement = connection.prepareStatement(Constants.CHECK_USERNAME_EXISTS_QUERY)) {

			statement.setString(1, username);
			try (ResultSet resultSet = statement.executeQuery()) {
				return resultSet.next() && resultSet.getInt(1) > 0;
			}
		} catch (SQLException e) {
			System.err.println("SQL Exception: " + e.getMessage());
			return false;
		}
	}

	static boolean checkValidUser(String user) {
        return isValid(user, Constants.USERNAME_FORMAT);
    }

	static boolean checkValidEmail(String email) {
        return isValid(email, Constants.EMAIL_FORMAT);
    }

	static boolean checkValidPassword(String password) {
        return isValid(password, Constants.PASSWORD_FORMAT);
    }

    private static boolean isValid(String input, String regexPattern) {
        return Pattern.matches(regexPattern, input);
    }
}
