class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        int a = slicer[0];
        int b = slicer[1];
        int c = slicer[2];

        int[] answer;
        
        if (n == 1) {
            // num_list의 0번 인덱스부터 b번 인덱스까지 슬라이싱
            answer = java.util.Arrays.copyOfRange(num_list, 0, b + 1);
        } else if (n == 2) {
            // num_list의 a번 인덱스부터 마지막 인덱스까지 슬라이싱
            answer = java.util.Arrays.copyOfRange(num_list, a, num_list.length);
        } else if (n == 3) {
            // num_list의 a번 인덱스부터 b번 인덱스까지 슬라이싱
            answer = java.util.Arrays.copyOfRange(num_list, a, b + 1);
        } else {
            // num_list의 a번 인덱스부터 b번 인덱스까지 c 간격으로 슬라이싱
            java.util.List<Integer> tempList = new java.util.ArrayList<>();
            for (int i = a; i <= b; i += c) {
                tempList.add(num_list[i]);
            }
            answer = tempList.stream().mapToInt(Integer::intValue).toArray();
        }

        return answer;
    }
}
