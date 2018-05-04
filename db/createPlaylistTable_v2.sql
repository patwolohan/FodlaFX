CREATE TABLE Playlist
(
	userID			integer			not null,
	musicID			integer			not null,
	annotation		varchar(400)	not null,
	PRIMARY KEY (userID,musicID)
);
