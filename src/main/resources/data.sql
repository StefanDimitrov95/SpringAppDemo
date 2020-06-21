INSERT INTO PRODUCTS (name, price, quantity) VALUES ('iPhone 11', 699.00, 10);
INSERT INTO PRODUCTS (name, price, quantity) VALUES ('iPhone 11 Pro', 999.00, 6);
INSERT INTO PRODUCTS (name, price, quantity) VALUES ('iPhone 11 Pro Max', 1099.00, 8);
INSERT INTO PRODUCTS (name, price, quantity) VALUES ('iPhone XR', 599.99, 14);
INSERT INTO PRODUCTS (name, price, quantity) VALUES ('iPhone SE', 399.99, 32);

INSERT INTO ROLES (id, name) VALUES (1, 'ADMIN');
INSERT INTO ROLES (id, name) VALUES (2, 'USER');

INSERT INTO USERS (id, username, password)
VALUES (1, 'admin', '$2a$10$/LsFQ2WAweM4h8JwNoPco.sPfviSMPk7DaiJY2xUlejJ.WLMvjm2K');

INSERT INTO USERS_ROLES (users_id, roles_id) VALUES (1, 1);
INSERT INTO USERS_ROLES (users_id, roles_id) VALUES (1, 2);