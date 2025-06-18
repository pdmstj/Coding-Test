class Solution {
    fun solution(a: Int, b: Int): Int {
        val op1 = (a.toString() + b.toString()).toInt()
        val op2 = 2 * a * b
        return if (op1 >= op2) op1 else op2
    }
}
