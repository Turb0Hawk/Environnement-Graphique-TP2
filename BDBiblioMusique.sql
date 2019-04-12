create schema BibliothequeDeMusique collate latin1_swedish_ci;

use BibliothequeDeMusique;

create table Artiste
(
	Numero int auto_increment
		primary key,
	Nom_Artiste int not null,
	Membre tinyint(1) default 0 not null,
	Photo longblob null
);

create table Album
(
	Numero int auto_increment
		primary key,
	Titre varchar(50) not null,
	Genre varchar(12) not null,
	Annee int(4) not null,
	Couverture longblob null,
	Numero_Artiste_Principal int not null,
	constraint FK_Num_Artiste
		foreign key (Numero_Artiste_Principal) references Artiste (Numero)
			on update cascade on delete cascade
);

