# Tasca S1.02: Exceptions

## Descripci�
- Utilitza per a tots els exercicis Eclipse o IntelliJ.
- No oblidis posar sempre les classes Java dins de packages.
- Pots construir projectes Maven, Gradle o nom�s Java.

## Nivell 1
### Exercici 1
Crea una classe anomenada "Producte" amb els atributs nom i preu, i una altra classe anomenada "Venda". Aquesta classe t� com a atributs una col�lecci� de productes i el preu total de la venda.

La classe "Venda", t� un m�tode anomenat calcularTotal() que llan�a l�excepci� personalitzada VendaBuidaException i mostra per pantalla �Per fer una venda primer has d�afegir productes� si la col�lecci� de productes est� buida. Si la col�lecci� t� productes, llavors ha de rec�rrer la col�lecci� i guardar la suma de tots els preus dels productes a l�atribut preu total de la venda.

L�excepci� personalitzada VendaBuidaException ha de ser filla de la classe Exception. Al seu constructor li hem de passar el missatge  �Per fer una venda primer has d�afegir productes� i quan capturem l�excepci�, l�hem de mostrar per pantalla amb el m�tode getMessage() de l�excepci�.

Escriu el codi necessari per a generar i capturar una excepci� de tipus ArrayIndexOutOfBoundsException.

## Nivell 2
### Exercici 1
Crea una classe anomenada "Entrada". Aquesta classe ha de servir per controlar les diferents excepcions que poden apar�ixer en Java a l�hora d�introduir dades per teclat utilitzant la classe Scanner.

El primer que s�ha de fer �s instanciar un objecte de la classe Scanner i a partir d�aqu�, crear m�todes est�tics per llegir els diferents tipus de dades des del teclat. 

Tots els m�todes reben un String amb el missatge que es vol mostrar a l�usuari/�ria, per exemple: �Introdueix la teva edat�, i retornen la dada oportuna introdu�da per l�usuari/�ria en cada m�tode, per exemple: un byte amb l�edat de l�usuari/�ria.

- M�todes a implantar capturant l�excepci� de la classe InputMismatchException:
- public static byte llegirByte(String missatge);
- public static int llegirInt(String missatge);
- public static float llegirFloat(String missatge);
- public static double llegirDouble(String missatge);

M�todes a implantar capturant l�excepci� de la classe Exception:
- public static char llegirChar(String missatge);
- public static String llegirString(String missatge);
- public static boolean llegirSiNo(String missatge), si l�usuari/�ria introdueix �s�, retorna �true�, si l�usuari introdueix �n�, retorna �false�.

## Nivell 3
### Exercici 1
Una famosa empresa de cinemes ens ha demanat que desenvolupem una aplicaci� per a la reserva de seients en els seus cinemes. L�aplicaci� ser� utilitzada pels venedors/es a l�hora de vendre les entrades.

#### Funcionament
L�aplicaci� un cop s�hagi iniciat, preguntar� a l�usuari/�ria quantes files i quants seients per fila t� la sala de cinema. Un cop introdu�des aquestes dades, es mostrar� el seg�ent men�:

1. Mostrar totes les butaques reservades.
2. Mostrar les butaques reservades per una persona.
3. Reservar una butaca.
4. Anul�lar la reserva d�una butaca.
5. Anul�lar totes les reserves d�una persona.
0. Sortir.


L�aplicaci� tindr� les seg�ents classes:

Classe Principal:  tindr� el main de l�aplicaci� on s�instanciar� un objecte de la classe Cine i cridar� al seu m�tode iniciar.

Classe Butaca: tindr� les dades d�una butaca:
Atributs:
- Nombre de fila.
- Nombre de seient.
- Persona que reserva la butaca.

M�todes:
- Constructor amb tots els par�metres.
- Getters per tots els atributs.
- Equals: retornar� que dues butaques s�n iguales si la fila i el seient s�n iguals.
- toString: retornar� un String amb el seg�ent format: �Fila: 5, Seient: 20, Persona: Maria Febrer�

