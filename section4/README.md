# Section 4 - Docker
## Accounts - Dockerfile approach
package jar - in pom.xml is a good format for creating a docker image

- $ accounts > mvn spring-boot:run<br>       
- $ accounts > java -jar target/accounts-0.0.1-SNAPSHOT.jar <br>
the same result as previous command
1) Create a fat jar inside target folder
- $ accounts > mvn clean install 

2) Dockerfile - write instructions for creating a docker image (from, maintainer, copy, entrypoint)

3) Execute the docker command to build the docker image
- $ docker version<br>
- $ accounts > docker build . -t sergml/accounts:s4
<br> parameter "-t" means tag, "s4" - section 4

4) Create and run a container from docker image
- $ accounts > docker run -p 8080:8080 sergml/accouns:s4

- $ accounts > docker run -d -p 8080:8080 sergml/accouns:s4<br>
parameter "-d" means detached mode, will not see any logs inside my terminal<br>


- $ accounts > docker run -d -p 8081:8080 sergml/accouns:s4<br>
8081 - local port, 8080 - container port, the containers are isolated


- $ docker ps - list all running containers
- $ docker ps -a - list all containers, including stopped ones
- $ docker start de0fee0f611b - start an existent stopped container

## Loans - Buildpacks approach
Alternative approach to Dockerfile. Automatically generate a production ready OCI images from the source code.
- https://buildpacks.io/ - best practice experience for creating docker images from Heroku
- https://paketo.io/ - run app in the cloud. java, go, python, php end other languages

1) Add image name in spring-boot-maven-plugin pom.xml 
2) Crete a docker image using buildpacks (first run about 5 minutes for downloading dependencies) <br>
- $ loans > mvn spring-boot:build-image<br>

- $ docker images<br>
  REPOSITORY                                 TAG       IMAGE ID       CREATED        SIZE<br>
  sergml/accounts                            s4        dceac24f568e   2 hours ago    811MB<br>
  paketobuildpacks/run-jammy-tiny            latest    f8e55c2672ea   2 days ago     38.6MB<br>
  sergml/loans                               s4        40d23cdde5f1   45 years ago   735MB<br>
  paketobuildpacks/builder-jammy-java-tiny   latest    409890f058ee   45 years ago   1.02GB<br>

3) Run a container from docker image
- $ loans > docker run -d -p 8090:8090 sergml/loans:s4   


## Cards - Google Jib approach
https://github.com/GoogleContainerTools/jib

- $ cards > mvn compile jib:dockerBuild
- $ cards > docker images
- $ cards > docker run -d -p 9000:9000 sergml/cards:s4
