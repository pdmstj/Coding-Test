fun main() {
    while (true) {
        val (a, b, c) = readLine()!!.split(" ").map { it.toInt() }
        if (a == 0 && b == 0 && c == 0) break

        val sides = listOf(a, b, c).sorted()
        val (x, y, z) = sides

        if (x + y <= z) {
            println("Invalid")
        } else if (x == y && y == z) {
            println("Equilateral")
        } else if (x == y || y == z || x == z) {
            println("Isosceles")
        } else {
            println("Scalene")
        }
    }
}