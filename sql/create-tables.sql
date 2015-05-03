CREATE TABLE Yritys
(
id SERIAL PRIMARY KEY,
tyontekija_id INTEGER REFERENCES Tyontekija(id),
nimi varchar(50),
hintataso varchar(10),
osoite varchar(50),
sijainti varchar(50),
kotisivut varchar(50),
kuvaus varchar(255)
);


CREATE TABLE Tyontekija
(
id SERIAL PRIMARY KEY,
tunnus varchar(50),
salasana varchar(50)
);


CREATE TABLE Tarjonta
(
id SERIAL PRIMARY KEY,
nimi varchar(20)
);


CREATE TABLE tarjonta_yritys
(
id SERIAL PRIMARY KEY,
tarjonta_id INTEGER REFERENCES Tarjonta(id),
yritys_id INTEGER REFERENCES Yritys(id)
);