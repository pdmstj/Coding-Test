class Solution {
    public String solution(String[] arr) {
        StringBuilder answer = new StringBuilder();
        
        // 배열의 각 원소를 차례대로 StringBuilder에 추가
        for (String s : arr) {
            answer.append(s);
        }
        
        // StringBuilder를 String으로 변환하여 반환
        return answer.toString();
    }
}
