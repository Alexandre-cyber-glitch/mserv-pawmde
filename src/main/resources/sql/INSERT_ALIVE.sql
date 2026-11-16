-- =========================================================
-- Seed rejouable : ON CONFLICT DO NOTHING => si la ligne existe
-- déjà (données gardées / modifiées dans l'appli), on n'y touche pas.
-- Photos : aucune pour l'instant (avatar/cover_photo_id = NULL).
-- =========================================================

-- ---------- Warm Waffle (DOG) ----------
INSERT INTO living (id, name, type, created_at) VALUES (1, 'Warm Waffle', 'DOG', CURRENT_TIMESTAMP) ON CONFLICT (id) DO NOTHING;
INSERT INTO animal (id, birth_date, sex, weight) VALUES (1, '2025-06-15', 'MALE', 12.50) ON CONFLICT (id) DO NOTHING;
INSERT INTO dog (id, breed) VALUES (1, 'GOLDEN_RETRIEVER') ON CONFLICT (id) DO NOTHING;

-- ---------- Albert (PLANT) ----------
INSERT INTO living (id, name, type, created_at) VALUES (2, 'Albert', 'PLANT', CURRENT_TIMESTAMP) ON CONFLICT (id) DO NOTHING;
INSERT INTO plant (id, acquisition_date, species, watering_frequency_days) VALUES (2, '2025-08-10', 'Monstera Deliciosa', 7) ON CONFLICT (id) DO NOTHING;

-- ---------- Enzo (DOG) ----------
INSERT INTO living (id, name, type, created_at) VALUES (3, 'Enzo', 'DOG', CURRENT_TIMESTAMP) ON CONFLICT (id) DO NOTHING;
INSERT INTO animal (id, birth_date, sex, weight) VALUES (3, '2025-06-15', 'MALE', 12.50) ON CONFLICT (id) DO NOTHING;
INSERT INTO dog (id, breed) VALUES (3, 'GOLDEN_RETRIEVER') ON CONFLICT (id) DO NOTHING;

-- ---------- Balbien (DOG) ----------
INSERT INTO living (id, name, type, created_at) VALUES (4, 'Balbien', 'DOG', CURRENT_TIMESTAMP) ON CONFLICT (id) DO NOTHING;
INSERT INTO animal (id, birth_date, sex, weight) VALUES (4, '2025-06-15', 'MALE', 12.50) ON CONFLICT (id) DO NOTHING;
INSERT INTO dog (id, breed) VALUES (4, 'GOLDEN_RETRIEVER') ON CONFLICT (id) DO NOTHING;

-- ---------- Nicolas (DOG) ----------
INSERT INTO living (id, name, type, created_at) VALUES (5, 'Nicolas', 'DOG', CURRENT_TIMESTAMP) ON CONFLICT (id) DO NOTHING;
INSERT INTO animal (id, birth_date, sex, weight) VALUES (5, '2025-06-15', 'MALE', 12.50) ON CONFLICT (id) DO NOTHING;
INSERT INTO dog (id, breed) VALUES (5, 'GOLDEN_RETRIEVER') ON CONFLICT (id) DO NOTHING;

-- Recale le compteur d'id sur le plus grand id existant
-- (au lieu de "RESTART WITH 6", qui casserait dès qu'il y a plus de 5 lignes).
SELECT setval(pg_get_serial_sequence('living', 'id'), (SELECT MAX(id) FROM living));