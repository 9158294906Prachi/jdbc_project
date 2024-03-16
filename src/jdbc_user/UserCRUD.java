package jdbc_user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserCRUD {
	public void signUp(User user) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("Insert into user(id,name,phone,emailid,password) values(?,?,?,?,?)");
		preparedStatement.setInt(1, user.getId());
		preparedStatement.setString(2, user.getName());
		preparedStatement.setLong(3, user.getNumber());
		preparedStatement.setString(4, user.getEmailId());
		preparedStatement.setString(5, user.getPassword());
		try {
			int result = preparedStatement.executeUpdate();
			if (result != 0) {
				System.out.println("Successfully signup");
			} else {
				System.out.println("Not signup");
			}
		} catch (Exception e) {
			System.out.println("User with the given id already exist.");
		}
		connection.close();
	}

	public int logIn(String emailId, String password) throws Exception {
		String query = "select password from user where emailid=?";
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, emailId);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			if (resultSet.getString("password").equals(password)) {
				return 1;
			} else {
				return -1;
			}
		}
		connection.close();
		return 0;

	}

	public void showPassword(String emailId) throws Exception {
		String query = "select facebookPassword,instagramPassword,XPassword from user where emailid=?";
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, emailId);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			System.out.println("Facebook Password:" + resultSet.getString("facebookPassword"));
			System.out.println("Instagram Password:" + resultSet.getString("instagramPassword"));
			System.out.println("X Password:" + resultSet.getString("XPassword"));
		}

	}

	public int forgotPassword(String emailId, String newPassword) throws Exception {
		String query = "select emailid from user where emailid=?";
		String updateQuery = "update user set password=? where emailid=?";
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, emailId);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			if (resultSet.getString("emailid").equals(emailId)) {
				preparedStatement = connection.prepareStatement(updateQuery);
				preparedStatement.setString(1, newPassword);
				preparedStatement.setString(2, emailId);
				int result = preparedStatement.executeUpdate();
				if (result != 0) {
					System.out.println("Successfully updated");
					return 1;
				} else {
					System.out.println("Try again!");
				}
			} else {
				System.out.println("Enter correct details!");
			}
		}
		connection.close();
		return 0;

	}

	public void updatePassword(int i, String emailId, String password) throws Exception {
		String query = "select emailid from user where emailid=?";
		String updateQuery="";
		if (i == 1) {
			updateQuery = "update user set facebookPassword=? where emailid=?";
		} else if (i == 2) {
			updateQuery = "update user set instagramPassword=? where emailid=?";
		} else if (i == 3) {
			updateQuery = "update user set XPassword=? where emailid=?";
		}
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, emailId);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			if (resultSet.getString("emailid").equals(emailId)) {
				preparedStatement = connection.prepareStatement(updateQuery);
				preparedStatement.setString(1, password);
				preparedStatement.setString(2, emailId);
				int result = preparedStatement.executeUpdate();
				if (result != 0) {
					System.out.println("Successfully updated");
				} else {
					System.out.println("Try again!");
				}
			} else {
				System.out.println("Enter correct details!");
			}
		}
		connection.close();
	}

	public Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb", "root", "root");
		return connection;
	}

}
