class P3 {
    // failed to solve
    // referenced from discussion
    fun lengthOfLongestSubstring(s: String): Int {
        // 만약 문자열이 비어있다면 부분 문자열 자체가 없기 때문에 그 즉시 0을 반환하고 종료
        if (s.isEmpty()) return 0

        // 문자열 안의 문자를 key, 그들의 위치 값을 value로 두는 hash map 유지
        val map = HashMap<Char, Int>()

        // max는 가장 긴 부분 문자열의 길이 값을 유지
        var max = 0
        // j는 가장 긴 부분 문자열이 시작되는 위치 값을 유지
        var j = 0

        // i는 부분 문자열을 만들기 위해 오른쪽으로 이동하는 포인터 역할
        // 가장 긴 부분 문자열의 끝 값을 의미하기도 함
        for (i in s.indices) {
            // 만약 문자열 i 위치의 문자가 이미 map 안에 있을 경우 == 검사한 부분 문자열 안에 중복되는 문자가 있을 경우
            if (map.containsKey(s[i])) {
                // 중복된 문자가 있던 위치보다 하나 더 오른쪽의 위치 값과 현재 j 값을 비교해, 더 큰 값을 j로 유지
                j = j.coerceAtLeast(map[s[i]]!!.plus(1))
            }
            // 그 문자를 map 안에 유지하고,
            map[s[i]] = i
            // 이 때 i, j의 위치로 만들어지는 부분 문자열의 길이와 max를 비교해, 더 큰 값을 max로 유지
            max = max.coerceAtLeast(i - j + 1)
        }
        // 주의) i와 j는 부분 문자열의 시작과 끝의 위치를 가리키는 포인터 역할이고, 오른쪽으로만 이동

        // 얻은 max 값을 반환.
        return max
    }
}