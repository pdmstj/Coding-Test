class Solution {
    public String solution(String rsp) {
        StringBuilder answer = new StringBuilder();

        for (char c : rsp.toCharArray()) {
            if (c == '2') {
                answer.append('0'); // 가위(2)는 바위(0)로 이김
            } else if (c == '0') {
                answer.append('5'); // 바위(0)는 보(5)로 이김
            } else if (c == '5') {
                answer.append('2'); // 보(5)는 가위(2)로 이김
            }
        }

        return answer.toString();
    }
}
