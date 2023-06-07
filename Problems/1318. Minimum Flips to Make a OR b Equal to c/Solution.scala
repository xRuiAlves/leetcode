object Solution {
  def minFlips(a: Int, b: Int, c: Int): Int = (0 until 32).foldLeft(0) {
    case (flips, i) => flips + numFlips(a, b, c, 1 << i)
  }

  private[this] final def numFlips(a: Int, b: Int, c: Int, mask: Int): Int = {
    val maskA = a & mask
    val maskB = b & mask
    val maskC = c & mask

    if ((maskA | maskB) == maskC) 0
    else if ((maskA & maskB) == 0) 1
    else 2
  }
}
