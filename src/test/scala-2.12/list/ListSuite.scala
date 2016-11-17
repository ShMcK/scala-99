package list

import org.scalatest.FunSuite

// 01
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

// 02
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

// 03
class NthElementSuite extends FunSuite {
  test("find the Nth element of a list") {
    val x = List(1, 2, 3, 4, 5)
    assert(nth(2, x) == 3)
  }
}


// 04
class LengthSuite extends FunSuite {
  test("find the length of a list") {
    val x = List(10, 20, 30, 40, 50)
    assert(length(x) == 5)
  }
}

// 05
class ReverseSuite extends FunSuite {
  test("reverse a list") {
    val x = List(1, 2, 3, 4, 5)
    assert(reverse(x) == List(5, 4, 3, 2, 1))
  }
}


// 06
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

// 07
class FlattenSuite extends FunSuite {
  test("flattens a nested List") {
    val result = flatten(List(List(1, 1), 2, List(3, List(5, 8))))
    val expected = List(1, 1, 2, 3, 5, 8)
    assert(result == expected)
  }
}

// 08
class CompressSuite extends FunSuite {
  test("compress removes consecutive duplicates") {
    val x = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    val expected = List('a, 'b, 'c, 'a, 'd, 'e)
    assert(compress(x) == expected)
  }
}

// 09
class PackSuite extends FunSuite {
  test("pack puts repeated elements into inner lists") {
    val result = pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
    val expected = List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))
    assert(result == expected)
  }
}

// 10
class EncodeSuite extends FunSuite {
  test("encode changes list to tuple of count and value") {
    val result = encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
    val expected = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))
    assert(result == expected)
  }
}

// 11
class EncodeModifiedSuite extends FunSuite {
  test("encode but leave items without duplicates as single values") {
    val expected = encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
    val result = List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e))
    assert(result == expected)
  }
}

// 12
class DecodeSuite extends FunSuite {
  test("decode an encoded list") {
    val result = decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
    val expected = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    assert(result == expected)
  }
}

class EncodeDirectSuite extends FunSuite {
  test("encodeDirect, encode a string without using pack") {
    val result = encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
    val expected = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))
    assert(result == expected)
  }
}