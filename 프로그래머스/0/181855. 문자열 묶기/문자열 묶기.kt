class Solution {
    fun solution(strArr: Array<String>): Int {
        val countMap = mutableMapOf<Int, Int>()
        
        for (str in strArr) {
            val len = str.length
            countMap[len] = countMap.getOrDefault(len, 0) + 1
        }
        return countMap.values.maxOrNull() ?: 0
    }
}
