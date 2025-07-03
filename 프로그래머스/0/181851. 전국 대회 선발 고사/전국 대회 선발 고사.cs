using System;
using System.Linq;

public class Solution {
    public int solution(int[] rank, bool[] attendance) {
        var students = rank
            .Select((r, i) => new { Rank = r, Index = i }) 
            .OrderBy(s => s.Rank);  

        var selected = students
            .Where(s => attendance[s.Index])
            .Take(3)
            .Select(s => s.Index) 
            .ToArray();

        int a = selected[0];
        int b = selected[1];
        int c = selected[2];

        return 10000 * a + 100 * b + c;
    }
}
