USE undici;


CREATE TABLE pizza (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  pizza varchar(45) not null,
  preis double not null);
  
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
    
  insert into pizza (pizza, preis) values
  ('Margheritta', 16)
  ,('Funghi', 19)
  ,('Salame', 20)
  ,('Salame Picante', 20)
  ,('Calzone', 20)
  ,('Quatro Formagi', 21)
  ,('Prosciutto', 20)
  ,('Hawaii', 20)
  ,('Napoli', 18)
  ,('Quatro Stagioni', 20)
  ,('frutti di mare', 20);