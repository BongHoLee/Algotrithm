package leetcode.medium.graph.leet_1462

class Leet_1462_Floyd {
    fun checkIfPrerequisite(numCourses: Int, prerequisites: Array<IntArray>, queries: Array<IntArray>): List<Boolean> {
        val hasPath = Array(numCourses) {BooleanArray(numCourses)}
        val list = mutableListOf<Boolean>()
        for (prerequisite in prerequisites) {
            val from = prerequisite[0]
            val to = prerequisite[1]
            hasPath[from][to] = true
        }

        for (k in 0 until numCourses) {
            for (u in 0 until numCourses) {
                for (v in 0 until numCourses) {
                    if (!hasPath[u][v]) {
                        if (hasPath[u][k] && hasPath[k][v]) {
                            hasPath[u][v] = true
                        }
                    }
                }
            }
        }

        queries.forEach { query -> list.add(hasPath[query[0]][query[1]]) }
        return list
    }
}

fun main() {
    val numCourses = 2
    val prerequisites = arrayOf(
        intArrayOf(1, 0)
    )
    val queries = arrayOf(
        intArrayOf(1, 0),
        intArrayOf(0, 1)
    )

    println(Leet_1462_Floyd().checkIfPrerequisite(numCourses, prerequisites, queries))
}