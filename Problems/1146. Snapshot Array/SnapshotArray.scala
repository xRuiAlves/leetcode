import scala.collection.mutable

class SnapshotArray(_length: Int) {
  private[this] var currSnapshot = 0
  private[this] val storage: Array[mutable.TreeMap[Int, Int]] = 0
    .until(_length)
    .map(_ => List((0,0)).to(mutable.TreeMap))
    .toArray

  def set(index: Int, value: Int) {
    storage(index).put(currSnapshot, value)
  }

  def snap(): Int = {
    currSnapshot += 1
    currSnapshot - 1
  }

  def get(index: Int, snapId: Int): Int = storage(index).maxBefore(snapId + 1).get._2
}
