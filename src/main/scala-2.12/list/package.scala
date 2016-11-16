
import java.util.NoSuchElementException

package object list {

  def last(x: List[Int]): Int = x.last

  def secondLast(x: List[Int]): Int =
    if (x.length > 1) x(x.length - 2)
    else throw new java.util.NoSuchElementException

}
