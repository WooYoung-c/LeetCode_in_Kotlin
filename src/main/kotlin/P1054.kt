import java.lang.Integer.max

class P1054 {
    // failed to solve
    // referenced from discussion
    companion object {
        fun rearrangeBarcodes(barcodes: IntArray): IntArray {
            val count = IntArray(10001)
            var maxCnt = 0
            var maxBarcode = 0
            var pos = 0

            for (barcode in barcodes) {
                maxCnt = max(maxCnt, ++count[barcode])
                maxBarcode = if (maxCnt == count[barcode]) barcode else maxBarcode
            }

            for (barcode in 0..10000) {
                val curBarcode = if (barcode == 0) maxBarcode else barcode

                while (count[curBarcode]-- > 0) {
                    barcodes[pos] = curBarcode
                    pos = if (pos + 2 < barcodes.size) pos + 2 else 1
                }
            }

            return barcodes
        }
    }
}