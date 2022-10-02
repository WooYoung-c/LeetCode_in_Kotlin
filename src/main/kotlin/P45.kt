import kotlin.math.max

class P45 {
    // referred from here
    // https://leetcode.com/problems/jump-game-ii/discuss/18014/Concise-O(n)-one-loop-JAVA-solution-based-on-Greedy
    fun jump(nums: IntArray): Int {
        var jumps = 0
        var curEnd = 0
        var curFarthest = 0

        for (i in 0 until nums.size - 1) {
            curFarthest = max(curFarthest, i + nums[i])
            if(i == curEnd){
                jumps++
                curEnd = curFarthest
            }
        }
        return jumps
    }
}