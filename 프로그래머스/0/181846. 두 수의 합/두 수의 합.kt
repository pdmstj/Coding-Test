import java.math.BigInteger

class Solution {
    fun solution(a: String, b: String): String {
        val bigA = BigInteger(a)
        val bigB = BigInteger(b)
        return (bigA + bigB).toString()
    }
}
