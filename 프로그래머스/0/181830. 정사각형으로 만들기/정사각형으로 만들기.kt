class Solution {
    fun solution(arr: Array<IntArray>): Array<IntArray> {
        val rowCount = arr.size
        val colCount = arr[0].size

        return if (rowCount > colCount) {
            Array(rowCount) { i ->
                arr[i] + IntArray(rowCount - colCount) { 0 }
            }
        } else if (rowCount < colCount) {
            val newArr = arr.toMutableList()
            repeat(colCount - rowCount) {
                newArr.add(IntArray(colCount) { 0 })
            }
            newArr.toTypedArray()
        } else {
            arr
        }
    }
}
