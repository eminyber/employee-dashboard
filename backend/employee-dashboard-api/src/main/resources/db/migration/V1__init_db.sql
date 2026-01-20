CREATE TABLE job_titles (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE projects (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE employees (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    job_title_id BIGINT NOT NULL,
    employed_date DATE NOT NULL,
    CONSTRAINT fk_employee_title FOREIGN KEY (job_title_id) REFERENCES job_titles(id),
    INDEX idx_employee_first_name (first_name),
    INDEX idx_employee_last_name (last_name),
    INDEX idx_employee_job_title (job_title_id)
);

CREATE TABLE employee_project (
    employee_id BIGINT NOT NULL,
    project_id BIGINT NOT NULL,
    PRIMARY KEY (employee_id, project_id),
    CONSTRAINT fk_employee_project_employee FOREIGN KEY (employee_id) REFERENCES employees(id) ON DELETE CASCADE,
    CONSTRAINT fk_employee_project_project FOREIGN KEY (project_id) REFERENCES projects(id) ON DELETE CASCADE
);