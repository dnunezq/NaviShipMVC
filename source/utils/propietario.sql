CREATE TABLE propietario(
	pro_identificacion bigint  not null,
	pro_razonsocial varchar(50) primary key not null,
    pro_tipo ENUM("Empresa","Persona") not null,
    pro_pais varchar(40) not null
);
insert into propietario values (87984564564, "Ship Latina","Empresa", "Colombia");
insert into propietario values (87983512364564, "Delfines SA", "Empresa", "Venezuela");
insert into propietario values (8798156974, "Condores", "Empresa", "Ecuador");
insert into propietario values (87987815, "Velas de los Andes", "Empresa", "Peru");
insert into propietario values (87973245, "Pedro Torres", "Persona", "Colombia");
