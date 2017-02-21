USE undici;


CREATE TABLE pizza (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  pizza varchar(45) not null,
  preis double not null,
  bild varchar(55) not null);
  

    
  insert into pizza (pizza, preis, bild) values
  ('Margheritta', 16,'src/undici/GUI/Bilder/margherita.jpg')
  ,('Funghi', 19,'src/undici/GUI/Bilder/funghi.jpg')
  ,('Salame', 20,'src/undici/GUI/Bilder/salame.jpg')
  ,('Salame Picante', 20,'src/undici/GUI/Bilder/salamePicante.jpg')
  ,('Calzone', 20,'src/undici/GUI/Bilder/calzone.jpg')
  ,('Quatro Formagi', 21,'src/undici/GUI/Bilder/quatroFormagi.jpg')
  ,('Prosciutto', 20,'src/undici/GUI/Bilder/prosciutto.jpg')
  ,('Hawaii', 20,'src/undici/GUI/Bilder/hawaii.jpg')
  ,('Napoli', 18,'src/undici/GUI/Bilder/napoli.jpg')
  ,('Quatro Stagioni', 20,'src/undici/GUI/Bilder/quatroStagioni.jpg')
  ,('frutti di mare', 20,'src/undici/GUI/Bilder/fruttiDiMare.jpg');