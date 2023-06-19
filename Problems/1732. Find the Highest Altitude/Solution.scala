object Solution {
  def largestAltitude(gain: Array[Int]): Int = gain.foldLeft((0, 0)) {
    case ((height, maxHeight), heightGain) => (height + heightGain, math.max(maxHeight, height + heightGain))
  }._2
}
