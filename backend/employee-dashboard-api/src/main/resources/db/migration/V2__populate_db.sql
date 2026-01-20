-- --------------- Adding some titles --------------- --
INSERT IGNORE INTO job_titles (title) VALUES ('CEO');
INSERT IGNORE INTO job_titles (title) VALUES ('HR');
INSERT IGNORE INTO job_titles (title) VALUES ('Sales Representative');
INSERT IGNORE INTO job_titles (title) VALUES ('Software Developer');
INSERT IGNORE INTO job_titles (title) VALUES ('Test Engineer');
INSERT IGNORE INTO job_titles (title) VALUES ('Marketing Manager');
INSERT IGNORE INTO job_titles (title) VALUES ('Product Manager');
INSERT IGNORE INTO job_titles (title) VALUES ('Data Scientist');

-- --------------- Adding some projects --------------- --
INSERT IGNORE INTO projects (name) VALUES ('Website Redesign');
INSERT IGNORE INTO projects (name) VALUES ('Mobile App Development');
INSERT IGNORE INTO projects (name) VALUES ('Internal HR System');
INSERT IGNORE INTO projects (name) VALUES ('Acquiring Sales Partner');
INSERT IGNORE INTO projects (name) VALUES ('E-commerce Platform');
INSERT IGNORE INTO projects (name) VALUES ('Customer Support Portal');

-- --------------- Adding some employees --------------- --

INSERT IGNORE INTO employees (first_name, last_name, email, job_title_id, employed_date)
VALUES ('Alice', 'Johnson', 'alice.johnson@company.com', 1, '2020-01-15');

INSERT IGNORE INTO employees (first_name, last_name, email, job_title_id, employed_date)
VALUES ('Bob', 'Smith', 'bob.smith@company.com', 4, '2021-03-10');

INSERT IGNORE INTO employees (first_name, last_name, email, job_title_id, employed_date)
VALUES ('Charlie', 'Davis', 'charlie.davis@company.com', 3, '2022-07-01');

INSERT IGNORE INTO employees (first_name, last_name, email, job_title_id, employed_date)
VALUES ('Diana', 'Evans', 'diana.evans@company.com', 2, '2019-11-25');

INSERT IGNORE INTO employees (first_name, last_name, email, job_title_id, employed_date)
VALUES ('Ethan', 'Brown', 'ethan.brown@company.com', 5, '2023-01-05');

INSERT IGNORE INTO employees (first_name, last_name, email, job_title_id, employed_date)
VALUES ('Gina', 'Mitchell', 'gina.mitchell@company.com', 6, '2021-06-15');

-- Employee 2 - Product Manager, assigned to 'E-commerce Platform'
INSERT IGNORE INTO employees (first_name, last_name, email, job_title_id, employed_date)
VALUES ('Henry', 'Fisher', 'henry.fisher@company.com', 7, '2020-03-20');

-- Employee 3 - Data Scientist, assigned to 'Customer Support Portal'
INSERT IGNORE INTO employees (first_name, last_name, email, job_title_id, employed_date)
VALUES ('Isabella', 'Lee', 'isabella.lee@company.com', 8, '2022-01-25');

-- Employee 4 - Sales Representative, no project
INSERT IGNORE INTO employees (first_name, last_name, email, job_title_id, employed_date)
VALUES ('James', 'Walker', 'james.walker@company.com', 3, '2020-07-10');

-- Employee 5 - CEO, assigned to 'E-commerce Platform'
INSERT IGNORE INTO employees (first_name, last_name, email, job_title_id, employed_date)
VALUES ('Kim', 'Taylor', 'kim.taylor@company.com', 2, '2019-10-01');

-- Employee 6 - HR, assigned to 'Internal HR System'
INSERT IGNORE INTO employees (first_name, last_name, email, job_title_id, employed_date)
VALUES ('Liam', 'Gonzalez', 'liam.gonzalez@company.com', 2, '2021-12-05');

