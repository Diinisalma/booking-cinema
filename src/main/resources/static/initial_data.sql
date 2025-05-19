-- Insert Cities
INSERT INTO public.t_city (name) VALUES
('Jakarta'),
('Bandung'),
('Surabaya'),
('Yogyakarta'),
('Medan'),
('Semarang'),
('Malang'),
('Denpasar'),
('Makassar'),
('Palembang'),
('Manado'),
('Balikpapan'),
('Pekanbaru'),
('Padang'),
('Banjarmasin'),
('Pontianak'),
('Jayapura'),
('Ambon'),
('Kupang'),
('Mataram');

-- Create temporary table for city IDs
CREATE TEMPORARY TABLE city_ids AS
SELECT id, name
FROM t_city;

-- Insert Cinemas (5 per city)
INSERT INTO public.t_cinema (city_id, name)
SELECT 
    c.id as city_id,
    'Cine ' || 
    CASE 
        WHEN c.name = 'Jakarta' THEN 'Grand Indonesia'
        WHEN c.name = 'Bandung' THEN 'Paris Van Java'
        WHEN c.name = 'Surabaya' THEN 'Tunjungan Plaza'
        WHEN c.name = 'Yogyakarta' THEN 'Hartono Mall'
        WHEN c.name = 'Medan' THEN 'Sun Plaza'
        WHEN c.name = 'Semarang' THEN 'Paragon Mall'
        WHEN c.name = 'Malang' THEN 'Malang Town Square'
        WHEN c.name = 'Denpasar' THEN 'Beachwalk'
        WHEN c.name = 'Makassar' THEN 'Panakkukang Mall'
        WHEN c.name = 'Palembang' THEN 'Palembang Square'
        WHEN c.name = 'Manado' THEN 'Manado Town Square'
        WHEN c.name = 'Balikpapan' THEN 'Balikpapan Superblock'
        WHEN c.name = 'Pekanbaru' THEN 'Pekanbaru Mall'
        WHEN c.name = 'Padang' THEN 'Padang City Center'
        WHEN c.name = 'Banjarmasin' THEN 'Banjarmasin City Center'
        WHEN c.name = 'Pontianak' THEN 'Pontianak City Center'
        WHEN c.name = 'Jayapura' THEN 'Jayapura City Center'
        WHEN c.name = 'Ambon' THEN 'Ambon City Center'
        WHEN c.name = 'Kupang' THEN 'Kupang City Center'
        WHEN c.name = 'Mataram' THEN 'Mataram City Center'
    END as name
FROM city_ids c
UNION ALL
SELECT 
    c.id as city_id,
    'Cine ' || 
    CASE 
        WHEN c.name = 'Jakarta' THEN 'Central Park'
        WHEN c.name = 'Bandung' THEN 'Bandung Trade Center'
        WHEN c.name = 'Surabaya' THEN 'Galaxy Mall'
        WHEN c.name = 'Yogyakarta' THEN 'Plaza Ambarrukmo'
        WHEN c.name = 'Medan' THEN 'Center Point'
        WHEN c.name = 'Semarang' THEN 'DP Mall'
        WHEN c.name = 'Malang' THEN 'Malang City Point'
        WHEN c.name = 'Denpasar' THEN 'Mall Bali Galeria'
        WHEN c.name = 'Makassar' THEN 'Trans Studio Mall'
        WHEN c.name = 'Palembang' THEN 'Palembang Icon'
        WHEN c.name = 'Manado' THEN 'Manado City Mall'
        WHEN c.name = 'Balikpapan' THEN 'Balikpapan Trade Center'
        WHEN c.name = 'Pekanbaru' THEN 'Pekanbaru City Center'
        WHEN c.name = 'Padang' THEN 'Padang Trade Center'
        WHEN c.name = 'Banjarmasin' THEN 'Banjarmasin Trade Center'
        WHEN c.name = 'Pontianak' THEN 'Pontianak Trade Center'
        WHEN c.name = 'Jayapura' THEN 'Jayapura Trade Center'
        WHEN c.name = 'Ambon' THEN 'Ambon Trade Center'
        WHEN c.name = 'Kupang' THEN 'Kupang Trade Center'
        WHEN c.name = 'Mataram' THEN 'Mataram Trade Center'
    END as name
