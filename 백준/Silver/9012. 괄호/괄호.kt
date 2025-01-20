fun main() {
    val t = readLine()!!.toInt()
    val results = mutableListOf<String>()

    repeat(t) {
        val ps = readLine()!!
        results.add(if (isValidParenthesisString(ps)) "YES" else "NO")
    }

    results.forEach { println(it) }
}

fun isValidParenthesisString(ps: String): Boolean {
    var balance = 0

    for (char in ps) {
        if (char == '(') {
            balance++
        } else {
            balance--
        }

        if (balance < 0) return false
    }

    return balance == 0
}
