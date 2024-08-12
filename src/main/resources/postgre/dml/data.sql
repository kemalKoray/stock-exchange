DELETE FROM stock_exchange_stock;
DELETE FROM stock;
DELETE FROM stock_exchange;

INSERT INTO stock_exchange
(description, name, live_in_market)
VALUES('SE 1 description', 'se1', true);

INSERT INTO stock_exchange
(description, name, live_in_market)
VALUES('SE 2 description', 'se2', false);

INSERT INTO stock_exchange
(description, name, live_in_market)
VALUES('SE 3 description', 'se3', false);


INSERT INTO stock
(create_date, description, last_update, "name", current_price)
VALUES('2024-08-11 19:47:58.184', 'S 1 description', '2024-08-11 19:47:58.184', 's1', 1000.00);
INSERT INTO stock
(create_date, description, last_update, "name", current_price)
VALUES('2024-08-11 19:48:17.591', 'S 2 description', '2024-08-11 19:48:17.591', 's2', 2000.00);
INSERT INTO stock
(create_date, description, last_update, "name", current_price)
VALUES('2024-08-11 19:48:24.999', 'S 3 description', '2024-08-11 19:48:24.999', 's3', 3000.00);
INSERT INTO stock
(create_date, description, last_update, "name", current_price)
VALUES('2024-08-11 19:48:32.695', 'S 4 description', '2024-08-11 19:48:32.695', 's4', 4000.00);
INSERT INTO stock
(create_date, description, last_update, "name", current_price)
VALUES('2024-08-11 19:48:41.317', 'S 5 description', '2024-08-11 19:48:41.317', 's5', 5000.00);
INSERT INTO stock
(create_date, description, last_update, "name", current_price)
VALUES('2024-08-11 19:48:57.183', 'S 6 description', '2024-08-11 19:48:57.183', 's6', 6000.00);
INSERT INTO stock
(create_date, description, last_update, "name", current_price)
VALUES('2024-08-11 19:49:06.380', 'S 7 description', '2024-08-11 19:49:06.380', 's7', 7000.00);
INSERT INTO stock
(create_date, description, last_update, "name", current_price)
VALUES('2024-08-11 19:52:21.764', 'S 8 description', '2024-08-11 19:52:21.764', 's8', 7000.00);
INSERT INTO stock
(create_date, description, last_update, "name", current_price)
VALUES('2024-08-11 19:52:27.776', 'S 9 description', '2024-08-11 19:52:27.776', 's9', 7000.00);
INSERT INTO stock
(create_date, description, last_update, "name", current_price)
VALUES('2024-08-11 19:52:35.674', 'S 10 description', '2024-08-11 19:52:35.674', 's10', 7000.00);


INSERT INTO stock_exchange_stock (stock_exchange_id, stock_id)
SELECT
    (SELECT id FROM stock_exchange WHERE name = 'se1'),
    (SELECT id FROM stock WHERE name = 's1');
INSERT INTO stock_exchange_stock (stock_exchange_id, stock_id)
SELECT
    (SELECT id FROM stock_exchange WHERE name = 'se1'),
    (SELECT id FROM stock WHERE name = 's2');
INSERT INTO stock_exchange_stock (stock_exchange_id, stock_id)
SELECT
    (SELECT id FROM stock_exchange WHERE name = 'se1'),
    (SELECT id FROM stock WHERE name = 's3');
INSERT INTO stock_exchange_stock (stock_exchange_id, stock_id)
SELECT
    (SELECT id FROM stock_exchange WHERE name = 'se1'),
    (SELECT id FROM stock WHERE name = 's4');
INSERT INTO stock_exchange_stock (stock_exchange_id, stock_id)
SELECT
    (SELECT id FROM stock_exchange WHERE name = 'se1'),
    (SELECT id FROM stock WHERE name = 's5');
INSERT INTO stock_exchange_stock (stock_exchange_id, stock_id)
SELECT
    (SELECT id FROM stock_exchange WHERE name = 'se1'),
    (SELECT id FROM stock WHERE name = 's6');
INSERT INTO stock_exchange_stock (stock_exchange_id, stock_id)
SELECT
    (SELECT id FROM stock_exchange WHERE name = 'se2'),
    (SELECT id FROM stock WHERE name = 's7');
INSERT INTO stock_exchange_stock (stock_exchange_id, stock_id)
SELECT
    (SELECT id FROM stock_exchange WHERE name = 'se2'),
    (SELECT id FROM stock WHERE name = 's1');
INSERT INTO stock_exchange_stock (stock_exchange_id, stock_id)
SELECT
    (SELECT id FROM stock_exchange WHERE name = 'se2'),
    (SELECT id FROM stock WHERE name = 's2');
INSERT INTO stock_exchange_stock (stock_exchange_id, stock_id)
SELECT
    (SELECT id FROM stock_exchange WHERE name = 'se2'),
    (SELECT id FROM stock WHERE name = 's3');
INSERT INTO stock_exchange_stock (stock_exchange_id, stock_id)
SELECT
    (SELECT id FROM stock_exchange WHERE name = 'se3'),
    (SELECT id FROM stock WHERE name = 's8');
INSERT INTO stock_exchange_stock (stock_exchange_id, stock_id)
SELECT
    (SELECT id FROM stock_exchange WHERE name = 'se3'),
    (SELECT id FROM stock WHERE name = 's9');
INSERT INTO stock_exchange_stock (stock_exchange_id, stock_id)
SELECT
    (SELECT id FROM stock_exchange WHERE name = 'se3'),
    (SELECT id FROM stock WHERE name = 's10');
INSERT INTO stock_exchange_stock (stock_exchange_id, stock_id)
SELECT
    (SELECT id FROM stock_exchange WHERE name = 'se3'),
    (SELECT id FROM stock WHERE name = 's1');
