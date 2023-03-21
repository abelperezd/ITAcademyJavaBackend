USE pizzeria;
-- Llista quants productes de categoria 'Begudes' s'han venut en una determinada localitat.
SELECT SUM(i.quantitat) AS 'begudes venudes a Barcelona, Barcelona'
FROM items i, productes p
WHERE i.producte_id = p.id AND p.categoria = 'beguda' 
AND i.comanda_id IN 
	(SELECT id FROM comandes c WHERE c.botiga_id IN 
		(SELECT id FROM botigues WHERE adreça_id IN 
		(SELECT id from adreces WHERE provincia = 'Barcelona')));
	
-- Llista quantes comandes ha efectuat un determinat empleat/da.
SELECT CONCAT (t.nom, ' ', t.cognoms) AS nom, COUNT(*) AS 'comandes realitzades'
FROM comandes c, treballadors t
WHERE c.treballador_id = t.id AND t.nom = 'Laura' AND t.cognoms = 'Fernandez'