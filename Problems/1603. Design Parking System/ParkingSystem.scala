class ParkingSystem(_big: Int, _medium: Int, _small: Int) {
    private[this] final val capacities = Array(_big, _medium, _small)

    def addCar(carType: Int): Boolean = {
        capacities(carType - 1) -= 1
        capacities(carType - 1) >= 0
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * var obj = new ParkingSystem(big, medium, small)
 * var param_1 = obj.addCar(carType)
 */
 