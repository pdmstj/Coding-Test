import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] playersAtStage = new int[N + 2]; // 각 스테이지에 머물러 있는 플레이어 수를 저장
        int[] result = new int[N];
        
        // stages 배열을 통해 각 스테이지에 도달한 플레이어 수를 카운트
        for (int stage : stages) {
            playersAtStage[stage]++;
        }
        
        int totalPlayers = stages.length; // 총 플레이어 수
        List<StageFailure> failureRates = new ArrayList<>();
        
        for (int i = 1; i <= N; i++) {
            if (totalPlayers == 0) {
                failureRates.add(new StageFailure(i, 0)); // 도달한 플레이어가 없으면 실패율 0
            } else {
                double failureRate = (double) playersAtStage[i] / totalPlayers;
                failureRates.add(new StageFailure(i, failureRate));
                totalPlayers -= playersAtStage[i]; // 다음 스테이지로 넘어가는 플레이어 수 갱신
            }
        }
        
        // 실패율 기준 내림차순 정렬, 실패율이 같으면 스테이지 번호 오름차순
        failureRates.sort((a, b) -> {
            if (b.failureRate == a.failureRate) {
                return Integer.compare(a.stage, b.stage);
            }
            return Double.compare(b.failureRate, a.failureRate);
        });
        
        // 정렬된 결과에서 스테이지 번호만 추출
        for (int i = 0; i < N; i++) {
            result[i] = failureRates.get(i).stage;
        }
        
        return result;
    }
}

// 실패율 정보를 저장하기 위한 클래스
class StageFailure {
    int stage;
    double failureRate;
    
    public StageFailure(int stage, double failureRate) {
        this.stage = stage;
        this.failureRate = failureRate;
    }
}
