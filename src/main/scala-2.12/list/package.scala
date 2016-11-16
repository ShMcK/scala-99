
import java.util.NoSuchElementException

package object list {

  def last(x: List[Int]): Int = x.last

  def secondLast(x: List[Int]): Int =
    if (x.length > 1) x(x.length - 2)
    else throw new java.util.NoSuchElementException

  def nth(n: Int, x: List[Int]): Int = x(n)

  def length(x: List[Int]): Int = x.length

  def reverse(x: List[Int]): List[Int] = x.reverse

}
