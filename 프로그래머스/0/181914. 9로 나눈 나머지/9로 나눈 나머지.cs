using System;

public class Solution {
    public int solution(string number) {
        int sum = 0;
        foreach (char c in number)
        {
            sum += c - '0'; 
        }
        return sum % 9; 
    }
}
