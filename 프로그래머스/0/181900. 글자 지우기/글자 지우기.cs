using System;
using System.Collections.Generic;

public class Solution {
    public string solution(string my_string, int[] indices) {
        // 빠른 검색을 위해 indices를 HashSet에 저장
        HashSet<int> indexSet = new HashSet<int>(indices);
        
        string answer = "";

        for (int i = 0; i < my_string.Length; i++) {
            if (!indexSet.Contains(i)) {
                answer += my_string[i];
            }
        }

        return answer;
    }
}