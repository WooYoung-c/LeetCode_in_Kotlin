class P131 {
    fun partition(s: String): List<List<String>> {
        val answer: ArrayList<ArrayList<String>> = ArrayList()
        findPalindrome(s, ArrayList(), answer)
        return answer
    }

    private fun findPalindrome(s: String, palindromes: ArrayList<String>, answer: ArrayList<ArrayList<String>>) {
        if (s.isEmpty()) {
            answer.add(ArrayList(palindromes))
            return
        }

        for (i in 1..s.length) {
            val candidate = s.substring(0, i)

            if (checkIfItIsPalindrome(candidate)) {
                palindromes.add(candidate)
                findPalindrome(s.substring(i), palindromes, answer)
                // referred to solution - backTrack one element just put in!
                palindromes.removeAt(palindromes.size - 1)
            }
        }
    }

    private fun checkIfItIsPalindrome(candidate: String) = candidate.reversed() == candidate
}