package com.patwolohan.FodlaFX.music;

/*****************************************************************
*	Date: 2018
*	@author COR Edited by PW
*  
* Music class
* 
*****************************************************************/

import javafx.beans.property.IntegerProperty;
//import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
//import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
//import java.time.LocalDate;

public class Music {

	// DATA
	// ............................................................
	// declare objects

	private IntegerProperty musicID;
	private StringProperty musicTitle;
	private StringProperty musicArtist;
	private StringProperty musicDescription;
	private StringProperty musicGenre;
	private StringProperty musicUrl;
	private StringProperty musicYear;

	// CONSTRUCTORS
	// ............................................................
	public Music() {
		this(0, null, null, null, null, null, null);
	}

	/*
	 * public Music(int musicID, String musicTitle, String musicArtist, String
	 * musicDescription, String musicGenre, String musicUrl, LocalDate musicYear) {
	 * this(musicID, musicTitle, music) }
	 */

	public Music(int musicID, String musicTitle, String musicArtist, String musicDescription, String musicGenre,
			String musicUrl, String musicYear) {

		this.musicID = new SimpleIntegerProperty(musicID);
		this.musicTitle = new SimpleStringProperty(musicTitle);
		this.musicArtist = new SimpleStringProperty(musicArtist);
		this.musicDescription = new SimpleStringProperty(musicDescription);
		this.musicGenre = new SimpleStringProperty(musicGenre);
		this.musicUrl = new SimpleStringProperty(musicUrl);
		this.musicYear = new SimpleStringProperty(musicYear);
	}
	// METHODS
	// ............................................................

	public int getMusicID() {
		return musicID.get();
	}

	public void setMusicID(IntegerProperty musicID) {
		this.musicID = musicID;
	}

	public IntegerProperty musicIDProperty() {
		return musicID;
	}

	public String getMusicTitle() {
		return musicTitle.get();
	}

	public void setMusicTitle(String musicTitle) {
		this.musicTitle.set(musicTitle);
	}

	public StringProperty musicTitleProperty() {
		return musicTitle;
	}

	public String getMusicArtist() {
		return musicArtist.get();
	}

	public void setMusicArtist(String musicArtist) {
		this.musicArtist.set(musicArtist);
	}

	public StringProperty musicArtistProperty() {
		return musicArtist;
	}

	public String getMusicDescription() {
		return musicDescription.get();
	}

	public void setMusicDescription(String musicDescription) {
		this.musicDescription.set(musicDescription);
	}

	public StringProperty musicDescriptionProperty() {
		return musicDescription;
	}

	public String getMusicGenre() {
		return musicGenre.get();
	}

	public void setMusicGenre(String musicGenre) {
		this.musicGenre.set(musicGenre);
	}

	public StringProperty musicGenreProperty() {
		return musicGenre;
	}

	public String getMusicUrl() {
		return musicUrl.get();
	}

	public void setMusicUrl(String musicUrl) {
		this.musicUrl.set(musicUrl);
	}

	public StringProperty musicUrlProperty() {
		return musicUrl;
	}

	public String getMusicYear() {
		return musicYear.get();
	}

	public void setMusicYear(String musicYear) {
		this.musicYear.set(musicYear);
	}

	public StringProperty musicYearProperty() {
		return musicYear;
	}

	@Override
	public String toString() {
		return String.format(
				"Music [musicID=%s, musicTitle=%s, musicArtist=%s, musicDescription=%s, musicGenre=%s, musicUrl=%s, musicYear=%s]",
				musicID.get(), musicTitle.get(), musicArtist.get(), musicDescription.get(), musicGenre.get(),
				musicUrl.get(), musicYear.get());
	}

}// EOC
