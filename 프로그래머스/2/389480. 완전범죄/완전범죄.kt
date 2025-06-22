class Solution {
    var minTrace = Int.MAX_VALUE
    lateinit var memo: Array<IntArray>

    fun solution(info: Array<IntArray>, n: Int, m: Int): Int {
        val size = info.size
        memo = Array(size + 1) { IntArray(m) { Int.MAX_VALUE } }
        dfs(0, 0, 0, info, n, m)
        return if (minTrace == Int.MAX_VALUE) -1 else minTrace
    }

    fun dfs(index: Int, traceA: Int, traceB: Int, info: Array<IntArray>, n: Int, m: Int) {
        if (traceA >= n || traceB >= m) return
        if (index == info.size) {
            minTrace = minOf(minTrace, traceA)
            return
        }

        // memoization: 같은 index와 traceB에 대해 traceA가 더 클 경우 가지치기
        if (memo[index][traceB] <= traceA) return
        memo[index][traceB] = traceA

        // A 도둑이 훔치는 경우
        dfs(index + 1, traceA + info[index][0], traceB, info, n, m)

        // B 도둑이 훔치는 경우
        dfs(index + 1, traceA, traceB + info[index][1], info, n, m)
    }
}
