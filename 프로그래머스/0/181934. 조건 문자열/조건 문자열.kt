class Solution {
    fun solution(ineq: String, eq: String, n: Int, m: Int): Int {
        return when (ineq + eq) {
            "<=" -> if (n <= m) 1 else 0
            ">=" -> if (n >= m) 1 else 0
            "<!" -> if (n < m) 1 else 0
            ">!" -> if (n > m) 1 else 0
            else -> 0  
        }
    }
}
