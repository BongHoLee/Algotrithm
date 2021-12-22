package leetcode.easy.dp.leet_70

class LEET_70 {
    fun climbStairs(n: Int): Int {
        val fibo = IntArray(46)
        fibo[0] = 0
        fibo[1] = 1
        fibo[2] = 2

        for (i in 3 .. n) {
            fibo[i] = fibo[i-1] + fibo[i-2]
        }

        return fibo[n]
    }
}

fun main() {
    println(LEET_70().climbStairs(4))
    println(LEET_70().climbStairs(5))
    println(LEET_70().climbStairs(6))
}