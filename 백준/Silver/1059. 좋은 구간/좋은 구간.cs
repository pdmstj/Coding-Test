using System;
using System.Linq;

class Program
{
    static void Main()
    {
        // 첫 번째 입력을 무시
        Console.ReadLine();
        
        // 두 번째 입력: 정수 리스트 S
        int[] S = Console.ReadLine().Split().Select(int.Parse).ToArray();
        
        // 세 번째 입력: 정수 n
        int n = int.Parse(Console.ReadLine());
        
        if (S.Contains(n))
        {
            Console.WriteLine(0);
        }
        else
        {
            // 정수 n을 리스트 S에 추가하고 정렬
            S = S.Append(n).OrderBy(x => x).ToArray();
            int check = Array.IndexOf(S, n);
            
            int count;
            if (check == 0)
            {
                count = (S[1] - S[0]) * S[0] - 1;
            }
            else
            {
                count = (S[check] - S[check - 1]) * (S[check + 1] - S[check]) - 1;
            }
            Console.WriteLine(count);
        }
    }
}