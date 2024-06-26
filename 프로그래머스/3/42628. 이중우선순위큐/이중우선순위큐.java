import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public static void main(String[] args){
        String[] operations = {"I 16", "D 1"};
        String[] operations2 = {"I 7", "I 5", "I -5", "D -1"};
    
        int[] result = solution(operations);
        int[] result2 = solution(operations2);
        
        print(result);
        print(result2);
    }
    
    public static int[] solution(String[] operations) {
        PriorityQueue<Integer> pqDesc = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return b - a;
            }
        });
        PriorityQueue<Integer> pqAsc = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return a - b;
            }
        });
        
        for (int i = 0; i < operations.length; i++){
            String[] temp = operations[i].split(" ");
            int num = Integer.parseInt(temp[1]);
            switch (temp[0]){
                case "I":
                    pqAsc.offer(num);
                    pqDesc.offer(num);
                    break;
                case "D":
                    if (!pqAsc.isEmpty()){
                        if (num == -1){
                            int del = pqAsc.poll();
                            pqDesc.remove(del);
                        } else {
                            int del = pqDesc.poll();
                            pqAsc.remove(del);
                        }
                    }
                    break;
            }
        }
        
        if (pqAsc.isEmpty())
            return new int[]{0, 0};
        else
            return new int[]{pqDesc.peek(), pqAsc.peek()};
    }
    
    public static void print(int[] result){
        for (int i = 0; i < result.length; i++)
            System.out.print(result[i] + ", ");
        System.out.println();
    }
}
