using System;
using System.Collections.Generic;

class Solution
{
    public int solution(int[] nums)
    {
        int answer = 0;

        // 3개의 숫자를 고르기 위한 반복문
        for (int i = 0; i < nums.Length - 2; i++)
        {
            for (int j = i + 1; j < nums.Length - 1; j++)
            {
                for (int k = j + 1; k < nums.Length; k++)
                {
                    int sum = nums[i] + nums[j] + nums[k];

                    // 소수인지 확인
                    if (IsPrime(sum))
                    {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

    // 소수 판별 함수
    private bool IsPrime(int number)
    {
        if (number < 2)
        {
            return false;
        }
        for (int i = 2; i <= Math.Sqrt(number); i++)
        {
            if (number % i == 0)
            {
                return false;
            }
        }
        return true;
    }
}
