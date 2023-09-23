package login;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Pattern;


public class Validation {

	public static boolean checkUsernameExists(String username){
	    boolean usernameExists = false;

	    try{
	        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/aplicatieLicenta", "root", "password");
	        Statement statement = connection.createStatement();

	        String SQL = "SELECT * FROM cont WHERE username='" + username + "'";

	        ResultSet rs = statement.executeQuery(SQL);

	         if(rs.next()) {
	              usernameExists = true;
	         }


	     }
	     catch (SQLException e) {
	        System.out.println("SQL Exception: "+ e.toString());
	     }

	    return usernameExists;
	 }

	public static boolean checkValidUser(String user){
        String emailFormate ="^[a-zA-Z0-9.\\-_$@*!]{6,20}$";

        Pattern p = Pattern.compile(emailFormate);
        if(user == null){
        	return false;
        }
        return p.matcher(user).matches();
    }

    public static boolean checkValidEmail(String email){
        String emailFormate ="^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\."
                + "[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";

        Pattern p = Pattern.compile(emailFormate);
        if(email == null){
        	return false;
        }
        return p.matcher(email).matches();
    }

    public static boolean checkValidPassword(String password){
        String passwordFormat = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$";
        //cel putin o cifra
        //minim 6 caractere, maxim 20
        Pattern p = Pattern.compile(passwordFormat);
        if(password == null){
        	return false;
        }
        return p.matcher(password).matches();
    }

}


