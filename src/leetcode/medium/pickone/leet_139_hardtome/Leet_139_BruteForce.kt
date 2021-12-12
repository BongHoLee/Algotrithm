package leetcode.medium.pickone.leet_139_hardtome

class Leet_139_BruteForce {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val wordDictSet = HashSet(wordDict)
        return wordBreakRecursion(s, wordDictSet)

    }

    private fun wordBreakRecursion(s: String, wordDictSet: MutableSet<String>) : Boolean {
        if (s.isEmpty()) {
            return true
        }

        // 반복문 내 recursion 횟수 만큼 한 레이어에 노드 생성
        for (start in 1 .. s.length) {
            if (wordDictSet.contains(s.substring(0, start)) && wordBreakRecursion(s.substring(start), wordDictSet)) {
                return true
            }
        }
        return false
    }
}

fun main() {
    val s = "fohhemkkaecojceoaejkkoedkofhmohkcjmkggcmnami"
    val wordDict = listOf(
        "c","hk","ecojceoaejkkoed","m","i","g","k","f","n","kofhmoh","fohhemkka","e","kgg","ko","kk","fo","d","o","kcjmkggcmnami","ej"
    )

    println(Leet_139_BruteForce().wordBreak(s, wordDict))
}

