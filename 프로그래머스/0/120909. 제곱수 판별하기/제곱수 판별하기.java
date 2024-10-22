class Solution {
    public int solution(int n) {
        // n의 제곱근을 구합니다.
        double sqrt = Math.sqrt(n);
        
        // 제곱근의 정수 부분을 구한 후 제곱해서 n과 같은지 확인합니다.
        if (sqrt == (int) sqrt) {
            return 1;  // 제곱수가 맞다면 1 반환
        } else {
            return 2;  // 제곱수가 아니라면 2 반환
        }
    }
}
