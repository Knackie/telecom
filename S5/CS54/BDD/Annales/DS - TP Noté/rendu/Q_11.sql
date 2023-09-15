SELECT st.nom_station, st.pays_station
FROM station st
WHERE st.nom_station NOT IN (
      SELECT st.nom_station
      FROM station st, competition co
      WHERE st.nom_station = co.nom_station
);