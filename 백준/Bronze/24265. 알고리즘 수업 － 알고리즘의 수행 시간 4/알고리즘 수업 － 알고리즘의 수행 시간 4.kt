fun main() {
    val n = readLine()!!.toInt()

    // 코드1의 수행 횟수 계산: n * (n - 1) / 2
    val operationCount = n.toLong() * (n - 1) / 2

    // 시간 복잡도의 최고차항 차수는 2 (n^2)
    val highestOrder = 2

    println(operationCount)
    println(highestOrder)
}