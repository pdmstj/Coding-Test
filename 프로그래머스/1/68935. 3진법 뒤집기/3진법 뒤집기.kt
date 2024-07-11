class Solution {
    fun solution(n: Int): Int {
        var num = n
        var ternary = StringBuilder()

        // 1. 삼진법으로 변환 (뒤집어서 저장)
        while (num > 0) {
            ternary.append(num % 3)
            num /= 3
        }

        // 2. 삼진법을 뒤집어서 저장한 것을 순서대로 읽으며 다시 십진법으로 변환
        var answer = 0
        var factor = 1

        for (i in ternary.length - 1 downTo 0) {
            answer += (ternary[i] - '0') * factor
            factor *= 3
        }

        return answer
    }
}
