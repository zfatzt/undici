use undici;

CREATE TABLE getraenk (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  getraenk varchar(45) not null,
  preis double not null);
  
  insert into getraenk(getraenk, preis) values
  ('Coca Cola', 4)
  ,('Coca-Cola zero', 4)
  ,('Coca-Cola light', 4)
  ,('Fanta', 4)
  ,('Sprite', 4)
  ,('Valser Wasser', 2)
  ,('Rivella Rot', 2);