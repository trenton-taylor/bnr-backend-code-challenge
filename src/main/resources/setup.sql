-- Base level auth and permissions to get the application running in any postgres environment
CREATE SCHEMA bnr;
CREATE ROLE bnruser SUPERUSER LOGIN PASSWORD 'bnr2023.!';