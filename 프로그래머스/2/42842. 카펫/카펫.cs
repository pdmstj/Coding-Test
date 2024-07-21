public class Solution {
    public int[] solution(int brown, int yellow) {
        // 1. 세로 길이는 가로보다 작거나 같다는 조건이 있으므로 절반까지 확인
        for (int bh = 1; bh <= brown / 2; bh++) {
            // 2. 위 정리된 수식을 이용하여 가로, 세로 구하기
            int bw = (brown - 2 * bh + 4) / 2;
            int yw = bw - 2;
            int yh = bh - 2;

            // 3. 옐로우 = 옐로우 가로 x 옐로우 세로 이면서 옐로우 + 브라운이 브라운 가로 x 브라운 세로를 만족하면
            if (yellow == yw * yh && yellow + brown == bw * bh) {
                // 4. 브라운 가로, 브라운 세로가 카펫의 크기와 같다.
                return new int[] { bw, bh };
            }
        }

        // 기본적으로 루프를 다 돌고도 반환이 안 되었다면 문제가 있는 것이므로
        // null을 반환하는데, 프로그래머스에서는 기본적으로 이 부분은 도달하지 않을 것으로 가정
        return null;
    }
}