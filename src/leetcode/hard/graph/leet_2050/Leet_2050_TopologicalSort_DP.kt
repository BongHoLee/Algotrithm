package leetcode.hard.graph.leet_2050

import java.util.*

class Leet_2050_TopologicalSort_DP {
    fun minimumTime(n: Int, relations: Array<IntArray>, time: IntArray): Int {
        val inDegree = IntArray(n + 1)
        val graph = mutableMapOf<Int, MutableList<Int>>()
        val dp = IntArray(n + 1)

        for (relation in relations) {
            val from = relation[0]
            val to = relation[1]

            inDegree[to]++
            graph.getOrPut(from) { mutableListOf() }.add(to)
        }

        val q = LinkedList<Int>()
        for (i in 1 until inDegree.size) {
            if (inDegree[i] == 0) {
                q.offer(i)
                dp[i] = time[i-1]
            }
        }

        while(q.isNotEmpty()) {
            val curNode = q.poll()

            for (adj in graph.getOrDefault(curNode, mutableListOf())) {
                if (dp[adj] < dp[curNode] + time[adj-1]) {
                    dp[adj] = dp[curNode] + time[adj-1]
                }

                if (--inDegree[adj] == 0) {
                    q.offer(adj)
                }
            }
        }

        var max = 0
        dp.forEach { each ->
            max = each.coerceAtLeast(max)
        }
        return max
    }
}

fun main() {
    val n = 7
    val relations = arrayOf(
        intArrayOf(1, 5),
        intArrayOf(2, 5),
        intArrayOf(3, 4),
        intArrayOf(4, 5),
        intArrayOf(4, 6),
        intArrayOf(5, 7),

        )
    val time = intArrayOf(1, 6, 2, 3, 20, 22, 8)

    // expected 34
    println(Leet_2050_TopologicalSort_DP().minimumTime(n, relations, time))
}