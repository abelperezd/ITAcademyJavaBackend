# Tasca S2.03: Estructura de dades - MongoDB

## Descripci�
Per a cada base de dades ha de pujar-se el seg�ent:

- Diagrama d'estructura (Model Tree o Model Relationships) amb el disseny de la base de dades. Si ho desitges, pots utilitzar draw.io o qualsevol altra eina que et permeti dibuixar l'estructura i exportar-la en format png o jpg (per a pujar-la al repositori).
- Script .js de creaci� i c�rrega de la base de dades.

## Nivell 1

### Exercici 1 - �ptica
 Una �ptica, anomenada �Cul d'Ampolla�, vol informatitzar la gesti� dels clients/es i vendes d'ulleres.
- En primer lloc, l'�ptica vol saber quin �s el prove�dor de cadascuna de les ulleres. En concret vol saber de cada prove�dor:
	- El nom
	- L'adre�a (carrer, n�mero, pis, porta, ciutat, codi postal i pa�s)
	- Tel�fon
	- Fax
	- NIF.

- La pol�tica de compres de l'�ptica es basa que les ulleres d'una marca es compraran a un �nic prove�dor (aix� en podr� treure m�s bons preus), per� poden comprar ulleres de diverses marques a un prove�dor. De les ulleres vol saber:
	- La marca.
	- La graduaci� de cadascun dels vidres.
	- El tipus de muntura (flotant, pasta o met�l�lica).
	- El color de la muntura.
	- El color de cada vidre.
	- El preu.

- Dels clients/es vol emmagatzemar:
	- El nom.
	- L'adre�a postal.
	- El tel�fon.
	- El correu electr�nic.
	- La data de registre.
	- Quan arriba un/a client/a nou, emmagatzemar el/la client/a que li ha recomanat l'establiment (sempre que alg� li hagi recomanat).
	- El nostre sistema haur� d�indicar qui ha sigut l�empleat/da que ha venut cada ullera.

### Exercici 2 - Pizzeria
T�han contractat per a dissenyar una web que permeti fer comandes de menjar a domicili per Internet.
- Tingues en compte les seg�ents indicacions per a modelar com seria la base de dades del projecte:
- Per a cada client/a emmagatzemem un identificador �nic:
	- Nom.
	- Cognoms.
	- Adre�a.
	- Codi postal.
	- Localitat.
	- Prov�ncia.
	- N�mero de tel�fon.
	- Les dades de localitat i prov�ncia estaran emmagatzemats en taules separades. Sabem que una localitat pertany a una �nica prov�ncia, i que una prov�ncia pot tenir moltes localitats. Per a cada localitat emmagatzemem un identificador �nic i un nom. Per a cada prov�ncia emmagatzemem un identificador �nic i un nom.

- Una persona pot realitzar moltes comandes, per� una �nica comanda nom�s pot ser realitzat per una �nica persona. De cada comanda s'emmagatzema un identificador �nic:
	- Data/hora.
	- Si la comanda �s per a repartiment a domicili o per a recollir en botiga.
	- La quantitat de productes que s'han seleccionat de cada tipus.
	- El preu total.

Una comanda pot constar d'un o diversos productes.

- Els productes poden ser pizzes, hamburgueses i begudes. De cada producte s'emmagatzema un identificador �nic:
	- Nom.
	- Descripci�.
	- Imatge.
	- Preu.

En el cas de les pizzes existeixen diverses categories que poden anar canviant de nom al llarg de l'any. Una pizza nom�s pot estar dins d'una categoria, per� una categoria pot tenir moltes pizzes.

- De cada categoria s'emmagatzema un identificador �nic i un nom. Una comanda �s gestionada per una �nica botiga i una botiga pot gestionar moltes comandes. De cada botiga s'emmagatzema un identificador �nic:
	- Adre�a.
	- Codi postal.
	- Localitat.
	- Prov�ncia.

- En una botiga poden treballar molts empleats/des i un empleat/da nom�s pot treballar en una botiga. De cada empleat/da, s'emmagatzema un identificador �nic:
	- Nom.
	- Cognoms.
	- NIF.
	- Tel�fon.
	- Si treballa com a cuiner/a o repartidor/a. Per a les comandes de repartiment a domicili interessa guardar qui �s el repartidor/a que fa el lliurament de la comanda i la data/hora del moment del lliurament.

## Nivell 2
### Exercici 1 - Youtube
Tractarem de fer un model senzill de com seria la base de dades per a una versi� redu�da de YouTube.

- De cada usuari/�ria guardem un identificador �nic:
	- Email.
	- Password.
	- Nom d'usuari/�ria.
	- Data de naixement.
	- Sexe.
	- Pa�s.
	- Codi postal.

- Un usuari/�ria publica v�deos. De cada v�deo guardem un identificador �nic:
	- Un t�tol.
	- Una descripci�.
	- Una grand�ria.
	- El nom de l'arxiu de v�deo.
	- Durada del v�deo.
	- Un thumbnail.
	- El nombre de reproduccions.
	- El n�mero de likes.
	- El n�mero de dislikes.