-- Employee 7 - Test Engineer, no project
INSERT IGNORE INTO employees (first_name, last_name, email, job_title_id, employed_date)
VALUES ('Mia', 'Brown', 'mia.brown@company.com', 5, '2023-02-13');

-- Employee 8 - Software Developer, assigned to 'Website Redesign'
INSERT IGNORE INTO employees (first_name, last_name, email, job_title_id, employed_date)
VALUES ('Nathan', 'Harris', 'nathan.harris@company.com', 4, '2021-07-25');

-- Employee 9 - Data Scientist, no project
INSERT IGNORE INTO employees (first_name, last_name, email, job_title_id, employed_date)
VALUES ('Olivia', 'King', 'olivia.king@company.com', 8, '2022-08-30');

-- Employee 10 - Marketing Manager, assigned to 'Customer Support Portal'
INSERT IGNORE INTO employees (first_name, last_name, email, job_title_id, employed_date)
VALUES ('Paul', 'Evans', 'paul.evans@company.com', 6, '2020-11-14');

-- Employee 11 - Product Manager, no project
INSERT IGNORE INTO employees (first_name, last_name, email, job_title_id, employed_date)
VALUES ('Quinn', 'Martinez', 'quinn.martinez@company.com', 7, '2021-04-12');

-- Employee 12 - CEO, assigned to 'Acquiring Sales Partner'
INSERT IGNORE INTO employees (first_name, last_name, email, job_title_id, employed_date)
VALUES ('Rachel', 'Scott', 'rachel.scott@company.com', 2, '2018-09-22');

-- Employee 13 - Software Developer, assigned to 'Mobile App Development'
INSERT IGNORE INTO employees (first_name, last_name, email, job_title_id, employed_date)
VALUES ('Steve', 'Young', 'steve.young@company.com', 4, '2022-03-04');

-- Employee 14 - Test Engineer, no project
INSERT IGNORE INTO employees (first_name, last_name, email, job_title_id, employed_date)
VALUES ('Tara', 'Rodriguez', 'tara.rodriguez@company.com', 5, '2023-01-30');

-- Employee 15 - Data Scientist, assigned to 'Customer Support Portal'
INSERT IGNORE INTO employees (first_name, last_name, email, job_title_id, employed_date)
VALUES ('Uma', 'Davis', 'uma.davis@company.com', 8, '2021-09-16');

-- Employee 16 - Marketing Manager, no project
INSERT IGNORE INTO employees (first_name, last_name, email, job_title_id, employed_date)
VALUES ('Vera', 'Perez', 'vera.perez@company.com', 6, '2022-07-22');

-- Employee 17 - Product Manager, assigned to 'E-commerce Platform'
INSERT IGNORE INTO employees (first_name, last_name, email, job_title_id, employed_date)
VALUES ('William', 'Morris', 'william.morris@company.com', 7, '2020-02-05');

-- Employee 18 - Software Developer, no project
INSERT IGNORE INTO employees (first_name, last_name, email, job_title_id, employed_date)
VALUES ('Xander', 'Adams', 'xander.adams@company.com', 4, '2023-01-22');

-- Employee 19 - HR, assigned to 'Internal HR System'
INSERT IGNORE INTO employees (first_name, last_name, email, job_title_id, employed_date)
VALUES ('Yara', 'Bennett', 'yara.bennett@company.com', 2, '2020-11-07');

-- Employee 20 - Test Engineer, assigned to 'Mobile App Development'
INSERT IGNORE INTO employees (first_name, last_name, email, job_title_id, employed_date)
VALUES ('Zane', 'Carter', 'zane.carter@company.com', 5, '2021-12-20');

-- Employee 63 - Marketing Manager, no project
INSERT IGNORE INTO employees (first_name, last_name, email, job_title_id, employed_date)
VALUES ('Aaron', 'Williams', 'aaron.williams@company.com', 6, '2022-04-19');

