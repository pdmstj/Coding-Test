class Solution {
    public int solution(int num1, int num2) {
        // num1을 num2로 나누고 1000을 곱한 결과
        double result = (double) num1 / num2 * 1000;
        return (int) result;
    }
}
