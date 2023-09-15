SELECT st.nom_station, COUNT(nom_skieur) AS nb_skieur
FROM station st, skieur sk
WHERE st.nom_station = sk.nom_station
GROUP BY (st.nom_station);