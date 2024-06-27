class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        
        int num = x;
        int numSum = 0;
        
        while(num != 0) {
            numSum += num % 10;
            num /= 10;
        }
        
        if(x % numSum != 0) {
            answer = false;
        }
        
        return answer;
    }
}