class P765 {
    // referred from here
    // https://leetcode.com/problems/couples-holding-hands/discuss/113362/JavaC%2B%2B-O(N)-solution-using-cyclic-swapping
    // keep reading it until understanding
    fun minSwapsCouples(row: IntArray): Int {
        var res = 0
        val N = row.size
        val ptn = IntArray(N)
        val pos = IntArray(N)
        for (i in 0 until N) {
            ptn[i] = if (i % 2 == 0) i + 1 else i - 1
            pos[row[i]] = i
        }
        for (i in 0 until N) {
            var j = ptn[pos[ptn[row[i]]]]
            while (i != j) {
                swap(row, i, j)
                swap(pos, row[i], row[j])
                res++
                j = ptn[pos[ptn[row[i]]]]
            }
        }
        return res
    }

    private fun swap(arr: IntArray, i: Int, j: Int) {
        val t = arr[i]
        arr[i] = arr[j]
        arr[j] = t
    }
}