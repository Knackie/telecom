CREATE OR REPLACE PROCEDURE
    ajout_participant(n INTEGER, no_competition INTEGER) AS $$
DECLARE
      placeLbStation INTEGER;
BEGIN
      SELECT capacite - nb_participants INTO placeLbStation
      FROM competition co, station st
      WHERE co.nom_station = st.nom_station
      AND co.no_comp = no_competition;

      IF((placeLbStation - n) < 0) THEN
            RAISE EXCEPTION 'Pas assez de place dans la station';
      ELSE
      BEGIN
            UPDATE competition
            SET nb_participants = nb_participants + n
            WHERE competition.no_comp = no_competition;

            RAISE NOTICE 'Nouveau nombre de participant de la competition % : %', no_competition, (SELECT nb_participants
                                                                                          FROM competition
                                                                                          WHERE competition.no_comp = no_competition);
      END;
      END IF;
END;

$$language plpgsql;