fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val matrix = Array(n) { readLine()!! }
    var maxSize = 1

    for (i in 0 until n) {
        for (j in 0 until m) {
           
            for (size in 1..minOf(n - i, m - j)) {
                val endRow = i + size - 1
                val endCol = j + size - 1

                if (endRow < n && endCol < m) {
                    val topLeft = matrix[i][j]
                    val topRight = matrix[i][endCol]
                    val bottomLeft = matrix[endRow][j]
                    val bottomRight = matrix[endRow][endCol]

                    if (topLeft == topRight && topLeft == bottomLeft && topLeft == bottomRight) {
                        maxSize = maxOf(maxSize, size * size)
                    }
                }
            }
        }
    }

    println(maxSize)
}