-- Employee 64 - Product Manager, assigned to 'E-commerce Platform'
INSERT IGNORE INTO employees (first_name, last_name, email, job_title_id, employed_date)
VALUES ('Bella', 'Johnson', 'bella.johnson@company.com', 7, '2020-02-03');

-- Employee 65 - Data Scientist, no project
INSERT IGNORE INTO employees (first_name, last_name, email, job_title_id, employed_date)
VALUES ('Carlos', 'Martinez', 'carlos.martinez@company.com', 8, '2021-10-11');

-- Employee 66 - Sales Representative, assigned to 'Customer Support Portal'
INSERT IGNORE INTO employees (first_name, last_name, email, job_title_id, employed_date)
VALUES ('Diana', 'Garcia', 'diana.garcia@company.com', 3, '2022-06-21');

-- Employee 67 - Test Engineer, no project
INSERT IGNORE INTO employees (first_name, last_name, email, job_title_id, employed_date)
VALUES ('Edward', 'Lopez', 'edward.lopez@company.com', 5, '2023-03-15');

-- Employee 68 - Software Developer, assigned to 'Mobile App Development'
INSERT IGNORE INTO employees (first_name, last_name, email, job_title_id, employed_date)
VALUES ('Fiona', 'Thomas', 'fiona.thomas@company.com', 4, '2021-05-12');

-- Employee 69 - Marketing Manager, no project
INSERT IGNORE INTO employees (first_name, last_name, email, job_title_id, employed_date)
VALUES ('George', 'Hernandez', 'george.hernandez@company.com', 6, '2020-07-23');

-- Employee 70 - Product Manager, assigned to 'Website Redesign'
INSERT IGNORE INTO employees (first_name, last_name, email, job_title_id, employed_date)
VALUES ('Hannah', 'Rodriguez', 'hannah.rodriguez@company.com', 7, '2021-01-08');

-- Employee 71 - Data Scientist, assigned to 'Customer Support Portal'
INSERT IGNORE INTO employees (first_name, last_name, email, job_title_id, employed_date)
VALUES ('Ian', 'Young', 'ian.young@company.com', 8, '2022-02-25');

-- Employee 72 - Sales Representative, no project
INSERT IGNORE INTO employees (first_name, last_name, email, job_title_id, employed_date)
VALUES ('Jack', 'Walker', 'jack.walker@company.com', 3, '2022-12-10');

-- Employee 73 - Test Engineer, assigned to 'Website Redesign'
INSERT IGNORE INTO employees (first_name, last_name, email, job_title_id, employed_date)
VALUES ('Kara', 'Perez', 'kara.perez@company.com', 5, '2021-09-06');

-- Employee 74 - Software Developer, assigned to 'Acquiring Sales Partner'
INSERT IGNORE INTO employees (first_name, last_name, email, job_title_id, employed_date)
VALUES ('Liam', 'Taylor', 'liam.taylor@company.com', 4, '2022-03-22');

-- Employee 75 - Marketing Manager, assigned to 'Customer Support Portal'
INSERT IGNORE INTO employees (first_name, last_name, email, job_title_id, employed_date)
VALUES ('Megan', 'Miller', 'megan.miller@company.com', 6, '2020-09-15');

-- Employee 76 - Product Manager, no project
INSERT IGNORE INTO employees (first_name, last_name, email, job_title_id, employed_date)
VALUES ('Nathan', 'Davis', 'nathan.davis@company.com', 7, '2023-01-13');

-- Employee 77 - Data Scientist, no project
INSERT IGNORE INTO employees (first_name, last_name, email, job_title_id, employed_date)
VALUES ('Olivia', 'Martinez', 'olivia.martinez@company.com', 8, '2021-08-30');

-- Employee 78 - Sales Representative, assigned to 'Internal HR System'
INSERT IGNORE INTO employees (first_name, last_name, email, job_title_id, employed_date)
VALUES ('Paul', 'Evans', 'paul.evans@company.com', 3, '2022-10-14');

