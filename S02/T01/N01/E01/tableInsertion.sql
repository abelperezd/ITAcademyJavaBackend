USE cul_d_ampolla;

-- ----------------------------------------------- ADRECES -----------------------------------------------
TRUNCATE TABLE adreces;
INSERT INTO adreces (carrer, numero, pis, porta, codi_postal, pais) 
VALUES
('Gran Via', '10', '3', 'B', '08001', 'España'),
('Rue de Rivoli', '25', NULL, NULL, '75001', 'Francia'),
('Baker Street', '221', '2', NULL, 'NW16E', 'Reino Unido'),
('Fifth Avenue', '123', NULL, 'A', '10061', 'Estados Unidos'),
('Alexanderplatz', '7', '5', 'C', '10178', 'Alemania'),
('Paseo de la Reforma', '222', NULL, NULL, '06500', 'México'),
('Bundesplatz', '1', '12', 'A', '10715', 'Suiza'),
('Calle de Alcalá', '45', '4', NULL, '28014', 'España'),
('Rua Augusta', '182', NULL, NULL, '11001', 'Portugal'),
('Kurfürstendamm', '231', NULL, NULL, '10719', 'Alemania'),
('Rue Saint-Honoré', '148', '3', 'D', '75001', 'Francia'),
('Grafton Street', '30', NULL, NULL, 'DH211', 'Irlanda'),
('Nikolskaya Street', '10', '1', 'B', '10812', 'Rusia'),
('Via del Corso', '20', NULL, NULL, '00187', 'Italia'),
('Schildergasse', '1', NULL, NULL, '50667', 'Alemania'),
('Champs-Élysées', '52', '6', NULL, '75008', 'Francia'),
('Oxford Street', '400', NULL, NULL, 'W11AB', 'Reino Unido'),
('La Rambla', '45', '1', 'A', '08002', 'España'),
('Siam Paragon', '991', '7', 'C', '10330', 'Tailandia'),
('Gran Vía de les Corts Catalanes', '123', NULL, 'B', '08014', 'España'),
('Tverskaya Street', '9', '2', NULL, '12P09', 'Rusia'),
('Bahnhofstrasse', '15', NULL, NULL, '8001', 'Suiza'),
('Calle Florida', '450', NULL, NULL, 'C10AD', 'Argentina'),
('Bulevar Kralja Aleksandra', '73', '4', 'C', '11000', 'Serbia'),
('Park Avenue', '800', '27', 'D', '10021', 'Estados Unidos')
;

-- ----------------------------------------------- PROVEIDORS -----------------------------------------------
TRUNCATE proveidors;
INSERT INTO proveidors (nom, telefon, fax, nif, adreça_id) 
VALUES
('Super Optica', '938405608', '938405597', 'A–8200876', 8),
('Optica Mira', '937891234', '937891235', 'C-7654321', 2),
('Optica Univers', '936784512', NULL, 'A-12345678', 3),
('Optica Vision', '938401234', NULL, 'N-87654321', 4),
('Optica Sol', '938409876', NULL, 'B-98765432', 5),
('Optica Llum', '937890123', '937890124', 'C-12345678', 6),
('Optica Nova', '936789012', NULL, 'N-45678901', 7),
('Optica World', '936712345', '936712346', 'A-654321', 1),
('Optica Center', '938401245', NULL, 'B-45678901', 9),
('Optica Zoom', '938401237', '938401238', 'N-45678901', 10);

-- ----------------------------------------------- MONTURES -----------------------------------------------
TRUNCATE montures;
INSERT INTO montures (tipus) 
VALUES ('flotant'), ('pasta'), ('metàl.lica');


-- ----------------------------------------------- ULLERES -----------------------------------------------
TRUNCATE ulleres;

INSERT INTO ulleres (marca, graduacio_esq, graduacio_dre, color_montura, color_esq, color_dre, preu, montura_id, proveidors_id)
VALUES
('Cling', 1.7, 0.5, 'blau', 'verd', 'rosa', 299.99, 4, 5),
('Ray-Ban', 2.0, 1.5, 'negre', 'blanc', 'negre', 129.99, 2, 4),
('Oakley', 0.5, 1.0, 'marró', 'marró', 'verd', 189.99, 5, 2),
('Tom Ford', 1.0, 1.0, 'negre', 'blanc', 'negre', 79.99, 1, 1),
('Prada', 2.5, 2.5, 'blau', 'blau', 'blau', 599.99, 8, 3),
('Gucci', 0.5, 0.5, 'marró', 'marró', 'marró', 349.99, 10, 2),
('Dior', 3.0, 2.0, 'negre', 'negre', 'negre', 799.99, 6, 1),
('Versace', 1.5, 1.5, 'rosa', 'rosa', 'rosa', 239.99, 3, 5),
('Burberry', 2.0, 1.0, 'marró', 'marró', 'vermell', 129.99, 9, 4),
('Michael Kors', 1.0, 0.5, 'negre', 'blanc', 'blau', 99.99, 7, 3),
('Tiffany', 2.5, 2.0, 'blau', 'blau', 'vermell', 599.99, 10, 5),
('Ralph Lauren', 0.5, 0.5, 'negre', 'blanc', 'negre', 219.99, 4, 1),
('Armani', 3.0, 3.0, 'negre', 'negre', 'negre', 899.99, 2, 5),
('Hugo Boss', 1.5, 1.5, 'blanc', 'blanc', 'blanc', 299.99, 5, 4),
('Calvin Klein', 1.0, 0.5, 'blau', 'verd', 'blau', 149.99, 3, 1),
('Fendi', 2.0, 1.5, 'rosa', 'rosa', 'rosa', 399.99, 8, 3),
('Chanel', 2.5, 2.5, 'negre', 'negre', 'negre', 699.99, 1, 5);


