# Player market

### Installing

#### 2. Install Open JDK 11
  - Windows
    - Download and install 
    Amazon Corretto 11 from https://docs.aws.amazon.com/corretto/latest/corretto-11-ug/downloads-list.html
    - Open terminal and type ``java -version`` 
    If you see ``command not found`` that mean you have to setup environment variables.
    Open the Start Search, type in “env”, and choose “Edit the system environment variables”. 
        Click on Advanced->"Environment Variables..."
      - In the popup window, System variables section, click on New button and add a variable with the following details:\
        Name: JAVA_HOME\
        Value: /Path to the installed JDK/ 
        e.g., C:\Program Files\Amazon Corretto\jdk11.0.6_10
      - Add %JAVA_HOME%\bin to the current system PATH variable.

  - MacOS:
    - Download and install 
    Amazon Corretto 11 from https://docs.aws.amazon.com/corretto/latest/corretto-11-ug/macos-install.html

#### 3. Install Apache Maven
  - Windows
    - Download a Binary zip archive from https://maven.apache.org/download.cgi
    - Unpack the archive. Prefer C drive, e.g., C:\apache-maven-3.6.3
    - Open the Start Search, type in “env”, and choose “Edit the system environment variables”. 
        Click on Advanced->"Environment Variables..."
      - In the popup window, System variables section, click on New button and add a variable with the following details:\
        Name: MAVEN_HOME\
        Value: /Path to the unpacked Maven/ 
        e.g., C:\apache-maven-3.6.3
      - Add %MAVEN_HOME%\bin to the current system PATH variable.
      - Test maven works on cmd
        ``mvn --version``
  - MacOS
    - In terminal run 
      ``brew install maven``

### **Optional** Setup IntelliJ IDEA IDE (BYOL - Bring Your Own License)
#### 1a. Download, install and setup IntelliJ IDEA Ultimate
  - Install IntelliJ IDEA from https://www.jetbrains.com/idea/download

## Deployment

#### 1. Install & Setup Docker

##### Installation
1. Install Docker Desktop from https://www.docker.com/products/docker-desktop
2. *(Windows Only)* Open Docker Desktop, by opening the context menu of Docker Desktop from the [notification area](https://docs.microsoft.com/en-us/windows/win32/uxguide/winenv-notification), and select Settings. Under 
_Resources -> File Sharing -> C Local Drive_

##### Run
1. To start Docker, execute ```./docker.sh``` in the project root directory using Git Bash
2. To stop Docker, press ```Ctrl+C``` in the Git Bash window
3. To clean up Docker containers, execute ```./docker.sh --clean``` in the project root directory using Git Bash

- To open PostgreSQL, using PgAdmin4, login to localhost:5432, with user:postgres and password:postgres

##### Troubleshooting
Refer to 'docker" module regarding instructions. [DOCKER.md](docker/DOCKER.md)

#### 2. Initiate databases
  Usually you do not need to do anything. All DBs will be initialized automatically when the micro-services start.
  - If you need to clear the databases in Git Bash go to the root project folder and execute 
      ``./docker.sh --clean``

  - If it is necessary to add a new dependency run 
    ``npm install <dependency>``

#### 6. Build and run back-end in Docker (for front-end developers)
 - Git pull the necessary branch
 - Open Git Bash terminal, go to the project root and execute the following command
   ``./run-backend.sh``\
 All back-end applications will be build and run in Docker.
 - To stop Docker in the terminal window execute _Ctrl+C_      

#### 7. Access to DB
  - Download and install [pgAdmin 4](https://www.pgadmin.org/download/pgadmin-4-windows/)
  - Create a new server
  Right click on "Servers"
  _Create -> Servers..._\
  On "General" tab type any name (e.g., docker)
  Go to "Connection" tab, add\
  Host: localhost\
  Username: postgres\
  Password: postgres

## Utilities

### Swagger-UI
On Development environment, you can access API documentation with the ability to test by going to the following url.
* [player-service](http://localhost:8050/swagger-ui/index.html)
* [commission-service](http://localhost:8150/swagger-ui/index.html)

## Built With
### Java
* [Spring Boot](https://spring.io/projects/spring-boot) - Java Micro Service Framework 
* [Hibernate](https://hibernate.org/) - Domain model persistence for relational databases
* [Eureka Server](https://github.com/Netflix/eureka) - Mid-Tier Load Balancing
* [Lombok](https://projectlombok.org/) - Annotations for model/data objects
* [Maven](https://maven.apache.org/) - Dependency Management
* [Swagger](https://swagger.io/) - API Documentation, Design, Development, & Testing Tool

### Infrastructure
* [PostgreSQL](https://www.postgresql.org/) - Relational database
* [Docker](https://www.docker.com/) -  Tool designed to make it easier to create, deploy, and run applications by using containers

### Other
* [Flyway](https://flywaydb.org/) Database Version Control


