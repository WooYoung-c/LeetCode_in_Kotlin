class P1054 {
    data class Node(var num: Int, var count: Int) : Comparable<Node> {
        override fun compareTo(other: Node): Int {
            return when {
                this.count < other.count -> 1
                this.count > other.count -> -1
                else -> 0
            }
        }
    }

    companion object {
        fun rearrangeBarcodes(barcodes: IntArray): IntArray {
            val ans = IntArray(barcodes.size)
            val forCount = IntArray(10001)
            val arrayList = ArrayList<Node>()

            for (i in barcodes.indices) {
                forCount[barcodes[i]]++
            }

            for (i in forCount.indices) {
                if (forCount[i] != 0) {
                    arrayList.add(Node(i, forCount[i]))
                }
            }

            var ansIdx = 0

            while (ansIdx != ans.size) {
                for (i in arrayList.indices) {
                    val curNode = arrayList[i]

                    if (curNode.count == 0) continue

                    ans[ansIdx++] = curNode.num
                    curNode.count--
                }
            }

            return ans
        }
    }
}