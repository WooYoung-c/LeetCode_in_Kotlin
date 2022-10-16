class P1443 {
    // https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/discuss/623673/Concise-explanation-with-a-Picture-for-Visualization
    var ans = 0
    fun minTime(n: Int, edges: Array<IntArray>, hasApple: MutableList<Boolean>): Int {
        // 주어진 edges 정보에 따라 tree를 생성
        val tree: MutableMap<Int, MutableList<Int>> = HashMap()
        for (edge in edges) {
            tree.putIfAbsent(edge[0], ArrayList())
            tree.putIfAbsent(edge[1], ArrayList())
            tree[edge[0]]!!.add(edge[1])
            tree[edge[1]]!!.add(edge[0])
        }
        // 그 tree 정보를 바탕으로 dfs하여 필요한 시간을 잰다
        dfs(0, tree, hasApple, HashSet())
        // 답을 반환
        return ans
    }

    private fun dfs(
        node: Int,
        tree: Map<Int, MutableList<Int>>,
        hasApple: MutableList<Boolean>,
        seen: MutableSet<Int>
    ): Boolean {
        // 이미 방문한 노드라면 함수를 종료한다.
        if (seen.contains(node)) return false
        // 노드를 방문했다는 표시를 한다.
        seen.add(node)
        // 방문한 노드의 자식 노드들을 모두 dfs로 방문한다.
        for (next in tree[node]!!) {
            if (dfs(next, tree, hasApple, seen)) {
                // 자식 노드에게 사과가 있다면 그 부모인 노드도 사과가 있다고 여긴다.
                hasApple[node] = true
                // 사과가 있는 노드에게 가는 시간 1초, 다시 돌아가는 시간 1초 합해 2초를 올린다.
                // => 한번의 dfs로 반복되는 시간을 잴 수 있다.
                ans += 2
            }
        }
        // dfs가 끝났다면 방문했다는 표시를 제거한다.
        seen.remove(node)
        // 사과가 있다면 계속 dfs를 실행해야 하기 때문에,
        // dfs의 결과값으로 사과의 유무를 반환한다.
        return hasApple[node]
    }
}