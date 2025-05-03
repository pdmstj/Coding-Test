class Solution {
    fun solution(diffs: IntArray, times: IntArray, limit: Long): Int {
        var left = 1
        var right = 100_000 
        var answer = right

        fun isPossible(level: Int): Boolean {
            var totalTime = 0L
            for (i in diffs.indices) {
                val diff = diffs[i]
                val timeCur = times[i]
                val timePrev = if (i == 0) 0 else times[i - 1]

                if (diff <= level) {
                    totalTime += timeCur
                } else {
                    val fails = diff - level
                    totalTime += (timeCur + timePrev).toLong() * fails + timeCur
                }

                if (totalTime > limit) return false
            }
            return true
        }

        while (left <= right) {
            val mid = (left + right) / 2
            if (isPossible(mid)) {
                answer = mid
                right = mid - 1
            } else {
                left = mid + 1
            }
        }

        return answer
    }
}