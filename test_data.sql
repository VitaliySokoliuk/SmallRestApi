use air_management;
insert into air_company(company_type, founded_at, name)
values ('INTERNATIONAL', '2021-06-10', 'Turkish Airlines'),
	('INTERNATIONAL', '2020-03-16', 'AirBaltic'),
	('REGIONAL', '2014-11-04', 'Lufthansa'),
	('NATIONAL', '2004-06-12', 'LOT');
    
insert into airplane(name, factory_serial_number, air_company_id, number_of_flights, flight_distance, fuel_capacity, airplane_type, created_at)
values ('Airbus A380', 'ABCD-0433-OTIJ-34KR', 1, 0, 0, 32940, 'WIDE_BODY', '2021-01-10'),
	('Air Force One', 'HRYI-U4UH-IR78-09I5', 1, 0, 0, 41720, 'NARROW_BODY', '2020-11-30'),
    ('Air Force One', 'HRYI-U4UH-IR78-09B5', 1, 0, 0, 41720, 'NARROW_BODY', '2015-02-17'),
    ('Concorde', 'IUTN-492R-0954-RU23', 2, 0, 0, 26975, 'WIDE_BODY', '2011-01-20'),
    ('Concorde', 'IUTN-492R-0954-RU24', 2, 0, 0, 26975, 'WIDE_BODY', '2020-02-06'),
    ('The Wright Flyer', 'RHTI-495H-2JNF-04J0', 2, 0, 0, 12805, 'COMMUTER', '2021-08-04'),
    ('Concorde', 'IUTN-492R-0954-RU28', 3, 0, 0, 26975, 'WIDE_BODY', '2020-05-10'),
    ('Lockheed Vega 5b', '85HN-2NJR-5IUW-4NFR', 3, 0, 0, 10100, 'REGIONAL', '2020-01-17'),
    ('The Wright Flyer', 'RHTI-495H-2JNF-04J2', 3, 0, 0, 12805, 'COMMUTER', '2019-12-22'),
    ('The Wright Flyer', 'RHTI-495H-2JNF-04J4', 4, 0, 0, 12805, 'COMMUTER', '2011-10-18'),
    ('The Wright Flyer', 'RHTI-495H-2JNF-04J3', 4, 0, 0, 12805, 'COMMUTER', '2018-04-11');
    
insert into flight(flight_status, air_company_id, airplane_id, departure_city, destination_city, distance, estimated_flight_time, delay_started_at, started_at, ended_at, created_at, arrives_at)
values ('PENDING', 1, 1, 'Istambul', 'Kyiv', 1322, '02:12:40', null, null, null, '2021-06-10 20:06:40', '2021-08-14 16:35:30'),
	('PENDING', 1, 2, 'Istambul', 'Prague', 1754, '02:47:20', null, null, null, '2021-06-10 20:07:25', '2021-08-14 16:35:30'),
    ('PENDING', 1, 2, 'Istambul', 'London', 3308, '04:16:10', null, null, null, '2021-06-10 20:07:10', '2021-08-14 16:35:30'),
    ('PENDING', 1, 3, 'Ankara', 'Warsaw', 1712, '02:45:40', null, null, null, '2021-06-10 20:07:45', '2021-08-14 16:35:30'),
    ('PENDING', 1, 4, 'Ankara', 'Lviv', 1289, '02:10:45', null, null, null, '2021-06-10 20:08:50', '2021-08-14 16:35:30'),
    ('PENDING', 2, 4, 'Vilnius', 'Kyiv', 570, '01:10:20', null, null, null, '2021-06-10 20:08:35', '2021-08-14 16:35:30'),
    ('PENDING', 2, 5, 'Riga', 'Helsinki', 407, '01:03:50', null, null, null, '2021-06-10 20:11:20', '2021-08-14 16:35:30'),
    ('PENDING', 2, 6, 'Tallin', 'Riga', 340, '00:57:30', null, null, null, '2021-06-10 20:12:15', '2021-08-14 16:35:30'),
    ('PENDING', 2, 6, 'Helsinki', 'Stockholm', 412, '01:08:05', null, null, null, '2021-06-10 20:12:50', '2021-08-14 16:35:30'),
    ('PENDING', 2, 7, 'Stockholm', 'Kyiv', 1634, '02:34:25', null, null, null, '2021-06-10 20:14:35', '2021-08-14 16:35:30'),
    ('PENDING', 3, 8, 'Berlin', 'Frankfurt', 483, '01:04:45', null, null, null, '2021-06-10 20:15:20', '2021-08-14 16:35:30'),
    ('PENDING', 3, 9, 'Munich', 'Berlin', 711, '01:27:55', null, null, null, '2021-06-10 20:16:45', '2021-08-14 16:35:30'),
    ('PENDING', 3, 9, 'Leipzig', 'Berlin', 214, '00:24:30', null, null, null, '2021-06-10 20:18:40', '2021-08-14 16:35:30'),
    ('PENDING', 3, 10, 'Frankfurt', 'Leipzig', 469, '01:05:10', null, null, null, '2021-06-10 20:18:15', '2021-08-14 16:35:30'),
    ('PENDING', 4, 10, 'Poznan', 'Gdansk', 270, '00:29:20', null, null, null, '2021-06-10 20:22:00', '2021-08-14 16:35:30'),
    ('PENDING', 4, 11, 'Warsaw', 'Poznan', 248, '00:28:40', null, null, null, '2021-06-10 20:24:40', '2021-08-14 16:35:30'),
    ('PENDING', 4, 11, 'Gdansk', 'Warsaw', 284, '00:30:35', null, null, null, '2021-06-10 20:25:05', '2021-08-14 16:35:30');






