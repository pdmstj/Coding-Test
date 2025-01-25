using System;

class Program
{
    static void Main(string[] args)
    {
        int X = int.Parse(Console.ReadLine());

        int diagonal = 1; 
        int count = 1; 

        // X가 속한 대각선을 찾는 과정
        while (X > count)
        {
            diagonal++;
            count += diagonal;
        }

        // 해당 대각선에서의 위치 계산
        int positionInDiagonal = count - X;

        // 분자와 분모 계산
        int numerator, denominator;
        if (diagonal % 2 == 0) // 대각선 번호가 짝수인 경우
        {
            numerator = diagonal - positionInDiagonal;
            denominator = 1 + positionInDiagonal;
        }
        else // 대각선 번호가 홀수인 경우
        {
            numerator = 1 + positionInDiagonal;
            denominator = diagonal - positionInDiagonal;
        }

        // 결과 출력
        Console.WriteLine($"{numerator}/{denominator}");
    }
}
