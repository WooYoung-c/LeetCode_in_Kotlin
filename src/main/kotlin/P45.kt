import kotlin.math.max

class P45 {
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