class P93 {
    companion object {
        fun restoreIpAddresses(s: String): List<String> {
            val answer = ArrayList<String>()
            return answer
        }

        fun backTracking(s: String, ip: String, checked: Int, answer: ArrayList<String>) {
            if (checked == 4) {
                answer.add(ip)
                return
            }

            for (checkToIndex in 0..2) {
                val checkString = s.substring(0, checkToIndex)
                if (checkString == "0") {
                    val nextIp = ip.apply {
                        if (this.isEmpty()) this.plus(checkString)
                        else this.plus(".$checkString")
                    }
                    backTracking(s.substring(checkToIndex + 1, s.length - 1), nextIp, checked + 1, answer)
                    return
                } else {
                    if (checkString.toInt() in 0..255) {
                        val nextIp = ip.apply {
                            if (this.isEmpty()) this.plus(checkString)
                            else this.plus(".$checkString")
                        }
                        backTracking(s.substring(checkToIndex + 1, s.length - 1), nextIp, checked + 1, answer)
                    }
                }
            }
        }
    }
}