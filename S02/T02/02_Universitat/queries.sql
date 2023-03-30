 -- Si us plau, descàrrega la base de dades del fitxer schema_universidad.sql, visualitza el diagrama E-R en un editor i efectua les següents consultes:

-- 1. Retorna un llistat amb el primer cognom, segon cognom i el nom de tots els/les alumnes. El llistat haurà d'estar ordenat alfabèticament de menor a major pel primer cognom, segon cognom i nom.
SELECT apellido1, apellido2, nombre
FROM persona
ORDER BY apellido1 ASC, apellido2 ASC, nombre ASC;

-- 2. Esbrina el nom i els dos cognoms dels alumnes que no han donat d'alta el seu número de telèfon en la base de dades.
SELECT apellido1, apellido2, nombre
FROM persona
WHERE telefono IS NULL;

-- 3. Retorna el llistat dels alumnes que van néixer en 1999.
SELECT *
FROM persona
WHERE YEAR(fecha_nacimiento ) = 1999;

-- 4. Retorna el llistat de professors/es que no han donat d'alta el seu número de telèfon en la base de dades i a més el seu NIF acaba en K.
SELECT p.*
FROM persona p, profesor pr
WHERE pr.id_profesor = p.id AND p.nif LIKE '%K' AND p.telefono IS NULL;

-- 5. Retorna el llistat de les assignatures que s'imparteixen en el primer quadrimestre, en el tercer curs del grau que té l'identificador 7.
SELECT a.* FROM asignatura a
WHERE a.cuatrimestre = 1 AND a.curso = 3 AND id_grado = 7;

-- 6. Retorna un llistat dels professors/es juntament amb el nom del departament al qual estan vinculats. 
-- El llistat ha de retornar quatre columnes, primer cognom, segon cognom, nom i nom del departament. 
-- El resultat estarà ordenat alfabèticament de menor a major pels cognoms i el nom.
SELECT p.apellido1, p.apellido2, p.nombre, d.nombre
FROM persona p, departamento d, profesor pr
WHERE  pr.id_profesor=p.id AND pr.id_departamento = d.id
ORDER BY p.apellido1 ASC, p.apellido2 ASC, p.nombre ASC;

-- 7. Retorna un llistat amb el nom de les assignatures, any d'inici i any de fi del curs escolar de l'alumne/a amb NIF 26902806M.
SELECT a.nombre, c.anyo_inicio, c.anyo_fin
FROM asignatura a, curso_escolar c, alumno_se_matricula_asignatura al, persona p
WHERE al.id_asignatura = a.id AND al.id_curso_escolar = c.id AND al.id_alumno = p.id AND p.nif = '26902806M';

-- 8. Retorna un llistat amb el nom de tots els departaments que tenen professors/es que imparteixen alguna assignatura en el Grau en Enginyeria Informàtica (Pla 2015).
SELECT DISTINCT(d.id), d.nombre FROM departamento d, profesor p
WHERE d.id = p.id_departamento AND p.id_profesor IN
	(SELECT a.id FROM asignatura a, grado g
    WHERE a.id_grado = g.id AND g.nombre = 'Grado en Ingeniería Informática (Plan 2015)')
    ORDER BY d.id;

-- 9. Retorna un llistat amb tots els alumnes que s'han matriculat en alguna assignatura durant el curs escolar 2018/2019.
SELECT p.nombre, p.apellido1, p.apellido2 FROM persona p
WHERE p.id IN(SELECT a.id_alumno FROM alumno_se_matricula_asignatura a 
	WHERE a.id_curso_escolar IN (SELECT id FROM curso_escolar 
		WHERE anyo_inicio = 2018));
-- --------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- Resol les 6 següents consultes utilitzant les clàusules LEFT JOIN i RIGHT JOIN.

-- 1. Retorna un llistat amb els noms de tots els professors/es i els departaments que tenen vinculats. 
-- El llistat també ha de mostrar aquells professors/es que no tenen cap departament associat. 
-- El llistat ha de retornar quatre columnes, nom del departament, primer cognom, segon cognom i nom del professor/a. 
-- El resultat estarà ordenat alfabèticament de menor a major pel nom del departament, cognoms i el nom.
SELECT d.nombre AS departamento, p.apellido1, p.apellido2, p.nombre FROM persona p
	LEFT JOIN profesor pr ON pr.id_profesor = p.id
		LEFT JOIN departamento d ON d.id = pr.id_departamento
        ORDER BY d.nombre ASC, p.apellido1 ASC, p.apellido2 ASC, p.nombre ASC;

-- 2. Retorna un llistat amb els professors/es que no estan associats a un departament.
SELECT p.apellido1, p.apellido2, p.nombre FROM persona p
	LEFT JOIN profesor pr ON pr.id_profesor = p.id
		WHERE pr.id_departamento IS NULL
	ORDER BY p.apellido1 ASC, p.apellido2 ASC, p.nombre ASC;

-- 3. Retorna un llistat amb els departaments que no tenen professors/es associats.
SELECT d.nombre AS departamento FROM departamento d
	LEFT JOIN profesor pr ON pr.id_departamento = d.id
		WHERE pr.id_profesor IS NULL
	ORDER BY d.nombre ASC;

-- 4. Retorna un llistat amb els professors/es que no imparteixen cap assignatura.
SELECT p.apellido1, p.apellido2, p.nombre FROM persona p
	LEFT JOIN profesor pr ON pr.id_profesor = p.id
    WHERE pr.id_profesor NOT IN
		(SELECT id_profesor FROM asignatura)
	ORDER BY p.apellido1 ASC, p.apellido2 ASC, p.nombre ASC;

