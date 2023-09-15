SELECT nom_station
FROM station
WHERE station.pays_station = 'France'
AND station.nom_station NOT IN (
      SELECT st.nom_station
      FROM station st, competition co
      WHERE co.nom_station = st.nom_station
);