import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)

    // 입력 처리
    val n = scanner.nextInt()
    val m = scanner.nextInt()
    val numbers = IntArray(n + 1)
    
    for (i in 1..n) {
        numbers[i] = scanner.nextInt()
    }

    // 누적 합 배열 생성
    val prefixSum = IntArray(n + 1)
    for (i in 1..n) {
        prefixSum[i] = prefixSum[i - 1] + numbers[i]
    }

    // 구간 합 계산 및 출력
    val result = StringBuilder()
    for (query in 1..m) {
        val i = scanner.nextInt()
        val j = scanner.nextInt()
        result.append(prefixSum[j] - prefixSum[i - 1]).append("\n")
    }

    print(result)
}
