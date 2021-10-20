package Programmers.level3.tree

class PyramidToothbrushSeller  {


    fun solution(enroll: Array<String>, referral: Array<String>, seller: Array<String>, amount: IntArray): IntArray {
        val profitTable = IntArray(enroll.size)
        val nameForIdx = mutableMapOf<String, Int>()
        val enrollForRef = mutableMapOf<String, String>()

        for (idx in enroll.indices) {
            val enrollment = enroll[idx]
            val ref = referral[idx]
            nameForIdx[enrollment] = idx
            enrollForRef[enrollment] = ref
        }

        for (idx in seller.indices) {
            val eachSeller = seller[idx]
            val totalAmount = amount[idx] * 100
            distributeProfit(eachSeller, totalAmount, nameForIdx, enrollForRef, profitTable)
        }

        return profitTable
    }

    private fun distributeProfit(beneficiary: String, lastProfit: Int, nameForIdx : MutableMap<String, Int>, enrollForRef: MutableMap<String, String>, profitTable: IntArray) {
        if (beneficiary != "-" && lastProfit > 0) {
            val nextProfit = if (lastProfit >= 10) lastProfit/10 else 0
            val curProfit = lastProfit - nextProfit
            profitTable[nameForIdx[beneficiary]!!] = profitTable[nameForIdx[beneficiary]!!] + curProfit

            distributeProfit(enrollForRef[beneficiary]!!, nextProfit, nameForIdx, enrollForRef, profitTable)
        }
    }
}

fun main() {
    val enroll = arrayOf("john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young")
    val referral = arrayOf("-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward")
    val seller = arrayOf("sam", "emily", "jaimie", "edward")
    val amount = intArrayOf(2, 3, 5, 4)

    val result =PyramidToothbrushSeller().solution(enroll, referral, seller, amount)
    result.forEach { print("$it ")  }
}