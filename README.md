
# Contents

[Scala native](#scala-native)
  [What is it ?](#what-is-it-)
  [Why would you use it ?](#why-would-you-use-scala-native-)
      [C Interoperability](#c-Interoperability)
      Scalapy ???
  [How does it work ?](#how-does-it-work-)
  Leaving the world of the jvm
      Native code

Compare
    Rust
    Kotlin
    Golang

# Scala native

## What is it ?
## Why would you use scala native ?

Advantages of system programming:

- Faster startup
- Use c libraries
- Closer to metal
- Low level memory allocation / IO 

Advantages of scala:

- Functional programming
- Reuse of scala libraries (need to be published for native)
    - Make a list of existing libraries with support for scala native
- Use of Scala tooling (sbt, intellij)

Disadvantages:

- Many libraries are not supported
- Using C libraries (need of shared libraries / loss of type safety / more complex build)

### C Interoperability 

### C++ / Objective-C / Swift Interoperability

## How does it work ?

Compiles to native with llvm:

    - LLVM: The LLVM Project is a collection of modular and reusable compiler and toolchain technologies. Despite its name, LLVM has little to do with traditional virtual machines. The name "LLVM" itself is not an acronym; it is the full name of the project. 
        - Optimizer + Code generation support for many CPUs () + LLVM IR
        - Debugger
        - Implementation of libc

Since it doesn't run on top of the JVM, it cannot use some of the libraries that come with it. Scala native provides it's own implementation of a subset of the JDK core libraries:

http://www.scala-native.org/en/v0.3.9-docs/lib/javalib.html

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


