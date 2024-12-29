class Solution {
    fun solution(wallpaper: Array<String>): IntArray {
        var minRow = Int.MAX_VALUE
        var minCol = Int.MAX_VALUE
        var maxRow = Int.MIN_VALUE
        var maxCol = Int.MIN_VALUE

        for (i in wallpaper.indices) {
            for (j in wallpaper[i].indices) {
                if (wallpaper[i][j] == '#') {
                   
                    minRow = minOf(minRow, i)
                    minCol = minOf(minCol, j)
                    maxRow = maxOf(maxRow, i)
                    maxCol = maxOf(maxCol, j)
                }
            }
        }

        return intArrayOf(minRow, minCol, maxRow + 1, maxCol + 1)
    }
}
