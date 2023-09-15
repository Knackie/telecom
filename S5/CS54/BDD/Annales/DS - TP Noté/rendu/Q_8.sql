SELECT nom_skieur AS nom_s
FROM skieur
WHERE (nom_skieur LIKE '%t'
OR LENGTH(nom_skieur) = 4);