class Solution {
    public int solution(int left, int right) {
        int answer = 0;

        for (int i = left; i <= right; i++) {
            int curNum = 0; // 현재 수의 약수의 갯수

            for (int j = 1; j <= i / 2; j++) {
                if (i % j == 0) curNum++;
            }

            curNum++; // 자신의 갯수 추가

            if ((curNum & 1) == 0) answer += i; // 짝수인 경우
            else answer -= i; // 홀수인 경우
        }

        return answer;
    }
}