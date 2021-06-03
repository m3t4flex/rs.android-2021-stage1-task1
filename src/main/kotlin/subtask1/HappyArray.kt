package subtask1


class HappyArray {

    fun convertToHappy(sadArray: IntArray): IntArray {
        val happyArray: MutableList<Int> = sadArray.toMutableList()
        var i: Int = 1
        while (i <= happyArray.size - 2) {
            if (happyArray[i] < happyArray[i - 1] + happyArray[i + 1]) {
                i += 1
            }
            else {
                happyArray.removeAt(i)
                if (i > 1) {
                    i -= 1
                }
            }
        }
        return happyArray.toIntArray()
    }

}
