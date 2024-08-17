fun main() = readln().run {
    println(r.zip(r.reversed()).sumOf { it.first * it.second })
}
val r get() = readln().split(" ").map { it.toInt() }.sorted()