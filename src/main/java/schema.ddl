
    create table Categoria (
        nombre varchar(255) not null,
        primary key (nombre)
    );

    create table Curso (
        nombre varchar(255) not null,
        cantHoras time,
        creditos int4 not null,
        descripcion varchar(255),
        duracion varchar(255),
        fechaR timestamp,
        url varchar(255),
        instituto_nombre varchar(255),
        primary key (nombre)
    );

    create table Curso_Categoria (
        cursos_nombre varchar(255) not null,
        categorias_nombre varchar(255) not null
    );

    create table Curso_Curso (
        Curso_nombre varchar(255) not null,
        previas_nombre varchar(255) not null
    );

    create table Docente (
        nick varchar(255) not null,
        Password varchar(255),
        apellido varchar(255),
        correo varchar(255) unique,
        fechaNac timestamp,
        nombre varchar(255),
        instituto_nombre varchar(255),
        primary key (nick)
    );

    create table Edicion (
        nombre varchar(255) not null,
        cupo int4 not null,
        fechaF timestamp,
        fechaI timestamp,
        fechaPub timestamp,
        curso_nombre varchar(255),
        primary key (nombre)
    );

    create table Edicion_Docente (
        Edicion_nombre varchar(255) not null,
        docentesAsignados_nick varchar(255) not null
    );

    create table Estudiante (
        nick varchar(255) not null,
        Password varchar(255),
        apellido varchar(255),
        correo varchar(255) unique,
        fechaNac timestamp,
        nombre varchar(255),
        primary key (nick)
    );

    create table InscripcionEdi (
        fechaIns date,
        edicion_nombre varchar(255),
        estudiante_nick varchar(255),
        primary key (edicion_nombre, estudiante_nick)
    );

    create table Instituto (
        nombre varchar(255) not null,
        primary key (nombre)
    );

    create table ProgFormacion (
        nombre varchar(255) not null,
        descripcion varchar(255),
        fechaAlta timestamp,
        fechaF timestamp,
        fechaI timestamp,
        primary key (nombre)
    );

    create table ProgFormacion_Curso (
        ProgFormacion_nombre varchar(255) not null,
        cursos_nombre varchar(255) not null
    );

    create table Usuario_Usuario (
        seguidores_nick varchar(255) not null,
        seguidos_nick varchar(255) not null
    );

    alter table Curso 
        add constraint FK3E7107C2419147D 
        foreign key (instituto_nombre) 
        references Instituto;

    alter table Curso_Categoria 
        add constraint FK7521A11094693542 
        foreign key (cursos_nombre) 
        references Curso;

    alter table Curso_Categoria 
        add constraint FK7521A110781BECF0 
        foreign key (categorias_nombre) 
        references Categoria;

    alter table Curso_Curso 
        add constraint FKE3E336F990FAC431 
        foreign key (previas_nombre) 
        references Curso;

    alter table Curso_Curso 
        add constraint FKE3E336F94931C05D 
        foreign key (Curso_nombre) 
        references Curso;

    alter table Docente 
        add constraint FKD03455F22419147D 
        foreign key (instituto_nombre) 
        references Instituto;

    alter table Edicion 
        add constraint FKF2A8D34F4931C05D 
        foreign key (curso_nombre) 
        references Curso;

    alter table Edicion_Docente 
        add constraint FK5008110256815A25 
        foreign key (docentesAsignados_nick) 
        references Docente;

    alter table Edicion_Docente 
        add constraint FK50081102A81993BD 
        foreign key (Edicion_nombre) 
        references Edicion;

    alter table InscripcionEdi 
        add constraint FK2798418143A199AD 
        foreign key (estudiante_nick) 
        references Estudiante;

    alter table InscripcionEdi 
        add constraint FK27984181A81993BD 
        foreign key (edicion_nombre) 
        references Edicion;

    alter table ProgFormacion_Curso 
        add constraint FKA665ED8536EB61BD 
        foreign key (ProgFormacion_nombre) 
        references ProgFormacion;

    alter table ProgFormacion_Curso 
        add constraint FKA665ED8594693542 
        foreign key (cursos_nombre) 
        references Curso;
