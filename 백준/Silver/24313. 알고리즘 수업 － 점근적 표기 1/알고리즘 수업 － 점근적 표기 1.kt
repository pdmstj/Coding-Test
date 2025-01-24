fun main() {
    val (a1, a0) = readLine()!!.split(" ").map { it.toInt() }
    val c = readLine()!!.toInt()
    val n0 = readLine()!!.toInt()

    val satisfiesCondition = { n: Int -> a1 * n + a0 <= c * n }

    val result = if ((n0..100).all(satisfiesCondition)) 1 else 0

    println(result)
}
