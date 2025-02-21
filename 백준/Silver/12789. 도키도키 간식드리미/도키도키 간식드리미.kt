import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val queue: Queue<Int> = LinkedList()
    val stack: Stack<Int> = Stack()
    
    for (i in 0 until n) {
        queue.add(scanner.nextInt())
    }
    
    var expected = 1
    
    while (queue.isNotEmpty() || stack.isNotEmpty()) {
        if (queue.isNotEmpty() && queue.peek() == expected) {
            queue.poll()
            expected++
        } else if (stack.isNotEmpty() && stack.peek() == expected) {
            stack.pop()
            expected++
        } else if (queue.isNotEmpty()) {
            stack.push(queue.poll())
        } else {
            println("Sad")
            return
        }
    }
    println("Nice")
}
