-- Partie 1

-- 1)
CREATE SCHEMA IF NOT EXISTS public;

DROP TABLE IF EXISTS public.client;
CREATE TABLE IF NOT EXISTS public.client
(
    "nomPrenom" VARCHAR NOT NULL,
    "dateNais" VARCHAR NOT NULL,
    "adresse" VARCHAR NOT NULL,
    "profession" VARCHAR NOT NULL,
    CONSTRAINT "Client_pkey" PRIMARY KEY ("nomPrenom")
);


DROP TABLE IF EXISTS public.typeCompte;
CREATE TABLE public.typeCompte
(
    nom VARCHAR NOT NULL,
    categorie VARCHAR NOT NULL,
    soldeMin DECIMAL(20, 2) NOT NULL,
    interet DECIMAL(4, 1) NOT NULL,
    CONSTRAINT TypeCompte_pkey PRIMARY KEY (nom),
	CHECK (nom ='compte courant etudiant' OR nom = 'compte courant' OR nom = 'compte sur livret' OR nom = 'compte action')
);

DROP TABLE IF EXISTS public.compte;
CREATE TABLE public.compte 
(
    "noCompte" VARCHAR NOT NULL,
    "typeC" VARCHAR NOT NULL,
    "proprietaire" VARCHAR NOT NULL,  
    "solde" INT NOT NULL,
    PRIMARY KEY ("noCompte"),
    FOREIGN KEY ("typeC")
        REFERENCES public.typeCompte (nom) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID,
    FOREIGN KEY (proprietaire)
        REFERENCES public.Client ("nomPrenom") MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID
);

DROP TABLE IF EXISTS public.transactionBancaire;
CREATE TABLE public.transactionBancaire 
(
    "noCompte" VARCHAR NOT NULL,
    "date" VARCHAR NOT NULL DEFAULT CURRENT_DATE,
    "typeTransac" VARCHAR NOT NULL,
    "credit" DECIMAL(20, 2) NOT NULL,
    "debit" DECIMAL(20, 2) NOT NULL,
    PRIMARY KEY ("noCompte", date),
    FOREIGN KEY ("noCompte")
        REFERENCES public.compte ("noCompte") MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID
);


-- 2) 
SELECT table_name 
FROM information_schema.tables 
WHERE table_schema = 'public'

-- 3) 

-- 4)
      INSERT INTO CLIENT VALUES(
      'Vincent Mollard',
      '15/03/1997',
      '45 Avenue Général Leclerc 54500 Vandoeuvre les Nancy',
      'Etudiant'
      );

      INSERT INTO CLIENT VALUES(
      'Bernard Maigret',
      '10/12/1966',
      '1 Place des Vosges 54000 Nancy',
      'Enseignant'
      );
      INSERT INTO CLIENT VALUES(
      'Olivier Durand',
      '15/02/1989',
      '21 Avenue de General Leclerc 54000 Nancy',
      'Etudiant'
      );
      INSERT INTO CLIENT VALUES(
      'Marine Vogt',
      '12/12/1990',
      '21 Avenue Jean Jaures 54500 Vandoeuvre les Nancy',
      'Ingenieur d Ètude'
      );
      INSERT INTO CLIENT VALUES(
      'Amelie Dupont',
      '13/12/1986',
      '1 Avenue de la RÈpublique 54000 Nancy',
      'Enseignant'
      );
      INSERT INTO CLIENT VALUES(
      'Olivier Lenort',
      '27/01/1966',
      '3 Place de la Republique 54000 Nancy',
      'Agent de sÈcuritÈ'
      );

      INSERT INTO CLIENT VALUES(
      'Christophe Lemaire',
      '15/01/1976',
      '3 Place de la Republique 63000 Clermont Ferrand',
      'Enseignant'
      );


      INSERT INTO TYPECOMPTE VALUES(
      'compte courant',
      'courant',
      -300,
      1
      );

      INSERT INTO TYPECOMPTE VALUES(
      'compte courant etudiant',
      'courant',
      -200,
      0.5
      );


      INSERT INTO TYPECOMPTE VALUES(
      'compte sur livret',
      'épargne',
      -1000,
      2
      );

      INSERT INTO COMPTE VALUES(
      'E-120-256',
      'compte courant etudiant',
      'Olivier Durand',
      -100
      );

      INSERT INTO COMPTE VALUES(
      'C-005-569',
      'compte sur livret',
      'Marine Vogt',
      5260
      );

      INSERT INTO COMPTE VALUES(
      'C-205-569',
      'compte courant',
      'Christophe Lemaire',
      230
      );

      INSERT INTO COMPTE VALUES(
      'L95129',
      'compte sur livret',
      'Amelie Dupont',
      100
      );
      INSERT INTO COMPTE VALUES(
      'C-125-199',
      'compte courant',
      'Olivier Lenort',
      205
      );
      INSERT INTO COMPTE VALUES(
      'C-425-299',
      'compte courant',
      'Bernard Maigret',
      305
      );


      INSERT INTO TRANSACTIONBANCAIRE VALUES (
      'L95129','04/03/2020', 'crédit espèces', 100, 0); 

      INSERT INTO TRANSACTIONBANCAIRE VALUES (
      'L95129','05/05/2020', 'débit espèces', 0, 50); 

      INSERT INTO TRANSACTIONBANCAIRE VALUES (
      'C-005-569','03/03/2021', 'crédit espèces', 150, 0); 

      INSERT INTO TRANSACTIONBANCAIRE VALUES (
      'C-005-569','08/05/2021', 'crédit chèque', 230, 0); 

      INSERT INTO TRANSACTIONBANCAIRE VALUES (
      'C-205-569','11/10/2021', 'crédit chèque', 100, 0); 

      INSERT INTO TRANSACTIONBANCAIRE VALUES (
      'E-120-256','04/15/2021', 'crédit espèces', 100, 0); 

-- 5)
DELETE
FROM compte USING client 
WHERE client.profession = 'Enseignant'
AND client.adresse like '%54000 Nancy'

-- 6)
SELECT tr.noCompte, tr.date, tr.typeTransac, tr.debit, tr.credit
FROM transactionBancaire tr, compte co
WHERE tr.noCompte = co.noCompte
AND (co.typeCompte = "compte courant")
OR (co.noCompte LIKE 'C%'
   AND LENGTH(co.noCompte) <= 6);

-- 7)
ALTER TABLE public.TypeCompte
ADD CONSTRAINT interet_value CHECK (typeCompte.interet >= 0 AND typeCompte.interet <= 3);

-- 8)
CREATE VIEW VueClients (nomPrenom, age, adresse, profession, noCompte)