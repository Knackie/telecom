-- Romain NATANELIC
--
--

-- EXERCICE 1
-- 1)
CREATE OR REPLACE FUNCTION
	CHARGES(salary int) returns int as $$
BEGIN
	return salary*0.45;
END;		
$$language plpgsql;

SELECT last_name, CHARGES(salary)
FROM employees;

-- 2)
CREATE OR REPLACE FUNCTION
      INSERT_LOCATION(rue VARCHAR DEFAULT 'INCONNU', ville VARCHAR DEFAULT 'Paris')returns BOOLEAN as $$
DECLARE
      lastID INTEGER DEFAULT 0;
BEGIN
      SELECT location_id + 1 INTO lastID
	  FROM locations
	  ORDER BY location_id DESC
	  LIMIT 1;

      INSERT INTO locations(id, street_address, city) VALUES(lastID, rue, ville); 

	RETURN true;
END;
$$language plpgsql;

SELECT insert_location('Rue Saint Symphorien', 'METZ');
SELECT *
FROM locations
ORDER BY location_id DESC
LIMIT 1;

-- 3) a)
DO $$
DECLARE
      nb10KMoins INTEGER DEFAULT 0;
BEGIN
      SELECT COUNT(*) into nb10KMoins
      FROM departments d, employees e
      WHERE d.department_name = 'Finance'
      AND d.department_id = e.department_id
      AND e.salary < 10000;

      IF(nb10KMoins = 0) THEN
            RETURN 'Tous les employes du service Finance gagnent plus de 10 000e';
      ELSE
            RETURN CONCAT('Il y a ', CONCAT(nb10KMoins::VARCHAR(255), ' employes qui gagnent plus de 10 000e'));
      END IF;
END;
$$language plpgsql;

-- 3) b)
CREATE OR REPLACE FUNCTION
      test_service(service VARCHAR)returns VARCHAR as $$
DECLARE
      nb10KMoins INTEGER DEFAULT 0;
      nbServiceCorrespondant INTEGER DEFAULT 0;
BEGIN

      SELECT COUNT(*) into nbServiceCorrespondant
      FROM departments d
      WHERE d.department_name = service;

      IF(nbServiceCorrespondant = 0) THEN
            RAISE EXCEPTION 'No service corresponding %', now();
      END IF;

      SELECT COUNT(*) into nb10KMoins
      FROM departments d, employees e
      WHERE d.department_name = service
      AND d.department_id = e.department_id
      AND e.salary < 10000;

      IF(nb10KMoins = 0) THEN
            RETURN 'Tous les employes du service Finance gagnent plus de 10 000e';
      ELSE
            RETURN CONCAT('Il y a ', CONCAT(nb10KMoins::VARCHAR(255), ' employes qui gagnent plus de 10 000e'));
      END IF;
END;
$$language plpgsql;

SELECT test_service('IT');

-- 3) c)
-- Teste, voici les messages obtenus : 
ERROR: ERREUR:  No service corresponding
CONTEXT:  fonction PL/pgSQL test_service(character varying), ligne 12 a RAISE


SQL state: P0001 

-- 4)
CREATE OR REPLACE PROCEDURE
      service_sans_chef() as $$
DECLARE
	resRequete RECORD;
BEGIN
	FOR resRequete in (SELECT DISTINCT(d.department_name)
      					FROM departments d
      					WHERE d.manager_id ISNULL)
	LOOP
		RAISE NOTICE '%', resRequete.department_name;
	END LOOP;
END;
$$language plpgsql;

CALL service_sans_chef();


-- 5)
CREATE OR REPLACE PROCEDURE
      service_sans_chef_ville(ville VARCHAR) as $$
DECLARE
	resRequete RECORD;
BEGIN
	FOR resRequete in (SELECT DISTINCT(d.department_name)
      			FROM departments d, locations l
      			WHERE l.city = ville
      			AND d.manager_id ISNULL)
	LOOP
		RAISE NOTICE '%', resRequete.department_name;
	END LOOP;
END;
$$language plpgsql;

CALL service_sans_chef_ville('Paris');




-- EXERCICE 2
-- 1)
DO $$ 
DECLARE
	resRequete RECORD;
BEGIN
      FOR resRequete IN (SELECT *
				FROM employees
				ORDER BY salary DESC
				LIMIT 5)
	LOOP 
	  	RAISE NOTICE '%', resRequete;
	END LOOP;
END;
$$language plpgsql;

-- 2
CREATE OR REPLACE PROCEDURE
      top_n(n int) as $$
DECLARE
	resRequete RECORD;
BEGIN
      IF (n > 0) THEN 
            FOR resRequete IN (SELECT *
                              FROM employees
                              ORDER BY salary DESC
                              LIMIT n)
            LOOP 
                  RAISE NOTICE '%', resRequete;
            END LOOP;
      ELSE
            RAISE NOTICE 'Merci de saisir une valeur strictement positive';
      END IF;
      
END;
$$language plpgsql;