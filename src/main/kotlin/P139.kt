class P139 {
    // failed to solve
    // referred to discusstion
    // https://leetcode.com/problems/word-break/discuss/43790/Java-implementation-using-DP-in-two-ways
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        // 특정 지점까지의 문자열이 이미 wordDict에 있는지 기록하는 배열
        val find = MutableList(s.length + 1) { false }

        find[0] = true

        for (i in 1..s.length) {
            for (j in 0 until i) {
                // j까지 이미 wordDict에 있고,
                // j부터 i까지의 문자열도 wordDict에 있다면 문제의 조건 만족
                if (find[j] && wordDict.contains(s.substring(j, i))) {
                    find[i] = true
                    break
                }
            }
        }

        return find[s.length]
    }
}