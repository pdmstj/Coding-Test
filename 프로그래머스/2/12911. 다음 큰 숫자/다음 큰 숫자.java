class Solution {
    public int solution(int n) {
        int BinaryCount=0;
        String str = Integer.toBinaryString(n);
        
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)=='1') BinaryCount++;
        }
        int temp=BinaryCount;
        
		for(int i=n+1; i<10000000; i++) {
			String highNumber= Integer.toBinaryString(i);
			BinaryCount=temp;
            
			for(int j=0; j<highNumber.length(); j++) {
				if(highNumber.charAt(j)=='1') BinaryCount--;
			}
			
			if(BinaryCount==0) return i;
		}
        return BinaryCount;
    }
}