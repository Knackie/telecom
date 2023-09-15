SELECT DISTINCT(sk.no_skieur), MIN(rang) AS meilleur_rang
FROM skieur sk, classement cl, station st
WHERE sk.no_skieur = cl.no_skieur
AND sk.nom_station = st.nom_station
AND st.pays_station = 'France'
GROUP BY(sk.no_skieur);