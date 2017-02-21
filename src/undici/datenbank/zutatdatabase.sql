use undici;

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