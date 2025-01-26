import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> userMap = new HashMap<>();
        List<String[]> messageList = new ArrayList<>();

        for (String rec : record) {
            String[] parts = rec.split(" ");
            String command = parts[0]; 
            String userId = parts[1];

            if (command.equals("Enter") || command.equals("Change")) {
                String nickname = parts[2];
                userMap.put(userId, nickname);
            }

            if (command.equals("Enter")) {
                messageList.add(new String[] {userId, "님이 들어왔습니다."});
            } else if (command.equals("Leave")) {
                
                messageList.add(new String[] {userId, "님이 나갔습니다."});
            }
        }

        String[] result = new String[messageList.size()];
        int i = 0;
        for (String[] message : messageList) {
            String userId = message[0];
            String action = message[1];
            result[i++] = userMap.get(userId) + action; 
        }

        return result;
    }
}
