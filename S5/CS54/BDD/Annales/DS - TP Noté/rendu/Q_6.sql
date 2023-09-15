SELECT no_comp, date_comp
FROM competition co, station st
WHERE co.nom_station = st.nom_station
AND st.alt_station > 3000;