fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }

    val unheard = mutableSetOf<String>()
    val unseenUnheard = mutableListOf<String>()

    repeat(n) {
        unheard.add(readLine()!!)
    }

    repeat(m) {
        val name = readLine()!!
        if (name in unheard) {
            unseenUnheard.add(name)
        }
    }

    unseenUnheard.sort()

    println(unseenUnheard.size)
    unseenUnheard.forEach { println(it) }
}

