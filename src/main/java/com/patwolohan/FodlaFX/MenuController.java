package com.patwolohan.FodlaFX;

/*
*	Author:	COR edited by PW
*	Date:	2018
*	
*/

import java.io.IOException;

import com.patwolohan.FodlaFX.data.DataManagerSQLite;
import com.patwolohan.FodlaFX.music.MusicDAO;
import com.patwolohan.FodlaFX.music.MusicFXBrowserController;
import com.patwolohan.FodlaFX.playlist.PlaylistDAO;
import com.patwolohan.FodlaFX.playlist.PlaylistFXBrowserController;
import com.patwolohan.FodlaFX.user.UserConsoleController;
import com.patwolohan.FodlaFX.user.UserDAO;
import com.patwolohan.FodlaFX.user.UserTextAreaListView;
import com.patwolohan.FodlaFX.MenuController;
import com.patwolohan.FodlaFX.user.UserFXBrowserController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class MenuController {

	// components on the scene these are the fx:id names from Scene Builder

	@FXML
	private MenuItem listPlayListMenuItem;
	@FXML
	private MenuItem listMusicMenuItem;
	@FXML
	private MenuItem listUsersMenuItem;
	@FXML
	private MenuItem checkUsersMenuItem;

	@FXML
	private TextArea aTextArea;

	// the root layout
	private BorderPane rootLayout;
	private App theApp;

	/*
	 * Constructor
	 */
	public MenuController(App theApp) {
		this.theApp = theApp;
		this.rootLayout = theApp.getRootLayout();
	}

	/*
	 * MENU method calls - On Action, defined in Scene Builder
	 */

	@FXML
	void showMusic() {
		// aTextArea.setText("showMusic() called");

		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MenuController.class.getResource("music/MusicBrowserView.fxml"));

			// FXML outer node is a VBox so
			AnchorPane fxmlView = loader.<AnchorPane>load();

			// put it into the root layout
			this.rootLayout.setCenter(fxmlView);

			// Instantiate the model so we can pull from the database
			MusicDAO model = new MusicDAO(DataManagerSQLite.getInstance());

			// Give the controller access to the model.
			MusicFXBrowserController controller = loader.getController();
			controller.setModel(model);
			controller.setApp(theApp);
			controller.setMessagebox(aTextArea);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@FXML
	void showPlayList() {
		// aTextArea.setText("showPlayList() called");

		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MenuController.class.getResource("playlist/PlaylistBrowserView.fxml"));

			// FXML outer node is a VBox so
			AnchorPane fxmlView = loader.<AnchorPane>load();

			// put it into the root layout
			this.rootLayout.setCenter(fxmlView);

			// Instantiate the model so we can pull from the database
			PlaylistDAO model = new PlaylistDAO(DataManagerSQLite.getInstance());

			// Give the controller access to the model.
			PlaylistFXBrowserController controller = loader.getController();
			controller.setModel(model);
			controller.setApp(theApp);
			controller.setMessagebox(aTextArea);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@FXML
	void showUsers() {

		// In this MVC the view is instantiated first by the FXMLLoader
		// It knows its controller as it in set in the .fxml within Scene Builder
		// Then we user the loader to give us the reference to the controller and we
		// setModel()
		// this then pulls data into the view

		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MenuController.class.getResource("user/UserBrowserView.fxml"));

			// FXML outer node is a VBox so
			AnchorPane fxmlView = loader.<AnchorPane>load();

			// put it into the root layout
			this.rootLayout.setCenter(fxmlView);

			// Instantiate the model so we can pull from the database
			UserDAO model = new UserDAO(DataManagerSQLite.getInstance());

			// Give the controller access to the model.
			UserFXBrowserController controller = loader.getController();
			controller.setModel(model);
			controller.setApp(theApp);
			controller.setMessagebox(aTextArea);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// CHECK DB - method calls

	@FXML
	void checkDBMusic() {
		aTextArea.setText("checkDBMusic() called");
	}

	@FXML
	void checkDBPlayList() {
		aTextArea.setText("checkDBPlayList() called");
	}

	@FXML
	void close() {
		System.exit(0);
	}

	@FXML
	void checkDBUsers() {

		// aTextArea.setText("checkDBUsers() called");

		UserDAO model = new UserDAO(DataManagerSQLite.getInstance());
		UserTextAreaListView view = new UserTextAreaListView(aTextArea);
		UserConsoleController controller = new UserConsoleController(view, model);
		controller.display();
	}
}
