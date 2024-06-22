import java.util.*;

class Solution {
        public String solution(String s) {
           
            String[] temp = s.split(" ");
            
            int min =Integer.valueOf(temp[0]);
            int max=Integer.valueOf(temp[0]);
            for(String each : temp){
                if(max<Integer.valueOf(each)){
                    max=Integer.valueOf(each);
                }else if(min>Integer.valueOf(each)){
                    min=Integer.valueOf(each);
                }
                
            }
            
            return min+" "+max;
            }
}