FROM city_ids c
UNION ALL
SELECT 
    c.id as city_id,
    'Cine ' || 
    CASE 
        WHEN c.name = 'Jakarta' THEN 'Pacific Place'
        WHEN c.name = 'Bandung' THEN 'Festival Citylink'
        WHEN c.name = 'Surabaya' THEN 'Pakuwon Mall'
        WHEN c.name = 'Yogyakarta' THEN 'Jogja City Mall'
        WHEN c.name = 'Medan' THEN 'Thamrin Plaza'
        WHEN c.name = 'Semarang' THEN 'Ciputra Mall'
        WHEN c.name = 'Malang' THEN 'Sarinah'
        WHEN c.name = 'Denpasar' THEN 'Lippo Mall'
        WHEN c.name = 'Makassar' THEN 'Nipah Mall'
        WHEN c.name = 'Palembang' THEN 'Palembang Trade Center'
        WHEN c.name = 'Manado' THEN 'Manado Mega Mall'
        WHEN c.name = 'Balikpapan' THEN 'Balikpapan City Center'
        WHEN c.name = 'Pekanbaru' THEN 'Pekanbaru Trade Center'
        WHEN c.name = 'Padang' THEN 'Padang Plaza'
        WHEN c.name = 'Banjarmasin' THEN 'Banjarmasin Plaza'
        WHEN c.name = 'Pontianak' THEN 'Pontianak Plaza'
        WHEN c.name = 'Jayapura' THEN 'Jayapura Plaza'
        WHEN c.name = 'Ambon' THEN 'Ambon Plaza'
        WHEN c.name = 'Kupang' THEN 'Kupang Plaza'
        WHEN c.name = 'Mataram' THEN 'Mataram Plaza'
    END as name
FROM city_ids c
UNION ALL
SELECT 
    c.id as city_id,
    'Cine ' || 
    CASE 
        WHEN c.name = 'Jakarta' THEN 'Plaza Senayan'
        WHEN c.name = 'Bandung' THEN 'Cihampelas Walk'
        WHEN c.name = 'Surabaya' THEN 'Supermall Pakuwon Indah'
        WHEN c.name = 'Yogyakarta' THEN 'Malioboro Mall'
        WHEN c.name = 'Medan' THEN 'Medan Fair'
        WHEN c.name = 'Semarang' THEN 'Java Supermall'
        WHEN c.name = 'Malang' THEN 'Malang Plaza'
        WHEN c.name = 'Denpasar' THEN 'Trans Studio Mall'
        WHEN c.name = 'Makassar' THEN 'Mall Ratu Indah'
        WHEN c.name = 'Palembang' THEN 'Palembang Indah Mall'
        WHEN c.name = 'Manado' THEN 'Manado Trade Center'
        WHEN c.name = 'Balikpapan' THEN 'Balikpapan Plaza'
        WHEN c.name = 'Pekanbaru' THEN 'Pekanbaru Plaza'
        WHEN c.name = 'Padang' THEN 'Padang Grand City'
        WHEN c.name = 'Banjarmasin' THEN 'Banjarmasin Grand City'
        WHEN c.name = 'Pontianak' THEN 'Pontianak Grand City'
        WHEN c.name = 'Jayapura' THEN 'Jayapura Grand City'
        WHEN c.name = 'Ambon' THEN 'Ambon Grand City'
        WHEN c.name = 'Kupang' THEN 'Kupang Grand City'
        WHEN c.name = 'Mataram' THEN 'Mataram Grand City'
    END as name
FROM city_ids c
UNION ALL
SELECT 
    c.id as city_id,
    'Cine ' || 
    CASE 
        WHEN c.name = 'Jakarta' THEN 'Senayan City'
        WHEN c.name = 'Bandung' THEN 'Paskal 23'
        WHEN c.name = 'Surabaya' THEN 'Grand City'
        WHEN c.name = 'Yogyakarta' THEN 'Transmart Maguwo'
        WHEN c.name = 'Medan' THEN 'Cambridge City Square'
        WHEN c.name = 'Semarang' THEN 'Simpang Lima'
        WHEN c.name = 'Malang' THEN 'Dinoyo City'
        WHEN c.name = 'Denpasar' THEN 'Central Park'
        WHEN c.name = 'Makassar' THEN 'GTC Mall'
        WHEN c.name = 'Palembang' THEN 'Palembang City Center'
        WHEN c.name = 'Manado' THEN 'Manado Central Park'
        WHEN c.name = 'Balikpapan' THEN 'Balikpapan Grand City'
        WHEN c.name = 'Pekanbaru' THEN 'Pekanbaru Grand City'
        WHEN c.name = 'Padang' THEN 'Padang Mall'
        WHEN c.name = 'Banjarmasin' THEN 'Banjarmasin Mall'
        WHEN c.name = 'Pontianak' THEN 'Pontianak Mall'
        WHEN c.name = 'Jayapura' THEN 'Jayapura Mall'
        WHEN c.name = 'Ambon' THEN 'Ambon Mall'
        WHEN c.name = 'Kupang' THEN 'Kupang Mall'
        WHEN c.name = 'Mataram' THEN 'Mataram Mall'
    END as name
