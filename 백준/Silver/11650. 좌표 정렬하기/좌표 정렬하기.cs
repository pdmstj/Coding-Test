using System;
using System.Collections.Generic;

class Program
{
    static void Main()
    {
        int n = int.Parse(Console.ReadLine());
        List<(int x, int y)> points = new List<(int x, int y)>();

        for (int i = 0; i < n; i++)
        {
            string[] input = Console.ReadLine().Split();
            int x = int.Parse(input[0]);
            int y = int.Parse(input[1]);
            points.Add((x, y));
        }

        points.Sort((a, b) =>
        {
            if (a.x != b.x)
                return a.x.CompareTo(b.x);
            else
                return a.y.CompareTo(b.y);
        });

        foreach (var point in points)
        {
            Console.WriteLine($"{point.x} {point.y}");
        }
    }
}
