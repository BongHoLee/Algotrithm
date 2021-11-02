package leetcode.medium.graph.leet_787

import java.util.*

// 기본적인 벨만-포드 알고리즘으로는 해결이 어렵나?(될듯)
// 메모제이션을 위해 distance, currentStop을 활용
// distance가 더 작거나, currentStop이 더 작으면 갱신하는 방식
    // 둘 다(distance, currentStop) 비교함으로써 누락되는 상황을 피해갈 수 있구나.

class Leet_787_BellmanFord_KT {

    fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, k: Int): Int {
        val graph = mutableMapOf<Int, MutableList<Pair<Int, Int>>>()

        for (flight in flights) {
            val from = flight[0]
            val to = flight[1]
            val weight = flight[2]

            graph.getOrPut(from) { mutableListOf() }.add(Pair(to, weight))
        }


        val distance = IntArray(n) {Int.MAX_VALUE}
        distance[src] = 0

        val currentStop = IntArray(n) {Int.MAX_VALUE}
        currentStop[src] = 0

        // {node, cost, distance}
        val q = LinkedList<IntArray>()
        q.add(intArrayOf(src, 0, 0))

        var min = Int.MAX_VALUE
        while (q.isNotEmpty()) {
            val cur = q.poll()
            val node = cur[0]
            val cost = cur[1]
            val stop = cur[2]

            if (node == dst) {
                min = min.coerceAtMost(cost)
                continue
            }

            if (stop > k) {
                continue
            }

            for (adj in graph.getOrDefault(node, mutableListOf())) {
                val adjNode = adj.first
                val curToAdjCost = adj.second

                val dU = cost
                val dV = distance[adjNode]
                val wUV = curToAdjCost

                // Better Cost
                if (dU + wUV < dV) {
                    q.offer(intArrayOf(adjNode, dU + wUV, stop + 1))
                    distance[adjNode] = dU + wUV
                } else if (stop < currentStop[adjNode]) {
                    q.offer(intArrayOf(adjNode, dU + wUV, stop + 1))
                }
                currentStop[adjNode] = stop

            }
        }

        return if(min == Int.MAX_VALUE) -1 else min
    }
}

fun main() {
    val n = 5
    val flights = arrayOf(
        intArrayOf(4, 1, 1),
        intArrayOf(1, 2, 3),
        intArrayOf(0, 3, 2),
        intArrayOf(0, 4, 10),
        intArrayOf(3, 1, 1),
        intArrayOf(1, 4, 3)

    )
    val src = 2
    val dst = 1
    val k = 1

    println(Leet_787_BellmanFord_KT().findCheapestPrice(n, flights, src, dst, k))
}