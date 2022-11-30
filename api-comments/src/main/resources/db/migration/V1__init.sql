CREATE TABLE comments (
  id      VARCHAR(255) PRIMARY KEY,
  comentario VARCHAR(255) NOT NULL,
  id_usuario VARCHAR(255) NOT NULL,
  id_publicacion  VARCHAR(255) NOT NULL,
  autorizado BOOLEAN DEFAULT false
);
