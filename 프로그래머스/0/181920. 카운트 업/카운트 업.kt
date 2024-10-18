class Solution {
    fun solution(start_num: Int, end_num: Int): IntArray {
        // start_num부터 end_num까지의 숫자를 배열로 변환하여 반환
        return (start_num..end_num).toList().toIntArray()
    }
}
