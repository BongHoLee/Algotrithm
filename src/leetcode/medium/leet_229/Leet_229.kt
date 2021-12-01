package leetcode.medium.leet_229

class Leet_229 {
    fun majorityElement(nums: IntArray): List<Int> {
        val until = (nums.size / 3)
        val elements = mutableMapOf<Int, Int>()
        val moreThanNSet = HashSet<Int>()

        for (num in nums) {
            val count = elements.getOrDefault(num, 0) + 1
            if (count > until) {
                moreThanNSet.add(num)
            }

            elements[num] = count
        }

        return moreThanNSet.toList()
    }
}

fun main() {
    val nums = intArrayOf(3, 2, 3)
    println(Leet_229().majorityElement(nums))
}