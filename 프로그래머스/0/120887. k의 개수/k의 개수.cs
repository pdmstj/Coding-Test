using System;

public class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        string target = k.ToString(); // k를 문자열로 변환

        for (int num = i; num <= j; num++) {
            // 현재 숫자를 문자열로 변환하여 target(k) 문자가 몇 번 등장하는지 셉니다.
            answer += CountOccurrences(num.ToString(), target);
        }
        
        return answer;
    }

    private int CountOccurrences(string str, string target) {
        int count = 0;
        foreach (char c in str) {
            if (c.ToString() == target) {
                count++;
            }
        }
        return count;
    }
}
