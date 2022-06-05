import java.util.*


class P787 {
    // failed to solve
    // referenced from discussion
    // https://leetcode.com/problems/cheapest-flights-within-k-stops/discuss/686774/SUGGESTION-FOR-BEGINNERS-BFS-or-DIJKSHTRA-or-DP
    // 접근법
    // 다익스트라 알고리즘 활용
    fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, k: Int): Int {
        val adjMatrix = Array(n) { IntArray(n) }

        for (flight in flights) {
            adjMatrix[flight[0]][flight[1]] = flight[2]
        }

        val distances = IntArray(n)
        val currentStops = IntArray(n)

        Arrays.fill(distances, Integer.MAX_VALUE)
        Arrays.fill(currentStops, Integer.MAX_VALUE)

        distances[src] = 0
        currentStops[src] = 0

        val minHeap = PriorityQueue { a: IntArray, b: IntArray ->
            a[1] - b[1]
        }
        minHeap.offer(intArrayOf(src, 0, 0))

        while (minHeap.isNotEmpty()) {
            val info = minHeap.poll()
            val node = info[0]
            val stops = info[2]
            val cost = info[1]

            if (node == dst) return cost

            if (stops == k + 1) continue

            for (nei in 0 until n) {
                if (adjMatrix[node][nei] > 0) {
                    val dV = distances[nei]
                    val wUV = adjMatrix[node][nei]

                    if (cost + wUV < dV || stops < currentStops[nei]) {
                        minHeap.offer(intArrayOf(nei, cost + wUV, stops + 1))
                        distances[nei] = cost + wUV
                        currentStops[nei] = stops
                    }
                }
            }
        }

        return if (distances[dst] == Integer.MAX_VALUE) -1 else distances[dst]
    }
}