INSERT INTO role (id, role) VALUES (UNHEX(REPLACE(UUID(), '-', '')), 'admin');
INSERT INTO role (id, role) VALUES (UNHEX(REPLACE(UUID(), '-', '')), 'supervisor');
INSERT INTO role (id, role) VALUES (UNHEX(REPLACE(UUID(), '-', '')), 'reporter');