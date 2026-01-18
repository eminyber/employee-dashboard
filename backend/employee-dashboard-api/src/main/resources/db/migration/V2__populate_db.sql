-- --------------- Adding some titles --------------- --
INSERT IGNORE INTO title (position) VALUES ('CEO');
INSERT IGNORE INTO title (position) VALUES ('HR');
INSERT IGNORE INTO title (position) VALUES ('Sales Representative');
INSERT IGNORE INTO title (position) VALUES ('Software Developer');
INSERT IGNORE INTO title (position) VALUES ('Test Engineer');

-- --------------- Adding some projects --------------- --
INSERT IGNORE INTO project (name) VALUES ('Website Redesign');
INSERT IGNORE INTO project (name) VALUES ('Mobile App Development');
INSERT IGNORE INTO project (name) VALUES ('Internal HR System');
INSERT IGNORE INTO project (name) VALUES ('Acquiring Sales Partner');

-- --------------- Adding some employees --------------- --

INSERT IGNORE INTO employee (first_name, last_name, email, title_id, employed_date)
VALUES ('Alice', 'Johnson', 'alice.johnson@company.com', 1, '2020-01-15');

INSERT IGNORE INTO employee (first_name, last_name, email, title_id, employed_date)
VALUES ('Bob', 'Smith', 'bob.smith@company.com', 4, '2021-03-10');

INSERT IGNORE INTO employee (first_name, last_name, email, title_id, employed_date)
VALUES ('Charlie', 'Davis', 'charlie.davis@company.com', 3, '2022-07-01');

INSERT IGNORE INTO employee (first_name, last_name, email, title_id, employed_date)
VALUES ('Diana', 'Evans', 'diana.evans@company.com', 2, '2019-11-25');

INSERT IGNORE INTO employee (first_name, last_name, email, title_id, employed_date)
VALUES ('Ethan', 'Brown', 'ethan.brown@company.com', 5, '2023-01-05');

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