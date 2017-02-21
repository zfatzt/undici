drop database undici;

drop table adresse;
drop table bestellung;
drop table getraenk;
drop table kunde;
drop table pizza;
drop table zutat;
drop table pizza_zutat;



#gibt dem root alle rechte
 GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' IDENTIFIED BY '1234' WITH GRANT OPTION;
 FLUSH PRIVILEGES;
 
 #gibt laurent alle Rechte.
  GRANT ALL PRIVILEGES ON *.* TO 'Laurenz'@'%' IDENTIFIED BY '1234' WITH GRANT OPTION;
 FLUSH PRIVILEGES;