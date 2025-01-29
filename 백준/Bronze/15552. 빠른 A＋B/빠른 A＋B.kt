import java.io.*

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val t = reader.readLine().toInt()  // 테스트 케이스 개수

    repeat(t) {
        val (a, b) = reader.readLine().split(" ").map { it.toInt() }
        writer.write("${a + b}\n")  // 결과를 저장
    }

    writer.flush()  // 한 번에 출력
}
