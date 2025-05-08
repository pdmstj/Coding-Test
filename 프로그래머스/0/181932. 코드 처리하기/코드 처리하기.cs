using System;
using System.Text;

public class Solution {
    public string solution(string code) {
        StringBuilder ret = new StringBuilder();
        int mode = 0;

        for (int idx = 0; idx < code.Length; idx++) {
            if (code[idx] == '1') {
                mode = 1 - mode; 
            } else {
                if ((mode == 0 && idx % 2 == 0) || (mode == 1 && idx % 2 == 1)) {
                    ret.Append(code[idx]);
                }
            }
        }

        return ret.Length > 0 ? ret.ToString() : "EMPTY";
    }
}
