class Solution {
    public int[] solution(int[] sequence, int k) {
        int start = 0, end = 0, currentSum = 0;
        int minLength = Integer.MAX_VALUE;
        int[] result = new int[2];
        
        while (end < sequence.length) {
            currentSum += sequence[end];
            
            while (currentSum > k && start <= end) {
                currentSum -= sequence[start];
                start++;
            }
            
            if (currentSum == k) {
                int length = end - start + 1;
                if (length < minLength) {
                    minLength = length;
                    result[0] = start;
                    result[1] = end;
                }
            }
            
            end++;
        }
        
        return result;
    }
}
