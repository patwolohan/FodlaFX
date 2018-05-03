package com.patwolohan.FodlaFX.user;

/*****************************************************************
*	Date: 2018
*	@author COR Edited by PW
*  
* User class
* 
*****************************************************************/

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import java.time.LocalDate;

public class User {

	// DATA
	// ............................................................
	// declare objects

	private IntegerProperty userID;
	private StringProperty userName;
	private StringProperty userEmail;
	private StringProperty userRole;
	private StringProperty userToken;
	private IntegerProperty userStatus;
	private ObjectProperty<LocalDate> userLastUpdate;

	// CONSTRUCTORS
	// ............................................................

	public User() {
		this(0, null, null);
	}

	public User(int userID, String userName, String userEmail) {
		// dummy data added
		this(userID, userName, userEmail, "No Role Defined", "No Token Defined", 0, LocalDate.of(1999, 9, 9));

	}

	public User(int userID, String userName, String userEmail, String userRole, String userToken, int userStatus,
			LocalDate userLastUpdate) {
		this.userID = new SimpleIntegerProperty(userID);
		this.userName = new SimpleStringProperty(userName);
		this.userEmail = new SimpleStringProperty(userEmail);
		this.userRole = new SimpleStringProperty(userRole);
		this.userToken = new SimpleStringProperty(userToken);
		this.userStatus = new SimpleIntegerProperty(userStatus);
		this.userLastUpdate = new SimpleObjectProperty<LocalDate>(userLastUpdate);
	}

	// METHODS - Gets and Sets
	// ............................................................

	public int getUserID() {
		return userID.get();
	}

	public void setUserID(int userID) {
		this.userID.set(userID);
	}

	public IntegerProperty userIDProperty() {
		return userID;
	}

	// --

	public String getUserName() {
		return userName.get();
	}

	public void setUserName(String userName) {
		this.userName.set(userName);
	}

	public StringProperty userNameProperty() {
		return userName;
	}

	// --

	public String getUserEmail() {
		return userEmail.get();
	}

	public void setUserEmail(String userEmail) {
		this.userEmail.set(userEmail);
	}

	public StringProperty userEmailProperty() {
		return userEmail;
	}

	// --

	public String getUserRole() {
		return userRole.get();
	}

	public void setUserRole(String userRole) {
		this.userRole.set(userRole);
	}

	public StringProperty userRoleProperty() {
		return userRole;
	}

	// --

	public String getUserToken() {
		return userToken.get();
	}

	public void setUserToken(String userToken) {
		this.userToken.set(userToken);
	}

	public StringProperty userTokenProperty() {
		return userToken;
	}

	// --

	public int getUserStatus() {
		return userStatus.get();
	}

	public void setUserStatus(int userStatus) {
		this.userStatus.set(userStatus);
	}

	public IntegerProperty userStatusProperty() {
		return userStatus;
	}

	// --

	public LocalDate getUserLastUpdate() {
		return userLastUpdate.get();
	}

	public void setUserLastUpdate(LocalDate userLastUpdate) {
		this.userLastUpdate.set(userLastUpdate);
	}

	public ObjectProperty<LocalDate> userLastUpdateProperty() {
		return userLastUpdate;
	}

	// METHODS
	// ............................................................

	@Override
	public String toString() {
		return String.format(
				"User [userID=%s, userName=%s, userEmail=%s, userRole=%s, userToken=%s, userStatus=%s, userLastUpdate=%s]",
				userID.get(), userName.get(), userEmail.get(), userRole.get(), userToken.get(), userStatus.get(),
				userLastUpdate.get());
	}

}// EOC
