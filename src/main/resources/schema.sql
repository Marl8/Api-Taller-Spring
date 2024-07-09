drop database if exists agencia_db_prueba;
create database agencia_db_prueba;
use agencia_db_prueba;

create table cliente(
codC int,
DNI varchar(12),
Nombre Varchar(45),
Apellido varchar(50),
Direccion varchar(70),
tel varchar(15),
constraint PK_cliente primary key(codC)
)ENGINE=INNODB;

create table mecanico(
codMec int,
Nombre Varchar(45),
Apellido varchar(50),
DNI varchar(12),
tel varchar(15),
repara boolean,    /* 0 si diagnostica y 1 si repara */
constraint PK_mecanico primary key(codMec)
)ENGINE=INNODB;


create table mecdiag(
codMD int,
tematica varchar(70),
codMec int,
constraint PK_mecdiag primary key(codMD),
constraint FK_mecdiag_mec foreign key(codMec) references mecanico(codMec)
)ENGINE=INNODB;


create table mecrep(
codMR int,
horaE time,
horaS time,
codMec int,
constraint PK_mecrep primary key(codMR),
constraint FK_mecrep_mec foreign key(codMec) references mecanico(codMec)
)ENGINE=INNODB;

create table vehiculo(
codVEH int,
Matricula varchar(7),
Modelo varchar(45),
Marca varchar(50),
Color varchar(25),
codC int,
constraint PK_codVEH primary key(codVEH),
constraint FK_vehiculo FOREIGN key(codC) references cliente(codC)
)ENGINE=INNODB;

create table repuesto(
codRep int,
Nombre varchar (50),
stock int,
PP int,
precio float,
Unidad varchar(20),
constraint PK_codRep primary key(codRep)
)ENGINE=INNODB;

create table ficha(
codF int,
codVEH int,
fecha date,
hora time,
constraint PK_ficha primary key(codF),
constraint FK_codC_ficha FOREIGN key(codVEH) references vehiculo(codVEH)
)ENGINE=INNODB;


create table fichamd(
codF int,
codMD int,
informe varchar(100),
constraint PK_FichaMD primary key(codMD,codF),
constraint FK_codF FOREIGN key(codF) references ficha(codF),
constraint FK_codMD_FM FOREIGN key(codMD) references MecDiag(codMD)
)ENGINE=INNODB;


create table presup(
NPresup int,
codF int,
fecha date,
DiagFinal varchar(100),
Monto float,
Aceptado boolean,
constraint PK_NPresup primary key(NPresup),
constraint FK_codF_presup FOREIGN key(codF) references ficha(codF)
)ENGINE=INNODB;


create table presurep(
Npresup int,
codRep int,
cant int,
constraint PK_PresuRep primary key(Npresup,codRep),
constraint FK_Npresu FOREIGN key(Npresup) references presup(Npresup),
constraint FK_codRe FOREIGN key(codRep) references repuesto(codRep)
)ENGINE=INNODB;

