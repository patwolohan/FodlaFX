package com.patwolohan.FodlaFX;

/*
	*	Author:	COR edited by PW
	*	Date:	2018
	*	
	*/

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;

import java.io.File;
import java.io.IOException;

import com.patwolohan.FodlaFX.MenuController;
import com.patwolohan.FodlaFX.data.DataManagerSQLite;

public class App extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;
	private MenuController theMenuController;

	@Override
	public void init() {
		// preshow stage setup
		// database setup

		String dbURL = "jdbc:sqlite:database/fodlafx.db";
		String filename = dbURL.substring(dbURL.lastIndexOf(':') + 1);

		if (!new File(filename).isFile()) {
			System.out.println("ERROR:	Database	file	does	not	exist	:	" + dbURL);
			System.out.println("Expect file to be in the database directory and called fodlafx.db");
			System.exit(0);
		} else {
			DataManagerSQLite.getInstance().setDataFile(dbURL);
			System.out.println("Database file exists : " + dbURL);
		}
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Music and Life");

		// create BoarderPane layout on stage
		initRootLayout();

		// give the controller the object reference to the root layout so it can place
		// scenes there
		// 1.
		this.theMenuController = new MenuController(this);

		// Place the screens into the BorderPane on the main stage
		// 2.
		showMenu();
		showMessagePanel();
		showWelcome();

		// now control is handed over to the menu and events on the screen
	}

	// now control is handed over to the menu and events on the screen

	/**
	 * Initializes the root layout.
	 */
	public void initRootLayout() {
		try {
			this.rootLayout = new BorderPane();
			Scene scene = new Scene(this.rootLayout, 600, 400);
			this.primaryStage.setScene(scene);
			this.primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * THIS IS THE QUESTIONABLE CODE. Should it be in the app.java?? Show the FXML
	 * generated menu inside the root layout.
	 */
	public void showMenu() {
		try {
			// Load root layout from fxml file.
			// 1.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(App.class.getResource("MenuPanel.fxml"));

			// Give it the controller to use
			// 2.
			loader.setController(this.theMenuController);

			// FXML outer node is an AnchorPane so
			// 3.
			AnchorPane fxmlView = loader.<AnchorPane>load();

			// put it into the root layout
			// 4.
			this.rootLayout.setTop(fxmlView);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showWelcome() {
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(App.class.getResource("WelcomePanel.fxml"));

			// FXML outer node is a VBox so
			AnchorPane fxmlView = loader.<AnchorPane>load();

			// put it into the root layout
			this.rootLayout.setCenter(fxmlView);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showMessagePanel() {
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(App.class.getResource("MessagePanel.fxml"));

			// Give it the controller to use
			loader.setController(this.theMenuController);

			// FXML outer node is a VBox so
			AnchorPane fxmlView = loader.<AnchorPane>load();

			// put it into the root layout
			this.rootLayout.setBottom(fxmlView);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* end of questionable code */
	public BorderPane getRootLayout() {
		return this.rootLayout;
	}

	public Stage getPrimaryStage() {
		return this.primaryStage;
	}

	public static void main(String[] args) {

		// launch is a method in the class Application that we are extending
		Application.launch(args);

		// next init() is executed as defined in the superclass Application
		// then start()
		// finally stop()
	}
}