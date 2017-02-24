use undici;
drop database undici;
create database undici;
use undici;

#drop table bestellung;
#drop table getraenk;
#drop table kunde;
#drop table pizza_zutat;
#drop table pizza;
#drop table zutat;
#drop table adresse;


CREATE TABLE adresse (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  strasse varchar(50) NOT NULL,
  hausnummer int not null,
  plz int not null,
  ort varchar(50) NOT NULL  );
  
  
  create table zutat (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  zutat varchar(45) not null,
  preis double not null);
  
  insert into zutat(zutat, preis) values
  ('Tomatensauce', 2)
  ,('Mozzarella', 2)
  ,('Oregano', 2)
  ,('Ananas', 1)
  ,('Artischocken', 2)
  ,('Auberginen', 2)
  ,('Blattspinat', 2)
  ,('Broccoli', 2)
  ,('Champignons', 2)
  ,('Crevetten Black Tiger', 3)
  ,('Ei', 2)
  ,('Gorgonzola', 2)
  ,('Hinterschinken', 3)
  ,('Kapern', 1)
  ,('Knoblauch', 1)
  ,('Mais', 1)
  ,('Mascarpone', 2)
  ,('Meeresfrüchte', 3)
  ,('Mozzarella extra', 2)
  ,('Oliven', 1)
  ,('Grana Padano', 2)
  ,('Peperocini', 1)
  ,('Peperoni', 1)
  ,('Rohschinknen', 5)
  ,('Rucola', 2)
  ,('Salami', 3)
  ,('Scharfe Salami', 3)
  ,('Speck', 3)
  ,('Steinpilze', 3)
  ,('Tomatenscheiben', 2)
  ,('Zwiebeln', 1);
  
  CREATE TABLE pizza (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  pizza varchar(45) not null,
  preis double not null,
  bild varchar(55) not null);
  

    
  insert into pizza (pizza, preis, bild) values
  ('Margharita', 16,'/undici/GUI/Bilder/margharita.jpg')
  ,('Funghi', 19,'/undici/GUI/Bilder/funghi.jpg')
  ,('Salame', 20,'/undici/GUI/Bilder/salame.jpg')
  ,('Salame Picante', 20,'/undici/GUI/Bilder/salamePicante.jpg')
  ,('Calzone', 20,'/undici/GUI/Bilder/calzone.jpg')
  ,('Quatro Formagi', 21,'/undici/GUI/Bilder/quatroFormagi.jpg')
  ,('Prosciutto', 20,'/undici/GUI/Bilder/prosciutto.jpg')
  ,('Hawaii', 20,'/undici/GUI/Bilder/hawaii.jpg')
  ,('Napoli', 18,'/undici/GUI/Bilder/napoli.jpg')
  ,('Quatro Stagioni', 20,'/undici/GUI/Bilder/quatroStagioni.jpg')
  ,('frutti di mare', 20,'/undici/GUI/Bilder/fruttiDiMare.jpg');

create table pizza_zutat (
pizza_id int not null,
zutat_id int not null,
PRIMARY KEY(pizza_id, zutat_id),
foreign key(zutat_id) references undici.zutat(id),
foreign key(pizza_id) references undici.pizza(id));

  insert into pizza_zutat (pizza_id, zutat_id) values (1,1),(1,2),(1,3),
  (2,2),(2,1),(2,9),(2,3),
  (3,1),(3,2),(3,3),(3,26),
  (4,1),(4,2),(4,3),(4,27),(4,22),
  (5,1),(5,2),(5,13),(5,11),(5,3),
  (6,1),(6,2),(6,21),(6,12),(6,17),(6,3),
  (7,1),(7,2),(7,3),(7,13),
  (8,1),(8,2),(8,13),(8,4),(8,3),
  (9,1),(9,2),(9,14),
  (10,1),(10,2),(10,13),(10,5),(10,9),(10,23),
  (11,1),(11,2),(11,3),(11,18);
  
  
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
    
    CREATE TABLE getraenk (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  getraenk varchar(45) not null,
  preis double not null,
  bild varchar(55) not null);
  
  insert into getraenk(getraenk, preis, bild) values
  ('Coca Cola', 4,'/undici/GUI/Bilder/cocaCola.png')
  ,('Coca-Cola zero', 4,'/undici/GUI/Bilder/cocaColaZero.jpg')
  ,('Coca-Cola light', 4,'/undici/GUI/Bilder/cocaColaLight.png')
  ,('Fanta', 4,'/undici/GUI/Bilder/fanta.jpg')
  ,('Sprite', 4,'/undici/GUI/Bilder/sprite.jpg')
  ,('Valser Wasser', 2,'/undici/GUI/Bilder/valserWasser.png')
  ,('Rivella Rot', 4,'/undici/GUI/Bilder/rivellaRot.png');
    
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