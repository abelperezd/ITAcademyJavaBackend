# Tasca S5.01 Spring boot API rest + Aplicaci� web

## Descripci�
En aquesta tasca far�s un CRUD (Create, Read, Update, Delete) que pugui ser cridat com a API Rest i, tamb�, com aplicaci� web.

Aprendr�s a usar correctament els verbs HTTP i a gestionar els codis de resposta.

## Nivell 1: Exercici aplicaci� Web CRUD amb MySQL
Accedeix a la p�gina ->https://start.spring.io/, i genera un projecte Spring boot.

Tenim una entitat anomenada Sucursal, que disposa de les seg�ents propietats:
- Integer pk_SucursalID
- String nomSucursal
- String paisSucursal

Tamb� tenim una DTO anomenada SucursalDTO, que tindr� les mateixes propietats que l�entitat Sucursal, afegint-ne una:
- String tipusSucursal.

Aquesta propietat, en funci� del pa�s de la sucursal, haur� d�indicar si �s �UE� o �Fora UE�. Per a fer aix�, pots tenir una llista privada a la mateixa DTO (per exemple: List<String> pa�sos), amb els pa�sos que formen part de la UE.

Aprofitant l�especificaci� JPA, haur�s de persistir l�entitat Sucursal a una base de dades MySql, seguint el patr� MVC.

El consell �s que SucursalDTO la facis servir al Controller y la Vista, i Sucursal al Repository. La capa de serveis ser� l�encarregada de fer la traducci� entre les dues.

Per a aix�, depenent del package principal, crear�s una estructura de packages, on ubicar�s les classes que necessitis:
- cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.controllers
- cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.domain
- cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.dto
- cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.services
- cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.repository

La classe ubicada al paquet controllers (SucursalController, per exemple), haur� de ser capa� de donar resposta a les seg�ents peticions per actualitzar i consultar informaci�:

- http://localhost:9000/sucursal/add
- http://localhost:9000/sucursal/update
- http://localhost:9000/sucursal/delete/{id}
- http://localhost:9000/sucursal/getOne/{id}
- http://localhost:9000/sucursal/getAll

Com pots veure, a l�arxiu application.properties, haur�s de configurar que el port a utilitzar sigui el 9000.

La vista haur� d�estar desenvolupada amb Thymeleaf.

Per tal de fer-la m�s atractiva, pots usar opcionalment alguna llibreria CSS que t�ho faciliti, com bootstrap, tailwind, material, etc.

## Nivell 2: Exercici API Rest CRUD amb MySQL
Accedeix a la p�gina ->https://start.spring.io/, i genera un projecte Spring boot.

Tenim una entitat anomenada FlorEntity, que disposa de les seg�ents propietats:
- Integer pk_FlorID
- String nomFlor
- String paisFlor

Tamb� tenim una DTO anomenada FlorDTO, que tindr� les mateixes propietats que l�entitat Sucursal, afegint-ne una:
- String tipusFlor.

Aquesta propietat, en funci� del pa�s d'origen de la flor, haur� d�indicar si �s �UE� o �Fora UE�. Per a fer aix�, pots tenir una llista privada a la mateixa DTO (per exemple: List<String> pa�sos), amb els pa�sos que formen part de la UE.

Aprofitant l�especificaci� JPA, haur�s de persistir l�entitat FlorEntity a una base de dades MySQL, seguint el patr� MVC.

El consell �s que FlorDTO la facis servir al Controller, i FlorEntity al Repository. La capa de serveis ser� l�encarregada de fer la traducci� entre les dues.

Per a aix�, depenent del package principal, crear�s una estructura de packages, on ubicar�s les classes que necessitis:

- cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.controllers
- cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.domain
- cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.dto
- cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.services
- cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.repository

La classe ubicada al paquet controllers (FlorController, per exemple), haur� de ser capa� de donar resposta a les seg�ents peticions per actualitzar i consultar informaci�:

- http://localhost:9001/flor/add
- http://localhost:9001/flor/update
- http://localhost:9001/flor/delete/{id}
- http://localhost:9001/flor/getOne/{id}
- http://localhost:9001/flor/getAll

Com pots veure, a l�arxiu application.properties, haur�s de configurar que el port a usar sigui el 9001.

Haur�s de tenir en compte les bones pr�ctiques de disseny de les API, fent servir correctament els codis d'error i les respostes en cas d'invocacions incorrectes. (Pots consultar informaci� sobre ResponseEntity).

Has d�incloure swagger perqu� quasevol desenvolupador/a pugui tenir una idea r�pida dels recursos de que disposa l�API.


## Nivell 3: Exercici API Rest connectada a una altra API Rest
Accedeix a la p�gina ->https://start.spring.io/, i genera un projecte Spring boot.

Fent servir RestTemplate o WebClient, t�haur�s de connectar a l�API que has fet al nivell 2, per cridar i testar totes les peticions que permet aquesta API.

Tingues en compte, que en aquesta tasca del nivell 3, no tens cap refer�ncia a cap base de dades, ni necessites fer servir JPA, ja que el teu repositori accedir� a l�API del nivell 2.

No et cal crear una Vista, perqu� aquest nivell 3 est� previst com una API Rest, per� haur�s de crear totes les capes fins al controlador com qualsevol altra aplicaci�:

- cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n03.controllers
- cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n03.model.domain
- cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n03.model.dto
- cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n03.model.services
- cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n03.model.repository

La classe controladora, haur� de ser capa� d�atendre les seg�ents peticions:
- http://localhost:9002/flor/clientFlorsAdd
- http://localhost:9002/flor/clientFlorsUpdate
- http://localhost:9002/flor/clientFlorsDelete/{id}
- http://localhost:9002/flor/clientFlorsGetOne/{id}
- http://localhost:9002/flor/clientFlorsAll

Com pots veure, a l�arxiu application.properties, haur�s de configurar que el port a usar sigui el 9002.

Per a provar el nivell 3, haur�s de tenir en marxa l�API del nivell 2. No tindr�s problemes, ja que l�API del nivell 3 treballa amb el port 9002 i la del nivell 2 amb el port 9001.

Has d�incloure swagger perqu� quasevol desenvolupador/a pugui tenir una idea r�pida dels recursos de que disposa l�API.