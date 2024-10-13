using System;

public class Solution {
    public string solution(string my_string, int n) {
        // 문자열의 뒤에서 n글자만큼 추출
        return my_string.Substring(my_string.Length - n);
    }
}
