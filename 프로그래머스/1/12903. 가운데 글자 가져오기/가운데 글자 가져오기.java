class Solution {
    public String solution(String s) {
        int len = s.length();
        return s.substring((len-1)/2, (len/2) + 1);
    }
}