import scala.collection.mutable.ArrayBuffer

object Solution {
    def winnerSquareGame(n: Int): Boolean = {
        val dp = new Array[Boolean](n + 1)
        val exponents = buildExponents(n)

        for (i <- dp.indices) {
            var j = 0
            while (j < exponents.length && i - exponents(j) >= 0 && !dp(i)) {
                dp(i) = dp(i) || !dp(i - exponents(j))
                j += 1
            }
        }

        dp(n)
    }

    def buildExponents(n: Int): Array[Int] = {
        val exponents = new ArrayBuffer[Int]()

        var i = 1
        while (i*i <= n) {
            exponents += (i * i)
            i += 1
        }

        exponents.toArray
    }
}
