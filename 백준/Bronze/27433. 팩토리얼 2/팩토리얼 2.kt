fun main() {
    val n = readLine()!!.toInt()
    println(factorial(n))
}

fun factorial(n: Int): Long {
    var result = 1L
    for (i in 2..n) {
        result *= i
    }
    return result
}
