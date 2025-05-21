using System;

public class Solution {
    public int[] solution(string my_string) {
        int[] answer = new int[52]; // 0~25: A~Z, 26~51: a~z

        foreach (char c in my_string) {
            if (c >= 'A' && c <= 'Z') {
                answer[c - 'A']++;
            } else if (c >= 'a' && c <= 'z') {
                answer[c - 'a' + 26]++;
            }
        }

        return answer;
    }
}