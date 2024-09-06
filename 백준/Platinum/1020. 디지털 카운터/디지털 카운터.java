import java.io.*;
import java.util.*;

public class Main {
    static String s;
    static final int[] lineCnt = {6, 2, 5, 5, 4, 5, 6, 3, 7, 5}; // 각 숫자에 필요한 LED 횟수
    static int[][][] dp; // 메모이제이션 배열
    static long goRet; // 결과로 사용할 숫자 저장

    // DP를 사용하여 pos 위치부터 남은 LED 수가 left일 때 가능한 가장 작은 숫자를 찾는 함수
    static int solve(int pos, int left, boolean bigger) {
        if (left < 0) return 10; // 남은 LED 수가 0보다 작으면 불가능한 경우
        if (pos == s.length()) return (bigger && left == 0) ? 0 : 10; // 남은 LED 수가 0이고 큰 숫자인 경우

        // 이미 계산된 값이 있으면 해당 값 반환
        if (dp[pos][left][bigger ? 1 : 0] != -1) return dp[pos][left][bigger ? 1 : 0];

        int ret = 10; // 기본 값으로 불가능한 값 설정
        // 현재 자릿수에서 만들 수 있는 가장 작은 숫자 찾기
        for (int i = (bigger ? 0 : s.charAt(pos) - '0'); i <= 9; ++i) {
            int next = solve(pos + 1, left - lineCnt[i], bigger || (i > s.charAt(pos) - '0'));
            if (next != 10) {
                ret = i;
                break;
            }
        }
        return dp[pos][left][bigger ? 1 : 0] = ret; // 계산된 결과 저장 및 반환
    }

    // DP 결과를 기반으로 실제 숫자를 만들어내는 함수
    static void go(int pos, int left, boolean bigger) {
        if (pos == s.length()) return; // 마지막 자리까지 도달하면 종료

        int ret = dp[pos][left][bigger ? 1 : 0]; // 해당 자리의 값 가져오기
        goRet = goRet * 10 + ret; // 결과 숫자 생성
        go(pos + 1, left - lineCnt[ret], bigger || (ret > s.charAt(pos) - '0')); // 다음 자리 처리
    }

    // 10의 a 제곱을 계산하는 함수
    static long tenPow(int a) {
        return (a == 0) ? 1 : 10 * tenPow(a - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력 처리
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력 처리

        String input = br.readLine(); // 입력값 받기
        int sum = 0;
        for (char c : input.toCharArray()) {
            sum += lineCnt[c - '0']; // 입력된 숫자들의 LED 횟수 합산
        }

        // 순환 후의 답을 구하기 위한 초기화
        dp = new int[input.length()][sum + 1][2];
        for (int[][] matrix : dp) {
            for (int[] row : matrix) {
                Arrays.fill(row, -1); // dp 배열 초기화
            }
        }

        s = "0".repeat(input.length()); // 입력 크기와 같은 0으로 채운 문자열
        solve(0, sum, false); // 작은 숫자를 찾기 위한 solve 호출
        goRet = 0;
        go(0, sum, false); // 실제 숫자 생성
        long ans = goRet - Long.parseLong(input) + tenPow(s.length()); // 순환 후의 결과 계산

        // 순환 전의 답을 구하기 위한 초기화
        dp = new int[input.length()][sum + 1][2];
        for (int[][] matrix : dp) {
            for (int[] row : matrix) {
                Arrays.fill(row, -1); // dp 배열 초기화
            }
        }

        s = input;
        if (solve(0, sum, false) != 10) { // 순환 전의 값이 유효한 경우 처리
            goRet = 0;
            go(0, sum, false); // 순환 전의 숫자 생성
            ans = goRet - Long.parseLong(input); // 결과 계산
        }

        bw.write(Long.toString(ans)); // 최종 결과 출력
        bw.flush();
        br.close();
        bw.close();
    }
}
