# Tasca S1.06: Generics

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

## Nivell 2
### Exercici 1
Modifica l'exercici anterior de manera que un dels arguments del mètode genèric no sigui genèric.

### Exercici 2
Modifica l'apartat anterior de manera que els arguments del mètode genèric siguin una llista d'arguments de variable indefinida.

## Nivell 3
### Exercici 1
Per fer aquest exercici necessites una interfície anomenada Telefon i tres classes: Smartphone, Generica i la Principal.

La interfície Telefon ha de tenir un mètode anomenat trucar(). La classe Smartphone ha d’implementar Telefon, i a més del mètode trucar(), també ha de tenir el mètode ferFotos(). 

La classe Generica ha de tenir dos mètodes genèrics, el primer ha de rebre un tipus d’argument limitat per la interfície Telefon i el segon ha de rebre un argument limitat per la classe Smartphone. Des d’aquests dos mètodes crida els mètodes pertinents de Telefon i Smartphone. En el main() de la classe Principal, passa un objecte de la classe Smartphone als dos mètodes genèrics de la classe Generica.

El mètode limitat per la interfície Telefon, de la classe Generica, pot cridar al mètode ferFotos()?