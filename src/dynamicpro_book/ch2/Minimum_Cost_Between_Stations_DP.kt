package dynamicpro_book.ch2

import kotlin.math.sign

// 꽤나 헤맸지?
// 생각해보면 ㅈㄴ 쉬운거네

class Minimum_Cost_Between_Stations_DP {

    fun minimumCost(stations: Array<IntArray>) : Int {
        val minCost = Array(stations.size) {IntArray(stations[0].size)}

        for (y in stations.indices) {
            for (x in y until stations[y].size) {

                if (y==0) {
                    minCost[y][x] = stations[y][x]
                } else {
                    if (y == x) {
                        minCost[y][x] = minCost[y-1][x]
                    } else {
                        minCost[y][x] = Math.min(minCost[y-1][x], stations[y][x] + minCost[y-1][x-1])
                    }
                }
            }
        }

        val j = stations.size - 1
        val i = stations[0].size - 1
        return minCost[j][i]
    }
}


fun main() {
    val stations = arrayOf(
        intArrayOf(0, 10, 75, 140),
        intArrayOf(-1, 0, 35, 130),
        intArrayOf(-1, -1, 0, 80),
        intArrayOf(-1, -1, -1, 0)
    )

    println(Minimum_Cost_Between_Stations_DP().minimumCost(stations))
}
