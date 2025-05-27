using System;

public class Solution {
    public int solution(int[] arr) {
        int n = arr.Length;
        int[] prev = new int[n];
        Array.Copy(arr, prev, n);

        int count = 0;
        while (true)
        {
            bool changed = false;
            int[] next = new int[n];
            for (int i = 0; i < n; i++)
            {
                int value = prev[i];
                if (value >= 50 && value % 2 == 0)
                {
                    value /= 2;
                }
                else if (value < 50 && value % 2 == 1)
                {
                    value = value * 2 + 1;
                }
                next[i] = value;

                if (next[i] != prev[i])
                    changed = true;
            }

            if (!changed)
                break;

            prev = next;
            count++;
        }

        return count;
    }
}
