import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt(), f=sc.nextInt();
        n/=100;		
        for(int i=0;i<100;i++)			
            if((n*100+i)%f==0) {				
                System.out.printf("%02d",i);
                break;			
            }
    }
}