- Un v�deo pot tenir tres estats diferents: p�blic, ocult i privat. Un v�deo pot tenir moltes etiquetes. Una etiqueta s'identifica per un identificador �nic i un nom d'etiqueta. Interessa guardar qui �s l'usuari/�ria que publica el v�deo i en quina data/hora el fa.

- Un usuari/�ria pot crear un canal. Un canal t� un identificador �nic:
	- Un nom.
	- Una descripci�.
	- Una data de creaci�.

- Un usuari/�ria es pot subscriure als canals d'altres usuaris/es. Un usuari/�ria pot donar-li un like o un dislike a un v�deo una �nica vegada. Caldr� portar un registre dels usuaris/es que li han donat like i dislike a un determinat v�deo i en quina data/hora ho van fer.

- Un usuari/�ria pot crear playlists amb els v�deos que li agraden. Cada playlist t� un identificador �nic:
	- Un nom.
	- Una data de creaci�.
	- Un estat que indica que pot ser p�blica o privada.

- Un usuari/�ria pot escriure comentaris en un v�deo determinat. Cada comentari est� identificat per un identificador �nic:
	- El text del comentari.
	- La data/hora en la qual es va realitzar.

- Un usuari/�ria pot marcar un comentari com m'agrada o no m'agrada. Caldr� portar un registre dels usuaris/es que han marcat un comentari com m'agrada/no m'agrada, i en quina data/hora ho van fer.

## Nivell 3
### Exercici 1 - Spotify
Tractarem de fer un model senzill de com seria la base de dades necess�ria per a Spotify.

- Existeixen dos tipus d'usuaris/es: free i  pr�mium. De cada usuari/�ria guardem un identificador �nic:
	- Email.
	- password.
	- Nom d'usuari/�ria.
	- Data de naixement.
	- Sexe.
	- Pa�s.
	- Codi postal.

- Els usuaris/es pr�mium fan subscripcions. Les dades necess�ries que caldr� guardar per a cada subscripci� s�n:
	- Data d'inici de la subscripci�.
	- Data de renovaci� del servei.
	- Una forma de pagament, que pot ser mitjan�ant targeta de cr�dit o PayPal.

- De les targetes de cr�dit guardem el n�mero de targeta, mes i any de caducitat i el codi de seguretat. Dels usuaris/es que paguen amb PayPal guardem el nom d'usuari/�ria de PayPal. Ens interessa portar un registre de tots els pagaments que un usuari/�ria pr�mium ha anat realitzant durant el per�ode que est� subscrit. De cada pagament es guarda:
	- La data.
	- Un n�mero d'ordre (que �s �nic).
	- Un total.

- Un usuari/�ria pot crear moltes playlists. De cada playlist guardem:
	- Un t�tol.
	- El nombre de can�ons que cont�.
	- Un identificador �nic.
	- Una data de creaci�.


- Quan un usuari/�ria esborra una playlist no s'esborra del sistema, sin� que es marca com que ha estat eliminada. D'aquesta manera l'usuari/�ria pot tornar a recuperar les seves playlists en cas que les hagi eliminat per error. �s necessari emmagatzemar la data en la qual la playlist ha estat marcada com eliminada.

- Podem dir que existeixen dos tipus de playlists: actives i esborrades. Una playlist que est� activa pot ser compartida amb altres usuaris/es, aix� vol dir que altres usuaris/es poden afegir can�ons en ella. En una llista compartida ens interessa saber quin usuari/�ria ha estat el que ha afegit cada can�� i en quina data ho va fer.
- Una can�� nom�s pot pert�nyer a un �nic �lbum. Un �lbum pot contenir moltes can�ons. Un �lbum ha estat publicat per un/a �nic/a artista. Un/a artista pot haver publicat molts �lbums. De cada can�� guardem un identificador �nic:
	- Un t�tol.
	- Una durada.
	- El nombre de vegades que ha estat reprodu�da pels usuaris/es de Spotify.

- De cada �lbum guardem un identificador �nic:
	- T�tol.
	- Any de publicaci�.
	- Una imatge amb la portada.

- De cada artista guardem un identificador �nic:
	- Nom.
	- Una imatge de l'artista


- Un usuari/�ria pot seguir a molts/es artistes. Un/a artista pot estar relacionat/da amb altres artistes que facin m�sica semblant. De manera que Spotify pugui mostrar-nos un llistat d'artistes relacionats/des amb els artistes que ens agraden. Tamb� ens interessa guardar quins s�n els �lbums i les can�ons favorites d'un usuari/�ria. Un usuari/�ria pot seleccionar molts �lbums i moltes can�ons com a favorites.


NOTA: Un cop creada les bases de dades, omplirem les taules amb dades de prova per tal de verificar que les relacions s�n correctes.