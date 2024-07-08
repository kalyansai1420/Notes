# Practical Design Patterns for Java Devs

## Key Design Patterns

- **Dependency Injection (DI)**
  - DI is a technique where an object receives other objects it depends on rather than creating them itself.

- **Chain of Responsibility Pattern**
  - This pattern allows an object to send a command without knowing which object will handle the request. The request is passed along a chain of handlers

- **Flyweight Pattern**
  - This pattern is used to minimize memory usage by sharing as much data as possible with similar objects.

- **Observer Pattern**
  - This pattern establishes a one-to-many dependency between objects. When one object changes state, all its dependents are notified and updated automatically.

- **Visitor Pattern**
  - This pattern lets you define a new operation without changing the classes of the elements on which it operates.

- **Thread Pool Pattern**
  - This pattern reuses a fixed number of threads to perform multiple tasks, avoiding the overhead of creating and destroying threads for each task.

- **Anti-patterns**
  - Anti-patterns are common responses to recurring problems that are usually ineffective and counterproductive.

## SOLID Principles

- **Single Responsilibity Principle (SRP)**
  - A class should have only one reason to change, meaning it should have only one job or responsibility.

```java
//BAD example : A single class doing too much
class IronManSuit {
    public void managePower() { /*manage power logic*/ }
    public void activateWeapons() { /*activate weapons logic*/}
    public void handleFlight() { /*handle flight logic*/}
}

// GOOD example : Each class has a single responsibility
class PowerManager {
    public void managePower() { /*manage power logic*/}
}

class WeaponsManager {
    public void activateWeapons() { /*activate weapons logic*/}
}

class FlightHandler {
    public void handleFlight() { /*handle flight logic*/ }
}

```

- **Open/Closed Principle (OCP)**
  - Software entities should be open for extension but closed for modification. This means you should be able to add new functionality without changing existing code.

```java

// BAD example : Modifying existing code to add new feature
class IronManSuit {
    public void attack() {
        // Basic attack
    }
}

// Good example : Extending functionality without modifying existing code
abstract class IronManSuit {
    public abstract void attack();
}

class BasicSuit extends IronManSuit {
    @Override
    public void attack() {
        // Basic attack
    }
}

class AdvancedSuit extends IronManSuit {
    @Override
    public void attack() {
        // Advanced attacks with new features
    }
}
```

- **Liskov Substitution Principle (LSP)**
  - Subtypes should be substitutable for their base types without altering the correctness of the program

```java

//Bad example : Violating LSP by altering behaviour
class RegularSpiderMan {
    public void webSwing() { /* regular web swining */}
}

class IronSpider extends RegularSpiderMan {
    @Override
    public void webSwing() {
        throw new UnsupportedOperationException("Iron Spider can't web swing");
    }
}

// Good example : Maintaining substitutability
abstract class SpiderMan {
    public abstract void webSwing();
}

class RegularSpiderMan extends SpiderMan {
    @Override
    public void webSwing() { /*regular web swining*/ }
}

class IronSpider extends SpiderMan {
    @Override
    public void webSwing() { /*enhanced web swinging with iron suit*/}
}
```

- **Interface Segragation Principle (ISP)**
  - Clients should not be forced to depend on interfaces they do not use. Split large interfaces into smaller, more specific ones.

```java
// Bad example : A single interface with too many responsibilities
interface Avenger {
    void fly();
    void superStrength();
    void shootWeb();
}


// Good example : Specific interfaces for different abilities
interface Flyable {
    void fly();
}

interface Strength {
    void superStrength();
}

interface WebShooter {
    void shootWeb();
}

class IronMan implements Flyable {
    @Override
    public void fly () { /* Iron man flying logic*/}
}

class Hulk implements Strength {
    @Override
    public void superStrength() { /* Hulk strength logic */ }
}

class SpiderMan implements WebShooter {
    @Override
    public void shootWeb() { /* Spider-Man web shooting logic */ }
}
```

- **Dependency Inversion Principle (DIP)**
  - High-level modules should not depend on low-level modules. Both should depend on abstractions. Abstractions should not depend on details. Details should depend on abstractions.

```java
// BAD example: High-level module depends on low-level module
class Mission {
    private Agent agent = new Agent();

    public void execute() {
        agent.performTask();
    }
}

class Agent {
    public void performTask() { /* agent task logic */ }
}

// GOOD example: High-level module depends on abstraction
interface Task {
    void performTask();
}

class Mission {
    private Task task;

    public Mission(Task task) {
        this.task = task;
    }

    public void execute() {
        task.performTask();
    }
}

class Agent implements Task {
    @Override
    public void performTask() { /* agent task logic */ }
}

```