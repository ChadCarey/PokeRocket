

REM Simple helper script to create one container from a docker compose file at a time
REM while retaining the same configuration specified in the docker-compose (names, networks, ect...)

SET DOCKER_COMPOSE_FILE=%1
SET DOCKER_SERVICE_NAME=%2
SET COMMAND=%3
docker-compose -f %DOCKER_COMPOSE_FILE% run --rm --service-ports %DOCKER_SERVICE_NAME% %COMMAND%
