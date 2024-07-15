class Solution {
    fun solution(s: String): String {
        var answer = s.split(" ")
            .joinToString(" ") { word -> 
                word.toLowerCase().capitalize()
            }
        return answer
    }
}
