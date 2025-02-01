using System;

class Program
{
    static void Main()
    {
        int[] numbers = new int[9];  // 9개의 숫자를 저장할 배열 선언

        for (int i = 0; i < 9; i++)
        {
            numbers[i] = int.Parse(Console.ReadLine());
        }

        int maxValue = numbers[0];  
        int maxIndex = 0;    

        for (int i = 1; i < 9; i++)
        {
            if (numbers[i] > maxValue)
            {
                maxValue = numbers[i];
                maxIndex = i;
            }
        }

        Console.WriteLine(maxValue);
        Console.WriteLine(maxIndex + 1);  // 인덱스는 0부터 시작하므로 1을 더함
    }
}
