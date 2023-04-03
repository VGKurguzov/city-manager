INSERT INTO Cities (id, name) VALUES (1, 'Нижний Новгород');
INSERT INTO Cities (id, name) VALUES (2, 'Казань');

INSERT INTO Streets (id, name, city_id) VALUES (1, 'Гвардейцев', 1);
INSERT INTO Streets (id, name, city_id) VALUES (2, 'Акимова', 1);
INSERT INTO Streets (id, name, city_id) VALUES (3, 'Волгоградская', 2);

INSERT INTO Houses (id, number, street_id) VALUES (1, '1', 1);
INSERT INTO Houses (id, number, street_id) VALUES (2, '2', 1);
INSERT INTO Houses (id, number, street_id) VALUES (3, '10', 2);
INSERT INTO Houses (id, number, street_id) VALUES (4, '20', 3);

INSERT INTO Apartments (id, area, house_id) VALUES (1, 32.3, 1);
INSERT INTO Apartments (id, area, house_id) VALUES (2, 42.7, 1);
INSERT INTO Apartments (id, area, house_id) VALUES (3, 18.9, 2);
INSERT INTO Apartments (id, area, house_id) VALUES (4, 44.5, 3);
INSERT INTO Apartments (id, area, house_id) VALUES (5, 65.1, 4);