FROM city_ids c;

-- Drop temporary table
DROP TABLE city_ids;

-- Insert Studio Types
INSERT INTO public.t_studio_type (name, row_seats, col_seats) VALUES
('Regular', 8, 12),
('Premium', 6, 10),
('IMAX', 10, 15);

-- Create temporary table for cinema IDs
CREATE TEMPORARY TABLE cinema_ids AS
SELECT id
FROM t_cinema;

-- Create temporary table for studio sequence
CREATE TEMPORARY TABLE studio_sequence AS
SELECT 
    cinema.id as cinema_id,
    generate_series(1, 3) as studio_number
FROM cinema_ids cinema;

-- Insert Studios (3 types for each cinema)
INSERT INTO public.t_studio (cinema_id, type_id, name, col_seats, row_seats)
SELECT 
    s.cinema_id,
    s.studio_number as type_id,
    CASE 
        WHEN s.studio_number = 1 THEN 'Regular Studio'
        WHEN s.studio_number = 2 THEN 'Premium Studio'
        ELSE 'IMAX Studio'
    END as name,
    CASE 
        WHEN s.studio_number = 1 THEN 12
        WHEN s.studio_number = 2 THEN 10
        ELSE 15
    END as col_seats,
    CASE 
        WHEN s.studio_number = 1 THEN 8
        WHEN s.studio_number = 2 THEN 6
        ELSE 10
    END as row_seats
FROM studio_sequence s;

-- Drop temporary tables
DROP TABLE cinema_ids;
DROP TABLE studio_sequence;

-- Insert Movies
INSERT INTO public.t_movie (title, synopsis, genre, duration) VALUES
('The Last Adventure', 'An epic journey through uncharted territories', ARRAY['Action', 'Adventure'], 150),
('Love in Paris', 'A romantic story set in the city of love', ARRAY['Romance', 'Drama'], 120),
('Mystery of the Deep', 'A thrilling underwater exploration', ARRAY['Thriller', 'Mystery'], 135),
('Comedy Night', 'A night full of laughter and joy', ARRAY['Comedy'], 110),
('Future World', 'A sci-fi adventure in the year 2150', ARRAY['Sci-Fi', 'Action'], 160);

-- Create temporary table for studio IDs
CREATE TEMPORARY TABLE studio_ids AS
SELECT id, type_id
FROM t_studio;

-- Create temporary tables for schedule data
CREATE TEMPORARY TABLE schedule_sequence AS
SELECT 
    studio.id as studio_id,
    studio.type_id,
    (studio.id % 5) + 1 as movie_id  -- Each studio gets assigned one movie (1-5)
FROM studio_ids studio;

-- Insert Movie Studio Schedules
INSERT INTO public.t_movie_studio_schedule (studio_id, movie_id, start_time, price)
SELECT 
    s.studio_id,
    s.movie_id,
    CASE 
        WHEN s.studio_id % 4 = 1 THEN '2024-03-25 10:00:00+07'::timestamptz
        WHEN s.studio_id % 4 = 2 THEN '2024-03-25 13:00:00+07'::timestamptz
        WHEN s.studio_id % 4 = 3 THEN '2024-03-25 16:00:00+07'::timestamptz
        ELSE '2024-03-25 19:00:00+07'::timestamptz
    END as start_time,
    CASE 
        WHEN s.type_id = 1 THEN 50000
        WHEN s.type_id = 2 THEN 75000
        ELSE 100000
    END as price
FROM schedule_sequence s;

-- Drop temporary tables
DROP TABLE studio_ids;
DROP TABLE schedule_sequence;

-- Create temporary table for seat numbers
CREATE TEMPORARY TABLE seat_numbers AS
SELECT n as seat_number
FROM generate_series(1, 15) n;

-- Create temporary table for studio configurations
CREATE TEMPORARY TABLE studio_configs AS
SELECT 
    id,
    type_id,
    col_seats,
    row_seats
FROM t_studio;

