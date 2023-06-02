import scala.collection.mutable

object Solution {
  class Bomb(val x: Int, val y: Int, val radius: Int) {
    def intersects(other: Bomb): Boolean =
      math.pow(radius, 2) >= math.pow(x - other.x, 2) + math.pow(y - other.y, 2)
  }

  object Bomb {
    def fromArray(bombArray: Array[Int]): Bomb = bombArray match {
      case Array(x, y, radius) => new Bomb(x, y, radius)
      case _                   => throw new Exception(s"Invalid Bomb array ${bombArray.mkString(", ")}")
    }
  }

  def maximumDetonation(bombsRaw: Array[Array[Int]]): Int = {
    val bombs = bombsRaw.map(Bomb.fromArray)
    val graph = bombs
      .map(bomb => bomb -> bombs.filter(neighbor => neighbor != bomb && bomb.intersects(neighbor)))
      .toMap

    val visited = mutable.Set[Bomb]()
    var maxDetonationRadius = 0

    bombs.foreach(bomb => {
      if (!visited(bomb)) {
        val explosion = explosionBombs(graph, bomb)
        maxDetonationRadius = math.max(maxDetonationRadius, explosion.size)
        visited.addAll(explosion)
      }
    })

    maxDetonationRadius
  }

  def explosionBombs(graph: Map[Bomb, Array[Bomb]], start: Bomb): Set[Bomb] = {
    val visited = mutable.Set[Bomb]()
    val toVisit = mutable.Queue[Bomb]()
    toVisit.enqueue(start)

    while (toVisit.nonEmpty) {
      val curr = toVisit.dequeue()
      if (!visited.contains(curr)) {
        visited.addOne(curr)
        toVisit.enqueueAll(graph(curr))
      }
    }

    visited.toSet
  }
}
