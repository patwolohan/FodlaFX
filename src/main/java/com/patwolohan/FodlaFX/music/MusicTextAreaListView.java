package com.patwolohan.FodlaFX.music;

/*
*	Author:	COR edited by PW
*	Date:	2018
*	
*/

import java.util.Iterator;
import javafx.collections.ObservableList;
import javafx.scene.control.TextArea;

public class MusicTextAreaListView {

	ObservableList<Music> musicList;
	TextArea aTextArea;

	public MusicTextAreaListView(TextArea aTextArea) {
		this.aTextArea = aTextArea;
	}

	public void setMusicList(ObservableList<Music> musicList) {
		this.musicList = musicList;
	}

	public void display() {

		aTextArea.appendText("... MUSIC VIEWER ...");
		aTextArea.appendText("\n");
		Iterator<Music> iterator = this.musicList.iterator();
		while (iterator.hasNext()) {
			Music music = (Music) iterator.next();
			aTextArea.appendText(music.toString() + "\n");
		}
	}

}
