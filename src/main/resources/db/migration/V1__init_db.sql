CREATE TABLE worker (
    id INT PRIMARY KEY,
    name VARCHAR (1000) CHECK (LENGTH(name) > 2) NOT NULL,
    birthday DATE CHECK (birthday > '1900-12-31'),
    level ENUM ('Trainee', 'Junior', 'Middle', 'Senior') NOT NULL ,
    salary INT CHECK (salary > 99 AND salary < 100001)
);

CREATE TABLE client (
    id BIGINT PRIMARY KEY,
    name VARCHAR (1000) CHECK (LENGTH(name) > 2) NOT NULL
);

CREATE TABLE project (
    id BIGINT PRIMARY KEY,
    client_id BIGINT,
    start_date DATE,
    finish_date DATE
);

ALTER TABLE project
ADD CONSTRAINT client_id_fk
FOREIGN KEY (client_id)
REFERENCES client(id);

CREATE TABLE project_worker (
    project_id BIGINT NOT NULL,
    worker_id BIGINT NOT NULL,
    PRIMARY KEY (project_id, worker_id),
    FOREIGN KEY (project_id) REFERENCES project(id),
    FOREIGN KEY (worker_id) REFERENCES worker(id)
);
