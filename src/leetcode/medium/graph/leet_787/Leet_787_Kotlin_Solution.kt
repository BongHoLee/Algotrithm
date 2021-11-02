package leetcode.medium.graph.leet_787

// 정석적인 edge relaxation 이다.. (DP)
// 주어진 경로 통과 횟수가 주어졌을 때.. 어떻게 하는지..


class Leet_787_Kotlin_Solution {

    fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, k: Int): Int {
        // initialize price to get to each destination as max
        var prices = IntArray(n) { Integer.MAX_VALUE }

        // assume 0 for the source node
        prices[src] = 0

        for (i in 0 until (k + 1)) {
            val tempPrices = prices.clone()

            for (flight in flights) {
                val source = flight[0]
                val destination = flight[1]
                val cost = flight[2]

                if (prices[source] != Integer.MAX_VALUE && prices[source] + cost < tempPrices[destination]) {
                    tempPrices[destination] = prices[source] + cost
                }
            }

            prices = tempPrices
        }

        return if (prices[dst] == Integer.MAX_VALUE) return -1 else prices[dst]
    }
}

fun main() {
    val n = 4
    val flights = arrayOf(
        intArrayOf(0, 1, 100),
        intArrayOf(1, 2, 100),
        intArrayOf(0, 2, 500)
    )
    val src = 0
    val dst = 2
    val k = 1

    print(Leet_787_Kotlin_Solution().findCheapestPrice(n, flights, src, dst, k))
}