import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.IOException
import java.util.LinkedList
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val deque = LinkedList<Int>()
    var count = 0  // 2, 3번 연산 횟수 누적 합 변수

    var st = StringTokenizer(br.readLine(), " ")
    val N = st.nextToken().toInt()  // 큐의 크기(1 ~ N)
    val M = st.nextToken().toInt()  // 뽑으려는 숫자의 개수

    // 1부터 N까지 덱에 담아둔다.
    for (i in 1..N) {
        deque.offer(i)
    }

    val seq = IntArray(M)  // 뽑고자 하는 수를 담은 배열

    st = StringTokenizer(br.readLine(), " ")
    for (i in 0 until M) {
        seq[i] = st.nextToken().toInt()
    }

    for (i in 0 until M) {
        // 덱에서 뽑고자 하는 숫자의 위치(index) 찾기
        val targetIdx = deque.indexOf(seq[i])
        val halfIdx: Int

        // 만약 현재 덱의 원소가 짝수 개라면 중간 지점을 현재 덱의 절반 크기에서 -1 감소시킨다.
        // {1, 2, 3, 4} 일 때, 2를 중간지점으로 하면 인덱스는 1이기 때문
        if (deque.size % 2 == 0) {
            halfIdx = deque.size / 2 - 1
        } else {
            halfIdx = deque.size / 2
        }

        // 중간 지점 또는 중간 지점보다 원소의 위치가 앞에 있을 경우
        if (targetIdx <= halfIdx) {
            // idx 보다 앞에 있는 원소들을 모두 뒤로 보낸다. (2번 연산)
            for (j in 0 until targetIdx) {
                val temp = deque.pollFirst()
                deque.offerLast(temp)
                count++
            }
        } else {  // 중간 지점보다 원소의 위치가 뒤에 있는 경우
            // idx를 포함한 뒤에 있는 원소들을 모두 앞으로 보낸다. (3번 연산)
            for (j in 0 until deque.size - targetIdx) {
                val temp = deque.pollLast()
                deque.offerFirst(temp)
                count++
            }
        }
        deque.pollFirst()  // 연산이 끝나면 맨 앞 원소를 삭제
    }

    println(count)
}