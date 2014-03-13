package a.b

import org.junit.Test
import org.scalatest.junit.{JUnitSuite, ShouldMatchersForJUnit}

class FooTest extends JUnitSuite with ShouldMatchersForJUnit with FooComponent {
  override val foo = Foo()

  @Test
  def test1() {
    foo.someMethod() should equal("res")
  }
}
