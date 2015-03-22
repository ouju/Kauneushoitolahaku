CREATE TABLE Yritys
(
tunnus int,
nimi varchar(255),
hintataso varchar(255),
osoite varchar(255),
sijainti varchar(255),
puhelinnumero varchar(255),
kuvaus varchar(255)
);


CREATE TABLE Tyontekija
(
tunnus int,
nimimerkki varchar(255),
salasana varchar(255)
);


CREATE TABLE Palvelu
(
tunnus int,
nimi varchar(255),
);


CREATE TABLE Asiakas
(
tunnus int
);