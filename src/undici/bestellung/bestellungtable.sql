USE undici;

DROP TABLE IF EXISTS bestellung ;
CREATE TABLE bestellung (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  getraenke varchar(45) not null,
  pizza varchar(45) not null,
  zahlung varchar(45) not null,
  gesamtpreis double not null)