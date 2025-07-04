using System;
using System.Text;
using System.IO;
using System.Collections.Generic;

class Program
{
    static void Main()
    {
        var sr = new StreamReader(Console.OpenStandardInput());
        var sb = new StringBuilder();

        int n = int.Parse(sr.ReadLine());
        var points = new List<(int x, int y)>();

        for (int i = 0; i < n; i++)
        {
            var input = sr.ReadLine().Split();
            int x = int.Parse(input[0]);
            int y = int.Parse(input[1]);
            points.Add((x, y));
        }

        points.Sort((a, b) =>
        {
            if (a.y == b.y)
                return a.x.CompareTo(b.x);
            return a.y.CompareTo(b.y);
        });

        foreach (var point in points)
        {
            sb.AppendLine($"{point.x} {point.y}");
        }

        Console.Write(sb.ToString());
    }
}
