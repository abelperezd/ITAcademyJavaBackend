# Tasca S4.02 Api Rest amb Spring boot

## Descripció
En aquesta tasca faràs un CRUD (Create, Read, Update, Delete) amb 3 bases de dades diferents.

Aprendràs a usar correctament els verbs HTTP i a gestionar els codis de resposta.

## Nivell 1 - Exercici CRUD amb H2
Accedeix a la pàgina ->https://start.spring.io/, i genera un projecte Spring boot

Tenim una entitat anomenada "Fruita", que disposa de les següents propietats:
- int id
- String nom
- Int quantitatQuilos

Aprofitant l’especificació JPA, hauràs de persistir aquesta entitat a una base de dades H2, seguint el patró MVC. Per a això, depenent del Package principal, crearàs una estructura de packages, on ubicaràs les classes que necessitis:

- cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n01.controllers
- cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n01.model.domain
- cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n01.model.services
- cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n01.model.repository

La classe ubicada al paquet controllers (FruitaController, per exemple), haurà de ser capaç de donar resposta a les següents peticions per actualitzar i consultar informació:

- http://localhost:8080/fruita/add
- http://localhost:8080/fruita/update
- http://localhost:8080/fruita/delete/{id}
- http://localhost:8080/fruita/getOne/{id}
- http://localhost:8080/fruita/getAll


## Nivell 2 - Exercici CRUD amb MySQL
Accedeix a la pàgina ->https://start.spring.io/, i genera un projecte Spring boot.

Has de fer el mateix que al nivell 1, però persistint les dades a MySQL.

## Nivell 3 - Exercici CRUD amb MongoDB
Accedeix a la pàgina ->https://start.spring.io/, i genera un projecte Spring boot.

Has de fer el mateix que al nivell 1, però persistint les dades a MongoDB.