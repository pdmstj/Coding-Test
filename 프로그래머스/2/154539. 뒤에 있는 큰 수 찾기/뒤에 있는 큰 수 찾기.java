import java.util.Stack;

class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            // 스택이 비어 있지 않고, 현재 숫자가 스택의 top이 가리키는 숫자보다 크면
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                int idx = stack.pop(); // 스택에서 인덱스를 꺼냄
                answer[idx] = numbers[i]; // 해당 인덱스의 뒷 큰수를 현재 숫자로 설정
            }
            stack.push(i); 
        }
        
        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }
        
        return answer;
    }
}
