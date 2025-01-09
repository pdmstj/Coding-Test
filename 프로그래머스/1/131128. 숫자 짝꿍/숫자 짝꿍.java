import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        // 숫자 빈도 계산
        int[] countX = new int[10];
        int[] countY = new int[10];
        
        for (char c : X.toCharArray()) {
            countX[c - '0']++;
        }
        
        for (char c : Y.toCharArray()) {
            countY[c - '0']++;
        }
        
        // 공통 숫자 추출
        StringBuilder result = new StringBuilder();
        for (int i = 9; i >= 0; i--) { // 큰 숫자부터 내림차순 처리
            int commonCount = Math.min(countX[i], countY[i]);
            for (int j = 0; j < commonCount; j++) {
                result.append(i);
            }
        }
        
        // 결과 문자열 생성 및 예외 처리
        if (result.length() == 0) {
            return "-1"; // 공통 숫자가 없는 경우
        }
        
        // 결과가 0으로만 구성된 경우
        if (result.toString().replace("0", "").length() == 0) {
            return "0";
        }
        
        return result.toString();
    }
}
