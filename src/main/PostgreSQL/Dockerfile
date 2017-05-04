FROM postgres:9.6.2

ENV POSTGRES_DB GlucoseAppDB
ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD mysecretpassword

WORKDIR /GlucoseApp
ADD ./init.sql /docker-entrypoint-initdb.d/

EXPOSE 5432
