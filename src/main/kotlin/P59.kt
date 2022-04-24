class P59 {
    companion object {
        fun generateMatrix(n: Int): Array<IntArray> {
            val answer = Array(n) { IntArray(n) { 0 } }

            val rowDirection = arrayOf(0, 1, 0, -1)
            val colDirection = arrayOf(1, 0, -1, 0)

            var setDirection = 0

            var curRowIndex = 0
            var curColIndex = 0

            for (i in 1..n * n) {
                answer[curRowIndex][curColIndex] = i

                var nextRowIndex = curRowIndex + rowDirection[setDirection]
                var nextColIndex = curColIndex + colDirection[setDirection]

                if (nextRowIndex == n || nextColIndex == n || nextColIndex == -1 || answer[nextRowIndex][nextColIndex] != 0) {
                    setDirection = (setDirection + 1) % 4

                    nextRowIndex = curRowIndex + rowDirection[setDirection]
                    nextColIndex = curColIndex + colDirection[setDirection]
                }

                curRowIndex = nextRowIndex
                curColIndex = nextColIndex
            }

            return answer
        }
    }
}