## Descripci�
- Utilitza per a tots els exercicis Eclipse o IntelliJ.
- No oblidis posar sempre les classes Java dins de packages.
- Pots construir projectes Maven, Gradle o nom�s Java.

## Nivell 1
#### Exercici 1
Crea una classe anomenada Month amb un atribut "name" (que emmagatzemar� el nom del mes de l'any). Afegeix 11 objectes Month (cadascun amb el seu atribut diferent) en un ArrayList, a excepci� de l'objecte amb atribut "Agost". Despr�s, efectua la inserci� en el lloc que correspon a aquest mes i demostra que l�ArrayList mant� l'ordre correcte.

Converteix l�ArrayList de l�exercici anterior en un HashSet i assegura�t que no permet duplicats.

Recorre la llista amb un for i amb un iterador.

#### Exercici 2
Crea i emplena un List<Integer>. 

Crea un segon List<Integer> i insereix a la segona llista els elements de la primera en ordre invers. 

Empra els objectes ListIterator per a llegir els elements de la primera llista i inserir-los en la segona.

#### Exercici 3
Donat el fitxer countrties.txt (revisa l'apartat recursos) que cont� pa�sos i capitals. El programa ha de llegir el fitxer i guardar les dades en un HashMap<String, String>. El programa demana el nom de l�usuari/�ria, i despr�s ha de mostrar un pa�s de forma aleat�ria, guardat en el HashMap. Es tracta de qu� l�usuari/�ria ha d�escriure el nom de la capital del pa�s en q�esti�. Si l�encerta se li suma un punt. Aquesta acci� es repeteix 10 vegades. Un cop demanades les capitals de 10 pa�sos de forma aleat�ria, llavors s�ha de guardar en un fitxer anomenat classificacio.txt, el nom de l�usuari/�ria i la seva puntuaci�.

## Nivell 2
### Exercici 1
Crea una classe anomenada Restaurant amb dos atributs: nom(String) i puntuaci�(int). Implementa els m�todes necessaris perqu� no es puguin introduir objectes Restaurant amb el mateix nom i la mateixa puntuaci� en un HashSet creat en el main() de l�aplicaci�.

### Exercici 2
Utilitzant la classe del programa anterior, crea la implementaci� necess�ria perqu� els objectes de la classe Restaurant estiguin ordenats per nom i per puntuaci� en ordre ascendent. 

## Nivell 3
### Exercici 1
Crea una aplicaci� capa� de llegir un fitxer CSV. Aquest fitxer t� 3 camps: nom, cognom i DNI, per cada registre. Es tracta d�ordenar les persones llegides del fitxer, mitjan�ant el seu nom, cognom o DNI. Pots fer servir la llista que creguis m�s adient.

La classe Persona t� 3 atributs: 
- nom
- cognom
- DNI

La classe principal t� el seg�ent men�:

1. Introduir persona.
2. Mostrar les persones ordenades per nom (A-Z).
3. Mostrar les persones ordenades per nom (Z-A).
4. Mostrar les persones ordenades per cognoms (A-Z).
5. Mostrar les persones ordenades per cognoms (Z-A).
6. Mostrar les persones ordenades per DNI (1-9).
7. Mostrar les persones ordenades per DNI (9-1).
0. Sortir.

El programa haur� de llistar les persones com el seg�ent exemple:

___Nom___ ____Cognoms___ __NIF__ 
Andreu          Ballestero Llenas  34835767J 
Miquel          Bayona Font           48743957B 
Guillem         Capdevila Riu        33957834J 
Albert          Carbonell Ferrer      77364986R
Ferran          Casas Coderch        23047848P
Maria           Casellas Fuste          47102244S
Genis           Ciutat Vendrell         39718459N