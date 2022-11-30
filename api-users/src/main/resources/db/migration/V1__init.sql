CREATE TABLE users (
  id      VARCHAR(255) PRIMARY KEY,
  nombre VARCHAR(255) NOT NULL,
  apellido_paterno VARCHAR(255) NOT NULL,
  apellido_materno VARCHAR(255) NOT NULL,
  fecha_nacimiento  VARCHAR(255) NOT NULL,
  sexo VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  estatus BOOLEAN DEFAULT true
);
