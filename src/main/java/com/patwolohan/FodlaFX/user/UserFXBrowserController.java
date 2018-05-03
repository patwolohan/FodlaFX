package com.patwolohan.FodlaFX.user;

/*
*	Author:	COR edited by PW
*	Date:	2018
*	
*/

import java.io.IOException;

import com.patwolohan.FodlaFX.App;
import com.patwolohan.FodlaFX.MenuController;
import com.patwolohan.FodlaFX.data.DataManagerSQLite;

import com.patwolohan.FodlaFX.utils.DateUtil;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

public class UserFXBrowserController {

	// Scene Builder fx:id associated with controls on the fxml definition

	// The UI components

	@FXML
	private TableView<User> userTable;
	@FXML
	private TableColumn<User, Number> idColumn;
	@FXML
	private TableColumn<User, String> nameColumn;
	@FXML
	private TableColumn<User, String> emailColumn;

	@FXML
	private Label IDLabel;
	@FXML
	private Label nameLabel;
	@FXML
	private Label emailLabel;
	@FXML
	private Label roleLabel;
	@FXML
	private Label tokenLabel;
	@FXML
	private Label statusLabel;
	@FXML
	private Label updateLabel;

	// The App
	private App theApp;

	// Data
	private UserDAO model;

	// Message box
	TextArea aTextArea;

	// User
	User currentlySelectedUser;

	// in the UserDataView.fxml we have set the controller to use so this
	// controller is instantiated when we load the .fxml version of the screen
	// once this constructor is called next initialize is called

	/**
	 * Constructor
	 */
	public UserFXBrowserController() {
	}

	/**
	 * Called after constructor by .fxml loader.
	 */
	@FXML
	private void initialize() {

		// TABLE
		// Initialize the person table with the two columns.
		idColumn.setCellValueFactory(cellData -> cellData.getValue().userIDProperty());
		nameColumn.setCellValueFactory(cellData -> cellData.getValue().userNameProperty());
		emailColumn.setCellValueFactory(cellData -> cellData.getValue().userEmailProperty());

		// RECORD
		showUserDetails(null);

		// EVENTS

		// listen for clicks on table rows - using lambda function
		userTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showUserDetails(newValue));
	}

	/**
	 * Set Model
	 * 
	 * called from the MenuController to associate the model with this controller
	 */
	public void setModel(UserDAO model) {

		this.model = model;
		// Add observable list data to the table
		userTable.setItems(model.getAllUsers());
	}

	/**
	 * set parent application so can get the primary stage.
	 */
	public void setApp(App theApp) {
		this.theApp = theApp;
	}

	/**
	 * set messagebox.
	 */
	public void setMessagebox(TextArea aTextArea) {
		this.aTextArea = aTextArea;
	}

	/**
	 * display user details.
	 */
	public void showUserDetails(User user) {
		if (user != null) {
			IDLabel.setText(Integer.toString(user.getUserID()));
			nameLabel.setText(user.getUserName());
			emailLabel.setText(user.getUserEmail());
			roleLabel.setText(user.getUserRole());
			tokenLabel.setText(user.getUserToken());
			statusLabel.setText(Integer.toString(user.getUserStatus()));

			// Using our especially built DateUtil class i utils package
			updateLabel.setText(DateUtil.format(user.getUserLastUpdate()));

			// so we know the user in focus for a delete or edit
			this.currentlySelectedUser = user;
		} else {
			IDLabel.setText("-");
			nameLabel.setText("-");
			emailLabel.setText("-");
			roleLabel.setText("-");
			tokenLabel.setText("-");
			statusLabel.setText("-");
			updateLabel.setText("-");
		}
	}

	/**
	 * edit button.
	 */
	@FXML
	private void handleEditUser() {

		User selectedUser = userTable.getSelectionModel().getSelectedItem();

		// Check a selection has been made
		if (selectedUser != null) {
			// here would displau edit user panel and do database update
			this.aTextArea.setText("Edit user button pressed");
		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(theApp.getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No User Selected");
			alert.setContentText("Please select a User in the table.");

			alert.showAndWait();
		}

	}

	/**
	 * new button.
	 */
	@FXML
	private void handleNewUser() {

		// here would display new user panel and do database insert
		this.aTextArea.setText("New User button pressed");

	}

	/**
	 * delete button.
	 */
	@FXML
	private void handleDeleteUser() {

		int selectedIndex = userTable.getSelectionModel().getSelectedIndex();

		// if nothing left in list
		if (selectedIndex >= 0) {
			// does not delete in database only removes from the list
			userTable.getItems().remove(selectedIndex);
		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(theApp.getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No User Selected");
			alert.setContentText("Please select a User in the table.");

			alert.showAndWait();
		}
	}

}
