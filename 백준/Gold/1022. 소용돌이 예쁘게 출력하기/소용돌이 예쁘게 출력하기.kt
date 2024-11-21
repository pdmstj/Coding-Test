import kotlin.math.abs
import kotlin.math.max
import kotlin.math.pow

fun value(r: Int, c: Int): Int {
    val level = max(abs(r), abs(c))
    if (level == 0) {
        return 1
    }
    var v = ((2 * level - 1).toDouble().pow(2)).toInt()

    when {
        c == level && r != level -> v += -r + level
        r == -level -> v += level * 2 + (-c + level)
        c == -level -> v += 2 * (level * 2) + (r + level)
        r == level -> v += 3 * (level * 2) + (c + level)
    }

    return v
}

fun main() {
    val reader = System.`in`.bufferedReader()
    val (r1, c1, r2, c2) = reader.readLine().split(" ").map { it.toInt() }

    val ans = Array(r2 - r1 + 1) { IntArray(c2 - c1 + 1) }
    var maxV = 0

    for (i in 0..r2 - r1) {
        for (j in 0..c2 - c1) {
            ans[i][j] = value(i + r1, j + c1)
            maxV = max(maxV, ans[i][j])
        }
    }

    var maxDigit = 0
    var tempMaxV = maxV
    while (tempMaxV != 0) {
        maxDigit++
        tempMaxV /= 10
    }

    for (i in 0..r2 - r1) {
        for (j in 0..c2 - c1) {
            print(ans[i][j].toString().padStart(maxDigit, ' '))
            if (j < c2 - c1) print(" ")
        }
        println()
    }
}
