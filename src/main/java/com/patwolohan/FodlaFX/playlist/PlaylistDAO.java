package com.patwolohan.FodlaFX.playlist;

/*
 * COR
 * 2018
 * Ref: https://www.swtestacademy.com/database-operations-javafx/
 * 
 */

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.patwolohan.FodlaFX.data.IDataManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PlaylistDAO implements IPlaylistDAO {

	// DATA
	// ............................................................

	private IDataManager dataManager;

	// CONSTRUCTORS
	// ............................................................

	public PlaylistDAO(IDataManager dataManager) {

		this.dataManager = dataManager;
	}

	// METHODS
	// ............................................................

	/**
	 * GET ALL
	 */
	public ObservableList<Playlist> getAllPlaylist() {

		ObservableList<Playlist> playlistList = FXCollections.observableArrayList();

		// Get JDBC connection to database
		Connection connection = null;

		try {
			// get a database connection
			connection = this.dataManager.getConnectionObject();

			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30); // set timeout to 30 sec.

			// Run the query

			ResultSet resultSet = statement.executeQuery("select * from playlist");

			// iterate through the results create User objects put in the ObservableArray

			while (resultSet.next()) {

				Playlist playlist = new Playlist(resultSet.getInt("playlistID"), resultSet.getString("playlistTitle"),
						resultSet.getString("playlistDescription"), resultSet.getString("playlistTheme"));

				// putting the playlist objects into the list but not using them yet
				playlistList.add(playlist);

			}

		} catch (SQLException e) {
			// if the error message is "out of memory",
			// it probably means no database file is found
			System.out.println(e.getMessage());
		} finally {
			try {
				if (connection != null)
					this.dataManager.disconnect();
			} catch (SQLException e) {
				// connection close failed.
				System.out.println(e.getMessage());
			}
		}

		return playlistList;

	}// EOM

	/**
	 * GET ONE
	 */
	public Playlist getPlaylist(int playlistID) {
		throw new UnsupportedOperationException();
	}

	/**
	 * CREATE
	 */
	public long addPlaylist(Playlist playlist) {

		throw new UnsupportedOperationException();
	}

	/**
	 * UPDATE
	 */
	public void updatePlaylist(Playlist playlist) {

		throw new UnsupportedOperationException();
	}

	/**
	 * DELETE
	 */
	public void deletePlaylist(Playlist playlist) {
		throw new UnsupportedOperationException();
	}

	public String printPlaylist(int playlistID) {
		throw new UnsupportedOperationException();
	}

}
