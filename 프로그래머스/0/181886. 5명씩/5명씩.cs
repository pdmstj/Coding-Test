using System;
using System.Collections.Generic;

public class Solution {
    public string[] solution(string[] names) {
        List<string> result = new List<string>();
        
        for (int i = 0; i < names.Length; i += 5) {
            result.Add(names[i]);
        }
        
        return result.ToArray();
    }
}