object Solution {
  def distributeCookies(cookies: Array[Int], k: Int): Int = {
    val childrenCookies = Array.fill(k)(0)
    var minimumUnfairness = Int.MaxValue

    def findMinimumUnfairness(bagId: Int = 0): Unit = {
      if (bagId == cookies.length) {
        minimumUnfairness = math.min(minimumUnfairness, childrenCookies.max)
      } else {
        childrenCookies.indices.foreach(childId => {
          childrenCookies(childId) += cookies(bagId)
          findMinimumUnfairness(bagId + 1)
          childrenCookies(childId) -= cookies(bagId)
        })
      }
    }

    findMinimumUnfairness()
    minimumUnfairness
  }
}
