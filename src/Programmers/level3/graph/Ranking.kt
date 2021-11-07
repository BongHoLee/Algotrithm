package Programmers.level3.graph

class Ranking {
    fun solution(n: Int, results: Array<IntArray>): Int {

        // 이 문제를 어떻게 그래프로 해결할 수 있을까?
        // floyd-warshall 알고리즘(모든 노드에서 모든 노드로의 최단경로..) 문제라는데..
        // 어떻게 이 문제에 녹여낼 수 있을까?

        // 각 점수표를 이용해서 각 노드가 노드를 이겼는지 졌는지를 DP 이용해서?
        // 최단경로라기 보다 각 노드 사이의 관계를 이용해서 문제를 해결한다?
        //

        val graph = Array(n+1) {IntArray(n+1)}
        for (result in results) {
            val winner = result[0]
            val looser = result[1]

            graph[winner][looser] = 1
            graph[looser][winner] = -1
        }

        for (k in 1 until n+1) {
            for (i in 1 until n+1) {
                for (j in 1 until n+1) {

                    // i와 j 사이의 승패를 모를 때
                    if (graph[i][j] == 0) {
                        if (graph[i][k] == 1 && graph[k][j] == 1) {
                            graph[i][j] = 1
                            graph[j][i] = -1
                        } else if (graph[i][k] == -1 && graph[k][j] == -1) {
                            graph[i][j] = -1
                            graph[j][i] = 1
                        }
                    }
                }
            }
        }

        var result = 0
        for(y in 1 until n+1) {
            var tmp = 1
            for (x in 1 until n+1) {
                if (x != y) {
                    tmp *= graph[y][x]
                }
            }

            if (tmp != 0) result ++
        }

        return result
    }
}

fun main() {
    val n = 5
    val results = arrayOf(
        intArrayOf(4, 3),
        intArrayOf(4, 2),
        intArrayOf(3, 2),
        intArrayOf(1, 2),
        intArrayOf(2, 5)
    )

    println(Ranking().solution(n, results))
}