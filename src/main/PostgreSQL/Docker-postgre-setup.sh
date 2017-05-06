#!/bin/bash

DEPLOY_CONFIG_PATH=~/IdeaProjects/medical-app-java-ee/src/main/PostgreSQL
docker stop postgres-cont
docker rm postgres-cont
docker rmi postgres-img
docker build -t postgres-img $DEPLOY_CONFIG_PATH
docker run --name postgres-cont -p 5432:5432 -d postgres-img