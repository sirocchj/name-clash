package a.b

trait FooComponent {
  val foo: Foo

  object Foo {
    def apply(): Foo = new FooImpl
  }

  private class FooImpl extends Foo {
    override def someMethod() = "res"
  }
}

object FooComponentImpl extends FooComponent {
  override val foo = Foo()
}
