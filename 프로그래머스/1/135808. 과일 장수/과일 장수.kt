class Solution {
    fun solution(k: Int, m: Int, score: IntArray): Int {
        val sortedScores = score.sortedDescending()
        
        var maxProfit = 0
        for (i in sortedScores.indices step m) {
        
            if (i + m > sortedScores.size) break
            
            val box = sortedScores.slice(i until i + m)
            val boxMinScore = box.last() 
            maxProfit += boxMinScore * m
        }
        
        return maxProfit
    }
}
