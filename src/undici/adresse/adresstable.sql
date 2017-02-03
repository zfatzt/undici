DROP DATABASE IF EXISTS undici;
CREATE DATABASE undici;

USE undici;

DROP TABLE IF EXISTS adresse ;
CREATE TABLE adresse (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  strasse varchar(50) NOT NULL,
  hausnummer int not null,
  plz int not null,
  ort varchar(50) NOT NULL 
  
  );