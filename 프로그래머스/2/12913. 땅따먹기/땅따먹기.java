class Solution {
    int solution(int[][] land) {
        int rows = land.length;

        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < 4; j++) {
                int maxPrev = 0;
                for (int k = 0; k < 4; k++) {
                    if (k != j) {
                        maxPrev = Math.max(maxPrev, land[i - 1][k]);
                    }
                }
                land[i][j] += maxPrev;
            }
        }

        int answer = 0;
        for (int val : land[rows - 1]) {
            answer = Math.max(answer, val);
        }
        return answer;
    }
}