-- Employee 79 - Test Engineer, assigned to 'Mobile App Development'
INSERT IGNORE INTO employees (first_name, last_name, email, job_title_id, employed_date)
VALUES ('Quincy', 'Harris', 'quincy.harris@company.com', 5, '2023-02-06');

-- Employee 80 - Software Developer, assigned to 'E-commerce Platform'
INSERT IGNORE INTO employees (first_name, last_name, email, job_title_id, employed_date)
VALUES ('Rebecca', 'Gonzalez', 'rebecca.gonzalez@company.com', 4, '2022-11-09');

-- Employee 81 - Marketing Manager, assigned to 'Acquiring Sales Partner'
INSERT IGNORE INTO employees (first_name, last_name, email, job_title_id, employed_date)
VALUES ('Samuel', 'Lopez', 'samuel.lopez@company.com', 6, '2021-06-28');

-- Employee 82 - Product Manager, no project
INSERT IGNORE INTO employees (first_name, last_name, email, job_title_id, employed_date)
VALUES ('Tina', 'Roberts', 'tina.roberts@company.com', 7, '2023-04-17');

-- Employee 83 - Data Scientist, assigned to 'E-commerce Platform'
INSERT IGNORE INTO employees (first_name, last_name, email, job_title_id, employed_date)
VALUES ('Ursula', 'Wilson', 'ursula.wilson@company.com', 8, '2020-12-03');

-- Employee 84 - Sales Representative, no project
INSERT IGNORE INTO employees (first_name, last_name, email, job_title_id, employed_date)
VALUES ('Victor', 'White', 'victor.white@company.com', 3, '2021-11-19');

-- --------------- Assign employees to projects --------------- --

INSERT IGNORE INTO employee_project (employee_id, project_id)
VALUES (1, 1);

INSERT IGNORE INTO employee_project (employee_id, project_id)
VALUES (2, 2);

INSERT IGNORE INTO employee_project (employee_id, project_id)
VALUES (3, 4);

INSERT IGNORE INTO employee_project (employee_id, project_id)
VALUES (4, 3);

INSERT IGNORE INTO employee_project (employee_id, project_id)
VALUES (5, 1);

INSERT IGNORE INTO employee_project (employee_id, project_id)
VALUES (5, 2);

INSERT IGNORE INTO employee_project (employee_id, project_id)
VALUES (2, 5);

-- Assign some employees to 'Customer Support Portal'
INSERT IGNORE INTO employee_project (employee_id, project_id)
VALUES (3, 6);

-- Assign some employees to 'Acquiring Sales Partner'
INSERT IGNORE INTO employee_project (employee_id, project_id)
VALUES (12, 4);

-- Assign employees to 'Website Redesign'
INSERT IGNORE INTO employee_project (employee_id, project_id)
VALUES (8, 1);

-- Assign employees to 'Mobile App Development'
INSERT IGNORE INTO employee_project (employee_id, project_id)
VALUES (13, 2);

-- Assign employees to 'Internal HR System'
INSERT IGNORE INTO employee_project (employee_id, project_id)
VALUES (4, 3);

INSERT IGNORE INTO employee_project (employee_id, project_id)
VALUES (66, 1), (75, 1), (73, 1);

-- Assign some employees to 'Mobile App Development'
INSERT IGNORE INTO employee_project (employee_id, project_id)
VALUES (68, 2), (79, 2), (80, 2);

-- Assign some employees to 'Acquiring Sales Partner'
INSERT IGNORE INTO employee_project (employee_id, project_id)
VALUES (74, 4), (81, 4);

-- Assign some employees to 'Customer Support Portal'
INSERT IGNORE INTO employee_project (employee_id, project_id)
VALUES (64, 6), (71, 6), (75, 6);

-- Assign some employees to 'Internal HR System'
INSERT IGNORE INTO employee_project (employee_id, project_id)
VALUES (78, 3);

-- Assign some employees to 'E-commerce Platform'
INSERT IGNORE INTO employee_project (employee_id, project_id)
VALUES (64, 5), (80, 5), (83, 5);