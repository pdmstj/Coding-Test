class Solution {
    fun solution(numbers: IntArray): Int {
        numbers.sort()
        val max1 = numbers[numbers.size - 1] * numbers[numbers.size - 2]
        
        val max2 = numbers[0] * numbers[1]
        
        return maxOf(max1, max2)
    }
}
