#!/bin/bash


DOCKERFILE_DIRECTORY=~/IdeaProjects/Java-EE-7-App
docker stop glassfish-cont
docker rm glassfish-cont
docker rmi glassfish-img
docker build -t glassfish-img $DOCKERFILE_DIRECTORY
docker run --name glassfish-cont -p 8080:8008 -d glassfish-img