import java.util.*

class P611 {
    // failed to solve
    // referred to https://leetcode.com/problems/valid-triangle-number/discuss/128135/A-similar-O(n2)-solution-to-3-Sum
    fun triangleNumber(nums: IntArray): Int {
        // 답을 저장할 변수를 선언
        var count = 0
        // 입력 배열을 정렬한다.
        Arrays.sort(nums)
        // k에 배열의 마지막에서 부터 2번째 숫자까지의 인덱스값을 지정
        for (k in nums.size - 1 downTo 2) {
            // 제일 첫 번째 숫자의 인덱스를 i,
            var i = 0
            // k 바로 왼쪽의 숫자의 인덱스를 j라고 한다.
            var j = k - 1
            // 계속 j가 i의 오른 편에 위치할 때,
            while (i < j) {
                // i 번째 수와 j 번째 수의 합이 k 번째 수보다 작을 때,
                // 즉 이 세 수로 삼각형을 만들 수 있을 때
                if (nums[i] + nums[j] > nums[k]) {
                    // i 번째 수와 j 번째 수 사이의 있는 수는 모두 삼각형을 만들 수 있다.
                    // 배열은 정렬되어 있어 i + 1 번째 수에서 j - 1 번째 수는 모두 i 번째 수보다 커,
                    // 위 식에 nums[i] 대신 nums[i + 1] ~ nums[j - 1]를 넣어도 모두 만족하기 때문이다.
                    count += j - i
                    // j를 감소시켜 계속 탐색한다.
                    j--
                } else {
                    // 만약 삼각형이 만들어지지 않았을 때,
                    // j를 감소시키면 두 수의 합이 더 적어지기 때문에 i를 증가시켜본다.
                    i++
                }
            }
        }

        // 그렇게 얻은 답을 반환한다.
        return count
    }
}