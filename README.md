# OSGi Basics Explained with Minecraft

This application is summoning mobs at every player location every 10 seconds.
This demonstrates having multiple implementations during the runtime and how they can be called when hot deployed.

[![video](https://github.com/lgdd/doc-assets/blob/main/osgi-basics-explained-with-minecraft/thumbnail.jpg?raw=true)](https://youtu.be/dfnzTfVfT6U "OSGi Basics Explained with Minecraft")
> Checkout the video for more informations.

## Requirements

- JDK 11
- Docker 19+

## Setup

There's a Makefile to let you try things quickly.
You don't need a Minecraft account to test it, you should have logs on Karaf and the Minecraft Server.

To start the Minecraft Server (on Docker):
```
make minecraft-server
```

To create the Karaf runtime, start it and deploy the minimal set of modules (API + Scheduler):
```shell
make minimal
```

To build and deploy the other two modules:
```shell
make animals
make enemies
```

## License

[MIT](LICENSE)