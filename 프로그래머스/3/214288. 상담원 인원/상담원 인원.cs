using System;
using System.Collections.Generic;
using System.Linq;

public class Solution {
    public int solution(int k, int n, int[,] reqs) {
        int m = reqs.GetLength(0);
        var reqList = new List<(int time, int duration, int type)>();
        for (int i = 0; i < m; i++) {
            reqList.Add((reqs[i, 0], reqs[i, 1], reqs[i, 2] - 1));
        }

        var combinations = new List<List<int>>();
        GenerateCombinations(new List<int>(), 0, k, n, combinations);

        int minWait = int.MaxValue;
        foreach (var combo in combinations) {
            if (combo.Any(x => x == 0)) continue;

            int totalWait = 0;
            for (int i = 0; i < k; i++) {
                var tasks = reqList.Where(r => r.type == i).ToList();
                totalWait += SimulateMentors(combo[i], tasks);
            }

            minWait = Math.Min(minWait, totalWait);
        }

        return minWait;
    }

    void GenerateCombinations(List<int> current, int depth, int k, int remaining, List<List<int>> result) {
        if (depth == k) {
            if (remaining == 0) result.Add(new List<int>(current));
            return;
        }

        for (int i = 1; i <= remaining - (k - depth - 1); i++) {
            current.Add(i);
            GenerateCombinations(current, depth + 1, k, remaining - i, result);
            current.RemoveAt(current.Count - 1);
        }
    }

    int SimulateMentors(int mentorCount, List<(int time, int duration, int type)> tasks) {
        var endTimes = new List<int>();
        for (int i = 0; i < mentorCount; i++) endTimes.Add(0);

        int waitSum = 0;
        foreach (var task in tasks) {
            int earliest = int.MaxValue;
            int idx = -1;
            for (int i = 0; i < mentorCount; i++) {
                if (endTimes[i] < earliest) {
                    earliest = endTimes[i];
                    idx = i;
                }
            }

            int startTime = Math.Max(task.time, earliest);
            waitSum += startTime - task.time;
            endTimes[idx] = startTime + task.duration;
        }

        return waitSum;
    }
}