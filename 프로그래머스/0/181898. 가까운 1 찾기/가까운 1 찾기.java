class Solution {
    public int solution(int[] arr, int idx) {
        for (int i = idx; i < arr.length; i++) {  // idx부터 시작하여 검사
            if (arr[i] == 1) {
                return i;  // `1`을 찾으면 해당 인덱스 반환
            }
        }
        return -1;  // 끝까지 `1`을 찾지 못하면 -1 반환
    }
}
