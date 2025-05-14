import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()

    repeat(n) {
        val infMonth = scanner.nextInt()
        val infYear = scanner.nextInt()
        val strikeMonth = scanner.nextInt()
        val strikeYear = scanner.nextInt()

        val eit = calculateEIT(infMonth, infYear, strikeMonth, strikeYear)
        println(String.format("%.4f", eit))
    }
}

fun calculateEIT(infMonth: Int, infYear: Int, strikeMonth: Int, strikeYear: Int): Double {
    var eit = 0.0

    if (infYear == strikeYear) {
        val months = strikeMonth - infMonth
        if (months > 0) {
            val partialEIT = (0.5 / (13 - infMonth)) * months
            eit += partialEIT
        }
        return eit
    } else {
        eit += 0.5

        for (year in (infYear + 1) until strikeYear) {
            eit += 1.0
        }

        val months = strikeMonth - 1
        eit += months * (1.0 / 12.0)
    }

    return eit
}