package leetcode.medium.graph.leet_310

// 진출차수/진입차수를 비교하는 로직으로

// 각 노드의 최대 길이 방향들을 기록(Map<String, Any>)


// DFS + BFS + memozation으로

class Leet_310 {
    fun findMinHeightTrees(n: Int, edges: Array<IntArray>): List<Int> {
        val heights = Array(n) { mutableMapOf<String, Any>() }
        val visited = BooleanArray(n)
        val graph = mutableMapOf<Int, MutableList<Int>>()

        init(edges, graph)
        outPathsDfs(0, heights, visited, graph)
        calcInPathsWithOutPaths(0, 0, 0, heights, graph)

        var result = mutableListOf<Int>()
        var min = Int.MAX_VALUE
        for (i in heights.indices) {
            if ((heights[i]["height"] as Int) == min) {
                result.add(i)
            }

            if ((heights[i]["height"] as Int) < min) {
                min = heights[i]["height"] as Int
                result = mutableListOf()
                result.add(i)
            }
        }

        return result
    }

    private fun outPathsDfs(curNode: Int, heights: Array<MutableMap<String, Any>>, visited: BooleanArray, graph: MutableMap<Int, MutableList<Int>>) : Int {
        visited[curNode] = true
        heights[curNode]["height"] = 0
        heights[curNode]["set"] = mutableSetOf<Int>()

        if (!graph.containsKey(curNode)) {
            return 0
        } else {

            var maxOutPaths = 0
            for (adj in graph.getOrDefault(curNode, mutableListOf())) {
                if (!visited[adj]) {
                    val searched = outPathsDfs(adj, heights, visited, graph) + 1
                    if (maxOutPaths < searched) {
                        maxOutPaths = searched
                        heights[curNode]["height"] = searched
                        heights[curNode]["set"] = mutableSetOf(adj)
                    } else if (maxOutPaths == searched) {
                        val set =  (heights[curNode]["set"]) as MutableSet<Int>
                        set.add(adj)
                    }
                }
            }

            return maxOutPaths
        }
    }

    // [lastNode's outPaths + 1] vs [lastNode's inPaths + 1] vs [curNode's outPaths]
    private fun calcInPathsWithOutPaths(
        curNode: Int,
        lastNode: Int,
        inPaths: Int,
        heights: Array<MutableMap<String, Any>>,
        graph: MutableMap<Int, MutableList<Int>>

    )  {

        var curHeight = heights[curNode]["height"] as Int
        val lastHeight = heights[lastNode]["height"] as Int
        val lastSet = (heights[lastNode]["set"]) as MutableSet<Int>

        if (curNode != lastNode) {

            // lastNode의 heights경로가 curNode인 경우
            // inpahts, curheigts 계산
            if (lastSet.contains(curNode) && lastSet.size == 1) {
                if (curHeight < inPaths) {
                    curHeight = inPaths
                    val curSet = mutableSetOf<Int>()
                    curSet.add(lastNode)
                    heights[curNode]["height"] = curHeight
                    heights[curNode]["set"] = curSet
                } else if (curHeight == inPaths) {
                    val curSet = heights[curNode]["set"] as MutableSet<Int>
                    curSet.add(lastNode)
                }
            }
            // lastNode의 heights 경로가 curNode가 아닌것이 있는 경우
            else {
                if (curHeight < lastHeight + 1) {
                    curHeight = lastHeight + 1
                    val curSet = mutableSetOf<Int>()
                    curSet.add(lastNode)
                    heights[curNode]["height"] = curHeight
                    heights[curNode]["set"] = curSet
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
    val n = 5
    val edges = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(0, 2),
            intArrayOf(0, 3),
            intArrayOf(3, 4)
    )
    println(Leet_310().findMinHeightTrees(n, edges))
}

