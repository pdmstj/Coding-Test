import java.util.Arrays;

class Solution {
    public int[] solution(int[] numbers, int num1, int num2) {
        // Arrays.copyOfRange를 사용하여 numbers 배열의 num1부터 num2까지 자름
        return Arrays.copyOfRange(numbers, num1, num2 + 1);
    }
}
