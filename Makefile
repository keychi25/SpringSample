# development環境
.PHONY: setup
setup:
	docker-compose -f docker/local/docker-compose.yml build

.PHONY: start
start:
	docker-compose -f docker/local/docker-compose.yml up --remove-orphans

.PHONY: start.background
start.background:
	docker-compose -f docker/local/docker-compose.yml up -d --remove-orphans

.PHONY: status
status:
	docker-compose -f docker/local/docker-compose.yml ps

.PHONY: stop
stop:
	docker-compose -f docker/local/docker-compose.yml down

.PHONY: prod.setup
prod.setup:
	docker build --build-arg JAR_FILE=build/libs/\*.jar -t springio/gs-spring-boot-docker -f docker/production/java/Dockerfile .

.PHONY: prod.start
prod.start:
	docker run -p 8080:8080 springio/gs-spring-boot-docker