object Solution {
  def summaryRanges(nums: Array[Int]): List[String] = nums.
    foldRight(List.empty[(Int, Int)]) {
      case (curr, (l, r) :: tail) if curr + 1 == l => (curr, r) :: tail
      case (curr, list) => (curr, curr) :: list
    }
    .map {
      case (l, b) if l != b => s"$l->$b"
      case (l, _) => l.toString
    }
}
