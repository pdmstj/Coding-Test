fun main() {
    val n = readLine()!!.toInt()
    if (n == 1) {
        println(1)
        return
    }
    if (n == 2) {
        println(2)
        return
    }

    val mod = 15746
    var prev2 = 1
    var prev1 = 2

    for (i in 3..n) {
        val current = (prev1 + prev2) % mod
        prev2 = prev1
        prev1 = current
    }

    println(prev1)
}
