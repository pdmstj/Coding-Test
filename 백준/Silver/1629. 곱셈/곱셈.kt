fun main() {
    val (a, b, c) = readLine()!!.split(" ").map { it.toLong() }
    println(pow(a, b, c))
}

fun pow(a: Long, b: Long, c: Long): Long {
    if (b == 1L) return a % c

    val half = pow(a, b / 2, c)
    val result = (half * half) % c

    return if (b % 2 == 0L) {
        result
    } else {
        (result * a) % c
    }
}
