run:
	mvn package && java -jar target/gs-spring-boot-docker-0.1.0.jar
test:
	mvn clean test
