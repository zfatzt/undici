USE undici;

DROP TABLE IF EXISTS bestellung ;
CREATE TABLE bestellung (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  getraenk_id int not null,
  anzahlpizza int not null,
  pizza_id int not null,
  zahlung varchar(45) not null,
  kunde_id int not null,
    gesamtpreis double not null,
	foreign key(kunde_id) references undici.kunde(id),
	foreign key(getraenk_id) references undici.getraenk(id),
    foreign key(pizza_id) references undici.pizza(id));