CREATE TABLE title (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    position VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE project (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE employee (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    title_id BIGINT NOT NULL,
    employed_date DATE,
    CONSTRAINT fk_employee_title FOREIGN KEY (title_id) REFERENCES title(id)
);

CREATE TABLE employee_project (
    employee_id BIGINT NOT NULL,
    project_id BIGINT NOT NULL,
    PRIMARY KEY (employee_id, project_id),
    CONSTRAINT fk_employee_project_employee FOREIGN KEY (employee_id) REFERENCES employee(id),
    CONSTRAINT fk_employee_project_project FOREIGN KEY (project_id) REFERENCES project(id)
);