CREATE OR REPLACE FUNCTION
      classement_general(id_skieur INTEGER, annee INTEGER)returns INTEGER as $$
BEGIN
      RETURN (SELECT AVG(rang) AS rang
      FROM skieur sk, classement cl, competition co
      WHERE sk.no_skieur = cl.no_skieur
      AND cl.no_comp = co.no_comp
      AND sk.no_skieur = id_skieur
      AND co.specialite = 'alpin'
      AND annee = EXTRACT(YEAR FROM co.date_comp));
END;
$$language plpgsql;