import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int N;
    static Scanner sc = new Scanner(System.in);
    static int ans;
    static List<Integer> row;

    static boolean isPromising(int x) {
        for (int i=0; i<x; i++) {
            if (row.get(x) == row.get(i) | Math.abs(row.get(x) - row.get(i)) == Math.abs(x - i)) {
                return false;
            }
        }

        return true;
    }

    static void nQueen(int x) {
        if (x == N) {
            ans++;
            return;
        }

        for (int i=0; i<N; i++) {
            row.set(x, i);
            if (isPromising(x)) {
                nQueen(x + 1);
            }
        }
    }

    public static void main(String[] args) {
        N = sc.nextInt();
        ans = 0;
        row = new ArrayList<>();
        for (int i=0; i<N; i++) {
            row.add(0);
        }

        nQueen(0);
        System.out.println(ans);

    }
}