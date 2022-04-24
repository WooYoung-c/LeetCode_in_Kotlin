class P738 {
    companion object {
        // failed to solve
        // referenced from discussion
        fun monotoneIncreasingDigits(n: Int): Int {
            val chars = n.toString().toCharArray()
            var marker = chars.size
            for (i in chars.size - 1 downTo 1) {
                if (chars[i] < chars[i - 1]) {
                    chars[i - 1] = chars[i - 1] - 1
                    marker = i
                }
            }
            for (i in marker until chars.size) chars[i] = '9'
            return String(chars).toInt()
        }
    }
}