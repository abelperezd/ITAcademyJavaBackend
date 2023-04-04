# Tasca S2.01: Estructura de dades - MySQL

## Descripci�
Per a cada base de dades ha de pujar-se el seg�ent:

- Model Relacional amb el disseny de la base de dades. Si ho desitges, pots utilitzar draw.io, dbdiagram.io, Mysql Workbench o qualsevol altra eina que et permeti dibuixar l'estructura i exportar-la en format png o jpg (per a pujar-la al repositori). Et recomanem especialment genmymodel.com.
- Script .sql de creaci� i c�rrega de la base de dades.

## Nivell 1

### Exercici 1 - �ptica
- En primer lloc, l'�ptica vol saber quin �s el prove�dor de cadascuna de les ulleres. En concret vol saber de cada prove�dor: El nom, l'adre�a (carrer, n�mero, pis, porta, ciutat, codi postal i pa�s), tel�fon, fax, NIF.
- La pol�tica de compres de l'�ptica es basa que les ulleres d'una marca es compraran a un �nic prove�dor (aix� en podr� treure m�s bons preus), per� poden comprar ulleres de diverses marques a un prove�dor. De les ulleres vol saber: La marca, la graduaci� de cadascun dels vidres, el tipus de muntura (flotant, pasta o met�l�lica), el color de la muntura, el color de cada vidre, el preu.
- Dels clients/es vol emmagatzemar: El nom, l'adre�a postal, el tel�fon, el correu electr�nic, la data de registre.
- Quan arriba un/a client/a nou, emmagatzemar el/la client/a que li ha recomanat l'establiment (sempre que alg� li hagi recomanat).
- El nostre sistema haur� d�indicar qui ha sigut l�empleat/da que ha venut cada ullera.

### Exercici 2 - Pizzeria
T�han contractat per a dissenyar una web que permeti fer comandes de menjar a domicili per Internet.
- Tingues en compte les seg�ents indicacions per a modelar com seria la base de dades del projecte:
- Per a cada client/a emmagatzemem un identificador �nic: Nom, cognoms, adre�a, codi postal, localitat, prov�ncia, n�mero de tel�fon.
- Una persona pot realitzar moltes comandes, per� una �nica comanda nom�s pot ser realitzat per una �nica persona. De cada comanda s'emmagatzema un identificador �nic: Data/hora, si la comanda �s per a repartiment a domicili o per a recollir en botiga, la quantitat de productes que s'han seleccionat de cada tipus, el preu total.

Una comanda pot constar d'un o diversos productes.
- Els productes poden ser pizzes, hamburgueses i begudes. De cada producte s'emmagatzema un identificador �nic: Nom, descripci�, imatge, preu.

En el cas de les pizzes existeixen diverses categories que poden anar canviant de nom al llarg de l'any. Una pizza nom�s pot estar dins d'una categoria, per� una categoria pot tenir moltes pizzes.
- De cada categoria s'emmagatzema un identificador �nic i un nom. Una comanda �s gestionada per una �nica botiga i una botiga pot gestionar moltes comandes. De cada botiga s'emmagatzema un identificador �nic: Adre�a, codi postal, localitat, prov�ncia.
- En una botiga poden treballar molts empleats/des i un empleat/da nom�s pot treballar en una botiga. De cada empleat/da, s'emmagatzema un identificador �nic: Nom, cognoms, NIF, Tel�fon.
- Si treballa com a cuiner/a o repartidor/a. Per a les comandes de repartiment a domicili interessa guardar qui �s el repartidor/a que fa el lliurament de la comanda i la data/hora del moment del lliurament.

## Nivell 2
### Exercici 1 - Youtube
- De cada usuari/�ria guardem un identificador �nic: Email, password, nom d'usuari/�ria, data de naixement, sexe, pa�s, codi postal.
- Un usuari/�ria publica v�deos. De cada v�deo guardem un identificador �nic: Un t�tol, una descripci�, una grand�ria, el nom de l'arxiu de v�deo, durada del v�deo, un thumbnail, el nombre de reproduccions, el n�mero de likes, el n�mero de dislikes.
- Un v�deo pot tenir tres estats diferents: p�blic, ocult i privat. Un v�deo pot tenir moltes etiquetes. Una etiqueta s'identifica per un identificador �nic i un nom d'etiqueta. Interessa guardar qui �s l'usuari/�ria que publica el v�deo i en quina data/hora el fa.
- Un usuari/�ria pot crear un canal. Un canal t� un identificador �nic: Un nom, una descripci�, una data de creaci�.
- Un usuari/�ria es pot subscriure als canals d'altres usuaris/es. Un usuari/�ria pot donar-li un like o un dislike a un v�deo una �nica vegada. Caldr� portar un registre dels usuaris/es que li han donat like i dislike a un determinat v�deo i en quina data/hora ho van fer.
- Un usuari/�ria pot crear playlists amb els v�deos que li agraden. Cada playlist t� un identificador �nic: Un nom, una data de creaci�, un estat que indica que pot ser p�blica o privada.
- Un usuari/�ria pot escriure comentaris en un v�deo determinat. Cada comentari est� identificat per un identificador �nic: El text del comentari, la data/hora en la qual es va realitzar.
- Un usuari/�ria pot marcar un comentari com m'agrada o no m'agrada. Caldr� portar un registre dels usuaris/es que han marcat un comentari com m'agrada/no m'agrada, i en quina data/hora ho van fer.

