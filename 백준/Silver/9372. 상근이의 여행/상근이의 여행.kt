import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import java.util.PriorityQueue

data class Edge(val weight: Int, val from: Int, val to: Int)

fun find(parent: IntArray, x: Int): Int {
    if (parent[x] != x) parent[x] = find(parent, parent[x])
    return parent[x]
}

fun union(parent: IntArray, rank: IntArray, x: Int, y: Int): Boolean {
    val rootX = find(parent, x)
    val rootY = find(parent, y)
    
    if (rootX != rootY) {
        if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX
        } else if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY
        } else {
            parent[rootY] = rootX
            rank[rootX]++
        }
        return true
    }
    return false
}

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val testCases = reader.readLine().toInt()
    
    val results = mutableListOf<Int>()
    
    repeat(testCases) {
        val (n, m) = reader.readLine().split(" ").map { it.toInt() }
        val parent = IntArray(n + 1) { it }
        val rank = IntArray(n + 1)
        val edges = mutableListOf<Edge>()
        
        repeat(m) {
            val st = StringTokenizer(reader.readLine())
            val a = st.nextToken().toInt()
            val b = st.nextToken().toInt()
            edges.add(Edge(1, a, b))
        }
        
        edges.sortBy { it.weight }
        
        var totalWeight = 0
        for (edge in edges) {
            if (union(parent, rank, edge.from, edge.to)) {
                totalWeight++
            }
        }
        
        results.add(totalWeight)
    }
    
    results.forEach { println(it) }
}
