package leetcode.medium.graph.leet_207

class Leet_207_BFS {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val graph = mutableMapOf<Int, MutableList<Int>>()
        val isVisited = BooleanArray(numCourses)

        


    }
}

fun main() {
    val numCourses = 2
    val prerequisites = arrayOf(
        intArrayOf(1, 0)
    )
    println(Leet_207_BFS().canFinish(numCourses, prerequisites))
}