class P93 {
    // referred to discussion
    private val answer: ArrayList<String> = ArrayList()

    fun restoreIpAddresses(s: String): List<String> {
        checkPointCanBeLocated(s, "", 0)
        return answer
    }

    private fun checkPointCanBeLocated(s: String, restored: String, pointCount: Int) {

        if (s.isEmpty() || pointCount == 4) {
            if (s.isEmpty() && pointCount == 4) answer.add(restored.substring(1))
            return
        }

        for (i in 1..3) {
            if (i > s.length) break

            val ip = s.substring(0, i)

            if (checkIfIpIsValid(ip)) {
                checkPointCanBeLocated(s.substring(i), "$restored.$ip", pointCount + 1)
                if (checkIfIPIsZero(ip)) break
            }
        }
    }

    private fun checkIfIPIsZero(ip: String) = ip == "0"

    private fun checkIfIpIsValid(ip: String) = when {
        ip.toInt() in 0..255 -> true
        else -> false
    }
}