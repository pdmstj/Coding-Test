using System;
using System.Collections.Generic;

public class Solution {
    public List<int> solution(int[] num_list) {
        Array.Sort(num_list); 
        List<int> list = new List<int>(); 
        for(int i = 5; i < num_list.Length; i++) 
        {
            list.Add(num_list[i]);
        }
       
        return list; // list 반환
    }
}