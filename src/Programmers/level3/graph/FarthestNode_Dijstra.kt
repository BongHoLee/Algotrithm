package Programmers.level3.graph

import java.util.*

class FarthestNode_Dijstra {
    fun solution(n: Int, edge: Array<IntArray>): Int {
        var max = 0
        var count = 0
        val startToEachDistance = IntArray(n+1) { Int.MAX_VALUE}
        val graph : MutableMap<Int, MutableList<Int>> = mutableMapOf()

        edge.forEach {
            val node = it[0]
            val target = it[1]

            graph.getOrPut(node) { mutableListOf()}.add(target)
            graph.getOrPut(target) { mutableListOf()}.add(node)
        }

        // 다익스트라 최단경로 탐색 노드 삽입을 위한 Heap(Priority Queue)
        val pq = PriorityQueue<Int>(compareBy{startToEachDistance[it]})
        startToEachDistance[1] = 0
        pq.offer(1)

        while (pq.isNotEmpty()) {
            val cur = pq.poll()

            for (adjNode in graph.getOrDefault(cur, mutableListOf())) {
                if (startToEachDistance[adjNode] > startToEachDistance[cur] + 1) {
                    startToEachDistance[adjNode] = startToEachDistance[cur] + 1
                    pq.offer(adjNode)

                    when {
                        max < startToEachDistance[adjNode] -> {
                            max = startToEachDistance[adjNode]
                            count = 1
                        }
                        max == startToEachDistance[adjNode] -> {
                            count ++
                        }
                    }

                }
            }
        }

        return count
    }
}

fun main() {
    val n = 6;
    val vertex = arrayOf(
            intArrayOf(3, 6),
            intArrayOf(4, 3),
            intArrayOf(3, 2),
            intArrayOf(1, 3),
            intArrayOf(1, 2),
            intArrayOf(2, 4),
            intArrayOf(5, 2)
    )
    println(FarthestNode_Dijstra().solution(n, vertex))
}


