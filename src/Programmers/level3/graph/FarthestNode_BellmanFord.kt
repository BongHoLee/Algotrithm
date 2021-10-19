package Programmers.level3.graph

import java.util.*

class FarthestNode_BellmanFord {
    fun solution(n: Int, edge: Array<IntArray>): Int {
        var max = 0
        var count = 0
        val visited = BooleanArray(n+1)
        val graph : MutableMap<Int, MutableList<Int>> = mutableMapOf()

        edge.forEach {
            val node = it[0]
            val target = it[1]

            graph.getOrPut(node) { mutableListOf()}.add(target)
            graph.getOrPut(target) { mutableListOf()}.add(node)
        }

        // 노드 탐색을 위한 q
        val q = LinkedList<Pair<Int,Int>>()
        visited[1] = true
        q.offer(Pair(1, 0))

        while (q.isNotEmpty()) {
            val nodes = q.size
            for (i in 0 until nodes) {
                val cur = q.poll()
                val curNode = cur.first
                val curDistance = cur.second

                for (adj in graph.getOrDefault(curNode, mutableListOf())) {
                    if (!visited[adj]) {
                        visited[adj] = true
                        q.offer(Pair(adj, curDistance+1))

                        when {
                            curDistance+1 > max ->  {
                                max = curDistance+1
                                count = 1
                            }

                            curDistance+1 == max -> {
                                count++
                            }

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
    println(FarthestNode_BellmanFord().solution(n, vertex))
}


