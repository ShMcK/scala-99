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

class NthElementSuite extends FunSuite {
  test("find the Nth element of a list") {
    val x = List(1, 2, 3, 4, 5)
    assert(nth(2, x) == 3)
  }
}

class LengthSuite extends FunSuite {
  test("find the length of a list") {
    val x = List(10, 20, 30, 40, 50)
    assert(length(x) == 5)
  }
}

class ReverseSuite extends FunSuite {
  test("reverse a list") {
    val x = List(1, 2, 3, 4, 5)
    assert(reverse(x) == List(5, 4, 3, 2, 1))
  }
}

class PalindromeSuite extends FunSuite {
  test("returns true for odd palindromes") {
    val x = List(1, 2, 3, 2, 1)
    assert(isPalindrome(x))
  }

  test("returns true for even palindromes") {
    val x = List(1, 2, 2, 1)
    assert(isPalindrome(x))
  }

  test("returns true for single item lists") {
    val x = List(1)
    assert(isPalindrome(x))
  }

  test("returns false for non-palindromes") {
    val x = List(2, 3, 1)
    assert(!isPalindrome(x))
  }
}

class FlattenSuite extends FunSuite {
  test("flattens a nested List") {
    val result = flatten(List(List(1, 1), 2, List(3, List(5, 8))))
    val expected = List(1, 1, 2, 3, 5, 8)
    assert(result == expected)
  }
}