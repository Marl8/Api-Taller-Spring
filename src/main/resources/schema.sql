drop database if exists agencia_db_prueba;
create database agencia_db_prueba;
use agencia_db_prueba;

create table cliente(
codC int auto_increment,
DNI varchar(12),
Nombre Varchar(45),
Apellido varchar(50),
Direccion varchar(70),
tel varchar(15),
constraint PK_cliente primary key(codC)
);

create table mecanico(
codMec int auto_increment,
Nombre Varchar(45),
Apellido varchar(50),
DNI varchar(12),
tel varchar(15),
repara boolean,
constraint PK_mecanico primary key(codMec)
);


create table mecdiag(
codMD int auto_increment,
tematica varchar(70),
codMec int,
constraint PK_mecdiag primary key(codMD),
constraint FK_mecdiag_mec foreign key(codMec) references mecanico(codMec)
);


create table mecrep(
codMR int auto_increment,
hora_E time,
hora_S time,
codMec int,
constraint PK_mecrep primary key(codMR),
constraint FK_mecrep_mec foreign key(codMec) references mecanico(codMec)
);

create table vehiculo(
codVEH int auto_increment,
Matricula varchar(7),
Modelo varchar(45),
Marca varchar(50),
Color varchar(25),
codC int,
constraint PK_codVEH primary key(codVEH),
constraint FK_vehiculo FOREIGN key(codC) references cliente(codC)
);

create table repuesto(
codRep int auto_increment,
Nombre varchar (50),
stock int,
PP int,
precio float,
Unidad varchar(20),
constraint PK_codRep primary key(codRep)
);

create table ficha(
codF int auto_increment,
codVEH int,
fecha date,
hora time,
constraint PK_ficha primary key(codF),
constraint FK_codC_ficha FOREIGN key(codVEH) references vehiculo(codVEH)
);


create table fichamd(
codF int,
codMD int,
informe varchar(100),
constraint PK_FichaMD primary key(codMD,codF),
constraint FK_codF FOREIGN key(codF) references ficha(codF),
constraint FK_codMD_FM FOREIGN key(codMD) references MecDiag(codMD)
);


create table presup(
NPresup int auto_increment,
codF int,
fecha date,
DiagFinal varchar(100),
Monto float,
Aceptado boolean,
constraint PK_NPresup primary key(NPresup),
constraint FK_codF_presup FOREIGN key(codF) references ficha(codF)
);


create table presurep(
Npresup int,
codRep int,
cant int,
constraint PK_PresuRep primary key(Npresup,codRep),
constraint FK_Npresu FOREIGN key(Npresup) references presup(Npresup),
constraint FK_codRe FOREIGN key(codRep) references repuesto(codRep)
);

create table users(
id_user int auto_increment,
username VARCHAR(30) UNIQUE,
password VARCHAR(255),
is_enable boolean,
account_non_expired boolean,
account_non_locked boolean,
credentials_non_expired boolean,
constraint PK_users primary key (id_user)
);

create table rol(
id_rol int,
nombre VARCHAR(25),
constraint PK_rol primary key (id_rol)
);

create table permisos(
id_permiso int,
nombre VARCHAR(25) UNIQUE NOT NULL,
constraint PK_permiso primary key (id_permiso)
);

create table usrol(
id_user int,
id_rol int,
constraint PK_usrol primary key (id_user, id_rol),
constraint PK_user FOREIGN KEY (id_user) REFERENCES users (id_user),
constraint PK_roles FOREIGN KEY (id_rol) REFERENCES rol (id_rol)
);

create table rolper(
id_rol int,
id_permiso int,
constraint PK_rolper primary key (id_rol, id_permiso),
constraint PK_roles_per FOREIGN KEY (id_rol) REFERENCES rol (id_rol),
constraint PK_permisos FOREIGN KEY (id_permiso) REFERENCES permisos (id_permiso)
);