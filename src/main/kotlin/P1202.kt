class P1202 {
    // failed to solve
    // referenced from discussion
    // https://leetcode.com/problems/smallest-string-with-swaps/solution/
    // 접근법
    // 각 index들 : vertex, 각 pair들 : edge로 취급해 graph를 그린다.
    // 그렇게 그려진 graph를 이용해 주어진 String 안의 글자들을 오름차순해준다.

    private val n = 100001
    var visited = BooleanArray(n)
    private val adj: Array<ArrayList<Int>?> = arrayOfNulls(n)

    fun DFS(string: String, vertex: Int, characters: MutableList<Char>, indices: MutableList<Int>) {
        characters.add(string[vertex])
        indices.add(vertex)

        visited[vertex] = true

        for (adjacent in adj[vertex]!!) {
            if (!visited[adjacent]) {
                DFS(string, adjacent, characters, indices)
            }
        }
    }

    fun smallestStringWithSwaps(s: String, pairs: List<List<Int>>): String {
        for (i in s.indices) {
            adj[i] = ArrayList()
        }

        for (edge in pairs) {
            val source = edge[0]
            val destination = edge[1]

            adj[source]?.add(destination)
            adj[destination]?.add(source)
        }

        val answer = arrayOfNulls<Char>(s.length)
        for (vertex in s.indices) {
            if (!visited[vertex]) {
                val characters = ArrayList<Char>()
                val indices = ArrayList<Int>()

                DFS(s, vertex, characters, indices)

                characters.sort()
                indices.sort()

                for (index in characters.indices) {
                    answer[indices[index]] = characters[index]
                }
            }
        }
        return answer.joinToString("")
    }
}