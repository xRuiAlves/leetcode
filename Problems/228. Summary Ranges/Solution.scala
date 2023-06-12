object Solution {
  type Range = (Int, Int)

  private[this] final def formatRange(range: Range): String = range match {
    case (l, b) if l != b => s"$l->$b"
    case (l, _) => l.toString
  }

  def summaryRanges(nums: Array[Int]): List[String] = nums.
    foldLeft(List.empty[Range]) {
      case ((l, r) :: tail, curr) if r == curr - 1 => (l, curr) :: tail
      case (list, curr) => (curr, curr) :: list
    }
    .map(formatRange)
    .reverse
}
