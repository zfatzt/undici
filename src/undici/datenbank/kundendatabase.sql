USE undici;

DROP TABLE IF EXISTS kunde ;
CREATE TABLE kunde (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  anrede varchar(50) NOT NULL,
  vorname varchar(45) not null,
  name varchar(45) not null,
  email varchar(45) not null,
  passwort varchar(45) not null,
  telefon varchar(16)not null,
  adresse_id int not null,
	foreign key(adresse_id) references undici.adresse(id));
    
    
    
insert into kunde (anrede, vorname, name, email, passwort, telefon, adresse_id) values ('Herr', 'Tobias', 'Fatzer', 'tobias.fatzer@bbcag.ch', 'Toby1234', '+41 76 689 68 89', 1)
    