-- 5. Retorna un llistat amb les assignatures que no tenen un professor/a assignat.
SELECT a.id, a.nombre
FROM asignatura a
LEFT JOIN profesor p ON a.id_profesor = p.id_profesor
WHERE p.id_profesor IS NULL;

-- 6. Retorna un llistat amb tots els departaments que no han impartit assignatures en cap curs escolar.
SELECT d.*, a.id_profesor FROM departamento d
	LEFT JOIN profesor p ON d.id=p.id_departamento
		LEFT JOIN asignatura a ON a.id_profesor=p.id_profesor
 WHERE a.id_profesor IS NULL
 GROUP BY d.nombre;

-- --------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- Consultes resum:

-- 1. Retorna el nombre total d'alumnes que hi ha.
SELECT COUNT(p.id) AS alumnos FROM persona p; 

-- 2. Calcula quants alumnes van néixer en 1999.
SELECT COUNT(p.id) AS alumnos FROM persona p
WHERE YEAR(p.fecha_nacimiento) = 1999; 

-- 3. Calcula quants professors/es hi ha en cada departament. 
-- El resultat només ha de mostrar dues columnes, una amb el nom del departament i una altra amb el nombre de professors/es que hi ha en aquest departament. 
-- El resultat només ha d'incloure els departaments que tenen professors/es associats i haurà d'estar ordenat de major a menor pel nombre de professors/es.
SELECT d.nombre AS departamento, COUNT(p.id_departamento) AS profesores
FROM departamento d, profesor p
WHERE d.id = p.id_departamento
GROUP BY d.nombre
ORDER BY profesores;

-- 4. Retorna un llistat amb tots els departaments i el nombre de professors/es que hi ha en cadascun d'ells. 
-- Tingui en compte que poden existir departaments que no tenen professors/es associats. Aquests departaments també han d'aparèixer en el llistat.
SELECT d.nombre AS departamento, COUNT(p.id_profesor) AS profesores FROM departamento d
LEFT JOIN profesor p ON p.id_departamento = d.id  
GROUP BY d.id;

-- 5. Retorna un llistat amb el nom de tots els graus existents en la base de dades i el nombre d'assignatures que té cadascun. 
-- Tingues en compte que poden existir graus que no tenen assignatures associades. Aquests graus també han d'aparèixer en el llistat. 
-- El resultat haurà d'estar ordenat de major a menor pel nombre d'assignatures.
SELECT g.nombre AS grado, COUNT(a.id_grado) AS asignaturas FROM grado g
LEFT JOIN asignatura a ON a.id_grado = g.id  
GROUP BY g.id
ORDER BY asignaturas DESC;

-- 6. Retorna un llistat amb el nom de tots els graus existents en la base de dades i el nombre d'assignatures que té cadascun, 
-- dels graus que tinguin més de 40 assignatures associades.
SELECT g.nombre AS grado, COUNT(a.id_grado) AS asignaturas FROM grado g
	LEFT JOIN asignatura a ON a.id_grado = g.id  
GROUP BY g.id
HAVING asignaturas > 40
ORDER BY asignaturas DESC;

-- 7. Retorna un llistat que mostri el nom dels graus i la suma del nombre total de crèdits que hi ha per a cada tipus d'assignatura. 
-- El resultat ha de tenir tres columnes: nom del grau, tipus d'assignatura i la suma dels crèdits de totes les assignatures que hi ha d'aquest tipus.
SELECT g.nombre AS grado, a.tipo, SUM(a.creditos) AS creditos, COUNT(a.id) AS asignaturas FROM grado g
LEFT JOIN asignatura a ON a.id_grado = g.id  
GROUP BY a.tipo, g.nombre
ORDER BY creditos DESC;

-- 8. Retorna un llistat que mostri quants alumnes s'han matriculat d'alguna assignatura en cadascun dels cursos escolars. 
-- El resultat haurà de mostrar dues columnes, una columna amb l'any d'inici del curs escolar i una altra amb el nombre d'alumnes matriculats.
SELECT c.anyo_inicio, c.anyo_fin, COUNT(a.id_alumno) AS alumnos FROM curso_escolar c
LEFT JOIN alumno_se_matricula_asignatura a ON a.id_curso_escolar = c.id
GROUP BY a.id_curso_escolar, c.anyo_inicio, c.anyo_fin
ORDER BY alumnos DESC, c.anyo_inicio ASC;  

-- 9. Retorna un llistat amb el nombre d'assignatures que imparteix cada professor/a. 
-- El llistat ha de tenir en compte aquells professors/es que no imparteixen cap assignatura. 
-- El resultat mostrarà cinc columnes: id, nom, primer cognom, segon cognom i nombre d'assignatures. 
-- El resultat estarà ordenat de major a menor pel nombre d'assignatures.
SELECT p.id, p.nombre, p.apellido1, p.apellido2, COUNT(a.id) AS asignaturas FROM persona p
	RIGHT JOIN profesor pr ON pr.id_profesor = p.id 
		LEFT JOIN asignatura a ON pr.id_profesor = a.id_profesor
GROUP BY p.id
ORDER BY asignaturas DESC;

-- 10. Retorna totes les dades de l'alumne/a més jove.
SELECT p.* FROM persona p
WHERE p.fecha_nacimiento = (SELECT MAX(fecha_nacimiento) 
	FROM persona WHERE id NOT IN (SELECT id_profesor 
		FROM profesor));

-- 11. Retorna un llistat amb els professors/es que tenen un departament associat i que no imparteixen cap assignatura.
SELECT pr.id_profesor FROM profesor pr
WHERE  pr.id_departamento IS NOT NULL AND
	 pr.id_profesor NOT IN (SELECT id_profesor FROM asignatura 
		WHERE id_profesor IS NOT NULL)
        ORDER BY pr.id_profesor; 