package leetcode.medium.graph.leet_787

// DFS로 코스트 저장

class Leet_787_DFS_KT_timefail {

    fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, k: Int): Int {
        val graph: MutableMap<Int, MutableList<Pair<Int, Int>>> = mutableMapOf()

        for (flight in flights) {
            val from = flight[0]
            val to = flight[1]
            val price = flight[2]
            graph.getOrPut(from) { mutableListOf() }.add(Pair(to, price))
        }

        val cost = IntArray(n) {10001}
        for (adj in graph.getOrDefault(src, mutableListOf())) {
            cost[src] = cost[src].coerceAtMost(dfs(adj, dst, k, cost, graph))
        }

        return if(cost[src] == 10001) -1 else cost[src]
    }

    fun dfs(node: Pair<Int, Int>, dsc: Int, k: Int, cost: IntArray,  graph: MutableMap<Int, MutableList<Pair<Int, Int>>>) : Int{
        val nodeNumber = node.first
        val toNodePrice = node.second

        when {
            k < 0 -> {
                return -1
            }
            nodeNumber == dsc -> {
                return toNodePrice
            }
            else -> {
                var min = 10001
                for (adj in graph.getOrDefault(nodeNumber, mutableListOf())) {
                    val adjResult =  dfs(adj, dsc, k-1, cost,graph)

                    // 경로가 없는 경우 -1로 return 되므로 상정하지 않음
                    if (adjResult in 1..10000) {
                        val curWithAdjResult = toNodePrice + adjResult
                        min = min.coerceAtMost(curWithAdjResult)
                    }
                }
                cost[nodeNumber] = cost[nodeNumber].coerceAtMost(min)
                return min
            }
        }
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

    print(Leet_787_DFS_KT_timefail().findCheapestPrice(n, flights, src, dst, k))
}