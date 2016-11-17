package object list {

  // 01
  def last[A](x: List[A]): A = x.last

  // 02
  def secondLast[A](x: List[A]): A =
    if (x.length > 1) x(x.length - 2)
    else throw new java.util.NoSuchElementException

  // 03
  def nth[A](n: Int, x: List[A]): A = x(n)

  // 04
  def length[A](x: List[A]): Int = x.length

  // 05
  def reverse[A](x: List[A]): List[A] = x.reverse

  // 06
  def isPalindrome[A](x: List[A]): Boolean = x == x.reverse

  // 07
  def flatten(x: List[Any]): List[Any] = x flatMap {
    case xs: List[_] => flatten(xs)
    case h => List(h)
  }

  // 08
  def compress[A](x: List[A]): List[A] = x.foldLeft(List[A]()) {
    case (res, next)
      if res.isEmpty || res.last != next =>
        res ::: List(next)
    case (res, next) => res
  }

  // 09
  def pack[A](x: List[A]): List[List[A]] = x.foldLeft(List[List[A]]()) {
    // first item
    case (res, next) if res.isEmpty => List(List(next))
      // matches next
    case (res, next)
      if res.last.last == next => res.init :+ (res.last ::: List(next))
      // no match
    case (res, next) => res :+ List(next)
  }

  // 10
  def encode[A](x: List[A]): List[(Int, A)] = {
    pack(x).map(xl => (xl.length, xl.head))
  }

  // 11
  def encodeModified[A](x: List[A]): List[Any] = {
    pack(x) map {
      xl => xl match {
        case xl if xl.length > 1 => (xl.length, xl.head)
        case xl => xl.head
      }
    }
  }
  // Would like output type to be List[(Int, A) ∈ A]
  // Not sure how to implement Union types in Scala

  // 12
  def decode[A](x: List[(Int, A)]): List[A] = {
    x.foldLeft(List[A]())((res, next: (Int, A)) => res ::: List.fill(next._1)(next._2))
  }

}
