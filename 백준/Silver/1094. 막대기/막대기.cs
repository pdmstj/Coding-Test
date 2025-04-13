using System;

class Program
{
    static void Main()
    {
        int X = int.Parse(Console.ReadLine());
        int count = 0;

        while (X > 0)
        {
            if ((X & 1) == 1) 
                count++;
            X >>= 1; 
        }

        Console.WriteLine(count);
    }
}
