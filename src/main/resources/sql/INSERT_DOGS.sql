INSERT INTO dog (name, photo_url, created_at, birth_date, sex, weight, breed, type)
VALUES
    ('Warn Waffle', 'https://example.com/nala.jpg', CURRENT_TIMESTAMP,
     '2025-06-15', 'MALE', 12.50, 'GOLDEN_RETRIVEVER', 'DOG');
INSERT INTO plant (name, photo_url, created_at, acquisition_date, species, watering_frequency_days, type)
VALUES
    ('Albert', 'https://example.com/monstera.jpg', CURRENT_TIMESTAMP,
     '2025-08-10', 'Monstera Deliciosa', 7, 'PLANT');