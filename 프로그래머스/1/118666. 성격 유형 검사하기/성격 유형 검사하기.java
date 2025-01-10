import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        // 성격 유형별 점수 저장
        Map<Character, Integer> scoreMap = new HashMap<>();
        scoreMap.put('R', 0);
        scoreMap.put('T', 0);
        scoreMap.put('C', 0);
        scoreMap.put('F', 0);
        scoreMap.put('J', 0);
        scoreMap.put('M', 0);
        scoreMap.put('A', 0);
        scoreMap.put('N', 0);

        // 선택지에 따른 점수 계산
        for (int i = 0; i < survey.length; i++) {
            char disagree = survey[i].charAt(0); // 비동의 성격 유형
            char agree = survey[i].charAt(1);    // 동의 성격 유형
            int choice = choices[i];
            
            if (choice < 4) { // 비동의 선택
                scoreMap.put(disagree, scoreMap.get(disagree) + (4 - choice));
            } else if (choice > 4) { // 동의 선택
                scoreMap.put(agree, scoreMap.get(agree) + (choice - 4));
            }
            // choice == 4일 경우 점수 없음
        }

        // 결과 조합
        StringBuilder result = new StringBuilder();
        result.append(scoreMap.get('R') >= scoreMap.get('T') ? 'R' : 'T');
        result.append(scoreMap.get('C') >= scoreMap.get('F') ? 'C' : 'F');
        result.append(scoreMap.get('J') >= scoreMap.get('M') ? 'J' : 'M');
        result.append(scoreMap.get('A') >= scoreMap.get('N') ? 'A' : 'N');

        return result.toString();
    }
}
