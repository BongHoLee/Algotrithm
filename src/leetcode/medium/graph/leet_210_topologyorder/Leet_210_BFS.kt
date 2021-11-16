package leetcode.medium.graph.leet_210_topologyorder

import java.util.*

// Topological Sort (위상정렬) 사용?
class Leet_210_BFS {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val degreeArr = IntArray(numCourses)
        val order = IntArray(numCourses)
        val graph = mutableMapOf<Int, MutableList<Int>>()
        for (prerequisite in prerequisites) {
            val from = prerequisite[1]
            val to = prerequisite[0]

            degreeArr[to]++
            graph.getOrPut(from) { mutableListOf()}.add(to)
        }

        val topologyQueue = LinkedList<Int>()
        for (i in degreeArr.indices) {
            if (degreeArr[i] == 0) topologyQueue.offer(i)
        }

        var visitOrder= 0
        while(topologyQueue.isNotEmpty()) {
            val cur = topologyQueue.poll()
            order[visitOrder] = cur
            visitOrder++

            for (adj in graph.getOrDefault(cur, mutableListOf())) {
                if (--degreeArr[adj] == 0) {
                    topologyQueue.offer(adj)
                }
            }
        }

        return if (visitOrder != degreeArr.size) IntArray(0) else order
    }
}

fun main() {
    val numCourses = 2
    val prerequisites = arrayOf(
        intArrayOf(1, 0)

    )

    println(Leet_210_BFS().findOrder(numCourses, prerequisites).toList())
}