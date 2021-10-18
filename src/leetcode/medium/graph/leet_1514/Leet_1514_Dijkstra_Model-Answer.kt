package leetcode.medium.graph.leet_1514

import java.util.*

fun main() {
    val n = 3
    val edges = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(1, 2),
        intArrayOf(0, 2)

        )
    val succProb = doubleArrayOf(
        0.5,
        0.5,
        0.2
    )
    val start = 0
    val end = 2
    println(`Leet_1514_Dijkstra_Model-Answer`().maxProbability(n, edges, succProb, start, end))
}


class `Leet_1514_Dijkstra_Model-Answer` {

    fun maxProbability(n: Int, edges: Array<IntArray>, succProb: DoubleArray, start: Int, end: Int): Double {
        val graph: MutableMap<Int, MutableList<Pair<Int, Double>>> = mutableMapOf()
        for (i in edges.indices) {
            val from = edges[i][0]
            val to = edges[i][1]
            val distance = succProb[i]

            graph.getOrPut(from){mutableListOf()}.add(Pair(to, distance))
            graph.getOrPut(to){mutableListOf()}.add(Pair(from, distance))
        }


        val startTo = DoubleArray(n)
        val pq: PriorityQueue<Int> = PriorityQueue(compareBy { -startTo[it]})
        startTo[start] = 1.0
        pq.offer(start)

        while(pq.isNotEmpty()) {
            val cur = pq.poll()
            if (cur == end) {
                return startTo[end]
            }

            for (adj in graph.getOrDefault(cur, mutableListOf())) {
                val adjNode = adj.first
                val curToAdjDistance = adj.second

                if (startTo[adjNode] < startTo[cur] * curToAdjDistance) {
                    startTo[adjNode] = startTo[cur] * curToAdjDistance
                    pq.offer(adjNode)
                }
            }

        }
        return startTo[end]
    }
}

