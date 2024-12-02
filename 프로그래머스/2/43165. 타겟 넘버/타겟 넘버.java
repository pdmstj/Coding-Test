class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }

    private int dfs(int[] numbers, int target, int index, int sum) {
        // 모든 숫자를 다 사용한 경우
        if (index == numbers.length) {
            // 현재 합이 target과 같으면 1을 반환
            return sum == target ? 1 : 0;
        }
        // 현재 숫자를 더하는 경우와 빼는 경우를 모두 탐색
        return dfs(numbers, target, index + 1, sum + numbers[index]) +
               dfs(numbers, target, index + 1, sum - numbers[index]);
    }
}
