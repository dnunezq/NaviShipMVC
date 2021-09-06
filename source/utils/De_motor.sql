CREATE TABLE De_Motor(
	mot_id int auto_increment PRIMARY KEY not null,
	mot_registro varchar(50) not null,
	mot_marca varchar(30) not null,
    mot_cantidadMotores int not null,
    #mot_propietario varchar(50) not null,
    mot_autonomia_horas int not null,
    foreign key (mot_registro) references barco(registro)
);
insert into de_motor (mot_registro,mot_marca,mot_cantidadMotores,mot_autonomia_horas)values ("IR45678", "Airbus Ships",1,200);
insert into de_motor (mot_registro,mot_marca,mot_cantidadMotores,mot_autonomia_horas)values ("PA48679", "BELL",2,300);
insert into de_motor (mot_registro,mot_marca,mot_cantidadMotores,mot_autonomia_horas)values ("PE48679", "JSC RUSSIAN",3,350);
insert into de_motor (mot_registro,mot_marca,mot_cantidadMotores,mot_autonomia_horas)values ("CO48679", "SIKORSKY",2,280);
insert into de_motor (mot_registro,mot_marca,mot_cantidadMotores,mot_autonomia_horas)values ("BR58219", "BELL",2,500);
select * from de_motor;
SELECT mot_registro  as Registro,mot_marca as Marca,mot_cantidadMotores as "N° de motores",barc_propietario as Propietario, mot_autonomia_horas as "Autonomía (Horas)" 
From de_motor,barco where de_motor.mot_registro=barco.registro ORDER BY  mot_registro ASC ;