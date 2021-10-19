package leetcode.medium.graph.leet_1631

import java.util.*
import kotlin.math.abs


// 기본적으로 BFS 사용 방법은 Bellman-Ford 알고리즘의 형태임
// 이를 Shortest Path Faster Algorithm(SPFA)이라 부름
// SPFA는 Bellman-Ford가 매 횟수에서 전체 edge relaxation을 하는 데 반해 필요 없는 edge relaxation을 제거함으로써 효율을 높임
// 하지만 최악의 경우 bellman-ford와 성능이 동일(결국 bellman-ford를 좀 더 최적화 한 것)

// https://leetcode.com/problems/path-with-minimum-effort/discuss/909002/JavaPython-3-3-codes%3A-Binary-Search-Bellman-Ford-and-Dijkstra-w-brief-explanation-and-analysis.

// 사이클 생기는걸 어떻게 해결하나 싶어서 확인해보니 efforts[][] 배열을 두고 start로부터 각 노드의 최단거리(최소 effort)를 구하는 방식으로 진행한걸 확인함.


class Leet_1631_Kotlin {
    private val point = intArrayOf(0, 1, 0, -1, 0)

    fun minimumEffortPath(heights: Array<IntArray>): Int {
        val n = heights.size
        val m = heights[0].size

        // 2중배열 생성과 동시에 모든 요소들을 Int.MAX_VALUE로 채운다.
        val efforts = Array(n) { IntArray(m) {Int.MAX_VALUE} }
        val q = LinkedList<Pair<Int, Int>>()

        efforts[0][0] = 0
        q.offer(Pair(0, 0))

        while(q.isNotEmpty()) {
            val cur = q.poll()
            val y = cur.first
            val x = cur.second

            for (i in 0..point.size - 2) {
                val adjX = x + point[i]
                val adjY = y + point[i+1]

                if (adjX >= 0 && adjY >= 0 && adjX < m && adjY < n) {
                    val nextEffort = efforts[adjY][adjX]
                    val toUpdateEffort = efforts[y][x].coerceAtLeast(abs(heights[y][x] - heights[adjY][adjX]))

                    if (nextEffort > toUpdateEffort) {
                        efforts[adjY][adjX] = toUpdateEffort
                        q.offer(Pair(adjY, adjX))
                    }
                }

            }
        }

        return efforts[n-1][m-1]
    }
}

fun main() {
    val heights = arrayOf(
        intArrayOf(1,2,1,1,1),
        intArrayOf(1,2,1,2,1),
        intArrayOf(1,2,1,2,1),
        intArrayOf(1,2,1,2,1),
        intArrayOf(1,1,1,2,1)
    )
    print(Leet_1631_Kotlin().minimumEffortPath(heights))
}