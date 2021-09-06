CREATE TABLE barco(
	registro varchar(50) PRIMARY KEY not null,
	barc_propietario varchar(50) not null,
	foreign key(barc_propietario) references propietario(pro_razonsocial)
);
insert into barco values ("IR45678", "Ship Latina");
insert into barco values ("PA48679", "Delfines SA");
insert into barco values ("PE48679",  "Condores");
insert into barco values ("CO48679",  "Velas de los Andes");
insert into barco values ("BR58219",  "Pedro Torres");
insert into barco values ("AF45678", "Ship Latina");
insert into barco values ("LF48679", "Delfines SA");
insert into barco values ("CO4867910","Condores");
insert into barco values ("US48679", "Velas de los Andes");
insert into barco values ("US58219", "Pedro Torres");
