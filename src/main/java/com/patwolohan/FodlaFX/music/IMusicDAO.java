package com.patwolohan.FodlaFX.music;

/*
*	Author:	COR edited by PW
*	Date:	2018
*	
*/

import javafx.collections.ObservableList;

public interface IMusicDAO {

	public ObservableList<Music> getAllMusic();

	public Music getMusic(int musicID);

	public long addMusic(Music music);

	public void updateMusic(Music music);

	public void deleteMusic(Music music);

	public String printMusic(int musicID);

}
