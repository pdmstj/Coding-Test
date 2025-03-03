import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int work : works) {
            pq.offer(work);
        }

        while (n > 0 && !pq.isEmpty()) {
            int maxWork = pq.poll(); // 가장 큰 값 꺼내기
            if (maxWork == 0) break; // 작업량이 0이면 종료
            pq.offer(maxWork - 1); // 감소 후 다시 삽입
            n--;
        }
        
        long answer = 0;
        while (!pq.isEmpty()) {
            int work = pq.poll();
            answer += (long) work * work; // 제곱 합
        }

        return answer;
    }
}
