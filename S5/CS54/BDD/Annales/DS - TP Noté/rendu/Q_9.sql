SELECT nom_skieur AS nom, prenom
FROM skieur sk, competition co
GROUP BY (nom_skieur, prenom, sk.nom_station, co.nom_station)
HAVING sk.nom_station = co.nom_station;