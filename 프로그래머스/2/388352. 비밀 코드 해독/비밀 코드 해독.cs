using System;
using System.Collections.Generic;
using System.Linq;

public class Solution {
    public int solution(int n, int[,] q, int[] ans) {
        var nums = Enumerable.Range(1, n).ToArray();
        var combinations = GetCombinations(nums, 5);
        int count = 0;

        foreach (var code in combinations) {
            bool valid = true;
            for (int i = 0; i < ans.Length; i++) {
                int match = 0;
                for (int j = 0; j < 5; j++) {
                    if (code.Contains(q[i, j])) match++;
                }
                if (match != ans[i]) {
                    valid = false;
                    break;
                }
            }
            if (valid) count++;
        }

        return count;
    }

    private List<List<int>> GetCombinations(int[] arr, int r) {
        var result = new List<List<int>>();
        Generate(arr, r, 0, new List<int>(), result);
        return result;
    }

    private void Generate(int[] arr, int r, int start, List<int> current, List<List<int>> result) {
        if (current.Count == r) {
            result.Add(new List<int>(current));
            return;
        }
        for (int i = start; i < arr.Length; i++) {
            current.Add(arr[i]);
            Generate(arr, r, i + 1, current, result);
            current.RemoveAt(current.Count - 1);
        }
    }
}