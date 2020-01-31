SELECT solde FROM Client ;
SELECT nom, solde FROM Client ;

SELECT DISTINCT solde FROM Client ;
SELECT DISTINCT nom, solde FROM Client ;
SELECT DISTINCT solde, nom FROM Client ;

-- Le distinct sert à garder une seul occurrence des valeurs
-- ou de l'ensemble des valeurs récupérées

/*  Q3 */

SELECT nom FROM CLIENT WHERE SOLDE>=150;

/* Q4 */

SELECT ID from CLIENT WHERE mod(ID,2)=0;

/* Q5 */

SELECT nom FROM CLIENT WHERE NOM like '%o%';

/* Q6 */

INSERT INTO Client VALUES (20,'riri',null);
INSERT INTO Client(id,nom) VALUES (21,'fifi');
INSERT INTO Client(id,solde) VALUES (22,150.0);

/* Q7 */
INSERT INTO client(nom) VALUES ('loulou');
-- Il refuse car la clé primaire ne peut jamais être à null

/* Q8 */

SELECT COUNT(*) FROM Client ;
SELECT COUNT(nom) FROM Client ;
SELECT AVG(solde) FROM Client ;

UPDATE Client SET solde = solde - 30.0, nom='toto' WHERE id = 2 ;
SELECT * FROM Client ;

/* Q9 */

-- Il ne le modifera aucun autre utilisateur car on le
-- selectionne avec son ID

UPDATE Client SET solde = solde + 30.0 WHERE solde BETWEEN 100.0 AND 180.0 ;
SELECT * FROM Client ;

/* Q10 */

-- Car on définit sur un solde et non sur un id d'utilisateur --

DELETE FROM Client WHERE id = 4 ;
SELECT * FROM Client ;

/* Q11 */

-- Elle n'a pas changée car il n'y avait aucun utilisateur avec l'id 4 --

DELETE FROM client WHERE id = 1 ;
SELECT * FROM Client ;

DROP TABLE Client ;
SELECT * FROM Client ;

CREATE TABLE Producteur (
  id Number (5),
  nom Varchar2 (20),
  CONSTRAINT Producteur_PK PRIMARY KEY (id)
);
INSERT INTO Producteur VALUES ( 1, 'Bricolot') ;
INSERT INTO Producteur VALUES ( 2, 'Fruit and Fibre') ;

 CREATE TABLE Produit (
          id Number (5),
          nom Varchar2 (20),
          prix_unitaire Number (8, 2),
          producteur Number (5),
          CONSTRAINT Produit_Producteur_FK
          FOREIGN KEY (producteur) REFERENCES Producteur(id),
CONSTRAINT Produit_PK PRIMARY KEY (id) );

INSERT INTO Produit (id, nom, prix_unitaire, producteur) VALUES ( 1, 'clou', 11.0, 1) ;
INSERT INTO Produit (id, nom, prix_unitaire,producteur) VALUES ( 2, 'robinet', 30.0, 1) ;
INSERT INTO Produit (id, nom, prix_unitaire,producteur) VALUES ( 3, 'kiwi', 0.3, 2) ;
SELECT * FROM Produit ;

/*INSERT INTO Produit (id, nom, prix_unitaire,producteur) VALUES ( 4, 'pomme', 0.5, 3) ;*/
SELECT * FROM Produit ;

/* Q13 */
SELECT P.nom as nomProducteur, producteur.nom as nomProducteur from Producteur inner join Produit P on Producteur.id = P.producteur;

/* Q14 */

SELECT P1.nom as nomProduit1,
P2.nom as nomProduit2,
P1.prix_unitaire as p1,
P2.prix_unitaire as p2
from Produit P1,
Produit P2
where P1.prix_unitaire<=P2.prix_unitaire;

CREATE TABLE Commande (
          idClient Number (5),
          idProduit Number (5),
          quantite Number (5),
          CONSTRAINT Commande_PK PRIMARY KEY (idClient,idProduit),
          CONSTRAINT Commande_Client_FK
          FOREIGN KEY (idClient) REFERENCES Client (id), CONSTRAINT Commande_Produit_FK
          FOREIGN KEY (idProduit) REFERENCES Produit (id)
);

INSERT INTO Commande VALUES (2, 2, 3) ;
     INSERT INTO Commande VALUES (2, 3, 20) ;
     INSERT INTO Commande VALUES (5, 1, 100) ;
     INSERT INTO Commande VALUES (5, 3, 10) ;
     SELECT * FROM Commande ;

select CLIENT.nom, Produit.nom, COMMANDE.quantite
from CLIENT INNER JOIN (Produit INNER JOIN Commande on Produit.id = Commande.idProduit) on Commande.idClient=CLIENT.ID;

select DISTINCT CLIENT.nom
from CLIENT INNER JOIN Commande on Commande.idClient=CLIENT.ID;

select nom from CLIENT where id in (select idClient from Commande);