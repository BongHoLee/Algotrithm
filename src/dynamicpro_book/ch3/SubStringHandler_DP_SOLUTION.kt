package dynamicpro_book.ch3
import java.util.*

// 절반 숫자의 합이 같은 부분 문자열 중 가장 긴 부분 문자열

class SubStringHandler_DP_SOLUTION {
    fun handle(str: String): String {
        val n = str.length
        val arr = Array(n) {IntArray(n)}

        str.forEachIndexed {index, each -> arr[index][index] = Character.getNumericValue(each)}
        var substr = ""

        for (len in 2 .. n) {
            for (y in 0 until (n - len + 1)) {
                val x = y + len - 1
                val k = len / 2

                val left = arr[y][x-k]
                val right = arr[x-k+1][x]
                arr[y][x] =  left + right

                if (len % 2 == 0 && left == right && str.substring(y, x+1).length > substr.length) {
                    substr = str.substring(y, x+1)
                }
            }
        }


        return substr
    }
}

fun main() {
    val str = "9430723129"
    println(SubStringHandler_DP_SOLUTION().handle(str))
}