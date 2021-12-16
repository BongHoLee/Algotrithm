package dynamicpro_book.ch2

class ArrPathCount_DP {
    fun arrCount(arr: Array<IntArray>, N: Int, M: Int) : Int {


        for (y in 0 until N) {
            for (x in 0 until M) {

                val dp = if (y == 0 && x == 0) {
                    1
                } else {
                    val lastY = if (y - 1 >= 0) arr[y - 1][x] else 0
                    val lastX = if (x - 1 >= 0) arr[y][x - 1] else 0
                    lastX + lastY
                }
                arr[y][x] = dp
            }
        }

        return arr[N-1][M-1]
    }
}

fun main() {
    val N = 4
    val M = 5
    val arr = Array(N) {IntArray(M)}
    println(ArrPathCount_DP().arrCount(arr, N, M))
}