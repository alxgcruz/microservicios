CREATE TABLE friendships (
  id      VARCHAR(255) PRIMARY KEY,
  id_usuario VARCHAR(255) NOT NULL,
  id_amigo VARCHAR(255) NOT NULL,
  authorized BOOLEAN DEFAULT false
);
