import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 입력 받기
        int N = scanner.nextInt();
        int L = scanner.nextInt();
        
        // 연속된 수열 찾기
        for (int i = L; i <= 100; i++) {
            // 첫 번째 수 a 계산
            int a = N / i - (i - 1) / 2;
            
            // a가 음수이면 다음 i로 넘어감
            if (a < 0) {
                continue;
            }
            
            // 수열의 합이 N과 같은지 확인
            if (N == (2 * a + i - 1) * i / 2) {
                // 수열 출력
                StringBuilder result = new StringBuilder();
                for (int j = 0; j < i; j++) {
                    result.append(a + j).append(" ");
                }
                System.out.println(result.toString().trim());
                return;
            }
        }
        
        // 조건을 만족하는 수열이 없는 경우 -1 출력
        System.out.println("-1");
    }
}