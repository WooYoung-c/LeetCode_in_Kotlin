import kotlin.math.max
import kotlin.math.min

class P1594 {
    // failed to solve
    // referred to https://leetcode.com/problems/maximum-non-negative-product-in-a-matrix/discuss/855082/C%2B%2B-Dynamic-Programming-With-Comments
    fun maxProductPath(grid: Array<IntArray>): Int {
        // 행의 개수
        val n = grid.size
        // 열의 개수
        val m = grid[0].size
        // dp에 사용할 배열 선언
        // mn : 각 칸에 방문할 때의 최소값을 저장할 배열
        // mx : 각 칸에 방문할 때의 최대값을 저장할 배열
        val mn = Array(n) { LongArray(m) }
        val mx = Array(n) { LongArray(m) }
        // 각각의 dp 배열의 출발점 (0, 0) 값을 실제 값으로 초기화
        mx[0][0] = grid[0][0].toLong()
        mn[0][0] = mx[0][0]
        // 가장 윗 쪽과 왼 쪽을 초기화한다.
        for (i in 1 until n) {
            mx[i][0] = mx[i - 1][0] * grid[i][0]
            mn[i][0] = mx[i][0]
        }
        for (j in 1 until m) {
            mx[0][j] = mx[0][j - 1] * grid[0][j]
            mn[0][j] = mx[0][j]
        }
        // 출발점을 제외한 각 칸을 순회한다
        for (i in 1 until n) {
            for (j in 1 until m) {
                // 현재 위치의 값을 curr이라 한다.
                val curr = grid[i][j]
                // curr 칸까지 올 때까지 유지할 수 있는 최소 값과 최대 값을 구한다.
                // 최소 : mn에서 이 칸의 바로 위와 바로 왼쪽에 해당하는 값을 비교해 더 작은 값
                // 최대 : mx에서 이 칸의 바로 위와 바로 왼쪽에 해당하는 값을 비교해 더 큰 값
                val min = min(mn[i - 1][j], mn[i][j - 1])
                val max = max(mx[i - 1][j], mx[i][j - 1])
                // 만약 curr이 양수라면
                // mx의 값에 곱하는 것이 제일 큰 값을 얻을 수 있다.
                // 따라서 mx의 값에 곱해 이 값을 다시 mx에 저장한다.
                // 이 때, 이전에 구한 min에도 curr를 곱해 mn에 저장하여 다음 순회에 사용한다.
                if (curr >= 0) {
                    mx[i][j] = max * curr
                    mn[i][j] = min * curr
                }
                // 반대로 curr이 음수라면
                // 절대값이 그나마 낮은 mn의 값에 곱하는 것이 제일 큰 값을 얻는 방법일 것이다.
                // 따라서 앞선 경우와는 반대로 min에 curr를 곱한 수를 mx에 저장하고,
                // max에 curr를 곱한 수를 mn에 저장한다.
                else {
                    mx[i][j] = min * curr
                    mn[i][j] = max * curr
                }
            }
        }
        // 이렇게 완성된 mx 배열의 도착점의 값이 정답이다.
        val res = mx[n - 1][m - 1]
        val mod = 1e9.toLong() + 7
        // 문제의 조건에 따라 res 값이 음수라면 -1, 아니라면 이 값의 modulo 결과를 반환한다.
        return if (res < 0) -1 else (res % mod).toInt()
    }
}