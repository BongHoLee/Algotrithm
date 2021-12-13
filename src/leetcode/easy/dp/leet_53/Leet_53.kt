package leetcode.easy.dp.leet_53

// A[i]의 요소가 `반드시 포함`된 상태로 더 큰 값을 구한 뒤 max와 비교
// (A[i]까지의 합 또는 오직 A[i]) compare to (MAX)
// 요거 생각하기 쉽지 않더라고
// 현재의 최적해를 subproblem의 최적해로부터 어떻게 구할 수 있다. -> '최적의 하위 구조'를 갖는다.
// F(4) = MAX(A[4], F(3) + A[3]) => 현재의 최적 해 `F(4)`를 subproblem의 최적해 `F(3)`으로 부터 어떻게 구할 수 있다. => 최적의 하위 구조를 갖는다.


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