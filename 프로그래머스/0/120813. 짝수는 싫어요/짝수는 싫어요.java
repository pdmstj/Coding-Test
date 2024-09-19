import java.util.ArrayList;

class Solution {
    public int[] solution(int n) {
        ArrayList<Integer> arList = new ArrayList<Integer>();

        for(int i=0;i<=n;i++){
            if(i%2 != 0) {
                arList.add(i);
            }
        }
        
        int[] answer = new int[arList.size()];
        int index = 0;
        for(int i : arList){
          answer[index++] = i;
        }

        return answer;
    }
}