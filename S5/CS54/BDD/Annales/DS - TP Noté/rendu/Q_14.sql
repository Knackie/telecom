CREATE OR REPLACE VIEW VueCompetition (no_comp, date_comp, places_libres)
AS
SELECT no_comp, date_comp, (capacite - nb_participants)
FROM competition co, station st
WHERE co.nom_station = st.nom_station;