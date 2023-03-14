# Tasca S1.07: Annotations

## Descripció
- Utilitza per a tots els exercicis Eclipse o IntelliJ.
- No oblidis posar sempre les classes Java dins de packages.
- Pots construir projectes Maven, Gradle o només Java.

## Nivell 1
Crea una classe anomenada NoGenericMethods que emmagatzemi tres objectes del mateix tipus, juntament amb els mètodes per a emmagatzemar i extreure aquests objectes i un constructor per a inicialitzar els tres. Comprova que els arguments es poden posar en qualsevol posició en la crida al constructor.

### Exercici 1
Crea una classe anomenada Persona amb els atributs nom, cognom i edat. Després crea una classe anomenada GenericMethods amb un mètode genèric que accepti tres arguments de tipus genèric. Aquest mètode només ha d’imprimir per pantalla els arguments que ha rebut. Al main() de la classe principal, crida el mètode genèric amb diferents tipus de paràmetres.

Exemple: un objecte de la classe Persona, un String i un tipus primitiu.

D’aquesta manera has comprovat que se li pot passar qualsevol tipus de paràmetre i en qualsevol ordre.

### Exercici 2
Afegeix a les classes filles alguns mètodes obsolets (deprecated), i utilitza l’anotació corresponent. Invoca des d'una classe externa els mètodes obsolets, suprimint mitjançant l'anotació corresponent els “warnings” per ser obsolets.

## Nivell 2
### Exercici 1
Crea una anotació personalitzada que ha de permetre serialitzar un objecte Java en un fitxer JSON. L’anotació ha de rebre el directori on es col·locarà el fitxer resultant.

## Nivell 3
### Exercici 1
Afegeix la possibilitat que l'anotació creada en el nivell anterior sigui registrada per la Virtual Machine en temps d'execució. Demostra que s'executa la lectura de l'annotation fent servir Java Reflection.