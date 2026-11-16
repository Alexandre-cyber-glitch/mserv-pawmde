-- =========================================================
-- Seed rejouable : ON CONFLICT DO NOTHING => si la ligne existe
-- déjà (données gardées / modifiées dans l'appli), on n'y touche pas.
-- Photos : les fichiers sont dans pawmade.storage.root,
-- la colonne storage_key = chemin relatif à ce dossier.
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

-- ---------- Photos (après les livings, à cause de la FK living_id) ----------
INSERT INTO photo (id, living_id, storage_key, content_type, created_at) VALUES
  ('00000000-0000-0000-0000-000000000001', 1, 'photo/00000000-0000-0000-0000-000000000001/WarmWaffle.jpg',   'image/jpeg', CURRENT_TIMESTAMP),
  ('00000000-0000-0000-0000-000000000002', 1, 'photo/00000000-0000-0000-0000-000000000002/WarmeWaffle.webp', 'image/webp', CURRENT_TIMESTAMP)
ON CONFLICT (id) DO NOTHING;

-- Lie avatar + cover à Warm Waffle, seulement si aucune photo n'est déjà choisie
-- (pour ne pas écraser un changement fait depuis l'appli).
UPDATE living
SET avatar_photo_id = '00000000-0000-0000-0000-000000000001',
    cover_photo_id  = '00000000-0000-0000-0000-000000000002'
WHERE id = 1 AND avatar_photo_id IS NULL;

-- Recale le compteur d'id sur le plus grand id existant
-- (au lieu de "RESTART WITH 6", qui casserait dès qu'il y a plus de 5 lignes).
SELECT setval(pg_get_serial_sequence('living', 'id'), (SELECT MAX(id) FROM living));