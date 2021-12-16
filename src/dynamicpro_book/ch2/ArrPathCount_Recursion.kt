package dynamicpro_book.ch2

class ArrPathCount_Recursion {
    var count = 0
    fun arrCount(arr: Array<IntArray>, N: Int, M: Int) : Int{
        count++
        if (N > arr.size || M > arr[0].size) {
            return 0
        }

        if (N == arr.size && M == arr[0].size) {

            return 1
        }

        return arrCount(arr, N+1, M) + arrCount(arr, N, M+1)
    }
}

fun main() {
    val N = 3
    val M = 4
    val arr = Array(N) { IntArray(M) }
    val ar = ArrPathCount_Recursion()


    println(ar.arrCount(arr, 1, 1))
    println(ar.count)
}