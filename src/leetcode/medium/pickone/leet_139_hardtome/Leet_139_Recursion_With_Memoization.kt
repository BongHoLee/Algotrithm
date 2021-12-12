package leetcode.medium.pickone.leet_139_hardtome

class Leet_139_Recursion_With_Memoization {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        return wordBreakRecursion(s, HashSet(wordDict), HashMap())
    }

    private fun wordBreakRecursion(s: String, wordDict: MutableSet<String>, memo: MutableMap<String, Boolean>) : Boolean {
        if (s.isEmpty() ) {
            return true
        }

        if (memo.containsKey(s)) {
            return memo[s]!!
        }

        for (i in 1 .. s.length) {
            if (wordDict.contains(s.substring(0, i))) {

                if (wordBreakRecursion(s.substring(i), wordDict, memo)) {
                    memo[s] = true
                    return true
                }

            }
        }

        memo[s] = false
        return false
    }

}

fun main() {
    val s = "fohhemkkaecojceoaejkkoedkofhmohkcjmkggcmnami"
    val wordDict = listOf(
        "c","hk","ecojceoaejkkoed","m","i","g","k","f","n","kofhmoh","fohhemkka","e","kgg","ko","kk","fo","d","o","kcjmkggcmnami","ej"
    )

    println(Leet_139_Recursion_With_Memoization().wordBreak(s, wordDict))
}