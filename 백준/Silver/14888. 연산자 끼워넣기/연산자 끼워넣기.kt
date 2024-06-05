import java.util.*

var minResult = Int.MAX_VALUE
var maxResult = Int.MIN_VALUE

fun main() {
    val scanner = Scanner(System.`in`)
    
    // 입력 처리
    val N = scanner.nextInt()
    val A = IntArray(N) { scanner.nextInt() }
    val Op = IntArray(4) { scanner.nextInt() }
    
    // 재귀 함수 정의
    fun recur(add: Int, sub: Int, mul: Int, div: Int, index: Int, currentResult: Int) {
        if (index == N) {
            // 최종 결과값 업데이트
            minResult = minOf(minResult, currentResult)
            maxResult = maxOf(maxResult, currentResult)
        } else {
            // 각 연산자에 대해 재귀 호출
            if (add > 0) recur(add - 1, sub, mul, div, index + 1, currentResult + A[index])
            if (sub > 0) recur(add, sub - 1, mul, div, index + 1, currentResult - A[index])
            if (mul > 0) recur(add, sub, mul - 1, div, index + 1, currentResult * A[index])
            if (div > 0) recur(add, sub, mul, div - 1, index + 1, currentResult / A[index])
        }
    }
    
    // 초기값으로 재귀 함수 호출
    recur(Op[0], Op[1], Op[2], Op[3], 1, A[0])
    
    // 결과 출력
    println(maxResult)
    println(minResult)
}
