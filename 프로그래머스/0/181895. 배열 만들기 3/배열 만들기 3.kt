class Solution {
    fun solution(arr: IntArray, intervals: Array<IntArray>): IntArray {
        val (a1, b1) = intervals[0]
        val (a2, b2) = intervals[1]
        val part1 = arr.copyOfRange(a1, b1 + 1)
        val part2 = arr.copyOfRange(a2, b2 + 1)
        
        return part1 + part2
    }
}
