package dynamicpro_book.ch3
import java.util.*

// 절반 숫자의 합이 같은 부분 문자열 중 가장 긴 부분 문자열

class SubStringHandler_DP_1 {
    fun handle(str: String): String {
        val arr = Array(str.length) {IntArray(str.length)}
        str.forEachIndexed {index, each -> arr[index][index] = Character.getNumericValue(each)}
        var substr = ""

        for (y in 1 until str.length) {
            for (x in 0 until str.length - y) {
                // arr(from, to) -> 부분문자열 from ~ to 까지의 합
                // k가 중요 변수 ?
                // arr[0][1], arr[1][2] ... => arr[x][x+y]
                // 대각선 채우기
                val left = arr[x][x+y-1]
                val right = arr[x+y][x+y]
                arr[x][x+y] = left + right

                if ()
            }
        }


        return substr
    }
}

fun main() {
    val str = "9430723"
    println(SubStringHandler_DP_1().handle(str))
}