CREATE TABLE prestamos(
	prest_key int auto_increment primary key,
	prest_fechainicial varchar(20) not null,
    prest_tiempo int not null,
	prest_barco varchar(30) not null,
    prest_cuenta varchar(30) not null,
    foreign key (prest_cuenta) references cliente(cli_cuenta),
    foreign key (prest_barco) references barco(registro)
);
insert into prestamos (prest_fechainicial,prest_tiempo,prest_barco,prest_cuenta) values ("20/01/2010",100, "AF45678","ViajeSeguro");
insert into prestamos (prest_fechainicial,prest_tiempo,prest_barco,prest_cuenta) values ("21/05/2010",1000, "LF48679","Confianzavelas");
insert into prestamos (prest_fechainicial,prest_tiempo,prest_barco,prest_cuenta) values ("18/12/2015",80, "CO4867910","Condores");
insert into prestamos (prest_fechainicial,prest_tiempo,prest_barco,prest_cuenta) values ("05/08/2019",150, "US48679","Serviciosnavierosperu");
insert into prestamos (prest_fechainicial,prest_tiempo,prest_barco,prest_cuenta) values ("30/01/2011",200, "US58219","juansanchez");
insert into prestamos (prest_fechainicial,prest_tiempo,prest_barco,prest_cuenta) values ("20/01/2010",100, "IR45678","ViajeSeguro");
insert into prestamos (prest_fechainicial,prest_tiempo,prest_barco,prest_cuenta) values ("21/05/2010",1000, "PA48679","Confianzavelas");
insert into prestamos (prest_fechainicial,prest_tiempo,prest_barco,prest_cuenta) values ("18/12/2015",80, "PE48679","Condores");
insert into prestamos (prest_fechainicial,prest_tiempo,prest_barco,prest_cuenta) values ("05/08/201",150, "CO48679","Serviciosnavierosperu");
insert into prestamos (prest_fechainicial,prest_tiempo,prest_barco,prest_cuenta) values ("30/01/2011",200, "BR58219","juansanchez");
insert into prestamos (prest_fechainicial,prest_tiempo,prest_barco,prest_cuenta) values ("05/08/2021",150, "CO48679","Confianzavelas");


