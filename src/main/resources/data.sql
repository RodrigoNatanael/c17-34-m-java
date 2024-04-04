--- Insertar datos en la tabla categorias
INSERT INTO categorias(name, create_at) VALUES ('Tango Techno Night', CURRENT_TIMESTAMP);
INSERT INTO categorias(name, create_at) VALUES ('Electro Asado', CURRENT_TIMESTAMP);
INSERT INTO categorias(name, create_at) VALUES ('Palermo Neon Party', CURRENT_TIMESTAMP);
INSERT INTO categorias(name, create_at) VALUES ('Puerto Madero Deep House Cruise', CURRENT_TIMESTAMP);
INSERT INTO categorias(name, create_at) VALUES ('Recoleta Underground Experience', CURRENT_TIMESTAMP);
INSERT INTO categorias(name, create_at) VALUES ('Eclectic Electronic Showcase', CURRENT_TIMESTAMP);
--- Insertar datos en la tabla user
INSERT INTO users(email, password, create_at) VALUES ( 'test@test.com', '123456', CURRENT_TIMESTAMP);
INSERT INTO users(email, password, create_at) VALUES ( 'test2@test.com', '123456', CURRENT_TIMESTAMP);
INSERT INTO users(email, password, create_at) VALUES ( 'test3@test.com', '123456', CURRENT_TIMESTAMP);
INSERT INTO users(email, password, create_at) VALUES ( 'test4@test.com', '123456', CURRENT_TIMESTAMP);
INSERT INTO users(email, password, create_at) VALUES ('test5@test.com', '123456', CURRENT_TIMESTAMP);
--- Insertar datos en la tabla profiles
INSERT INTO profiles( user_id, name, lastname, document, is_present, create_at) VALUES ( 1, 'Test', 'Test', '123456', true, CURRENT_TIMESTAMP);
INSERT INTO profiles( user_id, name, lastname, document, is_present, create_at) VALUES ( 2, 'Test2', 'Test2', '123456', true, CURRENT_TIMESTAMP);
INSERT INTO profiles( user_id, name, lastname, document, is_present, create_at) VALUES ( 3, 'Test3', 'Test3', '123456', true, CURRENT_TIMESTAMP);
INSERT INTO profiles( user_id, name, lastname, document, is_present, create_at) VALUES ( 4, 'Test4', 'Test4', '123456', true, CURRENT_TIMESTAMP);
INSERT INTO profiles( user_id, name, lastname, document, is_present, create_at) VALUES ( 5, 'Test5', 'Test5', '123456', true, CURRENT_TIMESTAMP);
--- Insertar datos en la tabla transactions
INSERT INTO transaccion( profile_buyer_id, profile_seller_id, state_transaction, create_at) VALUES ( 1, 2, 'PENDING', CURRENT_TIMESTAMP);
INSERT INTO transaccion( profile_buyer_id, profile_seller_id, state_transaction, create_at) VALUES ( 2, 3, 'PENDING', CURRENT_TIMESTAMP);
INSERT INTO transaccion( profile_buyer_id, profile_seller_id, state_transaction, create_at) VALUES ( 3, 4, 'PENDING', CURRENT_TIMESTAMP);
INSERT INTO transaccion( profile_buyer_id, profile_seller_id, state_transaction, create_at) VALUES ( 4, 5, 'PENDING', CURRENT_TIMESTAMP);
INSERT INTO transaccion( profile_buyer_id, profile_seller_id, state_transaction, create_at) VALUES ( 2, 5, 'PENDING', CURRENT_TIMESTAMP);
--- Insertar datos en la tabla tickets
INSERT INTO tickets( meta, create_at, transaction_id, profile_id) VALUES ( 'Meta 1', CURRENT_TIMESTAMP, 1, 1);
INSERT INTO tickets( meta, create_at, transaction_id, profile_id) VALUES ( 'Meta 2', CURRENT_TIMESTAMP, 2, 2);
INSERT INTO tickets( meta, create_at, transaction_id, profile_id) VALUES ( 'Meta 3', CURRENT_TIMESTAMP, 3, 3);
INSERT INTO tickets( meta, create_at, transaction_id, profile_id) VALUES ( 'Meta 4', CURRENT_TIMESTAMP, 4, 4);
INSERT INTO tickets( meta, create_at, transaction_id, profile_id) VALUES ( 'Meta 5', CURRENT_TIMESTAMP, 5, 2);
--- Insertar datos en la tabla category_ticket
INSERT INTO category_ticket (category_id, ticket_id) VALUES (1, 1);
INSERT INTO category_ticket (category_id, ticket_id) VALUES (2, 2);
INSERT INTO category_ticket (category_id, ticket_id) VALUES (3, 3);
INSERT INTO category_ticket (category_id, ticket_id) VALUES (1, 4);
INSERT INTO category_ticket (category_id, ticket_id) VALUES (2, 5);
--- Insertar datos en la tabla data_bank
INSERT INTO data_bank( profile_id, account_number, account_type, entity_bank,create_at) VALUES ( 1, '123456', 'Ahorros', 'Banco de Bogotá', CURRENT_TIMESTAMP);
INSERT INTO data_bank( profile_id, account_number, account_type, entity_bank,create_at) VALUES ( 2, '123456', 'Ahorros', 'Banco de Bogotá', CURRENT_TIMESTAMP);
INSERT INTO data_bank( profile_id, account_number, account_type, entity_bank,create_at) VALUES ( 3, '123456', 'Ahorros', 'Banco de Bogotá', CURRENT_TIMESTAMP);
INSERT INTO data_bank( profile_id, account_number, account_type, entity_bank,create_at) VALUES ( 2, '123456', 'Billetera virtual', 'Mercado Pago', CURRENT_TIMESTAMP);
INSERT INTO data_bank( profile_id, account_number, account_type, entity_bank,create_at) VALUES ( 3, '123456', 'Billetera virtual', 'Mercado Pago', CURRENT_TIMESTAMP);
--- Insertar datos en la tabla wallet_user
INSERT INTO wallet_user( balance, state_account, create_at) VALUES (10000.00, 'ACTIVE', CURRENT_TIMESTAMP);
INSERT INTO wallet_user(  balance, state_account, create_at) VALUES (  15000.00, 'ACTIVE', CURRENT_TIMESTAMP);
INSERT INTO wallet_user(  balance, state_account, create_at) VALUES (  9000.00, 'ACTIVE', CURRENT_TIMESTAMP);
INSERT INTO wallet_user(  balance, state_account, create_at) VALUES ( 3000.00, 'ACTIVE', CURRENT_TIMESTAMP);
INSERT INTO wallet_user(  balance, state_account, create_at) VALUES ( 20000.00, 'ACTIVE', CURRENT_TIMESTAMP);
--- Insertar datos en la tabla wallet_user
UPDATE profiles SET wallet_id = 1 WHERE id = 1;
UPDATE profiles SET wallet_id = 2 WHERE id = 2;
UPDATE profiles SET wallet_id = 3 WHERE id = 3;
UPDATE profiles SET wallet_id = 4 WHERE id = 4;
UPDATE profiles SET wallet_id = 5 WHERE id = 5;
--- Insertar datos en la tabla transaccion
UPDATE transaccion SET wallet_buyer_id = 1 WHERE id = 1;
UPDATE transaccion SET wallet_buyer_id = 2 WHERE id = 2;
UPDATE transaccion SET wallet_buyer_id = 3 WHERE id = 3;
UPDATE transaccion SET wallet_buyer_id = 4 WHERE id = 4;
UPDATE transaccion SET wallet_buyer_id = 2 WHERE id = 5;
--- Insertar datos en la tabla transaccion
UPDATE transaccion SET wallet_seller_id = 2 WHERE id = 1;
UPDATE transaccion SET wallet_seller_id = 3 WHERE id = 2;
UPDATE transaccion SET wallet_seller_id = 4 WHERE id = 3;
UPDATE transaccion SET wallet_seller_id = 5 WHERE id = 4;
UPDATE transaccion SET wallet_seller_id = 5 WHERE id = 5;