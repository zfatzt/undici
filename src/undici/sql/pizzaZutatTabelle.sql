use undici;

create table pizza_zutat (
pizza_id int not null,
zutat_id int not null,
PRIMARY KEY(pizza_id, zutat_id),
foreign key(zutat_id) references undici.zutat(id),
foreign key(pizza_id) references undici.pizza(id));