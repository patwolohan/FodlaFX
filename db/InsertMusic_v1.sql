BEGIN TRANSACTION;
insert into Music ( songName, songArtist, songYear, songURL ) 
values  ('UltronWaltz', 'Ultron', '1999', 'file:///media/UltronBestLinesMoments.mp3');
insert into Music ( songName, songArtist, songYear, songURL ) 
values  ('C3POWaltz', 'C3PO', '2020', 'file:///media/C-3POWhines.mp3');
insert into Music ( songName, songArtist, songYear, songURL ) 
values  ('R2D2Waltz', 'R2D2', '1957', 'file:///media/C3P0TeachesR2.mp3');
insert into Music ( songName, songArtist, songYear, songURL ) 
values  ('UltronPop', 'Ultron', '2000', 'file:///media/C-3POWhines.mp3');
insert into Music ( songName, songArtist, songYear, songURL ) 
values  ('UltronRock', 'Ultron', '2010', 'file:///media/TheFirstWaltz.mp3');
COMMIT;
