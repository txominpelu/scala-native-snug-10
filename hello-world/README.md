
# Getting started in Mac

Requirements:

```bash
brew install llvm # compiler backend
brew install bdw-gc re2 # garbage collector and regex c libraries (optional)
```

# Hello world

- Create prototype project  

    ```bash
    sbt new scala-native/scala-native.g8
    ```

- Build native binary

    ```bash
    sbt nativeLink
    ```

- Run

    ```bash
    $ ./target/scala-2.11/hello-world-out
    Hello, world!
    ```

# Scala-native vs Scala start time

```bash
$ time java -cp target/scala-2.11/hello-world-assembly-0.1.0-SNAPSHOT.jar Main
Hello, world!

real	0m0.265s
user	0m0.242s
sys	0m0.070s
$ time ./target/scala-2.11/hello-world-out
Hello, world!

real	0m0.005s
user	0m0.002s
sys	0m0.002s
```


