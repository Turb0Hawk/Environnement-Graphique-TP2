create schema if not EXISTS  BibliothequeDeMusique collate latin1_swedish_ci;

use BibliothequeDeMusique;

create table if not EXISTS Artiste
(
	Numero int auto_increment
		primary key,
	Nom_Artiste varchar(50) not null,
	Membre BOOLEAN default false not null,
	Photo longblob null
);

create table if not EXISTS Album
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
			on update cascade on delete cascade,
			
	constraint CHK_Genre check(Genre in ('Folk', 'Jazz', 'Classique', 'Alternatif', 'Rock'))
);

insert into Artiste(Nom_Artiste) values 
('Dave Brubeck'),
('Miles Davis'),
('John Coltrane'),
('Snarky Puppy '),
('Le Vent du Nord'),
('Faun'),
('Vitáliy "Vitas" Vladasovich Grachyov'),
('Ali Farka Touré'),
('Rimi Natsukawa'),
('Neil Cicierega'),
('Stupeflip'),
('Muse'),
('Rush'),
('Carlos Santana'),
('Queen'),
('Electric Light Orchestra'),
('Pink Floyd'),
('Two Steps From Hell'),
('Gustav Mahler'),
('Sergei Rachmaninov'),
('Claude Debussy'),
('Johannes Brahms');


insert into Album(Titre, Genre, Annee, Numero_Artiste_Principal) values
('Time Out', 'Jazz', 1959, 1),
('Kinf of Blue', 'Jazz', 1959, 2),
('A Love Supreme', 'Jazz', 1965, 3),
('We Like It Here', 'Jazz', 2014, 4),
('In a Silent Way', 'Jazz', 1969, 2),
('Notre Album SOLO', 'Folk', 2018, 5),
('Luna', 'Folk', 2014, 6),
('Philosophy of Miracle', 'Folk', 2001, 7),
('Biennale', 'Folk', 1978, 8),
('Okinawa no Kaze', 'Folk', 2004, 9),
('Mouth Moods', 'Alternatif', 2017, 10),
('The Hypnoflip Invasion', 'Alternatif', 2011, 11),
('Mouth Sounds', 'Alternatif', 2014, 10),
('Mouth Silence', 'Alternatif', 2014, 10),
('Drones', 'Alternatif', 2015, 12),
('Chronicles', 'Rock', 1990, 13),
('Ultimate Santana', 'Rock', 2007, 14),
('Absolute Greatest', 'Rock', 2009, 15),
('Greatest Hits', 'Rock', 1976, 16),
('The Dark Side Of The Moon', 'Rock', 1973, 17),
('Illumina', 'Classique', 2010, 18),
('Berliner Philharmoniker - Symphony No.5', 'Classique', 2002, 19),
('Vladimir Ashkenazy - Piano Concertos', 'Classique', 1995, 20),
('Orchestre Symphonique de Montréal - La Mer', 'Classique', 1999, 21),
('London Philharmonic Orchestra - Symphony No.1', 'Classique', 2004, 22);
