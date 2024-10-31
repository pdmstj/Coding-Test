class Solution {
    public int[] solution(int[] arr) {
        // 2의 첫 번째와 마지막 위치를 초기화
        int start = -1;
        int end = -1;

        // 배열에서 2의 첫 번째와 마지막 위치를 찾음
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2) {
                if (start == -1) {
                    start = i;
                }
                end = i;
            }
        }

        // 2가 없는 경우 [-1] 반환
        if (start == -1) {
            return new int[]{-1};
        }

        // start에서 end까지의 부분 배열 생성
        int[] answer = new int[end - start + 1];
        for (int i = start; i <= end; i++) {
            answer[i - start] = arr[i];
        }
        
        return answer;
    }
}
