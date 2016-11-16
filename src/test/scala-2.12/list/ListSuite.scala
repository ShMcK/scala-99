package list

import org.scalatest.FunSuite
// import java.util.NoSuchElementException

class LastSuite extends FunSuite {

  test("last gets last item from list") {
    val x = List(1, 2, 3, 4, 5)
    assert(last(x) == 5)
  }

  test("last handles empty list") {
    val x = List()
    assertThrows[java.util.NoSuchElementException] {
      last(x)
    }
  }
}

class SecondLastSuite extends FunSuite {
  test("secondLast gets second last item from list") {
    val x = List(1, 2, 3, 4, 5)
    assert(secondLast(x) == 4)
  }

  test("secondLast handles empty list") {
    val x = List()
    assertThrows[java.util.NoSuchElementException] {
      secondLast(x)
    }
  }

  test("secondLast handles single item list") {
    val x = List(1)
    assertThrows[java.util.NoSuchElementException] {
      secondLast(x)
    }
  }
}
