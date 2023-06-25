import scala.collection.mutable

object Solution {
  private[this] final case class State(location: Int, fuel: Int)
  private[this] final val MOD = (1e9 + 7).toInt

  def countRoutes(locations: Array[Int], start: Int, finish: Int, fuel: Int): Int = {
    val cache = new mutable.HashMap[State, Long]()

    def visit(state: State): Long = cache.get(state) match {
      case Some(cached) => cached
      case _ => state match {
        case State(_, fuel) if fuel < 0 => 0
        case State(location, fuel) => {
          val numChildRoutes = locations.indices.foldLeft(0L) {
            case (acc, neighbor) if neighbor != location =>
              (acc + visit(State(neighbor, fuel - math.abs(locations(location) - locations(neighbor))))) % MOD
            case (acc, _) => acc
          } + (if (location == finish) 1 else 0)
          cache(state) = numChildRoutes
          numChildRoutes
        }
      }
    }

    visit(State(start, fuel)).toInt
  }
}
