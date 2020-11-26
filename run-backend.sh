#!/usr/bin/env sh

CONFIG="-f ./docker/docker-compose-dev.yml"

docker-compose $CONFIG down
mvn clean install -DskipTests -T2
docker build ./docker/app-base
docker-compose $CONFIG build
docker-compose $CONFIG up --remove-orphans