## Nivell 3
### Exercici 1 - Spotify
- Existeixen dos tipus d'usuaris/es: free i  pr�mium. De cada usuari/�ria guardem un identificador �nic: Email, password, nom d'usuari/�ria, data de naixement, sexe, pa�s, codi postal.

- Els usuaris/es pr�mium fan subscripcions. Les dades necess�ries que caldr� guardar per a cada subscripci� s�n: Data d'inici de la subscripci�, data de renovaci� del servei, una forma de pagament, que pot ser mitjan�ant targeta de cr�dit o PayPal.

- De les targetes de cr�dit guardem el n�mero de targeta, mes i any de caducitat i el codi de seguretat. Dels usuaris/es que paguen amb PayPal guardem el nom d'usuari/�ria de PayPal. Ens interessa portar un registre de tots els pagaments que un usuari/�ria pr�mium ha anat realitzant durant el per�ode que est� subscrit. De cada pagament es guarda: La data, un n�mero d'ordre (que �s �nic), un total.

- Un usuari/�ria pot crear moltes playlists. De cada playlist guardem: Un t�tol, el nombre de can�ons que cont�, un identificador �nic, una data de creaci�.

- Quan un usuari/�ria esborra una playlist no s'esborra del sistema, sin� que es marca com que ha estat eliminada. D'aquesta manera l'usuari/�ria pot tornar a recuperar les seves playlists en cas que les hagi eliminat per error. �s necessari emmagatzemar la data en la qual la playlist ha estat marcada com eliminada.

- Podem dir que existeixen dos tipus de playlists: actives i esborrades. Una playlist que est� activa pot ser compartida amb altres usuaris/es, aix� vol dir que altres usuaris/es poden afegir can�ons en ella. En una llista compartida ens interessa saber quin usuari/�ria ha estat el que ha afegit cada can�� i en quina data ho va fer.
- Una can�� nom�s pot pert�nyer a un �nic �lbum. Un �lbum pot contenir moltes can�ons. Un �lbum ha estat publicat per un/a �nic/a artista. Un/a artista pot haver publicat molts �lbums. De cada can�� guardem un identificador �nic: Un t�tol, una durada, el nombre de vegades que ha estat reprodu�da pels usuaris/es de Spotify.

- De cada �lbum guardem un identificador �nic: T�tol, any de publicaci�, una imatge amb la portada.
- De cada artista guardem un identificador �nic: Nom, una imatge de l'artista

- Un usuari/�ria pot seguir a molts/es artistes. Un/a artista pot estar relacionat/da amb altres artistes que facin m�sica semblant. De manera que Spotify pugui mostrar-nos un llistat d'artistes relacionats/des amb els artistes que ens agraden. Tamb� ens interessa guardar quins s�n els �lbums i les can�ons favorites d'un usuari/�ria. Un usuari/�ria pot seleccionar molts �lbums i moltes can�ons com a favorites.

NOTA: Per crear l'estructura de la base de dades, omplirem les col�leccions amb dades de prova per tal de verificar que les relacions s�n correctes.

## Recursos
Per a verificar que el teu disseny �s correcte, efectua les seg�ents consultes i comprova que retornen resultats correctes:

�ptica:
- Llista el total de factures d'un client/a en un per�ode determinat.
- Llista els diferents models d'ulleres que ha venut un empleat/da durant un any.
- Llista els diferents prove�dors que han subministrat ulleres venudes amb �xit per l'�ptica.

Pizzeria:
- Llista quants productes de categoria 'Begudes' s'han venut en una determinada localitat.
- Llista quantes comandes ha efectuat un determinat empleat/da.