class Solution {
    public int solution(int[] num_list) {
        int oddSum = 0; // 홀수 번째 원소들의 합
        int evenSum = 0; // 짝수 번째 원소들의 합

        // 인덱스를 이용하여 홀수 번째와 짝수 번째를 구분합니다.
        for (int i = 0; i < num_list.length; i++) {
            if ((i + 1) % 2 == 1) { // 홀수 번째 원소
                oddSum += num_list[i];
            } else { // 짝수 번째 원소
                evenSum += num_list[i];
            }
        }

        // 더 큰 값을 반환하거나 두 값이 같을 경우 그 값을 반환합니다.
        return Math.max(oddSum, evenSum);
    }
}
