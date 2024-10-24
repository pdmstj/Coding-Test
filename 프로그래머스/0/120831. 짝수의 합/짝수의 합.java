class Solution {
    public int solution(int n) {
        int answer = 0;
        // 1부터 n까지의 수 중 짝수만 더하기
        for (int i = 2; i <= n; i += 2) {
            answer += i;
        }
        return answer;
    }
}
