DELETE 
FROM skieur sk USING competition co, classement cl
WHERE sk.no_skieur = cl.no_skieur
AND cl.no_comp = co.no_comp
AND co.nb_participants > 500;