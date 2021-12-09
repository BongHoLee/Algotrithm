package dynamicpro_book.ch2

import kotlin.reflect.jvm.internal.impl.utils.DFS

// 각 station을 거치느냐 거치지 않느냐로 분할 정복이 가능할 듯 함.
class Minimum_Cost_Between_Stations {

    fun minimumCost(stations: Array<IntArray>, start: Int, dest: Int) : Int{
        val memo = Array(dest+1) { IntArray(dest+1) {Int.MAX_VALUE} }
        val visited = Array(dest+1) { IntArray(dest+1) {0} }

        return passTo(stations, start, dest, memo, visited)
    }

    private fun passTo(stations: Array<IntArray>, start: Int, dest: Int, memo: Array<IntArray>, visited: Array<IntArray>) : Int {
        if (start == dest) {
            return stations[start][dest]
        }

        var minCost = Int.MAX_VALUE
        for (goThrough in start+1 .. dest) {

            // 메모제이션이 되어있지 않으면 탐색
            if (visited[start][goThrough] == 0) {
                val passResult = stations[start][goThrough] + passTo(stations, goThrough, dest, memo, visited)

                memo[start][goThrough] = Math.min(memo[start][goThrough], passResult)
            }

            minCost = Math.min(minCost, memo[start][goThrough])
            visited[start][goThrough] = 1

        }

        return minCost
    }

}

fun main() {
    val stations = arrayOf(
        intArrayOf(0, 10, 75, 94),
        intArrayOf(-1, 0, 35, 50),
        intArrayOf(-1, -1, 0, 80),
        intArrayOf(-1, -1, -1, 0)
    )

    println(Minimum_Cost_Between_Stations().minimumCost(stations, 0, 3))
}