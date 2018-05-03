package com.patwolohan.FodlaFX.playlist;

public class PlaylistConsoleController {

	private PlaylistTextAreaListView view;
	private PlaylistDAO model;

	public PlaylistConsoleController(PlaylistTextAreaListView view, PlaylistDAO model) {
		this.view = view;
		this.model = model;
	}

	public void display() {

		view.setPlaylistList(model.getAllPlaylist());
		view.display();
	}

}
