import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] routes) {
        if (routes.length == 0) return 0;

        // 차량의 진출 지점을 기준으로 오름차순 정렬
        Arrays.sort(routes, Comparator.comparingInt(a -> a[1]));

        int answer = 0;
        int cameraPosition = Integer.MIN_VALUE;

        for (int[] route : routes) {
            if (route[0] > cameraPosition) {
                cameraPosition = route[1];
                answer++;
            }
        }

        return answer;
    }
}