import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        String[][] arr = new String[20][3];
        double sum = 0.0, div = 0.0;

        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                arr[i][j] = scanner.next();
            }

            if (!arr[i][2].equals("P")){
                sum += Double.parseDouble(arr[i][1]);
                if (arr[i][2].equals("A+")){
                   div += Double.parseDouble(arr[i][1]) * 4.5;
                }
                else if (arr[i][2].equals("A0")){
                    div += Double.parseDouble(arr[i][1]) * 4.0;
                }
                else if (arr[i][2].equals("B+")){
                    div += Double.parseDouble(arr[i][1]) * 3.5;
                }
                else if (arr[i][2].equals("B0")){
                    div += Double.parseDouble(arr[i][1]) * 3.0;
                }
                else if (arr[i][2].equals("C+")){
                    div += Double.parseDouble(arr[i][1]) * 2.5;
                }
                else if (arr[i][2].equals("C0")){
                    div += Double.parseDouble(arr[i][1]) * 2.0;
                }
                else if (arr[i][2].equals("D+")){
                    div += Double.parseDouble(arr[i][1]) * 1.5;
                }
                else if (arr[i][2].equals("D0")){
                    div += Double.parseDouble(arr[i][1]);
                }
                else {
                    div += 0.0;
                }
            }
        }
        double answer = div / sum;
        System.out.println(answer);
    }
}