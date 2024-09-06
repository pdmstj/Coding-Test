using System.Collections.Generic;
using System.Linq;

public class Solution {
    public int[] solution(int[] answers) {
        int oneCount = 0;
        int twoCount = 0;
        int threeCount = 0;
        int[] oneArray = { 1, 2, 3, 4, 5 };
        int[] twoArray = { 2, 1, 2, 3, 2, 4, 2, 5 };
        int[] threeArray = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
                
        for (int i = 0; i < answers.Length; ++i)
        {   
            if (oneArray[i % 5] == answers[i])
            {
                ++oneCount;
            }
            
            if (twoArray[i % 8] == answers[i])
            {
                ++twoCount;
            }
            
            
            if (threeArray[i % 10] == answers[i])
            {
                ++threeCount;
            }            
        }
        
        if (oneCount == twoCount && twoCount == threeCount)
        {
            return new int[3] { 1, 2, 3 };
        }
        
        int[] order = new int[3] { 1, 2, 3 };
        int[] value = { oneCount, twoCount, threeCount };
        int max = value[0];
        for (int i = 0; i < 3; ++i)
        {
            if (max > value[i])
            {
                value[i] = 0;
                continue;
            }
            max = value[i];
        }
        
        for (int i = 0; i < 3; ++i)
        {
            value[i] = max == value[i] ? value[i] : 0;
        }
        
        List<int> answer = new List<int>(3);
        for (int i = 0; i < 3; ++i)
        {
            if (value[i] == 0)
            {
                continue;
            }
            answer.Add(order[i]);
        }
        
        return answer.ToArray();
    }
}