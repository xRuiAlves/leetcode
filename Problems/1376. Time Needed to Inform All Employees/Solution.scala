import scala.collection.mutable

object Solution {
  case class SearchNode(id: Int, time: Int)

  def numOfMinutes(n: Int, headID: Int, manager: Array[Int], informTime: Array[Int]): Int = {
    val managees = manager
      .indices
      .map(i => i -> mutable.Set[Int]())
      .toMap

    manager.indices.foreach(i => if (manager(i) != -1) {
      managees(manager(i)).addOne(i)
    })

    val toVisit = mutable.Queue[SearchNode]()
    toVisit.enqueue(SearchNode(headID, 0))

    var totalTime = 0
    while (toVisit.nonEmpty) {
      val curr = toVisit.dequeue()
      val newTotalTime = curr.time + informTime(curr.id)
      totalTime = math.max(totalTime, newTotalTime)
      toVisit.enqueueAll(managees(curr.id).map(id => SearchNode(id, newTotalTime)))
    }

    totalTime
  }
}
