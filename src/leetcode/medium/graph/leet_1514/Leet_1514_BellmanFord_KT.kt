package leetcode.medium.graph.leet_1514

import java.util.*


fun main() {
    val n = 3
    val edges = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(1, 2),
        intArrayOf(0, 2)
    )
    val succProb = doubleArrayOf(0.5, 0.5, 0.2)
    val start = 0
    val end = 2
    println(Leet_1514_BellmanFord_KT().maxProbability(n, edges, succProb, start, end))
}


class Leet_1514_BellmanFord_KT {
    fun maxProbability(n: Int, edges: Array<IntArray>, succProb: DoubleArray, start: Int, end: Int) : Double {
        val graph: MutableMap<Int, MutableList<Pair<Int, Double>>> = mutableMapOf()
        edges.forEachIndexed { i, nodeToTarget ->
            val node = nodeToTarget[0]
            val target = nodeToTarget[1]
            graph.getOrPut(node) { mutableListOf() }.add(Pair(target, succProb[i]))
            graph.getOrPut(target) { mutableListOf() }.add(Pair(node, succProb[i]))
        }

        // start부터 다른 노드까지의 최단거리 기록(memozation)
        val startTo = DoubleArray(n)
        startTo[start] = 1.0;

        val q = LinkedList(mutableListOf(start))
        while (q.isNotEmpty()) {
            val cur = q.poll()
            for (adj in graph.getOrDefault(cur, Collections.emptyList())) {
                val adjNode = adj.first
                val distance = adj.second
                if (startTo[adjNode] < startTo[cur] * distance) {
                    startTo[adjNode] = startTo[cur] * distance
                    q.offer(adjNode)
                }
            }
        }

        return startTo[end]
    }
}

