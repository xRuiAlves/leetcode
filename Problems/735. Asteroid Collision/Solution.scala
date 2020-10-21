import scala.collection.mutable

object Solution {
    def asteroidCollision(asteroids: Array[Int]): Array[Int] = {
        val new_asteroids = new mutable.Stack[Int]()

        def areColliding(left: Int, right: Int): Boolean = left > 0 && right < 0

        def performCollisionLoop(asteroid: Int): Unit = {
            while (new_asteroids.nonEmpty && areColliding(new_asteroids.top, asteroid)) {
                val left_weight = math.abs(new_asteroids.top)
                val right_weight = math.abs(asteroid)

                if (right_weight > left_weight) {
                    new_asteroids.pop()
                } else {
                    if (right_weight == left_weight) {
                        new_asteroids.pop()
                    }
                    return
                }
            }
            new_asteroids.push(asteroid)
        }

        for (asteroid <- asteroids) {
            if (new_asteroids.isEmpty) {
                new_asteroids.push(asteroid)
            } else {
                performCollisionLoop(asteroid)
            }
        }

        new_asteroids.to(Array).reverse
    }
}
