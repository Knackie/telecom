CREATE OR REPLACE PROCEDURE
    nbParticipants() AS $$
DECLARE
      resRequete1 RECORD;
      resRequete2 RECORD;
      nbParticipant INTEGER;
BEGIN
      FOR resRequete1 IN (SELECT nom_station 
                          FROM station)
      LOOP
            FOR resRequete2 IN (SELECT DISTINCT(specialite)
                                FROM station st, competition co
                                WHERE st.nom_station = co.nom_station
                                AND st.nom_station = resRequete1.nom_station)
            LOOP
                  nbParticipant := 0;
                 
                  SELECT SUM(nb_participants) INTO nbParticipant
                  FROM station st, competition co
                  WHERE st.nom_station = co.nom_station
                  AND st.nom_station = resRequete1.nom_station
                  AND co.specialite = resRequete2.specialite;

                  RAISE NOTICE 'Station % - Specialite % - Nombre de participants : %', resRequete1.nom_station, resRequete2.specialite, nbParticipant;
            END LOOP;
      END LOOP;
END;

$$language plpgsql;