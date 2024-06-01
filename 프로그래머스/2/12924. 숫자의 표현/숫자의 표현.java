class Solution {
    public int solution(int n) {
        int answer = 0, sum =0;
        
        for (int i = 1; i < n / 2 + 1; i++) {
			sum = 0;
			int tmp = i;
			while (sum < n) {
				sum += tmp++;
				if (sum == n) answer++;
			}
		}
        return answer + 1;
    }
}