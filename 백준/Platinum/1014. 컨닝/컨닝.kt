import java.util.*

val DP = Array(10) { IntArray(1 shl 10) { -1 } }
var N = 0
var M = 0
lateinit var Board: Array<CharArray>

fun adjecent(idx: Int, bit: Int, standBit: Int): Boolean {
    var cnt = 0
    var flag = false

    for (i in 0 until M) {
        if (bit and (1 shl i) != 0) {
            if (Board[idx][M - 1 - i] == 'x') 
                return false

            if (standBit and (1 shl (i + 1)) != 0 || standBit and (1 shl (i - 1)) != 0)
                return false

            if (!flag)
                flag = !flag
            else {
                if (cnt == 0) return false 
                cnt = 0
            }
        } else {
            if (flag) cnt++
        }
    }

    return true
} 

fun solve(idx: Int, bit: Int): Int {
    if (idx >= N) return 0

    var ret = DP[idx][bit]

    if (ret != -1) return ret

    ret = 0

    for (i in 0 until (1 shl M)) {
        if (!adjecent(idx, i, bit))
            continue
        ret = maxOf(ret, solve(idx + 1, i) + Integer.bitCount(i))
    }

    DP[idx][bit] = ret
    return ret
}

fun main() {
    val scanner = Scanner(System.`in`)
    val T = scanner.nextInt()

    repeat(T) {
        N = scanner.nextInt()
        M = scanner.nextInt()
        Board = Array(N) { CharArray(M) }

        for (i in 0 until N) {
            val row = scanner.next()
            for (j in 0 until M) {
                Board[i][j] = row[j]
            }
        }

        for (i in 0 until 10) {
            for (j in 0 until (1 shl 10)) {
                DP[i][j] = -1
            }
        }

        println(solve(0, 0))
    } 
}