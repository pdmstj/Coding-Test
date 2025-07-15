import java.util.*

fun main() {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    val nStr = n.toString()
    val len = nStr.length

    if (len == 1 || (len == 2 && nStr[1] == '0')) {
        println(-1)
        return
    }

    var queue: Queue<String> = LinkedList()
    queue.add(nStr)

    repeat(k) {
        val nextQueue: Queue<String> = LinkedList()
        val visited = mutableSetOf<String>()
        
        while (queue.isNotEmpty()) {
            val cur = queue.poll()
            val curArr = cur.toCharArray()

            for (i in 0 until len - 1) {
                for (j in i + 1 until len) {
                    // swap
                    if (i == 0 && curArr[j] == '0') continue  // 앞에 0 오면 안됨

                    val temp = curArr[i]
                    curArr[i] = curArr[j]
                    curArr[j] = temp

                    val swapped = String(curArr)
                    if (swapped !in visited) {
                        visited.add(swapped)
                        nextQueue.add(swapped)
                    }

                    // 다시 원래대로 돌려놓기
                    curArr[j] = curArr[i]
                    curArr[i] = temp
                }
            }
        }

        queue = nextQueue
    }

    if (queue.isEmpty()) {
        println(-1)
    } else {
        println(queue.map { it.toInt() }.max())
    }
}