package leetcode.easy.dp.leet_53

// A[i]의 요소가 `반드시 포함`된 상태로 더 큰 값을 구한 뒤 max와 비교
// (A[i]까지의 합 또는 오직 A[i]) compare to (MAX)
// 요거 생각하기 쉽지 않더라고

class Leet_53 {
    fun maxSubArray(nums: IntArray): Int {
        if (nums.size < 1) return 0
        var max = Int.MIN_VALUE
        var toCur = 0

        for (i in nums.indices) {
            toCur = nums[i].coerceAtLeast(toCur + nums[i])
            max = max.coerceAtLeast(toCur)
        }

        return max
    }
}

fun main() {
    val nums = intArrayOf(-2,1,-3,4,-1,2,1,-5,4)
    println(Leet_53().maxSubArray(nums))
}