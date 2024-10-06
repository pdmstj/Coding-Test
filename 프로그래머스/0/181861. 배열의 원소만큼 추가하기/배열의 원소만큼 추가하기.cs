using System;
using System.Collections.Generic;

public class Solution {
    public int[] solution(int[] arr) {
        List<int> result = new List<int>();
     
        foreach (int num in arr) {
            for (int i = 0; i < num; i++) {
                result.Add(num);
            }
        }
        return result.ToArray();
    }
}
