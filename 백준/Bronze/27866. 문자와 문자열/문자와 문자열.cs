using System;

public class MainClass {
    public static void Main() {
        string s = Console.ReadLine(); // 입력받은 문자열
        int index = Int32.Parse(Console.ReadLine()) - 1; // 접근할 인덱스 수 형변환        
        Console.WriteLine(s.Substring(index, 1)); // 해당 인덱스의 문자 출력
    }
}