#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" <<-EOSQL

    CREATE USER admin PASSWORD 'admin';

    CREATE DATABASE red_social_users OWNER admin;
    GRANT ALL PRIVILEGES ON DATABASE red_social_users TO admin;

    CREATE DATABASE red_social_posts OWNER admin;
    GRANT ALL PRIVILEGES ON DATABASE red_social_posts TO admin;

    CREATE DATABASE red_social_comments OWNER admin;
    GRANT ALL PRIVILEGES ON DATABASE red_social_comments TO admin;

    CREATE DATABASE red_social_friendships OWNER admin;
    GRANT ALL PRIVILEGES ON DATABASE red_social_friendships TO admin;

    CREATE DATABASE red_social_auth OWNER admin;
    GRANT ALL PRIVILEGES ON DATABASE red_social_auth TO admin;


EOSQL
