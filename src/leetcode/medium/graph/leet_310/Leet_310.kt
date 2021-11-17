package leetcode.medium.graph.leet_310

// 진출차수/진입차수를 비교하는 로직으로

// 각 노드의 최대 길이 방향을 기록

// DFS + BFS + memozation으로

class Leet_310 {
    fun findMinHeightTrees(n: Int, edges: Array<IntArray>): List<Int> {
        val heights = Array(n) {Pair(0, 0)}
        val visited = BooleanArray(n)
        val graph = mutableMapOf<Int, MutableList<Int>>()

        init(edges, graph)
        outPathsDfs(0, heights, visited, graph)
        calcInPathsWithOutPaths(0, 0, 0, heights, graph)

        var result = mutableListOf<Int>()
        var min = Int.MAX_VALUE
        for (i in heights.indices) {
            if (heights[i].first == min) {
                result.add(i)
            }

            if (heights[i].first < min) {
                min = heights[i].first
                result = mutableListOf()
                result.add(i)
            }
        }

        return result
    }

    private fun outPathsDfs(curNode: Int, heights: Array<Pair<Int, Int>>, visited: BooleanArray, graph: MutableMap<Int, MutableList<Int>>) : Int {
        visited[curNode] = true

        if (!graph.containsKey(curNode)) {
            return 0
        } else {

            var maxOutPaths = 0
            var maxPathsNode = 0
            for (adj in graph.getOrDefault(curNode, mutableListOf())) {
                if (!visited[adj]) {

                    val searched = outPathsDfs(adj, heights, visited, graph) + 1
                    if (maxOutPaths < searched) {
                        maxOutPaths = searched
                        maxPathsNode = adj
                    }
                }
            }

            heights[curNode] = Pair(maxOutPaths, maxPathsNode)
            return maxOutPaths
        }
    }

    // [lastNode's outPaths + 1] vs [lastNode's inPaths + 1] vs [curNode's outPaths]
    private fun calcInPathsWithOutPaths(
        curNode: Int,
        lastNode: Int,
        inPaths: Int,
        heights: Array<Pair<Int, Int>>,
        graph: MutableMap<Int, MutableList<Int>>

    )  {

        var curHeight = heights[curNode].first
        val lastHeights = heights[lastNode]

        if (curNode != lastNode) {

            // lastheigts, curheights 계산
            if (curNode != lastHeights.second) {
               curHeight = curHeight.coerceAtLeast(lastHeights.first + 1)
               heights[curNode] = Pair(curHeight, lastNode)
            }
            // inpahts, curheigts 계산
            else {
                if (curHeight < inPaths) {
                    curHeight = inPaths
                    heights[curNode] = Pair(curHeight, lastNode)
                }
            }


        }


        for (adj in graph.getOrDefault(curNode, mutableListOf())) {
            if (adj != lastNode) {
                calcInPathsWithOutPaths(adj, curNode, inPaths + 1, heights, graph)
            }
        }
    }

    private fun init(edges: Array<IntArray>, graph: MutableMap<Int, MutableList<Int>>) {
        for (edge in edges) {
            val from = edge[0]
            val to = edge[1]

            graph.getOrPut(from) { mutableListOf() }.add(to)
            graph.getOrPut(to) { mutableListOf() }.add(from)
        }
    }
}

fun main() {
    val n = 3
    val edges = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(0, 2)

    )
    println(Leet_310().findMinHeightTrees(n, edges))
}

