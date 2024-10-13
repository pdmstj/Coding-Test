using System.Linq;

public class Solution {
    public int[] solution(int[] num_list) {
        // LINQ의 Reverse 메서드를 이용하여 배열을 뒤집기
        return num_list.Reverse().ToArray();
    }
}
