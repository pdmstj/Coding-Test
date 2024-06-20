import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        String word = sc.next();
        
        for(char i='a'; i<='z'; i++){
            System.out.printf("%d ", word.indexOf(i));
        }
    }
}
