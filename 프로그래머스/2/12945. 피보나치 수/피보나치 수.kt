class Solution {
    fun solution(n: Int): Int {
        var arr = arrayOf(1,1,1)
        if(n==2) return 1
        repeat(n-2){
            arr[2] = (arr[0]+arr[1])%1234567
            arr[0] = arr[1]
            arr[1] = arr[2]
        }
       return arr[2]
    }
}
