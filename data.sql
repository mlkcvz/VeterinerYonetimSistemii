-- CUSTOMER
INSERT INTO customer (id, name, phone, mail, address, city) VALUES
(1, 'Ali Veli', '05551112233', 'ali@example.com', 'Cadde 1', 'İstanbul'),
(2, 'Ayşe Yılmaz', '05554443322', 'ayse@example.com', 'Sokak 2', 'Ankara'),
(3, 'Mehmet Demir', '05332221144', 'mehmet@example.com', 'Mahalle 3', 'İzmir'),
(4, 'Zeynep Korkmaz', '05443332211', 'zeynep@example.com', 'Apartman 4', 'Antalya'),
(5, 'Burak Çelik', '05221113344', 'burak@example.com', 'Ev 5', 'Bursa');

-- DOCTOR
INSERT INTO doctor (id, name, phone, mail, address, city) VALUES
(1, 'Dr. Emre Kaya', '05001112233', 'emre@vet.com', 'Klinik 1', 'İstanbul'),
(2, 'Dr. Selin Aras', '05002223344', 'selin@vet.com', 'Klinik 2', 'İzmir'),
(3, 'Dr. Can Yıldız', '05003334455', 'can@vet.com', 'Klinik 3', 'Ankara'),
(4, 'Dr. Elif Güneş', '05004445566', 'elif@vet.com', 'Klinik 4', 'Bursa'),
(5, 'Dr. Deniz Kurt', '05005556677', 'deniz@vet.com', 'Klinik 5', 'Adana');

-- ANIMAL
INSERT INTO animal (id, name, species, breed, gender, colour, date_of_birth, customer_id) VALUES
(1, 'Karamel', 'Kedi', 'Tekir', 'Dişi', 'Sarı', '2020-06-15', 1),
(2, 'Max', 'Köpek', 'Golden Retriever', 'Erkek', 'Sarı', '2019-04-20', 2),
(3, 'Mia', 'Kedi', 'British Shorthair', 'Dişi', 'Gri', '2021-02-10', 3),
(4, 'Tarçın', 'Köpek', 'Poodle', 'Dişi', 'Beyaz', '2018-11-30', 4),
(5, 'Leo', 'Kedi', 'Van Kedisi', 'Erkek', 'Beyaz', '2022-01-05', 5);

-- AVAILABLE_DATE
INSERT INTO available_date (id, doctor_id, available_date) VALUES
(1, 1, '2025-07-02'),
(2, 1, '2025-07-03'),
(3, 2, '2025-07-02'),
(4, 3, '2025-07-03'),
(5, 4, '2025-07-04');

-- APPOINTMENT
INSERT INTO appointment (id, appointment_date, doctor_id, animal_id) VALUES
(1, '2025-07-02 10:00:00', 1, 1),
(2, '2025-07-02 11:00:00', 1, 2),
(3, '2025-07-03 10:30:00', 2, 3),
(4, '2025-07-03 14:00:00', 3, 4),
(5, '2025-07-04 09:00:00', 4, 5);

-- VACCINE
INSERT INTO vaccine (id, name, code, protection_start_date, protection_finish_date, animal_id) VALUES
(1, 'Kuduz Aşısı', 'RAB123', '2024-01-01', '2025-01-01', 1),
(2, 'Parvo Aşısı', 'PAR456', '2024-03-01', '2025-03-01', 2),
(3, 'Corona Aşısı', 'COR789', '2024-02-15', '2025-02-15', 3),
(4, 'Karma Aşı', 'KAR321', '2024-04-20', '2025-04-20', 4),
(5, 'Mikrochip', 'MIC654', '2024-05-10', '2030-05-10', 5);
