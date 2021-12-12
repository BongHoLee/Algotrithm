package leetcode.hard.graph.leet_2050

import java.util.*

// 위상정렬 문제인데, DP 요소가 좀 섞여있는건가?

// maxTime <> lastTime + curTime => ㄴㄴ 오류가 존재
// 진입 차수가 2개 이상인 경우 해당 진입 노드들 중에서 최대 소요 시간을 넣어야 하는데 그렇지 않음.(그냥 큐에 마지막에 들어있는 놈이랑 계산되어 들어감)

// 그래서 DP를 사용해야 하는구나.


class Leet_2050_TopologicalSort_fail {
    fun minimumTime(n: Int, relations: Array<IntArray>, time: IntArray): Int {

        val inDegree = IntArray(n+1)
        val graph = mutableMapOf<Int, MutableList<Int>>()
        val q = LinkedList<Pair<Int, Int>>()

        for (relation in relations) {
            val from = relation[0]
            val to = relation[1]

            inDegree[to]++
            graph.getOrPut(from) { mutableListOf() }.add(to)
        }

        var maxTime = 0
        for (i in 1 until inDegree.size) {
            if (inDegree[i] == 0) {
                val nodeTime = time[i - 1]

                // Pair(노드 번호, 누적 시간)
                q.offer(Pair(i, nodeTime))

                maxTime = maxTime.coerceAtLeast(nodeTime)
            }
        }


        while (q.isNotEmpty()) {
            val curNodeInfo = q.poll()
            val curNodeNumber = curNodeInfo.first
            val toCurTime = curNodeInfo.second

            for (adj in graph.getOrDefault(curNodeNumber, mutableListOf())) {
                val toNextTime = toCurTime + time[adj-1]
                maxTime = maxTime.coerceAtLeast(toNextTime)


                if (--inDegree[adj] == 0) {
                    q.offer(Pair(adj, toNextTime))
                }
            }
        }

        return maxTime
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

    // expected 34 ( 2(6) + 5(20) + 7(8)) but output is 33 (fail)
    println(Leet_2050_TopologicalSort_fail().minimumTime(n, relations, time))
}