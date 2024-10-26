-- ************************************** proyectos
CREATE TABLE proyectos
(
 "id"         serial NOT NULL,
 estado       boolean NOT NULL,
 fecha_inicio date NOT NULL,
 fecha_fin    date NULL,
 nombre       varchar(150) NOT NULL,
 CONSTRAINT PK_5 PRIMARY KEY ( "id" )
);

-- ************************************** empresas
CREATE TABLE empresas
(
 "id"        serial NOT NULL,
 nombre      varchar(150) NOT NULL,
 abreviatura varchar(50) NOT NULL,
 estado      boolean NOT NULL,
 nit         varchar(20) NOT NULL,
 CONSTRAINT PK_3 PRIMARY KEY ( "id" )
);


-- ************************************** profesiones
CREATE TABLE profesiones
(
 "id"   serial NOT NULL,
 nombre varchar(100) NOT NULL,
 CONSTRAINT PK_4 PRIMARY KEY ( "id" )
);


-- ************************************** empleados
CREATE TABLE empleados
(
 "id"                  serial NOT NULL,
 id_profesion          int NOT NULL,
 nombres               varchar(50) NOT NULL,
 apellidos             varchar(50) NOT NULL,
 correo                varchar(150) NOT NULL,
 direccion             varchar(150) NOT NULL,
 estado                boolean NOT NULL,
 fecha_ingreso         date NOT NULL,
 fecha_nacimiento      date NOT NULL,
 genero                varchar(1) NOT NULL,
 tipo_identificacion   varchar(50) NOT NULL,
 numero_identificacion varchar(50) NOT NULL,
 telefono              varchar(15) NOT NULL,
 CONSTRAINT PK_2 PRIMARY KEY ( "id" ),
 CONSTRAINT FK_2 FOREIGN KEY ( id_profesion ) REFERENCES profesiones ( "id" )
);

-- ************************************** cartas_laborales
CREATE TABLE cartas_laborales
(
 "id"            serial NOT NULL,
 id_empleado     int NOT NULL,
 entidad_destino varchar(150) NULL,
 fecha           date NOT NULL,
 url_archivo     text NOT NULL,
 CONSTRAINT PK_1 PRIMARY KEY ( "id" ),
 CONSTRAINT FK_1 FOREIGN KEY ( id_empleado ) REFERENCES empleados ( "id" )
);

-- ************************************** cargos
CREATE TABLE cargos
(
 "id"   serial NOT NULL,
 nombre varchar(50) NOT NULL,
 CONSTRAINT PK_10 PRIMARY KEY ( "id" )
);

-- ************************************** contratos
CREATE TABLE contratos
(
 "id"          serial NOT NULL,
 tipo_contrato varchar(50) NOT NULL,
 CONSTRAINT PK_7 PRIMARY KEY ( "id" )
);


-- ************************************** contratos_empleados
CREATE TABLE contratos_empleados
(
 "id"         serial NOT NULL,
 salario      decimal NOT NULL,
 estado       boolean NOT NULL,
 fecha_inicio date NOT NULL,
 fecha_fin    date NULL,
 id_empresa   int NOT NULL,
 id_empleado  int NOT NULL,
 id_contrato  int NOT NULL,
 id_cargo     int NOT NULL,
 CONSTRAINT PK_9_1 PRIMARY KEY ( "id" ),
 CONSTRAINT FK_3 FOREIGN KEY ( id_empleado ) REFERENCES empleados ( "id" ),
 CONSTRAINT FK_4 FOREIGN KEY ( id_contrato ) REFERENCES contratos ( "id" ),
 CONSTRAINT FK_8 FOREIGN KEY ( id_empresa ) REFERENCES empresas ( "id" ),
 CONSTRAINT FK_10 FOREIGN KEY ( id_cargo ) REFERENCES cargos ( "id" )
);


-- ************************************** proyectos_empleados
CREATE TABLE proyectos_empleados
(
 "id"         serial NOT NULL,
 rol          varchar(50) NOT NULL,
 fecha_inicio date NOT NULL,
 fecha_fin    date NOT NULL,
 estado       boolean NOT NULL,
 id_lider     int NOT NULL,
 id_proyecto  int NOT NULL,
 id_empleado  int NOT NULL,
 CONSTRAINT PK_9 PRIMARY KEY ( "id" ),
 CONSTRAINT FK_5 FOREIGN KEY ( id_proyecto ) REFERENCES proyectos ( "id" ),
 CONSTRAINT FK_6 FOREIGN KEY ( id_empleado ) REFERENCES empleados ( "id" ),
 CONSTRAINT FK_9 FOREIGN KEY ( id_lider ) REFERENCES empleados ( "id" )
);

-- ************************************** vacaciones
CREATE TABLE vacaciones
(
 "id"         serial NOT NULL,
 fecha_inicio date NOT NULL,
 fecha_fin    date NOT NULL,
 descripcion  varchar(200) NOT NULL,
 dias_habiles int NOT NULL,
 estado       boolean NOT NULL,
 id_contrato  int NOT NULL,
 CONSTRAINT PK_6 PRIMARY KEY ( "id" ),
 CONSTRAINT FK_10_1 FOREIGN KEY ( id_contrato ) REFERENCES contratos_empleados ( "id" )
);


CREATE INDEX FK_PROFESIONES_EMPLEADOS ON empleados
(
 id_profesion
);



CREATE INDEX FK_CARTA_EMPLEADO ON cartas_laborales
(
 id_empleado
);



CREATE INDEX FK_CONTRATO_EMPLEADO ON contratos_empleados
(
 id_contrato
);

CREATE INDEX FK_CONTRATO_EMPRESA ON contratos_empleados
(
 id_empresa
);

CREATE INDEX FK_CONTRATO_CARGO ON contratos_empleados
(
 id_cargo
);



CREATE INDEX FK_PROYECTO_EMPLEADO ON proyectos_empleados
(
 id_proyecto
);

CREATE INDEX FK_EMPLEADO_PROYECTO ON proyectos_empleados
(
 id_empleado
);

CREATE INDEX FK_LIDER_EMPLEADO ON proyectos_empleados
(
 id_lider
);



CREATE INDEX FK_CONTRATO_VACACIONES ON vacaciones
(
 id_contrato
);