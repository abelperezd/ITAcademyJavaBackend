# Tasca S3.02: Patterns 2

## Descripci�
Anem a aprofundir en els patrons de construcci� de programari. Pensa-ho b� abans de construir el teu software!

## Nivell 1
En tots els exercicis, crea un projecte Gradle amb una classe Main que demostri l'�s del patr� (amb les invocacions que es necessitin).

### Observer
Dissenya un sistema en el qual un Agent de Borsa (Observable) notifica a diverses ag�ncies de Borsa (Observers) canvis quan la Borsa puja o baixa.
- �s necessari que l'objecte Observable mantingui refer�ncies als Observers.

## Nivell 2

### Callback
Crea una classe que repliqui el funcionament del comando 'Undo'. Aquesta classe ser� utilitzada per la classe Main, que permetr� introduir opcions per consola.
- La passarel�la invocar� el pagament sense con�ixer la forma i retornant el control a la classe d'origen.
- La classe que invoca la passarel�la de pagament ser� una botiga de sabates.

## Nivell 3
### Dependency Injection
Dissenya una classe que mostri en pantalla el preu de diversos articles. Ja que haur� de mostrar-los tamb� en diversos tipus de moneda.

Assegura't d'afegir-li com a Injecci� de Depend�ncia una classe Convertidor de Moneda que efectu� la correcci� del preu en funci� del canvi de divisa.