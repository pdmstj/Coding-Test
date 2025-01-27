import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            // 스택에 있는 이전 시점의 가격과 비교
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int idx = stack.pop(); // 스택에서 빼기
                answer[idx] = i - idx; // 가격이 떨어진 기간 계산
            }
            stack.push(i); // 현재 시점 추가
        }

        // 스택에 남아 있는 시점은 끝까지 가격이 떨어지지 않음
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            answer[idx] = n - 1 - idx; // 끝까지 유지된 기간 계산
        }

        return answer;
    }
}
