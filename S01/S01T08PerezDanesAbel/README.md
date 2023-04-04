# Tasca S1.08: Lambdas

## Descripci�
Practica exclusiva de les lambdes, un concepte dif�cil d'entendre per� molt �til un cop assolit.
- Utilitza per a tots els exercicis Eclipse o IntelliJ.
- No oblidis posar sempre les classes Java dins de packages.
- Pots construir projectes Maven, Gradle o nom�s Java.

## Nivell 1
Per a tots els exercicis s'ha d'utilitzar l'API de Java Lambdas and Streams de Java 8+. 

### Exercici 1
A partir d�una llista de Strings, escriu un m�tode que retorna una llista de totes les cadenes que contenen la lletra �o�. Imprimeix el resultat.

### Exercici 2
Has de fer el mateix que en el punt anterior, per� ara, el m�tode ha de retornar una llista amb els Strings que a m�s de contenir la lletra �o� tamb� tenen m�s de 5 lletres. Imprimeix el resultat.

### Exercici 3
Crea una llista amb els noms dels mesos de l�any. Imprimeix tots els elements de la llista amb una lambda.

### Exercici 4
Fer la mateixa impressi� del punt anterior, per� mitjan�ant method reference. 

### Exercici 5
Crea una Functional Interface amb un m�tode anomenat getPiValue() que ha de retornar un double. Des del main() de la classe principal, inst�ncia la interf�cie i assigna-li el valor 3.1415. Invoca el m�tode getPiValue() i imprimeix el resultat.

### Exercici 6
Crea una llista amb nombres i cadenes de text i ordena la llista amb les cadenes de m�s curta a m�s llarga.

### Exercici 7
Amb la llista de l�exercici anterior, ara ordena-la al rev�s, de cadena m�s llarga a m�s curta.

### Exercici 8
Crea una Functional Interface que contingui un m�tode anomenat reverse(). Aquest m�tode ha de rebre i ha de retornar un String. En el main() de la classe principal, injecta a la interf�cie creada mitjan�ant una lambda, el cos del m�tode, de manera que torni la mateixa cadena que rep com a par�metre per� al rev�s. Invoca la inst�ncia de la interf�cie passant-li una cadena i comprova si el resultat �s correcte.

## Nivell 2
### Exercici 1
Crea una llista de cadenes amb noms propis. Escriu un m�tode que retorna una llista de totes les cadenes que comencen amb la lletra 'A' (maj�scula) i  tenen exactament 3 lletres. Imprimeix el resultat. 

### Exercici 2
Programa un m�tode que retorna una cadena separada per comes, basada en una llista d�Integers. Cada element ha d�anar precedit per lletra �e� si el nombre �s parell, o per la lletra �o� si el nombre �s imparell. Per exemple, si la llista d�entrada �s (3, 55, 44), la sortida ha de ser �o3, o55, e44�. Imprimeix el resultat.

### Exercici 3
Crea una Functional Interface que contingui un m�tode anomenat operacio(). Aquest m�tode ha de retornar un float. Injecta a la interf�cie creada mitjan�ant una lambda, el cos del m�tode, de manera que es pugui transformar l�operaci� amb una suma, una resta, una multiplicaci� i una divisi�.

### Exercici 4
Crea una llista que contingui algunes cadenes de text i nombres.

Ordena-les per:
- Alfab�ticament pel primer car�cter. (Nota: charAt(0) retorna el codi num�ric del primer  car�cter) 
- Les cadenes que contenen una "e" primer, la resta de cadenes despr�s. Posa el codi directament a la lambda.  
- Modifica tots els elements de la llista que tenen una �a�. Modifica la �a� per un �4�.
- Mostra nom�s els elements que s�n num�rics. (Encara que estiguin guardats com Strings).   

## Nivell 3
### Exercici 1
Crea una classe Alumne amb els atributs: Nom, edat, curs i nota.

Omple una llista amb 10 alumnes

- Mostra per pantalla el nom i l�edat de cada alumne/a. 
- Filtra la llista per tots els alumnes que el seu nom comen�a per �a�. Assigna a aquests alumnes a una altra  llista i  mostra per pantalla la nova llista (tot  amb lambdes). 
- Filtra i mostra per pantalla els alumnes que tenen una nota de 5 o superior. 
- Filtra i mostra per pantalla els alumnes que tenen un nota de 5 o m�s, i que no s�n de PHP.  
- Mostra tots els alumnes que fan JAVA i s�n majors d�edat.