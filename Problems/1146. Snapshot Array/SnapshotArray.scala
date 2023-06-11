import scala.collection.mutable

class SnapshotArray(_length: Int) {
  private[this] var currSnapshot = 0
  private[this] val storage: Array[mutable.TreeMap[Int, Int]] = 0
    .until(_length)
    .map(_ => {
      val snapshotsMap = mutable.TreeMap.empty[Int, Int]
      snapshotsMap.put(0, 0)
      snapshotsMap
    })
    .toArray

  def set(index: Int, value: Int) {
    storage(index).put(currSnapshot, value)
  }

  def snap(): Int = {
    currSnapshot += 1
    currSnapshot - 1
  }

  def get(index: Int, snapId: Int): Int = storage(index).rangeTo(snapId).last._2
}
