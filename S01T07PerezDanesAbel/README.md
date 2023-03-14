# Tasca S1.07: Annotations

## Descripci�
- Utilitza per a tots els exercicis Eclipse o IntelliJ.
- No oblidis posar sempre les classes Java dins de packages.
- Pots construir projectes Maven, Gradle o nom�s Java.

## Nivell 1
Crea una classe anomenada NoGenericMethods que emmagatzemi tres objectes del mateix tipus, juntament amb els m�todes per a emmagatzemar i extreure aquests objectes i un constructor per a inicialitzar els tres. Comprova que els arguments es poden posar en qualsevol posici� en la crida al constructor.

### Exercici 1
Crea una classe anomenada Persona amb els atributs nom, cognom i edat. Despr�s crea una classe anomenada GenericMethods amb un m�tode gen�ric que accepti tres arguments de tipus gen�ric. Aquest m�tode nom�s ha d�imprimir per pantalla els arguments que ha rebut. Al main() de la classe principal, crida el m�tode gen�ric amb diferents tipus de par�metres.

Exemple: un objecte de la classe Persona, un String i un tipus primitiu.

D�aquesta manera has comprovat que se li pot passar qualsevol tipus de par�metre i en qualsevol ordre.

### Exercici 2
Afegeix a les classes filles alguns m�todes obsolets (deprecated), i utilitza l�anotaci� corresponent. Invoca des d'una classe externa els m�todes obsolets, suprimint mitjan�ant l'anotaci� corresponent els �warnings� per ser obsolets.

## Nivell 2
### Exercici 1
Crea una anotaci� personalitzada que ha de permetre serialitzar un objecte Java en un fitxer JSON. L�anotaci� ha de rebre el directori on es col�locar� el fitxer resultant.

## Nivell 3
### Exercici 1
Afegeix la possibilitat que l'anotaci� creada en el nivell anterior sigui registrada per la Virtual Machine en temps d'execuci�. Demostra que s'executa la lectura de l'annotation fent servir Java Reflection.