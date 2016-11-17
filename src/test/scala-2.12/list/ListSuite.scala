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

// 13
class EncodeDirectSuite extends FunSuite {
  test("encodeDirect, encode a string without using pack") {
    val result = encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
    val expected = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))
    assert(result == expected)
  }
}

// 14
class DuplicateSuite extends FunSuite {
  test("duplicate doubles items in the list") {
    val result = duplicate(List('a, 'b, 'c, 'c, 'd))
    val expected = List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)
    assert(result == expected)
  }
}

// 15
class DuplicateNSuite extends FunSuite {
  test("duplicate the elements of a list a given number of times") {
    val result = duplicateN(3, List('a, 'b, 'c, 'c, 'd))
    val expected = List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd)
    assert(result == expected)
  }
}

// 16
class DropNSuite extends FunSuite {
  test("drop every Nth element from a list") {
    val result = dropN(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
    val expected = List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)
    assert(result == expected)
  }
}

// 17
class SplitSuite extends FunSuite {
  test("split a list into two parts") {
    val result = split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
    val expected = (List('a, 'b, 'c),List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
    assert(result == expected)
  }
}

// 18
class SliceSuite extends FunSuite {
  test("extract a slice from a list") {
    val result = slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
    val expected = List('d, 'e, 'f, 'g)
    assert(result == expected)
  }
}

// 19
class RotateSuite extends FunSuite {
  test("rotate a list N places to the right") {
    val result = rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
    val expected = List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c)
    assert(result == expected)
  }

  test("rotate a list N places to the left") {
    val result = rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
    val expected = List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i)
    assert(result == expected)
  }
}

// 20
class RemoveAtSuite extends FunSuite {
  test("remove the Kth element from a list") {
    val result = removeAt(1, List('a, 'b, 'c, 'd))
    val expected = (List('a, 'c, 'd),'b)
    assert(result == expected)
  }
}

// 21
class InsertAtSuite extends FunSuite {
  test("insert an element at a given position into a list") {
    val result = insertAt('new, 1, List('a, 'b, 'c, 'd))
    val expected = List('a, 'new, 'b, 'c, 'd)
    assert(result == expected)
  }
}

// 22
class RangeSuite extends FunSuite {
  test("create a list containing all integers within a given range") {
    val result = range(4, 9)
    val expected = List(4, 5, 6, 7, 8, 9)
    assert(result == expected)
  }
}

// 23
class RandomSelect extends FunSuite {
  test("extract a given number of randomly selected elements from a list") {
    val result = randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h))
    assert(result.length == 3)
  }
}

