package leetcode.medium.graph.leet_743

import java.util.*

// 각 노드는 직전의 비용을 계산해서 가지고 있는다.
class Leet_743_BellmanFord {

    fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {

        val graph = mutableMapOf<Int, MutableList<Pair<Int, Int>>>()
        for (time in times) {
            val from = time[0]
            val to = time[1]
            val weight = time[2]

            graph.getOrPut(from) { mutableListOf() }.add(Pair(to, weight))
        }

        val cost = IntArray(n+1) { 101 }
        cost[0] = 0
        val q = LinkedList<Pair<Int, Int>>()

        cost[k] = 0

        q.add(Pair(k, 0))

        while (q.isNotEmpty()) {
            val cur = q.poll()
            val curNode = cur.first
            val toCurCost = cur.second

            for (adj in graph.getOrDefault(curNode, mutableListOf())) {
                val adjNode = adj.first
                val curToAdjCost = adj.second

                if (cost[adjNode] > toCurCost + curToAdjCost) {
                    cost[adjNode] = toCurCost + curToAdjCost
                    q.add(Pair(adjNode, cost[adjNode]))
                }
            }
        }

        cost.sort()
        return if(cost[n] >= 101) -1 else cost[n]
    }
}

fun main() {
    val times = arrayOf(
        intArrayOf(2, 1, 1),
        intArrayOf(2, 3, 1),
        intArrayOf(3, 4, 1)
    )

    val n = 4
    val k = 2

    print(Leet_743_BellmanFord().networkDelayTime(times, n, k))
}