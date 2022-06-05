class P1366 {
    // failed to solve
    // referenced from discussion
    fun rankTeams(votes: Array<String>): String {
        val map: HashMap<Char, IntArray> = HashMap()
        val l = votes[0].length

        for (vote in votes) {
            for (i in 0 until l) {
                val c = vote[i]
                map.putIfAbsent(c, IntArray(l))
                map[c]!![i]++
            }
        }

        val list: List<Char> = ArrayList(map.keys)
        list.sortedWith { a: Char, b: Char ->
            for (i in 0 until l) {
                if (map[a]!![i] != map[b]!![i]) {
                    return@sortedWith map[b]!![i] - map[a]!![i]
                }
            }
            a - b
        }

        val sb = StringBuilder()

        for (c in list) {
            sb.append(c)
        }

        return sb.toString()
    }
}