package com.patwolohan.FodlaFX.user;

/*
*	Author:	COR edited by PW
*	Date:	2018
*	
*/

import java.util.Iterator;
import javafx.collections.ObservableList;
import javafx.scene.control.TextArea;

public class UserTextAreaListView {

	ObservableList<User> userList;
	TextArea aTextArea;

	public UserTextAreaListView(TextArea aTextArea) {
		this.aTextArea = aTextArea;
	}

	public void setUserList(ObservableList<User> userList) {
		this.userList = userList;
	}

	public void display() {

		aTextArea.appendText("... USER VIEWER ...");
		aTextArea.appendText("\n");
		Iterator<User> iterator = this.userList.iterator();
		while (iterator.hasNext()) {
			User aUser = (User) iterator.next();
			aTextArea.appendText(aUser.toString() + "\n");
		}
	}

}