-- Insert Seat Studios for all studios
INSERT INTO public.t_seat_studio (seat_type_id, seat_element_id, studio_id, row, col, price, is_available, code)
SELECT * FROM (
    -- Regular Studios (type_id = 1)
    SELECT 
        2 as seat_type_id,  -- Standard seats
        1 as seat_element_id,  -- Regular seats
        s.id as studio_id,
        row.seat_number as row,
        col.seat_number as col,
        50000 as price,
        true as is_available,
        chr((s.id / 3)::int + 64) || row.seat_number || '-' || col.seat_number as code
    FROM studio_configs s
    CROSS JOIN seat_numbers row
    CROSS JOIN seat_numbers col
    WHERE s.type_id = 1
    AND row.seat_number <= 2
    AND col.seat_number <= s.col_seats

    UNION ALL

    -- Regular Studios remaining rows
    SELECT 
        4,  -- Bean Bag seats
        1,  -- Regular seats
        s.id,
        row.seat_number,
        col.seat_number,
        75000,
        true,
        chr((s.id / 3)::int + 64) || row.seat_number || '-' || col.seat_number
    FROM studio_configs s
    CROSS JOIN seat_numbers row
    CROSS JOIN seat_numbers col
    WHERE s.type_id = 1
    AND row.seat_number BETWEEN 3 AND s.row_seats
    AND col.seat_number <= s.col_seats

    UNION ALL

    -- Premium Studios (type_id = 2)
    SELECT 
        2,  -- Standard seats
        1,  -- Regular seats
        s.id,
        row.seat_number,
        col.seat_number,
        75000,
        true,
        chr((s.id / 3)::int + 64) || row.seat_number || '-' || col.seat_number
    FROM studio_configs s
    CROSS JOIN seat_numbers row
    CROSS JOIN seat_numbers col
    WHERE s.type_id = 2
    AND row.seat_number <= 2
    AND col.seat_number <= s.col_seats

    UNION ALL

    -- Premium Studios remaining rows
    SELECT 
        5,  -- Couple seats
        1,  -- Regular seats
        s.id,
        row.seat_number,
        col.seat_number,
        100000,
        true,
        chr((s.id / 3)::int + 64) || row.seat_number || '-' || col.seat_number
    FROM studio_configs s
    CROSS JOIN seat_numbers row
    CROSS JOIN seat_numbers col
    WHERE s.type_id = 2
    AND row.seat_number BETWEEN 3 AND s.row_seats
    AND col.seat_number <= s.col_seats

    UNION ALL

    -- IMAX Studios (type_id = 3)
    SELECT 
        2,  -- Standard seats
        1,  -- Regular seats
        s.id,
        row.seat_number,
        col.seat_number,
        100000,
        true,
        chr((s.id / 3)::int + 64) || row.seat_number || '-' || col.seat_number
    FROM studio_configs s
    CROSS JOIN seat_numbers row
    CROSS JOIN seat_numbers col
    WHERE s.type_id = 3
    AND row.seat_number <= 2
    AND col.seat_number <= s.col_seats

    UNION ALL

    -- IMAX Studios remaining rows
    SELECT 
        5,  -- Couple seats
        1,  -- Regular seats
        s.id,
        row.seat_number,
        col.seat_number,
        150000,
        true,
        chr((s.id / 3)::int + 64) || row.seat_number || '-' || col.seat_number
    FROM studio_configs s
    CROSS JOIN seat_numbers row
    CROSS JOIN seat_numbers col
    WHERE s.type_id = 3
    AND row.seat_number BETWEEN 3 AND s.row_seats
    AND col.seat_number <= s.col_seats

    UNION ALL

    -- Special seats (stairs) for all studios
    SELECT 
        CASE s.type_id 
            WHEN 1 THEN 4  -- Bean Bag for Regular
            ELSE 5         -- Couple for Premium and IMAX
        END,
        2,  -- Stairs
        s.id,
        3,  -- Row 3
        CASE s.type_id 
            WHEN 1 THEN 6  -- Regular studio stairs
            WHEN 2 THEN 5  -- Premium studio stairs
            ELSE 8         -- IMAX studio stairs
        END,
        CASE s.type_id 
            WHEN 1 THEN 75000
            WHEN 2 THEN 100000
            ELSE 150000
        END,
        true,
        chr((s.id / 3)::int + 64) || '3-' || 
        CASE s.type_id 
            WHEN 1 THEN '6'
            WHEN 2 THEN '5'
            ELSE '8'
        END
    FROM studio_configs s
    WHERE s.type_id IN (1, 2, 3)

    UNION ALL

    -- Door seats for all studios
    SELECT 
        CASE s.type_id 
            WHEN 1 THEN 4  -- Bean Bag for Regular
            ELSE 5         -- Couple for Premium and IMAX
        END,
        3,  -- Door
        s.id,
        3,  -- Row 3
        1,  -- Column 1
        CASE s.type_id 
            WHEN 1 THEN 75000
            WHEN 2 THEN 100000
            ELSE 150000
        END,
        true,
        chr((s.id / 3)::int + 64) || '3-1'
    FROM studio_configs s
    WHERE s.type_id IN (1, 2, 3)
) all_seats;

-- Drop temporary tables
DROP TABLE seat_numbers;
DROP TABLE studio_configs; 