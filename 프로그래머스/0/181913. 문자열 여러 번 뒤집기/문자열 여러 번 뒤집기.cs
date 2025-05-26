using System;

public class Solution {
    public string solution(string my_string, int[,] queries) {

        char[] chars = my_string.ToCharArray();
        
        for (int i = 0; i < queries.GetLength(0); i++) {
            int s = queries[i, 0];
            int e = queries[i, 1];
            
            while (s < e) {
                char temp = chars[s];
                chars[s] = chars[e];
                chars[e] = temp;
                s++;
                e--;
            }
        }
        return new string(chars);
    }
}
