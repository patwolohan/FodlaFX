package com.patwolohan.FodlaFX.user;

/*
 * Author COR edited by PW 
 * 2018
 * Ref: https://www.swtestacademy.com/database-operations-javafx/
 * 
 */

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.patwolohan.FodlaFX.data.IDataManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UserDAO implements IUserDAO {

	// DATA
	// ............................................................

	private IDataManager dataManager;

	// CONSTRUCTORS
	// ............................................................

	public UserDAO(IDataManager dataManager) {

		this.dataManager = dataManager;
	}

	// METHODS
	// ............................................................

	/**
	 * GET ALL
	 */
	public ObservableList<User> getAllUsers() {

		ObservableList<User> userList = FXCollections.observableArrayList();

		// Get JDBC connection to database
		Connection connection = null;

		try {
			// get a database connection
			connection = this.dataManager.getConnectionObject();

			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30); // set timeout to 30 sec.

			// Run the query

			ResultSet resultSet = statement.executeQuery("select * from user");

			// iterate through the results create User objects put in the ObservableArray

			while (resultSet.next()) {
				// TODO: issue with localDate parsing, DateFormetter not working as per
				// documentation - workaround
				// System.out.println(resultSet.getString("userLastUpdate"));
				Timestamp t = Timestamp.valueOf(resultSet.getString("userLastUpdate"));
				LocalDateTime ldt = t.toLocalDateTime();
				LocalDate dateEntered = ldt.toLocalDate();

				User user = new User(resultSet.getInt("userID"), resultSet.getString("userName"),
						resultSet.getString("userEmail"), resultSet.getString("userRole"),
						resultSet.getString("userToken"), resultSet.getInt("userStatus"), dateEntered);

				// putting the user objects into the list but not using them yet
				userList.add(user);

			}

		} catch (SQLException e) {
			// if the error message is "out of memory",
			// it probably means no database file is found
			System.out.println(e.getMessage());
		} finally {
			try {
				if (connection != null)
					this.dataManager.disconnect();
			} catch (SQLException e) {
				// connection close failed.
				System.out.println(e.getMessage());
			}
		}

		return userList;

	}// EOM

	/**
	 * GET ONE
	 */
	public User getUser(int userID) {
		throw new UnsupportedOperationException();
	}

	/**
	 * CREATE
	 */
	public long addUser(User aUser) {

		throw new UnsupportedOperationException();
	}

	/**
	 * UPDATE
	 */
	public void updateUser(User aUser) {

		throw new UnsupportedOperationException();
	}

	/**
	 * DELETE
	 */
	public void deleteUser(User aUser) {
		throw new UnsupportedOperationException();
	}

	public String printUser(int userID) {
		throw new UnsupportedOperationException();
	}

}
