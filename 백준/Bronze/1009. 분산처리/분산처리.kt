import java.util.*;
fun main(args: Array<String>) {
    val s=Scanner(System.`in`)
    var n=s.nextInt()
    for(i in 0 until n){
        var a=s.nextInt()
        var b=s.nextInt()
        var num=1
        for(j in 0 until b) num=(num*a)%10
        if(num==0) num=10
        println(num)
    }
}