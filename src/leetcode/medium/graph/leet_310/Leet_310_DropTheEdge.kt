package leetcode.medium.graph.leet_310

import java.util.*
import kotlin.collections.HashSet

// 선 날리기 방법으로 진행해보기
// Topologist sort에서 영감을 얻음
// https://leetcode.com/problems/minimum-height-trees/discuss/76055/Share-some-thoughts
class Leet_310_DropTheEdge {
    fun findMinHeightTrees(n: Int, edges: Array<IntArray>): List<Int> {
        if (n == 1) return mutableListOf(0)
        val degreeArray = IntArray(n)
        val graph = mutableMapOf<Int, MutableSet<Int>>()
        init(degreeArray, graph, edges)

        val q = LinkedList<Int>()
        for (i in degreeArray.indices) {
            if (degreeArray[i] == 1) {
                q.offer(i)
            }
        }

        val resultList = mutableListOf<Int>()
        var remainedEdge = n - 1
        while (q.isNotEmpty()) {
            val qSize = q.size

            if ((remainedEdge == 0 && qSize == 1) || (remainedEdge == 1 && qSize == 2)) {
                resultList.addAll(q)
                break;
            }

            for (cur in 0 until qSize) {
                val curNode = q.poll()

                for (adj in graph.getOrDefault(curNode, mutableSetOf())) {
                    graph[curNode]!!.remove(adj)
                    graph[adj]!!.remove(curNode)

                    degreeArray[curNode]--
                    degreeArray[adj]--
                    remainedEdge--

                    if (degreeArray[adj] == 1) {
                        q.offer(adj)
                    }

                }
            }
        }

        return resultList
    }

    fun init(degreeArray: IntArray, graph: MutableMap<Int, MutableSet<Int>>, edges: Array<IntArray>) {
        for (edge in edges) {
            val from = edge[0]
            val to = edge[1]

            degreeArray[from]++
            degreeArray[to]++

            graph.getOrPut(from) { mutableSetOf() }.add(to)
            graph.getOrPut(to) { mutableSetOf() }.add(from)
        }
    }
}

fun main() {
    val n = 5
    val edges = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(0, 2),
        intArrayOf(0, 3),
        intArrayOf(3, 4)
    )
    println(Leet_310_DropTheEdge().findMinHeightTrees(n, edges))
}