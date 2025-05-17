# Section 4 - Docker

package jar - in pom.xml is a good format for creating a docker image

$ accounts > mvn spring-boot:run       
$ accounts > java -jar target/accounts-0.0.1-SNAPSHOT.jar - the same result as previous command
1) create a fat jar inside target folder
$ accounts > mvn clean install 

2) Dockerfile - write instructions for creating a docker image (from, maintainer, copy, entrypoint)

3) Execute the docker command to build the docker image
$ docker version
$ accounts > docker build . -t sergml/accounts:s4
- parameter "-t" means tag, "s4" - section 4

4) create and run a container from docker image
$ accounts > docker run -p 8080:8080 sergml/accouns:s4

- parameter "-d" means detached mode
will not see any logs inside my terminal
$ accounts > docker run -d -p 8080:8080 sergml/accouns:s4

- 8081 - local port, 8080 - container port, the containers are isolated
$ accounts > docker run -d -p 8081:8080 sergml/accouns:s4

- $ docker ps - list all running containers
- $ docker ps -a - list all containers, including stopped ones
- $ docker start de0fee0f611b - start an existent stopped container
