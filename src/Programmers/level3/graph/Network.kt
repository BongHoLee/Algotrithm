package Programmers.level3.graph

fun main() {
    val n = 3
    val computers = arrayOf(
        intArrayOf(1, 1, 0),
        intArrayOf(1, 1, 1),
        intArrayOf(0, 1, 1)
    )

    println(Network().solution(n, computers))
}

class Network {
    fun solution(n: Int, computers: Array<IntArray>): Int {
        var networkCount = 0
        val visited = BooleanArray(n)
        val graph = hashMapOf<Int, MutableList<Int>>()
        computers.forEachIndexed {y, connected ->
            connected.forEachIndexed { x, computer ->
                if (computer == 1) {
                    graph.getOrPut(y) { mutableListOf()}.add(x)
                }
            }
        }

        for (entry in graph) {
            val curComputer = entry.key
            if (!visited[curComputer])  {
                networkCount++
                dfs(curComputer, visited, graph)
            }
        }

        return networkCount
    }

    private fun dfs(node: Int, visited: BooleanArray, graph: MutableMap<Int, MutableList<Int>>) {
        if (!visited[node]) {
            visited[node] = true

            for (connected in graph.getOrDefault(node, mutableListOf())) {
                dfs(connected, visited, graph)
            }

        }
    }
}