-- ----------------------------------------------- CLIENTS -----------------------------------------------
TRUNCATE clients;
INSERT INTO clients (nom, telefon, correu, data_registre, client_recomanador_id, adreces_id)
VALUES
('Marta Rodríguez', 667890123, 'marta.rodriguez@gmail.com', '2021-07-01 11:05:15', NULL, 17),
('José Sánchez', 678901234, 'jose.sanchez@hotmail.com', '2021-07-03 16:50:40', 6, 15),
('Antonio López', 656789012, 'antonio.lopez@hotmail.com', '2021-06-29 13:30:20', 4, 24),
('Sara González', 701234567, 'sara.gonzalez@gmail.com', '2021-07-09 09:45:25', NULL, 22),
('Juan Pérez', 612345678, 'juan.perez@gmail.com', '2021-06-21 14:15:42', 1, 12),
('Luisa García', 645678901, 'luisa.garcia@gmail.com', '2021-06-27 09:10:50', NULL, 19),
('Carmen Jiménez', 689012345, 'carmen.jimenez@gmail.com', '2021-07-05 08:25:30', NULL, 11),
('Pedro Martínez', 634567890, 'pedro.martinez@gmail.com', '2021-06-25 15:45:12', 2, 21),
('Ana Fernandez', 623758985, 'anaf2067@gmail.com', '2021-06-19 11:38:09', NULL, 14),
('Carlos Castro', 712345678, 'carlos.castro@hotmail.com', '2021-07-11 15:20:10', 10, 20),
('María Gómez', 623456789, 'maria.gomez@hotmail.com', '2021-06-23 10:20:30', NULL, 23),
('Javier Ruiz', 690123456, 'javier.ruiz@hotmail.com', '2021-07-07 14:00:00', 8, 16),
('Laura Martín', 645612345, 'laura.martin@gmail.com', '2021-07-15 10:10:30', 3, 18),
('Carlos Gutiérrez', 678923456, 'carlos.gutierrez@hotmail.com', '2021-07-17 17:30:20', 9, 25),
('Isabel González', 678967890, 'isabel.gonzalez@gmail.com', '2021-07-19 09:20:15', NULL, 13);

-- ----------------------------------------------- EMPLEATS -----------------------------------------------
TRUNCATE empleat;
INSERT INTO empleat (nom)
VALUES ('Alfonso'), ('Beatriz'), ('Carlos'), ('Diana'), ('Esteban'), ('Fernando'), 
('Gloria'), ('Hugo'), ('Isabel'), ('Jorge');

-- ----------------------------------------------- VENDES -----------------------------------------------
TRUNCATE venda;
INSERT INTO venda (clients_id, data_venda, empleat_id, ulleres_id)
VALUES (1, '2022-01-01 09:00:00', 4, 11),
(2, '2022-01-07 15:34:00', 5, 5),
(1, '2022-01-10 12:15:00', 6, 9),
(8, '2022-01-13 16:30:00', 3, 3),
(1, '2022-01-15 09:45:00', 4, 14),
(1, '2022-01-20 14:00:00', 5, 1),
(1, '2022-01-22 11:20:00', 7, 3),
(10, '2022-01-23 17:50:00', 3, 13),
(5, '2022-01-26 10:10:00', 8, 14),
(7, '2022-01-30 15:25:00', 2, 5),
(6, '2022-02-03 10:45:00', 9, 16),
(7, '2022-02-05 14:55:00', 10, 2),
(8, '2022-02-07 11:30:00', 1, 8),
(9, '2022-02-12 16:00:00', 4, 1),
(3, '2022-02-14 09:20:00', 8, 12),
(4, '2022-02-18 12:40:00', 9, 7),
(12, '2022-02-23 14:15:00', 4, 6),
(1, '2022-02-25 09:30:00', 6, 10),
(2, '2022-02-27 13:45:00', 7, 4),
(5, '2022-03-03 16:20:00', 10, 17),
(6, '2022-03-05 11:10:00', 1, 16),
(11, '2022-03-08 14:50:00', 6, 11),
(12, '2023-03-10 17:30:00', 4, 13),
(11, '2023-02-20 10:00:00', 4, 15);
