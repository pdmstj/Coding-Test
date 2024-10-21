class Solution {
    public int[] solution(int[] numbers) {
        // numbers 배열과 같은 크기의 새로운 배열을 생성
        int[] answer = new int[numbers.length];
        
        // 각 원소에 대해 2를 곱해서 새로운 배열에 저장
        for (int i = 0; i < numbers.length; i++) {
            answer[i] = numbers[i] * 2;
        }
        
        // 결과 배열 반환
        return answer;
    }
}
