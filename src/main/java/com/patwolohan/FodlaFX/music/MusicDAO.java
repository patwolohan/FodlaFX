package com.patwolohan.FodlaFX.music;

/*
 * COR edited by PW
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

public class MusicDAO implements IMusicDAO {

	// DATA
	// ............................................................

	private IDataManager dataManager;

	// CONSTRUCTORS
	// ............................................................

	public MusicDAO(IDataManager dataManager) {

		this.dataManager = dataManager;
	}

	// METHODS
	// ............................................................

	/**
	 * GET ALL
	 */
	public ObservableList<Music> getAllMusic() {

		ObservableList<Music> musicList = FXCollections.observableArrayList();

		// Get JDBC connection to database
		Connection connection = null;

		try {
			// get a database connection
			connection = this.dataManager.getConnectionObject();

			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30); // set timeout to 30 sec.

			// Run the query

			ResultSet resultSet = statement.executeQuery("select * from music");

			// iterate through the results create User objects put in the ObservableArray

			while (resultSet.next()) {

				Music music = new Music(resultSet.getInt("musicID"), resultSet.getString("musicTitle"),
						resultSet.getString("musicArtist"), resultSet.getString("musicDescription"),
						resultSet.getString("musicGenre"), resultSet.getString("musicUrl"),
						resultSet.getString("musicYear"));

				// putting the music objects into the list but not using them yet
				musicList.add(music);

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

		return musicList;

	}// EOM

	/**
	 * GET ONE
	 */
	public Music getMusic(int musicID) {
		throw new UnsupportedOperationException();
	}

	/**
	 * CREATE
	 */
	public long addMusic(Music music) {

		throw new UnsupportedOperationException();
	}

	/**
	 * UPDATE
	 */
	public void updateMusic(Music music) {

		throw new UnsupportedOperationException();
	}

	/**
	 * DELETE
	 */
	public void deleteMusic(Music music) {
		throw new UnsupportedOperationException();
	}

	public String printMusic(int musicID) {
		throw new UnsupportedOperationException();
	}

}
