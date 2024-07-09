import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String s) {
     int[] answer = new int[2];
      HashMap<String, Integer> map = new HashMap<>();
      int zeroCnt = 0;
      int cnt = 0;
      boolean start = false;

      String[] split = s.split("");
      List<String> list = Arrays.stream(split).collect(Collectors.toList());
      // System.out.println(list);

      if(list.size() != 1) start = true;

      while (start) {
        for(String x : list) {
          map.put(x, map.getOrDefault(x, 0) + 1);
        }
        if(map.containsKey("0")) zeroCnt += map.get("0");
        if(map.containsKey("1")) {
          String value = Integer.toBinaryString(map.get("1"));
          // System.out.println("value = " + value);
          list.clear();
          list = Arrays.stream(value.split("")).collect(Collectors.toList());
          // System.out.println(list);
          if(list.size() == 1) start = false;
        }
        cnt++;
        map = new HashMap<>();
      }
      answer[0] = cnt;
      answer[1] = zeroCnt;

      return answer;
    }
}