class P11 {
    // failed to solve
    // referenced from discussion
    // https://leetcode.com/problems/container-with-most-water/discuss/200246/Proof-by-formula
    fun maxArea(height: IntArray): Int {
        // 가장 큰 넓이 값을 담을 변수. 이를 반환.
        var volume = 0
        // 배열에 저장된 높이 값을 가리키는 왼쪽 포인터
        var i = 0
        // 배열에 저장된 높이 값을 가리키는 오른쪽 포인터
        var j = height.size - 1

        while (i < j) {
            // 부피 = (i - j) * (height[i], height[j] 중 최소값)
            // 여기서 (i - j)는 가로변의 길이가 됨
            volume = volume.coerceAtLeast((j - i) * height[i].coerceAtMost(height[j]))
            // height[i] < height[j] 일 경우, i를 오른쪽으로 움직이는 경우만 생각함
            // height[i] > height[j] 일 경우, j를 왼쪽으로 움직이는 경우만 생각함
            if (height[i] < height[j]) i++
            else j--
            // height[i] < height[j] 일 경우 j를 왼쪽으로 움직여서 고려할 때의 부피 값은 그 이전 부피 값보다 무조건 작기 때문
            // 이 때의 부피 V = (i - j) * height[i]이고 (i, j - 1)일 때를 생각해보자
            // height[i] < height[j - 1] 일 경우 V' = (i - j - 1) * height[i] 이므로 V > V'
            // height[i] > height[j - 1] 일 경우 V' = (i - j - 1) * height[j - 1] 이므로 V > V'
            // 이는 height[i] > height[j] 일 경우 i를 오른쪽으로 움직일 때 부피 값이 그 이전 부피 값보다 항상 작은 것과 동일
        }

        return volume
    }
}