
# Contents

- [Scala native](#scala-native)
    - [What is it ?](#what-is-it-)
    - [How does it work ?](#how-does-it-work-)
        - Leaving the world of the jvm
        - Native code
    - [Why would you use it ?](#why-would-you-use-scala-native-)
        - [Fast Startup](#fast-startup)
        - [C Interoperability](#c-Interoperability)
        - Scalapy ???

- Compare
    - Rust
    - Kotlin
    - Golang

# Scala native

## What is it ?

Simple definition:

> Scala compiler to native code.

More complex definition:

> Scala Native is an optimizing ahead-of-time compiler and lightweight managed
> runtime designed specifically for Scala.

- Ahead of time compiler.  Standard Scala: compiles to JVM bytecode. Then the
JVM interpretes the code and executes it as native code. In some cases Java
uses JIT compilation.  Scala native: the compiler compiles directly to native
code. Doesn't rely on the JVM to run its code. (That's why it requires a
Runtime)

- (Lighweight) Runtime ~= VM (Heap management, Garbage Collector, Class loading) 

## How does it work ?

Compiles to native with llvm:

> The LLVM Project is a collection of modular and reusable compiler and
> toolchain technologies. Despite its name, LLVM has little to do with
> traditional virtual machines. The name "LLVM" itself is not an acronym; it is
> the full name of the project. 

- Optimizer + Code generation support for many CPUs () + LLVM IR Debugger
- Implementation of libc

**Disadvantage**: Since it doesn't run on top of the JVM, it cannot use some of
the libraries that come with it. Scala native provides it's own implementation
of a [subset](http://www.scala-native.org/en/v0.3.9-docs/lib/javalib.html) of
the JDK core libraries.

## Why would you use scala native ?

Advantages of system programming:

- Faster startup
- Use C libraries
- High performance: Lighter runtime / Low level memory allocation
- Develop Kernel drivers or embedded systems

Advantages of scala:

- Functional programming
- Reuse of scala libraries (need to be published for native)
    - [awesome-scala-native](https://github.com/tindzk/awesome-scala-native)
- Use of Scala tooling (sbt, intellij)

Disadvantages:

- Number of contributors (mostly a one-man project)
- Can't use Java libraries.
- Can't use Scala libraries unless built with NIR.
- Using C libraries
    - Need of shared libraries
    - Loss of type safety
    - More complex build

### Fast Startup

See [hello-world](hello-world) example.

### C Interoperability 

### C++ / Objective-C / Swift Interoperability

# Compare

## kotlin

## vs rust

Differences

- Opinionate approach to memory management (statically verified) vs garbage collector.
- Wider ecosystem (wider libraries and adoption on rust)

Similarities

- Favour functional programming
- Powerful type system (see differences)

## vs golang

Differences

- Super simple type system and language design overall (no generics, weird error handling)


