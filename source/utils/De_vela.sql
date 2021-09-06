CREATE TABLE De_Vela(
	vel_id int auto_increment PRIMARY KEY not null,
	vel_registro varchar(50) ,
	vel_modelo varchar(30),
    vel_cantidad_velas int not null,
    vel_tipo ENUM("PASAJEROS","CARGA"),
    vel_capacidad varchar(50),
    foreign key (vel_registro) references barco(registro)
);

insert into de_vela (vel_registro,vel_modelo,vel_cantidad_velas,vel_tipo,vel_capacidad) values ("AF45678", "V370",4, "CARGA","100 kg");
insert into de_vela (vel_registro,vel_modelo,vel_cantidad_velas,vel_tipo,vel_capacidad) values ("LF48679", "V380",2, "PASAJEROS","10 pasajeros");
insert into de_vela (vel_registro,vel_modelo,vel_cantidad_velas,vel_tipo,vel_capacidad) values ("CO4867910", "S388",4, "PASAJEROS","20 pasajeros");
insert into de_vela (vel_registro,vel_modelo,vel_cantidad_velas,vel_tipo,vel_capacidad) values ("US48679", "C525",2, "CARGA","250 kg");
insert into de_vela (vel_registro,vel_modelo,vel_cantidad_velas,vel_tipo,vel_capacidad) values ("US58219", "C525-452",2, "PASAJEROS","80 pasajeros");
