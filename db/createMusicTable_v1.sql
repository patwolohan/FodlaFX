CREATE TABLE Music
(
	musicID			integer		    not null	PRIMARY KEY AUTOINCREMENT,
	songName		varchar(100)	not null,
	songArtist		varchar(100)	not null,
	songYear		varchar(4)		not null,
	songURL			varchar(100)	not null
);
