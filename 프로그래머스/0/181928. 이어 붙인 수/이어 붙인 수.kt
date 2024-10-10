class Solution {
    fun solution(num_list: IntArray): Int {
        
        val oddString = num_list.filter { it % 2 != 0 }.joinToString("")
        val evenString = num_list.filter { it % 2 == 0 }.joinToString("")
        return oddString.toInt() + evenString.toInt()
    }
}
