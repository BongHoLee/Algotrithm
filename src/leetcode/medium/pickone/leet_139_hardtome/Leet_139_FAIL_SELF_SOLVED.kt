package leetcode.medium.pickone.leet_139_hardtome

class Leet_139 {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        var word = s

        var start = 0
        while (start < wordDict.size) {

            var converted = -1
            while (converted != 0) {
                converted = 0
                var c = wordDict[start]
                word = word.replaceFirst(c, "-", true)
                for (i in wordDict.indices) {
                    if (word.contains(wordDict[i])) {
                        c = wordDict[i]
                        word = word.replaceFirst(c, "-", true)
                        converted++
                    }
                }
            }

            if (word.replace("-", "") == "") {
                return true
            }

            start++
            word = s
        }

        return false
    }
}

fun main() {
    val s = "fohhemkkaecojceoaejkkoedkofhmohkcjmkggcmnami"
    val wordDict = listOf(
        "c","hk","ecojceoaejkkoed","m","i","g","k","f","n","kofhmoh","fohhemkka","e","kgg","ko","kk","fo","d","o","kcjmkggcmnami","ej"
    )

    for (c in wordDict) {
        if (s.contains(c)) {
            print("$c,")
        }
    }
    println(Leet_139().wordBreak(s, wordDict))
}