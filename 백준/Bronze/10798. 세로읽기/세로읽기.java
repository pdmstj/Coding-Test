import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = new String[5];
        
        for (int i = 0; i < 5; i++) {
            words[i] = scanner.nextLine().trim();
        }
        
        for (int i = 0; i < 15; i++) { // 최대 15글자
            for (int j = 0; j < 5; j++) { // 5개의 단어가 존재함
                if (i < words[j].length()) { // 단어가 끝나면 if 문을 통과한다는 뜻이다
                    System.out.print(words[j].charAt(i));
                }
            }
        }
    }
}
