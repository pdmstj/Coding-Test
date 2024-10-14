#include <stdio.h>
#include <stdlib.h>

// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
int solution(const char* message) {
    // 문자열의 길이를 구합니다.
    int length = 0;
    
    // 문자열의 길이를 계산합니다.
    while (message[length] != '\0') {
        length++;
    }
    
    // 각 문자가 2cm를 차지하므로 길이에 2를 곱합니다.
    return length * 2;
}

int main() {
    // 테스트 케이스 1
    const char* message1 = "happy birthday!";
    printf("%d\n", solution(message1)); // 30
    
    // 테스트 케이스 2
    const char* message2 = "I love you~";
    printf("%d\n", solution(message2)); // 22

    return 0;
}
