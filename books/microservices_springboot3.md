### Design patterns for microservies

#### Chapter 1

- Service discovery
  - Problem : How can clients find microservices and thier instances ?
  - Solution : Add a new component - a service discovery
    - to tthe system landscape which keeps track of currently available microservices and the IP addresses of its instances
  - Implementation :
    - Client-side routing
    - Server-side routing  
- Edge server
  - How exposed microservices can be protected from malicious clients?
  - an edge server
    - to the system landscape that all incoming requests will go through
  - implementation :
    - an edge server typically behaves like a reverse proxy
- Reactive microservices
  - If no. of concurrent requests goes up, a server might run out of available of threads in OS
  - use non-blocking I/O to no threads are allocated while waiting for processing to occur in another device
- Central configuration
  - how do i get a complete pciture of conf that is place for all the running microservices instances ?
  - how do i update the config & make sure that all the affected microservice isntances are updated correctly?
  - add a new component , a configuration server
    - to the system landscape to store the configuration of all the microservices
  - make it possible to store conf info for a group of microservices in one place with different settings for diff env ( for example: dev,test,qa, and prod)
- Centralized log analysis
  - how to get all the log of each microservice if it has an errors
  - add a new component that can manage centralized logging
    - detect new microservices
    - interpreting and storing log events
    - providing apis
- Distributed tracing
  - how to track requests and messgaes that flow b/w microservices while processing an external req to the system landscape?
  - we use common correlation ID
- Circuit breaker
  - if microservice stops responding,its clients might get into problems as well and stop responding to requests from their clients
  - circuit breaker
    - prevants new outgoing requests from a caller if it detects a problem with service it calls
- Control loop
  - how to manually detect and correct problems such as crashed or hugn microsverice instances
  - control loop will constantly observe the actual state of system landscape, comparing it with a desired state
    - if two states differ, it will take action to make the actual state equal to desired state.
- Centralized monitoring and alarms
  - how to analyze hardware resource consumption per microservice
  - a new component, a monitor service
    - to the system landscape, which is capable of collecting metrics about hardware resource usage for each microservice instance level

#### Chapter 2

- **Important points**
  - prefering construtor injection over field and setter injection to keep state in components immutatble. an immutable state is important if you want to be able to run the component in a multi threaded runtime environment.

- What is the porpose of @SpringBootApplication annotation ?
  - convention-based autoconfiguration mechanism can initiated by annotating the app
  - this annotation consists of
    - enabling component scanning
    - application class itself becomes a configuration class
    - enables autoconfiguration , where springboot looks for JAR files in the classpath that it can confirgura automatically

- What are main difference between the older Spring Component for developing REST services, Spring Web MVC and the new Spring WebFlux ?
- How does springdoc-openapi help a devloper document REST APIs?
  - it does by examining the application, for example, inspecting WebFlux and Swagger-based annotations
  - springdoc-openapi helps us to document the APIs exposed by our microservices
- What is function of reposistory in Spring Data and what is the simplest possible implementation of repository
  - used to store and access data from diffferent types of databases
  - most basic form , a repo can be declared as Java interface and Spring Data
- what is the purpose of binder in spring cloud stream ?
  - provides the actual integration with a specific messgaing system, similar to what a JDBCdriver does for a specific type of database
- what is purpose of docker compose ?
  - to start and stop many containers with one command
  - docker compose uses a YAML file to describe the containers to be managed.

- Summary
  - Spring boot is used to simplify the developement of Spring-based, productino ready applications sucha as microservices
  - Using Spring WebFlux, we can develop microsevrices that expose reactive, that is non-blocking, REST services
  - springdoc-openapi is used to document the REST services
  - spring data is used to persist data used by microsveices
  - spring cloud stream is used to send messgaes asyn between our microservices
  - docker concept of containers alternative of virtual machines easy to use

#### Chapter 3

Questions

- What is the command that lists available dependencies when you create a new Spring Boot project using the spring init Spring Initializr CLI tool?
- How can you set up Gradle to build multiple related projects with one command?
- What are the @PathVariable and @RequestParam annotations used for?
- How can you separate protocol-specific error handling from the business logic in an API implementation class?
- What is Mockito used for?

#### Chapter 4

Questions

- What are the major differences between a virtual machine and a Docker container?
- What is the purpose of namespaces and cgroups in Docker?
- What happens with a Java application that doesn’t honor the max memory settings in a container and allocates more memory than it is allowed to?
- How can we make a Spring-based application run as a Docker container without requiring modifications of its source code?
- Why will the following Docker Compose code snippet not work?

```sh
  review:
    build: microservices/review-service
    ports:
      - "8080:8080"
    environment:
      - SPRING_PROFILES_ACTIVE=docker
  product-composite:
    build: microservices/product-composite-service
    ports:
      - "8080:8080"
    environment:
      - SPRING_PROFILES_ACTIVE=docker
      ```
