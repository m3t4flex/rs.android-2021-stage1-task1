package subtask2

class BillCounter {

    fun calculateFairlySplit(bill: IntArray, k: Int, b: Int): String {
        var overallCheck: Int = 0
        for (item in bill) {
            overallCheck += item
        }
        val equalSplit: Int = (overallCheck - bill[k]) / 2
        return if (equalSplit == b) {
            "Bon Appetit"
        } else {
            (b - equalSplit).toString()
        }

    }
}
