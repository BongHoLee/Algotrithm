package dynamicpro_book.ch3
import java.util.*

// 절반 숫자의 합이 같은 부분 문자열 중 가장 긴 부분 문자열

class SubStringHandler_DP_1 {
    fun handle(str: String): String {
        val arr = Array(str.length) {IntArray(str.length)}
        str.forEachIndexed {index, each -> arr[index][index] = Character.getNumericValue(each)}
        var substr = ""

        // 왜맞음... 어케 맞은거임..
        for (y in 1 until str.length-1) {
            for (x in 0 until str.length - y) {
                // k가 중요 변수 ? k와 관련한 식으로 다시 세워보자.

                // arr(from, to) -> 부분문자열 from ~ to 까지의 합
                // arr[0][1], arr[1][2] ... => arr[x][x+y]
                // 대각선 채우기
                val left = arr[x][x+y-1]
                val right = arr[x+y][x+y]
                arr[x][x+y] = left + right

                // from ~ to 까지 반으로 나눌수 있다면(substring이 반으로 나눠질 수 있다면)
                if (( (x) + (x+y) +1)%2 == 0) {
                    val splitIdx = ( (x) + (x+y) +1) / 2
                    if (arr[x][splitIdx-1] == arr[splitIdx][x+y] && substr.length < str.substring(x, x+y+1).length) {
                        substr = str.substring(x, x+y+1)
                    }
                }
            }
        }


        return substr
    }
}

fun main() {
    val str = "9430723129"
    println(SubStringHandler_DP_1().handle(str))
}