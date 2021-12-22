package other.dp

import com.sun.xml.internal.fastinfoset.util.StringArray

// 공통 부분 문자열

// ABCD
// DBCA
// -> BC가 부분 공통 문자열

class LCS_DP_1 {
    fun lcs(str1: String, str2: String) : String {
        val strArr = Array(str1.length) {Array(str2.length) {""}}
        var maxStr = ""

        for (y in str1.indices) {
            for (x in str2.indices) {
                if (str1[y] == str2[x]) {

                    if (str1[y] == str2[x]) {
                        val ac = str1[y].toString()

                        if (y > 0 && x > 0) {
                            strArr[y][x] = strArr[y-1][x-1] + ac
                        } else {
                            strArr[y][x] = ac
                        }

                        if (maxStr.length < strArr[y][x].length) {
                            maxStr = strArr[y][x]
                        }
                    }

                }
            }
        }

        return maxStr
    }
}

fun main() {
    val str1 = "ABCDHEF"
    val str2 = "BCDEF"

    println(LCS_DP_1().lcs(str1, str2))
}