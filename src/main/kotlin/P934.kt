import java.util.*

class P934 {
    companion object {
        val dirs = arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(0, 1))

        // 처음 만나는 섬의 요소를 dfs를 통해 모두 -1로 바꿔 놓고, queue 안에 그들의 위치 정보를 넣는다.
        fun dfs(curX: Int, curY: Int, queue: Queue<IntArray>, grid: Array<IntArray>) {
            if (curX < 0 || curY < 0 || curX == grid.size || curY == grid[0].size || grid[curX][curY] != 1) return
            queue.offer(intArrayOf(curX, curY))
            grid[curX][curY] = -1
            for (dir in dirs) {
                val nextX = curX + dir[0]
                val nextY = curY + dir[1]

                dfs(nextX, nextY, queue, grid)
            }
        }

        // bfs를 통해 queue 안에 저장된 섬의 요소들로 부터 다른 섬의 요소인 1까지 얼마나 걸리는지 세준다.
        fun bfs(queue: Queue<IntArray>, grid: Array<IntArray>): Int {
            var step = 0
            val dirs = arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(0, 1))

            while (queue.isNotEmpty()) {
                val size = queue.size
                for (i in 0 until size) {
                    val curPoint = queue.poll()
                    for (dir in dirs) {
                        val x = curPoint[0] + dir[0]
                        val y = curPoint[1] + dir[1]
                        if (x >= 0 && y >= 0 && x < grid.size && y < grid[0].size && grid[x][y] != -1) {
                            if (grid[x][y] == 1) return step
                            queue.offer(intArrayOf(x, y))
                            grid[x][y] = -1
                        }
                    }
                }
                step++
            }
            return -1
        }


        fun shortestBridge(grid: Array<IntArray>): Int {
            val queue: Queue<IntArray> = LinkedList()

            outerLoop@ for (i in grid.indices) {
                for (j in 0 until grid[0].size) {
                    if (grid[i][j] == 1) {
                        dfs(i, j, queue, grid)
                        // 바깥 for loop를 break하기 위한 구문
                        break@outerLoop
                    }
                }
            }

            return bfs(queue, grid)
        }
    }
}