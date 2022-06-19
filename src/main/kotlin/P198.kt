import kotlin.math.max

// failed to solve
// referred to discusstion
// https://leetcode.com/problems/house-robber/discuss/156523/From-good-to-great.-How-to-approach-most-of-DP-problems.

class P198_Recursive_Top_Down {
    fun rob(nums: IntArray): Int {
        return rob(nums, nums.size - 1)
    }

    private fun rob(nums: IntArray, i: Int): Int {
        if (i < 0) return 0

        // i번째 집까지 훔칠 수 있는 가장 큰 액수의 돈은
        // i - 1번째 집까지의 액수와,
        // i - 2번째 집까지의 액수에 현재 i 번째의 돈을 더한 액수를 비교한 것 중 제일 큰 값
        return max(rob(nums, i - 2) + nums[i], rob(nums, i - 1))
    }
}

class P198_Recursive_Dp_Top_Down {
    private lateinit var memo: MutableList<Int>

    fun rob(nums: IntArray): Int {
        memo = MutableList(nums.size + 1) { -1 }
        return rob(nums, nums.size - 1)
    }

    private fun rob(nums: IntArray, i: Int): Int {
        if (i < 0) return 0

        // 위 함수에서
        // i 번째 집까지의 액수를 기록하는 공간을 두어 불필요한 연산을 줄인다
        if (memo[i] >= 0) return memo[i]

        val result = max(rob(nums, i - 2) + memo[i], rob(nums, i - 1))
        memo[i] = result
        return result
    }
}

class P198_Iterative_Dp_Bottom_up {
    fun rob(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        val memo = MutableList(nums.size + 1) { -1 }
        memo[0] = 0
        memo[1] = nums[0]
        // 0번째부터 i 번째까지 순차적으로 최대 액수값을 구하면서 그 값을 별도의 배열에 기록한다.
        for (i in 1 until nums.size step 1) {
            val cur = nums[i]
            memo[i + 1] = max(memo[i], memo[i - 1] + cur)
        }
        return memo[nums.size]
    }
}

class P198_Iterative_Two_Variable_Bottom_up {
    fun rob(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        var prev1 = 0
        var prev2 = 0
        // 위 함수와 같지만, 단 두개의 변수 공간으로 진행한다.
        for (i in nums.indices) {
            val tmp = prev1
            prev1 = max(prev1, prev2 + nums[i])
            prev2 = tmp
        }
        return prev1
    }
}