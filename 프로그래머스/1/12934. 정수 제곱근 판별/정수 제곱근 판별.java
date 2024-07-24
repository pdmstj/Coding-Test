class Solution {
    public long solution(long n) {
        long answer = 0;
        boolean flag = false;
    
        long num = 1;
        long index = 0;
        while(num <= n){
            if(num == n){
                flag = true;
                break;
            }
            num = num + 3 + (2 * index);
            index++;
        }
        
        answer = flag ? (index + 2) * (index + 2) : -1;
        
        return answer;
    }
}