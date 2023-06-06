object Solution {
  def canMakeArithmeticProgression(arr: Array[Int]): Boolean = {
    val min = arr.min
    val max = arr.max
    val delta = (max - min).toDouble / (arr.length - 1)
    val progression = arr.indices.map(i => min + delta * i).toSet
    val nums = arr.map(_.toDouble).toSet
    progression.forall(n => nums.contains(n))
  }
}
