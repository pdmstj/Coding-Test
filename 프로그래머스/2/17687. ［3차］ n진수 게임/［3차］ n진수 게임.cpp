#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string convertToBase(int number, int base) {
    string result = "";
    string digits = "0123456789ABCDEF";
    if (number == 0) return "0";
    
    while (number > 0) {
        result += digits[number % base];
        number /= base;
    }
    reverse(result.begin(), result.end());
    return result;
}

string solution(int n, int t, int m, int p) {
    string allNumbers = "";
    int currentNumber = 0;
    
    while (allNumbers.length() < t * m) {
        allNumbers += convertToBase(currentNumber, n);
        currentNumber++;
    }

    string answer = "";
    for (int i = 0; i < t; i++) {
        answer += allNumbers[(p - 1) + i * m];
    }

    return answer;
}