
import java.util.NoSuchElementException

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


}
