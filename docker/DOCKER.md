# Docker Setup

## Troubleshooting

On Windows, when changing networks, it is possible to encounter a scenario where you can't connect to mentioned above services. This mostly happens when you run Docker on different networks. The system hosts file identifies multiple IP address to host.docker.internal and gateway.docker.internal.

By Default, ```C:\Windows\System32\drivers\etc\hosts``` should look like below

```
## DOCKER NORMAL EXAMPLE
 host.docker.internal
 gateway.docker.internal
# Added by Docker Desktop
10.0.0.243 host.docker.internal
10.0.0.243 gateway.docker.internal
# To allow the same kube context to work on the host and the container:
127.0.0.1 kubernetes.docker.internal
# End of section
```

However, should the file look like below, the dns routing between docker and your local computer may have issues. 

```
## DOCKER ERROR EXAMPLE
 host.docker.internal
 gateway.docker.internal
10.0.0.195 host.docker.internal
10.0.0.195 gateway.docker.internal
10.0.0.158 host.docker.internal
10.0.0.158 gateway.docker.internal
# Added by Docker Desktop
10.0.0.243 host.docker.internal
10.0.0.243 gateway.docker.internal
# To allow the same kube context to work on the host and the container:
127.0.0.1 kubernetes.docker.internal
# End of section
```

To fix, this run ```ipconfig``` on command line and identify your IP address, and remove the ip addresses the don't match with your current system so it becomes like the error-clean file showcased above.