# Design Patterns

## Introduction

- In order to create software:
  - Let's assume there is a problem.
  - Every developer may solve it in different ways/approaches.
  - So, what’s the best way or approach though every approach can solve the problem?

- Design patterns are provided to solve the base problems for every software they build initially.
- DP represents an idea.

## Types of Design Patterns

### Creational DP

- Objects are there to be created.
- Examples:
  - Factory Pattern
  - Builder Pattern
  - Singleton Pattern

### Structural DP

- How we structure the code/class/object.
- Examples:
  - Proxy Pattern
  - Adaptor Pattern

### Behavioral DP

- Deals with object interaction.
- Maintains loose coupling (used to ease injection) between objects.
- Examples:
  - Iterator Pattern
  - Observer Pattern
  - State Pattern

## Points to Remember

1. Constructor should be private.
2. Object creation with the help of a method.
3. Create field to store the object privately.
4. Eager initialization is not a good practice because if objects are not used, they are still created at the time of class loading, which reduces performance.
5. In Lazy initialization, objects are created only when the method is called.
6. We ignored the threads concept.
7. If thread safety is not a concern, we can go with lazy initialization.

## What Developers Should Focus On

- Meeting business concerns.
- Implementing the use cases.

## Project Modules

- Horizontally layered: 3-tier architecture (presentation, business, and data layer).
- Vertically layered: Group functionality based on their business domain.
- Maven is a Java-based build system configured by XML, defined as POM (Project Object Model).
- Gradle uses a Domain Specific Language (DSL) to configure fully extensible and scriptable project builds.
- Both Gradle and Maven include sophisticated dependency management and are well suited for building Java-based projects.
- Enterprise software should be built with the main priority of solving business problems, leading to business-driven applications and technology rather than technology-driven solutions.
- EJB session beans can be either stateless, stateful, or singletons.
- EJBs implicitly include certain cross-cutting concerns, such as monitoring, transactions, exception handling, and managing concurrency for singleton beans.
- CDI managed beans come with similar scopes and more possibilities, such as adding custom scopes and the default dependent scope, which is active depending on the lifespan of its injection point.
- EJBs perform slightly better than CDI beans, which are instantiated every time their scope requires it.

## List of Patterns

### Singletons

- Have only one single instance per class within the whole application.
- Have the capability of storing states and coordinating actions at a central place.
- Use a static singleton instance that is managed in the singleton class.
- In Java EE, the concept of a singleton is directly built into EJBs with singleton session beans and CDIs with application scope.

### Abstract Factory

- Aims to separate the creation of objects from their usage.
- Example:
  - A static singleton instance managed in the singleton class.

### Factory Method

- Refers to factories that are implemented as methods on specific types.
- There is no single class responsible for creating certain instances; rather, the creation becomes the responsibility of the factory method, which is defined as part of a domain class.

### Object Pool

- Designed for performance optimization.
- Avoids constantly creating new instances of required objects and dependencies by retaining them in a pool of objects for a longer period of time.

### Decorator

- Allows us to add behavior to an object without affecting other objects of that class.
- Example:
  - Coffee with different combinations of milk, sugar, syrup, and cream.
  - InputStream class in JDK, which allows adding specific behavior for files, byte arrays, and so on.

### Facade

- Provides a clean and simple interface to certain functionalities.
- Encapsulation and abstraction layers are among the most important principles for writing code.
- Example:
  - Boundaries implemented with EJBs providing a facade to business use cases.

### Proxy

- Injected bean references usually do not contain a reference to the actual instance but a proxy.
- Proxies are thin wrappers around instances that can add certain functionalities.

### Observer

- Describes how an object manages and notifies observers in case of a change in the overall state.
- Example:
  - Facades implemented with EJBs.

### Strategy

- Allows dynamically choosing an implementation algorithm (strategy) at runtime.
