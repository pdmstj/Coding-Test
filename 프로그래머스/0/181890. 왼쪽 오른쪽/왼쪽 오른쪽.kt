class Solution {
    fun solution(str_list: Array<String>): Array<String> {
        for ((i, str) in str_list.withIndex()) {
            if (str == "l") {
                return str_list.sliceArray(0 until i)
            } else if (str == "r") {
                return str_list.sliceArray(i + 1 until str_list.size)
            }
        }
        return arrayOf()
    }
}
