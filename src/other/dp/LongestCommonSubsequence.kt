package other.dp


class LongestCommonSubsequence {
    fun subsequence(str1: String, str2: String): String {
        val dp = Array(str1.length + 1) {Array(str2.length + 1) {""} }
        var maxSubsequence = ""

        // dp[y][x] => str1의 y번째, str2의 x번째 까지 비교했을 때의 최장 부분 수열
        for (y in 1 until dp.size) {
            for (x in 1 until dp[y].size) {

                // 직전의 최장 부분 수열은 str1의 직전, str2의 직전 까지의 비교 중 더 큰 걸 가져온다.
                val lastSubsequence = if (dp[y-1][x].length > dp[y][x-1].length) dp[y-1][x] else dp[y][x-1]

                dp[y][x] = if (str1[y-1] == str2[x-1]) lastSubsequence + str1[y-1].toString() else lastSubsequence
            }
        }

        return dp[dp.size-1][dp[0].size-1]

    }
}

fun main() {
    val str1 = "ABCDFEA"
    val str2 = "GBCDFEOBA"

    println(LongestCommonSubsequence().subsequence(str1, str2))
}