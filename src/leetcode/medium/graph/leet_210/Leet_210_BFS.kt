package leetcode.medium.graph.leet_210

// Topological Sort (위상정렬) 사용?
class Leet_210_BFS {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {

    }
}

fun main() {
    val numCourses = 4
    val prerequisites = arrayOf(
        intArrayOf(1, 0),
        intArrayOf(2, 0),
        intArrayOf(3, 1),
        intArrayOf(3, 2)
    )

    println(Leet_210_BFS().findOrder(numCourses, prerequisites).toString())
}