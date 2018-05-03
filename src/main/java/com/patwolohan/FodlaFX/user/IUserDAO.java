package com.patwolohan.FodlaFX.user;

/*
*	Author:	COR edited by PW
*	Date:	2018
*	
*/

import javafx.collections.ObservableList;

public interface IUserDAO {

	public ObservableList<User> getAllUsers();

	public User getUser(int userID);

	public long addUser(User aUser);

	public void updateUser(User aUser);

	public void deleteUser(User aUser);

	public String printUser(int userID);

}
