using System;
using System.Collections.Generic;

public class Solution {
    public int solution(string dirs) {

        int x = 0, y = 0;
        
        var visitedPaths = new HashSet<string>();
     
        var directions = new Dictionary<char, (int dx, int dy)> {
            { 'U', (0, 1) }, 
            { 'D', (0, -1) }, 
            { 'R', (1, 0) },  
            { 'L', (-1, 0) }  
        };
        
        foreach (char dir in dirs) {
            if (!directions.ContainsKey(dir)) continue;

            int nx = x + directions[dir].dx;
            int ny = y + directions[dir].dy;

            // 좌표 범위 확인 (-5 ≤ x, y ≤ 5)
            if (nx < -5 || nx > 5 || ny < -5 || ny > 5) continue;

            string path1 = $"{x},{y}->{nx},{ny}";
            string path2 = $"{nx},{ny}->{x},{y}"; 
            
            if (!visitedPaths.Contains(path1)) {
                visitedPaths.Add(path1);
                visitedPaths.Add(path2);
            }

            x = nx;
            y = ny;
        }

        return visitedPaths.Count / 2; 
    }
}
