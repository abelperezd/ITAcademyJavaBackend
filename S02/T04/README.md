# Tasca S2.04: Estructura de dades - MongoDB queries

## Descripci�
- S'ha d'entregar en un mateix fitxer .js amb el codi ofuscat (cada sent�ncia en una l�nia).
- Si ho desitges, pots lliurar tamb� un altre fitxer que no tingui el codi ofuscat i que inclogui les teves anotacions en les consultes.

Tenim una col�lecci� d'Objectes Restaurant a la ciutat de Nova York, i necessitem algunes consultes... pots ajudar-nos?

1. Escriu una consulta per mostrar tots els documents en la col�lecci� Restaurants.
2. Escriu una consulta per mostrar el restaurant_id, name, borough i cuisine per tots els documents en la col�lecci� Restaurants.
3. Escriu una consulta per mostrar el restaurant_id, name, borough i cuisine, per� exclou el camp _id per tots els documents en la col�lecci� Restaurants.
4. Escriu una consulta per mostrar restaurant_id, name, borough i zip code, per� exclou el camp _id per tots els documents en la col�lecci� Restaurants.
5. Escriu una consulta per mostrar tots els restaurants que estan en el Bronx.
6. Escriu una consulta per mostrar els primers 5 restaurants que estan en el Bronx.
7. Escriu una consulta per mostrar el pr�xim 5 restaurants despr�s de saltar els primers 5 del Bronx.
8. Escriu una consulta per trobar els restaurants que tenen un score de m�s de 90.
9. Escriu una consulta per trobar els restaurants que tenen un score de m�s de 80 per� menys que 100.
10. Escriu una consulta per trobar els restaurants que es localitzen en valor de latitud menys de -95.754168.
11. Escriu una consulta de MongoDB per a trobar els restaurants que no preparen cap cuisine de 'American' i la seva qualificaci� �s superior a 70 i latitud inferior a -65.754168.
12. Escriu una consulta per trobar els restaurants que no preparen cap cuisine de 'American' i van aconseguir un marcador m�s de 70 i localitzat en la longitud menys que -65.754168. Nota: Fes aquesta consulta sense utilitzar $and operador.
13. Escriu una consulta per trobar els restaurants que no preparen cap cuisine de 'American' i van obtenir un punt de grau 'A' no pertany a Brooklyn. S'ha de mostrar el document segons la cuisine en ordre descendent.
14. Escriu una consulta per trobar el restaurant_id, name, borough i cuisine per a aquells restaurants que contenen 'Wil' com les tres primeres lletres en el seu nom.
15. Escriu una consulta per trobar el restaurant_id, name, borough i cuisine per a aquells restaurants que contenen 'ces' com les �ltimes tres lletres en el seu nom.
16. Escriu una consulta per trobar el restaurant_id, name, borough i cuisine per a aquells restaurants que contenen 'Reg' com tres lletres en algun lloc en el seu nom.
17. Escriu una consulta per trobar els restaurants que pertanyen al Bronx i van preparar qualsevol plat americ� o xin�s.
18. Escriu una consulta per trobar el restaurant_id, name, borough i cuisine per a aquells restaurants que pertanyen a Staten Island o Queens o Bronx o Brooklyn.
19. Escriu una consulta per trobar el restaurant_id, name, borough i cuisine per a aquells restaurants que no pertanyen a Staten Island o Queens o Bronx o Brooklyn.
20. Escriu una consulta per trobar el restaurant_id, name, borough i cuisine per a aquells restaurants que aconsegueixin un marcador que no �s m�s de 10.
21. Escriu una consulta per trobar el restaurant_id, name, borough i cuisine per a aquells restaurants que preparen peix excepte 'American' i 'Chinees' o el name del restaurant comen�a amb lletres 'Wil'.
22. Escriu una consulta per trobar el restaurant_id, name, i grades per a aquells restaurants que aconsegueixin un grau "A" i un score 11 en dades d'estudi ISODate "2014-08-11T00:00:00Z".
23. Escriu una consulta per trobar el restaurant_id, name i grades per a aquells restaurants on el 2n element de varietat de graus cont� un grau de "A" i marcador 9 sobre un ISODate "2014-08-11T00:00:00Z".
24. Escriu una consulta per trobar el restaurant_id, name, adre�a i ubicaci� geogr�fica per a aquells restaurants on el segon element del array coord cont� un valor que �s m�s de 42 i fins a 52.
25. Escriu una consulta per organitzar el nom dels restaurants en ordre ascendent juntament amb totes les columnes.
26. Escriu una consulta per organitzar el nom dels restaurants en ordre descendent juntament amb totes les columnes.
27. Escriu una consulta per organitzar el nom de la cuisine en ordre ascendent i pel mateix barri de cuisine. Ordre descendent.
28. Escriu una consulta per saber tant si totes les direccions contenen el carrer o no.
29. Escriu una consulta que seleccionar� tots els documents en la col�lecci� de restaurants on el valor del camp coord �s Double.
30. Escriu una consulta que seleccionar� el restaurant_id, name i grade per a aquells restaurants que retornin 0 com a resta despr�s de dividir el marcador per 7.
31. Escriu una consulta per trobar el name de restaurant, borough, longitud i altitud i cuisine per a aquells restaurants que contenen 'mon' com tres lletres en algun lloc del seu nom.
32. Escriu una consulta per trobar el name de restaurant, borough, longitud i latitud i cuisine per a aquells restaurants que contenen 'Mad' com primeres tres lletres del seu nom.