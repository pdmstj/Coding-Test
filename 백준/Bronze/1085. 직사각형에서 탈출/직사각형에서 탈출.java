import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class Main {
	static int M = 0;	
	static int N = 0;
	static boolean[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		int a = w-x;
		int b = h-y;
		
		int[] com = new int[4];
		com[0]=x;
		com[1]=y;
		com[2]=a;
		com[3]=b;
		
		for(int i=0; i<com.length; i++) {
			for(int j=0; j<com.length-i-1; j++) {
				if(com[j]>com[j+1]) {
					int temp = com[j+1];
					com[j+1] = com[j];
					com[j] = temp;
				}
			}
		}
		
		System.out.println(com[0]);
	}
}