class Solution {
    public int solution(int[] num_list, int n) {
        // num_list 배열을 순회하며 n이 존재하는지 확인
        for (int num : num_list) {
            if (num == n) {
                return 1;  // n이 배열에 있으면 1 반환
            }
        }
        return 0;  // n이 배열에 없으면 0 반환
    }
}