Classe Cine: contindr� tots els m�todes que permeten interactuar a l�usuari/�ria amb l�aplicaci�.

Atributs:
- Nombre de files del cinema.
- Nombre de seients per cada fila.
- Un objecte de la classe GestioButaques

M�todes:
- Constructor: no rebr� par�metres. Crear� l�objecte de la classe Gesti�Butaques. I cridar� al m�tode demanarDadesInicials que inicialitzar� el nombre de files i de seients.
- iniciar: comen�ar� l�aplicaci�. Cridar� al m�tode menu i en funci� del n�mero retornat, cridar� al m�tode corresponent.
- menu: mostrar� les opcions del men� principal a l�usuari/�ria, li demanar� el n�mero de l�opci� escollida i el retornar�.
- mostrarButaques: Mostra totes les butaques reservades.
- mostrarButaquesPersona: Demana el nom de la persona que ha fet la reserva i mostra totes les butaques reservades per aquesta persona.
- reservarButaca: Demana a l�usuari/�ria un n�mero de fila (crida al m�tode introduirFila), un n�mero de seient (crida al m�tode introduirSeient), el nom de la persona que fa la reserva (crida al m�tode introduirPersona) i reserva la butaca.
- anularReserva: Demana a l�usuari/�ria un n�mero de fila (crida al m�tode introduirFila), un n�mero de seient (crida al m�tode introduirSeient) i elimina la reserva de la butaca.
- anularReservaPersona: Demana a l�usuari/�ria el nom de la persona (crida al m�tode introduirPersona) i elimina les butaques reservades per la persona introdu�da.
- introduirPersona: demana a l�usuari/�ria el nom de la persona i el retorna si �s correcte. Si cont� n�meros, llen�a una excepci� personalitzada ExcepcioNomPersonaIncorrecte.
- demanarDadesInicials: Demana a l�usuari/�ria el nombre de files i seients i els guarda en els atributs corresponents. 
- introduirFila: Demana el nombre de fila, si aquest est� entre 1 i el nombre de files totals, el retorna. Si no, retorna una excepci� personalitzada ExcepcioFilaIncorrecta.
- introduirSeient: Demana el seient, si el n�mero est� entre 1 i el nombre total de seients, el retorna. Si no, retorna una excepci� del tipus ExcepcioSeientIncorrecte.

Classe GestioButaques: contindr� un ArrayList de butaques i els m�todes necessaris per afegir, eliminar i cercar les butaques a l�ArrayList.

Atributs:
- butaques: ArrayList de butaques.

M�todes:
- Constructor: No rebr� par�metres i inicialitzar� l�ArrayList de butaques.
- getButaques: Retornar� l�atribut butaques.
- afegirButaca: ser� l�encarregat d�afegir una butaca al vector de butaques. Rebr� com a par�metre un objecte de la classe Butaca i l�afegir� a l�ArrayList. Si la fila i el seient de la butaca rebuda com a par�metre coincideixen amb el d�una butaca que ja es trobi a l�ArrayList (s�utilitzar� el m�tode cercarButaca), es llen�ar� l�excepci� personalitzada ExcepcioButacaOcupada.
- eliminarButaca: ser� l�encarregat d�eliminar una butaca de l�ArrayList de butaques. Rebr� com a par�metres el n�mero de fila i el seient i l�eliminar� de l�ArrayList. Si la fila i el seient no coincideixen amb el d�una butaca reservada (s�utilitzar� el m�tode cercarButaca), llen�ar� una excepci� personalitzada ExcepcioButacaLliure.
- cercarButaca: Cerca a l�ArrayList de butaques, la butaca que coincideixi amb les dades rebudes com a par�metre (fila i seient). Si la troba retornar� la posici� de la butaca a l�ArrayList i si no la troba retornar� -1.