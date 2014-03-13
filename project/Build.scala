import sbt._
import Keys._

object NameClashBuild extends Build {
  lazy val root = Project(id = "name-clash", base = file(".")) aggregate(foo, bar)

  lazy val foo = Project(id = "name-clash-foo", base = file("foo"))

  lazy val bar = Project(id = "name-clash-bar", base = file("bar")) dependsOn (foo)
}
