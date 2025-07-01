class Solution {
    fun solution(arr: IntArray, n: Int): IntArray {
        val isOddLength = arr.size % 2 == 1

        return arr.mapIndexed { index, value ->
            if (isOddLength && index % 2 == 0) {
                value + n
            } else if (!isOddLength && index % 2 == 1) {
                value + n
            } else {
                value
            }
        }.toIntArray()
    }
}