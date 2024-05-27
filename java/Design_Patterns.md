## Design Patterns

- In order to create software 
  - lets are is has a problem
  - so for every developer they solve in different ways/approaches
  - then what's the best way or approach though every approach can solve the problem.

- So design patterns are provided to solve the base problems for every software they build initially  
- DP represents an idea
- Creational DP
  - Objects are there to be created
  - Factory Pattern, Builder Pattern, Singleton Pattern

- Structural DP
  - how we structure the code/class/object
  - Proxy pattern,Adaptor pattern
- Behavioral DP
  - deals about object interaction
  - maintain loose coupling (used to easy injection) between objects
  - Iterator pattern, Observer pattern , State pattern


Points to Remember
1. constructor private
2. Object create with the help of method
3. Create field to store object is private.
4. Eager is not a good practice because if objects are not used though there created at the time of class loading. It would reduce performance.
5. In Lazy if we call method then only objects get created
6. We ignored the threads concept
7. If threadsafety not concerned we can go with lazy initialization