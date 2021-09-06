CREATE TABLE cliente(
	cli_razonsocial varchar(80)  not null,
    cli_pais varchar(40)  not null,
    cli_nombre varchar(40)  not null,
    cli_email varchar(80),
    cli_cuenta varchar(30) PRIMARY KEY not null
);
insert into cliente values("Viaje Seguro","Colombia","Pepe Rivera","viajeseguro@gmail.com","ViajeSeguro");
insert into cliente values("Confianza en nuestras velas","Venezuela","Alan Brito","alanbrito@confianzaennuestrasvelas.com","Confianzavelas");
insert into cliente values("Condores del sur","Ecuador","Jhon Bunan","jhonbunan@condores.co","Condores");
insert into cliente values("Servicios navieros","Peru","Eliot Ramirez","serviciosnavieros@yahoo.com","Serviciosnavierosperu");
insert into cliente values("Capitanes asociados","Colombia","Juan Sanchez","juansanchez@pilotosasociados.com","juansanchez");