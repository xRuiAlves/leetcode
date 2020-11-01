object Day29 {
    def maxDistToClosest(seats: Array[Int]): Int = {
        var last_occupied = -1
        val empty_seats_counts = Array.fill(seats.length)(Int.MaxValue)

        for (i <- seats.indices) seats(i) match {
            case 1 => last_occupied = i
            case 0 => if (last_occupied != -1) empty_seats_counts(i) = i - last_occupied
        }

        last_occupied = -1
        for (i <- seats.indices.reverse) seats(i) match {
            case 1 => last_occupied = i
            case 0 => if (last_occupied != -1) empty_seats_counts(i) = math.min(empty_seats_counts(i), last_occupied - i)
        }

        empty_seats_counts.filter(_ != Int.MaxValue).max
    }
}
