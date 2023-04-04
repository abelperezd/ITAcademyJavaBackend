# Tasca S1.06: Generics

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

## Nivell 2
### Exercici 1
Modifica l'exercici anterior de manera que un dels arguments del m�tode gen�ric no sigui gen�ric.

### Exercici 2
Modifica l'apartat anterior de manera que els arguments del m�tode gen�ric siguin una llista d'arguments de variable indefinida.

## Nivell 3
### Exercici 1
Per fer aquest exercici necessites una interf�cie anomenada Telefon i tres classes: Smartphone, Generica i la Principal.

La interf�cie Telefon ha de tenir un m�tode anomenat trucar(). La classe Smartphone ha d�implementar Telefon, i a m�s del m�tode trucar(), tamb� ha de tenir el m�tode ferFotos(). 

La classe Generica ha de tenir dos m�todes gen�rics, el primer ha de rebre un tipus d�argument limitat per la interf�cie Telefon i el segon ha de rebre un argument limitat per la classe Smartphone. Des d�aquests dos m�todes crida els m�todes pertinents de Telefon i Smartphone. En el main() de la classe Principal, passa un objecte de la classe Smartphone als dos m�todes gen�rics de la classe Generica.

El m�tode limitat per la interf�cie Telefon, de la classe Generica, pot cridar al m�tode ferFotos()?