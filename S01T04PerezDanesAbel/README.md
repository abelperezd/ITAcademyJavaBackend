# Tasca S1.04: Testing

## Nivell 1: JUnit
### Exercici 1
- Crea una classe Java que insereixi en una llista ordenada els noms dels mesos de l'any.
- Verifica amb jUnit que la llista t� 12 posicions, que no �s nul�la i que en la seva posici� 8 cont� el nom 'agost'.

### Exercici 2
- Crea una classe anomenada CalculoDni que calculi la lletra del DNI en rebre el n�mero com a par�metre.
- Crea una classe jUnit que verifiqui el seu correcte funcionament, parametritzant-la perqu� el test rebi un espectre de dades ampli i validi si el c�lcul �s correcte per a 10 n�meros de DNI predefinits.

### Exercici 3
- Crea una classe amb un m�tode que llanci una ArrayIndexOutOfBoundsException.
- Verifica el seu correcte funcionament amb un test jUnit.

## Nivell 2: Hamcrest
### Exercici 1
Defineix un Matcher personalitzat per a Hamcrest que proporcioni el Matcher de longitud per a un String.

Volem usar la classe -->FeatureMatcher.

Amb FeatureMatcher podem ajustar un Matcher existent, decidir quin camp de l'Objecte prova ha de coincidir i proporcionar un missatge d'error agradable. El constructor de FeatureMatcher t� els seg�ents arguments en aquest ordre:
- El matcher que volem embolicar.
- Una descripci� de la funci� que provem.
- Una descripci� del possible mismatch (desajustament).

L'�nic m�tode que hem de sobreescriure �s featureValueOf (T actual), que retorna el valor que es passar� al m�tode match () / matchesSafely (). Utilitza el seu comparador personalitzat en una prova per a comprovar si la cadena "Mordor" t� una longitud de 8.

Ajusta la prova si �s necessari.


## Nivell 3: AssertJ
Crea les classes Java i/o els tests que les proven per a demostrar el seg�ent:
### Exercici 1
Una asserci� que demostri que el valor de dos objectes sencers �s igual, i una altra que indiqui que no ho �s.

### Exercici 2
Una asserci� que demostri que la refer�ncia a un objecte �s la mateixa que una altra, i una altra que indiqui que �s diferent.

### Exercici 3
Una asserci� que indiqui que dos arrays d'enters s�n id�ntics.

### Exercici 4
Crea un arrayList contenidor de diversos tipus d'objectes (crea'ls tamb�). Escriu una asserci� per a verificar l'ordre dels objectes en l'ArrayList segons han estat inserits.
- Ara verifica que la llista anterior cont� els objectes en qualsevol ordre.
- Verifica que, en la llista anterior, un dels objectes s'ha afegit nom�s una vegada. Deixa un dels elements sense afegir, i verifica que la llista no cont� aquest �ltim.

### Exercici 5
Crea un map i verifica que cont� una de les key que li afegeix.

### Exercici 6
Provoca una ArrayIndexOutOfBoundsException en una classe qualsevol. Crea una asserci� que validi que l'excepci� �s llan�ada quan correspon.

### Exercici 7
Crea un objecte Optional buit. Escriu l'asserci� correcta per a verificar que efectivament est� buit.