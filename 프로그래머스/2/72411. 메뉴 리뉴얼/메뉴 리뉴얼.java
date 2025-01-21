import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        List<String> result = new ArrayList<>();

        for (int courseSize : course) {
            Map<String, Integer> combinationCount = new HashMap<>();

            for (String order : orders) {
                char[] chars = order.toCharArray();
                Arrays.sort(chars);
                combination(chars, courseSize, 0, "", combinationCount);
            }
            
            int maxCount = combinationCount.values().stream()
                              .max(Comparator.naturalOrder())
                              .orElse(0);

            if (maxCount >= 2) { 
                for (Map.Entry<String, Integer> entry : combinationCount.entrySet()) {
                    if (entry.getValue() == maxCount) {
                        result.add(entry.getKey());
                    }
                }
            }
        }

        Collections.sort(result);
        return result.toArray(new String[0]);
    }

    private void combination(char[] chars, int courseSize, int start, String current, Map<String, Integer> countMap) {
        if (current.length() == courseSize) {
            countMap.put(current, countMap.getOrDefault(current, 0) + 1);
            return;
        }

        for (int i = start; i < chars.length; i++) {
            combination(chars, courseSize, i + 1, current + chars[i], countMap);
        }
    }
}
