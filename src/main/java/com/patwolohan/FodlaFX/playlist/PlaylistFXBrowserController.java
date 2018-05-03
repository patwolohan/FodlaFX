package com.patwolohan.FodlaFX.playlist;

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

public class PlaylistFXBrowserController {

	// Scene Builder fx:id associated with controls on the fxml definition

	// The UI components

	@FXML
	private TableView<Playlist> playlistTable;
	@FXML
	private TableColumn<Playlist, Number> idColumn;
	@FXML
	private TableColumn<Playlist, String> titleColumn;
	@FXML
	private TableColumn<Playlist, String> descriptionColumn;
	@FXML
	private TableColumn<Playlist, String> themeColumn;

	@FXML
	private Label IDLabel;
	@FXML
	private Label titleLabel;
	@FXML
	private Label descriptionLabel;
	@FXML
	private Label themeLabel;

	// The App
	private App theApp;

	// Data
	private PlaylistDAO model;

	// Message box
	TextArea aTextArea;

	// Playlist
	Playlist currentlySelectedPlaylist;

	// in the PlaylistDataView.fxml we have set the controller to use so this
	// controller is instantiated when we load the .fxml version of the screen
	// once this constructor is called next initialize is called

	/**
	 * Constructor
	 */
	public PlaylistFXBrowserController() {
	}

	/**
	 * Called after constructor by .fxml loader.
	 */
	@FXML
	private void initialize() {

		// TABLE
		// Initialize the playlist table with the two columns.
		idColumn.setCellValueFactory(cellData -> cellData.getValue().playlistIDProperty());
		titleColumn.setCellValueFactory(cellData -> cellData.getValue().playlistTitleProperty());
		descriptionColumn.setCellValueFactory(cellData -> cellData.getValue().playlistDescriptionProperty());
		themeColumn.setCellValueFactory(cellData -> cellData.getValue().playlistThemeProperty());

		// RECORD
		showPlaylistDetails(null);

		// EVENTS

		// listen for clicks on table rows - using lambda function
		playlistTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showPlaylistDetails(newValue));
	}

	/**
	 * Set Model
	 * 
	 * called from the MenuController to associate the model with this controller
	 */
	public void setModel(PlaylistDAO model) {

		this.model = model;
		// Add observable list data to the table
		playlistTable.setItems(model.getAllPlaylist());
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
	 * display playlist details.
	 */
	public void showPlaylistDetails(Playlist playlist) {
		if (playlist != null) {
			IDLabel.setText(Integer.toString(playlist.getPlaylistID()));
			titleLabel.setText(playlist.getPlaylistTitle());
			descriptionLabel.setText(playlist.getPlaylistDescription());
			themeLabel.setText(playlist.getPlaylistTheme());

			// so we know the playlist in focus for a delete or edit
			this.currentlySelectedPlaylist = playlist;
		} else {
			IDLabel.setText("-");
			titleLabel.setText("-");
			descriptionLabel.setText("-");
			themeLabel.setText("-");

		}
	}

	/**
	 * edit button.
	 */
	@FXML
	private void handleEditPlaylist() {

		Playlist selectedPlaylist = playlistTable.getSelectionModel().getSelectedItem();

		// Check a selection has been made
		if (selectedPlaylist != null) {
			// here would display edit playlist panel and do database update
			this.aTextArea.setText("Edit playlist button pressed");
		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(theApp.getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No playlist Selected");
			alert.setContentText("Please select playlist in the table.");

			alert.showAndWait();
		}

	}

	/**
	 * new button.
	 */
	@FXML
	private void handleNewPlaylist() {

		// here would display new Playlist panel and do database insert
		this.aTextArea.setText("New Playlist button pressed");

	}

	/**
	 * delete button.
	 */
	@FXML
	private void handleDeletePlaylist() {

		int selectedIndex = playlistTable.getSelectionModel().getSelectedIndex();

		// if nothing left in list
		if (selectedIndex >= 0) {
			// does not delete in database only removes from the list
			playlistTable.getItems().remove(selectedIndex);
		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(theApp.getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Playlist Selected");
			alert.setContentText("Please select Playlist in the table.");

			alert.showAndWait();
		}
	}

}
