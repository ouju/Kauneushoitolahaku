CREATE TABLE Yritys
(
id SERIAL PRIMARY KEY,
palvelu_id INTEGER REFERENCES Palvelu(id),
tarjonta_id INTEGER REFERENCES Tarjonta(id),
nimi varchar(255),
tunnus varchar(255),
salasana varchar(255),
hintataso varchar(255),
osoite varchar(255),
sijainti varchar(255),
puhelinnumero varchar(255),
kuvaus varchar(255)
);


CREATE TABLE Palvelu
(
id SERIAL PRIMARY KEY,
nimi varchar(255)
);

CREATE TABLE Tarjonta
(
id SERIAL PRIMARY KEY,
nimi varchar(255)
);