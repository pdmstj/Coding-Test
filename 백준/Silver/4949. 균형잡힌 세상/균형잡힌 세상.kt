import java.util.Stack

fun main() {
    val input = generateSequence(::readLine) 
    for (line in input) {
        if (line == ".") break 
        println(if (isBalanced(line)) "yes" else "no")
    }
}

fun isBalanced(line: String): Boolean {
    val stack = Stack<Char>()

    for (char in line) {
        when (char) {
            '(', '[' -> stack.push(char) 
            ')' -> {
                if (stack.isEmpty() || stack.pop() != '(') return false 
            }
            ']' -> {
                if (stack.isEmpty() || stack.pop() != '[') return false
            }
        }
    }

    return stack.isEmpty() 
}
