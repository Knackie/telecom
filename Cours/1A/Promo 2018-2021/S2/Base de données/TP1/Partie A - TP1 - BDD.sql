-- Grand A --

-- 1) --

CREATE TABLE Client (
id NUMBER (5), -- entier de 5 chiffres décimaux
nom VARCHAR2 (20), -- chaîne d’au plus 20 caractères
solde NUMBER (6, 2), -- de -9999.99 à +9999.99
CONSTRAINT client_PK PRIMARY KEY (id) -- garantit l’unicité de id pour chaque ligne
);

DESC Client; */
SELECT * from CLIENT;

SELECT table_name FROM user_tables;

-- Ajout des différents élements dans la table


INSERT INTO Client VALUES ( 1, 'toto', 200.0) ;
INSERT INTO Client VALUES ( 2, 'titi', 20.0) ;
INSERT INTO Client VALUES ( 3, 'titi', 20.0) ;
INSERT INTO Client VALUES ( 5, 'tata', 120.0) ;
INSERT INTO Client VALUES (15, 'bof', 150.0) ;
INSERT INTO Client VALUES (16, 'bif', 150.0) ;
