USE pizzeria;

-- ----------------------------------------------- ADRECES -----------------------------------------------
TRUNCATE TABLE adreces;
INSERT INTO adreces (adreça, codi_postal, localitat, provincia) 
VALUES
('Gran Via 10', '08001', 'Barcelona', 'Barcelona'),
('Carrer del Bisbe 5', '08002', 'Barcelona', 'Barcelona'),
('Rambla Catalunya 20', '08002', 'Manresa', 'Barcelona'),
('Carrer de la Marina 25', '08005', 'Sabadell', 'Barcelona'),
('Plaza Mayor 1', '37002', 'Barberà', 'Barcelona'),
('Plaça de la Vila 15', '08221', 'Terrassa', 'Barcelona'),
('Calle Mayor 1', '28013', 'Madrid', 'Madrid'),
('Avenida de la Constitución 12', '41004', 'Sevilla', 'Sevilla'),
('Carrer de la Mercè 5', '07001', 'Palma de Mallorca', 'Illes Balears'),
('Calle San Juan 22', '46003', 'Valencia', 'Valencia'),
('Calle Gran Vía 55', '50005', 'Zaragoza', 'Zaragoza'),
('Avenida de la Libertad 33', '30009', 'Murcia', 'Murcia'),
('Calle de la Estafeta 12', '31001', 'Pamplona', 'Navarra'),
('Calle de los Reyes Católicos 4', '18009', 'Granada', 'Granada');



-- ----------------------------------------------- CLIENTS -----------------------------------------------
TRUNCATE TABLE clients;
INSERT INTO clients (nom, cognoms, telefon, adreça_id)
VALUES
('Pau', 'Rodriguez', '678546987', 2),
('Marina', 'García', '677889900', 8),
('Jorge', 'Martínez', '644556677', 5),
('Laura', 'Fernández', '699112233', 3),
('Daniel', 'González', '633445566', 7),
('Carla', 'Ruiz', '655778899', 1),
('Sergio', 'Sánchez', '622334455', 4),
('Alicia', 'Pérez', '677889900', 10);


-- ----------------------------------------------- BOTIGUES -----------------------------------------------
TRUNCATE TABLE botigues;
INSERT INTO botigues (nom, adreça_id)
VALUES
('Dinar de casa', 1),
('Cafè de la Plaça', 2),
('La Taverna del Port', 3),
('Bar del Centre', 9),
('Pizzeria La Bella Napoli', 10),
('La Cuina del Món', 11);


-- ----------------------------------------------- TREBALLADORS -----------------------------------------------
TRUNCATE TABLE treballadors;
INSERT INTO treballadors (nom, cognoms, NIF, telefon, posicio, botiga_id)
VALUES
('Oscar', 'Martinez', '45366874L', '693256412', 'repartidor', 1),
('Laura', 'Fernandez', '65987423J', '622344556', 'repartidor', 2),
('Marc', 'Garcia', '20874365K', '667789012', 'repartidor', 3),
('Ainhoa', 'Lopez', '94671235M', '655889900', 'cuiner', 4),
('Pablo', 'Gomez', '30567890A', '644557799', 'cuiner', 5),
('Sofia', 'Ruiz', '76491238R', '677889900', 'cuiner', 5);


-- ----------------------------------------------- CAT. PIZZA -----------------------------------------------
TRUNCATE TABLE categories_pizza;
INSERT INTO categories_pizza (tipus)
VALUES
('Traditional'), ('Gourmet'), ('Vegetarian'), ('Vegan');

