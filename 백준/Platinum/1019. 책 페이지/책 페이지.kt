import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val cnt = IntArray(10) // 0부터 9까지 카운트하는 배열

    fun cal(n: Int, p: Int) {
        var num = n
        while (num > 0) {
            cnt[num % 10] += Math.pow(10.0, p.toDouble()).toInt()  // 자리수가 바뀔때마다 더해지는 값이 10의 제곱씩 곱해진다.
            num /= 10
        }
    }

    fun solve(A: Int, B: Int, p: Int) {
        var a = A
        var b = B

        while (a % 10 != 0 && a <= b) {  // A의 1의자리를 0으로 맞춘다.
            cal(a, p)
            a += 1
        }

        if (a > b) return

        while (b % 10 != 9 && b >= a) { // B의 1의자리를 9로 맞춘다.
            cal(b, p)
            b -= 1
        }

        for (i in 0..9) {
            cnt[i] += (b / 10 - a / 10 + 1) * Math.pow(10.0, p.toDouble()).toInt()  // 반복되는 만큼 모든자리에 더해준다
        }

        solve(a / 10, b / 10, p + 1)  // 재귀를 실행. if A>B가 참이되면 종료
    }

    solve(1, n, 0)
    println(cnt.joinToString(" "))
}