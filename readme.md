#### Configurations

Open the `application.properties` file and set your own configurations.

#### Prerequisites
- Java 8
- Maven 3

#### From terminal

Go on the project's root folder, then type:

    $ mvn spring-boot:run

# To debug the app
    $ mvn spring-boot:run -Drun.jvmArguments="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=8000"

#### From Eclipse/STS/IntelliJ Idea

Import as *Existing Maven Project* and run it as *Spring Boot App*.
