import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        Queue<Integer> queue = new LinkedList<>();
    
        boolean[] visited = new boolean[y + 1];
        
        queue.add(x);
        visited[x] = true;
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();

                if (current == y) {
                    return steps;
                }

                int[] nextValues = {current + n, current * 2, current * 3};
                for (int next : nextValues) {
                    if (next <= y && !visited[next]) {
                        visited[next] = true;
                        queue.add(next);
                    }
                }
            }
            steps++;
        }
        
        return -1;
    }
}
