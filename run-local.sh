#!/usr/bin/env bash

cd server-discovery
./generaImagen.sh
cd ../

cd server-gateway
./generaImagen.sh
cd ../

cd server-monitor
./generaImagen.sh
cd ../


cd api-users
./generaImagen.sh
cd ../

cd api-posts
./generaImagen.sh
cd ../

cd api-comments
./generaImagen.sh
cd ../

cd api-friendships
./generaImagen.sh
cd ../

cd api-auth
./generaImagen.sh
cd ../


docker-compose up --build

docker-compose stop
docker-compose kill
docker-compose rm -f
