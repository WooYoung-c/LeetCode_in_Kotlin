import kotlin.math.abs
import kotlin.math.min

class P1478 {
    // failed to solve
    // referred to discussion
    // https://leetcode.com/problems/allocate-mailboxes/discuss/685620/JavaC%2B%2BPython-Top-down-DP-Prove-median-mailbox-O(n3)
    private val max = 100
    private val inf = 100 * 10000

    // houses 안 집 i, j 번째간의 중간값의 거리를 측정해 저장해놓을 배열
    private val cost = Array(max) { IntArray(max) }

    // i, j 간 최소 거리를 저장해놓을 배열
    private val memo = Array(max) { IntArray(max) }

    fun minDistance(houses: IntArray, k: Int): Int {

        val n = houses.size
        houses.sort()

        // cost 배열을 채워넣는다
        for (i in houses.indices) {
            for (j in houses.indices) {
                // i, j의 중간 위치 계산
                val medianPos = houses[(i + j) / 2]
                // i, j 안의 모든 집들과 앞서 계산한 중간 위치간 거리를 모두 더해 저장
                for (m in i..j) {
                    cost[i][j] += abs(medianPos - houses[m])
                }
            }
        }

        return dp(houses, n, k, 0)
    }

    // Top-down 방식으로 최소의 거리를 구한다. 이 때, dp를 이용해 불필요한 연산을 줄인다.
    private fun dp(houses: IntArray, n: Int, k: Int, i: Int): Int {
        // 더 배치할 우편함이 없고, 배치할 위치도 houses의 길이서 부터로 더 배치할 곳이 없을 때 0을 반환
        if (k == 0 && i == n) return 0
        // 위 경우 중 하나라도 해당되면 최대치 반환
        if (k == 0 || i == n) return inf
        // 이미 탐색이 완료된 곳이라면 그 값을 반환
        if (memo[k][i] != 0) return memo[k][i]

        // 답으로 쓸 변수엔 우선 가장 큰값 할당
        var ans = inf

        // 각 구간의 cost에 남은 구간의 최소 cost를 더한 값이 답이 된다
        for (j in i until n) {
            ans = min(ans, cost[i][j] + dp(houses, n, k - 1, j + 1))
        }
        return ans.also { memo[k][i] = it }
    }
}