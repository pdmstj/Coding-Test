import java.util.Scanner;
public class Main {
    public static int[] arr;
    public static boolean[] visit;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        arr = new int[M];
        visit = new boolean[N];
        dfs(0, N, M);
        sc.close();
    }
    public static void dfs( int depth, int N, int M) {
        if (depth == M) {
            for (int val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = i + 1;
                dfs(depth + 1, N, M);
                visit[i] = false;
            }
        }
    }
}