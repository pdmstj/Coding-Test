import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int totalSoldiersUsed = 0;

        for (int round = 0; round < enemy.length; round++) {
            pq.add(enemy[round]);
            totalSoldiersUsed += enemy[round];

            if (totalSoldiersUsed > n) {
                if (k > 0) {
                    totalSoldiersUsed -= pq.poll();
                    k--;
                } else {
                    return round;
                }
            }
        }

        return enemy.length;
    }
}
