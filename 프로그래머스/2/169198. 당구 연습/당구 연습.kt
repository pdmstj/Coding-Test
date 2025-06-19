import kotlin.math.*

class Solution {
    fun solution(m: Int, n: Int, startX: Int, startY: Int, balls: Array<IntArray>): IntArray {
        val result = mutableListOf<Int>()
        
        for (ball in balls) {
            val (targetX, targetY) = ball
            var minDist = Int.MAX_VALUE

            val candidates = listOf(
                Pair(-targetX, targetY),
                Pair(2 * m - targetX, targetY),
                Pair(targetX, -targetY),
                Pair(targetX, 2 * n - targetY)
            )

            for ((rx, ry) in candidates) {
                val dx = rx - startX
                val dy = ry - startY
                val distSq = dx * dx + dy * dy

                val dx1 = startX - targetX
                val dy1 = startY - targetY
                val dx2 = rx - targetX
                val dy2 = ry - targetY

                if (dx1 * dy2 == dx2 * dy1 &&
                    min(startX, rx) <= targetX && targetX <= max(startX, rx) &&
                    min(startY, ry) <= targetY && targetY <= max(startY, ry)
                ) {
                    continue
                }

                minDist = min(minDist, distSq)
            }

            result.add(minDist)
        }

        return result.toIntArray()
    }
}
