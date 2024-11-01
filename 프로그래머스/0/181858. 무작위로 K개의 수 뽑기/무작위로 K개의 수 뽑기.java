import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        // 서로 다른 수를 저장할 Set
        Set<Integer> uniqueNumbers = new LinkedHashSet<>();
        
        // arr의 원소들을 차례대로 Set에 추가 (중복 제거)
        for (int num : arr) {
            if (uniqueNumbers.size() >= k) {
                break;
            }
            uniqueNumbers.add(num);
        }
        
        // 결과 배열 생성
        int[] answer = new int[k];
        int index = 0;
        
        // Set에서 서로 다른 수를 꺼내서 결과 배열에 저장
        for (int num : uniqueNumbers) {
            if (index >= k) {
                break;
            }
            answer[index++] = num;
        }
        
        // 아직 k개의 숫자를 다 채우지 못했다면 나머지를 -1로 채움
        while (index < k) {
            answer[index++] = -1;
        }
        
        return answer;
    }
}
