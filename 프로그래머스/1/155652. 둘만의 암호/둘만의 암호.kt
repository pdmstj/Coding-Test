class Solution {
    fun solution(s: String, skip: String, index: Int): String {
        val skipSet = skip.toSet()
        val validChars = ('a'..'z').filter { it !in skipSet } 
        val validSize = validChars.size 
        return s.map { char ->
            val currentIndex = validChars.indexOf(char) 
            val newIndex = (currentIndex + index) % validSize 
            validChars[newIndex]
        }.joinToString("") 
    }
}
