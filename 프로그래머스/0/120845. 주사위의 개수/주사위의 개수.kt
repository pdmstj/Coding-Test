class Solution {
    fun solution(box: IntArray, n: Int): Int {
        val widthCount = box[0] / n
        val lengthCount = box[1] / n
        val heightCount = box[2] / n
        
        return widthCount * lengthCount * heightCount
    }
}
