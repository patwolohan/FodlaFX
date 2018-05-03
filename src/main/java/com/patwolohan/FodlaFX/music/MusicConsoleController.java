package com.patwolohan.FodlaFX.music;

/*
*	Author:	COR edited by PW
*	Date:	2018
*	
*/

public class MusicConsoleController {

	private MusicTextAreaListView view;
	private MusicDAO model;

	public MusicConsoleController(MusicTextAreaListView view, MusicDAO model) {
		this.view = view;
		this.model = model;
	}

	public void display() {

		view.setMusicList(model.getAllMusic());
		view.display();
	}

}
