package leetcode.medium.graph.leet_207


class Leet_207_DFS {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val graph = mutableMapOf<Int, MutableList<Int>>()
        val isVisited = BooleanArray(numCourses)
        val isFinished = BooleanArray(numCourses)

        for (prerequisite in prerequisites) {
            val from = prerequisite[0]
            val to = prerequisite[1]
            graph.getOrPut(from) { mutableListOf() }.add(to)
        }

        graph.keys.forEach { eachNode ->
            if (!isFinished[eachNode]) {
                if (!search(isVisited, isFinished, graph, eachNode)) {
                    return false
                }
            }
        }

        return true
    }

    fun search(isVisited: BooleanArray, isFinished: BooleanArray, graph: MutableMap<Int, MutableList<Int>>, curNode: Int) : Boolean{

        if (isVisited[curNode]) {
            return false
        } else {
            if (isFinished[curNode]) {
                return true
            } else {
                isVisited[curNode] = true
                isFinished[curNode] = true
                for (each in graph.getOrDefault(curNode, mutableListOf())) {
                    if (!search(isVisited, isFinished, graph, each)) {
                        return false
                    }
                }

                isVisited[curNode] = false
                return true
            }
        }
    }

}

fun main() {
    val numCourses = 2
    val prerequisites = arrayOf(
        intArrayOf(1, 0)
    )
    println(Leet_207_DFS().canFinish(numCourses, prerequisites))
}