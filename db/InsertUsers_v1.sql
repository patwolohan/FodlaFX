BEGIN TRANSACTION;
insert into User ( userName, userEmail, userRole, userToken, userStatus, userLastUpdate ) 
values  ('Ultron', 'ultron@evilones.com', 'admin', 'evil', '1', datetime('now'));
insert into User ( userName, userEmail, userRole, userToken, userStatus, userLastUpdate ) 
values  ('R2D2', 'R2D2@goodones.com', 'user', '', '1', datetime('now'));
insert into User ( userName, userEmail, userRole, userToken, userStatus, userLastUpdate ) 
values  ('C3PO', 'C3PO@goodones.com', 'user', '', '1', datetime('now'));
COMMIT;
