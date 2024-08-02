# GO

## Facts

- Go is statically typed, compiled programming
- Syntactically similar to C
- but with memory safety, garbage collection, structural typing, and CSP-style concurreny.
- Go's threading model
  - provided by goroutines and channels.

## Part 1 : First Look at Go

### A brief look a Go vs. Java

- In java we use Ant or Maven
- In Go we use Go builder tool

| Go     | Java      |
| -------- | ------- |
| Go builder Tool | Ant or Maven |
| structs | Classes |
| base declarations & derived type declarations | only type declarations |
| full closures ( can capture mutable data ) | partial closures( can cpature only immutable data ) |
| lacks user-defined generic types | supports generic types of any reference type |
| allows type extension of only other types | base new types on any exisitng type |
| Goroutines | Threads |
| Not support Ternary Expressions | Support Ternary Expressions |
| has panics | assert statement |
| has panics | throw statements |
| no access modifiers only static keyword | access modifiers like (strictfp,transient,volatile,synchronized,abstract,static) |
| support Structs(classes without inheritance) | support classes |
| allow nested structs | like inner classes |

## Part 2

### Key Go Aspects

- Bytecdoe vs. Real Code
  - Go program is built, all code is resolved in runnabvle form into its image.
  - The OS simple needs to readd the fiele into memeory , and it can start execution immediately afterward
  - Go is statically compiled
    - means it is also statically optimized
    - done by the Go compiler based only on information in the source itself
  - JIT compiler is similar
    - optmizationis done at runtime
    - Java can also have a Hotspot compiler
    - uses runtime information to do improved optimizations.
- Go Runs Programs Instead of Classes
  - no direct equivalent of JVM or JRE
  - has a runtime that provides the needed function to support Go semantics.
  - go uses early(static) linking at build time.
  - Java does late (dynamic) linking at runtime.
  - Go approach results in an executable that is self-contained
  - can make deployment easier than with typical Java.
  - Go program is preassembled, it often loads up and starts faster than a typical Java program can.
  - helps in containerized environments and in serverless cloud environments.
- Go Memory Managment
  - using dynamic memory allocation can cause improper memory management
  - leads to memory leaks, improper reuse of memory blocks, premature memory release
  - provides automatic memory management
    - allocation of space for objects (instances of any data type in Go)
    - automatically reclaiming space of nay unreferenced (often called dead or unreachable) objects