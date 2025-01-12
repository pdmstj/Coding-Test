import java.util.*;

class Solution {
    public int solution(String dartResult) {
        String[] rounds = dartResult.split("(?=[0-9])(?<![0-9])");
        int[] scores = new int[3];
        int idx = 0;

        for (String round : rounds) {
            int score = 0;
            int len = round.length();

            if (len >= 2 && round.charAt(1) == '0') { 
                score = 10;
                round = round.substring(2); 
            } else {
                score = Character.getNumericValue(round.charAt(0)); 
                round = round.substring(1); 
            }

            char bonus = round.charAt(0); 
            if (bonus == 'S') {
                score = (int) Math.pow(score, 1);
            } else if (bonus == 'D') {
                score = (int) Math.pow(score, 2);
            } else if (bonus == 'T') {
                score = (int) Math.pow(score, 3);
            }

            if (round.length() > 1) { 
                char option = round.charAt(1);
                if (option == '*') {
                    score *= 2;
                    if (idx > 0) { 
                        scores[idx - 1] *= 2;
                    }
                } else if (option == '#') {
                    score *= -1;
                }
            }

            scores[idx++] = score;
        }

        int answer = 0;
        for (int s : scores) {
            answer += s;
        }

        return answer;
    }
}
