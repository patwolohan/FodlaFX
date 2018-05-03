package com.patwolohan.FodlaFX.playlist;

/*****************************************************************
*	Date: 2018
*	@author PW
*  
* Playlist class
* 
*****************************************************************/

import javafx.beans.property.IntegerProperty;
//import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
//import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
//import java.time.LocalDate;

public class Playlist {

	// DATA
	// ............................................................
	// declare objects

	private IntegerProperty playlistID;
	private StringProperty playlistTitle;
	private StringProperty playlistDescription;
	private StringProperty playlistTheme;

	// CONSTRUCTORS
	// ............................................................
	public Playlist() {
		this(0, null, null, null);
	}

	public Playlist(int playlistID, String playlistTitle, String playlistDescription, String playlistTheme) {

		this.playlistID = new SimpleIntegerProperty(playlistID);
		this.playlistTitle = new SimpleStringProperty(playlistTitle);
		this.playlistDescription = new SimpleStringProperty(playlistDescription);
		this.playlistTheme = new SimpleStringProperty(playlistTheme);

	}
	// METHODS
	// ............................................................

	public int getPlaylistID() {
		return playlistID.get();
	}

	public void setPlaylistID(IntegerProperty playlistID) {
		this.playlistID = playlistID;
	}

	public IntegerProperty playlistIDProperty() {
		return playlistID;
	}

	public String getPlaylistTitle() {
		return playlistTitle.get();
	}

	public void setPlaylistTitle(String playlistTitle) {
		this.playlistTitle.set(playlistTitle);
	}

	public StringProperty playlistTitleProperty() {
		return playlistTitle;
	}

	public String getPlaylistDescription() {
		return playlistDescription.get();
	}

	public void setPlaylistDescription(String playlistDescription) {
		this.playlistDescription.set(playlistDescription);
	}

	public StringProperty playlistDescriptionProperty() {
		return playlistDescription;
	}

	public String getPlaylistTheme() {
		return playlistTheme.get();
	}

	public void setPlaylistTheme(String playlistTheme) {
		this.playlistTheme.set(playlistTheme);
	}

	public StringProperty playlistThemeProperty() {
		return playlistTheme;
	}

	@Override
	public String toString() {
		return String.format("Playlist [playlistID=%s, playlistTitle=%s, playlistDescription=%s, playlistTheme=%s]",
				playlistID.get(), playlistTitle.get(), playlistDescription.get(), playlistTheme.get());
	}

}// EOC
