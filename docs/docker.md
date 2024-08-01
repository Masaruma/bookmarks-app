- To start a single Postgres DB container
  ```bash
  docker run -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=bookmarks -e POSTGRES_DB=bookmarks -d -p 5432:5432 postgres:16.3
  ```

- To get started with creating Dockerfile/compose files
    ```bash
     docker init
    ```

- To run the docker build
  ```bash
  export DOCKER_DEFAULT_PLATFORM=linux/amd64
  docker build . -t bookmarks
  ```

- To see the docker images
  ```bash
  docker image ls
  ```

- To run the docker container
  ```bash
  docker run -p 8080:8080 bookmarks
  ```

- To link an existing database container running on localhost and refer it from our container
  ```bash
  docker run -e SPRING_DATASOURCE_URL=jdbc:postgresql://host.docker.internal:5432/bookmarks -p 8080:8080 bookmarks
  ```

- To run all compose containers in the background
  ```bash
  docker compose up -d
  ```

- `docker compose stop server` to stop the server container
- `docker compose restart server` to restart the server container
- `docker compose down` to bring down all containers

- To use Cloud Native build packs
  ```bash
  ./gradlew bootBuildImage --imageName=bookmarks-cnb
  ```