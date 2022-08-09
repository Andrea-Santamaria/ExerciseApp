FROM mysql:8.0
COPY . ./

ADD qseat_ddl.sql /docker-entrypoint-initdb.d
ADD qseat_dml.sql /docker-entrypoint-initdb.d
#COPY qseat_ddl.sql /docker-entrypoint-initdb.d/
#COPY qseat_dml.sql /docker-entrypoint-initdb.d/
