import java.util.Stack;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < number.length(); i++) {
            char current = number.charAt(i);
            
            while (!stack.isEmpty() && k > 0 && stack.peek() < current) {
                stack.pop();
                k--;
            }
            
            stack.push(current); 
        }
        
        while (k > 0) {
            stack.pop();
            k--;
        }
        
        StringBuilder answer = new StringBuilder();
        for (char c : stack) {
            answer.append(c);
        }
        
        return answer.toString();
    }
}
