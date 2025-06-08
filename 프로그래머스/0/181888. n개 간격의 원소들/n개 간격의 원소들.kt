class Solution {
    fun solution(num_list: IntArray, n: Int): IntArray {
        val result = mutableListOf<Int>()
        var i = 0
        while (i < num_list.size) {
            result.add(num_list[i])
            i += n
        }
        return result.toIntArray()
    }
}