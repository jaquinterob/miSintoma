DROP TABLE IF EXISTS COVIDVACCINE;
  
CREATE TABLE COVIDVACCINE (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  nameVaccine VARCHAR(250) NOT NULL,
  components VARCHAR(250) NOT NULL,
  laboratory VARCHAR(250) NOT NULL,
  expirationDate VARCHAR(250) NOT NULL,
  clinicalData VARCHAR(250) NOT NULL,
  vaccineBatch VARCHAR(250) NOT NULL);
DROP TABLE IF EXISTS SINTOMAS;
  
CREATE TABLE SINTOMAS (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  namesintoma VARCHAR(250) NOT NULL,
  descripcion VARCHAR(250) NOT NULL
);