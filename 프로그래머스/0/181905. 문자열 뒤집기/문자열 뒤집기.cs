using System;

public class Solution {
    public string solution(string my_string, int s, int e) {
        string prefix = my_string.Substring(0, s);
        char[] middleArray = my_string.Substring(s, e - s + 1).ToCharArray();
        Array.Reverse(middleArray);
        string middle = new string(middleArray);
        string suffix = my_string.Substring(e + 1);
        return prefix + middle + suffix;
    }
}
