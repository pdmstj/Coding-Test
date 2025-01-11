class Solution {
    public int[] solution(String[] park, String[] routes) {
        int height = park.length;
        int width = park[0].length();
        int[] position = new int[2];
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (park[i].charAt(j) == 'S') {
                    position[0] = i;
                    position[1] = j;
                    break;
                }
            }
        }
        
        for (String route : routes) {
            String[] command = route.split(" ");
            String direction = command[0];
            int distance = Integer.parseInt(command[1]);
            
            int newY = position[0];
            int newX = position[1];
            boolean isValid = true;
            
            for (int step = 1; step <= distance; step++) {
                switch (direction) {
                    case "N": newY -= 1; break;
                    case "S": newY += 1; break;
                    case "W": newX -= 1; break;
                    case "E": newX += 1; break;
                }
                
                if (newY < 0 || newY >= height || newX < 0 || newX >= width || park[newY].charAt(newX) == 'X') {
                    isValid = false;
                    break;
                }
            }
          
            if (isValid) {
                position[0] = newY;
                position[1] = newX;
            }
        }
        
        return position;
    }
}
