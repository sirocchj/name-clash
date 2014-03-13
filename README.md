# Name clash files & gradle build

It appears to me that the way I build mixed Java/Scala projects w/ Gradle is somewhat wrong.

I start off with a multimodule project with two submodules, named `foo` and `bar`.

In `foo` I have created a Java interface (in `foo/src/main/java/a/b/Foo.java`) **and**
I've created some Scala code which makes use of that Java interface
(in `foo/src/main/scala/a/b/Foo.scala`).
More specifically `Foo.scala` contains one trait, named `FooComponent`, and one object,
named `FooComponentImpl`.

In `bar` I have just some ScalaTest/JUnit testing code
(in `bar/src/test/scala/a/b/FooComponentTest.scala`).

Finally, this project can be both built w/ SBT, as follows:

```
$ sbt clean test package
```

**and** w/ Gradle (and in this case you'll spot immediately an issue), as follows:

```
$ gradle clean test assemble
```

In the Gradle case the test cannot be compiled as it cannot find the `FooComponent`
trait that it needs to mix-in. This is due to the fact that there's no Scala bytecode
which managed to get into the resulting .jar file (which can be located in
`foo/build/libs/foo.jar`).

## Puzzling bit:

Have a try with this:

```
$ mv foo/src/main/scala/a/b/Foo.scala foo/src/main/scala/a/b/Foos.scala
```

and then again:

```
$ gradle clean test assemble
```

:)
