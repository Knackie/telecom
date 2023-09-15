CREATE OR REPLACE PROCEDURE
    podium_general(anneeDebut INTEGER, anneeFin INTEGER) AS $$
DECLARE
      resRequete RECORD;
      yearActual INTEGER;
      beginingYear INTEGER;
      endingYear INTEGER;
      classement VARCHAR;
      numClassement INTEGER;
BEGIN
      IF (anneeDebut > anneeFin) THEN
            BEGIN
                  beginingYear := anneeFin;
                  endingYear := anneeDebut;
            END;
      ELSE
            BEGIN
                  beginingYear := anneeDebut;
                  endingYear := anneeFin;
            END;
      END IF;
      
      FOR yearActual IN beginingYear..endingYear
      LOOP
	      classement := '';
            numClassement := 1;
            FOR resRequete IN (SELECT classement_general(no_skieur, yearActual), sk.nom_skieur
                               FROM skieur sk
                               ORDER BY classement_general ASC
                               LIMIT 3)
            LOOP
                  classement := CONCAT(classement, CONCAT(numClassement, CONCAT('. ',CONCAT(resRequete.nom_skieur, ' '))));
                  numClassement := numClassement + 1;
            END LOOP;
            

            raise notice 'Coupe % - %', yearActual, classement;
      END LOOP;
END;

$$language plpgsql;