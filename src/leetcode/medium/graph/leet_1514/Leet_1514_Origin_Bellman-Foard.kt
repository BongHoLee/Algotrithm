package leetcode.medium.graph.leet_1514

fun main() {
    val n = 5
    val edges = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(0, 2),
        intArrayOf(0, 3),
        intArrayOf(1, 2),
        intArrayOf(1, 4),
        intArrayOf(2, 4),
        intArrayOf(3, 4),

    )
    val succProb = doubleArrayOf(
        0.1,
        0.2,
        0.2,
        0.1,
        0.8,
        0.1,
        0.5
    )
    val start = 0
    val end = 4
    println(`Leet_1514_Origin_Bellman-Foard`().maxProbability(n, edges, succProb, start, end))
}

class `Leet_1514_Origin_Bellman-Foard` {

    fun maxProbability(
        n: Int,
        edges: Array<IntArray>,
        succProb: DoubleArray,
        start: Int,
        end: Int) : Double {

        // 각 노드 사이의 간선과 가중치는 graph로 표현
        val graph: MutableMap<Int, MutableList<Pair<Int, Double>>> = mutableMapOf()

        // 계산의 편의성을 위해 start와 각 node 사이의 가중치 표현은 startTo 배열로 표현
        // startTo[node] => start부터 node까지의 가중치.
        val startTo = DoubleArray(n)

        // graph, startTo 초기화
        succProb.forEachIndexed { i, prob ->
            val cur = edges[i][0]
            val adj = edges[i][1]

            when(start) {
                cur -> startTo[adj] = prob
                adj -> startTo[cur] = prob
            }

            graph.getOrPut(cur) { mutableListOf()}.add(Pair(adj, prob))
            graph.getOrPut(adj) { mutableListOf()}.add(Pair(cur, prob))
        }


        // 최대 간선 길이(V - 1) 만큼
        for (i in 0 until n) {

            // 그래프에서 각 노드와 간선들
            for (eachNodeEntry in graph) {
                val curNode = eachNodeEntry.key
                val curNodeToList = eachNodeEntry.value

                // 각 노드(cur)와 노드(adj) 사이의 가중치
                for (curNodeTo in curNodeToList) {
                    val adj = curNodeTo.first
                    val toAdjDistance = curNodeTo.second

                    val canUpdate = startTo[curNode] * toAdjDistance
                    if (startTo[adj] < canUpdate) {
                        startTo[adj] = canUpdate
                    }

                }

            }
        }

        return startTo[end]
    }
}
