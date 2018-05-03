package com.patwolohan.FodlaFX.music;

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

public class MusicFXBrowserController {

	// Scene Builder fx:id associated with controls on the fxml definition

	// The UI components

	@FXML
	private TableView<Music> musicTable;
	@FXML
	private TableColumn<Music, Number> idColumn;
	@FXML
	private TableColumn<Music, String> titleColumn;
	@FXML
	private TableColumn<Music, String> artistColumn;
	@FXML
	private TableColumn<Music, String> descriptionColumn;
	@FXML
	private TableColumn<Music, String> genreColumn;
	@FXML
	private TableColumn<Music, String> urlColumn;
	@FXML
	private TableColumn<Music, String> yearColumn;

	@FXML
	private Label IDLabel;
	@FXML
	private Label titleLabel;
	@FXML
	private Label artistLabel;
	@FXML
	private Label descriptionLabel;
	@FXML
	private Label genreLabel;
	@FXML
	private Label urlLabel;
	@FXML
	private Label yearLabel;

	// The App
	private App theApp;

	// Data
	private MusicDAO model;

	// Message box
	TextArea aTextArea;

	// Music
	Music currentlySelectedMusic;

	// in the MusicDataView.fxml we have set the controller to use so this
	// controller is instantiated when we load the .fxml version of the screen
	// once this constructor is called next initialize is called

	/**
	 * Constructor
	 */
	public MusicFXBrowserController() {
	}

	/**
	 * Called after constructor by .fxml loader.
	 */
	@FXML
	private void initialize() {

		// TABLE
		// Initialize the music table with the two columns.
		idColumn.setCellValueFactory(cellData -> cellData.getValue().musicIDProperty());
		titleColumn.setCellValueFactory(cellData -> cellData.getValue().musicTitleProperty());
		artistColumn.setCellValueFactory(cellData -> cellData.getValue().musicArtistProperty());
		descriptionColumn.setCellValueFactory(cellData -> cellData.getValue().musicDescriptionProperty());
		genreColumn.setCellValueFactory(cellData -> cellData.getValue().musicGenreProperty());
		urlColumn.setCellValueFactory(cellData -> cellData.getValue().musicUrlProperty());
		yearColumn.setCellValueFactory(cellData -> cellData.getValue().musicYearProperty());

		// RECORD
		showMusicDetails(null);

		// EVENTS

		// listen for clicks on table rows - using lambda function
		musicTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showMusicDetails(newValue));
	}

	/**
	 * Set Model
	 * 
	 * called from the MenuController to associate the model with this controller
	 */
	public void setModel(MusicDAO model) {

		this.model = model;
		// Add observable list data to the table
		musicTable.setItems(model.getAllMusic());
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
	 * display music details.
	 */
	public void showMusicDetails(Music music) {
		if (music != null) {
			IDLabel.setText(Integer.toString(music.getMusicID()));
			titleLabel.setText(music.getMusicTitle());
			artistLabel.setText(music.getMusicArtist());
			descriptionLabel.setText(music.getMusicDescription());
			genreLabel.setText(music.getMusicGenre());
			urlLabel.setText(music.getMusicUrl());
			yearLabel.setText(music.getMusicYear());

			// so we know the music in focus for a delete or edit
			this.currentlySelectedMusic = music;
		} else {
			IDLabel.setText("-");
			titleLabel.setText("-");
			artistLabel.setText("-");
			descriptionLabel.setText("-");
			genreLabel.setText("-");
			urlLabel.setText("-");
			yearLabel.setText("-");
		}
	}

	/**
	 * edit button.
	 */
	@FXML
	private void handleEditMusic() {

		Music selectedMusic = musicTable.getSelectionModel().getSelectedItem();

		// Check a selection has been made
		if (selectedMusic != null) {
			// here would display edit music panel and do database update
			this.aTextArea.setText("Edit music button pressed");
		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(theApp.getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No music Selected");
			alert.setContentText("Please select music in the table.");

			alert.showAndWait();
		}

	}

	/**
	 * new button.
	 */
	@FXML
	private void handleNewMusic() {

		// here would display new Music panel and do database insert
		this.aTextArea.setText("New Music button pressed");

	}

	/**
	 * delete button.
	 */
	@FXML
	private void handleDeleteMusic() {

		int selectedIndex = musicTable.getSelectionModel().getSelectedIndex();

		// if nothing left in list
		if (selectedIndex >= 0) {
			// does not delete in database only removes from the list
			musicTable.getItems().remove(selectedIndex);
		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(theApp.getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Music Selected");
			alert.setContentText("Please select Music in the table.");

			alert.showAndWait();
		}
	}

}
