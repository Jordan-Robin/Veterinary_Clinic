-- Delete tables if they exist
DROP TABLE Agendas
DROP TABLE Staff
DROP TABLE Animals
DROP TABLE Breeds
DROP TABLE Clients


-- CREATE TABLES

CREATE TABLE Staff
(
    id       INT IDENTITY(1,1) NOT NULL CONSTRAINT pk_staff PRIMARY KEY,
    name     VARCHAR(50) NOT NULL
        CONSTRAINT un_staff_name UNIQUE,
    password VARCHAR(68) NOT NULL,
    role     VARCHAR(8)  NOT NULL
        CONSTRAINT ck_staff_role CHECK (role IN ('ROLE_SEC', 'ROLE_VET', 'ROLE_ADM')),
    archive  BIT         NOT NULL
);

CREATE TABLE Clients
(
    id         INT IDENTITY(1,1) NOT NULL CONSTRAINT pk_clients PRIMARY KEY,
    last_name  VARCHAR(20),
    first_name VARCHAR(20),
    address1   VARCHAR(30) NULL,
    address2   VARCHAR(30) NULL,
    postcode   VARCHAR(6) NULL,
    city       VARCHAR(25) NULL,
    phone      VARCHAR(15) NULL,
    insurance  VARCHAR(30) NULL,
    mail       VARCHAR(20) NULL,
    comment    VARCHAR(1000) NULL,
    archive    BIT NOT NULL
);

CREATE TABLE Breeds
(
    breed   VARCHAR(20) NOT NULL,
    species VARCHAR(20) NOT NULL,
    CONSTRAINT pk_breeds PRIMARY KEY (breed, species)
);

CREATE TABLE Animals
(
    id         INT IDENTITY(1,1) NOT NULL CONSTRAINT pk_animals PRIMARY KEY,
    name       VARCHAR(30) NOT NULL,
    sex        VARCHAR(1)  NOT NULL CONSTRAINT ck_animals_sex CHECK (sex IN ('M', 'F', 'H')),
    color      VARCHAR(20) NULL,
    breed      VARCHAR(20) NOT NULL,
    species    VARCHAR(20) NOT NULL,
    client_id  INT         NOT NULL
        CONSTRAINT fk_animals_clients REFERENCES Clients (id),
    tattoo     VARCHAR(10) NOT NULL,
    antecedent VARCHAR(1000) NULL,
    archive    BIT         NOT NULL,
    CONSTRAINT fk_animals_breeds FOREIGN KEY (breed, species) REFERENCES Breeds (breed, species)
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