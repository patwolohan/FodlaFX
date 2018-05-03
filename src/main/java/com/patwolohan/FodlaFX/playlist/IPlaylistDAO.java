package com.patwolohan.FodlaFX.playlist;

import javafx.collections.ObservableList;

public interface IPlaylistDAO {

	public ObservableList<Playlist> getAllPlaylist();

	public Playlist getPlaylist(int playlistID);

	public long addPlaylist(Playlist playlist);

	public void updatePlaylist(Playlist playlist);

	public void deletePlaylist(Playlist playlist);

	public String printPlaylist(int playlistID);

}
