# Tasca S1.05: Java Utils

## Descripci�
Els exercicis dels 3 nivells han d'executar-se des de la l�nia de comandos, i no sols des de l'editor. Crea un fitxer anomenat �readme.txt� per explicar el comando a executar a cada exercici.
- Utilitza per a tots els exercicis Eclipse o IntelliJ.
- No oblidis posar sempre les classes Java dins de packages.
- Pots construir projectes Maven, Gradle o nom�s Java.

## Nivell 1
Es pot utilitzar Java exclusivament, o b� la llibreria Apache Commons IO si ho prefereixes.

### Exercici 1
Crea una classe que llisti alfab�ticament el contingut d'un directori rebut per par�metre.

### Exercici 2
Afegeix a la classe de l�exercici anterior, la funcionalitat de llistar un arbre de directoris amb el contingut de tots els seus nivells (recursivament) de manera que s'imprimeixin en pantalla en ordre alfab�tic dins de cada nivell, indicant a m�s si �s un directori (D) o un fitxer (F), i la seva �ltima data de modificaci�.

### Exercici 3
Modifica l�exercici anterior. Ara, en lloc de mostrar el resultat per la pantalla, guarda el resultat en un fitxer TXT.

### Exercici 4
Afegeix la funcionalitat de llegir qualsevol fitxer TXT i mostra el seu contingut per consola.

### Exercici 5
Ara el programa ha de serialitzar un Objecte Java a un fitxer .ser i despr�s l�ha de desserialitzar.

## Nivell 2
### Exercici 1
Executa l'exercici 3 del nivell anterior parametritzant tots els m�todes en un fitxer de configuraci�.

Pots utilitzar un fitxer Java Properties, o b� la llibreria Apache Commons Configuration si ho prefereixes.

De l'exercici anterior, parametritza el seg�ent:
- Directori a llegir.
- Nom i directori del fitxer TXT resultant.

## Nivell 3
### Exercici 1
Crea una utilitat que encripti i desencripti els fitxers resultants dels nivells anteriors.

Fes servir l'algorisme AES en manera de treball ECB o CBC amb m�tode d'ompliment PKCS5Padding. Es pot emprar javax.crypto o b� org.apache.commons.crypto.