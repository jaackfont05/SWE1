# Troubleshooting
### Incorrect Java Version
Open the pom.xml file and update the "java.version" attribute to the version of Java you have installed.

### Building the Jar File
Use Maven to build the Jar. The command from the project root directory is

"./mvnw clean package"

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/4.0.0-M2/maven-plugin)

### Maven Parent overrides

Due to Maven's design, elements are inherited from the parent POM to the project POM.
While most of the inheritance is fine, it also inherits unwanted elements like `<license>` and `<developers>` from the parent.
To prevent this, the project POM contains empty overrides for these elements.
If you manually switch to a different parent and actually want the inheritance, you need to remove those overrides.

