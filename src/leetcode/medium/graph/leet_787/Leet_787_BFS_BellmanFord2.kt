package leetcode.medium.graph.leet_787

import java.util.*


// 하하 내가 풀오따! 물론 엄청 찾아보고 헤맸지만!
// queue에 Pair(노드, 거리)를 저장함으로써 직전에 계산된 거리를 가져올 수 있다
    // 그리고 cost[]는 edge relaxation 마다(loop마다) 갱신된 비용을 갖기 때문에 k(loop)가 달라도 계산 가능하다.

class Leet_787_BFS_BellmanFord2 {
    fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, k: Int): Int {
        val graph = mutableMapOf<Int, MutableList<Pair<Int, Int>>>()
        for (flight in flights) {
            val from = flight[0]
            val to = flight[1]
            val weight = flight[2]
            graph.getOrPut(from) { mutableListOf() }.add(Pair(to, weight))
        }

        val cost = IntArray(n) {Int.MAX_VALUE}
        cost[src] = 0
        // {node, cost}
        val q = LinkedList<Pair<Int, Int>>()
        q.offer(Pair(src, 0))


        var stop = k
        while(q.isNotEmpty() && stop >= 0) {
            val qSize = q.size

            for (i in 0 until qSize) {
                val cur = q.poll()
                val curNode = cur.first
                val toCurCost = cur.second


                for (adj in graph.getOrDefault(curNode, mutableListOf())) {
                    val adjNode = adj.first
                    val curToAdjCost = adj.second

                    if (cost[adjNode] > toCurCost + curToAdjCost) {
                        cost[adjNode] = toCurCost + curToAdjCost
                        q.offer(Pair(adjNode, toCurCost + curToAdjCost))
                    }

                }

            }

            stop--
        }

        return if(cost[dst] == Int.MAX_VALUE) -1 else cost[dst]
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

    print(Leet_787_BFS_BellmanFord2().findCheapestPrice(n, flights, src, dst, k))
}