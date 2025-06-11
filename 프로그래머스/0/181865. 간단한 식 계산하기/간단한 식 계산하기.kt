class Solution {
    fun solution(binomial: String): Int {
        val parts = binomial.split(" ")
        val a = parts[0].toInt()
        val op = parts[1]
        val b = parts[2].toInt()

        return when (op) {
            "+" -> a + b
            "-" -> a - b
            "*" -> a * b
            else -> 0  
        }
    }
}