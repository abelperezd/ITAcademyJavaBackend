-- Llista el total de factures d'un client/a en un període determinat.
USE cul_d_ampolla;
SELECT v.data_venda, e.nom AS 'venedor', c.nom AS 'client', u.marca, u.preu
FROM venda v
	JOIN clients c
    ON v.clients_id = c.id 
		JOIN empleat e
        ON v.empleat_id = e.id
			JOIN ulleres u
            ON v.ulleres_id = u.id
WHERE v.data_venda BETWEEN '2022-01-14' AND '2022-01-24' && c.nom = 'Marta Rodríguez';

-- Llista els diferents models d'ulleres que ha venut un empleat/da durant un any.
USE cul_d_ampolla;
SELECT v.data_venda, e.nom AS 'empleat', u.marca, u.preu
FROM venda v
		JOIN empleat e
        ON v.empleat_id = e.id
			JOIN ulleres u
            ON v.ulleres_id = u.id
WHERE v.data_venda BETWEEN '2022-01-01' AND '2023-01-01' && e.id = 4;


-- Llista els diferents proveïdors que han subministrat ulleres venudes amb èxit per l'òptica.
SELECT 	DISTINCT p.nom, p.telefon, p.fax, p.NIF
FROM proveidors p
	JOIN ulleres u
    ON p.id = u.proveidors_id
		JOIN venda v
        ON p.id = v.ulleres_id
