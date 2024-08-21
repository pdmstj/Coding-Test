class Solution {
	public String[] maps2;
	int n;
	
    public String[] solution(int n, int[] arr1, int[] arr2) {
    	maps2 = new String[n];
    	
    	this.n = n;
    	makeMap2(arr1, arr2);
    	for(int i=0; i<n; i++){
    		System.out.println(maps2[i]);
    	}
        String[] answer = maps2;
        return answer;
    }
    public void makeMap2(int[] arr1, int[] arr2){
    	int lines;
    	String line;
    	int rules = (int)Math.pow(2, n); //전체 이진수의 길이+1 (1000000)
    	StringBuilder sb;
    	
    	for(int i=0; i<n; i++){
    		lines = rules | (arr1[i] | arr2[i]); //OR연산으로 한번에 벽 다 추가
    		line = Integer.toBinaryString(lines);
    		System.out.println(line + " " + line.length());
    		sb = new StringBuilder();
    		
    		for(int conv=1; conv<n+1; conv++){   			
    			if(line.charAt(conv) == '1') sb.append("#");//일일히 #과 공백 확인
    			else sb.append(" ");		
    		}
    		maps2[i] = sb.toString();
    	}
    }
}