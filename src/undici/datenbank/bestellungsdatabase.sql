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
    
    
    select undici.zutat.zutat, undici.pizza.id, undici.pizza.pizza, undici.pizza.preis  from undici.pizza_zutat join undici.pizza on undici.pizza.id = undici.pizza_zutat.pizza_id join undici.zutat on undici.zutat.id = undici.pizza_zutat.zutat_id where undici.pizza.id = 1;
    
    select undici.zutat.zutat, undici.pizza.id, undici.pizza.pizza, undici.pizza.preis, undici.pizza.bild from undici.pizza_zutat join undici.pizza on undici.pizza.id = undici.pizza_zutat.pizza_id join undici.zutat on undici.zutat.id = undici.pizza_zutat.zutat_id;