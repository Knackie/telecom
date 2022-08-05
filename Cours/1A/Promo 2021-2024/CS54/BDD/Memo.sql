# SQL

WHERE LAST_NAME LIKE 'J%';
WHERE LAST_NAME LIKE '%A%A%';

SELECT [...] MINUS SELECT [...]

COALESCE(arg,"Pas d'arg") 
# Retourne première valeur non nulle
# Si on boucle les arg => soit elle renvoie arg soit "pas d'arg"
# COALESCE = NVL

TO_CHAR(expression,format) # Voir docs pour format

SELECT  COUNT(...)/SUM(...), TUPLE
[...]
GROUP BY TUPLE;

# Fonction

CREATE OR REPLACE FUNCTION [Nom_Fonction] ([Nom_Argument] [Type_Argument]) 
RETURNS [Type_Retour]AS $$  
BEGIN 
[Commandes]
END; 
$$ LANGUAGE plpgsql; 

SELECT [Nom_Fonction]([Argument]) AS "[Nom_Colonne]" FROM [Table];

# Procédure 

CREATE OR REPLACE PROCEDURE [Nom_Procedure]([Nom_Arg] [Table].[Tuple]%TYPE 
DEFAULT [Valeur_Arg])  
LANGUAGE plpgsql 
AS $$ 
DECLARE 
[Nom_Variable] [Type_Variable]; 
BEGIN 
[Commandes]
END; $$

CALL [Nom_Procedure]([Argument]);

# Bloc

do $$  
DECLARE 
[Nom_Variable] [Type_Variable];
BEGIN 
[Commandes]
END ; 
$$ LANGUAGE plpgsql; 

# Curseur
DECLARE
[C_NOM] CURSOR FOR SELECT department_id AS [VAR] FROM [...] WHERE [...]
[C_VAR] departments.department_id%TYPE;

BEGIN
OPEN [C_NOM];
LOOP
FETCH [C_NOM] INTO [C_VAR];
IF NOT FOUND THEN EXIT; END IF;
END LOOP;
CLOSE [C_NOM];


# Commandes
[VAR] := [VAL];

SELECT [...] INTO [Nom_Variable];
IF [...] THEN 
[...];
ELSE
[...];
END IF;

RAISE EXCEPTION 'Text' ;
RAISE NOTICE 'Text %', [Nom_Variable];

FOR I IN C1 LOOP 
RAISE NOTICE '%', I.FIRST_NAME; 
END LOOP;

COMMIT;