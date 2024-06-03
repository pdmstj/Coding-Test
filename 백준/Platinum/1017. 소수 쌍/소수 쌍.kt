import java.util.*

var firstEqual = mutableListOf<Int>()
var firstDifferent = mutableListOf<Int>()
lateinit var match: IntArray
lateinit var visited: IntArray
var adj = Array(25) { mutableListOf<Int>() }

fun DFS(i: Int, cnt: Int): Boolean {
    if (visited[i] == cnt) return false

    visited[i] = cnt

    for (next in adj[i])
        if (match[next] == -1 || DFS(match[next], cnt)) {
            match[next] = i
            return true
        }

    return false
}

fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    var first = 0

    for (i in 0 until n) {
        val k = scanner.nextInt()

        if (i == 0) first = k

        if (k % 2 == first % 2) firstEqual.add(k) 
        else firstDifferent.add(k)
    }

    if (firstEqual.size != firstDifferent.size) {
        println(-1)
        return
    }

    val checkPrime = BooleanArray(1001) { true }

    for (i in 3 until 2000 step 2) {
        if (!checkPrime[i / 2]) continue

        for (j in i * i until 2001 step i * 2)
            checkPrime[j / 2] = false
    }

    for (i in firstEqual.indices) {
        for (j in firstDifferent.indices) {
            if (checkPrime[(firstEqual[i] + firstDifferent[j]) / 2]) {
                adj[i].add(j)
            }
        }
    }

    val result = mutableListOf<Int>()

    for (i in adj[0]) {
        var maxMatch = 1
        var cnt = 0
        visited = IntArray(25)
        match = IntArray(25) { -1 }
        match[i] = 0

        for (j in firstEqual.indices) {
            visited[0] = ++cnt
            if (DFS(j, cnt)) maxMatch++
        }

        if (maxMatch == firstDifferent.size) result.add(firstDifferent[i])
    }

    if (result.isEmpty()) println(-1)
    else {
        result.sort()
        println(result.joinToString(" "))
    }
}
