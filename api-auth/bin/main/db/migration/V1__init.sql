CREATE TABLE auth (
  id      VARCHAR(255) PRIMARY KEY,
  tipo_auth  VARCHAR NOT NULL,
  id_evento VARCHAR NOT NULL,
  fecha_creacion VARCHAR,
  fecha_autorizacion VARCHAR,
  estatus BOOLEAN NOT NULL DEFAULT FALSE
);