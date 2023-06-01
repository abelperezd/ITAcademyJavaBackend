# Tasca S4.01 Introducci� a Spring

## Descripci�
Aquest exercici t'introduir� al framework SPRING. 
Comen�ar�s a fer servir el protocol HTTP, a usar Postman, i a descobrir com gestionar depend�ncies amb Maven i Gradle.

## Nivell 1 : Exercici Spring i Maven
Aquest exercici �s un primer contacte amb Spring i Maven.
Accedeix a la p�gina ->https://start.spring.io/, i genera un projecte Spring boot.

- Importa�l a Eclipse amb l�opci� File > Import > Existing Maven Project.

- A l�arxiu application.properties, configura la variable server.port amb el valor 9000.

- Convertirem aquesta aplicaci� en una API REST: Depenent del package principal, crea un altre subpackage anomenat Controllers, i dins seu, afegeix la classe HelloWorldController. Haur� de tenir dos m�todes:
	- String saluda
	- String saluda2

- Aquests dos m�todes rebran un par�metre String anomenat nom, i retornaran la frase:�Hola, � + nom + �. Est�s executant un projecte Maven�.

- El primer m�tode respondr� a una petici� GET, i haur� de ser configurat per a rebre el par�metre com un RequestParam. El par�metre "nom" tindr� el valor per defecte �UNKNOWN�.

- Haur� de respondre a:
	- http://localhost:9000/HelloWorld
	- http://localhost:9000/HelloWorld?nom=El meu nom

- El segon m�tode respondr� a una petici� GET, i haur� de ser configurat per a rebre el par�metre com una PathVariable. El par�metre "nom" ser� opcional. Haur� de respondre a:
	- http://localhost:9000/HelloWorld2
	- http://localhost:9000/HelloWorld2/el meu nom


## Nivell 2: Exercici Spring i Gradle
Veur�s que aquest nivell �s quasi id�ntic al nivell 1, per� fent servir Gradle com a Gestor de depend�ncies.
Accedeix a la p�gina ->https://start.spring.io/, i genera un projecte Spring boot.

- Importa�l a Eclipse amb l�opci� File > Import > Existing Gradle Project.

- A l�arxiu application.properties, configura la variable server.port amb el valor 9001.

- Convertirem aquesta aplicaci� en una API REST: Depenent del package principal, crea un altre subpackage anomenat Controllers, i dins seu, afegeix la classe HelloWorldController. Haur� de tenir dos m�todes:
	- String saluda
	- String saluda2

- Aquests dos m�todes rebran un par�metre String anomenat "nom" i retornaran la frase: �Hola, � + nom + �. Est�s executant un projecte Gradle�.

- El primer m�tode respondr� a una petici� GET, i haur� de ser configurat per a rebre el par�metre com un RequestParam. El par�metre "nom" tindr� el valor per defecte �UNKNOWN�.

- Haur� de respondre a:
	- http://localhost:9001/HelloWorld
	- http://localhost:9001/HelloWorld?nom=El meu nom
 
- El segon m�tode respondr� a una petici� GET, i haur� de ser configurat per a rebre el par�metre com una PathVariable. El par�metre "nom" ser� opcional.

- Haur� de respondre a:
	- http://localhost:9001/HelloWorld2
	- http://localhost:9001/HelloWorld2/el meu nom

## Nivell 3 - Exercici Postman
Es tracta de provar els anteriors projectes des de Postman.
 Crea dos entorns:
- Projecte Maven
- Projecte Gradle

Ambd�s entorns tindran dues variables:
- Servidor, que en els dos casos tindr� el valor http://localhost
- Port, que en el cas del projecte Maven tindr� el valor 9000, i en el cas del projecte Gradle, 9001.

Que has d�entregar? (4 arxius):
- Els dos entorns exportats.
- Una captura de pantalla per cada entorn, on es vegi l�execuci� des de Postman usant l�entorn i les variables definides en ells.
- Pots provar l'URL: http://localhost:xxxx/HelloWorld/elmeunom, o qualsevol altra de les que admeten els dos projectes. (recorda que perqu� l�execuci� funcioni correctament, haur�s de tenir en execuci� els dos projectes a Eclipse).

Executa des d�Eclipse els projectes creats als dos nivells anteriors, i mostra el retorn obtingut en cada projecte, quan crides a algunes de les peticions disponibles, fent servir els entorns creats i les seves variables.

Haur�s d�entregar dues captures de pantalla, una per l�execuci� de cada entorn, i dos arxius amb format JSON, amb els entorns exportats.