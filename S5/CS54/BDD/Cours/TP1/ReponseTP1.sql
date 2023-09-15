-- Rendu TP 1

-- Reponse 1 : Afficher les noms des employas dont le salaire est superieur a 10 000 $.
SELECT * 
FROM employees
WHERE salary > 10000;

-- Reponse 2 : Afficher les noms des employes dont la date d'embauche est comprise entre 17/02/97 et 30/10/1997.
SELECT first_name, last_name 
FROM employees
WHERE hire_date > '1997-02-17'
AND hire_date < '1997-10-30';

-- Reponse 3 : Afficher les noms des employes commencant par la lettre 'J'. 
SELECT last_name 
FROM employees
WHERE last_name LIKE 'J%';

-- Reponse 4 : Afficher les noms des employes dont le nom contient deux fois la lettre 'a'. 
SELECT last_name 
FROM employees
WHERE LOWER(last_name) LIKE LOWER('%a%a%');

-- Reponse 5 : Afficher les noms des employes dont le numero du chef est 114.
SELECT last_name 
FROM employees
WHERE manager_id = 114;

-- Reponse 6 : Afficher les noms des services dont le numero du chef est 114 ou qui n'ont pas de chef. 
SELECT department_name 
FROM departments
WHERE (manager_id = 114
      OR manager_id = NULL);

-- Reponse 7 : Afficher les noms des services qui ne sont pas localises a 'Seattle'
SELECT department_name
FROM departments d, locations l
WHERE l.city = 'Seattle'
AND d.location_id != l.location_id

-- Reponse 8 : Afficher les noms des employes et leur commission. 
      -- Afficher 'pas de commission' dans la deuxieme colonne lorsque c'est le cas. 
      -- Ordonner la liste par rapport aux noms

SELECT last_name, COALESCE(commission_pct::varchar(255), 'Pas de commission')
FROM employees
ORDER BY last_name ASC;

-- Reponse 9 : Afficher les noms des employes, par ordre alphabetique 
      -- avec la premiere lettre seulement en majuscules, qui ont un salaire superieur au salaire moyen. 
SELECT e.last_name, e.salary  
FROM employees e  
GROUP BY e.last_name, e.salary  
HAVING e.salary > (select AVG(salary)
                   FROM employees e)
ORDER BY e.last_name ASC;

--Reponse 10 : Afficher les noms des employes qui ont au moins une personne sous leurs ordres. 
SELECT first_name, last_name
FROM employees
WHERE employee_id IN (
                  SELECT DISTINCT(manager_id) 
                  FROM employees 
                  WHERE manager_id IS NOT null)

-- Reponse 11 : Afficher les noms des services dans lesquels il n'y a aucun employe.
SELECT department_name
FROM departments
WHERE department_id NOT IN (
      SELECT d.department_id
      FROM departments d, employees e
      WHERE e.department_id = d.department_id
      );

-- Reponse 12 : Donner le nombre d'employes pour chaque poste.
SELECT COUNT(e.employee_id), j.job_title 
FROM jobs j, employees e 
WHERE j.job_id = e.job_id 
GROUP BY j.job_title

-- Reponse 13 : Afficher pour tous les employes qui ont ete embauches avant 'Weiss', leur nom, l'adresse et la ville de leur service.
SELECT e.first_name, e.last_name, l.street_address, l.city FROM employees e, locations l, departments d 
WHERE hire_date < (SELECT hire_date 
                  FROM employees 
                  WHERE last_name = 'Weiss') 
AND e.department_id = d.department_id 
AND d.location_id = l.location_id

-- Reponse 14 : Pour chaque poste, donner le nombre d'employes dont le salaire se trouve entre le minimum et le maximum des salaires prevus pour ce poste.
SELECT j.job_title, COUNT(e.employee_id)
FROM jobs j, employees e
WHERE j.job_id = e.job_id 
AND j.min_salary < e.salary
AND j.max_salary > e.salary
GROUP BY j.job_title

-- Reponse 15 : - Pour chaque poste, donner la somme des salaires lorsque cette somme est inferieure  10000$. 
SELECT j.job_title, SUM(e.salary) 
FROM employees e, jobs j
WHERE j.job_id = e.job_id 
GROUP BY j.job_title
HAVING SUM(salary)<10000