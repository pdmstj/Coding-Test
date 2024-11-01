import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int[] query) {
        // query를 순회하면서 arr의 크기를 계속 조정
        for (int i = 0; i < query.length; i++) {
            if (i % 2 == 0) {
                // 짝수 인덱스: query[i]번 인덱스 이후를 잘라서 버림
                arr = Arrays.copyOfRange(arr, 0, query[i] + 1);
            } else {
                // 홀수 인덱스: query[i]번 인덱스 이전을 잘라서 버림
                arr = Arrays.copyOfRange(arr, query[i], arr.length);
            }
        }
        return arr;
    }
}
