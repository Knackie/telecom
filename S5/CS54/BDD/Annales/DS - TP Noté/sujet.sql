CREATE TABLE Station (nom_station varchar(50) Primary key,
alt_station integer,
pays_station varchar(50),
capacite integer);
CREATE TABLE Skieur (no_skieur integer Primary key check (no_skieur > 0),
nom_skieur varchar(50),
prenom varchar(50),
nom_station varchar(50) references station(nom_station));
CREATE TABLE Competition (no_comp integer primary key check (no_comp > 0),
date_comp DATE, nom_station varchar(50) references station(nom_station),
specialite varchar(50) check (specialite in ('alpin','acrobatique','fond','snowboard')),
nb_participants integer);
CREATE TABLE Classement (no_comp integer references competition(no_comp),
no_skieur integer references skieur(no_skieur),
rang integer DEFAULT 0, primary key(no_comp,no_skieur));


-- Tuple 
insert into station values ('Tignes',2000,'France', 250);
insert into station values ('Bormio',3200,'Italie', 150);
insert into station values ('Arvieux en Queyras',1500,'France', 300);
insert into station values ('Ascou Pailheres',2500,'France', 200);
insert into skieur values (1, 'Durand','Olivier','Tignes');
insert into skieur values (2, 'Vogl','Marine','Bormio');
insert into skieur values (3, 'Renaut','Francois','Arvieux en Queyras');
insert into skieur values (4, 'Dupont','Laurent','Ascou Pailheres');
insert into skieur values (5, 'Enault','Francois','Bormio');
insert into competition values (1,'12-01-18', 'Tignes','alpin',120);
insert into competition values (2,'02-28-18', 'Bormio','fond',100);
insert into competition values (3,'02-03-17', 'Tignes','alpin',56);
insert into competition values (4,'01-20-17', 'Tignes','alpin',230);
insert into classement values (1,1,30);
insert into classement values (2,2,12);
insert into classement values (3,1,3);
insert into classement values (4,4,45);
insert into classement values (2,5,2);
insert into classement values (1,3,15);
insert into classement values (3,4,21);
insert into classement values (4,1,15);
insert into classement values (1,2,25);
insert into classement values (3,5,10);