INSERT INTO worker
(id, name, birthday, level, salary)
VALUES
(1, 'Valentyn Perlovko', '1985-02-12', 'Senior', 10000),
(2, 'Ruslan Velychko', '1993-11-21', 'Senior', 9500),
(3, 'Tetyana Mastoluk', '2000-03-15', 'Senior', 9500),
(4, 'Iryna Skrypnik', '1985-05-30', 'Middle', 6500),
(5, 'Yriy Ignor', '2001-07-19', 'Middle', 6500),
(6, 'Katerina Sosedko', '1996-09-18', 'Middle', 5500),
(7, 'Anton Peremozhets', '1991-12-21', 'Junior', 3500),
(8, 'Oleksander Potroshko', '2003-06-12', 'Junior', 3500),
(9, 'Volodymyr Zverev', '1998-08-12', 'Trainee', 1000),
(10, 'Svitlana Merkurieva', '1981-11-14', 'Trainee', 900);

INSERT INTO client
(id, name)
VALUES
(1, 'ProjectingGroup'),
(2, 'AcloudTree'),
(3, 'MegaProject'),
(4, 'CrudTask'),
(5, 'VeryBigSoft');

INSERT INTO project
(id, client_id, start_date, finish_date)
VALUES
(1, 1, '2024-02-10', '2024-06-20'),
(2, 2, '2024-03-01', '2025-03-01'),
(3, 3, '2024-02-20', '2024-03-20'),
(4, 3, '2024-03-25', '2026-03-25'),
(5, 3, '2024-04-01', '2029-06-01'),
(6, 4, '2024-06-01', '2025-08-01'),
(7, 4, '2024-06-01', '2027-08-01'),
(8, 5, '2024-09-01', '2024-12-31'),
(9, 5, '2025-01-03', '2027-03-03'),
(10, 5, '2024-10-10', '2025-10-20');

INSERT INTO project_worker
(project_id, worker_id)
VALUES
(1, 3),
(1, 4),
(1, 7),
(2, 1),
(2, 5),
(3, 2),
(3, 6),
(3, 8),
(3, 10),
(4, 1),
(4, 2),
(4, 6),
(4, 7),
(4, 9),
(4, 10),
(5, 1),
(5, 4),
(6, 3),
(6, 5),
(6, 6),
(6, 9),
(6, 10),
(7, 2),
(7, 4),
(7, 8),
(7, 9),
(8, 1),
(8, 6),
(8, 7),
(8, 10),
(9, 2),
(9, 5),
(9, 8),
(10, 1),
(10, 2),
(10, 4);