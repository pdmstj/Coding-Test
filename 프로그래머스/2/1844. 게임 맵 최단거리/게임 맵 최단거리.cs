using System;
using System.Collections.Generic;

class Solution {
    public int solution(int[,] maps) {
        int rows = maps.GetLength(0);
        int cols = maps.GetLength(1); 
        
        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };

        var queue = new Queue<(int x, int y, int distance)>();
        queue.Enqueue((0, 0, 1));
        
        var visited = new bool[rows, cols];
        visited[0, 0] = true;

        while (queue.Count > 0) {
            var current = queue.Dequeue();
            int x = current.x;
            int y = current.y;
            int distance = current.distance;

            if (x == rows - 1 && y == cols - 1) {
                return distance;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= rows || ny < 0 || ny >= cols || visited[nx, ny] || maps[nx, ny] == 0) {
                    continue;
                }

                visited[nx, ny] = true;
                queue.Enqueue((nx, ny, distance + 1));
            }
        }

        return -1;
    }
}
