BEGIN TRANSACTION;
insert into Playlist ( userID, musicID, annotation ) 
values  ('1', '1', 'my best moments');
insert into Playlist ( userID, musicID, annotation ) 
values  ('1', '4', 'he moans more than me');
insert into Playlist ( userID, musicID, annotation ) 
values  ('1', '5', 'chirppy');
insert into Playlist ( userID, musicID, annotation ) 
values  ('2', '2', 'C3PO my best moments');
insert into Playlist ( userID, musicID, annotation ) 
values  ('2', '3', 'C3PO he moans more than me');
insert into Playlist ( userID, musicID, annotation ) 
values  ('2', '1', 'C3PO chirppy');
insert into Playlist ( userID, musicID, annotation ) 
values  ('3', '4', 'R2D2 my best moments');
insert into Playlist ( userID, musicID, annotation ) 
values  ('3', '2', 'R2D2 he moans more than me');
insert into Playlist ( userID, musicID, annotation ) 
values  ('3', '5', 'R2D2 chirppy');
COMMIT;
