package com.patwolohan.FodlaFX.user;

/*
*	Author:	COR edited by PW
*	Date:	2018
*	
*/

public class UserConsoleController {

	private UserTextAreaListView view;
	private UserDAO model;

	public UserConsoleController(UserTextAreaListView view, UserDAO model) {
		this.view = view;
		this.model = model;
	}

	public void display() {

		view.setUserList(model.getAllUsers());
		view.display();
	}

}
