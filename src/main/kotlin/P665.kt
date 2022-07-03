class P665 {
    // failed to solve
    // referred to discussion
    // https://leetcode.com/problems/non-decreasing-array/discuss/106826/JavaC%2B%2B-Simple-greedy-like-solution-with-explanation
    fun checkPossibility(nums: IntArray): Boolean {
        var count = 0

        for (i in 1 until nums.size) {
            // i - 1 번째 숫자 보다 i 번째 숫자가 작을 때
            if (nums[i - 1] > nums[i]) {
                // 숫자를 바꾼 횟수를 세준다
                count++

                // i - 2 번째 숫자가 존재하지 않을 때,(i = 1일 때)
                // 그리고 i - 2 번째 숫자가 i 번째 숫자가 같거나 작을 때
                // i - 1 번째 숫자를 i 번째 숫자로 바꾼다
                if (i - 2 < 0 || nums[i - 2] <= nums[i]) nums[i - 1] = nums[i]
                // 그렇지 않을 떄 i 번째 숫자를 i - 1 번째 숫자로 바꾼다
                else nums[i] = nums[i - 1]

                // 첫번째 경우를 우선하는 이유 : i 번째 숫자를 우선적으로 바꾼다면 그 이후의 검사에서 문제의 조건을 어길 가능성이 높아지기 때문
                // i, i - 1, i - 2 번째만 고려하는 이유 : for 문은 문제의 조건을 충족하면서 진행되기 때문
            }
        }

        // 숫자를 바꾼 횟수가 1 보다 많으면 false, 그렇지 않음 true
        return count <= 1
    }
}