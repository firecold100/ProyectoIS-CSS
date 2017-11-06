USE gustosculposos;
	
	
create table usuario(
	 ID_USUARIO MEDIUMINT NOT NULL AUTO_INCREMENT,
	 alias VARCHAR(150) null,
     nombre VARCHAR(150) NULL,
     apellido_p VARCHAR(150) NULL,
     apellido_m VARCHAR(150) NULL,
     correo VARCHAR(300) NULL,
     #f_nac VARCHAR(150) NULL,
     f_reg TIMESTAMP null,
     contrasenya VARCHAR(150)  NULL,
     sexo VARCHAR(150) null,
     edad VARCHAR(150) null,
     constraint pk_usuario PRIMARY KEY (ID_USUARIO)
);

create table gustosculposos(
	ID_GUSTO MEDIUMINT not null,
	ID_USUARIO MEDIUMINT not null,
	gusto varchar(250) not null,
    constraint fk_gusto_usuario foreign key(ID_USUARIO)
	references usuario(ID_USUARIO),
	constraint pk_usuario PRIMARY KEY (ID_GUSTO)
);

create table mensajes(
	ID_MENSAJE MEDIUMINT not null,
	ID_USUARIO1 MEDIUMINT not null,
	ID_USUARIO2 MEDIUMINT not null,
	mensaje varchar(250) not null,
	f_envio datetime NOT NULL,
    constraint fk_mensaje_usuario1 foreign key(ID_USUARIO1)
	references usuario(ID_USUARIO),
	constraint fk_mensaje_usuario2 foreign key(ID_USUARIO2)
	references usuario(ID_USUARIO),
	constraint pk_usuario PRIMARY KEY (ID_MENSAJE)
);