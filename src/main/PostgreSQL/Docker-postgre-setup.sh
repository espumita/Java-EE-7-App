#!/bin/bash

DEPLOY_CONFIG_PATH=~/IdeaProjects/Java-EE-7-App/src/main/PostgreSQL
docker stop postgres-cont
docker rm postgres-cont
docker rmi postgres-img
docker build -t postgres-img $DEPLOY_CONFIG_PATH
docker run --name postgres-cont -p 5432:5432 -d postgres-img