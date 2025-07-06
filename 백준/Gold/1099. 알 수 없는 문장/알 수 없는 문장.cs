using System;
using System.Linq;

class Program
{
    static void Main()
    {
        string sentence = Console.ReadLine();
        int n = int.Parse(Console.ReadLine());
        string[] words = new string[n];
        for (int i = 0; i < n; i++)
            words[i] = Console.ReadLine();

        int len = sentence.Length;
        int INF = int.MaxValue / 2;
        int[] dp = Enumerable.Repeat(INF, len + 1).ToArray();
        dp[0] = 0;

        for (int i = 0; i < len; i++)
        {
            if (dp[i] == INF) continue;
            foreach (var word in words)
            {
                int wlen = word.Length;
                if (i + wlen <= len)
                {
                    string sub = sentence.Substring(i, wlen);
                    if (IsAnagram(sub, word))
                    {
                        int cost = CalcCost(sub, word);
                        if (dp[i + wlen] > dp[i] + cost)
                            dp[i + wlen] = dp[i] + cost;
                    }
                }
            }
        }

        Console.WriteLine(dp[len] == INF ? -1 : dp[len]);
    }

    static bool IsAnagram(string a, string b)
    {
        return a.OrderBy(c => c).SequenceEqual(b.OrderBy(c => c));
    }

    static int CalcCost(string a, string b)
    {
        return a.Zip(b, (x, y) => x == y ? 0 : 1).Sum();
    }
}
