package dynamicpro_book.ch3
import java.util.*

// 절반 숫자의 합이 같은 부분 문자열 중 가장 긴 부분 문자열

class SubStringHandler_BRUTE_FORCE {
    fun handle(str: String): String {
        val arr = IntArray(str.length)

        str.forEachIndexed {index, each -> arr[index] = Character.getNumericValue(each)}
        var substr = ""


        for (from in 0 until arr.size-1) {
            for (to in from+1 until arr.size step 2) {
                val splitIdx = ((from + to)/2) + 1
                var left = 0
                var right = 0

                for (i in from .. to) {

                    when {
                        i < splitIdx -> left += arr[i]
                        else -> right += arr[i]
                    }
                }

                if (left == right && str.substring(from, to+1).length > substr.length) {
                    substr = str.substring(from, to+1)
                }
            }
        }

        return substr
    }
}

fun main() {
    val str = "9430723"
    println(SubStringHandler_BRUTE_FORCE().handle(str))
}