- To start a single Postgres DB container
  ```bash
  docker run -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=bookmarks -e POSTGRES_DB=bookmarks -d -p 5488:5432 postgres:16.3
  ```