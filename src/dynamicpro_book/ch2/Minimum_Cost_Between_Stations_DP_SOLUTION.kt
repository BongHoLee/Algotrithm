package dynamicpro_book.ch2

class Minimum_Cost_Between_Stations_DP_SOLUTION {

    fun minimumCost(stations: Array<IntArray>) : Int {
        // minValue[i] : i역 까지 최소 거리
        val minValue = IntArray(stations.size)

        for (y in stations.indices) {
            minValue[y] = stations[0][y]

            for (x in 0 until y) {
                minValue[y] = Math.min(minValue[y], minValue[x] + stations[x][y])
            }
        }

        return minValue[minValue.size-1]
    }
}


fun main() {
    val stations = arrayOf(
        intArrayOf(0, 10, 75, 140),
        intArrayOf(-1, 0, 35, 100),
        intArrayOf(-1, -1, 0, 80),
        intArrayOf(-1, -1, -1, 0)
    )

    println(Minimum_Cost_Between_Stations_DP_SOLUTION().minimumCost(stations))
}
