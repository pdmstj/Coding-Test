fun findMinSteps(N: Int): Int {
    if (N == 1) return 1  

    var layer = 1 
    var maxNumber = 1  

    while (maxNumber < N) {
        maxNumber += 6 * layer  
        layer++ 
    }

    return layer
}

fun main() {
    val N = readLine()!!.toInt()
    println(findMinSteps(N))
}
