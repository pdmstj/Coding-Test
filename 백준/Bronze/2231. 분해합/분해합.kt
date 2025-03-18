fun main() {
    // 입력 받기
    val N = readLine()!!.toInt()

    // 생성자를 찾을 수 없는 경우 0을 출력하기 위한 변수
    var result = 0

    // M을 N에서 각 자리수의 합만큼 빼고 시작
    for (i in (N - 54)..(N - 1)) {
        val sum = i + i.toString().sumBy { it - '0' }  // i의 분해합 계산
        if (sum == N) {
            result = i
            break
        }
    }

    // 결과 출력
    println(result)
}