-- ----------------------------------------------- PRODUCTES -----------------------------------------------
TRUNCATE TABLE productes;
INSERT INTO productes (nom, preu, descripcio, imatge,categoria,categoria_pizza_id)
VALUES
('Pizza 4 formatges', 8.45,'Pizza amb 4 formatges: emmental, brie, cabra i blau', NULL, 'pizza',3),
('Pizza Margherita', 7.99, 'Pizza tradicional italiana amb salsa de tomàquet, formatge mozzarella i albercoc fresc', NULL, 'pizza',1),
('Pizza Pepperoni', 9.99, 'Pizza amb salsa de tomàquet, formatge mozzarella i pepperoni picant', NULL, 'pizza',1),
('Pizza Hawaiian', 11.99, 'Pizza amb salsa de tomàquet, formatge mozzarella, pernil i pinya', NULL, 'pizza',1),
('Pizza BBQ Chicken', 12.99, 'Pizza amb salsa BBQ, formatge mozzarella, pollastre a la graella i ceba vermella', NULL, 'pizza',2),
('Pizza Truffle Mushroom', 14.99, 'Pizza gourmet amb oli de tòfona, formatge mozzarella, bolets i rúcula', NULL,'pizza', 2),
('Pizza Spinach Feta', 13.99, 'Pizza vegetariana amb salsa de tomàquet, formatge mozzarella, espinacs i formatge feta', NULL, 'pizza',3),
('Pizza Vegan Supreme', 15.99, 'Pizza vegana amb salsa de tomàquet, formatge vegà, salsitxes Beyond Meat i verdures', NULL, 'pizza',4),
('Hamburguesa de pollastre', 6.5, 'Hamurguesa amb formatge i enciam, amb guarnició', NULL,'hamburguesa', NULL),
('Hamburguesa Clàssica', 7.5, 'Hamburguesa amb carn de vedella, formatge i enciam, amb guarnició', NULL,'hamburguesa', NULL),
('Hamburguesa Barbecue', 8.5, 'Hamburguesa amb carn de porc, salsa barbacoa i formatge xedar, amb guarnició', NULL,'hamburguesa', NULL),
('Hamburguesa Vegetariana', 9.5, 'Hamburguesa de quinoa, mongetes i pastanaga, amb salsa tzatziki i enciam, amb guarnició', NULL,'hamburguesa', NULL),
('Coca-Cola', 2.5, 'Refresc carbonatada amb cafeïna i sucre', NULL,'beguda', NULL),
('Fanta', 2.5, 'Refresc carbonatada de taronja sense cafeïna', NULL,'beguda', NULL),
('Llimonada', 3.0, 'Refrescant llimonada casolana amb llimona fresca i sucre', NULL, 'beguda',NULL),
('Tè helat', 3.5, 'Tè negre gelat, amb llimona i sucre', NULL,'beguda', NULL),
('Cafè', 2.0, 'Cafè negre amb llet o sucre a demanda', NULL, 'beguda',NULL);

-- ----------------------------------------------- COMANDES -----------------------------------------------
TRUNCATE TABLE comandes;
INSERT INTO comandes (data, repartiment, treballador_id, client_id, botiga_id)
VALUES
('2021-06-27 09:10:50', 'domicili',2, 3, 1),
('2021-06-27 10:20:30', 'domicili',1, 2, 2),
('2021-06-27 11:30:40', 'recollida',NULL, 1, 1),
('2021-06-27 12:40:50', 'domicili',2, 5, 4),
('2021-06-28 13:50:00', 'domicili',2, 4, 5),
('2021-06-28 14:00:10', 'recollida',NULL, 6, 6),
('2021-06-28 15:10:20', 'domicili',3, 7, 4),
('2021-06-28 16:20:30', 'domicili',6, 8, 5),
('2021-06-29 17:30:40', 'recollida',NULL, 2, 3),
('2021-06-29 18:40:50', 'domicili',1, 1, 4),
('2021-06-30 19:50:00', 'domicili',2, 3, 5),
('2021-06-30 20:00:10', 'recollida',NULL, 5, 6);

-- ----------------------------------------------- ITEMS -----------------------------------------------
TRUNCATE TABLE items;
INSERT INTO items (quantitat, comanda_id, producte_id)
VALUES
(2,1,4),
(1,1,13),
(3,1,1),
(5,2,14),
(4,3,15),
(2,3,12),
(1,3,2),
(7,4,8),
(3,5,6),
(4,5,13),
(2,5,11),
(1,5,16),
(6,5,9),
(1,5,10),
(2,8,14),
(3,8,15),
(5,8,17),
(1,9,3),
(2,10,1),
(3,10,7);