## Descripci�
- Utilitza per a tots els exercicis Eclipse o IntelliJ.
- No oblidis posar sempre les classes Java dins de packages.
- Es recomana crear per cada exercici un package de la seg�ent manera: n1exercici1, n1exercici2, n2exercici1, etc.
- Pots construir projectes Maven, Gradle o nom�s Java.

## Nivell 1
### Exercici 1
En un grup de m�sica hi ha diferents tipus d�instruments musicals. Hi ha instruments de vent, de corda i de percussi�.

Tots els instruments tenen com a atributs el seu nom, i el seu preu. A m�s, tenen un m�tode anomenat tocar(). Aquest, �s abstracte a la classe instrument i, per tant, s�ha d�implementar a les classes filles. Si s�est� tocant un instrument de vent, el m�tode ha de mostrar per consola: "Est� sonant un instrument de vent", si s�est� tocant un instrument de corda: �Est� sonant un instrument de corda� i si s�est� tocant un instrument de percussi�: �Est� sonant un instrument de percussi�.


El proc�s de c�rrega d'una classe nom�s t� lloc una vegada. Demostra que la c�rrega pot ser provocada per la creaci� de la primera inst�ncia d'aquesta classe o per l'acc�s a un membre est�tic d'aquesta. 

Cerca informaci� sobre els blocs d'inicialitzaci� i blocs est�tics en Java.

### Exercici 2
Crea una classe "Cotxe" amb els atributs: marca, model i pot�ncia. La marca ha de ser est�tic final, el model est�tic i la pot�ncia final. Demostra la difer�ncia entre els tres. N'hi ha algun que es pugui inicialitzar al constructor de la classe?

Afegeix dos m�todes a la classe �Cotxe�. Un m�tode est�tic anomenat frenar() i un altre no est�tic anomenat accelerar(). El m�tode accelerar ha de mostrar per consola: �El vehicle est� accelerant� i el m�tode frenar() ha de mostrar: �El vehicle est� frenant�. 

Demostra com invocar el m�tode est�tic i el no est�tic des del main() de la classe principal.

### Exercici 3
Explica�ns com ho has fet!

A m�s del codi que entregar�s per a resoldre aquest nivell, volem que ens l'expliquis i demostris com s'executa.

L'objectiu �s que practiquis el que ser� el teu dia a dia treballant integrat en un equip de desenvolupament on, peri�dicament, haur�s de detallar les teves propostes o justificar les decisions t�cniques que hagis pres.

Aquest exercici et permetr� treballar a ordenar idees i ser capa� de resumir i comunicar all� que consideris m�s rellevant per a la teva audi�ncia. A la IT Academy �s la persona encarregada de la mentoria, per� en el futur ser� l�equip de desenvolupament en el que t�integris.

Per aix�, et demanem que gravis un v�deo, que pots incloure en el mateix Repositori de Git on has d'entregar el codi, o en un altre diferent (en aquest cas, no t�oblidis d�incloure l�enlla�).

## Nivell 2
### Exercici 1
Crea una classe anomenada "Tel�fon" amb els atributs marca i model, i el m�tode trucar(). Aquest m�tode ha de rebre un String amb un n�mero de tel�fon. El m�tode ha de mostrar per consola un missatge dient que s�est� trucant al n�mero rebut per par�metre. 

Crea una interf�cie anomenada "Camera" amb el m�tode fotografiar(), i una altra interf�cie anomenada Rellotge amb el m�tode alarma().

Crea una classe anomenada "Smartphone" que sigui subclasse de "Tel�fon" i que a la vegada implementi les interf�cies "Camera" i "Rellotge".

El m�tode fotografiar() ha de mostrar per consola: �S�est� fent una foto� i el m�tode alarma() ha de mostrar: �Est� sonant l�alarma�.

Des del main() de l�aplicaci�, crea un objecte Smartphone i crida als m�todes anteriors.

## Nivell 3
### Exercici 1
En una redacci� de not�cies esportives tenen les not�cies classificades per esports: futbol, b�squet, tenis, F1 i motociclisme.

La redacci� pot tenir m�s d�un redactor, i de cadascun d�ells volem saber el seu nom, el DNI i el sou. Un cop assignat un DNI, aquest no podr� canviar mai. Tots els redactors tenen el mateix sou, i si en un futur l�empresa pot incrementar-lo, ho far� a tothom per igual. De moment el sou actual �s de 1500?�.

Cada redactor pot treballar en m�s d�una not�cia. Les not�cies han de tenir un titular, un text, una puntuaci� i un preu. En el moment de crear-se, el text ha d�estar buit.

A m�s, de les not�cies de futbol s�ha de saber a quina competici� fa refer�ncia(String), a quin club(String) i a quin jugador(String).

De les not�cies de b�squet s�ha d�indicar a quina competici� fa refer�ncia(String) i a quin club(String).

De les not�cies de tenis s�ha de saber de quina competici�(String) parlen i de quins tenistes(String).

De les not�cies d'F1 hem de saber a quina escuderia(String) fan refer�ncia.

De les not�cies de motociclisme s�ha d�indicar de quin equip(String) s�n.

Les not�cies es venen a diferents mitjans. Per saber el preu de cada not�cia hem d'implementar un m�tode que es diu calcularPreuNoticia(). 

A continuaci� s�explica com calcular el preu de cada not�cia:

Not�cies de futbol: 
- Preu inicial: 300?�
- Lliga de Campions: 100?�
- Bar�a o Madrid: 100?�
- Ferran Torres o Benzema: 50?�


Exemple: Una not�cia que parla d�un gol de Ferran Torres del Bar�a a la Lliga de Campions, t� un preu de 550?�.

Not�cies de b�squet:
- Preu inicial: 250?�
- Eurolliga: 75?�
- Bar�a o Madrid: 75?�

Not�cies de tenis:
- Preu inicial: 150?� 
- Federer, Nadal o Djokovic: 100?�

Not�cies d'F1:
- Preu inicial: 100?�
- Ferrari o Mercedes: 50?�

Not�cies de motociclisme:
- Preu inicial: 100?�
- Honda o Yamaha: 50?�

Per calcular les puntuacions de les not�cies se segueixen els seg�ents criteris:

Not�cies de futbol:
- 5 Punts.
- Lliga de Campions: 3 punts
- Lliga: 2 punts
- Bar�a o Madrid: 1 punt
- Ferran Torres o Benzema: 1 punt

Exemple: Una not�cia que parla d�un gol de Ferran Torres del Bar�a a la Lliga de Campions, t� una puntuaci� de 10 punts.

Not�cies de b�squet:
- 4 punts
- Eurolliga: 3 punts
- ACB: 2 punts
- Bar�a o Madrid: 1 punt

Not�cies de Tenis:
- 4 punts
- Federer, Nadal o Djokovic: 3 punts

Not�cies F1:
- 4 punts
- Ferrari o Mercedes: 2 punts

Not�cies de Motociclisme:
- 3 punts
- Honda o Yamaha: 3 punts

A la classe principal s�ha de fer un men� amb les seg�ents opcions:

1.- Introduir redactor.
2.- Eliminar redactor.
3.- Introduir not�cia a un redactor.
4.- Eliminar not�cia (ha de demanar redactor i titular de la not�cia).
5.- Mostrar totes les not�cies per redactor.
6.- Calcular puntuaci� de la not�cia.
7.- Calcular preu-not�cia.