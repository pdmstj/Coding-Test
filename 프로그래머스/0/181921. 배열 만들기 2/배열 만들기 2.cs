using System;
using System.Collections.Generic;

public class Solution {
    public int[] solution(int l, int r) {
        List<int> result = new List<int>();

        for (int i = l; i <= r; i++) {
            if (IsValid(i)) {
                result.Add(i);
            }
        }

        if (result.Count == 0) {
            return new int[] { -1 };
        }

        return result.ToArray();
    }

    private bool IsValid(int num) {
        while (num > 0) {
            int digit = num % 10;
            if (digit != 0 && digit != 5) {
                return false;
            }
            num /= 10;
        }
        return true;
    }
}
