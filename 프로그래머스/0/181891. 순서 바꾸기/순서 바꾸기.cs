using System;

public class Solution {
    public int[] solution(int[] num_list, int n) {
        
        int[] part1 = new int[num_list.Length - n];
        int[] part2 = new int[n];

        Array.Copy(num_list, n, part1, 0, num_list.Length - n);
        Array.Copy(num_list, 0, part2, 0, n);

        int[] result = new int[num_list.Length];
        Array.Copy(part1, 0, result, 0, part1.Length);
        Array.Copy(part2, 0, result, part1.Length, part2.Length);

        return result;
    }
}