using System;

class Program
{
    static void Main()
    {
        // 한 줄의 입력을 읽고 공백을 기준으로 문자열 배열로 분할
        string[] s = Console.ReadLine().Split();

        // 세 개의 long 정수를 저장할 배열 선언
        long[] nums = new long[3];

        // 합계를 저장할 변수 초기화
        long total = 0;

        // 문자열 배열의 처음 세 요소를 long 정수로 변환하여 nums 배열에 저장
        for (int i = 0; i < 3; i++)
        {
            nums[i] = long.Parse(s[i]); // 문자열을 long 정수로 변환하여 nums 배열에 저장
            total += nums[i]; // 현재 숫자를 합계에 더함
        }

        // 세 숫자의 합계를 콘솔에 출력
        Console.Write(total);
    }
}
