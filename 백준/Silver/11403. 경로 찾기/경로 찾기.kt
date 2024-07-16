import java.util.*

const val MAX = 100 + 1
var N = 0
val graph = Array(MAX) { mutableListOf<Int>() }
var visit = IntArray(MAX)

fun reset() {
    for (i in 0 until N) {
        visit[i] = 0
    }
}

fun dfs(node: Int) {
    val s = Stack<Int>()
    s.push(node)

    while (s.isNotEmpty()) {
        val cur = s.pop()

        for (i in graph[cur].indices) {
            if (visit[graph[cur][i]] == 1) continue

            visit[graph[cur][i]] = 1
            s.push(graph[cur][i])
        }
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    N = scanner.nextInt()
    for (i in 0 until N) {
        for (j in 0 until N) {
            val path = scanner.nextInt()
            if (path == 1) {
                graph[i].add(j)
            }
        }
    }

    for (i in 0 until N) {
        reset()
        dfs(i)
        for (j in 0 until N) {
            print("${visit[j]} ")
        }
        println()
    }
}