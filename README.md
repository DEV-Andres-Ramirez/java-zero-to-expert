# Java Zero to Expert

> A comprehensive, production-quality Java knowledge base covering foundational concepts through advanced topics with extensive documentation and interactive demonstrations.

![Java](https://img.shields.io/badge/Java-21-orange?style=flat&logo=java)
![Maven](https://img.shields.io/badge/Maven-3.x-blue?style=flat&logo=apache-maven)
![License](https://img.shields.io/badge/License-MIT-green?style=flat)

---

## Table of Contents

- [About This Project](#about-this-project)
- [Philosophy & Approach](#philosophy--approach)
- [Project Architecture](#project-architecture)
- [Topics Covered](#topics-covered)
  - [Foundational Concepts](#foundational-concepts)
  - [Primitive Data Types](#primitive-data-types)
  - [Composite Data Types](#composite-data-types)
  - [Control Flow](#control-flow)
- [Getting Started](#getting-started)
- [Project Structure](#project-structure)
- [Documentation Standards](#documentation-standards)
- [Technology Stack](#technology-stack)
- [Future Roadmap](#future-roadmap)
- [Author](#author)

---

## About This Project

**Java Zero to Expert** is a comprehensive, evolving **knowledge base** designed to document Java functionality from fundamental concepts to advanced features. This is not merely a tutorial or reference guide—it is a structured, professional-grade repository that serves as:

- **Educational Platform**: Progressive learning path from beginner to intermediate/advanced levels
- **Reference Documentation**: Extensive examples and best practices for experienced developers
- **Living Knowledge Base**: Continuously expanding collection of Java topics and patterns

### Purpose

To provide a well-organized, extensively documented collection of Java demonstrations that covers core programming concepts through advanced modern features, all accessible via an interactive CLI menu system with hands-on examples.

### Target Audience

- **Students** learning Java from foundational concepts
- **Developers** transitioning to Java from other languages
- **Experienced Engineers** seeking reference implementations and best practices
- **AI Systems** requiring structured, well-documented codebases for analysis and learning

### Living Repository

This repository is in **continuous development**. Topics are systematically added over time, building from fundamental concepts toward advanced Java features, modern APIs, and enterprise patterns. The knowledge base will evolve to encompass the full Java ecosystem.

---

## Philosophy & Approach

### Comprehensive Documentation

Every topic in this repository follows a rigorous documentation standard that goes far beyond typical code comments:

- **Concept Definition**: Clear explanation of what the concept is and its theoretical foundation
- **When to Use**: Specific scenarios and use cases where the pattern/feature should be applied
- **When NOT to Use**: Anti-patterns, limitations, and scenarios to avoid
- **Usage Contexts**: Real-world applications and practical implementation scenarios
- **Best Practices**: Industry-standard patterns, optimization techniques, and guidelines
- **Common Pitfalls**: Warnings about frequent mistakes and how to avoid them
- **Real-World Examples**: Practical, production-relevant code demonstrations

### Interactive Learning

Rather than passive code reading, this project provides an **interactive CLI menu system** that allows developers to:

- Navigate topics by category and complexity
- Execute demonstrations in real-time
- Observe output and behavior patterns
- Experiment with different scenarios

### Progressive Complexity

Topics are organized hierarchically:

1. **Foundational Layer**: Environment, I/O, primitive types
2. **Intermediate Layer**: Composite types, collections, control flow
3. **Advanced Layer**: (Planned) OOP, generics, concurrency, design patterns

Each topic builds upon previous concepts, creating a natural learning progression.

### Production-Quality Code

All code follows professional software engineering standards:

- **Utility Class Pattern**: Non-instantiable classes with private constructors
- **Professional Logging**: SLF4J logger framework (no `System.out.println`)
- **Exception Handling**: Proper error handling and validation
- **Type Safety**: Generics and compile-time safety mechanisms
- **Resource Management**: Proper lifecycle handling (Scanner, streams, etc.)
- **Modern Java Features**: Java 21 syntax, Stream API, var keyword, text blocks

---

## Project Architecture

### Package Structure

```
com.andres
├── App.java                      (Main entry point & menu orchestrator)
│
├── console/                      (Console I/O Operations)
│   ├── input/
│   │   └── InputReader.java      (User input capture with validation)
│   └── output/
│       ├── BasicOutput.java      (System.out demonstrations)
│       └── FormattedOutput.java  (printf & logger formatting)
│
├── controlflow/                  (Decision & Iteration Constructs)
│   ├── conditionals/
│   │   ├── IfElseDemo.java       (If-else chains, nested conditions)
│   │   ├── SwitchDemo.java       (Switch statements & expressions)
│   │   └── TernaryOperatorDemo.java  (Conditional operator)
│   ├── loops/
│   │   ├── ForLoopDemo.java      (Traditional for loops, variations, nested)
│   │   ├── ForEachLoopDemo.java  (Enhanced for-each iteration)
│   │   ├── WhileLoopDemo.java    (While loop constructs)
│   │   └── DoWhileLoopDemo.java  (Do-while execution model)
│   └── streams/
│       └── StreamBasicsDemo.java (Java 8+ Stream API fundamentals)
│
├── datatypes/                    (Data Type Demonstrations)
│   ├── primitive/
│   │   ├── integers/
│   │   │   └── IntegerTypesDemo.java  (byte, short, int, long)
│   │   ├── floatingpoint/
│   │   │   └── FloatingPointTypesDemo.java  (float, double, precision)
│   │   ├── character/
│   │   │   └── CharacterTypeDemo.java  (char, Unicode, escape sequences)
│   │   ├── bool/
│   │   │   └── BooleanTypeDemo.java  (boolean, logical operations)
│   │   ├── string/
│   │   │   └── StringTypeDemo.java  (String immutability, methods, StringBuilder)
│   │   └── casting/
│   │       └── TypeCastingDemo.java  (Widening/narrowing conversions)
│   │
│   └── composite/
│       ├── arrays/
│       │   ├── SingleDimensionArrayDemo.java  (1D arrays)
│       │   └── MultiDimensionArrayDemo.java   (Multi-dimensional arrays)
│       ├── collections/
│       │   ├── lists/
│       │   │   └── ArrayListDemo.java  (Dynamic lists, operations)
│       │   ├── maps/
│       │   │   └── HashMapDemo.java  (HashMap, LinkedHashMap, TreeMap)
│       │   ├── sets/
│       │   │   └── HashSetDemo.java  (HashSet, unique elements)
│       │   └── queues/
│       │       ├── QueueDemo.java   (FIFO queue operations)
│       │       └── DequeDemo.java   (Double-ended queue)
│       └── numeric/
│           └── BigDecimalDemo.java  (High-precision decimal arithmetic)
│
├── functions/                    (Methods & Recursion)
│   ├── methods/
│   │   ├── MethodBasicsDemo.java
│   │   ├── ParameterPassingDemo.java
│   │   ├── ReturnTypesDemo.java
│   │   ├── MethodOverloadingDemo.java
│   │   └── VariableArgumentsDemo.java
│   └── recursion/
│       ├── RecursionBasicsDemo.java
│       ├── RecursionPatternsDemo.java
│       └── RecursionVsIterationDemo.java
│
├── environment/
│   └── EnvironmentVariableManager.java  (System environment access)
│
└── utils/
    └── ConsoleUtils.java         (Reusable input validation utilities)
```

### Design Patterns

- **Menu-Driven CLI Architecture**: Multi-level interactive menu system for topic navigation
- **Utility Class Pattern**: All demo classes are final with private constructors and static methods
- **Separation of Concerns**: Organized by topic domain (types, control flow, I/O)
- **Template Method**: Consistent `demonstrate()` entry point across all demos

---

## Topics Covered

### Foundational Concepts

| Topic | Description | Location |
|-------|-------------|----------|
| **Environment Variables** | System environment access and display | `environment.EnvironmentVariableManager` |
| **Console Input** | User input capture with validation (String, int, double) | `console.input.InputReader` |
| **Basic Output** | Standard output demonstrations | `console.output.BasicOutput` |
| **Formatted Output** | printf formatting and SLF4J placeholders | `console.output.FormattedOutput` |

### Primitive Data Types

All primitive types include: range demonstrations, size metadata, arithmetic operations, overflow behavior, and wrapper class usage.

| Type | Size | Demo Class |
|------|------|------------|
| **Integer Types** | 8-64 bits | `datatypes.primitive.integers.IntegerTypesDemo` |
| - byte | 8 bits (-128 to 127) | ↑ |
| - short | 16 bits (-32,768 to 32,767) | ↑ |
| - int | 32 bits (~±2 billion) | ↑ |
| - long | 64 bits (~±9 quintillion) | ↑ |
| **Floating-Point Types** | 32-64 bits | `datatypes.primitive.floatingpoint.FloatingPointTypesDemo` |
| - float | 32 bits (6-7 decimal digits) | ↑ |
| - double | 64 bits (15-16 decimal digits) | ↑ |
| **Character** | 16 bits (Unicode) | `datatypes.primitive.character.CharacterTypeDemo` |
| **Boolean** | 1 bit (true/false) | `datatypes.primitive.bool.BooleanTypeDemo` |
| **String** | Reference type (immutable) | `datatypes.primitive.string.StringTypeDemo` |
| **Type Casting** | Widening/narrowing conversions | `datatypes.primitive.casting.TypeCastingDemo` |

**Key Topics**: Integer overflow, floating-point precision errors, Unicode escape sequences, String immutability & pooling, StringBuilder vs String, implicit/explicit casting.

### Composite Data Types

#### Arrays

| Topic | Description | Demo Class |
|-------|-------------|------------|
| **Single-Dimensional Arrays** | Creation, access, iteration, length | `datatypes.composite.arrays.SingleDimensionArrayDemo` |
| **Multi-Dimensional Arrays** | 2D arrays, matrix operations, nested structures | `datatypes.composite.arrays.MultiDimensionArrayDemo` |

#### Collections Framework

Demonstrations include: initialization, CRUD operations, iteration patterns, Stream integration, performance characteristics (Big O complexity).

| Collection | Interface | Implementation | Demo Class |
|------------|-----------|----------------|------------|
| **ArrayList** | List | Dynamic array | `datatypes.composite.collections.lists.ArrayListDemo` |
| **HashMap** | Map | Hash table | `datatypes.composite.collections.maps.HashMapDemo` |
| **HashSet** | Set | Hash table | `datatypes.composite.collections.sets.HashSetDemo` |
| **Queue** | Queue | FIFO queue | `datatypes.composite.collections.queues.QueueDemo` |
| **Deque** | Deque | Double-ended queue | `datatypes.composite.collections.queues.DequeDemo` |

**HashMap Demo Variants**: HashMap (unordered), LinkedHashMap (insertion-order), TreeMap (sorted)

#### Numeric Types

| Type | Purpose | Demo Class |
|------|---------|------------|
| **BigDecimal** | Arbitrary-precision decimal arithmetic | `datatypes.composite.numeric.BigDecimalDemo` |

**Use Case**: Financial calculations, avoiding floating-point precision errors (e.g., 0.1 + 0.2 ≠ 0.3 problem)

### Control Flow

#### Conditional Statements

| Construct | Description | Demo Class |
|-----------|-------------|------------|
| **If-Else** | Branching logic, if-else-if chains, nested conditions | `controlflow.conditionals.IfElseDemo` |
| **Switch** | Multi-way branching (statements & expressions) | `controlflow.conditionals.SwitchDemo` |
| **Ternary Operator** | Conditional operator (`? :`) | `controlflow.conditionals.TernaryOperatorDemo` |

#### Loop Constructs

All loop demos include: basic syntax, variations, nested loops, loop control (break/continue), and real-world examples.

| Loop Type | Use Case | Demo Class |
|-----------|----------|------------|
| **For Loop** | Known iteration count, index-based access | `controlflow.loops.ForLoopDemo` |
| **For-Each Loop** | Iterating collections/arrays (no index) | `controlflow.loops.ForEachLoopDemo` |
| **While Loop** | Condition-based iteration | `controlflow.loops.WhileLoopDemo` |
| **Do-While Loop** | Guaranteed first execution, then condition | `controlflow.loops.DoWhileLoopDemo` |

**For Loop Topics**: Counting variations, backward iteration, multiple variables, step increments, labeled breaks, batch processing.

#### Functional Programming

| Topic | Description | Demo Class |
|-------|-------------|------------|
| **Stream API Basics** | filter, map, collect, forEach, lazy evaluation | `controlflow.streams.StreamBasicsDemo` |

### Methods and Functions

#### Method Fundamentals

| Topic | Description | Demo Class |
|-------|-------------|------------|
| **Method Basics** | Anatomy, modifiers, static context, naming | `functions.methods.MethodBasicsDemo` |
| **Parameter Passing** | Pass-by-value, primitives vs objects, multiple parameters | `functions.methods.ParameterPassingDemo` |
| **Return Types** | void, primitives, objects, null handling, guard clauses | `functions.methods.ReturnTypesDemo` |
| **Method Overloading** | Same name different signatures, type promotion | `functions.methods.MethodOverloadingDemo` |
| **Variable Arguments** | Varargs syntax, flexibility, arrays vs varargs | `functions.methods.VariableArgumentsDemo` |

**Key Topics**: Access modifiers, static vs instance context, pass-by-value semantics, immutability implications, overloading resolution.

#### Recursion

| Topic | Description | Demo Class |
|-------|-------------|------------|
| **Recursion Basics** | Base case, recursive case, call stack, stack overflow | `functions.recursion.RecursionBasicsDemo` |
| **Recursion Patterns** | Linear, binary, tail recursion, array/string recursion | `functions.recursion.RecursionPatternsDemo` |
| **Recursion vs Iteration** | Performance comparison, trade-offs, when to use each | `functions.recursion.RecursionVsIterationDemo` |

**Key Topics**: Base case design, stack depth limitations, recursive algorithms (factorial, fibonacci, GCD), performance implications.

---

## Getting Started

### Prerequisites

- **Java Development Kit (JDK)**: Version 21 or higher
- **Apache Maven**: Version 3.x
- **Terminal/Command Line**: For executing the CLI application

### Installation

1. **Clone the Repository**
   ```bash
   git clone https://github.com/yourusername/java-zero-to-expert.git
   cd java-zero-to-expert
   ```

2. **Verify Java Version**
   ```bash
   java -version
   # Should output: java version "21" or higher
   ```

3. **Verify Maven Installation**
   ```bash
   mvn -version
   ```

### Building the Project

Compile all source files:
```bash
mvn clean compile
```

### Running the Application

**Option 1: Maven Exec Plugin**
```bash
mvn exec:java -Dexec.mainClass="com.andres.App"
```

**Option 2: Build and Run JAR**
```bash
mvn clean package
java -jar target/java-zero-to-expert-1.0-SNAPSHOT.jar
```

### Navigating the Menu System

The application presents an interactive menu:

```
|----------------------------------------|
|         MAIN MENU                      |
|----------------------------------------|
| 1. Environment Variables               |
| 2. Console Operations                  |
| 3. Primitive Data Types                |
| 4. Composite Data Types                |
| 5. Control Flow                        |
| 6. Methods and Functions               |
| 0. Exit                                |
|----------------------------------------|
```

- Select a category by entering its number
- Navigate through sub-menus to explore specific topics
- Each demonstration executes and displays results
- Press Enter to return to menus

### Generating API Documentation

Generate comprehensive Javadoc HTML documentation:

```bash
mvn javadoc:javadoc
```

Documentation will be available at: `target/site/apidocs/index.html`

Open in browser:
```bash
# Windows
start target/site/apidocs/index.html

# macOS
open target/site/apidocs/index.html

# Linux
xdg-open target/site/apidocs/index.html
```

---

## Project Structure

Complete directory hierarchy:

```
java-zero-to-expert/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── andres/
│   │               ├── App.java
│   │               ├── console/
│   │               │   ├── input/
│   │               │   │   └── InputReader.java
│   │               │   └── output/
│   │               │       ├── BasicOutput.java
│   │               │       └── FormattedOutput.java
│   │               ├── controlflow/
│   │               │   ├── conditionals/
│   │               │   │   ├── IfElseDemo.java
│   │               │   │   ├── SwitchDemo.java
│   │               │   │   └── TernaryOperatorDemo.java
│   │               │   ├── loops/
│   │               │   │   ├── DoWhileLoopDemo.java
│   │               │   │   ├── ForEachLoopDemo.java
│   │               │   │   ├── ForLoopDemo.java
│   │               │   │   └── WhileLoopDemo.java
│   │               │   └── streams/
│   │               │       └── StreamBasicsDemo.java
│   │               ├── datatypes/
│   │               │   ├── composite/
│   │               │   │   ├── arrays/
│   │               │   │   │   ├── MultiDimensionArrayDemo.java
│   │               │   │   │   └── SingleDimensionArrayDemo.java
│   │               │   │   ├── collections/
│   │               │   │   │   ├── lists/
│   │               │   │   │   │   └── ArrayListDemo.java
│   │               │   │   │   ├── maps/
│   │               │   │   │   │   └── HashMapDemo.java
│   │               │   │   │   ├── queues/
│   │               │   │   │   │   ├── DequeDemo.java
│   │               │   │   │   │   └── QueueDemo.java
│   │               │   │   │   └── sets/
│   │               │   │   │       └── HashSetDemo.java
│   │               │   │   └── numeric/
│   │               │   │       └── BigDecimalDemo.java
│   │               │   └── primitive/
│   │               │       ├── bool/
│   │               │       │   └── BooleanTypeDemo.java
│   │               │       ├── casting/
│   │               │       │   └── TypeCastingDemo.java
│   │               │       ├── character/
│   │               │       │   └── CharacterTypeDemo.java
│   │               │       ├── floatingpoint/
│   │               │       │   └── FloatingPointTypesDemo.java
│   │               │       ├── integers/
│   │               │       │   └── IntegerTypesDemo.java
│   │               │       └── string/
│   │               │           └── StringTypeDemo.java
│   │               ├── environment/
│   │               │   └── EnvironmentVariableManager.java
│   │               └── utils/
│   │                   └── ConsoleUtils.java
│   │
│   └── test/
│       └── java/
│           └── com/
│               └── andres/
│                   └── AppTest.java
│
├── target/                    (Build output - generated)
├── .gitignore
├── pom.xml                    (Maven configuration)
└── README.md                  (This file)
```

---

## Documentation Standards

Every demonstration class follows a **consistent documentation pattern**:

### Class-Level Documentation

Each class includes comprehensive Javadoc with:

```java
/**
 * Demonstrates [TOPIC] in Java.
 *
 * <p><strong>What is [TOPIC]?</strong></p>
 * [Definition and explanation]
 *
 * <p><strong>When to Use:</strong></p>
 * <ul>
 *   <li>Scenario 1</li>
 *   <li>Scenario 2</li>
 * </ul>
 *
 * <p><strong>When NOT to Use:</strong></p>
 * <ul>
 *   <li>Anti-pattern 1</li>
 *   <li>Limitation 1</li>
 * </ul>
 *
 * <p><strong>Usage Contexts:</strong></p>
 * [Real-world applications]
 *
 * <p><strong>Best Practices:</strong></p>
 * <ul>
 *   <li>Practice 1</li>
 *   <li>Practice 2</li>
 * </ul>
 */
```

### Code Characteristics

- **Utility Class Pattern**: All demo classes are `final` with private constructors
  ```java
  public final class ExampleDemo {
      private ExampleDemo() {
          throw new UnsupportedOperationException("Utility class cannot be instantiated");
      }
  }
  ```

- **Entry Point**: Public static `demonstrate()` method
  ```java
  public static void demonstrate() {
      // Orchestrates all demonstrations
  }
  ```

- **Professional Logging**: SLF4J Logger instead of `System.out.println`
  ```java
  private static final Logger logger = LoggerFactory.getLogger(ExampleDemo.class);
  logger.info("Message with {} placeholder", variable);
  ```

- **Organized Sub-Methods**: Complex topics broken into focused demonstration methods
- **Real-World Examples**: Practical scenarios beyond trivial "hello world" examples

---

## Technology Stack

| Component | Technology | Version | Purpose |
|-----------|------------|---------|---------|
| **Language** | Java | 21 | Core programming language (LTS) |
| **Build Tool** | Apache Maven | 3.x | Dependency management, build automation |
| **Logging API** | SLF4J | 2.0.9 | Logging abstraction layer |
| **Logging Implementation** | Logback Classic | 1.4.11 | Concrete logging framework |
| **Testing Framework** | JUnit | 4.11 | Unit testing |
| **Documentation** | Maven Javadoc Plugin | 3.6.3 | API documentation generation |

### Maven Configuration Highlights

**pom.xml Key Settings:**

- **Java Version**: Source/Target 21
- **Encoding**: UTF-8 throughout
- **Main Class**: `com.andres.App` (executable JAR)
- **Javadoc**: HTML5 output with links to Java 21 official docs

**Dependencies:**
- slf4j-api (logging interface)
- logback-classic (logging implementation)
- junit (testing)

**Plugins:**
- maven-compiler-plugin (Java 21 compilation)
- maven-jar-plugin (executable JAR with manifest)
- maven-javadoc-plugin (comprehensive API docs)

---

## Future Roadmap

This repository is **actively evolving**. Planned topics for future addition include:

### Object-Oriented Programming (Planned)
- Classes and Objects
- Constructors and Initialization Blocks
- Inheritance and Method Overriding
- Polymorphism (compile-time and runtime)
- Abstraction and Abstract Classes
- Encapsulation and Access Modifiers
- Composition vs Inheritance

### Interfaces & Advanced OOP (Planned)
- Interface Definitions and Implementation
- Default and Static Methods in Interfaces
- Functional Interfaces
- Multiple Inheritance via Interfaces
- Marker Interfaces

### Generics (Planned)
- Generic Classes and Methods
- Type Parameters and Bounded Types
- Wildcards (?, extends, super)
- Type Erasure and Limitations
- Generic Collections

### Exception Handling (Planned)
- Try-Catch-Finally Blocks
- Checked vs Unchecked Exceptions
- Custom Exceptions
- Exception Propagation
- Try-with-Resources (AutoCloseable)
- Best Practices and Anti-Patterns

### File I/O & NIO (Planned)
- java.io Package (File, FileReader, BufferedReader)
- java.nio Package (Path, Files, Channels)
- Reading and Writing Files
- Directory Operations
- Serialization and Deserialization

### Multithreading & Concurrency (Planned)
- Thread Creation (Thread class, Runnable interface)
- Thread Lifecycle and States
- Synchronization (synchronized keyword, locks)
- Concurrent Collections
- ExecutorService and Thread Pools
- Futures and CompletableFuture
- Parallel Streams

### Advanced Java 8+ Features (Planned)
- Lambda Expressions (deep dive)
- Method References
- Optional Class
- Stream API (advanced operations)
- Collectors (groupingBy, partitioningBy)
- Date and Time API (java.time)

### Collections (Advanced Topics) (Planned)
- Performance Characteristics (Big O analysis)
- Custom Comparators and Comparable
- Collections Utility Methods
- Immutable Collections
- Concurrent Collections (ConcurrentHashMap, CopyOnWriteArrayList)

### Design Patterns (Planned)
- Creational: Singleton, Factory, Builder
- Structural: Adapter, Decorator, Facade
- Behavioral: Strategy, Observer, Template Method

### Database Connectivity (Planned)
- JDBC Fundamentals
- Connection Management
- PreparedStatement and SQL Injection Prevention
- Transaction Management
- Connection Pooling

### Additional Topics (Under Consideration)
- Annotations and Reflection
- Java Modules (Java 9+)
- Regular Expressions
- Networking (Sockets, HTTP)
- JVM Internals and Performance Tuning
- Build Tools (Maven deep dive, Gradle)
- Testing (JUnit 5, Mockito, Test-Driven Development)

**Note**: Topics will be added systematically, maintaining the same rigorous documentation standards and interactive demonstration approach established in current modules.

---

## Contributing

Contributions are welcome! If you'd like to contribute:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/new-topic`)
3. Follow existing documentation standards (see [Documentation Standards](#documentation-standards))
4. Ensure code compiles and follows utility class pattern
5. Add comprehensive Javadoc with all standard sections
6. Update menu system in `App.java` if adding new topics
7. Submit a pull request

**Guidelines:**
- Maintain professional code quality
- Use SLF4J Logger (not System.out)
- Include real-world examples
- Document "when to use" and "when NOT to use"
- Follow existing package structure conventions

---

## License

This project is licensed under the MIT License. See LICENSE file for details.

---

## Author

**Andrés**

Created as a comprehensive, evolving knowledge base for Java developers at all skill levels.

---

## Acknowledgments

- Java community for continuous language evolution
- Oracle for Java platform and documentation
- Open-source contributors to SLF4J, Logback, Maven, and JUnit

---

**Last Updated**: January 2026
**Current Topics**: 36 demonstration classes across 6 major categories
**Repository Status**: Active Development

---

*This README is maintained alongside the codebase and will be updated as new topics are added to the knowledge base.*
