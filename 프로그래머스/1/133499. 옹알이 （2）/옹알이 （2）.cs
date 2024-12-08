using System;
using System.Text.RegularExpressions;

public class Solution {
    public int solution(string[] babbling) {
        int answer = 0;

        string validPattern = "^(aya|ye|woo|ma)+$";
        string repeatPattern = ".*(ayaaya|yeye|woowoo|mama).*";

        foreach (string word in babbling) {
            if (Regex.IsMatch(word, validPattern) && !Regex.IsMatch(word, repeatPattern)) {
                answer++;
            }
        }

        return answer;
    }
}
