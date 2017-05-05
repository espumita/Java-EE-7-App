CREATE TABLE patients (
  dni VARCHAR(20) PRIMARY KEY,
  name VARCHAR(20) NOT NULL,
  gender VARCHAR(20) NOT NULL,
  age INT NOT NULL,
  address VARCHAR(20) NOT NULL
);

CREATE TABLE doctors (
  dni VARCHAR(20) PRIMARY KEY,
  name VARCHAR(20) NOT NULL
);

CREATE TABLE relations (
  patientDni VARCHAR(20) PRIMARY KEY,
  doctorDni VARCHAR(20) NOT NULL
);

CREATE TABLE samples (
  id BIGSERIAL PRIMARY KEY,
  patientDni VARCHAR(20) NOT NULL,
  glucoseLevel INT NOT NULL,
  date VARCHAR(50) NOT NULL
);

INSERT INTO patients(  dni, name, gender, age, address)
VALUES ('patient', 'David Jesus', 'Male', 20, 'Las Palmas');

INSERT INTO patients(  dni, name, gender, age, address)
VALUES ('45345345A', 'Jesus', 'Male', 22, 'Tenerfie');

INSERT INTO patients(  dni, name, gender, age, address)
VALUES ('45345345B', 'Maria', 'Female', 36, 'Madrid');

INSERT INTO patients(  dni, name, gender, age, address)
VALUES ('45345345C', 'David', 'Male', 40, 'Arucas');


INSERT INTO doctors(  dni, name) VALUES ('doctor', 'Jhon Smith');
INSERT INTO doctors(  dni, name) VALUES ('00000000A', 'House');


INSERT INTO relations( patientDni, doctorDni) VALUES ('patient', 'doctor');
INSERT INTO relations( patientDni, doctorDni) VALUES ('45345345A', 'doctor');
INSERT INTO relations( patientDni, doctorDni) VALUES ('45345345B', '00000000A');
INSERT INTO relations( patientDni, doctorDni) VALUES ('45345345C', '00000000A');


INSERT INTO samples(patientDni, glucoseLevel, date) VALUES ('patient', 100, 'Fri May 05 11:36:08 WEST 2017');
INSERT INTO samples(patientDni, glucoseLevel, date) VALUES ('patient', 70, 'Fri May 06 11:36:08 WEST 2017');
INSERT INTO samples(patientDni, glucoseLevel, date) VALUES ('patient', 100, 'Fri May 07 11:36:08 WEST 2017');
INSERT INTO samples(patientDni, glucoseLevel, date) VALUES ('patient', 200, 'Fri May 08 11:36:08 WEST 2017');
INSERT INTO samples(patientDni, glucoseLevel, date) VALUES ('patient', 90, 'Fri May 09 11:36:08 WEST 2017');

INSERT INTO samples(patientDni, glucoseLevel, date) VALUES ('45345345A', 100, 'Fri May 05 11:36:08 WEST 2017');
INSERT INTO samples(patientDni, glucoseLevel, date) VALUES ('45345345A', 70, 'Fri May 06 11:36:08 WEST 2017');
INSERT INTO samples(patientDni, glucoseLevel, date) VALUES ('45345345A', 100, 'Fri May 07 11:36:08 WEST 2017');
INSERT INTO samples(patientDni, glucoseLevel, date) VALUES ('45345345A', 200, 'Fri May 08 11:36:08 WEST 2017');
INSERT INTO samples(patientDni, glucoseLevel, date) VALUES ('45345345A', 90, 'Fri May 09 11:36:08 WEST 2017');

INSERT INTO samples(patientDni, glucoseLevel, date) VALUES ('45345345B', 100, 'Fri May 05 11:36:08 WEST 2017');
INSERT INTO samples(patientDni, glucoseLevel, date) VALUES ('45345345B', 70, 'Fri May 06 11:36:08 WEST 2017');
INSERT INTO samples(patientDni, glucoseLevel, date) VALUES ('45345345B', 100, 'Fri May 07 11:36:08 WEST 2017');
INSERT INTO samples(patientDni, glucoseLevel, date) VALUES ('45345345B', 200, 'Fri May 08 11:36:08 WEST 2017');
INSERT INTO samples(patientDni, glucoseLevel, date) VALUES ('45345345B', 90, 'Fri May 09 11:36:08 WEST 2017');

INSERT INTO samples(patientDni, glucoseLevel, date) VALUES ('45345345C', 100, 'Fri May 05 11:36:08 WEST 2017');
INSERT INTO samples(patientDni, glucoseLevel, date) VALUES ('45345345C', 70, 'Fri May 06 11:36:08 WEST 2017');
INSERT INTO samples(patientDni, glucoseLevel, date) VALUES ('45345345C', 100, 'Fri May 07 11:36:08 WEST 2017');
INSERT INTO samples(patientDni, glucoseLevel, date) VALUES ('45345345C', 200, 'Fri May 08 11:36:08 WEST 2017');
INSERT INTO samples(patientDni, glucoseLevel, date) VALUES ('45345345C', 90, 'Fri May 09 11:36:08 WEST 2017');