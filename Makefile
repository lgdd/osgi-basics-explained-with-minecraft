all:
	make runtime
	make minimal
	make start

minecraft-server:
	docker run -ti --rm -p 25565:25565 --name mc -e EULA=TRUE itzg/minecraft-server

runtime:
	./mvnw clean install --projects minecraft-summon-runtime

start:
	./minecraft-summon-runtime/target/assembly/bin/karaf

connect:
	./minecraft-summon-runtime/target/assembly/bin/client

minimal:
	./mvnw clean install --projects minecraft-summon-api,minecraft-summon-scheduler
	cp ./minecraft-summon-api/target/minecraft-summon-api.jar ./minecraft-summon-runtime/target/assembly/deploy/
	cp ./minecraft-summon-scheduler/target/minecraft-summon-scheduler.jar ./minecraft-summon-runtime/target/assembly/deploy/

animals:
	./mvnw clean install --projects minecraft-summon-animals
	cp ./minecraft-summon-animals/target/minecraft-summon-animals.jar ./minecraft-summon-runtime/target/assembly/deploy/

enemies:
	./mvnw clean install --projects minecraft-summon-enemies
	cp ./minecraft-summon-enemies/target/minecraft-summon-enemies.jar ./minecraft-summon-runtime/target/assembly/deploy/
