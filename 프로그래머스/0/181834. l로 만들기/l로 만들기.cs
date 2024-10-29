using System;

public class Solution {
    public string solution(string myString) {
        char[] result = myString.ToCharArray();
        
        for (int i = 0; i < result.Length; i++) {
            // 현재 문자가 'l'보다 앞서는 경우 'l'로 치환
            if (result[i] < 'l') {
                result[i] = 'l';
            }
        }
        
        // 결과를 문자열로 변환하여 반환
        return new string(result);
    }
}
