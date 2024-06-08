
REM Define the path to the Docker Compose file
set COMPOSE_DIR=C:\Users\nancy\repo\smt\docker

REM Change to the directory containing the Docker Compose file
cd /d %COMPOSE_DIR%

REM Stop Docker Compose containers without removing volumes
docker-compose down

REM Pull the latest changes for all images defined in the Docker Compose file
docker-compose pull

REM Recreate and start the containers
docker-compose up -d

REM Print a message indicating the process is complete
echo Docker Compose containers have been updated and restarted.
pause
