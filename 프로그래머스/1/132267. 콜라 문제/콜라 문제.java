class Solution {
    public int solution(int a, int b, int n) {
        int left = n;
        int coke = 0;
        while (left >= a){
            coke += b * (left/a);
            left = b * (left/a) + left % a;
        }
        return coke;
    }
}