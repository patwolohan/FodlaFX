package com.patwolohan.FodlaFX.playlist;

import java.util.Iterator;
import javafx.collections.ObservableList;
import javafx.scene.control.TextArea;

public class PlaylistTextAreaListView {

	ObservableList<Playlist> playlistList;
	TextArea aTextArea;

	public PlaylistTextAreaListView(TextArea aTextArea) {
		this.aTextArea = aTextArea;
	}

	public void setPlaylistList(ObservableList<Playlist> playlistList) {
		this.playlistList = playlistList;
	}

	public void display() {

		aTextArea.appendText("... PLAYLIST VIEWER ...");
		aTextArea.appendText("\n");
		Iterator<Playlist> iterator = this.playlistList.iterator();
		while (iterator.hasNext()) {
			Playlist playlist = (Playlist) iterator.next();
			aTextArea.appendText(playlist.toString() + "\n");
		}
	}

}
