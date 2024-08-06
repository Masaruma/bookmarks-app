- Stop Colima
```bash
    colima stop
```

- Start Colima with network address
```bash
 colima start --network-address
- ```


- Add the following to the `.zshrc` file 

    ```bash
    export TESTCONTAINERS_HOST_OVERRIDE=$(colima ls -j | jq -r '.address')
    export TESTCONTAINERS_DOCKER_SOCKET_OVERRIDE=/var/run/docker.sock
    export DOCKER_HOST=unix://$HOME/.colima/default/docker.sock
    ```

Restart Intellij and new Terminal
