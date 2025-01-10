import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        // 선수 이름 -> 현재 순위 맵
        Map<String, Integer> playerIndexMap = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            playerIndexMap.put(players[i], i);
        }

        // callings를 처리하며 순위 변경
        for (String calling : callings) {
            int currentIndex = playerIndexMap.get(calling); // 추월한 선수의 현재 순위
            if (currentIndex > 0) { // 1등 선수는 불리지 않으므로 안전
                // 바로 앞 선수와 자리 교환
                String frontPlayer = players[currentIndex - 1];
                players[currentIndex - 1] = calling;
                players[currentIndex] = frontPlayer;

                // 맵 업데이트
                playerIndexMap.put(calling, currentIndex - 1);
                playerIndexMap.put(frontPlayer, currentIndex);
            }
        }

        return players;
    }
}
