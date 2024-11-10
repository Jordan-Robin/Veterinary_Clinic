-- Delete tables if they exist
DROP TABLE Staff_Authorities
DROP TABLE Authorities
DROP TABLE Agendas
DROP TABLE Staff
DROP TABLE Animals
DROP TABLE Breeds
DROP TABLE Clients


-- CREATE TABLES

CREATE TABLE Staff
(
    id       INT IDENTITY (1,1) NOT NULL
        CONSTRAINT pk_staff PRIMARY KEY,
    name     VARCHAR(50)        NOT NULL,
    mail     VARCHAR(40)        NOT NULL
        CONSTRAINT un_staff_mail UNIQUE,
    password VARCHAR(68)        NOT NULL,
    active   BIT                NOT NULL
);

CREATE TABLE Authorities
(
    id   INT IDENTITY (1,1) NOT NULL
        CONSTRAINT pk_authorities PRIMARY KEY,
    role VARCHAR(8)         NOT NULL
        CONSTRAINT ck_staff_role CHECK (role IN ('ROLE_SEC', 'ROLE_VET', 'ROLE_ADM'))
);

CREATE TABLE Staff_Authorities
(
    staff_id INT NOT NULL
        CONSTRAINT fk_staff_authorities_staff REFERENCES Staff (id),
    role_id  INT NOT NULL
        CONSTRAINT fk_staff_authorities_authorities REFERENCES Authorities (id),
    CONSTRAINT pk_staff_authorities PRIMARY KEY (staff_id, role_id)
);

CREATE TABLE Clients
(
    id         INT IDENTITY (1,1) NOT NULL
        CONSTRAINT pk_clients PRIMARY KEY,
    last_name  VARCHAR(20),
    first_name VARCHAR(20),
    address1   VARCHAR(30)        NULL,
    address2   VARCHAR(30)        NULL,
    postcode   VARCHAR(6)         NULL,
    city       VARCHAR(25)        NULL,
    phone      VARCHAR(15)        NULL,
    insurance  VARCHAR(30)        NULL,
    mail       VARCHAR(20)        NULL,
    comment    VARCHAR(1000)      NULL,
    active     BIT                NOT NULL
);

CREATE TABLE Breeds
(
    id      INT IDENTITY (1,1) NOT NULL
        CONSTRAINT pk_breeds PRIMARY KEY,
    breed   VARCHAR(20)        NOT NULL,
    species VARCHAR(20)        NOT NULL
);

CREATE TABLE Animals
(
    id         INT IDENTITY (1,1) NOT NULL
        CONSTRAINT pk_animals PRIMARY KEY,
    name       VARCHAR(30)        NOT NULL,
    sex        VARCHAR(1)         NOT NULL
        CONSTRAINT ck_animals_sex CHECK (sex IN ('M', 'F', 'H')),
    color      VARCHAR(20)        NULL,
    breed_id   INT                NOT NULL
        CONSTRAINT fk_animals_breeds REFERENCES Breeds (id),
    client_id  INT                NOT NULL
        CONSTRAINT fk_animals_clients REFERENCES Clients (id),
    tattoo     VARCHAR(10)        NOT NULL,
    antecedent VARCHAR(1000)      NULL,
    active     BIT                NOT NULL
);

CREATE TABLE Agendas
(
    veto_id   INT      NOT NULL
        CONSTRAINT fk_agendas_staff REFERENCES Staff (id),
    apt_date  DATETIME NOT NULL,
    animal_id INT      NOT NULL
        CONSTRAINT fk_agendas_animals REFERENCES Animals (id),
    CONSTRAINT pk_agendas PRIMARY KEY (veto_id, apt_date, animal_id)
);


-- INSERT DATAS

INSERT INTO Staff (name, mail, password, active)
VALUES (N'Mélanie MALALANICH', 'melanie-malalanich@vet.com',
        '$2a$10$ea8mS9Jkra8xXOn82oDk6e0oqFJbyMom5pAfnLgTYK7qVBJw5GJwK', 1);--password : malalanich
INSERT INTO Staff (name, mail, password, active)
VALUES ('Anne AIMONE', 'anne-aimone@vet.com', '$2a$10$ZZ/G7OJWtQD8YwxOb1/YhOlTEZlnsHrbdIuXkwPxzgeyjhdIesSii', 1);--password : aimone
INSERT INTO Staff (name, mail, password, active)
VALUES ('Sylvain TOURNE', 'sylvain-tourne@vet.com', '$2a$10$Lsk4Nw4YgbzvfP3jojnhse5NxqX4XzV0vms3uAxicgdvR5zmIQ7Pa', 1);--password : tourne
INSERT INTO Staff (name, mail, password, active)
VALUES ('Odette DE JEU', 'odette-dejeu@vet.com', '$2a$10$lVPq.//YS1UhC3hjG6Y.1uR4wFhbb3jA5ctR88fTfjDSbIAByyzsy', 1);--password : dejeu
INSERT INTO Staff (name, mail, password, active)
VALUES ('Elisabeth ABONDIEU', 'elisabeth-abondieu@vet.com',
        '$2a$10$2.3ZJDLQuj4tpPb5264ZVeHQ159dvclC6ScAnGZlgiOlTm0kCQ2DO', 1);--password : abondieu
INSERT INTO Staff (name, mail, password, active)
VALUES ('Marie Paule HISSON', 'mariepaule-hisson@vet.com',
        '$2a$10$SiNJ4.zHSFSKYwe7fytGweq5dD5n.Ilm2jHmmzWnMOFaZzP1ysOKi', 1);--password : hisson
INSERT INTO Staff (name, mail, password, active)
VALUES (N'Benoît DE CAJOU', 'benoit-decajou@vet.com', '$2a$10$j2i92vi8T76Fa60Inq50De6P/b28kQPjcwG6eYliOJW8CdT3tsdgq',
        1);--password : decajou

INSERT INTO Authorities (role)
VALUES ('ROLE_SEC');
INSERT INTO Authorities (role)
VALUES ('ROLE_VET');
INSERT INTO Authorities (role)
VALUES ('ROLE_ADM');

INSERT INTO Staff_Authorities (staff_id, role_id)
VALUES (1, 2);
INSERT INTO Staff_Authorities (staff_id, role_id)
VALUES (2, 2);
INSERT INTO Staff_Authorities (staff_id, role_id)
VALUES (3, 2);
INSERT INTO Staff_Authorities (staff_id, role_id)
VALUES (4, 1);
INSERT INTO Staff_Authorities (staff_id, role_id)
VALUES (5, 1);
INSERT INTO Staff_Authorities (staff_id, role_id)
VALUES (6, 1);
INSERT INTO Staff_Authorities (staff_id, role_id)
VALUES (7, 3);
INSERT INTO Staff_Authorities (staff_id, role_id)
VALUES (7, 2);


-- QUERIES

SELECT *
FROM Staff;
SELECT *
FROM Authorities;
SELECT *
FROM Staff_Authorities;

SELECT S.mail AS username, A.role AS authority
FROM Staff S
         INNER JOIN Staff_Authorities AS SA ON S.id = SA.staff_id
         INNER JOIN Authorities AS A ON SA.role_id = A.id
WHERE S.mail = ?;