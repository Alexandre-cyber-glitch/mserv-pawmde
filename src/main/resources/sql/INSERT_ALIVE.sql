-- ---------- Warm Waffle (DOG) ----------
INSERT INTO living (id, name, photo_url, type, created_at)
VALUES (1, 'Warm Waffle', 'https://example.com/nala.jpg', 'DOG', CURRENT_TIMESTAMP);
INSERT INTO animal (id, birth_date, sex, weight)
VALUES (1, '2025-06-15', 'MALE', 12.50);
INSERT INTO dog (id, breed)
VALUES (1, 'GOLDEN_RETRIEVER');

-- ---------- Albert (PLANT) ----------
INSERT INTO living (id, name, photo_url, type, created_at)
VALUES (2, 'Albert', 'https://example.com/monstera.jpg', 'PLANT', CURRENT_TIMESTAMP);
INSERT INTO plant (id, acquisition_date, species, watering_frequency_days)
VALUES (2, '2025-08-10', 'Monstera Deliciosa', 7);

-- ---------- Enzo (DOG) ----------
INSERT INTO living (id, name, photo_url, type, created_at)
VALUES (3, 'Enzo', 'https://example.com/nala.jpg', 'DOG', CURRENT_TIMESTAMP);
INSERT INTO animal (id, birth_date, sex, weight)
VALUES (3, '2025-06-15', 'MALE', 12.50);
INSERT INTO dog (id, breed)
VALUES (3, 'GOLDEN_RETRIEVER');

-- ---------- Balbien (DOG) ----------
INSERT INTO living (id, name, photo_url, type, created_at)
VALUES (4, 'Balbien', 'https://example.com/nala.jpg', 'DOG', CURRENT_TIMESTAMP);
INSERT INTO animal (id, birth_date, sex, weight)
VALUES (4, '2025-06-15', 'MALE', 12.50);
INSERT INTO dog (id, breed)
VALUES (4, 'GOLDEN_RETRIEVER');

-- ---------- Nicolas (DOG) ----------
INSERT INTO living (id, name, photo_url, type, created_at)
VALUES (5, 'Nicolas', 'https://example.com/nala.jpg', 'DOG', CURRENT_TIMESTAMP);
INSERT INTO animal (id, birth_date, sex, weight)
VALUES (5, '2025-06-15', 'MALE', 12.50);
INSERT INTO dog (id, breed)
VALUES (5, 'GOLDEN_RETRIEVER');

-- On a forcé les id à la main : on recale le compteur IDENTITY
-- pour que les prochains save() JPA commencent à 6 (sinon conflit de clé).
ALTER TABLE living ALTER COLUMN id RESTART WITH 6;