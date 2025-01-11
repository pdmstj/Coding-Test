import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
     
        String[] todayParts = today.split("\\.");
        int todayYear = Integer.parseInt(todayParts[0]);
        int todayMonth = Integer.parseInt(todayParts[1]);
        int todayDay = Integer.parseInt(todayParts[2]);
        
        Map<String, Integer> termMap = new HashMap<>();
        for (String term : terms) {
            String[] parts = term.split(" ");
            termMap.put(parts[0], Integer.parseInt(parts[1]));
        }
        
        List<Integer> expiredList = new ArrayList<>();
        
        // 개인정보 확인
        for (int i = 0; i < privacies.length; i++) {
            String[] privacyParts = privacies[i].split(" ");
            String[] dateParts = privacyParts[0].split("\\.");
            String termType = privacyParts[1];
            
            int year = Integer.parseInt(dateParts[0]);
            int month = Integer.parseInt(dateParts[1]);
            int day = Integer.parseInt(dateParts[2]);
            
            int validMonths = termMap.get(termType);
            month += validMonths;
            while (month > 12) {
                month -= 12;
                year++;
            }
            
            day -= 1;
            if (day == 0) {
                month -= 1;
                day = 28;
            }
            if (month == 0) {
                month = 12;
                year -= 1;
            }
          
            if (!isBeforeOrEqual(todayYear, todayMonth, todayDay, year, month, day)) {
                expiredList.add(i + 1);
            }
        }
        
        return expiredList.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private boolean isBeforeOrEqual(int todayYear, int todayMonth, int todayDay, int targetYear, int targetMonth, int targetDay) {
        if (todayYear < targetYear) return true;
        if (todayYear == targetYear && todayMonth < targetMonth) return true;
        if (todayYear == targetYear && todayMonth == targetMonth && todayDay <= targetDay) return true;
        return false;
    }
}
