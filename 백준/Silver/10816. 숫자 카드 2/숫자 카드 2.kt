import java.util.*

fun main() {
    val input = Scanner(System.`in`)
    
    val N = input.nextInt()
    val cards = mutableListOf<Int>()
    for (i in 0 until N) {
        cards.add(input.nextInt())
    }
    
    val M = input.nextInt()
    val queries = mutableListOf<Int>()
    for (i in 0 until M) {
        queries.add(input.nextInt())
    }
    
    val cardCount = cards.groupingBy { it }.eachCount()
    
    val result = queries.map { cardCount[it] ?: 0 }
    println(result.joinToString(" "))
}
