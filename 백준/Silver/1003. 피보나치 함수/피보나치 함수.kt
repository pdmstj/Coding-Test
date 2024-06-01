import java.util.Scanner

fun main(){
    val input = Scanner(System.`in`)
    val t = input.nextInt()
    
    for(i in 1 .. t){
        val n = input.nextInt()
        println("${fibonacchi(n-1)} ${fibonacchi(n)}")
    }
}

fun fibonacchi(n: Int): Int{
    if(n == 0) return 0
    if(n == 1) return 1
    var a = 0
    var b = 1
    var tmp = 0
    for(i in 2 .. n){
        tmp = a
        a = b
        b = tmp + b
    }
    return b
}