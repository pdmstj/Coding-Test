import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val N = br.readLine().toInt()
    val heap = IntArray(100001)
    var size = 0
    val ans = StringBuilder()

    fun swap(a: Int, b: Int) {
        val tmp = heap[a]
        heap[a] = heap[b]
        heap[b] = tmp
    }

    fun add(a: Int) {
        heap[++size] = a
        var i = size
        while (i > 1) {
            if (heap[i / 2] < heap[i]) swap(i / 2, i) else break
            i /= 2
        }
    }

    fun maxOut() {
        ans.append(heap[1]).append('\n')
        heap[1] = heap[size]
        heap[size--] = 0
        var me = 1
        while (me * 2 <= size) {
            val lchild = me * 2
            val rchild = me * 2 + 1
            if (heap[me] > heap[lchild] && heap[me] > heap[rchild]) break
            else if (heap[lchild] > heap[rchild]) {
                swap(me, lchild)
                me = lchild
            } else {
                swap(me, rchild)
                me = rchild
            }
        }
    }

    repeat(N) {
        val tmp = br.readLine().toInt()
        if (tmp == 0) { // 최댓값 출력
            if (size == 0) ans.append(0).append('\n') else maxOut()
        } else { // 해당 값 배열에 넣기
            add(tmp)
        }
    }

    bw.write(ans.toString())
    br.close()
    bw.flush()
    bw.close()
}
